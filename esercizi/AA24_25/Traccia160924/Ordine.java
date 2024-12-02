import java.time.LocalDateTime;
import java.util.HashMap;

public class Ordine {

    public HashMap<Articolo, Integer> articoli;
    public LocalDateTime data;
    public Double totaleOrdine = 0.0;

    public Ordine(LocalDateTime data) {
        this.articoli = new HashMap<>();
        this.data = data;
    }

    public void aggiungiArticolo(Articolo articolo, int quantita) {
        articoli.put(articolo, quantita);
        articolo.quantita-=quantita;
    }

    public void setTotaleOrdine(Double totale) {
        this.totaleOrdine = totale;
    }

}
