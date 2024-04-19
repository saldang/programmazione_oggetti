/**
 * Questo programma calcola il numero totale di uova in un certo numero di cestini.
 * Il numero di uova per cestino e' inserito dall'utente.
 * Il numero di cestini e' inserito dall'utente.
 * Il numero totale di uova e' calcolato e visualizzato.
 * Poi vengono rimosse due uova da ciascun cestino.
 * Il nuovo numero totale di uova e' calcolato e visualizzato.
 */
import java.util.Scanner;

public class CestiniUova2 {

	public static void main(String[] args) {
		int numeroDiCestini, uovaPerCestino, totaleUova;
	
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il numero di uova per ciascun cestino:");
		uovaPerCestino = tastiera.nextInt();
		System.out.println("Inserisci il numero di cestini:");
		numeroDiCestini = tastiera.nextInt();
		
		totaleUova = numeroDiCestini * uovaPerCestino;
		
		System.out.println("Se hai");
		System.out.println(uovaPerCestino + " uova per cestino e");
		System.out.println(numeroDiCestini + " cestini");
		System.out.println("il numero totale di uova e' " + totaleUova);
		
		System.out.println("Rimuoviamo ora due uova da ciascun cestino.");
		uovaPerCestino = uovaPerCestino - 2;
		
		totaleUova = numeroDiCestini * uovaPerCestino;
		System.out.println("Ora hai");
		System.out.println(uovaPerCestino + " uova per cestino e");
		System.out.println(numeroDiCestini + " cestini.");
		System.out.println("Il nuovo numero totale di uova e' " + totaleUova);
		tastiera.close();
	}
}