
import java.time.LocalDate;

/**
 * Item
 */
public class Item {

    private int id;
    private String titolo;
    private int anno;
    private boolean disponibile;
    private String utente;
    private LocalDate data;

    public Item(int id, String titolo, int anno) {
        this.id = id;
        this.titolo = titolo;
        this.anno = anno;
        this.disponibile = true;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "id:" + id + ", titolo:" + titolo + ", anno:" + anno + ", disponibile:" + disponibile + ", utente:"
                + utente + ", data:" + data;
    }

}