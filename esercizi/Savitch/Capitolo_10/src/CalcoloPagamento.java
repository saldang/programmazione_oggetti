public class CalcoloPagamento {
    
    private double tariffa;
    
    public CalcoloPagamento(double tariffa) {
        this.tariffa = tariffa;
    }
   
    public double calcolaPagamento(double ore){
        return tariffa * ore;
    }
    
    public void cambiaTasso(double nuovoTasso){
        tariffa = nuovoTasso;
    }
}

