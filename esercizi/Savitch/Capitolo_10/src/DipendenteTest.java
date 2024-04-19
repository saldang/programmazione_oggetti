import java.util.Scanner;

public class DipendenteTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti;
		
		do {
			Dipendente e1 = new Dipendente(); 
			System.out.println("Uso il costruttore di default:");
			e1.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e2 = new Dipendente("Mondo Kane");
			System.out.println("Uso il costruttore con il nome");
			e2.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e3 = new Dipendente("Fleetis Pascal", 111111.11);
			System.out.println("Uso il costruttore con il nome e la retribuzione annuale :");
			e3.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e4 = new Dipendente("Carl Wolf", 1968);
			System.out.println("CUso il costruttore con il nome e data assunzione:");
			e4.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e5 = new Dipendente("Sharon Kelly", "123-45-6789");
			System.out.println("Uso il costruttore con il nome e identificativo:");
			e5.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e6 = new Dipendente("Joann Rousch", 333333.33, 1963);
			System.out.println("Uso il costruttore con il nome, spidendio annuale e data assunzione:");
			e6.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e7 = new Dipendente("Lucy Sharp", 444444.44, "987-65-4321");
			System.out.println("Uso il costruttore con il nome, spidendio annuale e identificativo:");
			e7.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e8 = new Dipendente("Pierre Sokolskis", 1964, "999-99-9999");
			System.out.println("Uso il costruttore con il nome, data assunzione e identificativo:");
			e8.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			Dipendente e9 = new Dipendente("Last One", 555.55, 1999, "888-88-8888");
			System.out.println("Uso il costruttore con il nome, spidendio annuale, data assunzione e identificativo:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			System.out.println("Prima:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("Dopo il set che modifica tutti gli attributi:");
			System.out.println();
			e9.set("Nome modificato", 1010.10, 1010, "101-10-1010");
			e9.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			// change name
			e9.setNome("Jekyl N. Hyde");
			System.out.println("Dopo il metodo di set per il nome:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			// return name
			System.out.println("Metodo di get per il nome: " + e9.getNome());
			System.out.println();
			// write name
			System.out.println("Metodo di scrivi per il nome:");
			System.out.println();
			e9.scriviNome();
			System.out.println();
			// change salary
			System.out.println("Prima:");
			e9.scriviOutput();
			System.out.println();
			e9.setRetribuzioneAnnuale(987.65);
			System.out.println("Dopo il metodo di set per lo stipendio annuale:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			// return salary
			System.out.println("Metodo di get per lo stipendio annuale: " + e9.getRetribuzioneAnnuale());
			System.out.println();

			// write salary
			System.out.println("Metodo di scrivi per la retribuzione annuale:");
			System.out.println();
			e9.scriviRetribuzioneAnnuale();
			System.out.println();

			// change hire date
			System.out.println("Prima:");
			e9.scriviOutput();
			System.out.println();
			e9.setDataAssunzione(2001);
			System.out.println("Dopo il metodo di set per la data di assunzione:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			// return hire date
			System.out.println("Metodo di get per la data di assunzione: " + e9.getDataAssunzione());
			System.out.println();

			// write hire date
			System.out.println("Metodo di scrivi per la data di assunzione:");
			System.out.println();
			e9.scriviDataAssunzione();
			System.out.println();

			// change social security number
			System.out.println("Prima:");
			e9.scriviOutput();
			System.out.println();
			e9.setId("777-77-7777");
			System.out.println("Dopo il metodo di set per l'identificativo:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("===============================");

			// return social security number
			System.out.println("Metodo di get per l'identificativo: " + e9.getId());
			System.out.println();

			// write social security number
			System.out.println("Metodo di scrivi per l'identificativo:");
			System.out.println();
			e9.scriviId();
			System.out.println();

			// test equals

			// create e10 with the same vales as e9
			// and it should test true
			Dipendente e10 = new Dipendente("Jekyl N. Hyde", 987.65, 2001, "777-77-7777");
			System.out.println("Dati dipendente 9:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("Dati dipendente 10:");
			e10.scriviOutput();
			System.out.println();
			if (e9.equals(e10))
				System.out.println("TRUE: e9 uguale a e10!");
			else
				System.out.println("FALSE: e9 non e' uguale a e10.");

			System.out.println();
			e10.setId("777-77-777"); 
			System.out.println("Dopo aver cambiato un solo carattere nell'identificativo, i dati dei due dipendenti sono");
			System.out.println();
			System.out.println("Dati dipendente 9:");
			e9.scriviOutput();
			System.out.println();
			System.out.println("Dati dipendente 10:");
			e10.scriviOutput();
			System.out.println();
			if (e9.equals(e10))
				System.out.println("TRUE: e9 uguale a e10!");
			else
				System.out.println("FALSE: e9 non e' uguale a e10.");

			System.out.println("Ancora? (S for Si, or N for No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 's') || (ripeti == 'S'));
	}
}
