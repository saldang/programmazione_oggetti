public class Quadrato extends FormaDisegnabile {
	private int lunghezzaLato;

	public Quadrato(int lunghezzaLato) {
		super(0, 0, "Nero");
		setLunghezzaLato(lunghezzaLato);
	}

	public int getLunghezzaLato() {
		return lunghezzaLato;
	}

	public void setLunghezzaLato(int lunghezzaLato) {
		this.lunghezzaLato = lunghezzaLato;
	}

	public void disegna() {
		int xSinistra = getX() - lunghezzaLato / 2;
		int yTop = getY() - lunghezzaLato / 2;

		for (int i = 1; i < yTop; i++) {
			System.out.println();
		}

		String offset = "";
		for (int j = 1; j < xSinistra; j++) {
			offset = offset + " ";
		}

		String top = offset;
		for (int j = 0; j < lunghezzaLato; j++) {
			top = top + "*";
		}

		System.out.println(top);

		String side = offset + "*";
		for (int j = 0; j < lunghezzaLato - 2; j++) {
			side = side + " ";
		}
		side = side + "*";

		for (int i = 0; i < lunghezzaLato - 2; i++) {
			System.out.println(side);
		}

		System.out.println(top);
	}

	
	
	public static void main(String[] args) {
		Quadrato sq = new Quadrato(5);
		sq.muovi(7, 7);

		sq.disegna();
	}

}
