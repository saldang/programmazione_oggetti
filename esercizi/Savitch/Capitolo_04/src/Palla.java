import java.util.Scanner;

public class Palla {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		double altezza = 0.0;
		double velocita;
		int tempo = 0;
		int rimbalzi = 0;

		System.out.println("Inserisci la velocita' iniziale della palla");
		velocita = tastiera.nextDouble();

		while (rimbalzi < 5) {
			System.out.println("Tempo: " + tempo + " Altezza: " + altezza);
			altezza = altezza + velocita;
			velocita = velocita - 32;
			tempo = tempo + 1;

			if (altezza < 0) {
				altezza = -0.5 * altezza;
				velocita = -0.5 * velocita;
				rimbalzi = rimbalzi + 1;
				System.out.println("Rimbalzo!");
			}
		}
	}
}
