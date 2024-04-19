
import java.time.LocalDate;

public class Libro extends Item implements Prestabile {

    private String autore;
    private int pagine;

    public Libro(int id, String titolo, int anno, String autore, int pagine) {
        super(id, titolo, anno);
        this.autore = autore;
        this.pagine = pagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    @Override
    public void presta(String utente, LocalDate data) {

        if (isDisponibile()) {
            setDisponibile(false);
            setUtente(utente);
            setData(data);
        } else {
            throw new UnsupportedOperationException("Libro non disponibile");
        }
    }

    @Override
    public void restituisci() {
        if (!isDisponibile()) {
            setDisponibile(true);
            setUtente(null);
            setData(null);
        } else {
            throw new UnsupportedOperationException("Libro già disponibile");
        }
    }

    @Override
    public boolean isDisponibile() {
        return super.getDisponibile();
    }

    @Override
    public String toString() {
        return "Libro:" + super.toString() + " autore: " + autore + " pagine: " + pagine;
    }

}
