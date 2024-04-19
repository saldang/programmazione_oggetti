
/**
 File Name: DipendenteLinkedListSearch.java

 Reads Dipendente records from a file and stores them in a
 linked list, then asks the user to enter a Social Security Number
 (SSN) for which to search.  Repeats until the user does not want to
 search for any more Employees.

 Use DipendenteFileReadOrWrite to create anc view files.

 Uses Employeech12LinkedListSelfcontained.

 Written by: Lew Rakocy
 email address: Lrakocy@devrycols.edu
 Date: 04/19/2003
 Updated for fourth edition by Brian Durney, January 2005.
 */
import java.util.*;
import java.io.*;

public class ListaConcatenataDiDipendentiAutoContenutaDemo {
	public static void main(String[] args) {
		ListaConcatenataDiDipendentiAutoContenuta lista = new ListaConcatenataDiDipendentiAutoContenuta();

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Immetti le informazioni del dipendente.");
		char ripeti = 's';

		do {
			System.out.println("Inserisci il nome");
			String nome = tastiera.next();
			System.out.println("Inserisci la retribuzione annuale");
			double retribuzioneAnnuale = tastiera.nextDouble();
			System.out.println("Inserisci la data di assunzione");
			int dataAssunzione = tastiera.nextInt();
			System.out.println("Inserisci il codice fisacle (id)");
			String id = tastiera.next();
			lista.aggiungiNodoInTesta(new Dipendente(nome, retribuzioneAnnuale, dataAssunzione, id));
			System.out.println("Ancora dipendenti?");
			ripeti = tastiera.next().charAt(0);
		} while (ripeti == 's' || ripeti == 'S');

		// Cerca il dipendente dato l'id
		String targetId = null;
		tastiera = new Scanner(System.in);

		ripeti = 's';
		do {
			System.out.println();
			System.out.println("Inserisci il codice fisacle (id)");
			System.out.println();
			tastiera = new Scanner(System.in);
			targetId = tastiera.nextLine();
			System.out.println();
			if (lista.nellaLista(targetId)) {
				System.out.println("Il dipendente con id " + targetId + " e' uno dei ");
				System.out.println(lista.lunghezza() + " dipendenti della lista.");

				// Per stampare le specie occorre iterare attraverso la lista.
				// Riversiamo quindi gli elementi della lista in un array.
				// iterate through the list, so copy it to an array.

				Dipendente[] arrayDipendenti = lista.convertiInArray();

				boolean fatto = false;
				int i = 0;
				while (!fatto) {
					if (arrayDipendenti[i].getId().equals(targetId)) {
						System.out.println("I dati del dipendente con id " + targetId + " sono i seguenti:");
						arrayDipendenti[i].scriviOutput();
						fatto = true;
					} else {
						++i;
						if (i == lista.lunghezza())
							fatto = true;
					}
				}
			} else {
				System.out.println("Ci sono " + lista.lunghezza() + " impiegati sulla ");
				System.out.println("lista, ma " + targetId + " non e' presente.");
			}

			System.out.println();
			System.out.println("Vuoi cercare un altro dipendente? (s per si)");
			ripeti = tastiera.next().charAt(0);

		} while (ripeti == 's' || ripeti == 'S');

		System.out.println("Fine del programma.");

	}

}
