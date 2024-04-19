import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static ArrayList<Dipendente> reader() {
        ArrayList<Dipendente> dipendenti = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("dipendenti.csv"));
            String riga = bf.readLine();//skip prima riga
            riga = bf.readLine();
            while (riga != null) {
                String[] tokens = riga.split(",");
                if (tokens[3].equalsIgnoreCase("developer")) {
                    if (tokens[4].equalsIgnoreCase("junior")) {
                        dipendenti.add(new Developer(tokens[1], Integer.parseInt(tokens[0]),
                                Double.parseDouble(tokens[2]), tokens[4]));
                    } else if (tokens[4].equalsIgnoreCase("mid")) {

                        dipendenti.add(new Developer(tokens[1], Integer.parseInt(tokens[0]),
                                Double.parseDouble(tokens[2]), tokens[4]));

                    } else {
                        dipendenti.add(new SeniorDeveloper(tokens[1], Integer.parseInt(tokens[0]),
                                Double.parseDouble(tokens[2]), tokens[4]));
                    }

                } else {
                    dipendenti.add(new ProjectManager(tokens[1], Integer.parseInt(tokens[0]),
                            Double.parseDouble(tokens[2]), Integer.parseInt(tokens[5])));
                }
                riga = bf.readLine();
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dipendenti;
    }

    public static void main(String[] args) {
        ArrayList<Dipendente> dipendenti = new ArrayList<>();

        dipendenti = reader();

        try {
            FileWriter wr = new FileWriter("bonus.csv");
            for (Dipendente dipendente : dipendenti) {
                wr.write(dipendente.matricola + "," + dipendente.calcolaBonus() + "\n");
            }
            wr.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
