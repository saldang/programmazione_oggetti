import java.util.Scanner;

/** 
 Dimostrazione di utilizzo della classe ConvertitoreDimensioni
 */
public class ConvertitoreDimensioniDemo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in); 
		System.out.print("Inserisci una misura in pollici: "); 
		double pollici = tastiera.nextDouble();

		double piedi = ConvertitoreDimensioni.convertiPolliciInPiedi(pollici);
		System.out.println(pollici + " pollici = " + piedi + " piedi.");

		System.out.print("Inserisci una misura in piedi: "); 
		piedi = tastiera.nextDouble(); 
		pollici = ConvertitoreDimensioni.convertiPiediInPollici(piedi);
		System.out.println(piedi + " piedi = " + pollici + " pollici.");
	}
}