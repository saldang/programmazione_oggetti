import java.util.Scanner;

public class Frammenti {
	public static void main(String[] args) {

		// Esercizio 1
		int punteggio = 35;

		if (punteggio >= 0 && punteggio <= 100)
			System.out.println("Il punteggio " + punteggio + " e' valido.");
		else
			System.out.println("Il punteggio " + punteggio + " non e' valido.");

		// Esercizio 2
		int x = 20;

		System.out.println("Il valore vecchio di x e' " + x);
		if (x % 2 == 1)
			x = 3 * x - 1;
		else
			x = x / 2;
		System.out.println("Il nuovo valore di x e' " + x);

		// Esercizio 3
		Scanner tastiera = new Scanner(System.in);
		String risposta = tastiera.next();

		boolean accettato = false;

		if (risposta.equals("s") || risposta.equals("si"))
			accettato = true;
		else
			accettato = false;
		System.out.println("Accetatto e' " + accettato);

		risposta = risposta.toLowerCase();
		if (risposta.equals("s") || risposta.equals("si"))
			accettato = true;
		else
			accettato = false;
		System.out.println("Accetatto e' " + accettato);

		// Esercizio 6

		double ammontare = 100.3;
		double percentuale = 0.0;

		if (ammontare < 10.0)
			percentuale = 1.0;
		else if (ammontare < 100.0)
			percentuale = 0.1 * ammontare;
		else if (ammontare < 1000.0)
			percentuale = 5.0 + 0.05 * ammontare;
		else
			percentuale = 40.0 + 0.01 * ammontare;

		System.out.println("Il costo del servizio per " + ammontare + " e' " + percentuale);

		// Esercizio 7

		x = 5;
		int y = 10, z = 15;

		System.out.println(x < 5 && y > x);
		System.out.println(x < 5 || y > x);
		System.out.println(x > 3 || y < 10 && z == 15);
		System.out.println(!(x > 3) && x != z || x + y == z);

		// Esercizio 11
		char lettera = 'a';

		double voto = 0.0;

		switch (lettera) {
		case 'A':
			voto = 4.0;
			break;
		case 'B':
			voto = 3.0;
			break;
		case 'C':
			voto = 2.0;
			break;
		case 'D':
			voto = 1.0;
			break;
		case 'F':
			voto = 0.0;
			break;
		default:
			voto = 0.0;
			System.out.println("Il voto " + lettera + " non e' valido");
		}

		System.out.println("Il voto e' " + voto);

		// Esercizio 12
		String letteraMigliorata = "B+";

		voto = 0.0;

		if (letteraMigliorata.equals("A+"))
			voto = 4.25;
		else if (letteraMigliorata.equals("A"))
			voto = 4.0;
		else if (letteraMigliorata.equals("A-"))
			voto = 3.75;
		else if (letteraMigliorata.equals("B+"))
			voto = 3.25;
		else if (letteraMigliorata.equals("B"))
			voto = 3.0;
		else if (letteraMigliorata.equals("B-"))
			voto = 2.75;
		else if (letteraMigliorata.equals("C+"))
			voto = 2.25;
		else if (letteraMigliorata.equals("C"))
			voto = 2.0;
		else if (letteraMigliorata.equals("C-"))
			voto = 1.75;
		else if (letteraMigliorata.equals("D+"))
			voto = 1.25;
		else if (letteraMigliorata.equals("D"))
			voto = 1.0;
		else if (letteraMigliorata.equals("D-"))
			voto = 0.75;
		else if (letteraMigliorata.equals("F+"))
			voto = 0.25;
		else if (letteraMigliorata.equals("F"))
			voto = 0.0;
		else {
			voto = 0.0;
			System.out.println("Il voto " + letteraMigliorata + " non e' valido");
		}

		System.out.println("Il voto e' " + voto);

		char LetterDelVoto = letteraMigliorata.charAt(0);
		char menoPiu = '0';

		if (letteraMigliorata.length() > 1)
			menoPiu = letteraMigliorata.charAt(1);

		switch (LetterDelVoto) {
		case 'A':
			voto = 4.0;
			switch (menoPiu) {
			case '+':
				voto += 0.25;
				break;
			case '-':
				voto -= 0.25;
				break;
			}
			break;
		case 'B':
			voto = 3.0;
			switch (menoPiu) {
			case '+':
				voto += 0.25;
				break;
			case '-':
				voto -= 0.25;
				break;
			}
			break;
		case 'C':
			voto = 2.0;
			switch (menoPiu) {
			case '+':
				voto += 0.25;
				break;
			case '-':
				voto -= 0.25;
				break;
			}
			break;
		case 'D':
			voto = 1.0;
			switch (menoPiu) {
			case '+':
				voto += 0.25;
				break;
			case '-':
				voto -= 0.25;
				break;
			}
			break;
		case 'F':
			voto = 0.0;
			switch (menoPiu) {
			case '+':
				voto += 0.25;
				break;
			}
			break;
		default:
			voto = 0.0;
			System.out.println("Il voto " + letteraMigliorata + " non e' valido");

		}
		System.out.println("Il voto e' " + voto);
	}
}
