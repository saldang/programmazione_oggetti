package segreteria;

import java.util.ArrayList;

public class Segreteria {
    private Studente[] studenti;
    private int studentiRegistrati = 0;
    private int maxStudenti;

    public Segreteria(int n) {
        studenti = new Studente[n];
        maxStudenti = n;
    }

    public void registraStudente(Studente s) {
        if (studentiRegistrati < maxStudenti) {

            studenti[studentiRegistrati] = s;
            studentiRegistrati++;
        } else {
            System.out.println("Raggiunto il massimo numero di studenti");
        }
    }

    public void registraStudente(Studente[] ss) {
        if (ss.length <= studenti.length) {
            studenti = ss;
        } else {
            System.out.println("Lista di studenti superiore al massimo numero di studenti registrabili");

        }
    }

    public Studente[] getStudenti() {
        return studenti;
    }

    public void stampaListaStudenti() {
        for (Studente studente : studenti) {
            System.out.println(studente.toString());
            ;
        }
    }
    
}
