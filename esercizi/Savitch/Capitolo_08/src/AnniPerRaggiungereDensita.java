import java.util.Scanner;

public class AnniPerRaggiungereDensita {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		SpecieConDensita s1 = new SpecieConDensita();

		// legge le informazioni sulla specie
		s1.leggiInput();

		// legge la dimensione dell'area
		System.out.println("Inserisci l'area (in km quadrati): ");
		double area = tastiera.nextDouble();

		// legge la densita' obiettivo da raggiungere
		System.out.println("Inserisci la densita' obiettivo da raggiungere: ");
		double densitaObiettivo = tastiera.nextDouble();

		// condizone speciale:
		// Cosa succede se è già oltre la densita' obiettivo?
		if (s1.getDensita(area) >= densitaObiettivo) {
			System.out.println();
			System.out.println(
					"Densita' per " + s1.getNome() + " e' gia' " + densitaObiettivo + " o maggiore per km quadrato.");
		}

		else {
			// Identifica il numero di anni necessari affinche' la specie raggiunga la densita' obiettivo
			int anni = 1;
			while (s1.prediciPopolazione(anni) / area < densitaObiettivo) {
				anni = anni + 1;
			}
			System.out.println("Specie " + s1.getNome() + " raggiungera' " + densitaObiettivo + " per km quadrato in "
					+ anni + " anni.");
		}
	}
}
