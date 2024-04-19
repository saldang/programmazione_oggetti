import java.util.Scanner;
import java.util.Vector;
import java.util.ListIterator;

/**
 * Suitor contains the main code that creates the vector of suitors and
 * eliminates them one by one. Each element in the vector is an Integer object
 * that stores the original position that person stands in line.
 */
public class Pretendenti {
	public static void main(String[] args) {
		// Variable declarations
		int numeroPretendenti;
		Vector<Integer> pretendenti = new Vector<Integer>();
		Scanner tastiera = new Scanner(System.in);

		boolean inAvanti = true;
		System.out.println("Inserisci il numero di pretendenti:");
		numeroPretendenti = tastiera.nextInt();

		if (numeroPretendenti > 0) {
			for (int i = 1; i <= numeroPretendenti; i++) {
				// Aggiunge un nuovo pretendente alla fine dellafila
				pretendenti.add(Integer.valueOf(i));
			}
		}

		if (numeroPretendenti <= 0) {
			System.out.println("Pretendenti non in numero sufficiente.");
		} else if (numeroPretendenti == 1) {
			System.out.println("Saresti il primo della fila.");
		} else {
			ListIterator<Integer> iteratore = pretendenti.listIterator();
			// Si muove al primo pretendente
			iteratore.next();
			// Elimina un corteggiatore finché ce n'è almeno uno.
			while (pretendenti.size() > 1) {
				// Passa alla terza persona
				for (int i = 0; i < 2; i++) {
					if (inAvanti) {
						if (!iteratore.hasNext()) {
							inAvanti = false;
							// Torna indietro due volte
							iteratore.previous();
							iteratore.previous();
						} else
							iteratore.next();
					} else {
						if (!iteratore.hasPrevious()) {
							inAvanti = true;
							//Va avanti due volte
							iteratore.next();
							iteratore.next();
						} else
							iteratore.previous();
					}
				}
				// Rimuove il pretendente raggiunto
				iteratore.remove();
				// Va al prossimo pretendente
				if (inAvanti) {
					if (!iteratore.hasNext()) {
						inAvanti = false;
						iteratore.previous();
					} else
						iteratore.next();
				} else {
					if (!iteratore.hasPrevious()) {
						inAvanti = true;
						iteratore.next();
					} else
						iteratore.previous();
				}
			}
			System.out.println("Per vincere la principessa, si dovrebbe stare in posizione " + pretendenti.get(0).intValue());
		}
	}
}
