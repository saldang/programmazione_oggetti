import java.util.Scanner;

public class Metodi {

	// Esercizio 3
	public static long contaDispari(long numero) {
		long riultato;
		if (numero == 0)
			// caso base
			riultato = 0;
		else {
			long cifra = numero % 10;
			if (cifra < 0)
				cifra = -1 * cifra;
			if (cifra % 2 == 1)
				riultato = contaDispari(numero / 10) + 1;
			else
				riultato = contaDispari(numero / 10);
		}

		return riultato;
	}

	// Esercizio 4
	public static long sommaCifre(long numero) {
		long risultato;
		if (numero == 0)
			// caso base
			risultato = 0;
		else {
			long cifra = numero % 10;
			if (cifra < 0)
				cifra = -1 * cifra;
			risultato = cifra + sommaCifre(numero / 10);
		}

		return risultato;
	}

	// Esercizio 5
	/**
	 * Precondizone: n >= 0. 
	 * Restituisce 10 elevato alla potenza n.
	 */
	public static int calcolaDieciAlla(int n) {
		int risultato;

		if (n == 0) {
			risultato = 1;
		} else {
			risultato = calcolaDieciAlla(n / 2);
			risultato = risultato * risultato;
			if (n % 2 == 1) {
				// n è dispari occorre quadrare e poi moltiplicare per 10
				risultato = risultato * 10;
			}
		}
		return risultato;
	}

	// Esercizio 6
	public static int sommaArray(int[] data) {
		return sommaArrayElementoDaAggiungere(data, data.length - 1);
	}

	public static int sommaArrayElementoDaAggiungere(int[] data, int ultimo) {
		int result;

		if (ultimo < 0)
			result = 0; // un solo valore nell'array
		else {
			result = data[ultimo] + sommaArrayElementoDaAggiungere(data, ultimo - 1);
		}

		return result;

	}

	
	// Esercizio 7
	public static int max(int[] data) {
		return maxInSubArray(data, 0, data.length - 1);
	}

	public static int maxInSubArray(int[] data, int primo, int ultimo) {
		int risultato;

		if (primo == ultimo)
			risultato = data[primo]; // Un solo valore nell'array
		else {
			int mezzo = (ultimo + primo) / 2;
			int max1 = maxInSubArray(data, primo, mezzo);
			int max2 = maxInSubArray(data, mezzo + 1, ultimo);
			if (max1 > max2)
				risultato = max1;
			else
				risultato = max2;
		}

		return risultato;

	}

	
	// Esercizio 8
	public static int ricercaTernaria(int data[], int obiettivo) {
		return ricercaTernariaLimitata(data, obiettivo, 0, data.length - 1);
	}

	// Utilizza la ricerca trinaria per cercare obiettivo 
	// da data[primo] a data[ultimo] inclusi. 
	// Restituisce l'indice del obiettivo se questo viene trovato.
	// Restituisce -1 se obiettivo non viene trovato.
	public static int ricercaTernariaLimitata(int data[], int obiettivo, int primo, int ultimo) {
		int risultato;
		if (primo > ultimo)
			risultato = -1;
		else {
			int mezzo1 = (2 * primo + ultimo) / 3;
			int mezzo2 = (primo + 2 * ultimo) / 3;
			if (obiettivo == data[mezzo1])
				risultato = mezzo1;
			else if (obiettivo == data[mezzo2])
				risultato = mezzo2;
			else if (obiettivo < data[mezzo1])
				risultato = ricercaTernariaLimitata(data, obiettivo, primo, mezzo1 - 1);
			else if (obiettivo < data[mezzo2])
				risultato = ricercaTernariaLimitata(data, obiettivo, mezzo1 + 1, mezzo2 - 1);
			else
				risultato = ricercaTernariaLimitata(data, obiettivo, mezzo2 + 1, ultimo);

		}
		return risultato;
	}

	// Esercizio 9
	public static void sommaCumulativa(int data[]) {
		sommaCumulativaPosizione(data, 1);
	}

	public static void sommaCumulativaPosizione(int data[], int n) {
		if (n == data.length)
			return;
		else {
			data[n] += data[n - 1];
			sommaCumulativaPosizione(data, n + 1);
		}
	}

	// Esercizio 10
	public static double calcolaInteresseComposto(double sommaIniziale, int mesi) {
		double risultato;

		if (mesi <= 0) {
			risultato = sommaIniziale;
		} else {
			risultato = 1.005 * calcolaInteresseComposto(sommaIniziale, mesi - 1);
		}

		return risultato;

	}

	// Esercizio 11
	public static int messaggi(int volte) {
		int risultato;

		if (volte <= 3)
			risultato = 1;
		else
			risultato = messaggi(volte - 2) + messaggi(volte - 3);

		return risultato;
	}

	
	// Esercizio 12
	public static int contaVocali(String s) {
		int risultato;

		if (s.length() == 0)
			risultato = 0;
		else {
			if (isVocale(s.charAt(0)))
				risultato = 1 + contaVocali(s.substring(1));
			else
				risultato = contaVocali(s.substring(1));

		}
		return risultato;
	}

	public static boolean isVocale(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}

	
	// Esercizio 13
	public static String rimuoviVocali(String s) {
		String risultato;

		if (s.length() == 0)
			risultato = "";
		else {
			if (isVocale(s.charAt(0)))
				risultato = rimuoviVocali(s.substring(1));
			else
				risultato = s.charAt(0) + rimuoviVocali(s.substring(1));

		}
		return risultato;
	}

	// Esercizio 14
	public static String duplicaCarattere(String s) {
		String risultato;

		if (s.length() == 0)
			risultato = "";
		else {
			String doubled = "" + s.charAt(0) + s.charAt(0);
			risultato = doubled + duplicaCarattere(s.substring(1));
		}
		return risultato;
	}

	
	// Esercizio 15
	public static String inverti(String s) {
		String risultato;

		if (s.length() == 0)
			risultato = "";
		else {
			risultato = inverti(s.substring(1)) + s.charAt(0);
		}
		return risultato;
	}

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci un valore intero: ");
		long numero = tastiera.nextLong();

		System.out.println("Il numero di cifre dispari nel numero e' " + contaDispari(numero));
		System.out.println("La somma delle cifre del numero e' la seguente " + sommaCifre(numero));

		System.out.println("Inserisci un valore intero, verra' calcolato 10^n: ");
		int potenza = tastiera.nextInt();
		System.out.println("10^n e' " + calcolaDieciAlla(potenza));

		int array1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Il massimo dell'array dovrebbe essere 10, ottenuto da " + max(array1));
		int array2[] = { 10 };
		System.out.println("Il massimo dell'array dovrebbe essere 10, ottenuto da " + max(array2));
		int array3[] = { 0, 10 };
		System.out.println("Il massimo dell'array dovrebbe essere 10, ottenuto da " + max(array3));
		int array4[] = { 10, 0 };
		System.out.println("Il massimo dell'array dovrebbe essere 10, ottenuto da " + max(array4));
		int array5[] = { 1, 10, 5 };
		System.out.println("Il massimo dell'array dovrebbe essere 10, ottenuto da " + max(array5));
		int array6[] = { 1, 2, 3, 10, 4, 5, 6, 7, 8, 9 };
		System.out.println("Il massimo dell'array dovrebbe essere 10, ottenuto da " + max(array6));

		int array7[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

		System.out.println("La somma di 2, 4, 6, 8, 10, 12, 14, 18, 20 is " + sommaArray(array7));

		for (int i = 1; i <= 21; i++) {
			System.out.println("Trovato " + i + " in posizione " + ricercaTernaria(array7, i));
		}

		System.out.println("La somma cumulativa per  [2, 3, 1, 5, 6, 2, 7] dovrebbe essere [2, 5, 6, 11, 17, 19, 26]. ");
		int array8[] = { 2, 3, 1, 5, 6, 2, 7 };
		sommaCumulativa(array8);
		System.out.print("Ottengo :");
		for (int i = 0; i < array8.length; i++) {
			System.out.print(" " + array8[i]);
		}
		System.out.println();

		System.out.println("20.0: interesse composto per 1 mese e' " + calcolaInteresseComposto(20.0, 1));
		System.out.println("20.0: interesse composto per 2 mese e' " + calcolaInteresseComposto(20.0, 2));
		System.out.println("20.0: interesse composto per 10 mese e' " + calcolaInteresseComposto(20.0, 10));
		System.out.println("20.0: interesse composto per 100 mese e' " + calcolaInteresseComposto(20.0, 100));

		for (int i = 0; i < 14; i++) {
			System.out.println("Numero di messaggi per " + i + " microsecondi e' " + messaggi(i));
		}

		System.out.println("Il numero di caratteri per la stringa " + "\n \"A e' una lettera molto bella.\" e' "
				+ contaVocali("A e' una lettera molto bella."));

		System.out.println("Rimuovendo le vocali da " + "\n \"A e' una lettera molto bella. \" si ottiene "
				+ rimuoviVocali("A e' una lettera molto bella."));

		System.out.println("Duplicando ogni lettera in " + "\n \"A e' una lettera molto bella.\" si ottiene "
				+ duplicaCarattere("A e' una lettera molto bella."));

		System.out.println("Invertendo le lettere in " + "\n \"A e' una lettera molto bella.\" si ottiene "
				+ inverti("A e' una lettera molto bella."));

	}
}
