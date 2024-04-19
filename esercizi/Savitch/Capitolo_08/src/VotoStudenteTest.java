import java.util.Scanner;

public class VotoStudenteTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		VotoStudente unoStudente = new VotoStudente();

		char ripetizione;
		do  { // ripeti se l'utente dice si
			unoStudente.leggiValori();

			unoStudente.stampaValori();

			unoStudente.stampaNome();

			System.out.println("Nome studente: " + unoStudente.restituisciNome());

			unoStudente.stampaQuiz1();

			System.out.println("Voto quiz 1: " + unoStudente.restituisciQuiz1());

			unoStudente.stampaQuiz2();

			System.out.println("Voto quiz 2: " + unoStudente.restituisciQuiz2());

			unoStudente.stampaEsameIntermedio();

			System.out.println("Voto esame intermedio: " + unoStudente.restituisciEsameIntermedio());

			unoStudente.stampaEsameFinale();

			System.out.println("Voto esame intermedio: " + unoStudente.restituisciEsameFinale());

			System.out.println("Voto percentuale = " + unoStudente.getVotoPercentuale());

			unoStudente.stampaVotoPercentuale();

			System.out.println("Voto in lettere = " + unoStudente.getVotoLettera());

			unoStudente.stampaVotoLettera();

			unoStudente.stampaNome(); // prima
			unoStudente.leggiNome(); // modifica
			unoStudente.stampaNome(); // dopo

			unoStudente.stampaQuiz1(); // prima
			unoStudente.leggiQuiz1(); // modifica
			unoStudente.stampaQuiz1(); // dopo

			unoStudente.stampaQuiz2(); // prima
			unoStudente.leggiQuiz2(); // modifica
			unoStudente.stampaQuiz2(); // dopo

			unoStudente.stampaEsameIntermedio(); // prima
			unoStudente.leggiEsameIntermedio(); // modifica
			unoStudente.stampaEsameIntermedio(); // dopo

			unoStudente.stampaEsameFinale(); // prima
			unoStudente.leggiEsameFinale(); // modifica
			unoStudente.stampaEsameFinale(); // dopo

			// ricalcola e mostra il voto percentuale
			unoStudente.getVotoPercentuale(); // deve essere ricalcolato prima di calolare il voto
			unoStudente.stampaVotoPercentuale();

			// ricalcola e mostra il voto in lettere
			unoStudente.getVotoLettera(); // deve essere ricalcolato prima di calolare il voto
			unoStudente.stampaVotoLettera();

			System.out.println("Vuoi continuare? (S per Si, o N per No)");
			ripetizione = tastiera.next().charAt(0);
		} while ((ripetizione == 's') || (ripetizione == 'S'));
	}
}
