public class Unicorno extends AnimaleMagico {
    boolean siStanca;

    public Unicorno(String nome, int eta, double velocitaBase, boolean siStanca) {
        super(nome, eta, velocitaBase);
        this.siStanca = siStanca;
    }

    public boolean isSiStanca() {
        return siStanca;
    }

    public void setSiStanca(boolean siStanca) {
        this.siStanca = siStanca;
    }

    @Override
    double calcolaTempoPercorrenza(double distanza) {
        double velocitaEffettiva = getVelocitaBase();
        if (siStanca && distanza > 200) {
            // Se l'unicorno si stanca e la distanza è maggiore di 200, riduce la velocità
            velocitaEffettiva *= 0.9; // Riduce la velocità dell'unicorno se si stanca
            usaPotere();
        }
        return distanza / velocitaEffettiva;
    }

    @Override
    public String usaPotere() {
        return "L'unicorno " + getNome() + " si stanca e rallenta!";
    }
}
