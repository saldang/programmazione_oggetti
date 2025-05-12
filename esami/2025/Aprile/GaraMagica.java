import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GaraMagica {
    ArrayList<AnimaleMagico> partecipanti;

    public GaraMagica() {
        partecipanti = new ArrayList<>();
    }

    void aggiungiAnimale(AnimaleMagico animale) {
        partecipanti.add(animale);
    }

    void simulaGara(double distanza) {
        AnimaleMagico vincitore = null;
        double tempoMinimo = 0;
        for (AnimaleMagico animale : partecipanti) {
            System.out.println("Partecipante: " + animale.descrizione());
            double tempo = animale.calcolaTempoPercorrenza(distanza);
            System.out.println("Tempo impiegato:" + tempo + " ore per percorrere " + distanza + " km.");
            if (vincitore == null || tempo < tempoMinimo) {
                vincitore = animale;
                tempoMinimo = tempo;
            }
        }
        if (vincitore != null) {
            System.out.println(
                    "Il vincitore è: " + vincitore.descrizione() + " con un tempo di " + tempoMinimo + " ore.");
        } else {
            System.out.println("Nessun partecipante alla gara.");
        }
    }

    void salvaPartecipantiSuFile(String nomeFile) {
        // Implementazione per salvare i partecipanti su un file

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            for (AnimaleMagico animale : partecipanti) {
                writer.println(animale.descrizione());
            }
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }

    }

    void caricaPartecipantiDaFile(String nomeFile) throws AnimaleNonValidoException {
        // Implementazione per caricare i partecipanti da un file
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(nomeFile))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Supponiamo che il file contenga le informazioni in un formato specifico
                String[] dati = linea.split(";");
                String tipo = dati[0];
                String nome = dati[1];
                int eta = Integer.parseInt(dati[2]);
                double velocitaBase = Double.parseDouble(dati[3]);

                if (eta < 0) {
                    throw new AnimaleNonValidoException("Età non valida per l'animale: " + nome);
                }

                if (velocitaBase <= 0) {
                    throw new AnimaleNonValidoException("Velocità non valida per l'animale: " + nome);
                }
                // Aggiungi logica per determinare il tipo di animale e aggiungerlo alla lista
                // Ad esempio, se il nome contiene "Fenice", creiamo un oggetto Fenice
                if (tipo.equalsIgnoreCase("Fenice")) {
                    partecipanti.add(new Fenice(nome, eta, velocitaBase));
                } else if (tipo.equalsIgnoreCase("Unicorno")) {
                    boolean siStanca = Boolean.parseBoolean(dati[4]);
                    partecipanti.add(new Unicorno(nome, eta, velocitaBase, siStanca));
                } else if (tipo.equalsIgnoreCase("Drago")) {
                    boolean soffiaFuoco = Boolean.parseBoolean(dati[4]);
                    partecipanti.add(new Drago(nome, eta, velocitaBase, soffiaFuoco));
                }
            }
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }
}
