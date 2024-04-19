import java.util.*;

public class ConvertitoreDate {
	private static String input; // Per rimuovere caratteri extra nel buffer
	private static int mese;
	private static int giorno;
	private static int posizoneSlash; // separatore mese giorno
	private static boolean inputValido; // flag che indica se convertire o meno
	private static char ripetere; 
	private static String junk; // controllo dello scroll

	private static String[] monthName = { "Gennaio", "Febbario", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto",
			"Settembre", "Ottobre", "Novembre", "Dicembre" };

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		do { // Ripeti se l'utente dice si
			try {
				// Crea un nuovo oggetto di tipo Scanner ad ogni iterazione
				// per evitare problemi tra il nextLine e gli altri metodi di Scanner
				tastiera = new Scanner(System.in);
				System.out.println("Inserisci una data nel formatol mese/giorno: ");
				input = tastiera.nextLine();
				// Elimina gli eventuali spazi bianchi
				input = input.trim();
				// Parsa la stringa per identificare il numero del mese che deve esesere tra 1 e 12
				mese = meseStringaToInt();
				if (mese < 0) {
					inputValido = false;
					throw new MeseException("Errore nel formato del mese.");
				} else if (mese < 1 || mese > 12) {
					inputValido = false;
					throw new MeseException(mese);
				} else { // Mese valido: parsa per il giorno
					giorno = giornoStringaToInt();
					controllaGiorno();
				}
			} 

			catch (MeseException e1) {
				System.out.println();
				System.out.println(e1.getMessage());
				System.out.println();
			}

			if (inputValido) {
				System.out.println(mese + "/" + giorno + " e' " + monthName[mese - 1] + " " + giorno);
			}

			System.out.println();
			System.out.println("Ripetere?(s/n)");
			ripetere = tastiera.next().charAt(0);

		} while ((ripetere == 's') || (ripetere == 'S'));
	}

	
	private static int meseStringaToInt() {
		// Cerca '/': deve essere il secondo o terzo carattere
		posizoneSlash = input.indexOf("/");
		if (posizoneSlash == 2) {
			return 10 * asciiToInt(input.charAt(0)) + asciiToInt(input.charAt(1));
		} else if (posizoneSlash == 1)
			return asciiToInt(input.charAt(0));
		else
			return -1; // Separatore mancante o non corretto
	}

	private static int giornoStringaToInt() {
		int charsInDay = input.length() - 1 - posizoneSlash;
		if (charsInDay == 2) {
			return 10 * asciiToInt(input.charAt(input.length() - 2)) + asciiToInt(input.charAt(input.length() - 1));
		} else if (charsInDay == 1)
			return asciiToInt(input.charAt(input.length() - 1));
		else
			return -1;
	}

	private static int asciiToInt(char digit) {
		switch (digit) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		default:
			inputValido = false;
			return -1;
		}
	}

	private static void controllaGiorno() {
		try {
			switch (mese) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (giorno < 1 || giorno > 31) {
					inputValido = false;
					System.out.println("Solo valori tra 1 e 31.");
					throw new GiornoException(mese);
				} else
					inputValido = true;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (giorno < 1 || giorno > 30) {
					inputValido = false;
					System.out.println("Solo valori tra 1 e 30.");
					throw new GiornoException(mese);
				} else
					inputValido = true;
				break;

			case 2:
				if (giorno < 1 || giorno > 29) {
					inputValido = false;
					System.out.println("Solo valori tra 1 e 29.");
					throw new GiornoException(mese);
				} else
					inputValido = true;
				break;
			default:
				inputValido = false;
				System.out.println("Mese non valido.");
				throw new GiornoException("Impossibile: mese non valido.");
			}
		} 

		catch (GiornoException e2) {
			System.out.println();
			System.out.println(e2.getMessage());
			System.out.println();
		}
	} 
}
