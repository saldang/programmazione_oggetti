import java.util.Scanner;

public class ContaPoveri {

	public static void main(String[] args) {

		System.out.println("Quante famiglie ci sono? ");

		Scanner tastiera = new Scanner(System.in);
		int k = tastiera.nextInt();

		Famiglia[] data = new Famiglia[k];

		System.out.println("Inserisci il reddito e la dimensione per ogni famiglia ");
		for (int i = 0; i < data.length; i++) {
			System.out.println("Reddito e dimensione per la famiglia " + (i + 1) + " ");
			double in = tastiera.nextDouble();
			int dimensione = tastiera.nextInt();
			data[i] = new Famiglia(in, dimensione);
		}

		// Ottieni il costo medio per vitto e alloggio
		System.out.println("Inserisci il costo medio per vitto e alloggio ");
		double costoAlloggioMedio = tastiera.nextDouble();
		double costoVittoMedio = tastiera.nextDouble();

		// Conta e visualizza le famiglie che sono considerate povere
		System.out.println("\nVisualizza le famiglie considerate povere");
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].povera(costoAlloggioMedio, costoVittoMedio)) {
				count++;
				System.out.println("La famiglia " + (i + 1) + ": " + data[i]);

			}
		}
		System.out.println("Il conteggio e': " + count);
	}
}
