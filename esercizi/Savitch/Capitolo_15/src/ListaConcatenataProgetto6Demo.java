public class ListaConcatenataProgetto6Demo {
	public static void main(String[] args) {
		ListaConcatenataProgetto6<Elemento> lista = new ListaConcatenataProgetto6<Elemento>();

		Elemento elemento1 = new Elemento("Banane", 2);
		lista.aagiungiInOrdine(elemento1);

		Elemento elemento2 = new Elemento("Mele", 1);
		lista.aagiungiInOrdine(elemento2);

		Elemento elemento3 = new Elemento("Ciliegie", 3);
		lista.aagiungiInOrdine(elemento3);

		System.out.println("La lista ha " + lista.lunghezza() + " nodi.");
		lista.mostraLista();
		System.out.println("Fine della lista");
	}
} 
