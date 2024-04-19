public class PagamentoContanti extends Pagamento {
	
	/**
	 * Costruttore di default. Inizializza ammontare a 0.
	 */
	public PagamentoContanti() {
		this(0);
	}

	/**
	 * Inizializza ammontare al valore passato in ingresso
	 * @param ammontare Il valore per ammontare
	 */
	public PagamentoContanti(double ammontare) {
		super(ammontare);
	}

	/**
	 * Stampa i dettagli del pagamento
	 */
	public void dettagliPagamento() {
		System.out.println("Il pagamento in contanti ammonta a " + getAmmontare());
	}
} 