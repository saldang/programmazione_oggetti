public class CalcolaImposte {
    
    private static double impostaBase = 4.0;
    private static double impostaLusso = 10.0;
    
    public static void cambiaImpostaBase(double nuovaImpostaBase){
        impostaBase = nuovaImpostaBase;
    }
    
    public static void cambiaImpostaDiLusso(double nuovaImpostaLusso){
        impostaLusso = nuovaImpostaLusso;
    }
    
    public static double computaCostoBase(double prezzo){
        double tassa = prezzo * impostaBase / 100;
        prezzo = prezzo + tassa;
        return arrotondaACentesimoVicino(prezzo);
    }
    
    
    public static double computaCostoLusso(double prezzo){
        double tassa = prezzo * impostaLusso / 100;
        prezzo = prezzo + tassa;
        return arrotondaACentesimoVicino(prezzo);
    }
    
    private static double arrotondaACentesimoVicino(double prezzo){
        prezzo = prezzo * 100;
        prezzo = java.lang.Math.round(prezzo);
        return prezzo/100;
    }
    
    public static void main(String[] args) {
        System.out.println("Collaudo il calcolo dell'imposta base.");
        System.out.println("    Prezzo senza tassa: 10.00");
        System.out.println("    costo con tassa del 4%: "+ CalcolaImposte.computaCostoBase(10.00));
        
        System.out.println("Collaudo il calcolo dell'imposta base.");
        CalcolaImposte.cambiaImpostaBase(7.5);
        System.out.println("    Prezzo senza tassa: 10.00");
        System.out.println("    costo con tassa del 7.5%: "+ CalcolaImposte.computaCostoBase(10.00));
        
        System.out.println("Collaudo il calcolo dell'imposta di lusso.");
        System.out.println("    Prezzo senza tassa: 2019.25");
        System.out.println("    costo con tassa del 10%: "+ CalcolaImposte.computaCostoLusso(2019.25));
        
        System.out.println("Collaudo il calcolo dell'imposta di lusso.");
        CalcolaImposte.cambiaImpostaDiLusso(20.0);
        System.out.println("    Prezzo senza tassa: 2019.25");
        System.out.println("    costo con tassa del 20%: "+ CalcolaImposte.computaCostoLusso(2019.25));
        
        System.out.println("Collaudo il calcolo dell'imposta base nuovamente, dovrebbe essere sempre 7.5%.");
        System.out.println("    Prezzo senza tassa: 210.99");
        System.out.println("    costo con tassa del 7.5%: "+ CalcolaImposte.computaCostoBase(210.99));      
    }
}
