public class ScontoQuantita extends PoliticaSconto {
    
    private int minimo;
    private double percentuale;
    
   
    public ScontoQuantita(int minimo, double percentuale) {
        this.minimo = minimo;
        this.percentuale = percentuale;
    }
    
    public double calcolaSconto(int numeroArticoli, double prezzoArticolo){
        double sconto;
        if(numeroArticoli > minimo){
            sconto = numeroArticoli*prezzoArticolo*percentuale/100.0;
        } else {
            sconto = 0.0;
        }
        return sconto;
    }
   
   
    public static void main(String[] args) {
        PoliticaSconto bulk = new ScontoQuantita(10, 20.0);
        System.out.println("20% di sconto su piu' di 10 articoli "); 
        System.out.println("\n10 articoli a 5.0; sconto: " + bulk.calcolaSconto(10, 5.0));
        System.out.println("11 articoli a 5.0; sconto: " + bulk.calcolaSconto(11, 5.0));
        System.out.println("20 articoli a 3.0; sconto: " + bulk.calcolaSconto(20, 3.0));
    }
}



