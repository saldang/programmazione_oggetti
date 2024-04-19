import java.util.Scanner;

public class Oracolo {

	private String vecchiaRisposta = "La risposta e' nel tuo cuore.";
	private String nuovaRisposta;
	private String domanda;
	
	public void parla() {
		System.out.print("Sono l'oracolo. ");
		System.out.println("Rispondero' a qualsiasi domanda che digiterai su una riga.");
		Scanner tastiera = new Scanner(System.in);
		String risposta;
		do {
			rispondi();
			System.out.println("Vuoi pormi un'altra domanda?");
			risposta = tastiera.next();
		} while (risposta.equalsIgnoreCase("si"));
		System.out.println("L'oracolo ora riposa.");
	}
	
	private void rispondi() {
		System.out.println("Qual e' la tua domanda?");
		Scanner tastiera = new Scanner(System.in);
		domanda = tastiera.nextLine();
		cercaSuggerimento();
		System.out.println("Hai posto la domanda:");
		System.out.println(" " + domanda);
		System.out.println("Ora ecco la mia risposta:");
		System.out.println(" " + vecchiaRisposta);
		aggiorna();
	}
	
	private void cercaSuggerimento() {
		System.out.println("Hmm, ho bisogno di aiuto su questo.");
		System.out.println("Scrivimi una riga di aiuto.");
		Scanner tastiera = new Scanner(System.in);
		nuovaRisposta = tastiera.nextLine();
		System.out.println("Grazie. Mi ha aiutato molto");
	}
	
	private void aggiorna() {
		vecchiaRisposta = nuovaRisposta;
	}
}
