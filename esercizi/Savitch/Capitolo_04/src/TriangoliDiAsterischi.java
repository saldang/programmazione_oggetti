import java.util.Scanner;

public class TriangoliDiAsterischi {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un intero da 1 a 50: ");
		int numero = tastiera.nextInt();
		System.out.println();

		if (numero < 1)
			System.out.println("Numero non valido: deve essere almeno 1.");
		else if (numero > 50)
			System.out.println("Numero non valido: non puo' superare 50.");
		else { // input valido, stampa il triangolo di asterischi
			// stampa la prima meta'
			int contatoreLinea;
			int conteggioAsterischi;
			for (contatoreLinea = 1; contatoreLinea <= numero; contatoreLinea++) {
				for (conteggioAsterischi = 1; conteggioAsterischi <= contatoreLinea; conteggioAsterischi++) {
					System.out.print("*");
				}
				System.out.println();
			} // fine prima meta'

			// stampa seconda meta'
			for (contatoreLinea = numero - 1; contatoreLinea > 0; contatoreLinea--) {
				for (conteggioAsterischi = 1; conteggioAsterischi <= contatoreLinea; conteggioAsterischi++) {
					System.out.print("*");
				}
				System.out.println();
			} // fine seconda meta'
		}
	}
}
