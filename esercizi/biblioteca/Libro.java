package biblioteca;
import java.util.Date;
public class Libro {

    private String titolo;
    private Abbonato abbonato;
    private Date dataScadenza;

    public Libro(String titolo) {
        this.titolo = titolo;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Abbonato getAbbonato() {
        return abbonato;
    }

    public void setAbbonato(Abbonato abbonato) {
        this.abbonato = abbonato;
    }

}
