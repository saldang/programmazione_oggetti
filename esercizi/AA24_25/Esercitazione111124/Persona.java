public abstract class Persona {
    private String iD;
    private String nome;
    private String cognome;

    public Persona(String iD, String nome, String cognome) {
        this.iD = iD;
        this.nome = nome;
        this.cognome = cognome;
    }

    public abstract String visualizzaDettagli();

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}