public class ListaConcatenataDiSpecieAutoContenuta {
	private NodoLista testa;

	public ListaConcatenataDiSpecieAutoContenuta() {
		testa = null;
	}

	/**
	Restituisce il numero di nodi sulla lista.
	*/
	public int lunghezza() {
		int conteggio = 0;
		NodoLista posizione = testa;
		while (posizione != null) {
			conteggio++;
			posizione = posizione.collegamento;
		}
		return conteggio;
	}

	/**
	 * Aggiunge un nodo contenente i dati specie all'inizio della lista.
	 */
	public void aggiungiNodoInTesta(Specie specie) {
		testa = new NodoLista(specie, testa);
	}

	public void eliminaNodoDiTesta() {
		if (testa != null)
			testa = testa.collegamento;
		else {
			System.out.println("Si sta eliminando da una lista vuota.");
			System.exit(0);
		}
	}

	public boolean nellaLista(String elemento) {
		return (trova(elemento) != null);
	}

	/**
	 * Restituisce un riferimento al primo nodo che contiene i dati elemento. 
	 * Se l'elemento non e' nella lista, restituisce null
	 */
	private NodoLista trova(String elemento) {
		NodoLista posizione = testa;		
		String nomeAllaPosizione = null;
		while (posizione != null) {
			nomeAllaPosizione = posizione.dati.getNome();
			if (nomeAllaPosizione.equals(elemento))
				return posizione;
			posizione = posizione.collegamento;
		}
		return null; // L'elemento non e' stato trovato
	}

	public void mostra() {
		NodoLista posizione;
		posizione = testa;
		NodoLista dataAllaPosizione;
		while (posizione != null) {
			System.out.println(posizione.dati);
			posizione = posizione.collegamento;
		}
	}

	

	public Specie[] convertiInArray() {
		Specie a[] = new Specie[lunghezza()];
		NodoLista posizione;
		posizione = testa;
		int i = 0;
		while (posizione != null) {
			a[i] = posizione.dati;
			++i;
			posizione = posizione.collegamento;
		}
		return a;
	}
	
	private class NodoLista {
		private Specie dati;
		private NodoLista collegamento;

		public NodoLista() {
			collegamento = null;
			dati = null;
		}

		public NodoLista(Specie newData, NodoLista linkValue) {
			dati = newData;
			collegamento = linkValue;
		}
	}
}
