
import java.time.LocalDate;

public class Rivista extends Item implements Prestabile {

    private String periodicita;
    private int numero;

    public Rivista(int id, String titolo, int anno, String periodicita, int numero) {
        super(id, titolo, anno);
        this.periodicita = periodicita;
        this.numero = numero;
    }

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicita) {
        this.periodicita = periodicita;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void presta(String utente, LocalDate data) {
        if (isDisponibile()) {
            setDisponibile(false);
            setUtente(utente);
            setData(data);
        } else {
            throw new UnsupportedOperationException("Rivista non disponibile");
        }
    }

    @Override
    public void restituisci() {
        if (!isDisponibile()) {
            setDisponibile(true);
            setUtente(null);
            setData(null);
        } else {
            throw new UnsupportedOperationException("Rivista già disponibile");
        }
    }

    @Override
    public boolean isDisponibile() {
        return super.getDisponibile();
    }

    @Override
    public String toString() {
        return "Rivista:" + super.toString() + " periodicita:" + periodicita + ", numero:" + numero;
    }

}
