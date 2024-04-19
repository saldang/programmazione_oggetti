
/**
 File name: ImprovedCalculator.java

 This program improves the basic program Calculator.java (Listing 9.12)
 by adding the following options:
     m for save in memory - sets memory equal to result,
     r for recall memory - displays the value of memory but
         does not change result, and
     c to clear result.

 Derived from Calculator class, Display .

 Uses UnknownOpException and DivideByZeroException.

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 2/14/99
 Changes: 09/10/2000 Prologue: email address.
          03/23/2003 Made comments like text examples. Added lines to
                     make output for r (memory recall) match that in the
                     problem statement (output "memory recall" and
                     current value of result, in addition to the value
                     recalled from memory).
 Updated for fourth edition by Brian Durney, January 2005
 */
import java.util.*;

public class CalcolatriceMigliorata extends Calcolatrice {

	private double memoria;

	private double precisione = 0.0001;
	//Numeri cosi' prossimi a zero sono considerati pari a zero.

	public CalcolatriceMigliorata() {
		super();
		memoria = 0;
	}

	public void reset() {
		super.reset();
		memoria = 0;
	}

	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}

	public double getMemoria() {
		return memoria;
	}

	/**
	 * Il cuore della calcolatrice.
	 */
	public void eseguiCalcoli() throws DivisionePerZeroException, OpSconosciutaException {
		char prossimoOperatore;
		double prossimoNumero;
		boolean fatto = false;
		super.reset();
		memoria = 0;
		Scanner tastiera = new Scanner(System.in);

		System.out.println("risultato = " + getRisultato());
		System.out.println("memoria = " + memoria);

		while (!fatto) {
			prossimoOperatore = tastiera.next().charAt(0);
			switch (prossimoOperatore) {
			case 'f':
			case 'F':
				fatto = true;
				break;
			case 'm':
			case 'M':
				memoria = getRisultato();
				System.out.println("risultato salvato in meoria");
				System.out.println("risultato = " + getRisultato());
				System.out.println("memoria = " + memoria);
				break;
			case 'r':
			case 'R':
				System.out.println("richiamo la memoria ");
				System.out.println("valore memoria = " + memoria);
				System.out.println("risultato = " + getRisultato());
				break;
			case 'c':
			case 'C':
				setRisultato(0);
				System.out.println("risultato ripulito");
				System.out.println("risultato aggiornato = " + getRisultato());
				break;
			default:
				prossimoNumero = tastiera.nextDouble();
				setRisultato(valuta(prossimoOperatore, getRisultato(), prossimoNumero));
				System.out.println("risultato " + prossimoOperatore + " " + prossimoNumero + " = " + getRisultato());
				System.out.println("risultato aggiornato = " + getRisultato());
			}
		}
	}

	/**
	 * Restituisce n1 op n2, a patto che op sia uno fra '+', '-', '*',or '/'. AOgni altro varore per op solleva un'eccezione di tipo OpSconosciutaException
	 */
	public double valuta(char op, double n1, double n2) throws DivisionePerZeroException, OpSconosciutaException {
		double answer;
		switch (op) {
		case '+':
			answer = n1 + n2;
			break;
		case '-':
			answer = n1 - n2;
			break;
		case '*':
			answer = n1 * n2;
			break;
		case '/':
			if ((-precisione < n2) && (n2 < precisione))
				throw new DivisionePerZeroException();
			answer = n1 / n2;
			break;
		default:
			throw new  OpSconosciutaException(op);
		}
		return answer;
	}

	public void gestisciDivisionePerZeroException(DivisionePerZeroException e) {
		System.out.println("Divisione per zero.");
		System.out.println("Programma terminato");
		System.exit(0);
	}

	public void gestisciOpSconosciutaException(OpSconosciutaException e) {
		System.out.println(e.getMessage());
		System.out.println("Riprova dall'inizio:");

		try {
			System.out.print("Formato di ogni linea: ");
			System.out.println("operatore spazio numero");
			System.out.println("Per esempio: + 3 o");
			System.out.println("immetti la lettere m per salvare il risultato in memoria");
			System.out.println("o la lettera r per richiamare il contenuto della memoria");
			System.out.println("Immetti la lettere c per cancellare (ma non la memoria)");
			System.out.println("Per terminare inserire la lettera f.");
			eseguiCalcoli();
		} catch (OpSconosciutaException e2) {
			System.out.println(e2.getMessage());
			System.out.println("Riprova in un secondo momento.");
			System.out.println("Fine del programma.");
			System.exit(0);
		} catch (DivisionePerZeroException e3) {
			gestisciDivisionePerZeroException(e3);
		}
	}

	public static void main(String[] args) {
		CalcolatriceMigliorata calcolatrice = new CalcolatriceMigliorata();

		try {
			System.out.println("Calcolatrice attivata.");
			System.out.print("Formato di ogni linea: ");
			System.out.println("operatore spazio numero");
			System.out.println("Per esempio: + 3 o");
			System.out.println("immetti la lettere m per salvare il risultato in memoria");
			System.out.println("o la lettera r per richiamare il contenuto della memoria");
			System.out.println("Immetti la lettere c per cancellare (ma non la memoria)");
			System.out.println("Per terminare inserire la lettera f.");
			
			calcolatrice.eseguiCalcoli();
		} catch (OpSconosciutaException e) {
			calcolatrice.gestisciOpSconosciutaException(e);
		} catch (DivisionePerZeroException e) {
			calcolatrice.gestisciDivisionePerZeroException(e);
		}

		System.out.println("Il risultato finale e' " + calcolatrice.getRisultato());
		System.out.println("Fine del programma.");
	}
}
