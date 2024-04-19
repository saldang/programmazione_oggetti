import java.util.*;

public class StatisticheEsami {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci i voti numerici nel range 0 - 30. Solo valori interi");
		System.out.println("Inserisci -1 per terminare.");
		System.out.println();

		System.out.println("Inserisci un voto da 0 a 30 o -1 per uscire ");
		int voto = tastiera.nextInt(); // Ottiene il primo voto

		int numeroDiOttimi = 0, // Tutte le somme vengono inizializzate
				numeroDiDistinti = 0, numeroDiBuoni = 0, numeroDiDiscreti = 0, numeroDiSufficienti = 0, numeroDiInsufficienti = 0, 
				sommaVoti = 0, 
				piuAlto = voto, // Inizializza al primo valore di voto
				piuBasso = voto; // Inizializza al primo valore di voto

		while (voto >= 0) { // Esce se viene inserito un valore negativo
			 //Aggiorno la somma dei voti
			sommaVoti = sommaVoti + voto;

            //Cambio piuBasso e piuAlto se necessario
            if(voto < piuBasso)
            		piuBasso = voto;
            else if(voto > piuAlto)
            		piuAlto = voto;
            
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

		if (totaleVoti > 0) { // Non esegue le stampe se nessun voto e' stato inserito
			System.out.println();
			System.out.println("Totale voti = " + totaleVoti);
			System.out.println("Numero di Ottimi = " + numeroDiOttimi);
			System.out.println("Numero di Distinti = " + numeroDiDistinti);
			System.out.println("Numero di Buoni = " + numeroDiBuoni);
			System.out.println("Numero di Discreti = " + numeroDiDiscreti);
			System.out.println("Numero di Sufficienti = " + numeroDiSufficienti);
			System.out.println("Numero di Insufficienti = " + numeroDiInsufficienti);

			System.out.println();

			float percentuale;
			percentuale = (float) numeroDiOttimi * 100 / totaleVoti;
			System.out.println("Percentuale di Ottimi = " + percentuale);
			percentuale = (float) numeroDiDistinti * 100 / totaleVoti;
			System.out.println("Percentuale di Distinti = " + percentuale);
			percentuale = (float) numeroDiBuoni * 100 / totaleVoti;
			System.out.println("Percentuale di Buoni = " + percentuale);
			percentuale = (float) numeroDiDiscreti * 100 / totaleVoti;
			System.out.println("Percentuale di Discreti = " + percentuale);
			percentuale = (float) numeroDiSufficienti * 100 / totaleVoti;
			System.out.println("Percentuale di Sufficienti = " + percentuale);
			percentuale = (float) numeroDiInsufficienti * 100 / totaleVoti;
			System.out.println("Percentuale di Insufficienti = " + percentuale);
			System.out.println();

			System.out.println("Voto piu' basso = " + piuBasso);
			System.out.println("Voto piu' alto = " + piuAlto);
			System.out.println();

			System.out.println("Media voti = " + (float) sommaVoti / totaleVoti);
		} else { // Stampa un messaggio se nessun voto e' stato inserito
			System.out.println("Nessun voto inserito.");
			System.out.println("rrivederci!");
		}
	}
}
