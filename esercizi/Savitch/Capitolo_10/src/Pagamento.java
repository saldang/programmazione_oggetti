public class Pagamento {
	private double ammontare;

	/**
	 * Costruttore di default. Inizializza ammontare a 0.
	 */
	public Pagamento() {
		this(0);
	}

	/**
	 * Inizializza ammontare al valore passato in ingresso
	 * @param ammontare Il valore per ammontare
	 */
	public Pagamento(double ammontare) {
		setAmmontare(ammontare);
	}

	// ======================
	// Metodi di set e get
	// ======================
	public void setAmmontare(double ammontare) {
		this.ammontare = ammontare;
	}

	public double getAmmontare() {
		return ammontare;
	}

	/**
	 * Stampa i dettagli del pagamento
	 */
	public void dettagliPagamento() {
		System.out.println("L'ammontare del pagamento e' " + ammontare);
	}
}