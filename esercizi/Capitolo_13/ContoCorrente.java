public class ContoCorrente {
	private double saldo;

	public ContoCorrente() {
		this(0);
	}

	public ContoCorrente(double depositoIniziale) {
		saldo = depositoIniziale;
	}

	public double getSaldo() {
		return saldo;
	}

	// Restituisce il nuovo saldo o -1 in caso di errore
	public double deposita(double somma) throws SommaNegativaException {
		if (somma > 0)
			saldo += somma;
		else
			// return -1; // Codice che segnala un errore
			throw new SommaNegativaException();
		return saldo;
	}

	// Restituisce il nuovo saldo o -1 in caso di errore
	public double ritira(double somma) throws SommaInsufficienteException, SommaNegativaException {
		if (somma > saldo)
			throw new SommaInsufficienteException();
		else if (somma < 0)
			throw new SommaNegativaException();
		else
			saldo -= somma;
		return saldo;
	}

	public static void main(String[] args) {
		ContoCorrente cc = new ContoCorrente(10);
		try {
			cc.deposita(100);
			cc.ritira(120);
			System.out.println(cc.getSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
