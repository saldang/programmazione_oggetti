public class SeniorDeveloper extends Developer {

    public SeniorDeveloper(String nome, int matricola, double salario, String livello) {
        super(nome, matricola, salario, livello);
    }

    @Override
    public double calcolaBonus() {
        return salario * 0.40;
    }
}
