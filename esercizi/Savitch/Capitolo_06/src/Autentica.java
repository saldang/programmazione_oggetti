import java.util.Scanner;

public class Autentica {
	public static void main(String[] args) {
		// La password attuale è 99508
		int[] passwordAttuale = { 9, 9, 5, 0, 8 };
		// Array per contenere le cifre generate random
		int[] cifreRandom = new int[10];
		// Array per contenere le cifre immesse dall'utente per autenticarsi
		int[] passwordUtente = new int[passwordAttuale.length];

		// Genera in modo casuale numeri nel range 1-3 per ogni cifra
		for (int i = 0; i < 10; i++) {
			cifreRandom[i] = (int) (Math.random() * 3) + 1;
		}

		// Output the challenge
		System.out.println("Benvenuto!  Per loggarti, inserisci i numeri random da 1-3 che");
		System.out.println("corrispondono al tuo PIN.");
		System.out.println();
		System.out.println("PIN digit: 0 1 2 3 4 5 6 7 8 9");
		System.out.print("Random #:  ");
		for (int i = 0; i < 10; i++) {
			System.out.print(cifreRandom[i] + " ");
		}
		System.out.println();
		System.out.println();

		// Input dell'utente
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il codice.");
		String s = tastiera.next();
		// Estrae le cifre del codice e le memorizza nell'array passwordUtente
		for (int i = 0; i < s.length(); i++) {
			passwordUtente[i] = s.charAt(i) - '0'; // Converte il carattere nella cifra corrispondente
		}
		// Ad esempio, se l'utente ha immesso al stringa 12443, allora
		// passwordUtente[0] = 1, passwordUtente[1] = 2, passwordUtente[2] = 4,
		// passwordUtente[3] = 4, e passwordUtente[4] = 3

		if (valida(passwordAttuale, passwordUtente, cifreRandom)) {
			System.out.println("Corretta!  Puoi procedere.");
		} else {
			System.out.println("Errore, password non valida.");
		}
	}

	/****
	 * Restituisce true se viene inserita unapassword valida. False in caso contrario.
	 * 
	 * Ad esempio, se: attuale = {9,9,5,0,8} numeriRandom = {1,2,3,1,2,3,1,2,3,1}
	 * 
	 * quanto segue restituisce true 
	 * se: inserita[0] == 1 (attuale[0] = 9 -> numeriRandom[9] ->
	 * 1) inserita[1] == 1 (attuale[1] = 9 -> numeriRandom[9] -> 1) inserita[2] == 3
	 * (attuale[2] = 5 -> numeriRandom[5] -> 3) inserita[3] == 1 (attuale[3] = 0 ->
	 * numeriRandom[0] -> 1) inserita[4] == 3 (attuale[4] = 8 -> numeriRandom[8] -> 3)
	 * 
	 * o, in altre parole, il metodo restituisce false se una delle comdizioni sopra non è vera.
	 ****/
	public static boolean valida(int[] attuale, int[] inserita, int[] numeriRandom) {
		for (int i = 0; i < attuale.length; i++) {
			if (numeriRandom[attuale[i]] != inserita[i])
				return false;
		}
		return true;
	}

}