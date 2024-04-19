import java.util.Scanner;

/**
 * Classe che descrive un animale serializzabile
 * 
 * Class for basic pet records: name, age, and weight.
 * 
 * La classe e' la stessa del listato 9.1 ad eccezione di: 1. Implementa
 * Serializable. 2. Ha un metodo di lettura leggiInput simile a quello di
 * Specie, Listato 14.10 3. Ha un metodo toString simile a quello di Specie,
 * Listato 14.10
 */
public class AnimaleRecord {
	private String nome;
	private int eta; // in anni
	private double peso; // in Kg

	public AnimaleRecord() {
		nome = "Nessun nome";
		eta = 0;
		peso = 0;
	}

	public AnimaleRecord(String nomeIniziale, int etaIniziale, double pesoIniziale) {
		nome = nomeIniziale;
		if ((etaIniziale < 0) || (pesoIniziale < 0)) {
			System.out.println("Errore: eta' o peso negativi.");
			System.exit(0);
		} else {
			eta = etaIniziale;
			peso = pesoIniziale;
		}
	}

	public void setAnimale(String nuovoNome, int nuovaEta, double nuovoPeso) {
		nome = nuovoNome;
		if ((nuovaEta < 0) || (nuovoPeso < 0)) {
			System.out.println("Errore: eta' o peso negativi.");
			System.exit(0);
		} else {
			eta = nuovaEta;
			peso = nuovoPeso;
		}
	}

	public AnimaleRecord(String nomeIniziale) {
		nome = nomeIniziale;
		eta = 0;
		peso = 0;
	}

	public void setNome(String nuovoNome) {
		nome = nuovoNome; // eta' e peso rimangono invariate
	}

	public AnimaleRecord(int etaIniziale) {
		nome = "Nessun nome";
		peso = 0;
		if (etaIniziale < 0) {
			System.out.println("Errore: eta' negativa.");
			System.exit(0);
		} else {
			eta = etaIniziale;
		}
	}

	public void setEta(int nuovaEta) {
		if (nuovaEta < 0) {
			System.out.println("Errore: eta' negativa.");
			System.exit(0);
		} else {
			eta = nuovaEta;
			// nome e peso rimangono invariate
		}
	}

	public AnimaleRecord(double pesoIniziale) {
		nome = "Nessun nome";
		eta = 0;
		if (pesoIniziale < 0) {
			System.out.println("Errore: peso negativo.");
			System.exit(0);
		} else {
			peso = pesoIniziale;
		}
	}

	public void setPeso(double nuovoPeso) {
		if (nuovoPeso < 0) {
			System.out.println("Errore: peso negativo.");
			System.exit(0);
		} else {
			peso = nuovoPeso;
			// nome e eta' rimangono invariate
		}
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}

	public double getPeso() {
		return peso;
	}

	public void scriviOutput() {
		System.out.println("Nome: " + nome);
		System.out.println("Eta: " + eta + " anni");
		System.out.println("Peso: " + peso + " Kg");
	}

	public void leggiInput() {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Nome dell'animale:");
		nome = tastiera.nextLine();
		System.out.println("Eta dell'animale:");
		eta = tastiera.nextInt();
		if (eta < 0) {
			System.out.println("Errore: l'eta' non puo' essere negativa.");
			System.exit(0);
		}
		System.out.println("Peso dell'animale:");
		peso = tastiera.nextDouble();
		if (peso < 0) {
			System.out.println("Errore: il peso non puo' essere negativo.");
			System.exit(0);
		}
	}

	public String toString() {
		return ("Nome = " + nome + "\n" + "Eta' = " + eta + "\n" + "Peso = " + peso + "\n");
	}
}
