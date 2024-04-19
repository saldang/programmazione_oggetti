import java.util.Scanner;

public class RazionaleConAsserzioni {

	private int numeratore;
	private int denominatore;

	public RazionaleConAsserzioni(int theNumerator, int theDenominator) {
		setNumeratore(numeratore);
		setDenominatore(denominatore);
	}

	// get e set
	public void setNumeratore(int numeratore) {
		this.numeratore = numeratore;
	}

	public void setDenominatore(int denominatore) {
		assert denominatore != 0;
		this.denominatore = denominatore;
	}

	public double valore() {
		return (double) numeratore / denominatore;
	}

	public int getNumeratore() {
		return numeratore;
	}

	public int getDenominatore() {
		return denominatore;
	}

	public String toString() {
		return numeratore + "/" + denominatore;
	}

	
	public static void main(String[] args) {

		RazionaleConAsserzioni x = new RazionaleConAsserzioni(10, 13);
		RazionaleConAsserzioni y = new RazionaleConAsserzioni(-24, -30);
		RazionaleConAsserzioni z = new RazionaleConAsserzioni(60, -1234);

		System.out.println("Il costruttore dovrebbe dare 10/13");
		System.out.println("Il razionale e' " + x + " o " + x.valore());
		System.out.println("Numeratore e' " + x.getNumeratore());
		System.out.println("Denominatore e' " + x.getDenominatore());
		System.out.println();

		System.out.println("Cambio il numeratore in -24 ");
		x.setNumeratore(-24);
		System.out.println("Il razionale e' " + x + " o " + x.valore());
		System.out.println("Numeratore e' " + x.getNumeratore());
		System.out.println("Denominatore e' " + x.getDenominatore());
		System.out.println();

		System.out.println("Cambio il denominatore in -30 ");
		x.setDenominatore(-30);
		System.out.println("Il razionale e' " + x + " o " + x.valore());
		System.out.println("Numeratore e' " + x.getNumeratore());
		System.out.println("Denominatore e' " + x.getDenominatore());
		System.out.println();

		System.out.println("Cambio il denominatore in 0 ");
		x.setDenominatore(0);
		System.out.println("Il razionale e' " + x + " o " + x.valore());
		System.out.println("Numeratore e' " + x.getNumeratore());
		System.out.println("Denominatore e' " + x.getDenominatore());
		System.out.println();

	}

}
