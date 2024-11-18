public class PagamentoCarta extends Pagamento {

    private String nomeIntestatario;
    private String numeroCarta;
    private String dataScadenza;

    public PagamentoCarta(double importo, String nomeIntestatario, String numeroCarta, String dataScadenza) {
        super(importo);
        this.nomeIntestatario = nomeIntestatario;
        this.numeroCarta = numeroCarta;
        this.dataScadenza = dataScadenza;
    }

    public String getNomeIntestatario() {
        return nomeIntestatario;
    }

    public void setNomeIntestatario(String nomeIntestatario) {
        this.nomeIntestatario = nomeIntestatario;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Override
    public void dettaglioPagamento() {
        super.dettaglioPagamento();
        System.out.println("Pagamento effettuato con carta:");
        System.out.println(nomeIntestatario);
        System.out.println(numeroCarta);
        System.out.println(dataScadenza);
    }

}
