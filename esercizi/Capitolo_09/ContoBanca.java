/**
 * Una classe con variabili di istanza e variabili statiche. 
 */
public class ContoBanca {
	private double saldo; 
	public static double tassoInteresse = 0; 
	public static int numeroDiConti = 0;

	public ContoBanca() {
		saldo = 0; 
		numeroDiConti++;
	}

	public static void setTassoInteresse(double nuovoTasso) {
		tassoInteresse = nuovoTasso;
	}

	public static double getTassoInteresse() {
		return tassoInteresse; 
	}

	public static int getNumeroDiConti() {
		return numeroDiConti;
	}

	public void deposita(double somma) {
		saldo = saldo + somma;
	}

	public double preleva(double ammontare) {
		if (saldo >= ammontare) 
			saldo = saldo - ammontare;
		else
			ammontare = 0;
		return ammontare;
	}

	public void aggiungiInteresse() {
		double interesse = saldo * tassoInteresse; 
		//si puo sostituire tassoInteresse con getTassoInteresse()
		saldo = saldo + interesse;
	}

	public double getSaldo() {
		return saldo; 
	}

	public static void mostraSaldo(ContoBanca conto) {
		System.out.print(conto.getSaldo());
	}
}
