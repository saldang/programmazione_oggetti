import java.util.*;

public class ContoCorrente2 {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		double saldoIniziale;
		double tassoInteresse;
		double nuovoSaldo; // dopo 10 anni
		char risposta; // sentinella per ripetere o terminare il programma
		int iterazione; // contatore di iterazione

		do { // ripeti il programma se l'utente dice si
			System.out.println("Inserisci un saldo iniziale (euro.centesimi) ");
			// Legge il saldo e lo converte in centesimi
			saldoIniziale = (int) (tastiera.nextDouble() * 100 + 0.5);

			System.out.println("Inserisci un tasso di interesse (e.g. 5.25):");
			tassoInteresse = tastiera.nextDouble();

			// Visualizza le informazioni immesse
			System.out.println("In dieci anni un saldo iniziale di centesimi " + saldoIniziale);
			System.out.println("ad un tasso di interesse di " + tassoInteresse + "% varra'");

			// Calcolo annuale
			nuovoSaldo = saldoIniziale;
			for (iterazione = 1; iterazione <= 10; ++iterazione) // calcolo annuale
				// divide per 100 since perche' l'interesse e' %,
				// aggiunge 0.5 e converte a int per arrotondare
				nuovoSaldo = nuovoSaldo + (int) ((tassoInteresse / 100) * nuovoSaldo + 0.5);
			// divide per 100 e converte a double per stampare euro.centesimi
			System.out.println("Euro " + (double) nuovoSaldo / 100 + " calcolato annualmente");

			// Monthly computation
			nuovoSaldo = saldoIniziale;
			for (iterazione = 1; iterazione <= 120; ++iterazione) // calcolo mensile
				// divide per 12 per convertire il tasso a tasso mensile
				// divide per 100 since perche' l'interesse e' %,
				// aggiunge 0.5 e converte a int per arrotondare
				nuovoSaldo = nuovoSaldo + (int) ((tassoInteresse / 12) * (nuovoSaldo / 100) + 0.5);
			// divide per 100 e converte a double per stampare euro.centesimi
			System.out.println("Euro " + (double) nuovoSaldo / 100 + " calcolato mensilmente");

			// Calcolo giornaliero
			nuovoSaldo = saldoIniziale;
			for (iterazione = 1; iterazione <= 3650; ++iterazione) // calcolo giornaliero
				// divide per 365 per convertire il tasso a tasso giornaliero
				// divide per 100 since perche' l'interesse e' %,
				// aggiunge 0.5 e converte a int per arrotondare
				nuovoSaldo = nuovoSaldo + (int) ((tassoInteresse / 365) * ((float) nuovoSaldo / 100) + 0.5);
			// divide per 100 e converte a double per stampare euro.centesimi
			System.out.println("Euro " + (double) nuovoSaldo / 100 + " calcolato giornalmente");

			System.out.println(""); //linea vuoti per leggibilita'
			System.out.println("Vuoi farlo ancorea?");
			System.out.println("Inserisci s per si, n per no.");
			risposta = tastiera.next().charAt(0);
		} while ((risposta == 's') || (risposta == 'S'));
	}
}
