public class InsertionSortDemo {
	public static void main(String[] args) {
		int[] b = { 7, 5, 11, 2, 16, 4, 18, 14, 12, 30 };

		System.out.println("Valori dell'array prima dell'ordinamento:");
		int i;
		for (i = 0; i < b.length; ++i)
			System.out.print(b[i] + " ");

		System.out.println();

		OrdinaArray.insertionSort(b);

		System.out.println("Valori dell'array dopo l'ordinamento:");
		for (i = 0; i < b.length; ++i)
			System.out.print(b[i] + " ");

		System.out.println();
	}
}