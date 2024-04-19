/**
 * Classe per ordinare un array di tipo int dal piu' piccolo al piu' grande.
 */
public class OrdinaArray {

	/**
	 * Precondizione: Ogni elemento nell'array ha un valore. Azione: Ordina l'array
	 * in ordine crescente.
	 */
	public static void selectionSort(int[] unArray) {

		for (int indice = 0; indice < unArray.length - 1; indice++) {
			// Posiziona il valore corretto in unArray[indice]
			int indiceDelSuccessivoPiuPiccolo = getIndiceDelPiuPiccolo(indice, unArray);
			scambio(indice, indiceDelSuccessivoPiuPiccolo, unArray);
			// Asserzione: unArray[0] <= unArray[1] <=...<= unArray[indice]
			// e questi sono I piu' piccoli dell'array originale di elementi.
			// Le posizioni rimanenti contengono i rimanenti elementi
			// dell'array.
		}
	}

	/**
	 * Ritorna l'indice del piu' piccolo valore nella porzione di array che inizia
	 * dall'elemento il cui indice e' indiceInizio e termina all'ultimo elemento.
	 */
	private static int getIndiceDelPiuPiccolo(int indiceInizio, int[] a) {
		int minimo = a[indiceInizio];
		int indiceDelMinimo = indiceInizio;

		for (int indice = indiceInizio + 1; indice < a.length; indice++) {
			if (a[indice] < minimo) {
				minimo = a[indice];
				indiceDelMinimo = indice;
				// minimo e' il piu' piccolo
				// da a[indiceInizio] fino a[indice]
			}
		}
		return indiceDelMinimo;
	}

	/**
	 * Precondizione: i e j sono indici validi per l'array a. Postcondizione: I
	 * valori di a[i] e a[j] sono stati scambiati.
	 */
	private static void scambio(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp; // valore originale di a[i]
	}

	
	//Soluzione Progetto 3
	
	public static void bubbleSort(int[] a) {
		// La sentinella ordinato sarà posta a true prima di ogni passaggio attraverso
		// l'array
		// e posta a false se si verifica uno swap durante il passaggio.
		// Se rimane true, allora non si è verificato alcuno swap e l'array deve essere
		// ordinato.
		// La sentinella è inizializzata a false cosi' da entrare nel ciclo

		boolean ordinato = false;

		// Ogni passaggio attraverso il ciclo for mette l'elemento successivo nella sua
		// posizione corretta
		// (va salire fino alla posizione più alta non ordinata) e riduce di 1 il numero
		// di elementi
		// dell'array da elaborare nella successiva iterazione

		int iterazioni = a.length - 1; // Numero massimo di iterazioni

		while (!ordinato && iterazioni > 0) {
			// Imposta la sentinella ordinato a true per indicare che l'array e' ordinato e
			// la
			// imposta a false se avviene uno scambio

			ordinato = true;
			for (int i = 0; i < iterazioni; ++i) {
				if (a[i] > a[i + 1]) {
					// Scambio: sposta il valore più grande alla posizone più alta

					scambia(i, a);
					ordinato = false;
				}
			}
			--iterazioni;
		}
	}

	/**
	 * Precondizione: i e i+1 sono valori legali per l'array a. Postcondizone: I
	 * valori di a[i] e a[i+1] sono stati scambiati.
	 */
	private static void scambia(int i, int[] array) {
		int temp;
		temp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = temp; // Valore originale di a[i]
	}
	
	
	// Soluzione Progetto 4
	public static void insertionSort(int[] a) {
		// Gli elementi vengono letti dall'array originale uno alla volta e inseriti
		// nell'array
		// temp nel loro ordine corretto. Dopo che tutti gli elementi sono stati
		// elaborati,
		// temp contiene gli elementi dell'array originale in ordine crescente.

		int[] temp = new int[a.length]; // Dimensione massima di temp come quella dell'array originale
		int dimensioneDiTemp = 0; // La dimensione iniziale è 0
		int valoreSuccessivo; // Il prossimo elemento da inserire
		int puntoInserimento; // Punto di inseriemnto in temp

		// Il primo elemento va alla prima posizione di temp
		// Si assume che l'array abbia almeno un elemento

		temp[0] = a[0];
		dimensioneDiTemp++; // temp ha almeno un elemento

		// Occorre trovare il punto di inseriemnto per i restanti valori prima di
		// inserirli

		for (int i = 1; i < a.length; ++i) {
			valoreSuccessivo = a[i];
			puntoInserimento = trovaPuntoInserimento(valoreSuccessivo, temp, dimensioneDiTemp);
			++dimensioneDiTemp;
			muoviElementi(puntoInserimento, temp, dimensioneDiTemp);
			temp[puntoInserimento] = valoreSuccessivo;
		}

		// Finito: copia temp to a

		for (int i = 0; i < a.length; ++i)
			a[i] = temp[i];
	}

	private static int trovaPuntoInserimento(int valore, int[] array, int dimensioneArray) {
		int i; // Occorre un valore di ritorno del metodo
		for (i = 0; i < dimensioneArray; ++i) {
			if (valore < array[i])
				return (i); // Punto di inserimento trovato
		}
		return (i); // Il punto di inserimento e' dopo l'ultimo elemento
	}

	private static void muoviElementi(int indiceBasso, int[] array, int indiceAlto) {
		for (int i = indiceAlto - 1; i > indiceBasso; --i)
			array[i] = array[i - 1]; // Spsota gli elementi indietro di una posizone
	}

}