import java.util.*;

public class ChiediOAfferma {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		String frase;
		int lunghezzaFrase;
		char ultimoCarattere;

		System.out.println("Inserisci un'affermazione o una domanda.");

		frase = tastiera.nextLine();
		lunghezzaFrase = frase.length();
		ultimoCarattere = frase.charAt(lunghezzaFrase - 1);
		// l'ultimo carattere e' alla posizione (length - 1)

		switch (ultimoCarattere) {
			case '?':
				if (lunghezzaFrase % 2 == 0) // numero pari di caratteri
					System.out.println("Si");
				else
					System.out.println("No"); // se non e' pari e' dispari
				break;

			case '!':
				System.out.println("Wow");
				break;

			default:
				System.out.println("Dici sempre \"" + frase + "\"");
		}
	}
}
