import java.util.ArrayList;
import java.util.Scanner;

public class LibroMastro {
    
	private ArrayList<Double> vendite;
    private int venditeEffettuate;
    
    /**
     * Crea un'istanza di LibroMastro
     */
    public LibroMastro(int max){
        vendite = new ArrayList<Double>();
        venditeEffettuate = 0;       
    }
    
    public void aggiungiVendita(double d){
            vendite.add(d);;
            venditeEffettuate++;
    }
    
    public int getNumeroDiVendite(){
        return venditeEffettuate;
    }
        
    public double getTotaleVendite(){
        double risultato = 0.0;
        for(int i=0; i<venditeEffettuate; i++){
            risultato += vendite.get(i);
        }
        return risultato;
    }
    
    public double getMediaVendite(){
        if(venditeEffettuate > 1)
            return getTotaleVendite()/getNumeroDiVendite();
        else
            return 0.0;
    }
    
    public int getVenditeAlDiSopra(double soglia){
        int count = 0;
        for(int i=0; i<venditeEffettuate; i++){
            if(vendite.get(i) > soglia)
                count++;
        }
        
        return count;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Collado di LibroMastro: ");
        System.out.println("Aggiungo vendite 3.52, 2.43, 9.00, 3.5, 5.0");
        
        LibroMastro sales = new LibroMastro(10);
        sales.aggiungiVendita(3.52);
        sales.aggiungiVendita(2.43);
        sales.aggiungiVendita(9.0);
        sales.aggiungiVendita(3.5);
        sales.aggiungiVendita(5.0);
        
        System.out.println("Il numero di vendite e': " + sales.getNumeroDiVendite());
        System.out.println("Il totale delle vendite e': " + sales.getTotaleVendite());
        System.out.println("L'importo medio delle vendite e': " + sales.getMediaVendite());
        System.out.println("Il numero di vendite maggiore di 3.5 e': " + sales.getVenditeAlDiSopra(3.5));
        System.out.println("Il numero di vendite maggiore di 3.0 e': " + sales.getVenditeAlDiSopra(3.0));
    }
}




