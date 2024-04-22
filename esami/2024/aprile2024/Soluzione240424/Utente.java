package Soluzione240424;
public class Utente {
    private String nome;
    private String livelloAccesso;

    public Utente(String nome, String livelloAccesso) {
        this.nome = nome;
        this.livelloAccesso = livelloAccesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLivelloAccesso() {
        return livelloAccesso;
    }

    public void setLivelloAccesso(String livelloAccesso) {
        this.livelloAccesso = livelloAccesso;
    }

    @Override
    public String toString() {
        return "Utente [nome=" + nome + ", livelloAccesso=" + livelloAccesso + "]";
    }

}
