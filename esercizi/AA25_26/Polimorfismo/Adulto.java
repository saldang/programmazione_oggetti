public class Adulto extends Cliente {

    private String ci;

    protected Adulto(String nome, String cognome, String ci) {
        super(nome, cognome);
        this.ci = ci;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Adulto: " + super.toString() + " " + ci;
    }
}
