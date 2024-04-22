package Soluzione240424;
/**
 * Sensore
 */
public  abstract class Sensore {

    private Boolean stato = false;
    private String posizione;

    public Sensore( String posizione) {
        this.posizione = posizione;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public void attiva() {
        this.stato = true;
    }

    public void disattiva() {
        this.stato = false;
    }

    public Boolean statoSensore() {
        return stato;
    }

    public abstract Boolean rilevaEvento(Evento evento);

    @Override
    public String toString() {
        return "Sensore [posizione=" + posizione + ", stato=" + stato + "]";
    }
}