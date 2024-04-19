import java.util.Scanner;

/**
 * Classe che registra il tempo impiegato da ognuno dei dipendenti di un'azienda
 * durante una settimana di cinque giorni. Un esempio di applicazione e' nel
 * metodo main.
 */
public class LibroDelTempo {
	private int numeroDiDipendenti;
	private int[][] ore; // ore[i][j] contiene le ore
	// del dipendente j al giorno i.
	private int[] oreSettimana; // oreSettimana[i] contiene le ore settimanali
	// in cui ha lavorato il dipendente i+1.
	private int[] oreGiorno; // oreGiorno[i] contiene le ore totali in cui
	// hanno lavorato i dipendenti nel giorno i
	private static final int NUMERO_GIORNI_LAVORATIVI = 5;
	private static final int LUN = 0;
	private static final int MAR = 1;
	private static final int MER = 2;
	private static final int GIO = 3;
	private static final int VEN = 4;

	
	// Costruttore di default. Imposta il numero di dipendenti ad 1
	public LibroDelTempo() {
		numeroDiDipendenti = 1;
		ore = new int[NUMERO_GIORNI_LAVORATIVI][numeroDiDipendenti];
		oreSettimana = new int[numeroDiDipendenti];
		oreGiorno = new int[NUMERO_GIORNI_LAVORATIVI];
	}

	// Constructor con il numero di dipendenti specificato
	public LibroDelTempo(int ilNumeroDiDipendenti) {
		numeroDiDipendenti = ilNumeroDiDipendenti;
		ore = new int[NUMERO_GIORNI_LAVORATIVI][numeroDiDipendenti];
		oreSettimana = new int[numeroDiDipendenti];
		oreGiorno = new int[NUMERO_GIORNI_LAVORATIVI];
	}
	
	
	// Usato per verificare  il costruttore di default
	public void getOre() {
		ore[0][0] = 1;
		ore[1][0] = 2;
		ore[2][0] = 3;
		ore[3][0] = 4;
		ore[4][0] = 5;
	}

	/**
	 * Metodi di set 
	 */

	// setOre e' overlodato: la versione senza parametri interagisce con l'utente per 
	// inserire le ore per ogni impiegato per tutti e 5 giorni della settimana 
	public void setOre() {
		Scanner tastiera = new Scanner(System.in);
		// Il ciclo esterno itera sui giorni della settimana
		// Il ciclo interno sui dipendenti
		for (int i = 0; i < NUMERO_GIORNI_LAVORATIVI; i++) {
			System.out.println("Inserisci le ore per " + getNomeGiorno(i) + ":");
			for (int j = 0; j < numeroDiDipendenti; j++) {// per ogni dipendente
				System.out.println("Ore per il dipendente #" + (j + 1) + " = ");
				ore[i][j] = tastiera.nextInt();
			}
		}
	}

	// Questa versione del metodo imposta le ore di un dipendente per un giorno della settimana
	public void setOre(int giornoDellaSettimana, int numeroDipendente, int oreLavorate) {
		ore[giornoDellaSettimana][numeroDipendente - 1] = oreLavorate;
	}

	public void setOreDipendentePerGiorno(int giornoDellaSettimana) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisi le ore per il giorno " + getNomeGiorno(giornoDellaSettimana));
		for (int i = 0; i < numeroDiDipendenti; i++) {
			System.out.println("Ore per il dipendente #" + (i + 1) + " = ");
			ore[giornoDellaSettimana][i] = tastiera.nextInt();
		}
	}

	public void setOrePerDipendente(int dipendenteNumero) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Ore giornaliere per il dipendente #" + (dipendenteNumero));
		for (int i = 0; i < NUMERO_GIORNI_LAVORATIVI; i++) {
			System.out.println("Inserisi le ore per il giorno " + getNomeGiorno(i));
			ore[i][dipendenteNumero - 1] = tastiera.nextInt();
		}
	}

	/**
	 * Metodi get per ottenere i valori (di ritorno) delle variabili 
	 * (incluse le variabili dell'array indicizzato)
	 */

	public int getNumeroDiDipendenti() {
		return numeroDiDipendenti;
	}

	public int getOreGiornoPerDipendente(int giornoSettimana, int numeroDipendente) {
		return (ore[giornoSettimana][numeroDipendente - 1]);
	}

	// Ore settimanali per ciascun dipendente
	public int getOreSettimana(int numeroDipendente) {
		calcolaOreSettimana();
		return (oreSettimana[numeroDipendente - 1]);
	}

	// Totale ore dipendenti per ogni giorno
	// 0 per lunedi' fino a 4 per Venerdi
	public int getOreGiorno(int giornoDellaSettimana) {
		calcolaOreGiorno();
		return (oreGiorno[giornoDellaSettimana]);
	}

	public void aggiorna() {
		calcolaOreSettimana();
		calcolaOreGiorno();
	}

	private void calcolaOreSettimana() {
		for (int numeroDipendente = 1; numeroDipendente <= numeroDiDipendenti; numeroDipendente++) {// Elabora un
			// dipendente:
			int somma = 0;

			for (int giorno = LUN; giorno <= VEN; giorno++)
				somma = somma + ore[giorno][numeroDipendente - 1];
			// somma contiene la somma di tutte le ore lavorate in una
			// settimana dal dipendente con numero numeroDipendente.
			oreSettimana[numeroDipendente - 1] = somma;
		}
	}

	private void calcolaOreGiorno() {
		for (int giorno = LUN; giorno <= VEN; giorno++) {
			// Elabora un giorno (per tutti i dipendenti):
			int somma = 0;
			for (int numeroDipendente = 1; numeroDipendente <= numeroDiDipendenti; numeroDipendente++)
				somma = somma + ore[giorno][numeroDipendente - 1];
			// somma contiene la somma di tutte le ore lavorate da
			// tutti i dipendenti in un giorno.
			oreGiorno[giorno] = somma;
		}
	}

	public void visualizzaTabella() {
		int riga, colonna;
		System.out.print("Dipendente");
		for (colonna = 0; colonna < numeroDiDipendenti; colonna++)
			mostraIntInCampo(colonna + 1, 4);
		System.out.println("   totali");
		System.out.println();

		for (riga = 0; riga < NUMERO_GIORNI_LAVORATIVI; riga++) {
			System.out.print(getNomeGiorno(riga));
			for (int i = 0; i < 9 - getNomeGiorno(riga).length(); i++)
				System.out.print(" ");
			for (colonna = 0; colonna < ore[riga].length; colonna++)
				mostraIntInCampo(ore[riga][colonna], 4);
			mostraIntInCampo(oreGiorno[riga], 6);
			System.out.println("");
		}
		System.out.println();

		System.out.print("Totale  = ");
		for (colonna = 0; colonna < numeroDiDipendenti; colonna++)
			mostraIntInCampo(oreSettimana[colonna], 4);
		System.out.println();
	}

	// Mostra n in un campo di numeroCaratteri caratteri
	private void mostraIntInCampo(int n, int numeroCaratteri) {
		String nString = Integer.toString(n);
		for (int i = 0; i < (numeroCaratteri - nString.length()); i++)
			System.out.print(" ");// Riempie con spazi bianchi
		System.out.print(nString);
	}

	// Converte 0 in "Lunedi'", 1 in "Martedi'",ecc.
	// Gli spazi sono inseriti per avere tutte le stringhe della stessa lunghezza.
	private String getNomeGiorno(int giorno) {
		String nomeGiorno = null;

		switch (giorno) {
		case LUN:
			nomeGiorno = "Lunedi'   ";
			break;
		case MAR:
			nomeGiorno = "Martedi'  ";
			break;
		case MER:
			nomeGiorno = "Mercoledi'";
			break;
		case GIO:
			nomeGiorno = "Giovedi'  ";
			break;
		case VEN:
			nomeGiorno = "Venerdi'  ";
			break;
		default:
			System.out.println("Errore Fatale.");
			System.exit(0);
			break;
		}
		return nomeGiorno;
	}

	/**
	 * Legge le ore lavorate da ogni dipendente in ogni giorno della settimana
	 * lavorativa nell'array bi-dimensionale delle ore. (Il metodo per l'input e'
	 * solo una bozza in questa versione preliminare.) Computa il totale delle ore
	 * settimanali per ogni dipendente e il totale delle ore giornaliere per tutti i
	 * dipendenti.
	 */
	public static void main(String[] args) {
		final int NUMERO_DI_DIPENDENTI = 3;
		LibroDelTempo libro = new LibroDelTempo(NUMERO_DI_DIPENDENTI);
		libro.setOre();
		libro.aggiorna();
		libro.visualizzaTabella();
	}
}
