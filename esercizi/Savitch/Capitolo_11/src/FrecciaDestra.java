public class FrecciaDestra extends FormaBase {
	private int lunghezzaCoda; //tail
	private int larghezzaPunta; //base

	public FrecciaDestra() {
		super();
		setLunghezzaCoda(0);
		setLarghezzaPunta(3);
	}

	public FrecciaDestra(int scostamento, int lunghezzaCoda, int larghezzaPunta) {
		super(scostamento);
		setLunghezzaCoda(lunghezzaCoda);
		setLarghezzaPunta(larghezzaPunta);
	}
	
	public FrecciaDestra(int lunghezzaCoda, int larghezzaPunta) {
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
	public void setLarghezzaPunta(int larghezzaPunta) {
		if (larghezzaPunta < 3) {
			this.larghezzaPunta = 3;
		} else if (larghezzaPunta % 2 == 0) { 
			this.larghezzaPunta = larghezzaPunta + 1; // Aggiunge 1 per farla dispari			
		} else
			this.larghezzaPunta = larghezzaPunta;
	}

	@Override
	public String toString() {
		return "FrecciaDestra [lunghezzaCoda=" + lunghezzaCoda + ", larghezzaPunta=" + larghezzaPunta
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
		int startOfLine = getScostamento() + getLunghezzaCoda();
		numeroSpazi(startOfLine);
		System.out.println("*");
		int count;
		int linecount = getLarghezzaPunta() / 2 - 1;
		int insideWidth = 1;
		for (count = 0; count < linecount; ++count) {
			numeroSpazi(startOfLine);
			System.out.print("*");
			numeroSpazi(insideWidth);
			System.out.println("*");
			insideWidth = insideWidth + 2;
		}
	}

	public void disegnaCoda() {
		numeroSpazi(getScostamento());
		int count;
		for (count = 0; count <= lunghezzaCoda; ++count)
			System.out.print("*");
		int insideWidth = (getLarghezzaPunta() / 2 - 1) * 2 + 1;
		numeroSpazi(insideWidth);
		System.out.println("*");
	}

	public void disegnaBottom() {
		int startOfLine = getScostamento() + getLunghezzaCoda();
		int count;
		int linecount = getLarghezzaPunta() / 2 - 1;
		int insideWidth = (getLarghezzaPunta() / 2 - 1) * 2 - 1;
		for (count = 0; count < linecount; ++count) {
			numeroSpazi(startOfLine);
			System.out.print("*");
			numeroSpazi(insideWidth);
			System.out.println("*");
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