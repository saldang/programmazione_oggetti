import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        Scanner tastiera = new Scanner(System.in);

        int valoriIniziali[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        for (int i = 0; i < valoriIniziali.length; i++) {
            for (int j = 0; j < valoriIniziali.length; j++) {
                s.aggiungiIniziali(i, j, valoriIniziali[i][j]);
            }
        }

        System.out.println(s.toString());

        // System.out.println("Inserisci numero di riga e di colonna in questo formato
        // 'riga,colonna':");
        // String riga_colonna = tastiera.nextLine();
        // int riga = Integer.parseInt(riga_colonna.split(",")[0]);
        // int colonna = Integer.parseInt(riga_colonna.split(",")[1]);
        // System.out.println("Inserisci il valore da assegnare alla cella:");
        // int valore = tastiera.nextInt();
        // int esitoAggiungiMossa = s.aggiungiMossa(riga, colonna, valore);
        // if (esitoAggiungiMossa == -1) {
        // System.out.println("La cella selezionata non puo' essere modificata!");
        // }
        // if (s.verificaGioco())
        // System.out.println("Corretto");
        // else
        // System.out.println("Errore");

        boolean[] valoriConsentiti = s.getValoriValidi(3, 1);
        for (int i = 0; i < valoriConsentiti.length; i++) {
            System.out.println((i + 1) + ":" + valoriConsentiti[i]);
        }
        System.out.println(s.toString());

        tastiera.close();
    }
}
