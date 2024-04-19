import java.util.*;

public class MessaggioTroppoLungoExceptionDemo {
	private static String lineaInserita;
	private static int lunghezzaLinea;

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti;

		// Ripete se l'utente dice si
		do {
			// Crea un nuovo oggetto di tipo Scanner per evitare problemi
			// di mescolare nextLine con altri metodi.
			try {

				tastiera = new Scanner(System.in);

				System.out.println();
				System.out.println("Inserisci una linea di testo lunga fino a 20 caratteri.");
				lineaInserita = tastiera.nextLine();
				lunghezzaLinea = lineaInserita.length();

				if (lunghezzaLinea > 20) // Usa il messaggio di default
					throw new MessaggioTroppoLungoException();

				System.out.print("Hai inserito " + lunghezzaLinea + " caratteri, " + "che e' numero di caratteri accettabile.");
			}

			catch (MessaggioTroppoLungoException e) {
				System.out.println(e.getMessage());
			}

			System.out.println();
			System.out.println("Ancora? (s per Si)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 's') || (ripeti == 'S'));
	}
}
