/**
 * Prodotto
 */
public class Prodotto {

    String codice;
    String descrizione;
    double prezzo;

    public Prodotto(String codice, String descrizione, double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return codice+","+descrizione+","+prezzo;
    }
    
}