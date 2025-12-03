public class Bicicletta extends Veicolo {

    protected Bicicletta(String marca, String modello, int anno, String colore, boolean assistenzaElettrica,
            double valore) {
        super(marca, modello, anno, colore, assistenzaElettrica, valore);
    }

    @Override
    double calcolaValoreMercato() {
        throw new UnsupportedOperationException("Unimplemented method 'calcolaValoreMercato'");
    }

    @Override
    String visualizzaInformazioniVeicolo() {
        return "Bicicletta:\n" + super.toString() +
                ((isAssistenzaElettrica()) ? " - Hybrid" : "");
    }

    @Override
    public String toString() {
        return "Bicicletta []";
    }

    @Override
    public void accelera(double quantita) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accelera'");
    }

    @Override
    public void frena(double quantita) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frena'");
    }

    @Override
    public double getTotaleDistanza() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotaleDistanza'");
    }

}
