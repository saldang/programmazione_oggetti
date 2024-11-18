package entities;
/**
 * Studente
 */
public class Studente {
    static int cont = 0;
    private String nome;
    private String matricola;

    public Studente() {
        this("test", "a0000" + cont);
        cont++;
    }

    public Studente(String nome, String matricola) {
        this.nome = nome;
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String info() {
        return nome + " " + matricola;
    }
}