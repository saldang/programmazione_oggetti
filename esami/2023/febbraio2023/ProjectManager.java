public class ProjectManager extends Dipendente {
    int progettiGestiti;

    public ProjectManager(String nome, int matricola, double salario, int progettiGestiti) {
        super(nome, matricola, salario);
        this.progettiGestiti = progettiGestiti;
    }

    @Override
    public double calcolaBonus() {
        return salario * 0.05 * progettiGestiti;
    }
}
