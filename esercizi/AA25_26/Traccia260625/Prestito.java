import java.time.LocalDate;

public class Prestito extends Transazione {

    LocalDate dataInizio;
    LocalDate dataFine;
    double penalitaGiornaliera;

    public Prestito(LocalDate data, String utente, Materiale materiale, LocalDate dataInizio, LocalDate dataFine,
            double penalitaGiornaliera) {
        super(data, utente, materiale);
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.penalitaGiornaliera = penalitaGiornaliera;
    }

}
