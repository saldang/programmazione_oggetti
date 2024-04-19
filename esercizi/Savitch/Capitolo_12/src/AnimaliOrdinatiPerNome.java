import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimaliOrdinatiPerNome {
	public static void main(String[] args) {
		List<Animale> animali = new ArrayList<Animale>();

		char ripeti = 's';
		Scanner tastiera = new Scanner(System.in);


		while (ripeti == 's' || ripeti == 'S') {
			System.out.println("Nome dell'animale: ");
			String nome = tastiera.nextLine();
			System.out.println("Eta dell'animale: ");
			int eta = tastiera.nextInt();
			System.out.println("Peso dell'animale: ");
			double peso = tastiera.nextDouble();
			Animale nextAnimale = new Animale(nome, eta, peso);
			animali.add(nextAnimale);

			System.out.println();
			System.out.println("Un altro animale? (s per si): ");
			ripeti = tastiera.next().charAt(0);
		}
		
		aggiungiAnimali(animali);

		// Ordina gli animali per nome

		// La sentinella ordinato sarà posta a true prima di ogni passaggio attraverso
		// l'array
		// e posta a false se si verifica uno swap durante il passaggio.
		// Se rimane true, allora non si è verificato alcuno swap e l'array deve essere
		// ordinato.
		// La sentinella è inizializzata a false cosi' da entrare nel ciclo

		boolean ordinato = false;

		// Ad ogni ciclo, il prossimo elemento è posizionato correttamente
		int iterazioni = animali.size() - 1; // Numero massimo di iterazioni
		while (!ordinato && iterazioni > 0) {
			ordinato = true;
			for (int i = 0; i < iterazioni; ++i) {
				if (((animali.get(i)).getNome()).compareTo((animali.get(i + 1)).getNome()) > 0) {
					// Sposta nella posizone piu' altan
					Animale temp = animali.get(i);
					animali.set(i, animali.get(i + 1));
					animali.set(i + 1, temp);
					ordinato = false;
				}
			}
			iterazioni--;
		}

		// Ordinato!
		for (int i = 0; i < animali.size(); ++i) {
			System.out.println();
			((Animale)animali.get(i)).scriviOutput();
			System.out.println("===================================");
			System.out.println();
		}
	}

	// Questo metodo permette di aggiungere animali senza doverli inserire a mano
	public static void aggiungiAnimali(List<Animale> somePets) {
		somePets.add(new Animale("cane", 10, 25));
		somePets.add(new Animale("gatto", 4, 10));
		somePets.add(new Animale("ostrica", 8, 150));
		somePets.add(new Animale("elefante", 35, 2000));
		somePets.add(new Animale("asino", 8, 350));
		somePets.add(new Animale("cobra", 2, 2));
	}
}
