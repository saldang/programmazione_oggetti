
public class MessaggioTroppoLungoException extends Exception {
	public MessaggioTroppoLungoException() {
		super("Messaggio troppo lungo!");
	}

	public MessaggioTroppoLungoException(String message) {
		super(message);
	}
}