public class Rettangolo extends FormaBase {
	private int altezza;
	private int base;

	public Rettangolo() {
		super();
		altezza = 0;
		base = 0;
	}

	public Rettangolo(int scostamento, int altezza, int base) {
		super(scostamento);
		this.altezza = altezza;
		this.base = base;
	}

	public void reset(int scostamento, int altezza, int base) {
		setScostamento(scostamento);
		this.altezza = altezza;
		this.base = base;
	}

	public void disegnaQui() {
		disegnaLineaOrrizzontale();
		if (altezza > 2)
			disegnaLineeVerticali();
		if (altezza > 1)
			disegnaLineaOrrizzontale();
	}

	private void disegnaLineaOrrizzontale() {
		numeroSpazi(getScostamento());
		int count;
		for (count = 0; count < base; ++count)
			System.out.print('-');
		System.out.println();
	}

	private void disegnaLineeVerticali() {
		int count;
		for (count = 0; count < (altezza - 2); ++count)
			disegnaLineaVerticale();
	}

	private void disegnaLineaVerticale() {
		numeroSpazi(getScostamento());
		System.out.print('|');
		if (base > 1) {
			numeroSpazi(base - 2);
			System.out.println('|');
		}
	}

	private static void numeroSpazi(int number) {
		int count;
		for (count = 0; count < number; ++count)
			System.out.print(' ');
	}

	public int area() {
		return (altezza * base);
	}

	public int perimetro() {
		return (2 * altezza + 2 * base);
	}
}