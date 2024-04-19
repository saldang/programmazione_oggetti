
/**

File name: DogBoosterShotList.java

This program reads in information about five dogs then prints
a list of all dogs that are over two years old and have not had
a booster shot.

Uses Dog.java.

Author: Lew Rakocy
email address: LRakocy@devrycols.edu
Date: 9/7/2000
Last changed: NA
Updated for fourth edition by Brian Durney, December 2004

 */
import java.util.*;

public class CaneArrayTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		Cane cani[] = new Cane[5];

		char rispostaBreve;
		String nome;
		int eta;
		double peso;
		String razza;
		boolean comandoDiRichiamo;

		// Cane 1
		System.out.println("Creo il cane alla posizone 0 dell'array:");
		System.out.println("Inserisci il nome del cane:");
		nome = tastiera.nextLine();
		System.out.println();
		System.out.println("Inserisci l'eta' del cane in anni:");
		eta = tastiera.nextInt();
		System.out.println();
		System.out.println("Inserisci il peso del cane in kg:");
		peso = tastiera.nextDouble();
		System.out.println();
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Inserisci la razza del cane:");
		razza = tastiera.nextLine();
		System.out.println();
		System.out.println("Il cane entro i 2 anni ha imparato un comando di richiamo?");
		System.out.println("Inserisci s (o S) per si e qualsiasi altro carattere per no.");
		rispostaBreve = tastiera.next().charAt(0);
		if (rispostaBreve == 's' || rispostaBreve == 'S')
			comandoDiRichiamo = true;
		else
			comandoDiRichiamo = false;
		cani[0] = new Cane(nome, eta, peso, razza, comandoDiRichiamo);

		// Cane 2
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Creo il cane alla posizone 1 dell'array:");
		System.out.println("Inserisci il nome del cane:");
		nome = tastiera.nextLine();
		System.out.println();
		System.out.println("Inserisci l'eta' del cane in anni:");
		eta = tastiera.nextInt();
		System.out.println();
		System.out.println("Inserisci il peso del cane in kg:");
		peso = tastiera.nextDouble();
		System.out.println();
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Inserisci la razza del cane:");
		razza = tastiera.nextLine();
		System.out.println();
		System.out.println("Il cane entro i 2 anni ha imparato un comando di richiamo?");
		System.out.println("Inserisci s (o S) per si e qualsiasi altro carattere per no.");
		rispostaBreve = tastiera.next().charAt(0);
		if (rispostaBreve == 's' || rispostaBreve == 'S')
			comandoDiRichiamo = true;
		else
			comandoDiRichiamo = false;
		cani[1] = new Cane(nome, eta, peso, razza, comandoDiRichiamo);

		// Cane 3
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Creo il cane alla posizone 2 dell'array:");
		System.out.println("Inserisci il nome del cane:");
		nome = tastiera.nextLine();
		System.out.println();
		System.out.println("Inserisci l'eta' del cane in anni:");
		eta = tastiera.nextInt();
		System.out.println();
		System.out.println("Inserisci il peso del cane in kg:");
		peso = tastiera.nextDouble();
		System.out.println();
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Inserisci la razza del cane:");
		razza = tastiera.nextLine();
		System.out.println();
		System.out.println("Il cane entro i 2 anni ha imparato un comando di richiamo?");
		System.out.println("Inserisci s (o S) per si e qualsiasi altro carattere per no.");
		rispostaBreve = tastiera.next().charAt(0);
		if (rispostaBreve == 's' || rispostaBreve == 'S')
			comandoDiRichiamo = true;
		else
			comandoDiRichiamo = false;
		cani[2] = new Cane(nome, eta, peso, razza, comandoDiRichiamo);

		// Cane 4
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Creo il cane alla posizone 3 dell'array:");
		System.out.println("Inserisci il nome del cane:");
		nome = tastiera.nextLine();
		System.out.println();
		System.out.println("Inserisci l'eta' del cane in anni:");
		eta = tastiera.nextInt();
		System.out.println();
		System.out.println("Inserisci il peso del cane in kg:");
		peso = tastiera.nextDouble();
		System.out.println();
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Inserisci la razza del cane:");
		razza = tastiera.nextLine();
		System.out.println();
		System.out.println("Il cane entro i 2 anni ha imparato un comando di richiamo?");
		System.out.println("Inserisci s (o S) per si e qualsiasi altro carattere per no.");
		rispostaBreve = tastiera.next().charAt(0);
		if (rispostaBreve == 's' || rispostaBreve == 'S')
			comandoDiRichiamo = true;
		else
			comandoDiRichiamo = false;
		cani[3] = new Cane(nome, eta, peso, razza, comandoDiRichiamo);

		// Cane 5
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Creo il cane alla posizone 4 dell'array:");
		System.out.println("Inserisci il nome del cane:");
		nome = tastiera.nextLine();
		System.out.println();
		System.out.println("Inserisci l'eta' del cane in anni:");
		eta = tastiera.nextInt();
		System.out.println();
		System.out.println("Inserisci il peso del cane in kg:");
		peso = tastiera.nextDouble();
		System.out.println();
		// Creo nuovo oggetto tastiera per evitare problemi con nextLine
		tastiera = new Scanner(System.in);
		System.out.println("Inserisci la razza del cane:");
		razza = tastiera.nextLine();
		System.out.println();
		System.out.println("Il cane entro i 2 anni ha imparato un comando di richiamo?");
		System.out.println("Inserisci s (o S) per si e qualsiasi altro carattere per no.");
		rispostaBreve = tastiera.next().charAt(0);
		if (rispostaBreve == 's' || rispostaBreve == 'S')
			comandoDiRichiamo = true;
		else
			comandoDiRichiamo = false;
		cani[4] = new Cane(nome, eta, peso, razza, comandoDiRichiamo);

		System.out.println();
		cani[0].scriviOutput();
		System.out.println();
		System.out.println("===============================");

		System.out.println();
		cani[1].scriviOutput();
		System.out.println();
		System.out.println("===============================");

		System.out.println();
		cani[2].scriviOutput();
		System.out.println();
		System.out.println("===============================");

		System.out.println();
		cani[3].scriviOutput();
		System.out.println();
		System.out.println("===============================");

		System.out.println();
		cani[4].scriviOutput();
		System.out.println();
		System.out.println("===============================");

		System.out.println();
		System.out.println("I cani che seguono hanno piu' di 2 anni e non hanno un comando di richiamo:");
		System.out.println();

		for (int i = 0; i < cani.length; i++) {
			if (cani[i].getEta() > 2 && !cani[i].getComandoDiRichiamo())
				System.out.println(cani[i].getNome());
		}
		System.out.println();
		System.out.println("===============================");
	}
}
