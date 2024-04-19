import java.util.*;

public class Palindromo {
	public static final int MAX_CHARS = 80;

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Questo programma verifica se un testo che l'utente ha inserito e' palindromo.");
		System.out.println();
		System.out.println("Inserisci il testo (solo lettere e spazi, grazie).");

		String frase = tastiera.nextLine();
		System.out.println();
		if (frase.length() > MAX_CHARS) { // Troppi caratteri: si termina il programma
			System.out.println();
			System.out.println("Troppi caratteri: il massimo e' 50.");
		} else { // Numero di caratteri adeguato: si inizia la verifica
			if (palindromo(frase))
				System.out.println("SI, la frase e' palindroma!");
			else
				System.out.println("NO, la frase non e' palindroma.");
		}
	}

	public static boolean palindromo(String testo) {
		// Parse: rimuove gli spazi bianchi, salva le lettere in un array, conta il numero di lettere
		// Assunzione: il testo ha solo lettere e spazi bianchi. 
		// Se immessa una stringa vuota o nulla, il metodo restituisce true
		// Per scorrere i caratteri della stringa originale e creare un nuovo array 
		// con le sole lettere e senza spazi bianchi è necessario utilizzare contatori separati.
		
		int conteggioLettere = 0;// Indice del nuovo array con solo lettere.
		int conteggioCaratteri = testo.length(); // Numero di caratteri nella frase
		char[] lettera = new char[MAX_CHARS];
		char unCarattere;

		// i scorre attraverso i caratteri nell'array originale
		for (int i = 0; i < conteggioCaratteri; i++) {
			unCarattere = testo.charAt(i);
			if (!Character.isWhitespace(unCarattere)) {
				lettera[conteggioLettere] = unCarattere;
				conteggioLettere++;
			}
		}

		// Verifica se palindorma:
		// Si inizia con il primo e l'ultimo carattere e si lavora verso l'interno.
		// Se conteggio è dispari, il carattere intermedio può essere ignorato;
		// utilizzando i come variabile di controllo del ciclo, partendo da i = 0
		// e arrivando a i < (troncamento di conteggio/2), si ottiene il numero corretto
		// di confronti per un numero pari o dispari di caratteri.
		// Il carattere alla posizione array[i] si trova ad un'estremità dell'array e
		// il carattere alla posizione [conteggio - 1 - i] si trova all'altro capo, e
		// ogni incremento di i ottiene la prossima coppia di caratteri che dovrebbero
		// essere ugiali se la stringa e' palindroma

		boolean risultato = true;
		for (int i = 0; i < conteggioLettere / 2; i++) {
			if (Character.toUpperCase(lettera[i]) != Character.toUpperCase(lettera[conteggioLettere - 1 - i])) {
				risultato = false;
			}
		}
		return (risultato);
	}
}
