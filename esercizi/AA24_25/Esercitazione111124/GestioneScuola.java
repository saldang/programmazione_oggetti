import java.util.Scanner;

public class GestioneScuola {
    public static void main(String[] args) {
        Scuola scuola = new Scuola();
        Insegnante i1 = new Insegnante("I001", "Salvatore", "DAngelo", 2000, "Programmazione");
        Insegnante i2 = new Insegnante("I002", "Rocco", "Aversa", 2000, "Sistemi Operativi");
        Studente s1 = new Studente("S001", "Antonio", "Esposito", "1A");
        Studente s2 = new Studente("S002", "Paolo", "Rossi", "2C");
        Studente s3 = new Studente("S003", "Lucia", "Verde", "1A");
        Studente s4 = new Studente("S004", "Stefania", "Bianchi", "2C");

        Corso c1 = new Corso("Programmazione", i1);

        Corso c2 = new Corso("SisOp", i2);

        scuola.aggiungiCorso(c1);
        scuola.aggiungiCorso(c2);
        scuola.iscriviStudenteACorso("Programmazione", s1);
        scuola.iscriviStudenteACorso("Programmazione", s3);
        scuola.iscriviStudenteACorso("SisOp", s2);
        scuola.iscriviStudenteACorso("SisOp", s4);

        c1.assegnaVoto(s1, 7.8);
        c1.assegnaVoto(s3, 7.8);
        c1.assegnaVoto(s1, 8.8);
        c1.assegnaVoto(s3, 6.8);
        c2.assegnaVoto(s2, 9.8);
        c2.assegnaVoto(s2, 7.8);
        c2.assegnaVoto(s4, 7.8);
        c2.assegnaVoto(s4, 5.8);

        scuola.visualizzaDettagliCorso("Programmazione");

        scuola.visualizzaDettagliCorso("SisOp");

        scuola.calcolaMediaStudente(s1);
        scuola.calcolaMediaStudente(s2);
        scuola.calcolaMediaStudente(s3);
        scuola.calcolaMediaStudente(s4);

        for (String key : scuola.classi.keySet()) {
            System.out.println(key);
            for (Studente studente : scuola.classi.get(key)) {
                System.out.println(studente.visualizzaDettagli());
            }
        }

        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci il valore soglia degli studenti meritevoli:");
        double soglia = tastiera.nextDouble();
        for (Studente studente : scuola.studentiMeritevoli(soglia)) {
            System.out.println(studente.visualizzaDettagli());
        }

        tastiera.close();

        System.out.println("Media per corso:");
        for (Corso corso : scuola.corsi) {
            System.out.print("Corso:" + corso.nomeCorso + " Media:");
            System.out.format("%.2f", corso.mediaCorso());
            System.out.println();
        }
    }
}
