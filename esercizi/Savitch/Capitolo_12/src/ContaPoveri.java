import java.util.ArrayList;
import java.util.Scanner;

public class ContaPoveri {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);

		ArrayList<Famiglia> data = new ArrayList<Famiglia>();

		System.out.println("Inserisci il reddito e la dimensione per ogni famiglia ");
		boolean ancoraDati = true;
		int count = 0;

		while (ancoraDati) {
			System.out.println("Reddito e dimensione per la famiglia " + (count + 1) + " ");
			// Ogni input non double causera' l'uscita dal ciclo
			if (tastiera.hasNextDouble()) {
				double reddito = tastiera.nextDouble();
				int diemnsione = tastiera.nextInt();
				data.add(new Famiglia(reddito, diemnsione));
			} else {
				ancoraDati = false;
				System.out.println("Terminato di leggere dati.");
				// Pulisce la linea
				tastiera.next();
				tastiera.nextLine();
			}
			count++;
		}

		// Ottieni il costo medio per vitto e alloggio
		System.out.println("Inserisci il costo medio per vitto e alloggio ");
		double costoAlloggioMedio = tastiera.nextDouble();
		double costoVittoMedio = tastiera.nextDouble();

		// Conta e visualizza le famiglie che sono considerate povere
		System.out.println("\nVisualizza le famiglie considerate povere");
		count = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).povera(costoAlloggioMedio, costoVittoMedio)) {
				count++;
				System.out.println("La famiglia " + (i + 1) + ": " + data.get(i));
			}
		}
		System.out.println("Il conteggio e': " + count);
	}
}
