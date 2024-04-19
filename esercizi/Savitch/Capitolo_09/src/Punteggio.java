import java.util.Scanner;

public class Punteggio {
	private String descrizione;
	private int punteggioMassimo;
	private int punteggio;

	
	public Punteggio(String descrizoneAssegnata, int max) {
		descrizione = descrizoneAssegnata;
		punteggioMassimo = max;
		punteggio = -1;
	}

	public Punteggio() {
		descrizione = "da 0 a 10";
		punteggioMassimo = 10;
		punteggio = -1;
	}

	public void ottieniPunteggio() {
		System.out.println("Che punteggio assegni a " + descrizione + "?");
		System.out.println("Inserisci un intero fra 0 e " + punteggioMassimo);

		Scanner tastiera = new Scanner(System.in);
		int data = -1;
		boolean inputScorretto = true;

		while (inputScorretto) {
			data = tastiera.nextInt();
			if (data >= 0 && data <= punteggioMassimo) {
				inputScorretto = false;
			} else {
				System.out.println("Il punteggio inserito non e' valido.");
				System.out.println("Inserisci un intero fra 0 e " + punteggioMassimo);
			}
		}

		punteggio = data;
	}

	public int getPunteggioMassimo() {
		return punteggioMassimo;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public String getPunteggioInFormatoStringa() {
		return "il punteggio e' " + punteggio + "/" + punteggioMassimo;
	}

	public static void main(String[] args) {

		Punteggio punteggioFilm = new Punteggio("Film preferito", 5);
		Punteggio punteggioRistorante = new Punteggio();

		punteggioFilm.ottieniPunteggio();
		System.out.println("Visualizza degli attributi per la classificazione dei film.");
		System.out.println("Il punteggio e' " + punteggioFilm.getPunteggio() + " su " + punteggioFilm.getPunteggioMassimo());
		System.out.println();

		punteggioRistorante.ottieniPunteggio();
		System.out.println("Visualizza la classifica dei ristoranti.");
		System.out.println(punteggioRistorante.getPunteggioInFormatoStringa());
	}
}
