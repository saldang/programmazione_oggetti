
/**

   File name: BillingTest.java

   This program tests Billing class.

   Based on EmployeeTest.java from Practice Program 1.

   Author: Lew Rakocy
   email address: LRakocy@devrycols.edu
   Date: 9/4/2000
   Last changed:
   Updated for fourth edition  by Brian Durney, December 2004

 */
import java.util.*;

public class FatturaTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti;

		do {// ripete se l'utente dice si

			Dottore d1 = new Dottore("Spock", 200.00, "Pediatra");
			Dottore d2 = new Dottore("Dolittle", 175.00, "Cardiologo");
			Paziente p1 = new Paziente("Calvin", "123-45-6789");
			Paziente p2 = new Paziente("Hobbes", "987-65-4321");

			System.out.println();
			System.out.println("Creati due dottori:");
			System.out.println();
			d1.scriviOutput();
			System.out.println();
			d2.scriviOutput();
			System.out.println();

			System.out.println("Creati due pazienti:");
			System.out.println();
			p1.scriviOutput();
			System.out.println();
			p2.scriviOutput();
			System.out.println();

			Fattura b1 = new Fattura(d1, p1);
			Fattura b2 = new Fattura(d1, p2);
			Fattura b3 = new Fattura(d2, p1);

			System.out.println("Creato tre fatture:");
			System.out.println();
			System.out.println("Verifico prima fattura:");
			System.out.println("Dottore: Spock.");
			System.out.println("Paziente: Calvin");
			System.out.println("Ammontare fattura: $200.00");
			System.out.println();
			b1.scriviOutput();
			System.out.println("===============================");

			System.out.println();
			System.out.println("Verifico seconda fattura:");
			System.out.println("Dottore: Spock.");
			System.out.println("Paziente: Hobbes");
			System.out.println("Ammontare fattura: $200.00");
			System.out.println();
			b2.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println();
			System.out.println("Verifico terza fattura:");
			System.out.println("Dottore: Dolittle.");
			System.out.println("Paziente: Calvin");
			System.out.println("Ammontare fattura: $175.00");
			System.out.println();
			b3.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			System.out.println();

			System.out.println("Verifico ammontare complessivo delle fatture = €575");
			System.out.println();
			System.out.println();
			System.out.println("Totale");
			System.out.println("----------------------");
			double totalAmount = b1.getAmmontare() + b2.getAmmontare() + b3.getAmmontare();
			System.out.println("€" + totalAmount);

			System.out.println("Ancora? (S per Si, o N for No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 'y') || (ripeti == 'Y'));
	}
}
