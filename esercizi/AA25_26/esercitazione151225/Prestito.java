import java.time.LocalDate;

public class Prestito {
    private Utente utente;
    private Libro libro;
    private LocalDate dataPrestito;
    private LocalDate dataScadenza;
    private LocalDate dataRestituzione;
    private double penaleTotale;

    public Prestito(Utente utente, Libro libro, LocalDate dataPrestito) {
        this.utente = utente;
        this.libro = libro;
        this.dataPrestito = dataPrestito;
        if (libro instanceof Romanzo romanzo)
            this.dataScadenza = dataPrestito.plusDays(romanzo.getDurataPrestito());
        else if (libro instanceof Manuale manuale)
            this.dataScadenza = dataPrestito.plusDays(manuale.getDurataPrestito());
        else if (libro instanceof Rivista rivista)
            this.dataScadenza = dataPrestito.plusDays(rivista.getDurataPrestito());
        else
            this.dataScadenza = dataPrestito.plusDays(10);
        this.penaleTotale = 0;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getDataPrestito() {
        return dataPrestito;
    }

    public void setDataPrestito(LocalDate dataPrestito) {
        this.dataPrestito = dataPrestito;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public double getPenaleTotale() {
        return penaleTotale;
    }

    public void setPenaleTotale(double penaleTotale) {
        this.penaleTotale = penaleTotale;
    }

    @Override
    public String toString() {
        return "Prestito:\n\t" + utente.toString() + "\n\t" + libro.visualizzaDettagli() + "\n\t" + "Scadenza: "
                + dataScadenza
                + "\n\tPenale:" + penaleTotale;
    }
}
