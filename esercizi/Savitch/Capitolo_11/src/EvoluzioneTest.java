import java.util.Scanner;

public class EvoluzioneTest {
	public static final int NUMERO_INIZIALE_FORMICHE = 100;
	public static final int NUMERO_INIZIALE_LARVE = 5;

	public static void main(String[] args) {
		Mondo mondo = new Mondo();
		Scanner tastiera = new Scanner(System.in);

		// Crea random 100 formiche
		int numeroFormiche = 0;
		while (numeroFormiche < NUMERO_INIZIALE_FORMICHE) {
			int x = (int) (Math.random() * Mondo.DIMENSIONE_MONDO);
			int y = (int) (Math.random() * Mondo.DIMENSIONE_MONDO);
			if (mondo.getAllaCella(x, y) == null) {
				numeroFormiche++;
				Formica a1 = new Formica(mondo, x, y);
			}
		}
		// Crea random 5 larve
		int doodlecount = 0;
		while (doodlecount < NUMERO_INIZIALE_LARVE) {
			int x = (int) (Math.random() * Mondo.DIMENSIONE_MONDO);
			int y = (int) (Math.random() * Mondo.DIMENSIONE_MONDO);
			if (mondo.getAllaCella(x, y) == null) {
				doodlecount++;
				Larva d1 = new Larva(mondo, x, y);
			}
		}

		// Gira per sempre finoa c he l'utente non esce
		String s;
		while (true) {
			mondo.visualizza();
			mondo.simulaUnoStep();
			System.out.println("Press enter for next step");
			s = tastiera.nextLine();
		}
	}
}
