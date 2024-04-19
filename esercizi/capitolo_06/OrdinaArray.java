/**
Classe per ordinare un array di tipo int dal piu' piccolo al piu' grande.
*/
public class OrdinaArray {

	/**
	Precondizione: Ogni elemento nell'array ha un valore.
	Azione: Ordina l'array in ordine crescente.
	*/
	public static void selectionSort(int[] unArray) {

		for (int indice = 0; indice < unArray.length - 1; indice++) {
			// Posiziona il valore corretto in unArray[indice]
			int indiceDelSuccessivoPiuPiccolo = getIndiceDelPiuPiccolo(indice, unArray);
			scambio(indice, indiceDelSuccessivoPiuPiccolo, unArray);
			//Asserzione: unArray[0] <= unArray[1] <=...<= unArray[indice]
			//e questi sono I piu' piccoli dell'array originale di elementi.
			//Le posizioni rimanenti contengono i rimanenti elementi 
            //dell'array.
		}
	}

	/**
	Ritorna l'indice del piu' piccolo valore nella porzione di
	array che inizia dall'elemento il cui indice e' indiceInizio e
	termina all'ultimo elemento.
	*/
	private static int getIndiceDelPiuPiccolo(int indiceInizio, int[] a) {
		int minimo = a[indiceInizio];
		int indiceDelMinimo = indiceInizio;

		for (int indice = indiceInizio + 1; indice < a.length; indice++) {
			if (a[indice] < minimo) {
				minimo = a[indice];
				indiceDelMinimo = indice;
				//minimo e' il piu' piccolo 
                              //da a[indiceInizio] fino a[indice]
			}
		}
		return indiceDelMinimo;
	}

	/**
	Precondizione: I e j sono indici validi per l'array a.
	Postcondizione: I valori di a[i] e a[j] sono stati scambiati.
	*/
	private static void scambio(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp; //valore originale di a[i]
	}
}