import java.util.Scanner;

public class ContaFamiglie {

	public static void main(String[] args) {

		System.out.println("Quante famiglie ci sono? ");

		Scanner tastiera = new Scanner(System.in);
		int k = tastiera.nextInt();

		double[] data = new double[k];

		System.out.println("Inserisci il reddito per ciascuna delle famiglie ");
		for (int i = 0; i < data.length; i++) {
			System.out.println("Reddito per la famiglia " + (i + 1) + " ");
			data[i] = tastiera.nextDouble();
		}

		// calcola il massimo
		double max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max)
				max = data[i];
		}
		System.out.println("Il reddito massimo e': " + max);
		System.out.println("Il 10% del reddito massimo e': " + (0.1 * max));

		// conta e mostra le famiglie con reddito inferiore del 10% del reddito massimo
		System.out.println("\nMostro le famiglie con reddito inferiore del 10% del reddito massimo");
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] < (0.1 * max)) {
				count++;
				System.out.println("La famiglia " + (i + 1) + " ha reddito " + data[i]);

			}
		}
		System.out.println("Il conteggio e' pari a: " + count);
	}
}
