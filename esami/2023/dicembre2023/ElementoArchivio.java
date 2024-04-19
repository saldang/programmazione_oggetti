
abstract class ElementoArchivio {

    String nome;
    String dataCreazione;

    public ElementoArchivio(String nome, String dataCreazione) {
        this.nome = nome;
        this.dataCreazione = dataCreazione;
    }

    abstract public String visualizzaDettagli();
}