public class Bambino extends Cliente {
    private Adulto padre;
    private Adulto madre;

    public Bambino(String nome, String cognome, Adulto padre, Adulto madre) {
        super(nome, cognome);
        this.padre = padre;
        this.madre = madre;
    }

    public Adulto getPadre() {
        return padre;
    }

    public void setPadre(Adulto padre) {
        this.padre = padre;
    }

    public Adulto getMadre() {
        return madre;
    }

    public void setMadre(Adulto madre) {
        this.madre = madre;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Genitori:");
        padre.info();
        madre.info();

    }
}
