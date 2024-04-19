public abstract class PoliticaSconto {
    
    public abstract double calcolaSconto(int numeroArticoli, double prezzoArticolo);
   
}

/* Il seguente codice mostra come implementare PoliticaSconto 
 * come interfaccia.
 * Per usarlo con ScontoQuantita, CompraNArticoliPrendiUnoGratis e ScontoCombinato. 
 * Si dovrebbe cambiare le dichiarazioni di classe da extends PoliticaSconto 
 * a implements PoliticaSconto.

public interface PoliticaSconto {
    public double calcolaSconto(int numeroArticoli, double prezzoArticolo);
}
 */

