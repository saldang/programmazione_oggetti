public class Dipendente {

    private final String matricola;
    private final String nome;
    private double salario;
    private double bonusAnnuale;

    public void setBonusAnnuale(double bonusAnnuale) {
        this.bonusAnnuale = bonusAnnuale;
    }

    public Dipendente(String matricola, String nome, double salario) {
        this.matricola = matricola;
        this.nome = nome;
        this.salario = salario;
    }

    public String bonusAnnuale() {
        this.bonusAnnuale = salario * 0.1;
        return "Il bonus annuale e':" + this.bonusAnnuale;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonusAnnuale() {
        return bonusAnnuale;
    }

}