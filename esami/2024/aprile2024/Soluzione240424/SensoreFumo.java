package Soluzione240424;

public class SensoreFumo extends Sensore {

    public SensoreFumo(String posizione) {
        super(posizione);
    }

    @Override
    public Boolean rilevaEvento(Evento evento) {
        if (statoSensore() == true && evento.getTipo().equalsIgnoreCase("fumo")) {
            System.out.println("Rilevato fumo");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "SensoreFumo [posizione=" + super.getPosizione() + "stato=" + statoSensore() + "]";
    }

}
