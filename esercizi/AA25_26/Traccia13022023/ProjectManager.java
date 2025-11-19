public class ProjectManager extends Dipendente {
    private int nProgetti;

    public ProjectManager(int matricola, String nome, double salario, int nProgetti) {
        super(matricola, nome, salario);
        this.nProgetti = nProgetti;
    }

    @Override
    double calcolaBonus() {
        return (getSalario() * 0.05) * nProgetti;
    }

}
