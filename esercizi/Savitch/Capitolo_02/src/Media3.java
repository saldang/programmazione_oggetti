
/**

  File name: Average3.java

  This program does the following:
    Prompts the user to enter three integers,
    then calculates and prints the average of the three numbers.

  Author: Lew Rakocy
  email address: LRakocy@devrycols.edu
  Date: 2/14/99
  Last changed: Updated for 4th edition by Brian Durney, November 2004

 */

import java.util.*;

public class Media3 {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int primoIntero;
		int secondoIntero;
		int terzoIntero;

		// Use double - average may have a fractional part
		double media = 0;

		System.out.println("Inserisci il primo intero.");
		primoIntero = tastiera.nextInt();
		media = media + primoIntero; // somma intermedia

		System.out.println("Inserisci il secondo intero.");
		secondoIntero = tastiera.nextInt();
		media = media + secondoIntero; // somma intermedia

		System.out.println("Inserisci il terzo intero.");
		terzoIntero = tastiera.nextInt();
		media = media + terzoIntero; // somma intermedia

		media = media / 3; // Sono stati sommati tutti i numeri, adesso si calcola la media
		System.out.println(
				"La media di " + primoIntero + ", " + secondoIntero + 
				", e " + terzoIntero + " = " + media);
	}
}
