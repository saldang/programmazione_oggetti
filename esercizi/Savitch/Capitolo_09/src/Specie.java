import java.util.Scanner;

public class Specie {
	private String nome;
	private int popolazione;
	private double tassoCrescita;

	// Costruttore con tutti i parametri
	public Specie(String ilNome, int laPopolazione, double ilTassoCrescita) {
		set(ilNome, laPopolazione, ilTassoCrescita);
	}

	// Costruttore con solo il nome
	public Specie(String ilNome) {
		set(ilNome, 0, 0);
	}
	
	//Costruttore con solo la popolazione
	public Specie(int laPopolazione) {
		set("Nessun nome", laPopolazione, 0);
	}
	
	//Costruttore con solo il tasso di crescita
	public Specie(double ilTassoCrescita) {
		set("Nessun nome", 0, ilTassoCrescita);
	}
	
	//Costruttore di default
	public Specie() {
		set("Nessun nome", 0, 0);
	}

	public void set(String nuovoNome, int nuovaPopolazione, double nuovoTassoCrescita) {
		set(nuovoNome);
		set(nuovaPopolazione);
		set(nuovoTassoCrescita);
	}

	// Imposta il nome
	public void set(String nuovoNome) {
		nome = nuovoNome;
	}

	// Imposta la popolazione
	public void set(int laPopolazione) {
		if (laPopolazione >= 0)
			popolazione = laPopolazione;
		else {
			System.out.println("ERRORE: si sta usando un numero negativo per la popolazione.");
			System.exit(0);
		}
	}

	// Imposta il tasso di crescita
	public void set(double ilTassoCrescita) {
		tassoCrescita = ilTassoCrescita;
	}

	public void leggiInput() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Qual'e' il nome della specie?");
		nome = tastiera.nextLine();
		System.out.println("A quanto ammonta la popolazione?");
		popolazione = tastiera.nextInt();
		System.out.println("Inserisci il tasso di crescita (% crescita per anno):");
		tassoCrescita = tastiera.nextDouble();
	}

	public void scriviOutput() {
		System.out.println("Nome = " + nome);
		System.out.println("Popolazione = " + popolazione);
		System.out.println("Tasso crescita = " + tassoCrescita + "%");
	}

	/**
	 * Restituisce una proiezione della popolazione dopo un numero specificato di
	 * anni
	 */
	public int prediciPopolazione(int anni) {
		int risultato = 0;
		double totalePopolazione = popolazione;
		int contatore = anni;

		while ((contatore > 0) && (totalePopolazione > 0)) {
			totalePopolazione = (totalePopolazione + (tassoCrescita / 100) * totalePopolazione);
			contatore--;
		}
		if (totalePopolazione > 0)
			risultato = (int) totalePopolazione;
		return risultato;
	}

	public String getNome() {
		return nome;
	}

	public int getPopolazione() {
		return popolazione;
	}

	public double getTassoCrescita() {
		return tassoCrescita;
	}

	public boolean equals(Specie altroOggetto) {
		return (nome.equalsIgnoreCase(altroOggetto.nome)) && (popolazione == altroOggetto.popolazione)
				&& (tassoCrescita == altroOggetto.tassoCrescita);
	}
}
