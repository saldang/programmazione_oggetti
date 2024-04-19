public class Documento extends ElementoArchivio {

    String formato;
    String numeroPagine;

    public Documento(String nome, String dataCreazione, String formato, String numeroPagine) {
        super(nome, dataCreazione);
        this.formato = formato;
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String visualizzaDettagli() {
        return "Documento," + nome + "," + dataCreazione + "," + formato + "," + numeroPagine;
    }

}
