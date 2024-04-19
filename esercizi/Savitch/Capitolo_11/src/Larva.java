public class Larva extends Organismo {
	public static final int LARVA_RIPRODUZIONE = 8; // Numero di turni prima che la larva si riproduca
	public static final int LARVA_AFFAMATA = 3; // Numero di turni prima che la larva diventi affamata

	private int numeroTurniUltimoPasto; // Numero di turrni dalla ultimo pasto

	public Larva() {
		super();
		numeroTurniUltimoPasto = 0;
	}

	public Larva(Mondo mondo, int x, int y) {
		super(mondo, x, y);
		numeroTurniUltimoPasto = 0;
	}

	/**
	 * Crea una nuova larva adiacente alla cella corrente se numeroTurniUltimoPasto
	 * è uguale LARVA_RIPRODUZIONE.
	 */
	public void riproduci() {
		numeroTurniAffamato++;
		if (numeroTurniAffamato == LARVA_RIPRODUZIONE) {
			numeroTurniAffamato = 0;
			// Cerca di craere una nuova larva sopra, sinistra, destra o sotto
			if ((y > 0) && (mondo.getAllaCella(x, y - 1) == null)) {
				Larva nuovaLarva = new Larva(mondo, x, y - 1);
			} else if ((y < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x, y + 1) == null)) {
				Larva nuovaLarva = new Larva(mondo, x, y + 1);
			} else if ((x > 0) && (mondo.getAllaCella(x - 1, y) == null)) {
				Larva nuovaLarva = new Larva(mondo, x - 1, y);
			} else if ((x < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x + 1, y) == null)) {
				Larva nuovaLarva = new Larva(mondo, x + 1, y);
			}
		}
	}

	/**
	 * Cerca sopra, sotto, a sinistra e destra un posto in cui c'e' una formica. 
	 * Se viene trovato, si muove e la mangia, resettando numeroTurniUltimoPasto
	 * counter.
	 */
	public void sposta() {
		// Cerca in ogni direzione e se viene trovata una formica, si sposta e la mangia
		if ((y > 0) && (mondo.getAllaCella(x, y - 1) != null) && (mondo.getAllaCella(x, y - 1) instanceof Formica)) {
			mondo.setAt(x, y - 1, this); // Si muove
			mondo.setAt(x, y, null);
			numeroTurniUltimoPasto = 0; // Resetta il numero turni affamato
			y--;
			return;
		} else if ((y < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x, y + 1) != null)
				&& (mondo.getAllaCella(x, y + 1) instanceof Formica)) {
			mondo.setAt(x, y + 1, this); // Si muove
			mondo.setAt(x, y, null);
			numeroTurniUltimoPasto = 0; // Resetta il numero turni affamato
			y++;
			return;
		} else if ((x > 0) && (mondo.getAllaCella(x - 1, y) != null)
				&& (mondo.getAllaCella(x - 1, y) instanceof Formica)) {
			mondo.setAt(x - 1, y, this); // Si muove
			mondo.setAt(x, y, null);
			numeroTurniUltimoPasto = 0; // Resetta il numero turni affamato
			x--;
			return;
		} else if ((x < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x + 1, y) != null)
				&& (mondo.getAllaCella(x + 1, y) instanceof Formica)) {
			mondo.setAt(x + 1, y, this); // Si muove
			mondo.setAt(x, y, null);
			numeroTurniUltimoPasto = 0; // Resetta il numero turni affamato
			x++;
			return;
		}

		// Se si arriva qui, la larva non ha trovato cibo. 
		// Selezione random della direzione in cui muoversi per cercarlo
		int dir = (int) (Math.random() * 4);
		// Cerca di muoversi verso l'alto se non è un bordo o se non è vuota 
		if (dir == 0) {
			if ((y > 0) && (mondo.getAllaCella(x, y - 1) == null)) {
				mondo.setAt(x, y - 1, mondo.getAllaCella(x, y)); // Si muove
				mondo.setAt(x, y, null);
				y--;
			}
		}
		// Cerca di muoversi verso il basso
		else if (dir == 1) {
			if ((y < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x, y + 1) == null)) {
				mondo.setAt(x, y + 1, mondo.getAllaCella(x, y)); // Si muove
				mondo.setAt(x, y, null); // Imposta la cella a vuota
				y++;
			}
		}
		// Cerca di muoversi verso sinistra
		else if (dir == 2) {
			if ((x > 0) && (mondo.getAllaCella(x - 1, y) == null)) {
				mondo.setAt(x - 1, y, mondo.getAllaCella(x, y)); // Si muove
				mondo.setAt(x, y, null); // Imposta la cella a vuota
				x--;
			}
		}
		// Cerca di muoversi verso destra
		else {
			if ((x < Mondo.DIMENSIONE_MONDO - 1) && (mondo.getAllaCella(x + 1, y) == null)) {
				mondo.setAt(x + 1, y, mondo.getAllaCella(x, y)); // Si muove
				mondo.setAt(x, y, null); // Imposta la cella a vuota
				x++;
			}
		}
		numeroTurniUltimoPasto++; // incremento poiche' non ha mangiato
	}

	/**
	 * Indica se la larva è affamata o meno
	 */
	public boolean affammato() {
		// Muore di fame se non mangia entro LARVA_AFFAMATA turni
		if (numeroTurniUltimoPasto > LARVA_AFFAMATA) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Una larva e' rappresentata da "x"
	 */
	public String getTipo() {
		return "x";
	}
}