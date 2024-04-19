/**
 * La classe StringDemo illustra l'uso di alcuni metodi della classe String.
 */

public class StringDemo {
	
	public static void main(String[] args) {		
		String frase = "Elaborazione di testi? Difficile!";
		int posizione = frase.indexOf("Difficile");
		System.out.println(frase);
		System.out.println("01234567890123456789012345678901234567");
		System.out.println("La parola \"Difficile\" inizia all'indice " + posizione);
		frase = frase.substring(0, posizione) + "Facile!";
		frase = frase.toUpperCase();
		System.out.println("La stringa modificata e':");
		System.out.println(frase);
	}
}
