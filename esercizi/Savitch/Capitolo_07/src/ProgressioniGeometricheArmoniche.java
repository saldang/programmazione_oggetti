import java.util.Scanner;

public class ProgressioniGeometricheArmoniche {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti = 's';
		while (ripeti == 's' || ripeti == 'S') {
			int numero = -1; // Valore arbitario per entrare nel ciclo

			while (numero <= 0) {
				System.out.println("Inserisci un intero positivo:");
				numero = tastiera.nextInt();
			}
			System.out.println("Il prodotto dei primi " + numero + " interi e' " + geometrica(numero) + ".");
			System.out.println();
			System.out.println(
					"Il prodotto dell'inverso dei primi " + numero + " interi e' " + armonica(numero) + ".");
			System.out.println();
			System.out.println("Vuoi continuare? Inserisci 's' per si.");
			ripeti = tastiera.next().charAt(0);
		}
	}

	private static int geometrica(int n) {
		if (n == 1)
			return 1;
		else
			return (n * geometrica(n - 1));
	}

	private static double armonica(int n) {
		if (n == 1)
			return 1.0;
		else
			return ((double) 1 / n * armonica(n - 1));
	}
}
