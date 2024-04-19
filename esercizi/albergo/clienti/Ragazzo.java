package albergo.clienti;

public class Ragazzo extends Cliente {
    private final String ci;
    public Ragazzo(String n, String c, String ci) {
        super(n, c);
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Ragazzo: " + nome + " " + cognome + " (" + ci + ")";
    }
}
