public class Polinomio {
    private double[] coefficienti;
    private int grado;
    
    /**
     * Crea una nuova istanza di Polinomio
     */
    public Polinomio(int massimo) {
        grado = massimo;
        coefficienti = new double[grado+1];
    }
    
    public void setCostante(int i, double valore){
        if(i>=0 && i<=grado)
            coefficienti[i] = valore;
    }
    
    public double valuta(double x){
        double somma = 0.0;
        double xi = 1.0;
        for(int i=0; i<=grado; i++){
            somma += coefficienti[i]*xi;
            xi *= x;
        }
        return somma;
    }
    
    public static void main(String[] args) {
        System.out.println("Costruisco un polinomio");
        //a0 = 3, a1 = 5, a2 = 0, and a3 = 2
        Polinomio p = new Polinomio(5);
        p.setCostante(0, 3);
        p.setCostante(1, 5);
        p.setCostante(2, 0);
        p.setCostante(3, 2);
        
        System.out.println("La valutazione del polinomio a 0 dovrebbe dare 3");
        System.out.println("\tSi ottiene: " + p.valuta(0));
        
        System.out.println("La valutazione del polinomio a 1 dovrebbe dare 10");
        System.out.println("\tSi ottiene: " + p.valuta(1));
        
        System.out.println("La valutazione del polinomio a 7 dovrebbe dare 724");
        System.out.println("\tSi ottiene: " + p.valuta(7));

        System.out.println("La valutazione del polinomio a 1/2 dovrebbe dare 5.75");
        System.out.println("\tSi ottiene: " + p.valuta(0.5));

        
        
    }
    
}
