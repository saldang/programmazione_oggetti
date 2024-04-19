public class ProdottoArray {
	public static void main(String[] args) {
		String[][] data = { { "A", "B" }, { "1", "3" }, { "2" }, { "XX", "YY" } };

		String[] unaLinea = new String[data.length];
		// 0 significa inizia a riempire l'array alla posizione 0
		calcolaProdotto(data, unaLinea, 0);
	}

	public static void calcolaProdotto(String[][] data, String[] unaLinea, int gruppo) {
		// Termina se siamo alla fine dell'array data
		if (gruppo >= data.length)
			return;

		// Ottiene tutti i possibili valori dal gruppo
		for (int i = 0; i < data[gruppo].length; i++) {
			unaLinea[gruppo] = data[gruppo][i];
			calcolaProdotto(data, unaLinea, gruppo + 1);
			// Stampa se e' l'ultimo gruppo
			if (gruppo == data.length - 1)
				stampaElementi(unaLinea);
		}
	}

	public static void stampaElementi(String[] unaLinea) {
		for (int i = 0; i < unaLinea.length; i++)
			System.out.print(unaLinea[i] + " ");
		System.out.println();
	}

}