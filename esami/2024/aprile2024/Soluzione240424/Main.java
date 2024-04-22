package Soluzione240424;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        SicurezzaCasa sicurezzaCasa = new SicurezzaCasa();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("utenti.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] values = line.split(",");
                sicurezzaCasa.aggiungiUtente(values[0], values[1]);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sicurezzaCasa.visualizzaUtenti();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sensori.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase("movimento")) {
                    SensoreMovimento sensore = new SensoreMovimento(values[1]);
                    sicurezzaCasa.aggiungiSensore(sensore);

                } else if (values[0].equalsIgnoreCase("fumo")) {
                    SensoreFumo sensore = new SensoreFumo(values[1]);
                    sicurezzaCasa.aggiungiSensore(sensore);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sicurezzaCasa.visualizzaSensori();

        GestoreEventi gestoreEventi = new GestoreEventi(sicurezzaCasa);

        try {
            sicurezzaCasa.attivaSistemaSicurezza(sicurezzaCasa.getAdmin());
        } catch (AutorizzazioneException e) {
            e.getMessage();
        }

        gestoreEventi.leggiEventi();

        try {
            sicurezzaCasa.disattivaSistemaSicurezza(sicurezzaCasa.getOspite());
        } catch (AutorizzazioneException e) {
            e.getMessage();
        }

        try {
            sicurezzaCasa.disattivaSistemaSicurezza(sicurezzaCasa.getAdmin());
        } catch (AutorizzazioneException e) {
            e.getMessage();
        }
    }
}
