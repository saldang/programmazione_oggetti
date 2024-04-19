package segreteria;

public abstract class Persona {
    public String nome;
    public String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void stampa();

    @Override
    public boolean equals(Object obj) {
        return this.nome == ((Persona) obj).nome && this.cognome == ((Persona) obj).cognome;
    }
}
