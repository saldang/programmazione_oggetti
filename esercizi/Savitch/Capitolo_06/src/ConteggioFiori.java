import java.util.Scanner;

public class ConteggioFiori {

	public static void main(String[] args) {

		String[] nomiFiori = { "petunia", "viola del pensiero", "rosa", "violetta", "garofano" };
		double[] prezzi = { 0.50, 0.75, 1.50, 0.50, 0.80 };

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Che fiore vuoi? ");
		String fiore = tastiera.next();

		int indiceFiore = -1;
		for (int i = 0; i < nomiFiori.length; i++) {
			if (nomiFiori[i].equals(fiore))
				indiceFiore = i;
		}

		if (indiceFiore == -1)

			System.out.println("Mi spiace, ma non abbiamo quel fiore.");
		else {
			System.out.println("Quanti fiori vuoi? ");
			int numero = tastiera.nextInt();
			double costoTotale = numero * prezzi[indiceFiore];

			System.out.println(fiore + ": " + numero + " a " + prezzi[indiceFiore] + " costa/ano " + costoTotale);
		}

	}

}
