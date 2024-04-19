package albergo.camere;

public class Lusso extends Camera{
    public Lusso(int x) {
        super(x);
        setTariffa(100);
    }

    @Override
    public void pulisci() {
        setStato(PULITA);
    }

    @Override
    public String optional() {
        return "TV, minibar, aria condizionata";
    }

    @Override
    public String categoria() {
        return "Lusso";
    }

    public void setTemperatura(int t) {
        // TODO Auto-generated method stub

    }

    public int getTemperatura() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setCanale(int c) {
        // TODO Auto-generated method stub

    }

    public int getCanale() {
        // TODO Auto-generated method stub
        return 0;
    }

}
