import java.util.List;

public class StringBubbleSort {
	/**
	Ordina la lista in modo tale che a.get(0), a.get(1), ...
    a.get(a.size() - 1) sono in ordine lessografico.
    */ 
	public static void sort(List<String> a) {
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

		int iterazioni = a.size() - 1; // Numero massimo di iterazioni

		while (!ordinato && iterazioni > 0) {
			// Imposta la sentinella ordinato a true per indicare che l'array e' ordinato e
			// la
			// imposta a false se avviene uno scambio

			ordinato = true;
			for (int i = 0; i < iterazioni; ++i) {
				if(((String)(a.get(i))).compareTo((String)(a.get(i + 1))) > 0) {
					// Scambio: sposta il valore più grande alla posizone più alta

					scambia(i, a);
					ordinato = false;
				}
			}
			--iterazioni;
		}
	}

	/**
	 * Precondizione: i e i+1 sono valori legali per l'array lista. Postcondizone: I
	 * valori di lista.get(i) e lista.get(i+1) sono stati scambiati.
	 */
	private static void scambia(int i, List<String> lista) {
		String temp;
		temp = lista.get(i);
		lista.set(i, (lista.get(i + 1)));
		lista.set(i+1, temp); 
	}
}
