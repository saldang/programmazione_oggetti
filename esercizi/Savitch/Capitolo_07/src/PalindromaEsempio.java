
/**
 File name: PalindromeTestDemo.java

 A class to demonstrate a recursive algorithm to determine if a
 string is a palindrome. Blank spaces and case are ignored.

 Written by: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 10/14/2000
 Changes: 04/19/2003 Made comments like text examples.
 Updated for fourth edition by Brian Durney, January 2005.
 */
import java.util.*;

public class PalindromaEsempio {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		String ignora;
		char risposta = 's';
		while (risposta == 's' || risposta == 'S') {
			System.out.println("Inserisci una frase");
			String frase = tastiera.nextLine();
			System.out.println("");
			if (verificaPalindroma(frase))
				System.out.println("La frase e' palindroma");
			else
				System.out.println("La frase NON e' palindrom");
			System.out.println("");
			System.out.println("Vuoi inserire un'altra frase? (s/S)");
			risposta = tastiera.next().charAt(0);
			// Elimina la nuova riga rimasta inutilizzata da un precedente utilizzo della tastiera..
			ignora = tastiera.nextLine();
		}
	}

	public static boolean verificaPalindroma(String s) {
		// Rimuove gli spazi e la punteggiatura e rende tutto maiscolo
		String lettera = "";
		char unCarattere;
		for (int i = 0; i < s.length(); ++i) {
			unCarattere = Character.toUpperCase(s.charAt(i));
			if ((int) unCarattere >= (int) 'A' && (int) unCarattere <= (int) 'Z') {
				lettera = lettera + unCarattere;
			}
		}
		if (lettera.length() <= 1)
			return true; // Caso triviale di 0 o una lettera
		else {
			// La frase ha due o piu' lettere:
			// Compara le lettere alle posizioni iniziale e finale.
			// Se sono diverse, restituisce false, ma se
			// sono uguali e le lettere rimanenti sono palindorme, allora restituisce true.
			// temp è una sottostringa che contiene le lettere della stringa originale
			// tranne la prima e l'ultima

			String temp = lettera.substring(1, lettera.length() - 1);
			return ((lettera.charAt(0) == lettera.charAt(lettera.length() - 1)) && verificaPalindroma(temp));
		}
	}
}
