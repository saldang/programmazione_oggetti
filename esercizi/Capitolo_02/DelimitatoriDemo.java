
/**
 * Questo programma mostra come utilizzare due oggetti Scanner
 * con delimitatori diversi.
 */
import java.util.Scanner;

public class DelimitatoriDemo {

	public static void main(String[] args) {
		Scanner tastiera1 = new Scanner(System.in);
		Scanner tastiera2 = new Scanner(System.in);
		tastiera2.useDelimiter(",");
		// I delimitatori di tastiera1 sono i caratteri di spaziatura.
		// L'unico delimitatore di tastiera2 e' la stringa ##.

		String s1, s2;

		System.out.println("Scrivi una riga di testo con due parole:");
		s1 = tastiera1.next();
		s2 = tastiera1.next();
		System.out.println("Le due parole sono \"" + s1 + "\" e \"" + s2 + "\"");

		System.out.println("Scrivi una riga di testo con due parole");
		System.out.println("delimitate da ##:");
		s1 = tastiera2.next();
		s2 = tastiera2.next();
		System.out.println("Le due parole sono \"" + s1 + "\" e \"" + s2 + "\"");
		// tastiera1.close();
		// tastiera2.close();
	}
}