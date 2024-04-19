import java.util.*;

public class Fattoriale {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripetere = 's';
		while (ripetere == 's' || ripetere == 'S') {
			int numero = -1; // Valore arbitrario per entrare nel ciclo la prima volta
			while (numero < 0) {
				System.out.println("Inserisci un intero non negativo:");
				numero = tastiera.nextInt();
			}
			System.out.println("Il fattoriale di " + numero + " e' " + fattoriale(numero) + ".");
			System.out.println();
			System.out.println("Ancora? Inserisci 's' per continuare.");
			ripetere = tastiera.next().charAt(0);
		}
	}

	private static int fattoriale(int n) {
		if (n == 1 || n == 0)
			return 1;
		else
			return (n * fattoriale(n - 1));
	}
}
