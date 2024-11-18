import java.util.ArrayList;

public class Studente extends Persona implements Valutabile {
    private String classe;
    private double mediaVoti;
    private ArrayList<Double> voti;

    public Studente(String iD, String nome, String cognome, String classe) {
        super(iD, nome, cognome);
        this.classe = classe;
        this.voti = new ArrayList<>();
    }

    @Override
    public String visualizzaDettagli() {
        return getID() + " " + getNome() + " " + getCognome() + " " + mediaVoti + " " + classe;
    }

    @Override
    public void aggiungiVoto(double voto) {
        voti.add(voto);
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public double getMediaVoti() {
        double somma = 0;
        for (Double voto : voti) {
            somma += voto;
        }
        this.mediaVoti = somma / voti.size();
        return this.mediaVoti;
    }

    public ArrayList<Double> getVoti() {
        return voti;
    }

    @Override
    public boolean equals(Object o) {
        if (((Studente) o).getID().equals(this.getID()))
            return true;
        else
            return false;

    }
}
