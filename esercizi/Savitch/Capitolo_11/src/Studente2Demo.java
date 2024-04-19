import java.util.Arrays;

public class Studente2Demo {
	public static void main(String[] args) {
		Studente2[] studenti = new Studente2[4];

		studenti[0] = new Studente2("Fred", 991);
		studenti[1] = new Studente2("Bill", 331);
		studenti[2] = new Studente2("Adam", 412);
		studenti[3] = new Studente2("Chris", 121);

		Arrays.sort(studenti);

		// Stampa l'array degli studenti ordinato
		for (Studente2 s : studenti) {
			s.scriviOutput();
		}
	}
}