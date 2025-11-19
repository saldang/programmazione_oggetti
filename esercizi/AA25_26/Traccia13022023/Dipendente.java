public abstract class Dipendente {
    private int matricola;
    private String nome;
    private double salario;

    public Dipendente(int matricola, String nome, double salario) {
        this.matricola = matricola;
        this.nome = nome;
        this.salario = salario;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    abstract double calcolaBonus();
}
