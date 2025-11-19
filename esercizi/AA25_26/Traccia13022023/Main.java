import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Dipendente> dipendenti = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("dipendenti.csv"))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] info = line.split(",");
                if (info[3].equalsIgnoreCase("Developer")) {
                    if (info[4].equalsIgnoreCase("senior")) {
                        dipendenti.add(new SeniorDeveloper(Integer.parseInt(info[0]), info[1],
                                Double.parseDouble(info[2]), info[4]));
                    } else {
                        dipendenti.add(new Developer(Integer.parseInt(info[0]), info[1], Double.parseDouble(info[2]),
                                info[4]));
                    }

                } else if (info[3].equals("Project Manager")) {
                    dipendenti.add(new ProjectManager(Integer.parseInt(info[0]), info[1], Double.parseDouble(info[2]),
                            Integer.parseInt(info[5])));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Dipendente dipendente : dipendenti) {
            System.out.println(dipendente.getNome());
            System.out.println(dipendente);
            System.out.println(dipendente.getSalario());
            if (dipendente instanceof Developer d) {
                System.out.println(d.getLivello());
            }
            System.out.println(dipendente.calcolaBonus());
            System.out.println("---");
        }
    }
}
