public class ListaConcatenataDiStringheDemo {
	public static void main(String[] args) {
		ListaConcatenataDiStringhe lista = new ListaConcatenataDiStringhe();
		lista.aggiungiNodoInTesta("Uno");
		lista.aggiungiNodoInTesta("Due");
		lista.aggiungiNodoInTesta("Tre");
		System.out.println("La lista ha " + lista.lunghezza() + " elementi.");
		lista.mostraLista();
		if (lista.nellaLista("Tre"))
			System.out.println("Tre e' nella lista.");
		else
			System.out.println("Tre non e' nella lista.");
		lista.eliminaNodoDiTesta();
		if (lista.nellaLista("Tre"))
			System.out.println("Tre e' nella lista.");
		else
			System.out.println("Tre non e' nella lista.");
		lista.eliminaNodoDiTesta();
		lista.eliminaNodoDiTesta();
		System.out.println("Inizio lista:");
		lista.mostraLista();
		System.out.println("Fine lista.");

		lista.aggiungiNodoInCoda("1");
		System.out.println("\nInserita una stringa alla fine della lista ");
		System.out.println("Inizio lista:");
		lista.mostraLista();
		System.out.println("Fine lista.");

		lista.aggiungiNodoInCoda("2");
		lista.aggiungiNodoInCoda("2");
		lista.aggiungiNodoInCoda("2");
		lista.aggiungiNodoInCoda("3");
		System.out.println("\nInseriti tre 2 e 1 tre alla fine della lista ");
		System.out.println("\nPut three 2's  and a 3 at the end of the list ");
		System.out.println("Inizio lista:");
		lista.mostraLista();
		System.out.println("Fine lista.");

		lista.deleteLastNode();
		System.out.println("\nRimossa una stringa alla fine della lista ");
		System.out.println("Inizio lista:");
		lista.mostraLista();
		System.out.println("Fine lista.");

		lista.deleteLastNode();
		lista.deleteLastNode();
		lista.deleteLastNode();
		System.out.println("\nRimossa tre stringhe alla fine della lista ");
		System.out.println("Inizio lista:");
		lista.mostraLista();
		System.out.println("Fine lista.");

		lista.deleteLastNode();
		System.out.println("\nRimossa una stringa alla fine della lista ");
		System.out.println("Inizio lista:");
		lista.mostraLista();
		System.out.println("Fine lista.");
	}
}
