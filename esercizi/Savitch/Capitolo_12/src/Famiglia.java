public class Famiglia {

	private double reddito;
	private int dimensione;

	/**
	 * Crea una nuova istanza di Famiglia
	 */
	public Famiglia(double ilReddito, int laDimensione) {
		reddito = ilReddito;
		dimensione = laDimensione;
	}

	public boolean povera(double costoCasa, double costoCibo) {
		return costoCasa + costoCibo * dimensione > 0.5 * reddito;
	}

	public String toString() {
		return dimensione + " persone con reddito complessivo di " + reddito;
	}
}
