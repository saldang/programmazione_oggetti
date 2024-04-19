import java.util.*;

public class ContoCorrente2Troncato {
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
			System.out.println("In dieci anni un saldo iniziale di ");
			FormattaEuroTroncato.scriviRiga(saldoIniziale);
			System.out.println("ad un tasso di interesse di " + tassoInteresse + "% varra'");

			// Calcolo annuale
			nuovoSaldo = saldoIniziale;
			for (iterazione = 1; iterazione <= 10; ++iterazione) // calcolo annuale				
				nuovoSaldo = nuovoSaldo + (tassoInteresse / 100) * nuovoSaldo;
			FormattaEuroTroncato.scrivi(nuovoSaldo);
			System.out.println(" calcolato annualmente");

			// Monthly computation
			nuovoSaldo = saldoIniziale;
			for (iterazione = 1; iterazione <= 120; ++iterazione) // calcolo mensile
				nuovoSaldo = nuovoSaldo + (tassoInteresse / 12) * (nuovoSaldo / 100);
			FormattaEuroTroncato.scrivi(nuovoSaldo);
			System.out.println(" calcolato mensilmente");

			// Calcolo giornaliero
			nuovoSaldo = saldoIniziale;
			for (iterazione = 1; iterazione <= 3650; ++iterazione) // calcolo giornaliero
				nuovoSaldo = nuovoSaldo +  (tassoInteresse / 365) * (nuovoSaldo / 100);
			FormattaEuroTroncato.scrivi(nuovoSaldo);
			System.out.println(" calcolato giornalmente");

			System.out.println(""); //linea vuoti per leggibilita'
			System.out.println("Vuoi farlo ancorea?");
			System.out.println("Inserisci s per si, n per no.");
			risposta = tastiera.next().charAt(0);
		} while ((risposta == 's') || (risposta == 'S'));
	}
}
