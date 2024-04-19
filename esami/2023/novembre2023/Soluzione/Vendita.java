import java.util.HashMap;

public class Vendita {
    String dataVendita;
    HashMap<Prodotto, Integer> prodottiVenduti;
    double prezzoTotale;

    public Vendita(String dataVendita) {
        this.dataVendita = dataVendita;
        this.prodottiVenduti = new HashMap<Prodotto, Integer>();
        this.prezzoTotale = 0;
    }
}
