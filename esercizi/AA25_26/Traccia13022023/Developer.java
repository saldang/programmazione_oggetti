public class Developer extends Dipendente {

    private String livello;

    public Developer(int matricola, String nome, double salario, String livello) {
        super(matricola, nome, salario);
        this.livello = livello;
    }

    public String getLivello() {
        return livello;
    }

    public double calcolaBonus() {
        if (livello.equals("Junior")) {
            return getSalario() * 0.2;
        } else if (livello.equals("Mid")) {
            return getSalario() * 0.3;
        } else {
            return getSalario() * 0.1;
        }
    }

}
