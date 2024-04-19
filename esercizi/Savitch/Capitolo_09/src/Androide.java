public class Androide {

	private static int tag = 1;

	private static void cambiaTag() {
		int provaProssimo = tag + 1;
		while (!isPrimo(provaProssimo))
			provaProssimo = provaProssimo + 1;
		tag = provaProssimo;
	}

	private static boolean isPrimo(int n) {
		boolean hasFactor = false;

		for (int factor = 2; factor < n; factor++) {
			if (n % factor == 0)
				hasFactor = true;
		}
		return !hasFactor;
	}

	private String nome;

	/**
	 * Crea una nuova istanza di Androide
	 */
	public Androide() {
		nome = "Bob" + tag;
		cambiaTag();
	}

	public String getNome() {
		return nome;
	}

	public static void main(String[] args) {
		for (int count = 1; count < 10; count++) {
			Androide andy = new Androide();
			System.out.println("Creato un androide di nome " + andy.getNome());
		}
	}
}
