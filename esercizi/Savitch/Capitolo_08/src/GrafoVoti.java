
/**
Un oggetto di questa classe ha questi attributi:
numero di voti A, B, C, D e F.

Metodi pubblici
Impostare il numero di ogni voto individualmente o come gruppo.
Leggere il numero di ogni voto individualmente o in gruppo.
Indicare il numero di ogni voto.
Restituire il numero totale di voti.
Restituire la percentuale di ogni voto (un numero intero da 0 a 100).
Visualizzare un grafico del numero di ogni voto (stampando
una riga di asterischi proporzionale al numero di voti).

Precondizoni:
Per i metodi di sey: l'oggetto GrafoVoto è stato creato.
Per i metodi di get: i valori sono stati assegnati agli attributi.

Postcondizioni:
Metodi di set: uno o tutti i conteggi dei voti hanno assegnato un valore.
Metodi di get: valori visualizzati per uno o tutti gli attributi.
Metodo di visualizzazione: vengono visualizzate righe di asterischi proporzionali al numero
di ogni voto.
 */

import java.util.Scanner;

public class GrafoVoti {
	private int numeroA;
	private int numeroB;
	private int numeroC;
	private int numeroD;
	private int numeroF;
	private int numeroAsterischi;

	/**
	 * Metodi per impostare i valori agli attributi
	 */

	// In maniera interattiva asegna i valori a tutti gli attributi
	public void leggiInput() {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Quante A?");
		numeroA = tastiera.nextInt();
		while (numeroA < 0) {
			System.out.println("Il numero di A non puo' essere negativo.");
			System.out.println("Inserisci nuovamente ilnumero di A: ");
			numeroA = tastiera.nextInt();
		}

		System.out.println("Quante B?");
		numeroB = tastiera.nextInt();
		while (numeroB < 0) {
			System.out.println("Il numero di B non puo' essere negativo.");
			System.out.println("Inserisci nuovamente ilnumero di B: ");
			numeroB = tastiera.nextInt();
		}

		System.out.println("Quante C?");
		numeroC = tastiera.nextInt();
		while (numeroC < 0) {
			System.out.println("Il numero di C non puo' essere negativo.");
			System.out.println("Inserisci nuovamente ilnumero di C: ");
			numeroC = tastiera.nextInt();
		}

		System.out.println("Quante D?");
		numeroD = tastiera.nextInt();
		while (numeroD < 0) {
			System.out.println("Il numero di D non puo' essere negativo.");
			System.out.println("Inserisci nuovamente ilnumero di D: ");
			numeroD = tastiera.nextInt();
		}

		System.out.println("Quante F?");
		numeroF = tastiera.nextInt();
		while (numeroF < 0) {
			System.out.println("Il numero di F non puo' essere negativo.");
			System.out.println("Inserisci nuovamente ilnumero di F: ");
			numeroF = tastiera.nextInt();
		}
	}

	// Imposta i valori di tutti gli attributi non in maniera interattiva
	public void set(int nuovoNumeroA, int nuovoNumeroB, int nuovoNumeroC, int nuovoNumeroD, int nuovoNumeroF) {
		if (nuovoNumeroA >= 0)
			numeroA = nuovoNumeroA;
		else {
			System.out.println("Errore: il numero di A non puo' essere negativo.");
			System.exit(0);
		}

		if (nuovoNumeroB >= 0)
			numeroB = nuovoNumeroB;
		else {
			System.out.println("Errore: il numero di B non puo' essere negativo.");
			System.exit(0);
		}

		if (nuovoNumeroC >= 0)
			numeroC = nuovoNumeroC;
		else {
			System.out.println("Errore: il numero di C non puo' essere negativo.");
			System.exit(0);
		}

		if (nuovoNumeroD >= 0)
			numeroD = nuovoNumeroD;
		else {
			System.out.println("Errore: il numero di D non puo' essere negativo.");
			System.exit(0);
		}

		if (nuovoNumeroF >= 0)
			numeroF = nuovoNumeroF;
		else {
			System.out.println("Errore: il numero di F non puo' essere negativo.");
			System.exit(0);
		}

	}

	// Imposta i valori individualmente
	public void setNumeroA(int nuovoNumeroA) {
		if (nuovoNumeroA >= 0)
			numeroA = nuovoNumeroA;
		else {
			System.out.println("Errore: il numero di A non puo' essere negativo..");
			System.exit(0);
		}
	}

	public void setNumeroB(int nuovoNumeroB) {
		if (nuovoNumeroB >= 0)
			numeroB = nuovoNumeroB;
		else {
			System.out.println("Errore: il numero di B non puo' essere negativo..");
			System.exit(0);
		}
	}

	public void setNumeroC(int nuovoNumeroC) {
		if (nuovoNumeroC >= 0)
			numeroC = nuovoNumeroC;
		else {
			System.out.println("Errore: il numero di C non puo' essere negativo..");
			System.exit(0);
		}
	}

	public void setNumeroD(int nuovoNumeroD) {
		if (nuovoNumeroD >= 0)
			numeroD = nuovoNumeroD;
		else {
			System.out.println("Errore: il numero di D non puo' essere negativo..");
			System.exit(0);
		}
	}

	public void setNumeroF(int nuovoNumeroF) {
		if (nuovoNumeroF >= 0)
			numeroF = nuovoNumeroF;
		else {
			System.out.println("Errore: il numero di F non puo' essere negativo..");
			System.exit(0);
		}
	}

	/**
	 * Metodi per visualizzare i valori degli attributi
	 */
	public void stampa() {
		System.out.println("Numbero di A = " + numeroA);
		System.out.println("Numbero di B = " + numeroB);
		System.out.println("Numbero di C = " + numeroC);
		System.out.println("Numbero di D = " + numeroD);
		System.out.println("Numbero di F = " + numeroF);
	}

	public void stampaNumeroA() {
		System.out.println("Numbero di A = " + numeroA);
	}

	public void stampaNumeroB() {
		System.out.println("Numbero di B = " + numeroB);
	}

	public void stampaNumeroC() {
		System.out.println("Numbero di C = " + numeroC);
	}

	public void stampaNumeroD() {
		System.out.println("Numbero di D = " + numeroD);
	}

	public void stampaNumeroF() {
		System.out.println("Numbero di F = " + numeroF);
	}

	/**
	 * Metodi di get per gli attributi
	 */
	public int getNumeroA() {
		return numeroA;
	}

	public int getNumeroB() {
		return numeroB;
	}

	public int getNumeroC() {
		return numeroC;
	}

	public int getNumeroD() {
		return numeroD;
	}

	public int getNumeroF() {
		return numeroF;
	}

	/**
	 * Metodo che restituisce il numero di voti totali
	 */
	public int getNumeroTotaleVoti() {
		return (numeroA + numeroB + numeroC + numeroD + numeroF);
	}

	/**
	 * Metodi che restituiscono le percentali di ciascun voto
	 */
	public int getPercentualeA() {
		return (int) ((float) numeroA / this.getNumeroTotaleVoti() * 100 + 0.5);// arrotondamento
	}

	public int getPercentualeB() {
		return (int) ((float) numeroB / this.getNumeroTotaleVoti() * 100 + 0.5);// arrotondamento
	}

	public int getPercentualeC() {
		return (int) ((float) numeroC / this.getNumeroTotaleVoti() * 100 + 0.5);// arrotondamento
	}

	public int getPercentualeD() {
		return (int) ((float) numeroD / this.getNumeroTotaleVoti() * 100 + 0.5);// arrotondamento
	}

	public int getPercentualeF() {
		return (int) ((float) numeroF / this.getNumeroTotaleVoti() * 100 + 0.5);// arrotondamento
	}

	/**
	 * Metodo per disegnare un grafo del numero dei voti usando gli asterischi
	 * 
	 */
	public void disegna() {
		// Draw scale
		System.out.println("2   10   20   30   40   50" + "   60   70   80   90   100");
		System.out.println("|   |    |    |    |    |" + "    |    |    |    |    |");
		System.out.println("*************************" + "*************************");

		// Stampa una riga per ogni voto, da A a F
		// Ogni asterisco e' apri al 2%, quindi il numero di asterischi
		// da stampare e' pari alla percentuale del voto divisa per 2.
		// (dal momento che la parte frazionaria è 0 o 0,5, basta troncare)

		for (numeroAsterischi = 1; numeroAsterischi <= getPercentualeA() / 2; numeroAsterischi++) {
			System.out.print("*");
		}
		System.out.println(" A");

		for (numeroAsterischi = 1; numeroAsterischi <= getPercentualeB() / 2; numeroAsterischi++) {
			System.out.print("*");
		}
		System.out.println(" B");

		for (numeroAsterischi = 1; numeroAsterischi <= getPercentualeC() / 2; numeroAsterischi++) {
			System.out.print("*");
		}
		System.out.println(" C");

		for (numeroAsterischi = 1; numeroAsterischi <= getPercentualeD() / 2; numeroAsterischi++) {
			System.out.print("*");
		}
		System.out.println(" D");

		for (numeroAsterischi = 1; numeroAsterischi <= getPercentualeF() / 2; numeroAsterischi++) {
			System.out.print("*");
		}
		System.out.println(" F");
	} 
}
