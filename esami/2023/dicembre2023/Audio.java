public class Audio extends ElementoArchivio {
    String durata;
    String formato;

    public Audio(String nome, String dataCreazione, String durata, String formato) {
        super(nome, dataCreazione);
        this.durata = durata;
        this.formato = formato;
    }

    @Override
    public String visualizzaDettagli() {
        return "Audio," + nome + "," + dataCreazione + "," + durata + "," + formato;
    }
}
