
/**

 File name: Mortgage2.java

 Description:
 This program does the following:
  Reads in the amount of a mortgage and
  the outstanding balance (the amount still owed),
  then uses an annual interest rate of 6.79%
  to calculate and display the amount of the payment that goes to interest,
  the amount that goes toward principal,
  and the new principal.

 Assumptions:
  Payments are made monthly so the interest rate is 1/12 of the annual rate
      of 7.49%.


 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu 
 Date: 2/14/99
 Last changed: Updated for 4th edition by Brian Durney, November 2004

 */
import java.util.*;

public class Ipoteca2 {
	public static final double TASSO_ANNUO = 0.0749; // tasso di interesse annuo

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci l'importo pagato questo mese (in euro):");
		int pagamento = (int) (tastiera.nextDouble() * 100 + 0.5);
		// Moltiplica per 100, aggiunge 1/2 e tronca con cast esplicito
		// per garantire accuratezza all'ultimo centesimo

		System.out.println("Inserisci il debito rimanente (in euro):");
		int debitoRimanente = (int) (tastiera.nextDouble() * 100 + 0.5);
		// Stessa procedura per l'accuratezza

		int interessi = (int) (debitoRimanente * TASSO_ANNUO / 12);
		// E' richiesto un cast esplicito poiche' la divisone e' con un double

		int quotaDebito = pagamento - interessi;

		int nuovoDebitoRimanente = debitoRimanente - quotaDebito;

		System.out.println("Saldo precedente: " + (double) debitoRimanente / 100);
		System.out.println("Pagamento: " + (double) pagamento / 100);
		System.out.println("Interessi: " + (double) interessi / 100);
		System.out.println("Importo debito: " + (double) quotaDebito / 100);
		System.out.println("Nuovo saldo: " + (double) nuovoDebitoRimanente / 100);

	}
}
