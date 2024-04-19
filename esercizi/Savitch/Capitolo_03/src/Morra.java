import java.util.Scanner;

public class Morra {
	public static void main(String[] args) {
		String sceltaGiocatore1;
		String sceltaGiocatore2;
		Scanner tastiera = new Scanner(System.in);
//p, r, s
		System.out.println("Giocatore 1, scegli C, F, or S.");
		sceltaGiocatore1 = tastiera.next().toLowerCase(); // Convert to lowercase
		System.out.println("Giocatore 2, scegli C, F, or S.");
		sceltaGiocatore2 = tastiera.next().toLowerCase();

		// Check for winner
		if (sceltaGiocatore1.equals("c") && sceltaGiocatore2.equals("f")) {
			System.out.println("Le forbici tagliano la carta, il giocatore 2 vince!");

		} else if (sceltaGiocatore1.equals("f") && sceltaGiocatore2.equals("c")) {
			System.out.println("Le forbici tagliano la carta, il giocatore 1 vince!");

		} else if (sceltaGiocatore1.equals("c") && sceltaGiocatore2.equals("s")) {
			System.out.println("La carta avvolge il sasso, il giocatore 1 vince!");

		} else if (sceltaGiocatore1.equals("s") && sceltaGiocatore2.equals("c")) {
			System.out.println("La carta avvolge il sasso, il giocatore 2 vince!");

		} else if (sceltaGiocatore1.equals("s") && sceltaGiocatore2.equals("f")) {
			System.out.println("Il sasso rompe le forbici, il giocatore 1 vince!");

		} else if (sceltaGiocatore1.equals("f") && sceltaGiocatore2.equals("s")) {
			System.out.println("Il sasso rompe le forbici, il giocatore 2 vince!");

		} else {
			System.out.println("Input errato, nussuno vince.");
		}
	}
}