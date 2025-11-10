import java.util.Scanner;

public class Specie {
	private String nome;
	private int popolazione; 
	private double tassoCrescita;
	
	//Metodi dalla classe Specie del Capitolo 8
	
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
	 Restituisce una proiezione della popolazione dopo un numero 
	 specificato di anni
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

	public void setSpecie(String nuovoNome, int nuovaPopolazione, 
		double nuovoTassoCrescita) {
		nome = nuovoNome;
		if (nuovaPopolazione >= 0)
			popolazione = nuovaPopolazione;
		else {
			System.out.println("ERRORE: si sta usando un numero negativo per la popolazione.");
			System.exit(0);
		}
		tassoCrescita = nuovoTassoCrescita;
	}

	
	public static void main(String args[]){
		Specie specieAdOggi = new Specie(); 
		
		System.out.println("Inserisci i dati sulla specie ad oggi:"); 
		specieAdOggi.leggiInput(); 
		specieAdOggi.scriviOutput();
		System.out.println("Inserisci il numero di anni su cui calcolare la proiezione:"); 
		
		Scanner tastiera = new Scanner(System.in); 
		int numeroAnni = tastiera.nextInt(); 
		int popolazioneFutura = specieAdOggi.prediciPopolazione(numeroAnni);
		System.out.println("In " + numeroAnni + " la popolazione sara' di " + popolazioneFutura);
		specieAdOggi.setSpecie("Felini", 10, 15); 
		System.out.println("La nuova specie e':"); 
		specieAdOggi.scriviOutput();
	}
}
