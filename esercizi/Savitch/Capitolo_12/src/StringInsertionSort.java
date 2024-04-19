import java.util.ArrayList;
import java.util.List;

public class StringInsertionSort {
	public static void sort(List<String> a) {
		// Gli elementi vengono letti dall'array originale uno alla volta e inseriti
		// nell'array temp nel loro ordine corretto. Dopo che tutti gli elementi sono
		// stati
		// elaborati, temp contiene gli elementi dell'array originale in ordine
		// crescente.

		List<String> temp = new ArrayList<String>(a.size());
		int puntoInserimento; // Punto di inseriemnto in temp

		// Il primo elemento va alla prima posizione di temp
		// Si assume che l'array abbia almeno un elemento

		String next = a.get(0);
		temp.add(0, next);
		int dimensioneDiTemp = 1; // Numero di elementi inseriti in temp

		// ora inserisce nel punto giusto tutti tutti gli elementi rimanenti

		for (int i = 1; i < a.size(); ++i) {
			next = a.get(i);
			puntoInserimento = trovaPuntoInserimento(next, temp, dimensioneDiTemp);
			temp.add(puntoInserimento, next);
			dimensioneDiTemp++;
		}

		// Finito: copia temp to a

		for (int i = 0; i < a.size(); ++i)
			a.set(i, temp.get(i));
	}

	private static int trovaPuntoInserimento(String valore, List<String> array, int dimensioneArray) {
		int i; // Occorre un valore di ritorno del metodo
		for (i = 0; i < dimensioneArray; ++i) {
			if (valore.compareTo(array.get(i)) < 0)
				return (i); // Punto di inserimento trovato
		}
		return (i); // Il punto di inserimento e' dopo l'ultimo elemento
	}
}