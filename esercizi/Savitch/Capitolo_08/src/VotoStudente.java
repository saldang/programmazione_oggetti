
/**

 Class VotoStudente: per il voto di uno studnete.

 Questa classe memorizza i dati di uno studente per un corso:
   Nome dello studente
   Punteggio al quiz 1 (da 0 a 10 punti, 1/2 del 25% del punteggio finale)
   Punteggio al quiz 1 (da 0 a 10 punti, 1/2 del 25% del punteggio finale)
   Punteggio all'esame intermedio (da 0 a 100 punti, 25% del punteggio finale)
   Punteggio all'esame finale (da 0 a 100 punti, 50% del punteggio finale)

 La classe include i seguenti metodi pubblici:
   Richiedere e leggere i dati di ingresso.
   Visualizzare tutti i dati di ingresso.
   Richiedere e leggere solo il nome dello studente.
   Visualizzare il nome dello studente.
   Restituire il nome dello studente.
   Richiedi e leggi solo punteggio quiz 2.
   Visualizza quiz 2 punteggio.
   Ritorno quiz 2 punteggio.
   Richiedi e leggi solo punteggio medio termine.
   Visualizza punteggio a medio termine.
   Ritorno punteggio medio termine.
   Richiedi e leggi solo il punteggio dell'esame finale.
   Mostra il punteggio dell'esame finale.
   Restituire il punteggio dell'esame finale.
   Calcolare, impostare e restituire il voto finale in percentuale.
   Visualizzare il grado finale in percentuale (deve essere impostato su 1°).
   Calcola, imposta e restituisci il voto finale come lettera (A, B, C, D o F).
   Visualizzare il voto finale come lettera (deve essere impostato 1).
 */
import java.util.Scanner;

public class VotoStudente {
	// valori immessi
	private String nome;
	private int quiz1;
	private int quiz2;
	private int intermedio;
	private int finale;

	// valori calcolati
	private int votoPercentuale;
	private char votoLettera;

	// Viene creato un nuovo oggetto Scanner in ogni metodo 
	// altrimenti potrebbero crearsi problemi con nextLine
	private Scanner tastiera;

	/**
	 * Acquisisce  il nome dello studente e i punteggi dei due quiz, dell'esame intermedio e dell'esame finale.
	 * 
	 * Postcondizione: i punteggi del quiz 1 e 2 sono valori compresi tra 0 e 10. 
	 * I punteggi dell'esame intermedio e finale sono valori compresi tra 0 e 100.
	 */
	public void leggiValori() {
		tastiera = new Scanner(System.in);

		System.out.println("Nome dello studente?");
		nome = tastiera.nextLine();

		System.out.println("Punteggio quiz 1 (fino a 10 punti)?");
		quiz1 = tastiera.nextInt();
		while (quiz1 < 0 || quiz1 > 10) {
			System.out.println("Il punteggio del quiz 1 deve essere tra 0 e 10.");
			System.out.println("Inserisci un valore valido per quiz 1: ");
			quiz1 = tastiera.nextInt();
		}

		System.out.println("Punteggio quiz 2 (fino a 10 punti)?");
		quiz2 = tastiera.nextInt();
		while (quiz2 < 0 || quiz2 > 10) {
			System.out.println("Il punteggio del quiz 2 deve essere tra 0 e 10.");
			System.out.println("Inserisci un valore valido per quiz 2: ");			
			quiz2 = tastiera.nextInt();
		}

		System.out.println("Punteggio esame intermedio (fino a 100 punti)?");
		intermedio = tastiera.nextInt();
		while (intermedio < 0 || intermedio > 100) {
			System.out.println("Il punteggio dell'esame intermedio deve essere tra 0 e 100.");
			System.out.println("Inserisci un valore valido per esame intermedio: ");			
			intermedio = tastiera.nextInt();
		}

		System.out.println("Punteggio esame finale (fino a 100 punti)?");
		finale = tastiera.nextInt();
		while (finale < 0 || finale > 100) {
			System.out.println("Il punteggio dell'esame finale deve essere tra 0 e 100.");
			System.out.println("Inserisci un valore valido per esame finale: ");
			finale = tastiera.nextInt();
		}
	}

	/**
	 * Stampa il nome dello studente e i punteggi per i due quiz, 
	 * l'esame intermedio e l'esame finale.
	 * 
	 * Precondizione: Sono stati inseriti il nome e i punteggi dello studente 
	 * per i quiz 1 e 2, i punteggi dell'esame intermedio e finale.
	 */
	public void stampaValori() {
		System.out.println("Nome = " + nome);
		System.out.println("Punteggio quiz 1 (fino a 10 punti) = " + quiz1);
		System.out.println("Punteggio quiz 2 (fino a 10 punti) = " + quiz2);
		System.out.println("Punteggio esame intermedio (fino a 100 punti) = " + intermedio);
		System.out.println("Punteggio esame finale (fino a 100 punti) = " + finale);
	}

	/**
	 * Acquisisce ad imposta solo il nome
	 * 
	 * Postcondizione: è stato impostato o modificato solo il nome dello studente.
	 */
	public void leggiNome() {
		tastiera = new Scanner(System.in);
		System.out.println("Nome dello studnete?");
		nome = tastiera.nextLine();
	}

	/**
	 * Stampa il nome dello studente
	 * 
	 * Precondizone: Il nome dello studente è stato inserito
	 */
	public void stampaNome() {
		System.out.println("Nome = " + nome);
	}

	/**
	 * Restituisce il nome dello studente come tipo di Stringa.
	 *
	 * Precondizione: Il nome dello studente è stato inserito
	 */
	public String restituisciNome() {
		return nome;
	}

	/**
	 * Acquisisce ad imposta solo il valore di quiz 1
	 * 
	 * Postcondizione: è stato impostato o modificato solo il valore di quiz 1
	 */
	public void leggiQuiz1() {
		tastiera = new Scanner(System.in);
		System.out.println("Punteggio quiz 2 (fino a 10 punti)?");
		quiz1 = tastiera.nextInt();
		while ((quiz1 < 0) || (quiz1 > 10)) {
			System.out.println("Il punteggio di quiz 1 deve essere tra 0 e 10.");
			System.out.println("Inserisci un valore valido per quiz 1: ");
			quiz1 = tastiera.nextInt();
		}
	}

	/**
	 * Stampa il punteggio del quiz 1
	 * 
	 * Precondizione: Il punteggio di quiz 1 e' stato inserito
	 */
	public void stampaQuiz1() {
		System.out.println("Punteggio quiz 1 (fino a 10 punti) = " + quiz1);
	}

	/**
	 * Restituisce il punteggio del quiz 1 (un intero da 0 a 10).
	 * 
	 * Precondizione: Il punteggio di quiz 1 e' stato inserito
	 */
	public int restituisciQuiz1() {
		return quiz1;
	}

	/**
	 * Acquisisce ad imposta solo il valore di quiz 2
	 * 
	 * Postcondizione: è stato impostato o modificato solo il valore di quiz 2
	 */
	public void leggiQuiz2() {
		tastiera = new Scanner(System.in);
		System.out.println("Punteggio quiz 2 (fino a 10 punti)?");
		quiz2 = tastiera.nextInt();
		while ((quiz2 < 0) || (quiz2 > 10)) {
			System.out.println("Il punteggio di quiz 2 deve essere tra 0 e 10.");
			System.out.println("Inserisci un valore valido per quiz 2: ");
			quiz2 = tastiera.nextInt();
		}
	}

	/**
	 * Stampa il punteggio del quiz 2
	 * 
	 * Precondizione: Il punteggio di quiz 2 e' stato inserito
	 */
	public void stampaQuiz2() {
		System.out.println("Punteggio quiz 2 (fino a 10 punti)  = " + quiz2);
	}

	/**
	 * Restituisce il punteggio del quiz 2 (un intero da 0 a 10).
	 * 
	 * Precondizione: Il punteggio di quiz 2 e' stato inserito
	 */
	public int restituisciQuiz2() {
		return quiz2;
	}

	/**
	 * Acquisisce ad essegna solo il valore dell'esame intermedio
	 * 
	 * Postcondizone: solo il punteggio dell'esame intermedio è stato impostato o modificato
	 */
	public void leggiEsameIntermedio() {
		tastiera = new Scanner(System.in);
		System.out.println("Punteggio esame intermedio (fino a 100 punti)?");
		intermedio = tastiera.nextInt();
		while ((intermedio < 0) || (intermedio > 100)) {
			System.out.println("Il punteggio dell'esame intermedio deve essere tra 0 e 100.");
			System.out.println("Inserisci un valore valido per esame intermedio: ");
			intermedio = tastiera.nextInt();
		}
	}

	/**
	 * Stampa il punteggio dell'esame intermedio
	 * 
	 * Precondizione: Il punteggio dell'esame intermedio e' stato inserito
	 */
	public void stampaEsameIntermedio() {
		System.out.println("Punteggio esame intermedio (fino a 100 punti) = " + intermedio);
	}

	/**
	 * Restituisce il punteggio dell'esame intermedio (un intero da 0 a 100).
	 * 
	 * Precondizione: Il punteggio dell'esame intermedio e' stato inserito
	 */
	public int restituisciEsameIntermedio() {
		return intermedio;
	}

	/**
	 * Acquisisce ad essegna solo il valore dell'esame finale
	 * 
	 * Postcondizone: solo il punteggio dell'esame finale è stato impostato o modificato
	 */
	public void leggiEsameFinale() {
		tastiera = new Scanner(System.in);
		System.out.println("Punteggio esame finale (fino a 100 punti)?");
		finale = tastiera.nextInt();
		while ((finale < 0) || (finale > 100)) {
			System.out.println("Il punteggio dell'esame finale deve essere tra 0 e 100.");
			System.out.println("Inserisci un valore valido per esame finale: ");
			finale = tastiera.nextInt();
		}
	}

	/**
	 * Stampa il punteggio dell'esame finale
	 * 
	 * Precondizione: Il punteggio dell'esame finale e' stato inserito
	 */
	public void stampaEsameFinale() {
		System.out.println("Punteggio esame finale (fino a 100 punti)  = " + finale);
	}

	/**
	 * Restituisce il punteggio dell'esame finale (un intero da 0 a 100).
	 * 
	 * Precondizione: Il punteggio dell'esame finale e' stato inserito
	 */
	public int restituisciEsameFinale() {
		return finale;
	}

	/**
	 * Calcola, imposta e restituisce il voto percentuale dello studente utilizzando una 
	 * media ponderata: quiz 1 e 2 sono 10 punti ciascuno e insieme contano 25%, 
	 * esame intermedio è di 100 punti e conta 25%, e l'esame finale è di 100 punti e conta 50%.
	 * 
	 * Precondizione: I valori sono stati inseriti
	 * Postcondizone: Viene assegnato il valore a votoPercentuale
	 * 
	 * Nota: Il valore viene arrotondato in intero.
	 */
	public int getVotoPercentuale() {
		votoPercentuale = (int) ((double) 25 * (quiz1 + quiz2) / 20 + (double) 25 * intermedio / 100
				+ (double) 50 * finale / 100 + 0.5);
		return votoPercentuale;
	}

	/**
	 * Stampa il voto percentuale dello studente come un numero intero da 0 a 100.
	 * 
	 * Precondizone: È stato inserito il record dello studente (nome e punteggi) e il 
	 * punteggio percentuale è stato impostato con il metodo "getVotoPercentuale" 
	 */
	public void stampaVotoPercentuale() {
		System.out.println("Il voto percentuale dello studente " + nome + " e' " + votoPercentuale);
	}

	/**
	 * Determina, imposta e restituisce il voto in lettere dello studente sulla base del 
	 * voto percentuale: 90 o superiore = A, da 80 a 89 = B, da 70 a 79 = C, da 60 a 69 = D, da 0 a 59 = E.
	 * 
	 * Precondizone: È stato inserito il record dello studente (nome e punteggi) e il 
	 * punteggio percentuale è stato impostato con il metodo "getVotoPercentuale" 
	 * Postocondizione: viene aaseganat una lettera tra A, B, C, D, o F al voto finale.
	 */
	public char getVotoLettera() {
		int media = getVotoPercentuale();
		if (media >= 90)
			votoLettera = 'A';
		else if (media >= 80)
			votoLettera = 'B';
		else if (media >= 70)
			votoLettera = 'C';
		else if (media >= 60)
			votoLettera = 'D';
		else
			votoLettera = 'F';

		return votoLettera;
	}

	/**
	 * Stampa il voto in lettere dello studente sulla base del voto percentuale: 90 o superiore = A, 
	 * da 80 a 89 = B, da 70 a 79 = C, da 60 a 69 = D, da 0 a 59 = E.
	 * 
	 * Precondizone: È stato inserito il record dello studente (nome e punteggi) e il 
	 * punteggio percentuale è stato impostato con il metodo "getVotoPercentuale" 
	 */
	public void stampaVotoLettera() {
		System.out.println("Il voto in lettere dello studente " + nome + " e' " +  votoLettera);
	}
}
