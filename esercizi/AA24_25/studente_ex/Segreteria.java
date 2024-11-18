import java.util.Scanner;

import entities.Docente;
import entities.Studente;

public class Segreteria {
    public static void main(String[] args) {
        Studente[] studenti = new Studente[10];

        for (int i = 0; i < studenti.length; i++) {
            studenti[i] = new Studente();
        }

        for (Studente studente : studenti) {
            System.out.println(studente.info());
        }

        Docente[] docenti;
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Quanti docenti vuoi inserire?");
        int dimDocenti = tastiera.nextInt();
        docenti = new Docente[dimDocenti];
        Docente d1 = new Docente("asdasd","asdasdd");
        Docente d2 = new Docente("asdasd2","asdasdd2");
        for (int i = 0; i < dimDocenti; i++) {
            System.out.println("Inserisci nome");
            String nome = tastiera.next();
            System.out.println("Inserisci corso");
            String corso = tastiera.next();
            docenti[i] = new Docente(nome, corso);
        }

        for (Docente docente : docenti) {
            System.out.println(docente.info());
        }

    }
}
