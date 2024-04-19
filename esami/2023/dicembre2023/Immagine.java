public class Immagine extends ElementoArchivio {

    String risoluzione;
    String formato;

    public Immagine(String nome, String dataCreazione, String risoluzione, String formato) {
        super(nome, dataCreazione);
        this.risoluzione = risoluzione;
        this.formato = formato;
    }

    @Override
    public String visualizzaDettagli() {
        return "Immagine," + nome + "," + dataCreazione + "," + risoluzione + "," + formato;
    }
}
