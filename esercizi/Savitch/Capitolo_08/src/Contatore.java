public class Contatore {
	private int valore;

	/**
	 * Imposta il contatore a zero
	 */
	public void setZero() {
		valore = 0;
	}

	/**
	 * Incrementa il contatore di una unità
	 */
	public void incrementa() {
		valore++;
	}

	/**
	 * Decrementa valore di una unità, ma non va sotto lo zero
	 */
	public void decrementa() {
		if (valore > 0)
			valore--;
	}

	/**
	 * Returns the counter's value.
	 */
	public int getValore() {
		return valore;
	}

	/**
	 * Mostra a video il valoDisplays the counter's value.
	 */
	public void stampaContatore() {
		System.out.println("Contatore vale = " + valore);
	}
}