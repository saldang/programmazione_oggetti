public class TriangoloRettangolo extends FormaBase {
	private int base;

	public TriangoloRettangolo() {
		super();
		base = 0;
	}

	public TriangoloRettangolo(int scostamento, int base) {
		super(scostamento);
		this.base = base;
	}

	public void reset(int scostamento, int base) {
		setScostamento(scostamento);
		this.base = base;
	}

	public void disegnaQui() {
		disegnaTop();
		if (base > 1)
			disegnaBase();
	}

	private void disegnaBase() {
		numeroSpazi(getScostamento());
		int count;
		for (count = 0; count < base; ++count)
			System.out.print('*');
		System.out.println();
	}

	private void disegnaTop() {
		if (base > 0) {
			numeroSpazi(getScostamento());
			System.out.println("*");
		}

		for (int numeroLinea = 2; numeroLinea < base; ++numeroLinea) {
			numeroSpazi(getScostamento());
			System.out.print("*");

			for (int i = 1; i <= numeroLinea - 2; ++i)
				System.out.print(" ");
			System.out.println("*");
		}
	}

	private static void numeroSpazi(int numero) {
		int count;
		for (count = 0; count < numero; ++count)
			System.out.print(' ');
	}

	/**
	 * Methods to calculate area and circumference.
	 */
	public double area() {
		return (0.5 * base * base);
	}

	public double circumference() {
		return (2 * base + base * Math.sqrt(2));
	}
}