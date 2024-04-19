import java.util.Scanner;

public class AcquaNelPozzo {
	public static final double METRI_CUBI_PER_LITRO = 1000;

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int raggio;
		int profondita;
		int litri; // Potrebbe essere un double

		System.out.println("Questo programma calcola quanta acqua sarà disponibile in un pozzo.");
		System.out.println("Qual e' il raggio del pozzo in centimetri?");
		raggio = tastiera.nextInt();
		System.out.println("Qual e' la profondita' del pozzo in metri?");
		profondita = tastiera.nextInt();

		// Calola i litri, prima concerte il raggio in metri, quindi calola il volume
		// ae moltiplica per il fattore di conversione metri cubi per litro
		litri = (int) ((Math.PI * (raggio / 100.0) * (raggio / 100.0) * profondita) * METRI_CUBI_PER_LITRO);

		System.out.println("Il pozzo contiene " + litri + " litri.");
	}
}