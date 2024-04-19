
public class OpSconosciutaException extends Exception {

	public OpSconosciutaException() {
		super("OpSconosciutaException");
	}

	public OpSconosciutaException(char op) {
		super(op + " e' un operatore sconosciuto.");
	}

	public OpSconosciutaException(String messaggio) {
		super(messaggio);
	}
}

