import java.util.HashSet;

public class ParadossoCompleanni {
	// Numero di prove casuali da eseguire per dimensione della stanza
	public static final int NUM_TENTATIVI = 5000;
	// Numero massimo di persone in una stanza
	public static final int DIMENSIONE_MAX_STANZA = 50;

	public static void main(String[] args) {
		// Compleanni delle persone nella stanza, da 1 a 365
		HashSet<Integer> compleanni;
		int prova;
		int persone;
		int numeroMatch;

		for (persone = 2; persone <= DIMENSIONE_MAX_STANZA; persone++) {
			// Effettua delle prove per vedere se le persone hanno lo stesso compleanno.
			// Resetta il numero di matches
			numeroMatch = 0;
			for (prova = 0; prova < NUM_TENTATIVI; prova++) {
				// Crea un nuovo HashSet to store birthday
				compleanni = new HashSet<Integer>();
				boolean matchTrovato = false;
				// Genera a caso fino a "persone" compleanni
				for (int i = 0; (i < persone && !matchTrovato); i++) {
					// Genera una data di compleanno random
					int compleanno = (int) (Math.random() * 365) + 1;
					// Controlla se qualcuno ha questo compleanno
					if (compleanni.contains(compleanno)) {
						numeroMatch++;
						matchTrovato = true;
					} else {
						// Qggiunge questo compleanno all'insieme
						compleanni.add(compleanno);
					}
				}
			}
			System.out.println("Per " + persone + " la probabilita' che due compleanni coincidano e' circa "
					+ (double) numeroMatch / NUM_TENTATIVI);
		}
	}
}
