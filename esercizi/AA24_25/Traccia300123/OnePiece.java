import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OnePiece {
    public static void main(String[] args) {
        Ciurma ciurma = new Ciurma("Cappello di Paglia");

        // LETTURA FILE
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("onepiece.csv");
            br = new BufferedReader(fr);

            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] info = line.split(",");
                if (info.length > 2) {
                    if (info[4].equalsIgnoreCase("unknown")) {
                        info[4] = "0";
                    }
                    if (info[5].equalsIgnoreCase("unknown")) {
                        info[5] = "0";
                    }
                    ciurma.pirati.add(new Pirata(info[0], info[1], info[2], info[3].toUpperCase().charAt(0),
                            Integer.parseInt(info[4]), Double.parseDouble(info[5]),
                            Double.parseDouble(info[6].split(" ")[0].replace(".", ""))));
                } else {
                    ciurma.navi.add(new Nave(info[0], info[1]));
                }
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore nell'apertura del file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
            e.printStackTrace();
        }
        ciurma.stampa();
        ciurma.stampaMale("male.csv");
        ciurma.stampaOrdinato("big_bounty.csv", false);
        // for (Pirata pirata : ciurma.pirati) {
        // System.out.println(pirata);
        // }
        // for (Nave nave : ciurma.navi) {
        // System.out.println(nave);
        // }

    }
}
