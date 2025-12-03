import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RepositoryVeicoli {

    ArrayList<Veicolo> veicoli;

    public RepositoryVeicoli() {
        this.veicoli = new ArrayList<>();
    }

    public void aggiungiVeicolo(Veicolo v) {
        veicoli.add(v);
    }

    public void rimuoviVeicolo(Veicolo v) {
        int index = veicoli.indexOf(v);
        // Veicolo temp = null;
        // for (Veicolo veicolo : veicoli) {
        // if (veicolo.equals(v)) {
        // temp = veicolo;
        // // index = veicoli.indexOf(veicolo);
        // }
        // }
        // if (temp != null)
        // veicoli.remove(temp);

        if (index > 0)
            veicoli.remove(veicoli.get(index));

    }

    public void readCSV(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                switch (info[3].toLowerCase()) {
                    case "automobile": {
                        veicoli.add(new Automobile(info[0], info[1], Integer.parseInt(info[2]), info[7],
                                Boolean.parseBoolean(info[5]), Double.parseDouble(info[8]), Long.parseLong(info[4]),
                                Boolean.parseBoolean(info[6])));
                    }

                        break;
                    case "motocicletta": {
                        veicoli.add(new Motocicletta(info[0], info[1], Integer.parseInt(info[2]), info[7],
                                Double.parseDouble(info[8]), Long.parseLong(info[4]), Boolean.parseBoolean(info[5])));

                    }

                        break;
                    case "bicicletta": {
                        veicoli.add(new Bicicletta(info[0], info[1], Integer.parseInt(info[2]), info[7],
                                Boolean.parseBoolean(info[6]), Double.parseDouble(info[8])));
                    }
                        break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
