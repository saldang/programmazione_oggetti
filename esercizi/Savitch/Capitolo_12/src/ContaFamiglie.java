import java.util.ArrayList;
import java.util.Scanner;

public class ContaFamiglie {
	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);
		ArrayList<Double> data = new ArrayList<Double>();

		System.out.println("Inserisci il reddito per ciascuna delle famiglie ");

		boolean ancoraDati = true;
		int i = 0;
		while (ancoraDati) {
			System.out.println("Reddito per la famiglia " + (i + 1) + " ");
			double valore = tastiera.nextDouble();
			if (valore < 0)
				ancoraDati = false;
			else
				data.add(valore);
			i++;
		}

		// calcola il massimo
		double max = data.get(0);
		for (i = 0; i < data.size(); i++) {
			if (data.get(i) > max)
				max = data.get(i);
		}
		System.out.println("Il reddito massimo e': " + max);
		System.out.println("Il 10% del reddito massimo e': " + (0.1 * max));

		// conta e mostra le famiglie con reddito inferiore del 10% del reddito massimo
		System.out.println("\nMostro le famiglie con reddito inferiore del 10% del reddito massimo");
		int count = 0;
		for (i = 0; i < data.size(); i++) {
			if (data.get(i) < (0.1 * max)) {
				count++;
				System.out.println("La famiglia " + (i + 1) + " ha reddito " + data.get(i));
			}
		}
		System.out.println("Il conteggio e' pari a: " + count);
	}
}
