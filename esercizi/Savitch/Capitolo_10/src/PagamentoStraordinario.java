public class PagamentoStraordinario extends CalcoloPagamento {
    
    public PagamentoStraordinario(double tariffa) {
        super(tariffa);
    }
    
    public double calcolaPagamento(double ore){
        return super.calcolaPagamento(ore)* 1.5;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PagamentoStraordinario pagamento = new PagamentoStraordinario(7.5);
        System.out.println("Demo classi pagamento ");
        System.out.println("\n40 ore a 7.5 costano " + pagamento.calcolaPagamento(40));
        pagamento.cambiaTasso(10.22);
        System.out.println("3.5 ore a 10.22 costano " + pagamento.calcolaPagamento(3.5));
    }  
}



