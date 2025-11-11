public class Bambino extends Cliente {
    private Adulto genitore1;
    private Adulto genitore2;

    protected Bambino(String nome, String cognome, Adulto genitore1, Adulto genitore2) {
        super(nome, cognome);
        this.genitore1 = genitore1;
        this.genitore2 = genitore2;
    }

    public String getGenitori() {
        return genitore1.toString() + "\n" + genitore2.toString();
    }

    @Override
    public String toString() {

        return "Bambino " + super.toString() + "\n\tGenitori" + getGenitori();
    }
}
