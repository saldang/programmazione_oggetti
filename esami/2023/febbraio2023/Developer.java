public class Developer extends Dipendente {
    String livello;

    public Developer(String nome, int matricola, double salario, String livello) {
        super(nome, matricola, salario);
        this.livello = livello;
    }

    public double calcolaBonus() {
        if (livello.equalsIgnoreCase("junior")) {
            return salario * 0.20;
        } else {
            return salario * 0.30;
        }
    }
}
