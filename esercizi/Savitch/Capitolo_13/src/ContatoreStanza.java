import java.util.Scanner;

public class ContatoreStanza {

	private int contatore;

	public ContatoreStanza() {
		contatore = 0;
	}

	// get e set
	public void aggiungiPersona() {
		contatore++;
	}

	public void rimuoviPersona() throws ContatoreNegativoException {
		if (contatore <= 0)
			throw new ContatoreNegativoException("Non e' possibile rimuovere una persona");
		contatore--;
	}

	public int getContatore() {
		return contatore;
	}

	public static void main(String[] args) {

		ContatoreStanza rc = new ContatoreStanza();

		System.out.println("Il costruttore dovrebbe creare una stanza vuota");
		System.out.println("Il contatore e' " + rc.getContatore());

		System.out.println("Aggiungo 3 persone alla stanza ");
		rc.aggiungiPersona();
		rc.aggiungiPersona();
		rc.aggiungiPersona();
		System.out.println("Il contatore e' " + rc.getContatore());
		try {
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
		} catch (ContatoreNegativoException e) {
			System.out.println("Catturo un'eccezione: " + e.getMessage());
		}

	}

}
