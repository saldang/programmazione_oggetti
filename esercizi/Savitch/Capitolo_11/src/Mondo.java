/**
 * La classe Mondo memorizza i dati sul mondo creando un array 
 * DIMENSIONE_MONDO per DIMENSIONE_MONDO di tipo Organismo. 
 * null indica una cella vuota, altrimenti reference ad un oggetto 
 * indica una formica o larva. Per determinare quale, invocare il
 * metodo astratto getTipo di Organismo che dovrebbe restituire 
 * o se la classe è di tipo Formica, e x altrimenti.
 */
public class Mondo {
	public static final int DIMENSIONE_MONDO = 20;
	private Organismo[][] griglia; // Array di organismi per ogni cella

	/**
	 * Inizializza il mondo ad una griglia vuota
	 */
	public Mondo() {
		griglia = new Organismo[DIMENSIONE_MONDO][DIMENSIONE_MONDO];
		
	}

	/**
	 * Restituisce l'organismo alla posizone specificata
	 * 
	 * @param x La coordinata x
	 * @param y La coordinata y
	 */
	public Organismo getAllaCella(int x, int y) {
		if ((x >= 0) && (x < Mondo.DIMENSIONE_MONDO) && 
				(y >= 0) && (y < Mondo.DIMENSIONE_MONDO))
			return griglia[x][y];
		return null;
	}

	/**
	 * Inserisce l'orgaismo specificato alla posizone specificata
	 * 
	 * @param x La coordinata x
	 * @param y La coordinata y
	 * @param orgamismo L'organismo da inserire
	 */
	public void setAt(int x, int y, Organismo organismo) {
		if ((x >= 0) && (x < Mondo.DIMENSIONE_MONDO) && 
				(y >= 0) && (y < Mondo.DIMENSIONE_MONDO)) {
			griglia[x][y] = organismo;
		}
	}

	/**
	 * Visualizza il mondo in testo ASCII
	 */
	public void visualizza() {
		int i, j;
		System.out.println();
		System.out.println();
		for (j = 0; j < Mondo.DIMENSIONE_MONDO; j++) {
			for (i = 0; i < Mondo.DIMENSIONE_MONDO; i++) {
				if (griglia[i][j] == null)
					System.out.print(".");
				else
					System.out.print(griglia[i][j].getTipo());
				// x per larva, o per formica
			}
			System.out.println();
		}
	}

	/**
	 * Questo è il metodo principale che simula uno step nel mondo. 
	 * In primo luogo, per ogni organismo viene utilizzato un flag per indicare se si è spostato.
	 * Questo perché si itera attraverso la griglia partendo dall'alto in cerca 
	 * di un organismo da muovere. Se un organismo si è mosso verso il basso, non vogliamo muoverlo 
	 * di nuovo quando lo si raggiunge. 
	 * Prima si muovono le larve, poi formiche, e se sono ancora vivi poi li nutriamo. 
	 */
	public void simulaUnoStep() {
		int i, j;
		// Impostiamo tutti gli organismi a non mossi
		for (i = 0; i < Mondo.DIMENSIONE_MONDO; i++)
			for (j = 0; j < Mondo.DIMENSIONE_MONDO; j++) {
				if (griglia[i][j] != null)
					griglia[i][j].setMosso(false);
			}
		// Cerchiamo nelle celle in ordine e se e' una larva, la muoviamo
		for (i = 0; i < Mondo.DIMENSIONE_MONDO; i++)
			for (j = 0; j < Mondo.DIMENSIONE_MONDO; j++) {
				if ((griglia[i][j] != null) && (griglia[i][j] instanceof Larva)) {
					if (griglia[i][j].getMosso() == false) {
						griglia[i][j].setMosso(true); // Si marca come mossa
						griglia[i][j].sposta();
					}
				}
			}
		// Cerchiamo nelle celle in ordine e se e' una formica, la muoviamo
		for (i = 0; i < Mondo.DIMENSIONE_MONDO; i++)
			for (j = 0; j < Mondo.DIMENSIONE_MONDO; j++) {
				if ((griglia[i][j] != null) && (griglia[i][j] instanceof Formica)) {
					if (griglia[i][j].getMosso() == false) {
						griglia[i][j].setMosso(true); // Si marca come mossa
						griglia[i][j].sposta();
					}
				}
			}
		// Cerchiamo nelle celle in ordine se c'e' qualche organismo affamato
		for (i = 0; i < Mondo.DIMENSIONE_MONDO; i++)
			for (j = 0; j < Mondo.DIMENSIONE_MONDO; j++) {
				// Elimina tutte le larve che non hanno mangiato recentemente
				if ((griglia[i][j] != null) && (griglia[i][j] instanceof Larva)) {
					if (griglia[i][j].affammato()) {
						griglia[i][j] = null;
					}
				}
			}
		// Cerchiamo nelle celle in ordine se c'e' qualche organismo da riprodurre
		for (i = 0; i < Mondo.DIMENSIONE_MONDO; i++)
			for (j = 0; j < Mondo.DIMENSIONE_MONDO; j++) {
				// Vengono riprodotti solo gli organismi che si sono mossi poiche'
				// la riproduzione pone nuovi organismi sulla mappa e questi non devono essere riprodotti
				if ((griglia[i][j] != null) && (griglia[i][j].getMosso())) {
					griglia[i][j].riproduci();
				}
			}
	}
}