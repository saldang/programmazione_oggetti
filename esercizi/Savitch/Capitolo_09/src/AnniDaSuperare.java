import java.util.Scanner;

public class AnniDaSuperare {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Ottieni le informazioni sulla prima specie dall'utente
		System.out.println("Nome della specie:");
		String nomeSpecie = keyboard.nextLine();
		System.out.println("Popolazione della specie:");
		int poplazioneSpecie = keyboard.nextInt();
		System.out.println("Tasso di crescita della specie (percentuale di incremento per anno):");
		double tassoCrescietaSpecie = keyboard.nextDouble();
		// Usa il costruttore per inizializzare tutti e 3 gli attributi
		Specie s1 = new Specie(nomeSpecie, poplazioneSpecie, tassoCrescietaSpecie);
		System.out.println();

		// Per evitare problemi con nextLine()
		keyboard = new Scanner(System.in);

		// Ottieni le informazioni sulla seconda specie dall'utente
		System.out.println("Nome della specie:");
		nomeSpecie = keyboard.nextLine();
		System.out.println("Popolazione della specie:");
		poplazioneSpecie = keyboard.nextInt();
		System.out.println("Tasso di crescita della specie (percentuale di incremento per anno):");
		tassoCrescietaSpecie = keyboard.nextDouble();
		// Usa il costruttore per inizializzare tutti e 3 gli attributi
		Specie s2 = new Specie(nomeSpecie, poplazioneSpecie, tassoCrescietaSpecie);
		System.out.println();
		System.out.println("Cerifico la correttezza dei dati con scriviOutput().");
		System.out.println("Prima Specie:");
		s1.scriviOutput();
		System.out.println();
		System.out.println("Seconda Specie:");
		s2.scriviOutput();
		System.out.println();
		
		// Ora identifichiamo il numero di anni che ci vorranno per superare l'altra specie con la popolazione iniziale più bassa.
		// Si creano prima altri due oggetti Specie usando il costruttore che specifica solo il nome.
		Specie piuBassa = new Specie("piu' bassa"); // ha una popolazione inizlae più bassa
		Specie piuAlta = new Specie("piu' alta"); // ha una popolazione iniziale più alta

		//Verifica dell'istanziazione
        System.out.println("Mostra i risultati della creazione di oggetti piu' in basso e piu' in alto");
        System.out.println("la popolazione iniziale e il tasso di crescita dovrebbero essere 0");
        System.out.println();
        piuBassa.scriviOutput();
        System.out.println();
        piuAlta.scriviOutput();
        System.out.println();
		
		
		// Caso speciale:
		// Cosa succede se le due specie hanno la spessa popolazione iniziale?
		// Determina chi ha la popolazione inizale piu' bassa
		// Se hanno la stessa popolazione iniziale, assegna a piuBassa la prima specie
		// ed a piuALta la seconda specie
		if (s1.getPopolazione() <= s2.getPopolazione()) {
			piuBassa.set(s1.getNome(), s1.getPopolazione(), s1.getTassoCrescita());
			piuAlta.set(s2.getNome(), s2.getPopolazione(), s2.getTassoCrescita());
		} else {
			piuBassa.set(s2.getNome(), s2.getPopolazione(), s2.getTassoCrescita());
			piuAlta.set(s1.getNome(), s1.getPopolazione(), s1.getTassoCrescita());
		}

		// Identifica il numero di anni che occorrono affinché la specie con popolazione
		// iniziale più bassa superi quella con popolazione iniziale più alta
		int anni = 1;
		int prossimaPiuBassa = piuBassa.getPopolazione();
		int prossimaPiuAlta = piuAlta.getPopolazione();
		while (prossimaPiuBassa <= prossimaPiuAlta && anni <= 10) {
			prossimaPiuBassa = piuBassa.prediciPopolazione(anni);
			prossimaPiuAlta = piuAlta.prediciPopolazione(anni);
			anni++; // ATTENZIONE: il valori di anni all'uscita del ciclo avra' un elemento di
					// troppo
		}

		// Aggiusta anni in modo che il valore sia corretto
		anni--;

		// Porre attenzione quando anni = 10
		// la popolazione piuBassa potrebbe non aver superato la popolazione di piuAlta
		// occorre quindi fare una verifica finale

		if (anni == 10 && prossimaPiuBassa <= prossimaPiuAlta) {
			System.out.println("Specie " + piuBassa.getNome() + " non superera' " + piuAlta.getNome() + ".");
		} else {
			System.out.println(
					"Specie " + piuBassa.getNome() + " superera' " + piuAlta.getNome() + " in " + anni + " anni.");
		}
	}
}
