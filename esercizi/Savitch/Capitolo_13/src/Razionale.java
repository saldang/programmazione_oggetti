import java.util.Scanner;

public class Razionale {

	private int numeratore;
	private int denominatore;

	public Razionale(int numeratore, int denominatore) {
		setNumeratore(numeratore);
		setDenominatore(denominatore);
	}

	// get e set
	public void setNumeratore(int numeratore) {
		this.numeratore = numeratore;
	}

	public void setDenominatore(int denominatore) {
		if (denominatore == 0)
			throw new ArithmeticException("Denominatore del razionale e' zero");
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

		Razionale x = new Razionale(10, 13);
		Razionale y = new Razionale(-24, -30);
		Razionale z = new Razionale(60, -1234);

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

		System.out.println("Cambio il denominatore in to 0 ");
		x.setDenominatore(0);
		System.out.println("Il razionale e' " + x + " o " + x.valore());
		System.out.println("Numeratore e' " + x.getNumeratore());
		System.out.println("Denominatore e' " + x.getDenominatore());
		System.out.println();

	}

}
