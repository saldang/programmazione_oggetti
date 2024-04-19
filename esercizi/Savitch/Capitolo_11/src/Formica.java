public class Formica extends Organismo {
	public static final int FORMICA_RIPRODUZIONE = 3; // Numero di turni prima che la formica si riproduca

	public Formica() {
		super();
	}

	public Formica(Mondo world, int x, int y) {
		super(world, x, y);
	}

	/**
	 * Crea una nuova larva adiacente alla cella corrente se numeroTurniUltimoPasto
	 * è uguale FORMICA_RIPRODOTTA.
	 */
	public void riproduci() {
		numeroTurniAffamato++;
		if (numeroTurniAffamato == FORMICA_RIPRODUZIONE) {
			numeroTurniAffamato = 0;
			// Cerca di craere una nuova formica sopra, sinistra, destra o sotto
			if ((y > 0) && (mondo.getAllaCella(x, y - 1) == null)) {
				new Formica(mondo, x, y - 1);
			} else if ((y < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x, y + 1) == null)) {
				new Formica(mondo, x, y + 1);
			} else if ((x > 0) && (mondo.getAllaCella(x - 1, y) == null)) {
				new Formica(mondo, x - 1, y);
			} else if ((x < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x + 1, y) == null)) {
				new Formica(mondo, x + 1, y);
			}
		}
	}

	/**
	 * Si sposta su una cella vuota
	 */
	public void sposta() {
		// Selezione random della direzione in cui muoversi
		int dir = (int) (Math.random() * 4);
		// Cerca di muoversi verso l'alto se non è un bordo o se nonè vuota
		if (dir == 0) {
			if ((y > 0) && (mondo.getAllaCella(x, y - 1) == null)) {
				mondo.setAt(x, y - 1, mondo.getAllaCella(x, y)); // Move to new spot
				mondo.setAt(x, y, null);
				y--;
			}
		}
		// Cerca di muoversi verso il basso
		else if (dir == 1) {
			if ((y < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x, y + 1) == null)) {
				mondo.setAt(x, y + 1, mondo.getAllaCella(x, y)); // Si sposta
				mondo.setAt(x, y, null); // Imposta la cella a vuota
				y++;
			}
		}
		// Cerca di muoversi verso sinistra
		else if (dir == 2) {
			if ((x > 0) && (mondo.getAllaCella(x - 1, y) == null)) {
				mondo.setAt(x - 1, y, mondo.getAllaCella(x, y)); // Si sposta
				mondo.setAt(x, y, null); // Imposta la cella a vuota
				x--;
			}
		}
		// Cerca di muoversi verso destra
		else {
			if ((x < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x + 1, y) == null)) {
				mondo.setAt(x + 1, y, mondo.getAllaCella(x, y)); // Si sposta
				mondo.setAt(x, y, null); // Imposta la cella a vuota
				x++;
			}
		}
	}

	/**
	 * Restituisce false poiche' una formica non è mai affamata
	 */
	public boolean affammato() {
		return false;
	}

	/**
	 * Una formica e' rappresentata da "o"
	 */
	public String getTipo() {
		return "o";
	}
}