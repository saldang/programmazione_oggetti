import java.util.*;
import java.io.*;

public class ListaConcatenataDiSpecieAutoContenutaDemo {
	public static void main(String[] args) {
		
		ListaConcatenataDiSpecieAutoContenuta lista = new ListaConcatenataDiSpecieAutoContenuta();
		
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Immetti le informazioni.");
				char ripeti = 's';
		do {
			Specie specie = new Specie();
			specie.leggiInput();
			lista.aggiungiNodoInTesta(specie);
			System.out.println("Ancora specie?");
			ripeti = tastiera.next().charAt(0);			
		} while(ripeti == 's' || ripeti == 'S');
		
		// Cerca la specie richiesta dall'utente
		String nomeSpecie = null;
		tastiera = new Scanner(System.in);
		
		ripeti = 's'; 
		do {
			System.out.println();
			System.out.println("Inserisci il nome della specie da ricercare:");
			System.out.println();
			tastiera = new Scanner(System.in);
			nomeSpecie = tastiera.nextLine();
			System.out.println();
			if (lista.nellaLista(nomeSpecie)) {
				System.out.println("La specie " + nomeSpecie + " e' una delle ");
				System.out.println(lista.lunghezza() + " specie della lista.");

				// Per stampare le specie occorre iterare attraverso la lista.
				// Riversiamo quindi gli elementi della lista in un array.
				Specie[] arraySpecie = lista.convertiInArray();
				boolean fatto = false; 
				int i = 0; 
				while (!fatto) {
					if (arraySpecie[i].getNome().equals(nomeSpecie)) {
						System.out.println("I dati della specie " + nomeSpecie + " sono i seguenti:");
						System.out.println("Popolazione: " + arraySpecie[i].getPopolazione());
						System.out.println("Tasso di crescita: " + arraySpecie[i].getTassoCrescita());
						fatto = true;
					} else {
						++i;
						if (i == lista.lunghezza())
							fatto = true;
					}
				}
			} else {
				System.out.println("Ci sono " + lista.lunghezza() + " Specie sulla ");
				System.out.println("lista, ma " + nomeSpecie + " non e' presente.");
			}

			System.out.println();
			System.out.println("Vuoi cercare un'altra specie? (s per si)");
			ripeti = tastiera.next().charAt(0);

		} while (ripeti == 's' || ripeti == 'S');

		System.out.println("Fine del programma.");
	}
}
