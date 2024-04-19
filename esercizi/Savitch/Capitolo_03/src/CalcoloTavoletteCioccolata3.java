import java.util.Scanner;

public class CalcoloTavoletteCioccolata3 {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int eta;
		int peso;
		int altezza;
		String uomoODonna;
		String attivita;

		System.out.println("Questo programma calcola il numro di barrette di cioccalata da 230 Kcal ");
		System.out.println("cche si possono mangaier per mantenere il proprio peso.");
		System.out.println("Qual e' la tua eta' in anni?");
		eta = tastiera.nextInt();
		System.out.println("Qual e' la tua altezza in cm?"); 
		altezza = tastiera.nextInt();
		System.out.println("qual e' il tuo peso in kg?"); 
		peso = tastiera.nextInt();
		System.out.println("Inserisci 'U' per uomo o 'D' per donna.");
		uomoODonna = tastiera.next();

		System.out.println("Sei:");
		System.out.println("A. Sedentario");
		System.out.println("B. Moderatamente attivo (svolge attivita' fisica occasionalmente)");
		System.out.println("C. Attivo (svolge attivita' fisica 3-4 volte alla settimana)");
		System.out.println("D. Molto attivo (svolge attivita' fisica tutti i giorni)");
		System.out.println("Inserisci A,B,C, o D.");
		attivita = tastiera.next();

		double calorie;
		String sesso="";  // Variabile per il sesso cosi' cosi' si usa una sola istruzione dell'aoutput finale

		if (uomoODonna.equals("U")) {
			calorie = 66 + (13.8 * peso) + (5.0 * altezza) - (6.8 * eta);
			sesso = "uomo";
		} else if (uomoODonna.equals("D")) {
			calorie = 655 + (9.6 * peso) + (1.8 * altezza) - (4.7 * eta);
			sesso = "donna";
		} else {
			System.out.println("Input errato per il sesso.");
			return;
		}

		// Aggiusta le calorie sulal base dell'attivita' fisica svolta
		if (attivita.equals("A"))
			calorie *= 1.2;
		else if (attivita.equals("B"))
			calorie *= 1.3;
		else if (attivita.equals("C"))
			calorie *= 1.4;
		else if (attivita.equals("D"))
			calorie *= 1.5;

		System.out.println("Un/a " + sesso + " con i valori inseriti dovrebbe mangiare " + (calorie / 230)
				+ " barrette di cioccalata da 230 Kcal al giorno per mantenere il suo peso.");
	}
}