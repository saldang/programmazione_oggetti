import java.util.Scanner;

public class Merlino {
    private static Merlino mago;
    
    /**
     * Crea una nuova istanza di Merlino
     */
    private Merlino() {
        // Niente da fare qui, vogliamo solo imporre che  il 
    	// costruttore di default abbia un accesso privato
    }
    
    public static Merlino chiama(){
        if(mago == null)
            mago = new Merlino();
        return mago;
    }

    public String consulta(){
        return "Estrai la spada dalla roccia.";
    }  
}






