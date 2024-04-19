import java.util.*;

public class ConversioneTemperature {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		char uscita = 'n'; 		// variabile di controllo del ciclo
								// - impostata a n per entrare nel ciclo
								// - ciclo ripetuto a meno che non sia impostata a 'E' o 'e'
		double gradi; 			// inseriti dall'utente
		double gradiConvertiti; 	// convertiti
		char unita; 				// inserito dall'utente: 'F' or 'f' per Fahrenheit
								// oppure 'C' or 'c' per Celsius

		while (uscita != 'E' && uscita != 'e') {
			System.out.println(); // Linee bianche per leggibilita'
			System.out.println();
			System.out.println("Inserisci una temperatura in gradi (ad esempio 29.6): ");
			gradi = tastiera.nextDouble();

			System.out.println();
			System.out.println("Inserisci 'F' (o 'f') per Fahrenheit o " + "'C' (o 'c') per Celsius: ");

			unita = tastiera.next().charAt(0);
			System.out.println();

			switch (unita) {
			case 'F':
			case 'f':
				gradiConvertiti = 5 * (gradi - 32) / 9;
				System.out.println(gradi + " gradi F = " + gradiConvertiti + " gradi Celsius.");
				break;

			case 'C':
			case 'c':
				gradiConvertiti = gradi * 9 / 5 + 32;
				System.out.println(gradi + " gradi C = " + gradiConvertiti + " gradi Fahrenheit.");
				break;
			default:
				System.out.println("Unita' sconosciuta -");
				System.out.println("  cnon riesco a fare la conversione -");
				System.out.println("  la prossima volta inserisci " + "'F' per Fahrenheit o 'C' for Celsius.");
			} // fine switch
			
			System.out.println();
            System.out.println("Inserisci 'E' per uscire o un qualsiasi altro carattere per continuare");
            uscita = tastiera.next().charAt(0);
		}
	}
}
