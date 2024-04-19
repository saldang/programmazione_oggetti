import java.io.Serializable;

public class Persona implements Serializable {

    int eta;
    int annoIntervento;
    int nNoduli;
    int stato;

    public Persona(int eta, int annoIntervento, int nNoduli, int stato) {
        this.eta = eta;
        this.annoIntervento = annoIntervento;
        this.nNoduli = nNoduli;
        this.stato = stato;
    }

    @Override
    public String toString() {
        return eta + "," + annoIntervento + "," + nNoduli + "," + stato;
    }
}
