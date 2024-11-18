package entities;

public class Docente {
    static int cont = 0;
    private String nome;
    private String corso;

    public Docente() {
        this("docente_test", "corso" + cont);
        cont++;
    }

    public Docente(String nome, String corso) {
        this.nome = nome;
        this.corso = corso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public String info() {
        return nome + " " + corso;
    }
}
