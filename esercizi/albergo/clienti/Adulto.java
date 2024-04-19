package albergo.clienti;

public class Adulto extends Cliente {
    private final String ci;

    public Adulto(String n, String c, String ci) {
        super(n, c);
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Adulto: " + nome + " " + cognome + " (" + ci + ")";
    }
}
