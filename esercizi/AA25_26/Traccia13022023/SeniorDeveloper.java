public class SeniorDeveloper extends Developer {

    public SeniorDeveloper(int matricola, String nome, double salario, String livello) {
        super(matricola, nome, salario, livello);
    }

    @Override
    public double calcolaBonus() {
        return getSalario() * 0.4;
    }

}
