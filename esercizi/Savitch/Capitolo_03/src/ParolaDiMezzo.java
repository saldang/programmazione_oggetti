
import java.util.Scanner;

public class ParolaDiMezzo {

	public static void main(String[] args) {
		System.out.println("Inserisci tre parole separate da spazi");

		Scanner tastiera = new Scanner(System.in);
		String parola1 = tastiera.next();
		String parola2 = tastiera.next();
		String parola3 = tastiera.next();

		String parolaDiMezzo = null;

		if (parola1.compareTo(parola2) <= 0 && parola1.compareTo(parola3) <= 0) {
			// parola1 e' al piu' piccola
			if (parola2.compareTo(parola3) <= 0)
				parolaDiMezzo = parola2;
			else
				parolaDiMezzo = parola3;
		} else if (parola2.compareTo(parola3) <= 0) {
			// parola2 e' al piu' piccola
			if (parola1.compareTo(parola3) <= 0)
				parolaDiMezzo = parola1;
			else
				parolaDiMezzo = parola3;
		} else
		// parola3 e' al piu' piccola
		if (parola1.compareTo(parola2) <= 0)
			parolaDiMezzo = parola1;
		else
			parolaDiMezzo = parola2;

		System.out.println("La parola di mezzo e' " + parolaDiMezzo);
	}
}
