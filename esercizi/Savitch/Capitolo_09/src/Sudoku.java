import java.util.Scanner;

public class Sudoku {
	private int scacchiera[][];
	private int inizio[][];

	/**
	 * Crea una nuova istanza di Sudoku
	 */
	public Sudoku() {
		inizio = new int[9][9];
		scacchiera = new int[9][9];
	}

	public String toString() {
		String puzzleString = "Row/Col\n   1  2  3  4  5  6  7  8  9\n";
		puzzleString = puzzleString + "  --------------------------\n";
		for (int i = 0; i < 9; i++) {
			puzzleString = puzzleString + (i + 1) + " |";
			for (int j = 0; j < 9; j++) {
				if (scacchiera[i][j] == 0)
					puzzleString = puzzleString + ".  ";
				else
					puzzleString = puzzleString + scacchiera[i][j] + "  ";
			}
			puzzleString = puzzleString + "\n";
		}
		return puzzleString;
	}

	public void aggiungiaIniziali(int riga, int colonna, int valore) {
		if (riga >= 0 && riga <= 9 && colonna >= 0 && colonna <= 9 && valore >= 1 && valore <= 9) {
			inizio[riga][colonna] = valore;
			scacchiera[riga][colonna] = valore;
		}
	}

	public void aggiungiMossa(int riga, int colonna, int valore) {
		// assegna solo se e' 0
		if (riga >= 0 && riga <= 9 && colonna >= 0 && colonna <= 9 && valore >= 1 && valore <= 9
				&& inizio[riga][colonna] == 0) {
			scacchiera[riga][colonna] = valore;
		}
	}

	public int getValoreIn(int riga, int colonna) {
		return scacchiera[riga][colonna];
	}

	public void reset() {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				scacchiera[i][j] = inizio[i][j];
	}

	public boolean pieno() {
		boolean terminato = true;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				terminato = terminato && scacchiera[i][j] > 0;

				return terminato;
	}

	public boolean[] getValoriValidi(int riga, int colonna) {
		// Salva il valore nella cella e quindi prova tutti i 9 valori
		int valoreSalvato = scacchiera[riga][colonna];
		boolean risultato[] = new boolean[9];

		for (int value = 1; value <= 9; value++) {
			scacchiera[riga][colonna] = value;
			risultato[value - 1] = verificaGioco();
		}

		scacchiera[riga][colonna] = valoreSalvato;

		return risultato;
	}

	public boolean verificaGioco() {
		boolean ok = true;
		// verifica se i valori nella griglia sono validi;
		for (int i = 0; i < 9; i++) {
			ok = ok && controllaRiga(i);
			ok = ok && controllaColonna(i);
			ok = ok && checkSottoquadro(i);

		}
		return ok;
	}

	// Verifica che un numero compaia solo una volta nella riga
	private boolean controllaRiga(int riga) {
		int count[] = new int[10];
		for (int col = 0; col < 9; col++) {
			count[scacchiera[riga][col]]++;
		}

		boolean countIsOk = true;
		for (int i = 1; i <= 9; i++)
			countIsOk = countIsOk && (count[i] <= 1);

		return countIsOk;
	}

	// Verifica che un numero compaia solo una volta nella colonna
	private boolean controllaColonna(int colonna) {
		int count[] = new int[10];
		for (int row = 0; row < 9; row++) {
			count[scacchiera[row][colonna]]++;
		}

		boolean countIsOk = true;
		for (int i = 1; i <= 9; i++)
			countIsOk = countIsOk && (count[i] <= 1);

		return countIsOk;
	}

	// Verifica che un numero compaia solo una volta sottoquadro 3x3
	private boolean checkSottoquadro(int sottoquadro) {
		int count[] = new int[10];

		int rowBase = (sottoquadro / 3) * 3;
		int colBase = (sottoquadro % 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count[scacchiera[rowBase + i][colBase + j]]++;
			}
		}

		boolean countIsOk = true;
		for (int i = 1; i <= 9; i++)
			countIsOk = countIsOk && (count[i] <= 1);

		return countIsOk;
	}

	// Configura un sudoku
	public static void inizializza(Sudoku p) {
		p.aggiungiaIniziali(0, 0, 1);
		p.aggiungiaIniziali(0, 1, 2);
		p.aggiungiaIniziali(0, 2, 3);
		p.aggiungiaIniziali(0, 3, 4);
		p.aggiungiaIniziali(0, 4, 9);
		p.aggiungiaIniziali(0, 5, 7);
		p.aggiungiaIniziali(0, 6, 8);
		p.aggiungiaIniziali(0, 7, 6);
		p.aggiungiaIniziali(0, 8, 5);

		p.aggiungiaIniziali(1, 0, 4);
		p.aggiungiaIniziali(1, 1, 5);
		p.aggiungiaIniziali(1, 2, 9);

		p.aggiungiaIniziali(2, 0, 6);
		p.aggiungiaIniziali(2, 1, 7);
		p.aggiungiaIniziali(2, 2, 8);

		p.aggiungiaIniziali(3, 0, 3);
		p.aggiungiaIniziali(3, 4, 1);

		p.aggiungiaIniziali(4, 0, 2);

		p.aggiungiaIniziali(5, 0, 9);
		p.aggiungiaIniziali(5, 5, 5);

		p.aggiungiaIniziali(6, 0, 8);

		p.aggiungiaIniziali(7, 0, 7);

		p.aggiungiaIniziali(8, 0, 5);
		p.aggiungiaIniziali(8, 3, 9);

	}

	
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Gioco del Sudoku: ");

		Sudoku puzzle = new Sudoku();
		puzzle.inizializza(puzzle);
		
		System.out.print("Il gioco e': \n" + puzzle);

		boolean done = false;
		while (!done) {
			System.out.println("Cosa vuoi fare? \n"
					+ "Resettare(r) Imposta un valore (s) Visualizza valori ammissibili (v) Uscire (u) ");
			String response = tastiera.next();
			response = response.toLowerCase();

			if (response.equals("u")) {
				System.out.println("Grazie per aver giocato.");
				done = true;
			} else if (response.equals("s")) {
				System.out.println("Cella (riga 1-9 e colonna 1-9)?");
				int row = tastiera.nextInt() - 1;
				int col = tastiera.nextInt() - 1;
				System.out.println("Qual e' il valore?");
				int value = tastiera.nextInt();
				puzzle.aggiungiMossa(row, col, value);
			} else if (response.equals("v")) {
				System.out.println("Cella (riga 1-9 e colonna 1-9)?");
				int row = tastiera.nextInt() - 1;
				int col = tastiera.nextInt() - 1;
				boolean valid[] = puzzle.getValoriValidi(row, col);
				System.out.print("I valori amissibili sono: ");
				for (int i = 0; i < 9; i++) {
					if (valid[i])
						System.out.print((i + 1) + "  ");
				}
				System.out.println();

			} else if (response.equals("r")) {
				puzzle.reset();
			}

			System.out.print("Il puzzle e' adesso: \n" + puzzle);
			if (!puzzle.verificaGioco())
				System.out.println("Hai commesso un errore.");
			else if (puzzle.pieno())
				System.out.println("Congratulazioni: hai completato il puzzle.");
		}
	}
}
