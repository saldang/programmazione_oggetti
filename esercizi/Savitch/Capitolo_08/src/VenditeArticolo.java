import java.util.Scanner;

public class VenditeArticolo {

	private int numeroVenduti;
	private double totaleVendite;
	private double totaleScontati;
	private double costoArticolo;
	private int qtaIngrosso;
	private double percentualeScontoQtaIngrosso;

	public void inizializza(double costo, int ingrosso, double sconto) {
		numeroVenduti = 0;
		totaleVendite = 0.0;
		totaleScontati = 0.0;
		costoArticolo = costo;
		qtaIngrosso = ingrosso;
		percentualeScontoQtaIngrosso = sconto;
	}

	public void mostraVendite() {
		System.out.println("Totale vendite : " + totaleVendite + " per la vendita di " + numeroVenduti
				+ " pezzi con " + totaleScontati + " totali scontati.");
	}

	public void registraVendita(int n) {
		if (n > 0) {
			double costoBase = costoArticolo * n;
			double scontoEffettuato = 0.0;
			numeroVenduti += n;
			if (n >= qtaIngrosso) {
				scontoEffettuato = costoBase * percentualeScontoQtaIngrosso / 100;
			}
			totaleVendite += (costoBase - scontoEffettuato);
			totaleScontati += scontoEffettuato;

		}

	}

	public static void main(String[] args) {

		VenditeArticolo venditaCocaCola = new VenditeArticolo();
		venditaCocaCola.inizializza(1.0, 10, 90.0);

		System.out.println("Stiamo vendendo 1 lattina di Coca Cola. Dovrebbe costare 1.0 senza sconto");
		venditaCocaCola.registraVendita(1);
		venditaCocaCola.mostraVendite();
		System.out.println();

		System.out.println("Stiamo vendendo 9 lattine di Coca Cola. Dovrebbero costare 9.0 senza sconto");
		System.out.println("**** Il totale dovrebbe essere 10 lattine, totale vendita: 10.0, sconto: 0.0");
		venditaCocaCola.registraVendita(9);
		venditaCocaCola.mostraVendite();
		System.out.println();

		System.out.println("Stiamo vendendo 10 lattine di Coca Cola. Dovrebbero costare 1.0 con uno sconto di 9.0");
		System.out.println("**** Il totale dovrebbe essere 20 lattine, totale vendita: 11.0, sconto: 9.0");
		venditaCocaCola.registraVendita(10);
		venditaCocaCola.mostraVendite();
		System.out.println();

		System.out.println("Stiamo vendendo 50 lattine di Coca Cola. Dovrebbero costare 5.0 con uno sconto di 45.0");
		System.out.println("**** Il totale dovrebbe essere 70 lattine, totale vendita: 16.0, sconto: 54.0");
		venditaCocaCola.registraVendita(50);
		venditaCocaCola.mostraVendite();
	}

}
