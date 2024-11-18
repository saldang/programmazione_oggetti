public class Insegnante extends Persona {

    private double stipendioBase;
    private String materia;

    public Insegnante(String iD, String nome, String cognome, double stipendioBase, String materia) {
        super(iD, nome, cognome);
        this.stipendioBase = stipendioBase;
        this.materia = materia;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }

    public void setStipendioBase(double stipendioBase) {
        this.stipendioBase = stipendioBase;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String visualizzaDettagli() {
        return getID() + " " + getNome() + " " + getCognome() + " " + materia + " " + stipendioBase;

    }
}
