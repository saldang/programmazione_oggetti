package esame.albergo2025;

public class CameraDeLuxe extends Camera {
    private boolean haTerrazza;
    private boolean haJacuzzi;
    private boolean haKitchenette;
    private double scontoLealta;

    public CameraDeLuxe(int numero) {
        this(numero, true, true, true);
    }

    public CameraDeLuxe(int numero, boolean haTerrazza, boolean haJacuzzi, boolean haKitchenette) {
        super(numero, 150.0, 4);
        this.haTerrazza = haTerrazza;
        this.haJacuzzi = haJacuzzi;
        this.haKitchenette = haKitchenette;
        this.scontoLealta = 0.0;
    }

    public boolean haTerrazza() {
        return haTerrazza;
    }

    public boolean haJacuzzi() {
        return haJacuzzi;
    }

    public boolean haKitchenette() {
        return haKitchenette;
    }

    public double getScontoLealta() {
        return scontoLealta;
    }

    public void setScontoLealta(double scontoLealta) {
        if (scontoLealta < 0.0 || scontoLealta > 0.15) {
            throw new IllegalArgumentException("Lo sconto fedeltà deve essere compreso tra 0.0 e 0.15");
        }
        this.scontoLealta = scontoLealta;
    }

    @Override
    public double calcolaCosto(int giorni) {
        if (giorni <= 0) {
            throw new IllegalArgumentException("I giorni devono essere positivi");
        }
        double supplementi = 0.0;
        if (haTerrazza && haJacuzzi) {
            supplementi += getPrezzoPerNotte() * 0.15;
        }
        if (haKitchenette) {
            supplementi += getPrezzoPerNotte() * 0.10;
        }
        double totale = (getPrezzoPerNotte() + supplementi) * giorni;
        return totale * (1 - scontoLealta);
    }

    @Override
    public String visualizzaDettagli() {
        String servizi = "WiFi premium, TV smart, Bagno privato, Minibar, Frigobar, Cassaforte, Accappatoio premium";
        String sconto = scontoLealta > 0 ? " - Sconto fedeltà: " + (int) (scontoLealta * 100) + "%" : "";
        return "[DeLuxe - Camera N. " + getNumero() + "] - Prezzo: €"
                + String.format(java.util.Locale.ROOT, "%.2f", getPrezzoPerNotte())
                + "/notte - Ospiti max: " + getMaxOspiti()
                + " - Servizi: " + servizi
                + ", Terrazza: " + (haTerrazza ? "Sì" : "No")
                + ", Jacuzzi: " + (haJacuzzi ? "Sì" : "No")
                + ", Kitchenette: " + (haKitchenette ? "Sì" : "No")
                + sconto
                + " - Stato: " + statoDisponibilita();
    }

    @Override
    public String toString() {
        return "[DeLuxe - Camera N. " + getNumero() + "] - €150/notte - Ospiti: 4 - Terrazza: "
                + (haTerrazza ? "Sì" : "No") + " - Jacuzzi: " + (haJacuzzi ? "Sì" : "No");
    }
}
