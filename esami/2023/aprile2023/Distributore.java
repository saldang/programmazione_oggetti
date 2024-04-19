package aprile2023;

import java.util.ArrayList;

public interface Distributore {


    public void aggiungiProdotto(Prodotto p);
    public void aggiungiMoneta(Moneta m);
    public void stampaCredito();
    public void acquista(String codice);
    public void carica(String nomeFile);
    public void restituisciResto();
    public void stampaStock();

}
