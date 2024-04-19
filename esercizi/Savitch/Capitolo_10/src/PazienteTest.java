import java.util.Scanner;

public class PazienteTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti;

		do {// ripete se l'utente dice si
			Paziente p1 = new Paziente();
			System.out.println("Uso costruttore di default e writeOutput:");
			System.out.println();
			System.out.println("Verifico:");
			System.out.println("Nome: Ancora nessun nome.");
			System.out.println("SSN: 000-00-0000");
			System.out.println();
			p1.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test costruttore con solo il nome");
			Paziente p2 = new Paziente("English");
			System.out.println();
			System.out.println("Verifico:");
			System.out.println("Nome: English.");
			System.out.println("SSN: 000-00-0000");
			System.out.println();
			p2.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test costruttore con nome e ssn:");
			Paziente p3 = new Paziente("Yosarian", "777-77-7777");
			System.out.println();
			System.out.println("Verifico:");
			System.out.println("Nome: Yosarian.");
			System.out.println("SSN: 777-77-7777");
			System.out.println();
			p3.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			// cambio tutto
			System.out.println("Test set nome & ssn:");
			System.out.println();
			System.out.println("Prima:");
			p1.scriviOutput();
			System.out.println();
			p1.set("Brabanek", "111-11-1111");
			System.out.println("Verifico:");
			System.out.println("Nome: Brabanek.");
			System.out.println("SSN: 111-11-1111");
			System.out.println();
			p1.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test set nome:");
			System.out.println();
			System.out.println("Prima:");
			p1.scriviOutput();
			System.out.println();
			p1.setNome("Faith");
			System.out.println("Verifico:");
			System.out.println("Nome: Faith.");
			System.out.println("SSN: 111-11-1111");
			System.out.println();
			p1.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test set ssn:");
			System.out.println();
			System.out.println("Prima:");
			p1.scriviOutput();
			System.out.println();
			p1.setSsn("222-22-2222");
			System.out.println("Verifico:");
			System.out.println("Nome: Faith.");
			System.out.println("SSN: 222-22-2222");
			System.out.println();
			p1.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test get nome:");
			System.out.println();
			System.out.println("Verifico:");
			System.out.println("Nome: Faith.");
			System.out.println();
			System.out.println(p1.getNome());
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test get ssn:");
			System.out.println();
			System.out.println("Verifico:");
			System.out.println("SSN: 222-22-2222");
			System.out.println();
			System.out.println(p1.getSsn());
			System.out.println();
			System.out.println("===============================");
			System.out.println();
			System.out.println();

			System.out.println("Primo test equals:");
			System.out.println();
			// Creo un secondo paziente con gli stessi valori per gli attributi di istanza
			Paziente p4 = new Paziente("Faith", "222-22-2222");
			System.out.println();
			System.out.println("Stato del primo paziente:");
			p1.scriviOutput();
			System.out.println();
			System.out.println("Stato del secondo paziente:");
			p4.scriviOutput();
			System.out.println();
			System.out.println("Verifico: true.");
			System.out.println();
			System.out.println(p1.equals(p4));
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			// creao un solo carattere diverso nel ssn
			System.out.println();
			p4.setSsn("222-22-222");
			System.out.println("Dopo aver cambiato un solo carattere in ssn, lo stato dei due pazienti sono");
			System.out.println("the data for the 2 partients are");
			System.out.println();
			System.out.println("Stato del primo paziente:");
			p1.scriviOutput();
			System.out.println();
			System.out.println("Stato del secondo paziente:");
			p4.scriviOutput();
			System.out.println();
			System.out.println("Verifico: false.");
			System.out.println();
			System.out.println(p1.equals(p4));
			System.out.println();

			System.out.println("Ancora? (S per Si, o N for No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 'y') || (ripeti == 'Y'));
	}
}
