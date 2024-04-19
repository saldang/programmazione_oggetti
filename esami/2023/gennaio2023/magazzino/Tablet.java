package magazzino;
public class Tablet extends Device{
    private boolean penna;

    public Tablet(String marca, String modello, double display, String connessione, int peso, int codice,
            boolean penna) {
        super(marca, modello, display, connessione, peso, codice);
        this.penna = penna;
    }

    public boolean isPenna() {
        return penna;
    }

    public void setPenna(boolean penna) {
        this.penna = penna;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
