package magazzino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Magazzino {

    public static void main(String[] args) {
        // Crea una lista di dispositivi per immagazzinare i prodotti
        List<Device> devices = new ArrayList<>();

        // Leggi i prodotti dal file csv
        try (BufferedReader br = new BufferedReader(new FileReader("stock.csv"))) {
            // Legge la prima riga (intestazione) e la salta
            br.readLine();

            // Legge le righe successive finché ci sono dati da leggere
            String line;
            while ((line = br.readLine()) != null) {
                // Divide la riga in colonne
                String[] columns = line.split(",");

                // Crea un oggetto di tipo appropriato in base al primo carattere della riga
                Device device;
                if (columns[0].equals("t")) {
                    device = new Tablet();
                } else {
                    device = new Smartphone();
                }

                // Imposta le proprietà del dispositivo leggendo le colonne del file
                device.setModello(line);(columns[1]);
                device.setMarca(columns[2]);
                device.setDisplay(Double.parseDouble(columns[3]));
                device.setPeso(Integer.parseInt(columns[4]));
                device.setConnessione(columns[5]);
                device.setCodice(Integer.parseInt(columns[6]));

                // Aggiunge il dispositivo alla lista
                devices.add(device);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Tipo\tModello\tMarca\tDisplay\tConnessione\tPeso\tCodice");
        for (Device device : devices) {
            System.out.println(device);
        }

        // Crea una mappa per contare il numero di pezzi per ogni modello
        Map<String, Integer> modelCounts = new HashMap<>();
        for (Device device : devices) {
            String model = device.getModello();
            if (modelCounts.containsKey(model)) {
                modelCounts.put(model, modelCounts.get(model) + 1);
            } else {
                modelCounts.put(model, 1);
            }
        }

        // Stampa l'elenco dei modelli presenti in magazzino e il numero di pezzi presenti per ogni modello
        System.out.println("\nModelli presenti in magazzino:");
        for (Map.Entry<String, Integer> entry : modelCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pezzi");
        }
    }
}
