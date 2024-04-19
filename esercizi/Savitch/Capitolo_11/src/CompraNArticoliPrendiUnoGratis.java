public class CompraNArticoliPrendiUnoGratis extends PoliticaSconto {
    
    private int gratisOgni;
    
    
    public CompraNArticoliPrendiUnoGratis(int n ) {
        gratisOgni = n;
    }
    
    public double calcolaSconto(int numeroArticoli, double prezzoArticolo){
        double sconto;
        int multipli = numeroArticoli/gratisOgni;
        sconto = multipli * prezzoArticolo;
        
        return sconto;
    }
    
    
   public static void main(String[] args) {
        PoliticaSconto nItems = new CompraNArticoliPrendiUnoGratis(3);
        System.out.println("Ogni 3 articoli il terzo e' gratuito \n");
        for(int i=2; i<11; i++){
            System.out.println(i + " articoli a 5.0; sconto: " + nItems.calcolaSconto(i, 5.0));
        }
    }
}




