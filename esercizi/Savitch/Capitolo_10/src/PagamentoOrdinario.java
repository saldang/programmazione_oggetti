public class PagamentoOrdinario extends CalcoloPagamento {
    
    public PagamentoOrdinario(double laTariffa) {
        super(laTariffa);
    }
   
    public static void main(String[] args) {
        PagamentoOrdinario pagamento = new PagamentoOrdinario(7.5);
        System.out.println("Demo classi pagamento "); 
        System.out.println("\n40 ore a 7.5 costano " + pagamento.calcolaPagamento(40));
        pagamento.cambiaTasso(10.22);
        System.out.println("3.5 ore a 10.22 costano " + pagamento.calcolaPagamento(3.5));
    }
}


