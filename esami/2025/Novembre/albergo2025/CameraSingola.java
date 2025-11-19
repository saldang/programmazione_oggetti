package esame.albergo2025;

public class CameraSingola extends Camera {
    private final boolean haAria;
    private final int numeroFinestre;

    public CameraSingola(int numero) {
        this(numero, true, 1);
    }

    public CameraSingola(int numero, boolean haAria, int numeroFinestre) {
        super(numero, 50.0, 1);
        if (numeroFinestre <= 0) {
            throw new IllegalArgumentException("Il numero di finestre deve essere positivo");
        }
        this.haAria = haAria;
        this.numeroFinestre = numeroFinestre;
    }

    public boolean haAria() {
        return haAria;
    }

    public int getNumeroFinestre() {
        return numeroFinestre;
    }

    @Override
    public double calcolaCosto(int giorni) {
        if (giorni <= 0) {
            throw new IllegalArgumentException("I giorni devono essere positivi");
        }
        return getPrezzoPerNotte() * giorni;
    }

    @Override
    public String visualizzaDettagli() {
        return "[Singola - Camera N. " + getNumero() + "] - Prezzo: €"
                + String.format(java.util.Locale.ROOT, "%.2f", getPrezzoPerNotte())
                + "/notte - Ospiti max: " + getMaxOspiti()
                + " - Servizi: WiFi, TV, Bagno privato"
                + ", Aria condizionata: " + (haAria ? "Sì" : "No")
                + ", Finestre: " + numeroFinestre
                + " - Stato: " + statoDisponibilita();
    }

    @Override
    public String toString() {
        return "[Singola - Camera N. " + getNumero() + "] - €50/notte - Ospiti: 1";
    }
}
