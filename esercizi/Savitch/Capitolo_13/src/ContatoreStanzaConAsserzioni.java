import java.util.Scanner;

public class ContatoreStanzaConAsserzioni {

	private int contatore;

	public ContatoreStanzaConAsserzioni() {
		contatore = 0;
	}

	// get e set
	public void aggiungiPersona() {
		contatore++;
	}

	public void rimuoviPersona() {
		assert (contatore > 0);
		contatore--;
	}

	public int getContatore() {
		return contatore;
	}

	public static void main(String[] args) {

		ContatoreStanzaConAsserzioni rc = new ContatoreStanzaConAsserzioni();

		System.out.println("Il costruttore dovrebbe creare una stanza vuota");
		System.out.println("Il contatore e' " + rc.getContatore());

		System.out.println("Aggiungo 3 persone alla stanza ");
		rc.aggiungiPersona();
		rc.aggiungiPersona();
		rc.aggiungiPersona();
		System.out.println("Il contatore e' " + rc.getContatore());

		System.out.println("Rimuovo 2 persone dalla stanza ");
		rc.rimuoviPersona();
		rc.rimuoviPersona();
		System.out.println("Il contatore e' " + rc.getContatore());

		System.out.println("Rimuovo 1 persona dalla stanza ");
		rc.rimuoviPersona();
		System.out.println("Il contatore e' " + rc.getContatore());

		System.out.println("Cerco di rimuovere un'altra persona dalla stanza ");
		rc.rimuoviPersona();
		System.out.println("Il contatore e' " + rc.getContatore());

	}

}
