public class Dipendente {

    String nome;
    int matricola;
    double salario;
    
    public Dipendente(String nome, int matricola, double salario) {
        this.nome = nome;
        this.matricola = matricola;
        this.salario = salario;
    }
    
    public double calcolaBonus(){
        return salario*0.10;
    }
}