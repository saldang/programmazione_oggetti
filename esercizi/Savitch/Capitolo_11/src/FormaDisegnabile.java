public abstract class FormaDisegnabile {
	private int x;
	private int y;
	private String colore;

	public FormaDisegnabile(int x, int y, String colore) {
		this.x = x;
		this.y = y;
		this.colore = colore;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getColor() {
		return colore;
	}

	public void muovi(int incrementoX, int incrementoY) {
		x += incrementoX;
		y += incrementoY;
	}

	// Il metodo deve essere definito nelle sotto classi
	public abstract void disegna();
}
