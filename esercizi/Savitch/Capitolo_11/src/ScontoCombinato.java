public class ScontoCombinato extends PoliticaSconto {
    
    private PoliticaSconto politica1;
    private PoliticaSconto politica2;
    
    
    public ScontoCombinato(PoliticaSconto politica1, PoliticaSconto politica2) {
        this.politica1 = politica1;
        this.politica2 = politica2;
    }
    
    public double calcolaSconto(int numeroArticoli, double prezzoArticolo){
        double sconto1;
        double sconto2;
        
        sconto1 = politica1.calcolaSconto(numeroArticoli, prezzoArticolo);
        sconto2 = politica2.calcolaSconto(numeroArticoli, prezzoArticolo);
        
        if(sconto1 > sconto2)
            return sconto1;
        else
            return sconto2;
    }
    
    
   public static void main(String[] args) {
        PoliticaSconto nItems = new CompraNArticoliPrendiUnoGratis(3);
        PoliticaSconto bulk = new ScontoQuantita(5, 30.0);
        PoliticaSconto combo = new ScontoCombinato(nItems, bulk);
        
        System.out.println("Politica 1: ogni terzo articolo e' gratuito \n");
        System.out.println("Politica 2: 30% di sconto sopra i 5 articoli \n");
        for(int i=2; i<11; i++){
            System.out.println(i + " articoli a 5.0; " 
                    + ";  sconto 1 e' " + nItems.calcolaSconto(i, 5.0)
                    + ";  sconto 2 e' " + bulk.calcolaSconto(i, 5.0)
                    + ";  combinati forniscono  " + combo.calcolaSconto(i, 5.0));
        }
    }
}




