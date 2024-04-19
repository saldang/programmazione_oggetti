package lista;

import java.util.Scanner;

public class TestLista {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        boolean c = true;
        System.out.println("Inserisci la dimensione massima della lista:");
        int dim = input.nextInt();
        Lista studentsList = new Lista();
        studentsList.setDim(dim);
        studentsList.creaLista();
        while (c) {
            System.out.println("1 - Inserisci studente");
            System.out.println("2 - Termina");
            System.out.println("-----------------------");
            int scelta = input.nextInt();
            if (scelta == 1) {
                System.out.println("Inserisci nome cognome e matricola separati da spazio:");
                String data = input.next();
                String nome = data.split(" ")[0];
                String cognome = data.split(" ")[1];
                int matricola = Integer.parseInt(data.split(" ")[2]);
                if (studentsList.inserisciElemento(nome, cognome, matricola)) {
                    System.out.println("Inserimento effettuato");

                } else {
                    System.out.println("Inserimento fallito");

                }
            } else {
                c = false;
            }
        }
        System.out.println("Studenti inseriti:");
        studentsList.stampaLista();
    }
}
