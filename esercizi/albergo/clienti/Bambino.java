package albergo.clienti;

public class Bambino extends Cliente {
    private final String padre;
    private final String madre;
    private final int eta;

    public Bambino(String n, String c, String p, String m, int e) {
        super(n, c);
        padre = p;
        madre = m;
        eta = e;
    }

    @Override
    public String toString() {
        return "Bambino: " + nome + " " + cognome + " (" + eta + " anni), genitori: " + padre + " e " + madre;
    }
}
