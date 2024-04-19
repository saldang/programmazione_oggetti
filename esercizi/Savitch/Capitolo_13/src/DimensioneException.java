public class DimensioneException extends Exception {
	public DimensioneException() {
		super("Dimensione non valida: deve essere maggiore di 0.");
	}

	public DimensioneException(String dimensione, int valore) {
		super(valore + " non e' valido per " + dimensione + ": deve essere maggiore di 0.");
	}

	public DimensioneException(String messaggio) {
		super(messaggio);
	}
}