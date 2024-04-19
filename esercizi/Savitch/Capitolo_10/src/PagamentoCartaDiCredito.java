public class PagamentoCartaDiCredito extends Pagamento {
	private String nome;
	private String scadenza;
	private String numero;

	/**
	 * Costruttore di default. Inizializza ammontare a 0 e le stringe alla stringa blank
	 */
	public PagamentoCartaDiCredito() {
		this(0, "", "", "");
	}

	/**
	 * Inizializza tutti gli attributi
	 * @param ammontare Ammonatre del pagamento
	 * @param nome titolare della carta
	 * @param scadenza Data di scadenza della carta
	 * @param numero Numero della carta
	 */
	public PagamentoCartaDiCredito(double ammontare, String nome, String scadenza, String numero) {
		super(ammontare);
		this.nome = nome;
		this.scadenza = scadenza;
		this.numero = numero;
	}

	/**
	 * Stampa i dettagli del pagamento
	 */
	public void dettagliPagamento() {
		System.out.println("Il pagamento con la carta di credito ammonta a " + getAmmontare());
		System.out.println("Il titolare della carta e': " + nome);
		System.out.println("La data di scadenza della carta e' " + scadenza);
		System.out.println("Il numero della carta e': " + numero);
	}
} 