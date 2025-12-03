public class Motocicletta extends Veicolo {
    private long cilindrata;
    private boolean presenzaAntibloccaggio;

    public Motocicletta(String marca, String modello, int anno, String colore, double valore,
            long cilindrata, boolean presenzaAntibloccaggio) {
        super(marca, modello, anno, colore, valore);
        this.cilindrata = cilindrata;
        this.presenzaAntibloccaggio = presenzaAntibloccaggio;
    }

    public long getCilindrata() {
        return cilindrata;
    }

    public boolean isPresenzaAntibloccaggio() {
        return presenzaAntibloccaggio;
    }

    @Override
    double calcolaValoreMercato() {
        return getValore();

    }

    @Override
    String visualizzaInformazioniVeicolo() {
        return "Motocicletta:\n" + super.toString() +
                ((presenzaAntibloccaggio) ? " - ABS" : "");
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
