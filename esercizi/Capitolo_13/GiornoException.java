public class GiornoException extends Exception {
	public GiornoException() {
		super("Valore non corretto per il giorno.");
	}

	public GiornoException(int numeroMese) {
		super("Hai inserito un numero non valido per il giorno in relazione al mese " + numeroMese);
	}

	public GiornoException(String messaggio) {
		super(messaggio);
	}
}