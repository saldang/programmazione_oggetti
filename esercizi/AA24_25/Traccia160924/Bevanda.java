public class Bevanda extends Articolo {
    public String dimensione;

    public Bevanda(String codice, String nome, double prezzo, int quantita, String dimensione) {
        super(codice, nome, prezzo, quantita);
        this.dimensione = dimensione;
    }

    @Override
    public String toString() {
        return "Bevanda," + super.toString() + "," + dimensione;
    }

}