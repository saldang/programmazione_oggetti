public class Developer extends Dipendente {
    private Esperienza esperienza;

    public Developer(String matricola, String nome, double salario) {
        super(matricola, nome, salario);
    }

    public Developer(String matricola, String nome, double salario, Esperienza esperienza) {
        super(matricola, nome, salario);
        this.esperienza = esperienza;
    }

    @Override
    public String bonusAnnuale() {
        // if (esperienza.equalsIgnoreCase("junior")) {
        // setBonusAnnuale(getSalario() * 0.2);
        // } else {
        // setBonusAnnuale(getSalario() * 0.3);
        // }

        switch (esperienza) {
            case JUNIOR: {
                setBonusAnnuale(getSalario() * 0.2);
                return "Il bonus annuale del Developer Junior e' " + getBonusAnnuale();
            }
            case MID: {
                setBonusAnnuale(getSalario() * 0.3);
                return "Il bonus annuale del Developer Mid e' " + getBonusAnnuale();
            }
            default:
                return "Il bonus annuale e' " + getBonusAnnuale();
        }
    }
}
