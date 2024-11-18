public class SeniorDeveloper extends Developer {

    public SeniorDeveloper(String matricola, String nome, double salario) {
        super(matricola, nome, salario);
    }

    @Override
    public String bonusAnnuale() {
        setBonusAnnuale(getSalario() * 0.4);
        return "Il bonus annuale del Developer Senior e' " + getBonusAnnuale();
    }

}
