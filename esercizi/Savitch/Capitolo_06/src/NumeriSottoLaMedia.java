import java.util.Scanner;

public class NumeriSottoLaMedia {

	public static void main(String[] args) {
		double[] data = new double[10];

		System.out.println("Inserisci 10 valori di temperatura: ");

		Scanner tastiera = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			data[i] = tastiera.nextDouble();
		}

		// calcola la media
		double somma = 0.0;
		for (int i = 0; i < 10; i++) {
			somma += data[i];
		}
		double media = somma / 10;
		System.out.println("La temperatura media e': " + media);

		// conta le temperature sopra la media
		int conteggio = 0;
		for (int i = 0; i < 10; i++) {
			if (data[i] > media) {
				conteggio++;
				System.out.println("Il giorno " + i + " ha avuto una temperatura pari a " + data[i]
						+ " che e' stata sopra la media");

			}
		}

		System.out.println("Il numero di giorni con una temperatura superiore alla media e': " + conteggio);

	}

}
