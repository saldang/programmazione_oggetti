public class Ragazzo extends Cliente {

    private String ci;

    protected Ragazzo(String nome, String cognome, String ci) {
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
        return "Ragazzo: "+super.toString() + " " + ci;
    }

}
