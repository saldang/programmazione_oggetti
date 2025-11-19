package esame.albergo2025;

public class CameraMatrimoniale extends Camera {
    private final boolean haBalcone;
    private final boolean haVasca;
    private final String tipoLetto;

    public CameraMatrimoniale(int numero) {
        this(numero, true, true, "Matrimoniale");
    }

    public CameraMatrimoniale(int numero, boolean haBalcone, boolean haVasca, String tipoLetto) {
        super(numero, 80.0, 2);
        if (tipoLetto == null || tipoLetto.isBlank()) {
            throw new IllegalArgumentException("Il tipo di letto deve essere specificato");
        }
        this.haBalcone = haBalcone;
        this.haVasca = haVasca;
        this.tipoLetto = tipoLetto.trim();
    }

    public boolean haBalcone() {
        return haBalcone;
    }

    public boolean haVasca() {
        return haVasca;
    }

    public String getTipoLetto() {
        return tipoLetto;
    }

    @Override
    public double calcolaCosto(int giorni) {
        if (giorni <= 0) {
            throw new IllegalArgumentException("I giorni devono essere positivi");
        }
        double prezzoPerNotte = getPrezzoPerNotte();
        if (haBalcone && haVasca) {
            prezzoPerNotte += getPrezzoPerNotte() * 0.05;
        }
        return prezzoPerNotte * giorni;
    }

    @Override
    public String visualizzaDettagli() {
        return "[Matrimoniale - Camera N. " + getNumero() + "] - Prezzo: €"
                + String.format(java.util.Locale.ROOT, "%.2f", getPrezzoPerNotte())
                + "/notte - Ospiti max: " + getMaxOspiti()
                + " - Servizi: WiFi, TV, Bagno privato, Minibar"
                + ", Balcone: " + (haBalcone ? "Sì" : "No")
                + ", Vasca: " + (haVasca ? "Sì" : "No")
                + ", Letto: " + tipoLetto
                + " - Stato: " + statoDisponibilita();
    }

    @Override
    public String toString() {
        return "[Matrimoniale - Camera N. " + getNumero() + "] - €80/notte - Ospiti: 2 - Letto: " + tipoLetto;
    }
}
