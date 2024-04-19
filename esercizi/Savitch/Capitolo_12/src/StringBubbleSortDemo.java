import java.util.ArrayList;
import java.util.List;

public class StringBubbleSortDemo {
	public static void main(String[] args) {
		List<String> b = new ArrayList<String>();
        b.add("tempo");
        b.add("marea");
        b.add("nuvole");
        b.add("pioggia");

		System.out.println("Valori dell'array prima dell'ordinamento:");
		int i;
		for (i = 0; i < b.size(); i++)
			System.out.print(b.get(i) + " ");
		System.out.println();

		StringBubbleSort.sort(b);

		System.out.println("Valori dell'array dopo l'ordinamento:");
		for (i = 0; i < b.size(); i++)
			System.out.print(b.get(i) + " ");

		System.out.println();
	}
}