import java.util.ArrayList;
import java.util.HashMap;

public class Scuola {
    ArrayList<Corso> corsi;
    HashMap<String, ArrayList<Studente>> classi;

    public Scuola() {
        corsi = new ArrayList<>();
        classi = new HashMap<>();
    }

    public void aggiungiCorso(Corso corso) {
        corsi.add(corso);
    }

    public void iscriviStudenteACorso(String corso, Studente studente) {
        for (Corso c : corsi) {
            if (c.nomeCorso.equalsIgnoreCase(corso)) {
                c.aggiungiStudente(studente);
                if (classi.containsKey(studente.getClasse())) {
                    classi.get(studente.getClasse()).add(studente);
                } else {
                    ArrayList<Studente> classe = new ArrayList<>();
                    classe.add(studente);
                    classi.put(studente.getClasse(), classe);
                }
            }
        }
    }

    public void visualizzaDettagliCorso(String nomeCorso) {
        for (Corso corso : corsi) {
            if (corso.nomeCorso.equalsIgnoreCase(nomeCorso)) {
                System.out.println("Nome corso:" + corso.nomeCorso);
                System.out.println("Insegnante:" + corso.insegnante.visualizzaDettagli());
                System.out.println("Studenti:");
                for (Studente studente : corso.studenti) {

                    System.out.println(studente.visualizzaDettagli());

                }
            }
        }
    }

    public ArrayList<Studente> studentiMeritevoli(double soglia) {
        ArrayList<Studente> studentiMeritevoli = new ArrayList<>();

        for (Corso corso : corsi) {
            for (Studente studente : corso.studenti) {
                if (studente.getMediaVoti() >= soglia)
                    studentiMeritevoli.add(studente);
            }

        }
        return studentiMeritevoli;
    }

    public void calcolaMediaStudente(Studente studente) {
        System.out.println("Media di " + studente.getCognome() + ":" + studente.getMediaVoti());
    }
}
