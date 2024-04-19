import java.util.*;

public class NumeroDiVoti {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci i voti numerici nel range 0 - 30. Solo valori interi");
		System.out.println("Inserisci -1 per terminare.");
		System.out.println();

		System.out.println("Inserisci un voto da 0 a 30 o -1 per uscire ");
		int voto = tastiera.nextInt(); // Ottiene il primo voto

		int numeroDiOttimi = 0, // Tutte le somme vengono inizializzate
				numeroDiDistinti = 0, numeroDiBuoni = 0, numeroDiDiscreti = 0, numeroDiSufficienti = 0, numeroDiInsufficienti = 0; 

		while (voto >= 0) { // Esce se viene inserito un valore negativo			 
			if (voto >= 29)
				numeroDiOttimi = numeroDiOttimi + 1;
			else if (voto >= 26)
				numeroDiDistinti = numeroDiDistinti + 1;
			else if (voto >= 23)
				numeroDiBuoni = numeroDiBuoni + 1;
			else if (voto >= 20)
				numeroDiDiscreti = numeroDiDiscreti + 1;
			else if (voto >= 18)
				numeroDiSufficienti = numeroDiSufficienti + 1;
			else 
				numeroDiInsufficienti = numeroDiInsufficienti + 1;

			System.out.println("Inserisci un voto da 0 a 30 o -1 per uscire ");
			voto = tastiera.nextInt(); // Il prossimo voto
		}

		int totaleVoti = numeroDiOttimi + numeroDiDistinti + numeroDiBuoni + numeroDiDiscreti + numeroDiSufficienti + numeroDiInsufficienti;

		System.out.println();
		System.out.println("Totale voti = " + totaleVoti);
		System.out.println("Numero di Ottimi = " + numeroDiOttimi);
		System.out.println("Numero di Distinti = " + numeroDiDistinti);
		System.out.println("Numero di Buoni = " + numeroDiBuoni);
		System.out.println("Numero di Discreti = " + numeroDiDiscreti);
		System.out.println("Numero di Sufficienti = " + numeroDiSufficienti);
		System.out.println("Numero di Insufficienti = " + numeroDiInsufficienti);
	}
}
