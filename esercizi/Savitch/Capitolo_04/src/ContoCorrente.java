import java.util.*;

public class ContoCorrente {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		double saldoIniziale;
		double tassoInteresse;
		double nuovoSaldo; // dopo 10 anni
		char risposta; // sentinella per ripetere o terminare il programma
		int iterazione; // contatore di iterazione

		do { // ripeti il programma se l'utente dice si
			System.out.println("Inserisci un saldo iniziale (euro.centesimi) ");
			saldoIniziale = tastiera.nextDouble();
			System.out.println("Inserisci un tasso di interesse (e.g. 5.25):");
			tassoInteresse = tastiera.nextDouble();

			// Visualizza le informazioni immesse
			System.out.println("In dieci anni un saldo iniziale di Euro " + saldoIniziale);
			System.out.println("ad un tasso di interesse di " + tassoInteresse + "% varra'");

			nuovoSaldo = saldoIniziale;
			// inizializza prima di eseguire il ciclo del calcolo annuale
			for (iterazione = 1; iterazione <= 10; ++iterazione) // calcolo annuale
				nuovoSaldo = nuovoSaldo + (tassoInteresse / 100) * nuovoSaldo;
			System.out.println("Euro " + nuovoSaldo + " calcolato annualmente");

			nuovoSaldo = saldoIniziale;
			// inizializza prima di entarre nel ciclo mensile
			for (iterazione = 1; iterazione <= 120; ++iterazione) // calcola mensilmente
				nuovoSaldo = nuovoSaldo + (tassoInteresse / 12) * (nuovoSaldo / 100);
			System.out.println("Euro " + nuovoSaldo + " calcolato mensilmente");

			nuovoSaldo = saldoIniziale;
			// inizializza prima di intrare nel ciclo giornaliero
			for (iterazione = 1; iterazione <= 3650; ++iterazione) // Calcolo giornaliero
				nuovoSaldo = nuovoSaldo + (tassoInteresse / 365) * (nuovoSaldo / 100);
			System.out.println("Euro " + nuovoSaldo + " calcolato giornalmente");

			System.out.println(""); //linea vuoti per leggibilita'
			System.out.println("Vuoi farlo ancorea?");
			System.out.println("Inserisci s per si, n per no.");
			risposta = tastiera.next().charAt(0);
		} while ((risposta == 's') || (risposta == 'S'));
	}
}
