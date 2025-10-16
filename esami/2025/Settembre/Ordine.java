public class Ordine {
    // - Attributi: `numeroOrdine`, `numeroTavolo`, `orarioApertura`, `stato`,
    // `tipologia` (TAVOLO/ASPORTO/DELIVERY)
    // - Metodi: costruttore, `aggiungiPiatto()`, `calcolaTotale()`,
    // `getTempoStimato()`, `toString()`

    int numeroOrdine;
    int numeroTavolo;
    String orarioApertura; // potrebbe essere un oggetto Date o LocalDateTime
    String stato; // es. "APERTO", "CHIUSO"
    String tipologia; // es. "TAVOLO", "ASPORTO", "DELIVERY"
    double tempoPreparazione;
    double totale;

    // Costruttore
    public Ordine(int numeroOrdine, int numeroTavolo, String orarioApertura, String stato, String tipologia) {
        this.numeroOrdine = numeroOrdine;
        this.numeroTavolo = numeroTavolo;
        this.orarioApertura = orarioApertura;
        this.stato = stato;
        this.tipologia = tipologia;
    }

    // Metodi
    public boolean aggiungiPiatto(Piatto piatto, int quantita) {
        if (piatto instanceof Ordinabile) {
            tempoPreparazione += ((Ordinabile) piatto).aggiungiAllOrdine(numeroTavolo, quantita);
            totale += piatto.calcolaPrezzoFinale() * quantita;
            return true;
        }
        return false;
    }

    public double calcolaTotale() {
        // Implementazione per calcolare il totale dell'ordine
        return totale;
    }

    public double getTempoStimato() {
        // Implementazione per calcolare il tempo stimato di preparazione
        return tempoPreparazione;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", numeroTavolo=" + numeroTavolo +
                ", orarioApertura='" + orarioApertura + '\'' +
                ", stato='" + stato + '\'' +
                ", tipologia='" + tipologia + '\'' +
                '}';
    }
}
