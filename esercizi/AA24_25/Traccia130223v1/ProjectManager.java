public class ProjectManager extends Dipendente {
    private int numeroProgetti;

    public ProjectManager(String matricola, String nome, double salario, int numeroProgetti) {
        super(matricola, nome, salario);
        this.numeroProgetti = numeroProgetti;
    }

    @Override
    public String bonusAnnuale() {
        setBonusAnnuale((0.05 * getSalario()) * numeroProgetti);
        return "Il bonus annuale del Project Manager e' " + getBonusAnnuale();

    }
}
