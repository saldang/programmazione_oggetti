import java.util.Scanner;

public class ProgressioneAritmentica {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripetere = 's';
		while (ripetere == 's' || ripetere == 'Y') {
			int numero = -1; // Valore arbitrario per entare nel ciclo
			while (numero <= 0) {
				System.out.println("Inserisci un intero non negativo:");
				numero = tastiera.nextInt();
			}
			System.out.println("La somma dei primi " + numero + " interi e' " + sommaInteri(numero) + ".");
			System.out.println();
			System.out.println("Ancora? Inserisci 's' per continuare.");
			ripetere = tastiera.next().charAt(0);
		}
	}

	private static int sommaInteri(int n) {
		if (n == 1)
			return 1;
		else
			return (n + sommaInteri(n - 1));
	}
}
