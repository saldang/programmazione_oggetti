import java.util.*;

public class ContributoPercentualeAllaSomma {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Quanti numeri verranno inseriti?");
		int numeri;
		numeri = tastiera.nextInt();
		System.out.println();

		int[] laLista = new int[numeri];
		int indice;
		int somma;
		int percentuale;

		System.out.println("Inserire " + numeri + " numeri,");
		System.out.println("uno per riga.");

		for (indice = 0; indice < numeri; indice++) {
			System.out.println("Inserire numero " + (indice + 1) + ": ");
			laLista[indice] = tastiera.nextInt();
		}

		System.out.println();
		System.out.print("Hai riempito l'array con ");
		System.out.println(numeri + " numeri.");
		System.out.println();

		somma = calcolaSomma(laLista, numeri);
		System.out.println();
		System.out.println("La somma e' " + somma);
		System.out.println();

		System.out.println("I numeri sono:");
		System.out.println();
		for (indice = 0; indice < numeri; indice++)
			System.out.println(
					laLista[indice] + ", che e' il " + (int) (((double) laLista[indice] / somma) * 100 + 0.5) + "% della somma.");
		System.out.println();
	}

	public static int calcolaSomma(int[] listaDiValori, int lunghezzaLista) {
		int totale = 0;
		for (int i = 0; i < lunghezzaLista; i++)
			totale = totale + listaDiValori[i];

		return (totale);
	}
}
