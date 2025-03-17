import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
    private List<Carta> carte;

    public Mazzo() {
        carte = new ArrayList<>();
    }

    public List<Carta> getCarte() {
        return carte;
    }
    
    public List<Carta> caricaDaFile(String nomeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                Carta carta = null;
                if (tokens[0].equals("Pokemon")) {
                    carta = new CartaPokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]));
                } else if (tokens[0].equals("Energia")) {
                    carta = new CartaEnergia(tokens[1], tokens[2], tokens[6]);
                }
                if (carta != null) {
                    carte.add(carta);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carte;
    }

    public Carta pescaCarta() {
        if (carte.isEmpty()) {
            System.out.println("Il mazzo è vuoto.");
            return null;
        }
        return carte.remove(0);
    }

    public void mescola(){
        Collections.shuffle(carte);
    }
}