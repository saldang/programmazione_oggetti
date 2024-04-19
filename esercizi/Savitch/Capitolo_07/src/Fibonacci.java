import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti = 's';
		while (ripeti == 's' || ripeti == 'S') {
			int numero = -1; // Valore arbitario per entrare nel ciclo

			while (numero <= 0) {
				System.out.println("Quanti numeri di Fibonacci vuoi usare?");
				System.out.println("Inserisci un intero positivo:");
				numero = tastiera.nextInt();
			}

			System.out.println("Ecco la serie di Fibonacci e il rapporto fra il numero corrente ");
			System.out.println(numero + " e i succesivi numeri di Fibonacci e' :");

			System.out.println("Fibonacci #1 = 0");

			if (numero > 1)
				System.out.println("Fibonacci #2 = 1");

			for (int i = 3; i <= numero; ++i) {
				System.out.println("Fibonacci #" + i + " = " + fibonacci(i) + " e ratio = " + fibonacci(i) + "/"
						+ fibonacci(i - 1) + " = " + (float) fibonacci(i) / fibonacci(i - 1));
			}

			System.out.println();
			System.out.println("Vuoi continuare? Inserisci 's' per si.");
			ripeti = tastiera.next().charAt(0);
		}
	}

	private static int fibonacci(int n) {
		switch (n) {
		case 0:
		case 1:
			return 0;
		case 2:
			return 1;
		default:
			return (fibonacci(n - 1) + fibonacci(n - 2));
		}
	}
}
