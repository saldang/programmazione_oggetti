public class Drago extends AnimaleMagico  {
    boolean soffiaFuoco;

    public Drago(String nome, int eta, double velocitaBase, boolean soffiaFuoco) {
        super(nome, eta, velocitaBase);
        this.soffiaFuoco = soffiaFuoco;
    }

    public boolean isSoffiaFuoco() {
        return soffiaFuoco;
    }

    public void setSoffiaFuoco(boolean soffiaFuoco) {
        this.soffiaFuoco = soffiaFuoco;
    }

    @Override
    double calcolaTempoPercorrenza(double distanza) {
        double velocitaEffettiva = getVelocitaBase();
        if (soffiaFuoco && distanza > 100) {
            // Se il drago soffia fuoco e la distanza è maggiore di 100, aumenta la velocità
            velocitaEffettiva *= 1.2;
            usaPotere();
        }
        return distanza / velocitaEffettiva;
    }

    @Override
    public String usaPotere() {
        if (soffiaFuoco) {
            return "Il drago " + getNome() + " soffia fuoco!";
        } else {
            return "Il drago " + getNome() + " non soffia fuoco.";
        }
    }
}
