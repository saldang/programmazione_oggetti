import java.util.ArrayList;

public class Corso {
    public String nomeCorso;
    public Insegnante insegnante;
    public ArrayList<Studente> studenti;

    public Corso(String nomeCorso, Insegnante insegnante) {
        this.nomeCorso = nomeCorso;
        this.insegnante = insegnante;
        this.studenti = new ArrayList<>();
    }

    public void aggiungiStudente(Studente studente) {
        studenti.add(studente);
    }

    public void assegnaVoto(Valutabile studente, double voto) {
        for (Studente stud : studenti) {
            if (studente.equals(stud))
                stud.aggiungiVoto(voto);
        }
    }

    public void rimuoviStudente(String iD) {
        int index = -1;
        for (Studente studente : studenti) {
            if (iD.equalsIgnoreCase(studente.getID())) {
                index = studenti.indexOf(studente);
            }
        }
        if (index != -1)
            studenti.remove(index);
    }

    public double mediaCorso(){
        double somma=0;
        for (Studente studente : studenti) {
            somma+=studente.getMediaVoti();
        }
        return somma/studenti.size();
    }

}
