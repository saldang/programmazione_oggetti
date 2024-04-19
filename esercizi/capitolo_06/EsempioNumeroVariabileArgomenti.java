import java.util.Scanner;

public class EsempioNumeroVariabileArgomenti {
	/**
	 * Restituisce il massimo tra un numero qualunque di interi.
	 */
	public static int massimo(int... arg) {
		if (arg.length == 0) {
			System.out.println("Errore: nessun valore specificato.");
			System.exit(0);
		}

		int m = arg[0];
		for (int i = 1; i < arg.length; i++)
			if (arg[i] > m)
				m = arg[i];
		return m;
	}

	public static void main(String[] args) {
		System.out.println("Inserire i punteggi di Anna, Marco e Luca:");
		Scanner tastiera = new Scanner(System.in);
		int punteggioAnna = tastiera.nextInt();
		int punteggioMarco = tastiera.nextInt();
		int punteggioLuca = tastiera.nextInt();
		int punteggioPiuAlto = massimo(punteggioAnna, punteggioMarco,
				punteggioLuca);
		System.out.println("Punteggio piu' alto = " + punteggioPiuAlto);
		tastiera.close();
	}
}
