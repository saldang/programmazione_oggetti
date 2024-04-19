import java.util.Scanner;

/**
 Questo esempio della classe Specie serve solo per mostrare
 la differenza tra parametri di tipo classe e parametri di tipo primitivo.
 */
public class SpecieDemo {
	private String nome;
	private int popolazione;
	private double tassoCrescita;

	/**
	 Prova ad assegnare all'argomento variabileInt il valore 
	 di popolazione ma il parametro primitivo non puo' esser
	 modificato
	*/
	public void provaACambiare(int variabileInt) {
		variabileInt = this.popolazione;
	}

	/**
     Prova a far si che altroOggetto referenzi l'oggetto this.
     Ma non si possono sostituire gli argomenti di tipo classe.
	*/
	public void provaASostituire(SpecieDemo altroOggetto) {
		altroOggetto = this;
	}

	/**
     Cambia i dati in altro oggetto con quelli dell'oggetto this,
     che non viene modificato.
	*/
	public void cambia(SpecieDemo altroOggetto) {
		altroOggetto.nome = this.nome;
		altroOggetto.popolazione = this.popolazione;
		altroOggetto.tassoCrescita = this.tassoCrescita;
	}


	public void leggiInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Qual'e' il nome della specie?");
		nome = keyboard.nextLine();
		System.out.println("A quanto ammonta la popolazione?");
		popolazione = keyboard.nextInt();
		System.out.println("Inserisci il tasso di crescita (% crescita per anno):");
		tassoCrescita = keyboard.nextDouble();
	}

	public void scriviOutput() {
		System.out.println("Nome = " + nome);
		System.out.println("Popolazione = " + popolazione);
		System.out.println("Tasso crescita = " + tassoCrescita + "%");
	}


	/**
	 Restituisce una proiezione della popolazione dopo un numero  specificato
	 di anni
	 */
	public int prediciPopolazione(int anni) {

		int risultato = 0;
		double totalePopolazione = popolazione;
		int conteggio = anni;
		while ((conteggio > 0) && (totalePopolazione > 0)) {
			totalePopolazione = (totalePopolazione + (tassoCrescita / 100) * totalePopolazione);
			conteggio--;
		}
		if (totalePopolazione > 0)
			risultato = (int) totalePopolazione;
		return risultato;
	}


	public void setSpecie(String nuovoNome, int nuovaPopolazione, double nuovoTassoCrescita) {
		nome = nuovoNome;
		if (nuovaPopolazione >= 0)
			popolazione = nuovaPopolazione;
		else {
			System.out.println( "ERRORE: si sta usando un numero negativo per la popolazione.");
			System.exit(0);
		}

		tassoCrescita = nuovoTassoCrescita;
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

	public boolean equals(SpecieDemo altroOggetto) {
		return (this.nome.equalsIgnoreCase(altroOggetto.nome)) && 
			(this.popolazione == altroOggetto.popolazione) && 
			(this.tassoCrescita == altroOggetto.tassoCrescita);
	}
}
