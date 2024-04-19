import java.util.Scanner;

public class BuoniCioccolato {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int euro;
		int buoni;
		int barrette = 0;

		System.out.println("Quanto puoi spebdere per le barrette di cioccolato?");
		euro = tastiera.nextInt();

		// Calcola le barrette iniziali e i buoni
		barrette = euro; // Euro 1 per barretta
		buoni = barrette; // ! buono per barretta
		// Fintanto che si hanno almeno 6 buoni, si riscattano
		while (buoni >= 6) {
			barrette += (buoni / 6); // Tronca
			// Il nuovo numero di buoni e' pari a quelli che rimangono dopo il riscatto, piu' i buovi buoni che derivano dalle barrette di cioccolata
			buoni = (buoni % 6) + (buoni / 6);
		}
		System.out.println("Dopo aver riscattato i buoni, hai " + buoni + " buoni rimasti "
				+ "e pupi comprare " + barrette + " barrette di cioccolata.");
	}
}
