package albergo.camere;

public class ExtraLusso extends Lusso {
    public ExtraLusso(int x) {
        super(x);
        setTariffa(150);
    }

    @Override
    public void pulisci() {
        setStato(PULITA);
    }

    @Override
    public String optional() {
        return "TV, minibar, aria condizionata, vasca idromassaggio";
    }

    @Override
    public String categoria() {
        return "ExtraLusso";
    }

}
