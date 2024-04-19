import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    public static ArrayList<Veicolo> leggiCsv() {
        ArrayList<Veicolo> veicoli = new ArrayList<>();
        BufferedReader br;
        FileReader fr;
        try {
            fr = new FileReader("inventario.csv");
            br = new BufferedReader(fr);
            br.readLine();
            String riga = br.readLine();
            while (riga != null) {
                String[] tokens = riga.split(",");
                if (tokens[2].equalsIgnoreCase("auto")) {
                    veicoli.add(new Auto(tokens[0], tokens[1], Integer.parseInt(tokens[3]),
                            Double.parseDouble(tokens[6]), Double.parseDouble(tokens[5])));
                } else {
                    veicoli.add(new Moto(tokens[0], tokens[1], Integer.parseInt(tokens[4]),
                            Double.parseDouble(tokens[6]), Double.parseDouble(tokens[5])));
                }
                riga = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return veicoli;
    }

}
