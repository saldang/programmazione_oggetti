public class Documento {
	private String testo;

	/**
	 * Costruttore di default. Inizializza testo a blank
	 */
	public Documento() {
		testo = "";
	}

	/**
	 * Inizializza testo al valore passato in ingresso
	 * @param testo Il tetso
	 */
	public Documento(String testo) {
		this.testo = testo;
	}

	/**
	 * Restituisce una stringa con il contenuto del documento
	 */
	public String toString() {
		return testo;
	}
}