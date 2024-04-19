/**
 * Classe di prova per l'utilizzo della classe Scanner.
 */

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
	
		System.out.println("Digita due numeri interi");
		System.out.println("separati da uno o piu' spazi:");
		
		int n1, n2;
		n1 = tastiera.nextInt();
		n2 = tastiera.nextInt();
		System.out.println("Hai digitato " + n1 + " e " + n2);
		
		System.out.println("Ora digita altri due numeri.");
		System.out.println("E' ammesso anche il separatore decimale.");
		
		double d1, d2;
		d1 = tastiera.nextDouble();
		d2 = tastiera.nextDouble();
		System.out.println("Hai digitato " + d1 + " e " + d2);
		
		System.out.println("Ora digita due parole:");
		
		String s1, s2;
		s1 = tastiera.next();
		s2 = tastiera.next();
		System.out.println("Hai digitato \"" + s1 + "\" e \"" + s2 + "\"");
		
		s1 = tastiera.nextLine(); //Necessario per gestire il '\n'
		
		System.out.println("Digita ora una riga di testo:");
		s1 = tastiera.nextLine();
		System.out.println("Hai digitato: \"" + s1 + "\"");
		tastiera.close();

	}
}