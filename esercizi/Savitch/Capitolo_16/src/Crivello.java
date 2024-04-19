import java.util.ArrayList;
import java.util.Iterator;

public class Crivello {

	public static void main(String[] args) {
		ArrayList<Integer> numeri = new ArrayList<Integer>();

		// Genera numeri da 2 a 100
		for (int i = 2; i <= 100; i++) {
			numeri.add(i);
		}

		// Avvia
		for (int i = 0; i < numeri.size() - 1; i++) {
			// Ottiene il nuemro alla posizione i
			int valoreCorrente = numeri.get(i);
			// Ottiene un iteratore per il prossimo numero
			Iterator<Integer> iteratore = numeri.listIterator(i + 1);
			// Scansiona il resto della lista per multipli, 
			// rimuovendo l'elemento se si tratta di un multiplo di valoreCorrente
			while (iteratore.hasNext()) {
				int valoreCandidato = iteratore.next();
				// Rimuove se multiplo di valoreCorrente
				if ((valoreCandidato % valoreCorrente) == 0) {
					iteratore.remove();
				}
			}
		}

		// Stampa i valori che rimangono nell'ArrayList
		System.out.println("Numeri primi fra 2 e 100:");
		for (Integer n : numeri) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}