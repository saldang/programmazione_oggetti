public class MeseException extends Exception {
	public MeseException() {
		super("alore non corretto per il mese.");
	}

	public MeseException(int numeroMese) {
		super(numeroMese + " non e' valido: i mesi devo essere tra 1 e 12.");
	}

	public MeseException(String messaggio) {
		super(messaggio);
	}
}