import java.util.Scanner;

public class FrecciaSinistraTest {
	public static void main(String[] args) {
		char ripeti;
		Scanner tastiera = new Scanner(System.in);

		do { // Ripeti se l'utente dice si
			FrecciaSinistra a1 = new FrecciaSinistra();
			System.out.println("Costruttore di default:");
			System.out.println(a1);
			System.out.println();
			System.out.println("===============================");

			FrecciaSinistra a2 = new FrecciaSinistra(3, 5, 7);
			System.out.println("Costruttore cn tutti i parametri:");
			System.out.println(a2);
			System.out.println();
			System.out.println("===============================");

			FrecciaSinistra a3 = new FrecciaSinistra(9, 11);
			System.out.println("Costruttore con larghezza punta e lunghezza coda:");
			System.out.println(a3);
			System.out.println();
			System.out.println("===============================");

			System.out.println("Cambio il valore dello scostamento da 0 a 1:");
			System.out.println();
			System.out.println("Prima:");
			System.out.println(a1);
			System.out.println();
			a1.setScostamento(1);
			System.out.println("Dopo:");
			System.out.println(a1);
			System.out.println();
			System.out.println("===============================");

			System.out.println("Cambio il valore della lunghezza coda da 0 a 2:");
			System.out.println();
			System.out.println("Prima:");
			System.out.println(a1);
			System.out.println();
			a1.setLunghezzaCoda(2);
			System.out.println("Dopo:");
			System.out.println(a1);
			System.out.println();
			System.out.println("===============================");

			System.out.println("Cambio il valore della larghezza della punta da 3 a 10:");
			System.out.println("Dovrebbe cambiare a 11 per essere dispari.");
			System.out.println();
			System.out.println("Prima:");
			System.out.println(a1);
			System.out.println();
			a1.setLarghezzaPunta(10);
			System.out.println("Dopo:");
			System.out.println(a1);
			System.out.println();
			System.out.println("===============================");

			System.out.println();
			System.out.println("RESET a");
			System.out.println("Scostamento = 0, lunghezza coda = 3, larghezza punta = 5:");
			// passa a 7 automaticamente
			a1.set(0, 3, 5);
			System.out.println(a1);
			System.out.println();
			a1.disegnaQui();
			System.out.println();
			System.out.println("===============================");

			System.out.println();
			System.out.println("RESET a");
			System.out.println("Scostamento = 1, lunghezza coda = 4, larghezza punta = 7:");
			a1.set(1, 4, 7);
			System.out.println(a1);
			System.out.println();
			a1.disegnaQui();
			System.out.println();
			System.out.println("===============================");

			System.out.println();
			System.out.println("RESET a");
			System.out.println("Scostamento = 3, lunghezza coda = 5, larghezza punta = 6:");
			// passa a 7 automaticamente
			a1.set(3, 5, 6);
			System.out.println(a1);
			System.out.println();
			a1.disegnaQui();
			System.out.println();
			System.out.println("===============================");

			System.out.println();
			System.out.println("I valori della freccia sono:");
			System.out.println(a1);
			System.out.println();
			System.out.print("Questa freccia dovrebbe visualizzare 5 linee ");
			a1.disegnaDa(5);
			System.out.println();
			System.out.println("===============================");

			System.out.println("Ripetere? (S per si, o N per No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 's') || (ripeti == 'S'));
	}
}
