
/** 
 * Questa classe mostra l'overloading.
 */
public class Overload {

	private static double calcolaMedia(double primo, double secondo) {
		return (primo + secondo) / 2.0;
	}

	private static double calcolaMedia(double primo, double secondo, double terzo) {
		return (primo + secondo + terzo) / 3.0;
	}

	private static char calcolaMedia(char primo, char secondo) {
		return (char)(((int)primo + (int)secondo) / 2);
	}
	
	public static void main(String args[] ) {
		double media1 = Overload.calcolaMedia(40.0, 50.0); 
		double media2 = Overload.calcolaMedia(1.0, 2.0, 3.0); 
		char media3 = Overload.calcolaMedia('a', 'c');
		
		System.out.println("media1 = " + media1);
		System.out.println("media2 = " + media2);
		System.out.println("media3 = " + media3);
	}	
}
