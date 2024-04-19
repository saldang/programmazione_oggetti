import java.util.Scanner;

public class Frammenti {

	// Esercizio 5
	public static boolean strettamenteCrescente(double[] in) {
		boolean risultato = true;
		for (int i = 0; i < (in.length - 1); i++) {
			if (in[i + 1] <= in[i])
				risultato = false;
		}
		return risultato;
	}

	
	// Esercizio 6
	public static Character[] rimuoiviDuplicati(Character[] in) {
		boolean daTenere[] = new boolean[in.length];

		// Si inizia specificando che tutti i valori vanno tenuti
		for (int i = 0; i < in.length; i++) {
			daTenere[i] = true;
		}

		// Verifico i duplicati per ogni carattere
		for (int i = 0; i < in.length; i++) {
			// Eseguo la la scansione del resto solo se non si tratta di un duplicato
			if (daTenere[i])
				for (int j = i + 1; j < in.length; j++) {
					if (in[i] == in[j])
						daTenere[j] = false;
				}
		}

		// Trova il numero di non duplicati
		int count = 0;
		for (int i = 0; i < in.length; i++) {
			if (daTenere[i])
				count++;
		}

		// Crea e copia i non duplicati
		Character risultato[] = new Character[count];
		int posizione = 0;
		for (int i = 0; i < in.length; i++) {
			if (daTenere[i]) {
				risultato[posizione] = in[i];
				posizione++;
			}
		}

		return risultato;
	}

	
	// Esercizio 7
	public static int[] remove(int v, int[] in) {
		// Trova il numero di valori che saranno nel risultato
		int conteggio = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] != v)
				conteggio++;
		}

		// Copia i valori nel risultato
		int risultato[] = new int[conteggio];
		int posizione = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] != v) {
				risultato[posizione] = in[i];
				posizione++;
			}
		}
		return risultato;
	}

	
	// Esercizio 8
	public static int[] combinaOrdini(int[] ordine1, int[] ordine2) {
		// Trova il numero di valori che saranno nel risultato
		int[] ordineCombinato = new int[5];
		for (int i = 0; i < 5; i++) {
			ordineCombinato[i] = ordine1[i] + ordine2[i];
		}

		return ordineCombinato;
	}

	
	// Esercizio 9
	/**
	 * Precondizione: Ogni elemento in unArray ha un valore. 
	 * Azione: Ordina l'array in ordine crescente
	 */
	public static void selectionSort(Character[] unArray) {
		for (int indice = 0; indice < unArray.length - 1; indice++) {
			// Posiziona il valore corretto in unArray[indice]
			int indiceDelProssimoPiuPiccolo = indiceValoreMinore(indice, unArray);

			scambia(indice, indiceDelProssimoPiuPiccolo, unArray);
			// Asserzione:unArray[0] <= unArray[1] <=...<= unArray[indice]
			// e questi sono i più piccoli elementi dell'array originale.
			// Le altre posizioni contengono il resto degli elementi dell'array originale.
		}
	}

	/**
	 * Restituisce la posizone del valore inferiore nella porzione di array
	 * inizia dall'elemento il cui indice è indiceInizio e termina dall'ultimo elemento.
	 */
	private static int indiceValoreMinore(int indiceInizio, Character[] a) {
		Character min = a[indiceInizio];
		int indiceDiMin = indiceInizio;
		for (int indice = indiceInizio + 1; indice < a.length; indice++) {
			if (a[indice] < min) {
				min = a[indice];
				indiceDiMin = indice;
				// min è il piu' piccolo tra a[indiceInizio] e a[indice]
			}
		}
		return indiceDiMin;
	}

	/**
	 * Precondizione: i e j sono indici validi per l'array a. 
	 * Postcondizione: i valori di a[i] e a[j] sono stati scambiati.
	 */
	private static void scambia(int i, int j, Character[] a) {
		Character temp = a[i];
		a[i] = a[j];
		a[j] = temp; // valore originale di  a[i]
	}

	
	public static void main(String[] args) {

		double[] testArray1 = { 1.5, 2.3, 5.6, 8.9, 10.9 };
		double[] testArray2 = { 1.5, 2.3, 2.3, 8.9, 10.9 };
		double[] testArray3 = { 1.5, 2.3, 5.6, 8.9, 7.9 };
		double[] testArray4 = { 3.5, 2.3, 5.6, 8.9, 10.9 };

		System.out.println("Array 1 e' in ordine crescente, dovrebbe essere vero: " + strettamenteCrescente(testArray1));

		System.out.println("Array 2 non e' in ordine crescente, dovrebbe essere falso: " + strettamenteCrescente(testArray2));

		System.out.println("Array 3 non e' in ordine crescente, dovrebbe essere falso: " + strettamenteCrescente(testArray3));

		System.out.println("Array 4 non e' in ordine crescente, dovrebbe essere falso: " + strettamenteCrescente(testArray4));

		Character[] testArray5 = { 'b', 'd', 'a', 'b', 'f', 'a', 'g', 'a', 'a', 'f' };
		System.out.println("Array 5 dopo aver rimosso i dublicati dovrebbe essere b, d, a, f, g : ");
		Character[] risposta = rimuoiviDuplicati(testArray5);
		for (int i = 0; i < risposta.length; i++) {
			System.out.print(risposta[i] + "  ");
		}
		System.out.println();

		Character[] testArray6 = { 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		System.out.println("Array 6 dopo aver rimosso i dublicati dovrebbe essere b : ");
		risposta = rimuoiviDuplicati(testArray6);
		for (int i = 0; i < risposta.length; i++) {
			System.out.print(risposta[i] + "  ");
		}
		System.out.println();

		Character[] testArray7 = { 'b', 'd', 'a', 'z', 'f', 'n', 'g', 'm', 'p', 'q' };
		System.out.println("Array 7 dopo aver rimosso i dublicati dovrebbe essere b, d, a, z, f, n, g, m, p, q : ");
		risposta = rimuoiviDuplicati(testArray7);
		for (int i = 0; i < risposta.length; i++) {
			System.out.print(risposta[i] + "  ");
		}
		System.out.println();

		int[] testArray8 = { 4, 1, 3, 4, 2, 4, 5, 4, 5, 4 };
		System.out.println("Array 8 dopo aver rimosso 4 dovrebbe essere 1 3 2 5 5 : ");
		int[] risultato = remove(4, testArray8);
		for (int i = 0; i < risultato.length; i++) {
			System.out.print(risultato[i] + "  ");
		}
		System.out.println();

		System.out.println("Array 8 dopo aver rimosso 5 dovrebbe essere 4 1 3 4 2 4 4 4 : ");
		risultato = remove(5, testArray8);
		for (int i = 0; i < risultato.length; i++) {
			System.out.print(risultato[i] + "  ");
		}
		System.out.println();

		int[] ordine1 = { 0, 0, 3, 4, 7 };
		int[] ordine2 = { 0, 4, 0, 1, 2 };

		int[] ordineCombinato = combinaOrdini(ordine1, ordine2);
		System.out.println("L'ordine combinato dovrebbe essere 0 4 3 5 9 : ");
		for (int i = 0; i < ordineCombinato.length; i++) {
			System.out.print(ordineCombinato[i] + "  ");
		}
		System.out.println();

		int[] ordineCombinato2 = combinaOrdini(ordineCombinato, ordineCombinato);
		System.out.println("L'ordine combinato dovrebbe essere 0 8 6 10 18 : ");
		for (int i = 0; i < ordineCombinato2.length; i++) {
			System.out.print(ordineCombinato2[i] + "  ");
		}
		System.out.println();

		System.out.println("L'array 5 ordinato dovrebbe essere : a a a a b b d f f g ");
		selectionSort(testArray5);
		for (int i = 0; i < risposta.length; i++) {
			System.out.print(testArray5[i] + "  ");
		}
		System.out.println();

		System.out.println("L'array 7 ordinato dovrebbe essere : a b d f g m n p q z ");
		selectionSort(testArray7);
		for (int i = 0; i < risposta.length; i++) {
			System.out.print(testArray7[i] + "  ");
		}
		System.out.println();

	}

}
