package albergo.camere;

public class Normale extends Camera{
    public Normale(int x) {
        super(x);
    }

    @Override
    public void pulisci() {
        setStato(PULITA);
    }

    @Override
    public String optional() {
        return "Nessuno";
    }

    @Override
    public String categoria() {
        return "Normale";
    }
}
