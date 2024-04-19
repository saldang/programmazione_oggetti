
/**
 File name: EmployeeCh9Demo.java

 This program reads employee data for up to 100 employees into an
 array, then it outputs the records for all employees with annotation
 that tells if the employee's salary is above or below average.

 Uses SSNLengthException and SSNCharacterException classes to tell
 the user if there is an error when entering employee's SSNs.

 Note: SSN must be entered as a 9-digit string (without separators).

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/11/2000
 Changes: 03/26/2003 Made comments like text examples.
 Updated for fourth edition by Brian Durney, January 2005.
 */
import java.util.*;

public class DipendenteDemo {
	public static void main(String[] args) {
		Dipendente[] e = new Dipendente[100];
		String nome;
		String SNN;
		double salario;
		double sommaSalario = 0;
		double salarioMedio;
		String ignora;
		Scanner tastiera = new Scanner(System.in);

		char ripetere;
		int i = 0; 
		do {
			tastiera = new Scanner(System.in);

			System.out.println();
			e[i] = new Dipendente();
			System.out.print("Inserisci il nome per il dipendente #" + (i + 1) + ": ");
			nome = tastiera.nextLine();
			e[i].setNome(nome);
			System.out.println();

			System.out.print("Inserisci il salario per il dipendente #" + (i + 1) + ": ");
			salario = tastiera.nextDouble();
			e[i].setRetribuzioneAnnuale(salario);
			System.out.println();

			try {
				System.out.print("Inserisci il SNN (9 cifre) pe il dipendente #" + (i + 1)  + ": ");
				// Get rid of end of line left from nextDouble() call.
				ignora = tastiera.nextLine();
				SNN = tastiera.nextLine();
				if (SNN.length() != 9) {
					throw new LunghezzaCFException(SNN, SNN.length());
				} else {
					for (int j = 0; j < 9; ++j) {
						if (SNN.charAt(j) > '9' || SNN.charAt(j) < '0') {
							throw new FormatoCFException(SNN, SNN.charAt(j));
						}
					}
				}
				e[i].setId(SNN);
				++i; // Next employee
			}

			catch (LunghezzaCFException e1) {
				System.out.println(e1.getMessage());
				System.out.println("Re-inserisci dati per dipendente #" + (i + 1));
			}

			catch (FormatoCFException e2) {
				System.out.println(e2.getMessage());
				System.out.println("Re-inserisci dati per dipendente #" + (i + 1));
			}

			System.out.println("Altri dipendenti? (s per si)");
			ripetere = tastiera.next().charAt(0);

		} while ((ripetere == 's') || (ripetere == 'S'));

		for (int j = 0; j < i; ++j)
			sommaSalario = sommaSalario + e[j].getRetribuzioneAnnuale();

		salarioMedio = sommaSalario / i;

		System.out.println();
		for (int j = 0; j < i; ++j) {
			System.out.println("Dipendente #" + (j + 1));
			e[j].scriviOutput();
			if (e[j].getRetribuzioneAnnuale() > salarioMedio)
				System.out.println("  Sopra la media");
			else if (e[j].getRetribuzioneAnnuale() < salarioMedio)
				System.out.println("  Sotto la media");
			else
				System.out.println("  in media");
		}
		System.out.println("Nessun altro dipendente.");
	}
}
