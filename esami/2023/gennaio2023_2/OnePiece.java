import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class OnePiece {
    public static void main(String[] args) {
        Ciurma cappelloDiPaglia = new Ciurma("Cappello di paglia");

        try {
            Scanner in = new Scanner(new File("onepiece.csv"));
            String riga = in.nextLine();
            while (in.hasNext()) {
                riga = in.nextLine();
                System.out.println(riga);
                String[] tokens = riga.split(",");
                if (tokens.length > 2) {
                    int eta = 0;
                    int altezza = 0;
                    if (!tokens[4].equalsIgnoreCase("Unknown"))
                        eta = Integer.parseInt(tokens[4]);
                    if (!tokens[5].equalsIgnoreCase("Unknown"))
                        altezza = Integer.parseInt(tokens[5]);
                    cappelloDiPaglia.aggiungiPirata(new Pirata(tokens[0], tokens[1], tokens[2], tokens[3],
                            eta, altezza,
                            Double.parseDouble(tokens[6].split(" ")[0].replace(".", ""))));
                } else {
                    cappelloDiPaglia.aggiungiNave(new Nave(tokens[0], tokens[1]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("maleOp.csv"));
            for (Pirata pirata : cappelloDiPaglia.getPersonaggiMaschili()) {
                writer.write(pirata.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("bigBounty.txt"));
            for (Pirata pirata : cappelloDiPaglia.getBigBounty()) {
                writer.write(
                        pirata.getNomeOriginale() + " " + pirata.getSoprannome() + " "
                                + String.format(Locale.ITALIAN, "%,.2f", pirata.getTaglia()) + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
