package esame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Garage {

    public static void main(String[] args) {
        Veicolo[] veicoli = new Veicolo[3];
        veicoli[0] = new Auto("AA123BB", "Fiat", "Panda");
        veicoli[1] = new Auto("CC123DD", "Fiat", "Tipo");
        veicoli[2] = new Auto("BB123CC", "Fiat", "Punto");
        Garage garage = new Garage();
        garage.stampaVeicoli(veicoli);

        Auto[] auto = null;
        // Leggi file csv e conta le righe per inizializzare vettore di auto
        try (BufferedReader br = new BufferedReader(new FileReader("veicoli.csv"))) {
            String line;
            int count = 0;
            line = br.readLine(); // Scartare la prima riga
            while ((line = br.readLine()) != null) {
                count++;
            }
            auto = new Auto[count];

        } catch (FileNotFoundException e) {

        } catch (Exception e) {

        }
        // Leggi file csv e crea oggetti auto
        try (BufferedReader br = new BufferedReader(new FileReader("veicoli.csv"))) {
            String line;
            int i = 0;
            line = br.readLine(); // Scartare la prima riga
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                auto[i] = new Auto(values[0], values[1], values[2]);
                i++;
            }
        } catch (FileNotFoundException e) {

        } catch (Exception e) {

        }
        garage.stampaVeicoli(auto);
        System.out.println("Ordinamento...");
        garage.ordinaVeicoli(veicoli);
        garage.ordinaVeicoli(auto);
        garage.stampaVeicoli(veicoli);
        garage.stampaVeicoli(auto);

    }

    public void stampaVeicoli(Veicolo[] veicoli) {
        for (Veicolo veicolo : veicoli) {
            System.out.println(veicolo);
        }
    }

    public void ordinaVeicoli(Veicolo[] veicoli) {
        Arrays.sort(veicoli);
    }
}
