public class SommaInteriEsempio {
	public static void main(String[] args) {
		int[] testArray = new int[5];
		testArray[0] = 5;
		testArray[1] = 8;
		testArray[2] = 42;
		testArray[3] = 1;
		testArray[4] = 19;

		System.out.println("Gli interi nell'array sono:");
		for (int i = 0; i < testArray.length; ++i) {
			System.out.println("Valore all'indice " + i + " = " + testArray[i]);
		}

		int somma = sommaInteri(testArray);
		System.out.println();
		System.out.println("La somma dovrebbe essere 75");
		System.out.println("La somma attualmente restituita e' " + somma);
	}

	public static int sommaInteri(int[] a) {
		if (a.length == 1)
			return a[0];
		else {
			// Copia tutti gli elementi in un array temporaneo ad eccezione di quello con
			// valore piu' alto

			int[] temp = new int[a.length - 1];
			for (int i = 0; i < a.length - 1; ++i)
				temp[i] = a[i];

			// Aggiunge l'elemento alla posizone piu' alta e chiama nuovamente sommaInteri
			// con l'array a cui è stato tolto l'elemento alla poszione piu' alta

			return (sommaInteri(temp) + a[a.length - 1]);
		}
	}
}