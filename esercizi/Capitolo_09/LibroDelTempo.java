/**
Classe che registra il tempo impiegato da ognuno dei
dipendenti di un’azienda durante una settimana di cinque giorni.
Un esempio di applicazione e’ nel metodo main.
*/
public class LibroDelTempo {
	private int numeroDiDipendenti;
	private int[][] ore;            //ore[i][j] contiene le ore
                                    //del dipendente j al giorno i.
	private int[] oreSettimana;     //oreSettimana[i] contiene le ore settimanali               	                                
									//in cui ha lavorato il dipendente i+1.
	private int[] oreGiorno;        //oreGiorno[i] contiene le ore totali in cui
                	                //hanno lavorato i dipendenti nel giorno i
	private static final int NUMERO_GIORNI_LAVORATIVI = 5;
	private static final int LUN = 0;
	private static final int MAR = 1;
	private static final int MER = 2;
	private static final int GIO = 3;
	private static final int VEN = 4;

	public LibroDelTempo(int ilNumeroDiDipendenti) {
		numeroDiDipendenti = ilNumeroDiDipendenti;
		ore = new int[NUMERO_GIORNI_LAVORATIVI][numeroDiDipendenti];
		oreSettimana = new int[numeroDiDipendenti];
		oreGiorno = new int[NUMERO_GIORNI_LAVORATIVI];
	}

	public void setOre() { //Questo e’ un prototipo.
		ore[0][0] = 8; ore[0][1] = 0; ore[0][2] = 9;
		ore[1][0] = 8; ore[1][1] = 0; ore[1][2] = 9;
		ore[2][0] = 8; ore[2][1] = 8; ore[2][2] = 8;
		ore[3][0] = 8; ore[3][1] = 8; ore[3][2] = 4;
		ore[4][0] = 8; ore[4][1] = 8; ore[4][2] = 8;
	}

	public void aggiorna() {
		calcolaOreSettimana();
		calcolaOreGiorno();
	}

	private void calcolaOreSettimana() {
		for (int numeroDipendente = 1; numeroDipendente <= numeroDiDipendenti; numeroDipendente ++) {//Elabora un dipendente:
			int somma = 0;

			for (int giorno = LUN; giorno <= VEN; giorno++)
				somma = somma + ore[giorno][numeroDipendente - 1];
			//somma contiene la somma di tutte le ore lavorate in una
			//settimana dal dipendente con numero numeroDipendente.
			oreSettimana[numeroDipendente - 1] = somma;
		}
	}

	private void calcolaOreGiorno() {
		for (int giorno = LUN; giorno <= VEN; giorno++) {
			//Elabora un giorno (per tutti i dipendenti):
			int somma = 0;
			for (int numeroDipendente = 1; numeroDipendente <= numeroDiDipendenti; numeroDipendente++)
				somma = somma + ore[giorno][numeroDipendente - 1];
				//somma contiene la somma di tutte le ore lavorate da
				//tutti i dipendenti in un giorno.
			oreGiorno[giorno] = somma;
		}
	}

	public void visualizzaTabella() {
		// intestazione
		System.out.print("Dipendente ");

		for (int numeroDipendente = 1; numeroDipendente <= numeroDiDipendenti; numeroDipendente++)
			System.out.print(numeroDipendente + " ");

		System.out.println("Totali");
		System.out.println();

		// valori riga
		for (int giorno = LUN; giorno <= VEN; giorno++) {
			System.out.print(getNomeGiorno(giorno) + " ");
			for (int colonna = 0; colonna < ore[giorno].length; colonna++)
				System.out.print(ore[giorno][colonna] + " ");
			System.out.println(oreGiorno[giorno]);
		}

		System.out.println();
		System.out.print("Totale = ");

		for (int colonna = 0; colonna < numeroDiDipendenti; colonna++)
			System.out.print(oreSettimana[colonna] + " ");

		System.out.println();
	}

	//Converte 0 in "Lunedi’", 1 in "Martedi’",ecc.
	//Gli spazi sono inseriti per avere tutte le stringhe della stessa lunghezza.
	private String getNomeGiorno(int giorno) {
		String nomeGiorno = null;

		switch (giorno) {
			case LUN:
				nomeGiorno = "Lunedi’   ";
				break;
			case MAR:
				nomeGiorno = "Martedi’  ";
				break;
			case MER:
				nomeGiorno = "Mercoledi’";
				break;
			case GIO:
				nomeGiorno = "Giovedi’  ";
				break;
			case VEN:
				nomeGiorno = "Venerdi’  ";
				break;
			default:
				System.out.println("Errore Fatale.");
				System.exit(0);
				break;
		}

		return nomeGiorno;
	}

	/**
	Legge le ore lavorate da ogni dipendente in ogni giorno della
	settimana lavorativa nell’array bi-dimensionale delle ore. (Il metodo
	per l’input e’ solo una bozza in questa versione preliminare.)
	Computa il totale delle ore settimanali per ogni dipendente e
	il totale delle ore giornaliere per tutti i dipendenti.
	*/
	public static void main(String[] args) {
		final int NUMERO_DI_DIPENDENTI = 3;
		LibroDelTempo libro = new LibroDelTempo(NUMERO_DI_DIPENDENTI);
		libro.setOre();
		libro.aggiorna();
		libro.visualizzaTabella();
	}
}
