import java.util.Scanner;

public class Razionale {
	private int numeratore;
	private int denominatore;

	/**
	 * Crea un'istanza di Razionale
	 */
	public Razionale() {
		numeratore = 0;
		denominatore = 1;
	}

	// Precondizone: ilDenominatore deve essere diverso da 0. Non vengono fatti
	// controlli all'interno del costruttore.
	public Razionale(int ilNumeratore, int ilDenominatore) {
		numeratore = ilNumeratore;
		denominatore = ilDenominatore;
		semplifica();
	}

	// converte un numero razionale nella sua forma più semplice;
	private void semplifica() {

		// Determina se il razionale e' positivo o negativo.
		int segno = 1;
		if (numeratore * denominatore < 0)
			segno = -1;

		int n = Math.abs(numeratore);
		int d = Math.abs(denominatore);

		int comune = getGCD(n, d);

		// garantisce che il denominatore e' positivo
		numeratore = segno * n / comune;
		denominatore = d / comune;
	}

	private static int getGCD(int n, int m) {
		// Esistono dei modi piu' veloci per calcolare il GCD
		int risultato = 1;

		for (int i = 1; i <= n; i++) {
			if ((n % i == 0) && (m % i == 0))
				risultato = i;
		}

		return risultato;
	}

	public double getValore() {
		return (double) numeratore / denominatore;
	}

	public String toString() {
		return numeratore + "/" + denominatore;
	}

	public static void main(String[] args) {

		Razionale x = new Razionale();
		Razionale y = new Razionale(-24, -30);
		Razionale z = new Razionale(60, -1234);

		System.out.println("Il costruttore di default dovrebbe dare 0/1");
		System.out.println("Il razionale e' " + x + " or " + x.getValore());
		System.out.println();

		System.out.println("Usando il costruttore con -24, -30 dovrebbe dare 4/5");
		System.out.println("Il razionale e' " + y + " o " + y.getValore());
		System.out.println();

		System.out.println("Usando il costruttore con 60, -1234 dovrebbe dare -30/617");
		System.out.println("Il razionale e' " + z + " o " + z.getValore());
		System.out.println();
	}
}
