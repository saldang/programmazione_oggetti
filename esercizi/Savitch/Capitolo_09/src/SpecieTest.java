import java.util.Scanner;

public class SpecieTest {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// variabile di controllo per verificare se occorre ripetere il ciclo
		char risposta;

		do { // Il ciclo viene ripetuto se l'utente risponde S
			System.out.println("Collaudo 1° Costruttore");
			System.out.println("    - specifico tutti i valori epr gli attributi.");
			System.out.println();
			System.out.println("Nome dovrebbe essere Crepek.");
			System.out.println("La popolazione iniziale dovrebbe essere 11.");
			System.out.println("Il tasso di crescita dovrebbe essere 2.2.");
			System.out.println();
			Specie s1 = new Specie("Crepek", 11, 2.2);
			System.out.println("Valori dopo il costruttore:");
			s1.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo 2° Costruttore");
			System.out.println("    - specifico solo il  nome.");
			System.out.println();
			System.out.println("Nome dovrebbe essere Foobar.");
			System.out.println("La popolazione iniziale dovrebbe essere 0.");
			System.out.println("Il tasso di crescita dovrebbe essere 0.");
			System.out.println();
			Specie s2 = new Specie("Foobar");
			System.out.println("Valori dopo il costruttore:");
			s2.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo 3° Costruttorer");
			System.out.println("    - specifico solo la popolazione.");
			System.out.println();
			System.out.println("Nome dovrebbe essere \"Nessun nome\".");
			System.out.println("La popolazione iniziale dovrebbe essere 33.");
			System.out.println("Il tasso di crescita dovrebbe essere 0.");
			System.out.println();
			Specie s3 = new Specie(33);
			System.out.println("Valori dopo il costruttore:");
			s3.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo 4° Costruttore");
			System.out.println("    - specifico solo il tasso di crescita.");
			System.out.println();
			System.out.println("Nome dovrebbe essere \"Nessun nome\".");
			System.out.println("La popolazione iniziale dovrebbe essere 0.");
			System.out.println("Il tasso di crescita dovrebbe essere 44.4.");
			System.out.println();
			Specie s4 = new Specie(44.4);
			System.out.println("Valori dopo il costruttore:");
			s4.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("TCollaudo il costruttore di default");
			System.out.println("    - nessun parametro specificato.");
			System.out.println();
			System.out.println("Nome dovrebbe essere \"Nessun nome\".");
			System.out.println("La popolazione iniziale dovrebbe essere 0.");
			System.out.println("Il tasso di crescita dovrebbe essere 0.");
			System.out.println();
			Specie s5 = new Specie();
			System.out.println("Valori dopo il costruttore:");
			s5.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo tutti i parametri");
			System.out.println();
			System.out.println("Nome dovrebbe essere Yosarian.");
			System.out.println("La popolazione iniziale dovrebbe essere 55.");
			System.out.println("Il tasso di crescita dovrebbe essere 66.6.");
			System.out.println();
			s1.set("Yosarian", 55, 66.6);
			s1.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo il nome");
			System.out.println();
			System.out.println("Nome dovrebbe essere Milo.");
			System.out.println("La popolazione iniziale dovrebbe essere 55.");
			System.out.println("Il tasso di crescita dovrebbe essere 66.6.");
			System.out.println();
			s1.set("Milo");
			s1.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo la popolazione");
			System.out.println();
			System.out.println("Nome dovrebbe essere Milo.");
			System.out.println("La popolazione iniziale dovrebbe essere 77.");
			System.out.println("Il tasso di crescita dovrebbe essere 66.6.");
			System.out.println();
			s1.set(77);
			s1.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println("Collaudo il tasso di crescita");
			System.out.println();
			System.out.println("Nome dovrebbe essere Milo.");
			System.out.println("La popolazione iniziale dovrebbe essere 77.");
			System.out.println("Il tasso di crescita dovrebbe essere 88.8.");
			System.out.println();
			s1.set(88.8);
			s1.scriviOutput();
			System.out.println();
			System.out.println("==============================");

			System.out.println();
			System.out.println("Collauda ancora?(s/n)");
			risposta = keyboard.next().charAt(0);
		} while ((risposta == 's') || (risposta == 'S'));

		System.out.println("Fine del collaudo.");
	}
}
