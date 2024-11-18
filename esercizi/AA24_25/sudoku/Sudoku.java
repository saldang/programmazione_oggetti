/**
 * Sudoku
 */
public class Sudoku {

    int[][] scacchiera;
    boolean[][] inizio;

    public Sudoku() {
        scacchiera = new int[9][9];
        inizio = new boolean[9][9];
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < scacchiera.length; i++) {
            for (int j = 0; j < scacchiera.length; j++) {
                output += scacchiera[i][j] + " ";
                if ((j + 1) % 3 == 0) {
                    output += "| ";
                }
            }
            output += "\n";
            if ((i + 1) % 3 == 0) {
                output += "-----------------------\n";
            }
        }
        return output;
    }

    public void aggiungiIniziali(int riga, int colonna, int valore) {
        scacchiera[riga][colonna] = valore;
        if (valore != 0)
            inizio[riga][colonna] = true;
        else
            inizio[riga][colonna] = false;
    }

    public int aggiungiMossa(int riga, int colonna, int valore) {
        if (!inizio[riga][colonna]) {
            scacchiera[riga][colonna] = valore;
            return 1;
        } else {
            return -1;
        }
    }

    public boolean verificaGioco() {
        boolean corretto = true;
        boolean erroreRiga = false;
        boolean erroreColonna = false;
        boolean erroreRiquadro = false;

        for (int i = 0; i < scacchiera.length; i++) {
            for (int j = 0; j < scacchiera.length; j++) {
                if (!inizio[i][j] && scacchiera[i][j] != 0) {
                    for (int k = 0; k < scacchiera.length; k++) {
                        if (i != k)
                            if (scacchiera[i][j] == scacchiera[k][j]) {
                                erroreColonna = true;
                                corretto = false;
                            }

                        if (j != k)
                            if (scacchiera[i][j] == scacchiera[i][k]) {
                                erroreRiga = true;
                                corretto = false;
                            }

                    }
                    for (int k1 = (i / 3) * 3; k1 < ((i / 3) * 3) + 3; k1++) {
                        for (int k2 = (j / 3) * 3; k2 < ((j / 3) * 3) + 3; k2++) {
                            if (i != k1 || j != k2)
                                if (scacchiera[i][j] == scacchiera[k1][k2]) {
                                    erroreRiquadro = true;
                                    corretto = false;
                                }

                        }
                    }
                }
            }

        }
        if (erroreColonna)
            System.out.println("colonna");
        if (erroreRiga)
            System.out.println("riga");
        if (erroreRiquadro)
            System.out.println("riquadro");
        return corretto;
    }

    public int getValoreIn(int riga, int colonna) {
        return scacchiera[riga][colonna];
    }

    public boolean[] getValoriValidi(int riga, int colonna) {
        int temp = scacchiera[riga][colonna];

        boolean[] valoriConsentiti = new boolean[9];
        for (int i = 1; i <= 9; i++) {
            scacchiera[riga][colonna] = i;
            valoriConsentiti[i - 1] = verificaGioco();
        }
        scacchiera[riga][colonna] = temp;

        return valoriConsentiti;
    }

}
