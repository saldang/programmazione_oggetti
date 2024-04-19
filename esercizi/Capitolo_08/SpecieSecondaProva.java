import java.util.Scanner;

public class SpecieSecondaProva {
	private String nome;
	private int popolazione;
	private double tassoCrescita;

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
}
