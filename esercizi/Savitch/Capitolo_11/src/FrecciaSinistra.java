public class FrecciaSinistra extends FormaBase {
	private int lunghezzaCoda; //tail;
	private int larghezzaPunta; //base

	public FrecciaSinistra() {
		super();
		setLunghezzaCoda(0);
		setLarghezzaPunta(3);
	}

	public FrecciaSinistra(int scostamento, int lunghezzaCoda, int larghezzaPunta) {
		super(scostamento);
		setLunghezzaCoda(lunghezzaCoda);
		setLarghezzaPunta(larghezzaPunta);
	}

	public FrecciaSinistra(int lunghezzaCoda, int larghezzaPunta) {
		super();
		setLunghezzaCoda(lunghezzaCoda);
		setLarghezzaPunta(larghezzaPunta);
	}

	/**
	 * Metodo per cambiare tutti gli attributi
	 */
	public void set(int scostamento, int lunghezzaCoda, int larghezzaPunta) {
		setScostamento(scostamento);
		setLunghezzaCoda(lunghezzaCoda);
		setLarghezzaPunta(larghezzaPunta);		
	}

	/**
	 * Metodo per cambiare la lunghezza della coda della freccia.
	 */
	public void setLunghezzaCoda(int lunghezzaCoda) {
		this.lunghezzaCoda = lunghezzaCoda;
	}

	/**
	 * Metodo per cambiare la dimensione della base della freccia.
	 */
	public void setLarghezzaPunta(int newBase) {
		if (larghezzaPunta < 3) {
			this.larghezzaPunta = 3;
		} else if (larghezzaPunta % 2 == 0) { 
			this.larghezzaPunta = larghezzaPunta + 1; // Aggiunge 1 per farla dispari			
		} else
			this.larghezzaPunta = larghezzaPunta;		
	}

	@Override
	public String toString() {
		return "FrecciaSinistra [lunghezzaCoda=" + lunghezzaCoda + ", larghezzaPunta=" + larghezzaPunta
				+ ", getScostamento()=" + getScostamento() + "]";
	}

	public int getLunghezzaCoda() {
		return lunghezzaCoda;
	}

	public int getLarghezzaPunta() {
		return larghezzaPunta;
	}

	public void disegnaQui() {
		disegnaTop();
		disegnaCoda();
		disegnaBottom();
	}

	public void disegnaTop() {
		int linecount = getLarghezzaPunta() / 2;
		int numberOfSpaces = getScostamento() + linecount * 2;
		numeroSpazi(numberOfSpaces);
		System.out.println("*");
		int count;
		int insideWidth = 1;
		for (count = 1; count < linecount; ++count) {
			numberOfSpaces = numberOfSpaces - 2;
			numeroSpazi(numberOfSpaces);
			System.out.print("*");
			numeroSpazi(insideWidth);
			System.out.println("*");
			insideWidth = insideWidth + 2;
		}
	}

	public void disegnaCoda() {
		numeroSpazi(getScostamento());
		System.out.print("*");
		int insideWidth = (int) (getLarghezzaPunta() / 2) * 2 - 1;
		numeroSpazi(insideWidth);
		int count;
		for (count = 0; count <= lunghezzaCoda; ++count)
			System.out.print("*");
		System.out.println();
	}

	public void disegnaBottom() {
		int startOfLine = getScostamento() + 2;
		int count;
		int linecount = getLarghezzaPunta() / 2;
		int insideWidth = (linecount - 1) * 2 - 1;
		for (count = 1; count < linecount; ++count) {
			numeroSpazi(startOfLine);
			System.out.print("*");
			numeroSpazi(insideWidth);
			System.out.println("*");
			startOfLine = startOfLine + 2;
			insideWidth = insideWidth - 2;
		}
		numeroSpazi(startOfLine);
		System.out.println("*");
	}

	public static void numeroSpazi(int numero) {
		int count;
		for (count = 0; count < numero; ++count)
			System.out.print(' ');
	}
}