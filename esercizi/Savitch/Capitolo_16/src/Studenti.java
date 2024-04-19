
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Studenti {
	public static void main(String[] args) {
		HashMap<Integer, ArrayList<String>> studenti = new HashMap<Integer, ArrayList<String>>();
		String linea;
		int idStudente;
		String corso;
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci l'id dello studente seguito dal numero del corso. Immetti -1 per uscire.");
		do {
			linea = tastiera.nextLine();
			linea = linea.trim(); // rimuove ogni spazio all'inizio o alla fine della linea
			if (!linea.equals("-1")) {
				// Estrae l'id e il corso che si intende separati da uno spazio.
				// Usa il metodo split che crea un array di stringhe delimitate dal
				// delimitatore specificato. nel caso in ogetto lo spazio
				String[] stringaElaborata = linea.split(" ");
				idStudente = Integer.parseInt(stringaElaborata[0]); // l'id
				corso = stringaElaborata[1];
				// ASggiunge all'array se lo studente e' sattao gia' visto prima
				if (studenti.containsKey(idStudente)) {
					studenti.get(idStudente).add(corso);
				} else {
					// Aggiunge per la prima volta un arrayylist alla mappa
					ArrayList<String> corsi = new ArrayList<String>();
					corsi.add(corso);
					studenti.put(idStudente, corsi);
				}
			}
		} while (!linea.equals("-1"));

		// Adesso itera sulla mappa e stampa l'id dello studente e tutti i corsi a lui associati
		System.out.println();
		for (Integer key : studenti.keySet()) {
			System.out.println("Studente con i id: " + key);
			for (String cls : studenti.get(key)) {
				System.out.print(cls + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
}
