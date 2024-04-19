
public class InsiemeDemo {

	public static void main(String[] args) {
		// Round things
		Insieme insieme = new Insieme<String>();

		// Add some data to the set
		insieme.aggiungi("piselli");
		insieme.aggiungi("carote");
		insieme.aggiungi("torta");
		insieme.aggiungi("uva");

		System.out.println("Contenuto dell'insieme: ");
		insieme.mostraInsieme();

		// Cancella
		insieme.rimuovi("piselli");
		insieme.rimuovi("uva");

		System.out.println("Contenuto dell'insieme dopo aver rimosso piselli e uva");

		// Stampa usando l'iteratore
		Insieme<String>.InsiemeIterator i = insieme.iterator();
		i.restart();
		while (i.hasNext())
			System.out.println(i.next());
		System.out.println();
	}
}
