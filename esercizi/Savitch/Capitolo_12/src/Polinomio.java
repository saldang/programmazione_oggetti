import java.util.ArrayList;

public class Polinomio {
    private ArrayList<Double> coefficienti;
    private int grado;
    
    /**
     * Crea una nuova istanza di Polinomio
     */
    public Polinomio(int massimo) {
        grado = massimo;
        coefficienti = new ArrayList<Double>();
        for(int i=0; i<=grado; i++)
        	coefficienti.add(0.0);
    }
    
    public void setCostante(int i, double valore){
        if(i>=0 && i<=grado)
        	coefficienti.set(i, valore);
        else if(i>grado){
            // se i è fuori dai limiti, aggiungi 0.0
            while(coefficienti.size() < i)
            	coefficienti.add(0.0);
            // aggiunge
            coefficienti.add(valore);
            //e aggiona gradi
            grado = i;
        }
    }
    
    public double valuta(double x){
        double somma = 0.0;
        double xi = 1.0;
        for(int i=0; i<=grado; i++){
            somma += coefficienti.get(i)*xi;
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

        System.out.println("La valutazione del polinomio a 2 dovrebbe dare 29");
        System.out.println("\tGot: " + p.valuta(2));
        
        p.setCostante(10, 1);
        System.out.println("La valutazione del polinomio a 2 dovrebbe dare 1053");
        System.out.println("\tGot: " + p.valuta(2));

        p.setCostante(8, 3);
        System.out.println("La valutazione del polinomio a 2 dovrebbe dare 1821");
        System.out.println("\tGot: " + p.valuta(2));

        p.setCostante(13, 5);
        System.out.println("La valutazione del polinomio a 2 dovrebbe dare 42781");
        System.out.println("\tGot: " + p.valuta(2));
    }    
}
