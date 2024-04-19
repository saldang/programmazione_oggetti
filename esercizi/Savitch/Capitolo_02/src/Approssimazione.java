/*
 * Approximation.java
 *
 * Created on January 29, 2007, 8:45 PM
 *
 * Solution to Exercise 1
 * and open the template in the editor.
 */

/**
 *
 * @author charleshoot
 */

import java.util.Scanner;

public class Approssimazione {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un valore floating point.");
		double x = tastiera.nextDouble();

		double y = 1.0 / x;

		if (x * y < 1.0)
			System.out.println("x*y < 1.0");
		else if (x * y > 1.0)
			System.out.println("x*y > 1.0");
		else
			System.out.println("x*y = 1.0");

		System.out.println("La differenza tra x*y e 1 e' " + (x * y - 1.0));
	}
}
