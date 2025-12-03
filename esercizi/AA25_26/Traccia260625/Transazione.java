import java.time.LocalDate;

public abstract class Transazione {
    LocalDate data;
    String utente;
    Materiale materiale;

    public Transazione(LocalDate data, String utente, Materiale materiale) {
        this.data = data;
        this.utente = utente;
        this.materiale = materiale;
    }
}
