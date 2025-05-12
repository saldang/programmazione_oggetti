public class Fenice extends AnimaleMagico {

    public Fenice(String nome, int eta, double velocitaBase) {
        super(nome, eta, velocitaBase);
    }


    @Override
    double calcolaTempoPercorrenza(double distanza) {
        double velocitaEffettiva = getVelocitaBase();
        //Quando percorre una distanza, rinasce a metà strada, dimezzando il tempo totale.
        if (distanza > 0) {
            velocitaEffettiva *= 2; // Raddoppia la velocità
            usaPotere();
        }
        return distanza / velocitaEffettiva;
    }
    
    @Override
    public String usaPotere() {
        return "La fenice " + getNome() + " rinasce dalle sue ceneri!";
    }
}
