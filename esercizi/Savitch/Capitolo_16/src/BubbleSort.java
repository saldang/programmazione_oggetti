import java.util.Vector;

public class BubbleSort {
	/**
	 * Ordina gli elementi di un Vector 
	 * in mood che le stringhe siano ordinate in rdine lessicografico
	 */
	public static void sort(Vector a) {
		int index;
		for (int i = 0; i < a.size(); i++) {
			for (index = 0; index < a.size() - 1; index++) {
				String s = (String) a.get(index);
				String t = (String) a.get(index + 1);
				if (s.compareTo(t) > 0) {
					a.set(index + 1, s);
					a.set(index, t);
				}
			} 
		}
	}
}
