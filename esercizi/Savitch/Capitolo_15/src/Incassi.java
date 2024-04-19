import java.io.*;
import java.util.*;

public class Incassi {

	public static void main(String[] args) {

		ListaConcatenata<String> nomiDiStadi = new ListaConcatenata<String>();
		ListaConcatenata<Double> incassiPartita = new ListaConcatenata<Double>();

		Scanner tastiera = new Scanner(System.in);

		System.out.println(
				"Immetti le informazioni.  \nSu ogni linea immetti il nome di uno stadio e il relativo incasso");
		System.out.println("Scrivi fatto quando hai terminato");

		boolean ancoraDati = true;
		while (ancoraDati) {
			String nome = tastiera.next();
			if (nome.equals("fatto")) {
				ancoraDati = false;
			} else {
				Double incasso = tastiera.nextDouble();
				nomiDiStadi.aggiungiNodoInTesta(nome);
				incassiPartita.aggiungiNodoInTesta(incasso);
			}
		}

		// Occorre scansionare la lista: riversiamo gli elementi su ArrayList
		ArrayList<String> nomiArrayList = nomiDiStadi.convertiInArrayList();
		ArrayList<Double> incassiArrayList = incassiPartita.convertiInArrayList();

		System.out.println("Inserisci il nome dello stadio per avere l'incasso complessivo:");
		String stadio = tastiera.next();

		Double somma = 0.0;
		for (int i = 0; i < nomiArrayList.size(); i++) {
			String name = nomiArrayList.get(i);
			if (name.equals(stadio)) {
				somma += incassiArrayList.get(i);

			}
		}
		System.out.println("Il totale degli incassi e' " + somma);
	}
}
