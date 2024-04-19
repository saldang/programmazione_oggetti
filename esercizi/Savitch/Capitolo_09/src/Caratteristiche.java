import java.util.Scanner;

public class Caratteristiche {

	private String descrizione;
	private int punteggio;

	/**
	 * Crea una nuova istanza di Carattteristiche
	 */
	public Caratteristiche(String desc) {
		descrizione = desc;
		punteggio = 0;
	}

	private boolean valido(int punteggio) {
		return (punteggio >= 1 && punteggio <= 10);
	}

	public void setPunteggio(int unPunteggio) {
		if (valido(unPunteggio))
			punteggio = unPunteggio;
	}

	public void setPunteggio() {
		System.out.println("Punteggio per " + descrizione + "?");
		System.out.println("Inserisci un valore da 1 a 10");

		Scanner tastiera = new Scanner(System.in);
		int data = -1;
		boolean occorrePunteggio = true;

		while (occorrePunteggio) {
			data = tastiera.nextInt();
			if (valido(data)) {
				occorrePunteggio = false;
			} else {
				System.out.println("Il punteggio non e' valido.");
				System.out.println("Inserisci un valore da 1 a 10");
			}
		}

		setPunteggio(data);
	}

	public String toString() {
		return descrizione + " ha punteggio " + punteggio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public double getCompatibilita(Caratteristiche altraCaratteristica) {
		if (!corrispondenza(altraCaratteristica))
			return 0.0;
		else
			return getMisuraCompatibilita(altraCaratteristica);
	}

	private boolean corrispondenza(Caratteristiche altraCaratteristica) {
		return descrizione.equals(altraCaratteristica.getDescrizione());
	}

	private double getMisuraCompatibilita(Caratteristiche altroPunteggio) {
		int r1 = punteggio;
		int r2 = altroPunteggio.getPunteggio();

		if (r1 == 0 || r2 == 0) {
			return 0.0;
		} else {
			return (1.0 - (r1 - r2) * (r1 - r2) / 81.0);
		}
	}

	public static void main(String[] args) {

		Caratteristiche sportivo = new Caratteristiche("sportivo");
		Caratteristiche daSpiaggia = new Caratteristiche("da spiaggia");

		sportivo.setPunteggio();
		System.out.println("Punteggio: " + sportivo);
		System.out.println();

		daSpiaggia.setPunteggio();
		System.out.println("Punteggio: " + daSpiaggia);
		System.out.println();

		Caratteristiche Joe = new Caratteristiche("surfista");
		Joe.setPunteggio(6);
		Caratteristiche Sue = new Caratteristiche("surfista");
		Sue.setPunteggio(6);

		System.out.println("La misura di compatibilita' dovrebbe essere 1");
		System.out.println("\t" + Joe.getCompatibilita(Sue));

		System.out.println("La misura di compatibilita' dovrebbe essere 0");
		System.out.println("\t" + Joe.getCompatibilita(sportivo));

		Joe.setPunteggio(1);
		Sue.setPunteggio(9);
		System.out.println("La misura di compatibilita' dovrebbe essere circa 0.209");
		System.out.println("\t" + Joe.getCompatibilita(Sue));

		Joe.setPunteggio(2);
		Sue.setPunteggio(9);
		System.out.println("La misura di compatibilita' dovrebbe essere circa 0.395");
		System.out.println("\t" + Joe.getCompatibilita(Sue));

	}

}
