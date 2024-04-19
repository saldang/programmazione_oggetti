
/**
 File name: TicTacToe.java

 A class to play TicTacToe.

 Entries cannot be changed once they are entered.

 Written by: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/2/00
 Changes: 03/13/2003 Made comments like text examples.
                     Added code to display board after win and draw.
 Updated for fourth edition by Brian Durney, December 2004

 */
import java.util.*;

public class GiocoDelTris {
	// usa un array 3 X 3 per il tabellone.
	private static char[][] tabellone = new char[3][3];
	private static char turno;
	private static int riga; 
	private static int colonna;
	private static int rigaImmessaDaGiocatore; 
	private static int colonnaImmessaDaGiocatore; 
	private static boolean erroreDiImmissionePosizione;
	private static boolean altraPartita = true;
	private static char ripeti; // ripete la partita
	private static int conteggio = 0; // Il gioco termina quando il tabellone è pieno (conteggio 0 9)

	private static void scriviTabellone() {
		System.out.println("-----------------");
		System.out.println("|R\\C| 1 | 2 | 3 |");
		System.out.println("-----------------");
		for (riga = 0; riga < 3; ++riga) {
			System.out.println(
					"| " + (riga + 1) + " | " + tabellone[riga][0] + " | " + tabellone[riga][1] + " | " + tabellone[riga][2] + " |");
			System.out.println("-----------------");
		}
	}

	private static void getMossa() {
		erroreDiImmissionePosizione = true; // Cambiera' in false se vengono inserite una riga ed una coonna corrette 
		Scanner tastiera = new Scanner(System.in);

		while (erroreDiImmissionePosizione) {
			System.out.println();
			System.out.println("Turno di " + turno + ".");
			System.out.println("Dove vuoi che venga posto " + turno + "?");
			System.out.println("Inserisci un numero di riga e uno di colonna separati da uno spazio.");
			System.out.println();

			rigaImmessaDaGiocatore = tastiera.nextInt();
			colonnaImmessaDaGiocatore = tastiera.nextInt();
			System.out.println("Hai inserito la riga #" + rigaImmessaDaGiocatore + " e la colonna  #" + colonnaImmessaDaGiocatore);

			// Verifica se i valori sono corretti (1, 2, o 3)
			if (rigaImmessaDaGiocatore < 1 || rigaImmessaDaGiocatore > 3 || colonnaImmessaDaGiocatore < 1 || colonnaImmessaDaGiocatore > 3) {
				System.out.println("Valori errati: Riga e colonna devono essere tra 1 e 3.");
			}

			// Verifica se la posizione non e' gia' occupata
			// Aggiusta rigaImmessaDaGiocatore e colonnaImmessaDaGiocatore in modo da inserirle nell'array che parte da 0
			else if (tabellone[rigaImmessaDaGiocatore - 1][colonnaImmessaDaGiocatore - 1] == 'X' || tabellone[rigaImmessaDaGiocatore - 1][colonnaImmessaDaGiocatore - 1] == 'O') {
				System.out.println("La cella e' gia' occupata: seleziona un'altra cella.");
			}

			// Cella valida
			else {
				erroreDiImmissionePosizione = false;
				System.out.println("Grazie per la selezione.");
				tabellone[rigaImmessaDaGiocatore - 1][colonnaImmessaDaGiocatore - 1] = turno;
				++conteggio;
			}
		}
	}

	private static boolean vincitore() {
		// Controllo righe
		for (riga = 0; riga < 3; ++riga) {
			if (tabellone[riga][0] == turno) {
				if (tabellone[riga][1] == turno) {
					if (tabellone[riga][2] == turno) {
						System.out.println();
						System.out.println(turno + " VINCE!!!");
						scriviTabellone();
						return true;
					}
				}
			}
		}

		// Controllo colonne
		for (colonna = 0; colonna < 3; ++colonna) {
			if (tabellone[0][colonna] == turno) {
				if (tabellone[1][colonna] == turno) {
					if (tabellone[2][colonna] == turno) {
						System.out.println();
						System.out.println(turno + " VINCE!!!");
						scriviTabellone();
						return true;
					}
				}
			}
		}

		// Controllo diagonale
		if (tabellone[0][0] == turno) {
			if (tabellone[1][1] == turno) {
				if (tabellone[2][2] == turno) {
					System.out.println();
					System.out.println(turno + " VINCE!!!");
					scriviTabellone();
					return true;
				}
			}
		}
		if (tabellone[0][2] == turno) {
			if (tabellone[1][1] == turno) {
				if (tabellone[2][0] == turno) {
					System.out.println();
					System.out.println(turno + " VINCER!!!");
					scriviTabellone();
					return true;
				}
			}
		}

		//Le righe seguenti sono eseguite solo se non c'e' un vincitore
		
		// Fine del gioco se il tabellone e' pieno
		if (conteggio >= 9) {
			System.out.println();
			System.out.println("Nessun vincitore e il tabellone e' pieno.");
			scriviTabellone();
			return true;
		} else { // Turno prossimo giocatore
			if (turno == 'X')
				turno = 'O';
			else
				turno = 'X';
			return false;
		}
	}

	private static void nuovaPartita() {
		System.out.println();
		System.out.println("Nuova partita: X inizia prima.");
		turno = 'O'; // Il turno cambia a X quando viene invocato vincitore()

		// Pulisci il tabellone
		for (riga = 0; riga < 3; ++riga) {
			for (colonna = 0; colonna < 3; ++colonna)
				tabellone[riga][colonna] = ' ';
		}
		conteggio = 0;
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		while (altraPartita) {
			nuovaPartita();

			while (!vincitore()) {
				scriviTabellone();
				getMossa();
			}

			System.out.println("Un'altra partita? (S/s per si)");
			ripeti = tastiera.next().charAt(0);
			if (ripeti == 's' || ripeti == 'S')
				altraPartita = true;
			else
				altraPartita = false;
		}
	}
}
