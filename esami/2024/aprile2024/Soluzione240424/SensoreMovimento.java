package Soluzione240424;

/**
 * SensoreMovimento
 */
public class SensoreMovimento extends Sensore {

    public SensoreMovimento(String posizione) {
        super(posizione);
    }

    @Override
    public Boolean rilevaEvento(Evento evento) {
        if (evento.getTipo().equalsIgnoreCase("movimento")) {
            System.out.println("Rilevato movimento");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "SensoreMovimento [posizione=" + super.getPosizione() + "stato=" + statoSensore() + "]";
    }
}