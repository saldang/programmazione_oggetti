import java.util.*;

public class CaneTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti;

		do {// ripete se l'utente dice si
			int i = 1;// Contatore dei test

			// Testa i costruttori con scriviOutput()
			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Costruttore di default.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("nome: Nessun nome.");
			System.out.println("eta: 0 anni");
			System.out.println("peso: 0.0 kg");
			System.out.println("razza: None");
			System.out.println("Non ha un comando di richiamo.");
			System.out.println();
			Cane d1 = new Cane(); // default constructor
			d1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Costruttore con tutti i parametri ad eccezione del richiamo");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("nome: Calvin");
			System.out.println("eta: 5 anni");
			System.out.println("peso: 10.5 kg");
			System.out.println("razza: Dachshund");
			System.out.println("Non ha un comando di richiamo.");
			System.out.println();
			Cane d2 = new Cane("Calvin", 5, 10.5, "Dachshund");
			d2.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Costruttore con tutti i parametri.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("nome: Madigan");
			System.out.println("eta: 2 anni");
			System.out.println("peso: 50.0 kg");
			System.out.println("razza: Golden Retriever");
			System.out.println("Ha un comando di richiamo.");
			System.out.println();
			Cane d3 = new Cane("Madigan", 2, 50, "Golden Retriever", true);
			d3.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set nome.");
			System.out.println();
			System.out.println("Prima:");
			d1.scriviOutput();
			System.out.println();
			d1.setNome("Barley");
			System.out.println("Verifica nome cambiato in Barley");
			System.out.println();
			d1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set eta.");
			System.out.println();
			System.out.println("Prima:");
			d1.scriviOutput();
			System.out.println();
			d1.setEta(8);
			System.out.println("Verifica eta cambiato in 8");
			System.out.println();
			d1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set peso.");
			System.out.println();
			System.out.println("Prima:");
			d1.scriviOutput();
			System.out.println();
			d1.setPeso(15.1);
			System.out.println("Verifica peso cambiato in 15.1 kg");
			System.out.println();
			d1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set razza.");
			System.out.println();
			System.out.println("Prima:");
			d1.scriviOutput();
			System.out.println();
			d1.setRazza("Labrador");
			System.out.println("Verifica nome cambiato in Barley");
			System.out.println();
			d1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set per il richiamo.");
			System.out.println();
			System.out.println();
			System.out.println("Prima:");
			d1.scriviOutput();
			System.out.println();
			d1.setComandoDiRichiamo(true);
			System.out.println("Verifica \"Aveva ...\"");
			System.out.println();
			d1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set di tutti gli attributi.");
			System.out.println();
			System.out.println();
			System.out.println("Prima:");
			Cane d4 = new Cane();// Default constructor
			d4.scriviOutput();
			System.out.println();
			d4.set("Charley", 1, 23.8, "Greyhound", true);
			System.out.println("Verifica nome cambiato in Charley,");
			System.out.println("Verifica eta cambiato in 1 anno,");
			System.out.println("Verifica peso cambiato in 23.8 kg,");
			System.out.println("Verifica razza cambiato in Greyhound,");
			System.out.println("Verifica \"Has had ...\"");
			System.out.println();
			d4.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println("Ancora? (S per Si, o N for No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 's') || (ripeti == 'S'));
	}
}
