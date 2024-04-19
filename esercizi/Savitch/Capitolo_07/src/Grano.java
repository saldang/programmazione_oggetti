import java.util.Scanner;

public class Grano {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Calcolo del numero di chicchi di grano che verrebbero messi su una scacchiera.");
		System.out.println("Su ogni casella raddoppieremo il numero di chicchi di grano.");
		System.out.println("Immettere un valore intero k (numero di caselle): ");
		System.out.println("Nota: Si avra' overflow quando k e' maggiore di 63 ");
		int number = input.nextInt();

		System.out
				.println("Il numero di grani collocati sulla scacchiera è il seguente " + numeroTotaleGrani(number, 1));
	}

	public static long numeroTotaleGrani(int k, long grani) {
		long risultato;

		if (k == 1) {
			risultato = grani;
		} else {
			risultato = grani + numeroTotaleGrani(k - 1, 2 * grani);
		}

		return risultato;
	}

}
