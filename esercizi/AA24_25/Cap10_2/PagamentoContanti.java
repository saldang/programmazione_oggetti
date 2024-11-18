public class PagamentoContanti extends Pagamento {
    PagamentoContanti(double importo) {
        super(importo);
    }

    @Override
    public void dettaglioPagamento() {
        super.dettaglioPagamento();
        System.out.println("Pagamento effettuato in contanti.");
    }
}
