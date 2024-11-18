import java.util.Scanner;

public class AppEsame {
    public static void main(String[] args) {
        Studente s1 = new Studente();
        Scanner tastiera = new Scanner(System.in);
        for (int j = 0; j < s1.getEsercizi().length; j++) {
            System.out.println("Inserisci il voto del esercizio(da 0 a 10)  " + (j + 1));
            s1.setEsercizi(tastiera.nextFloat(), j);
        }

        for (int j = 0; j < s1.getEsamiIntermedi().length; j++) {
            System.out.println("Inserisci il voto degli esami intermedi (da 0 a 100) " + (j + 1));
            s1.setEsamiIntermedi(tastiera.nextFloat(), j);
        }

        System.out.println("Inserisci il voto dell'esame finale");
        s1.setEsameFinale(tastiera.nextFloat());

        s1.calcolaVotoFinale();
        s1.calcolaVotoLettera();

        System.out.println("Per lo studente il voto finale e':"+s1.getVotoFinale());
        System.out.println("Per lo studente il voto in lettera e':"+s1.getLettera());

    }
}
