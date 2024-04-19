import java.util.Scanner;

public class DottoreTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		char repeat;
		do { // ripeti se l'utente scrive si
		
			// Testa i 6 costruttori con scriviOutput()

			Dottore drNo = new Dottore();
			System.out.println("Costruttore di default:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Ancora nessun nome.");
			System.out.println("€150");
			System.out.println("Generico");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Costruttore con nome:");
			Dottore drJekyl = new Dottore("Jekyl");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Jekyl");
			System.out.println("€150");
			System.out.println("Generico");
			System.out.println();
			drJekyl.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Costruttore con nome e parcella:");
			Dottore drKildare = new Dottore("Kildare", 200.99);
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Kildare");
			System.out.println("€200.99");
			System.out.println("Generico");
			System.out.println();
			drKildare.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Costruttore con nome e specializzazione:");
			Dottore drWelby = new Dottore("Welby", "Cardiologo");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Welby");
			System.out.println("€150");
			System.out.println("Cardiologo");
			System.out.println();
			drWelby.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Costruttore con nome, parcella e specializzazione:");
			Dottore drHoliday = new Dottore("Vacanza", 5.25, "Dentista");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Vacanza");
			System.out.println("€5.25");
			System.out.println("Dentista");
			System.out.println();
			drHoliday.scriviOutput();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test di scrivi nome:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Nome: Vacanza");
			System.out.println();
			drHoliday.scriviNome();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test di scrivi parcella:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Parcella: €5.25");
			System.out.println();
			drHoliday.scriviParcella();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test di scrivi specializzazione:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Specializzazione: Dentista");
			System.out.println();
			drHoliday.scriviSpecializzazione();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Set nome, parcella e specializzazione:");
			System.out.println();
			System.out.println("Valori degli attributi prima del set:");
			drNo.scriviOutput();
			System.out.println();
			drNo.set("No", 1234.56, "Chirurgia laser");
			System.out.println("Verifica Valore degli attributi dopo il set:");
			System.out.println("No");
			System.out.println("€1234.56");
			System.out.println("Chirurgia laser");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test set nome:");
			System.out.println();
			System.out.println("Valori degli attributi prima del set:");
			drNo.scriviOutput();
			System.out.println();
			drNo.setNome("Si");
			System.out.println("Valore degli attributi dopo il set:");
			System.out.println("Verifica Nome: Si");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test set parcella:");
			System.out.println();
			System.out.println("Valori degli attributi prima del set:");
			drNo.scriviOutput();
			System.out.println();
			drNo.setParcella(987.65);
			System.out.println("Valore degli attributi dopo il set:");
			System.out.println("Verifica parcella: €987.65");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test set specializzazione:");
			System.out.println();
			System.out.println("Valori degli attributi prima del set:");
			drNo.scriviOutput();
			System.out.println();
			drNo.setSpecializzazione("Psicologo");
			System.out.println("Valore degli attributi dopo il set:");
			System.out.println("Verifica specializzazione: Psicologo");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test get nome:");
			System.out.println();
			System.out.println("Verifica si");
			System.out.println();
			System.out.println(drNo.getNome());
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test get parcella:");
			System.out.println();
			System.out.println("Verifica 987.65");
			System.out.println();
			System.out.println(drNo.getParcella());
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Test get specialita':");
			System.out.println();
			System.out.println("Verifica Psicologo");
			System.out.println();
			System.out.println(drNo.getSpecializzazione());
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			// test equals

			System.out.println("equals test 1:");
			System.out.println();
			// Create un secondo dottore con lo stesso nome di drNo
			Dottore drSi = new Dottore("Si", 987.65, "Psicologo");
			System.out.println("Valori per il primo dottore:");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo dottore:");
			System.out.println();
			drSi.scriviOutput();
			System.out.println("Verifica true");
			System.out.println();
			System.out.println(drNo.equals(drSi));
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("equals test 2:");
			System.out.println();
			drSi.setParcella(987.66);
			System.out.println("Valori per il primo dottore:");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo dottore:");
			System.out.println();
			drSi.scriviOutput();
			System.out.println("Verifica false");
			System.out.println();
			System.out.println(drNo.equals(drSi));
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("equals test 3:");
			System.out.println();
			drSi.setParcella(987.87);
			drSi.setSpecializzazione("Psicologo");
			System.out.println("Valori per il primo dottore:");
			System.out.println();
			drNo.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo dottore:");
			System.out.println();
			drSi.scriviOutput();
			System.out.println("Verifica false");
			System.out.println();
			System.out.println(drNo.equals(drSi));
			System.out.println();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Ancora? (S per Si, o N per No)");
			repeat = tastiera.next().charAt(0);

		} while ((repeat == 's') || (repeat == 'S'));
	}
}
