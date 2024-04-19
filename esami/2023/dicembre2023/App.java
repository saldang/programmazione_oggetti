import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<ElementoArchivio> caricaArchivio() {
        ArrayList<ElementoArchivio> elementiArchivio = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("archivio.csv"));
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] elementi = line.split(",");
                if (elementi[0].equals("Documento")) {
                    Documento documento = new Documento(elementi[1], elementi[2], elementi[3], elementi[4]);
                    elementiArchivio.add(documento);
                } else if (elementi[0].equals("Immagine")) {
                    Immagine immagine = new Immagine(elementi[1], elementi[2], elementi[3], elementi[4]);
                    elementiArchivio.add(immagine);
                } else if (elementi[0].equals("Audio")) {
                    Audio audio = new Audio(elementi[1], elementi[2], elementi[3], elementi[4]);
                    elementiArchivio.add(audio);
                } else {
                    System.out.println("Errore");
                }
                line = reader.readLine();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return elementiArchivio;

    }

    private static void salvaArchivio(ArrayList<ElementoArchivio> elementiArchivio) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("archivio.csv"));
            writer.write("Tipo, Nome, Data Creazione, Attributo 1, Attributo 2");
            writer.newLine();
            for (ElementoArchivio elemento : elementiArchivio) {
                writer.write(elemento.visualizzaDettagli());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArchivioDigitale archivio = new ArchivioDigitale(caricaArchivio());

        ElementoArchivio[] elementiArchivio = new ElementoArchivio[archivio.elementiArchivio.size()];
        archivio.elementiArchivio.toArray(elementiArchivio);
        System.out.println("Seleziona l'elemento da eliminare: ");
        long start1 = System.nanoTime();
        for (ElementoArchivio elementoArchivio : archivio.elementiArchivio) {
            System.out.println(
                    archivio.elementiArchivio.indexOf(elementoArchivio) + ":" + elementoArchivio.visualizzaDettagli());

        }
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        for (int i = 0; i < archivio.elementiArchivio.size(); i++) {
            System.out.println(i + ":" + elementiArchivio[i].visualizzaDettagli());
        }
        long end2 = System.nanoTime();
        System.out.println("Tempo di esecuzione: " + (end1 - start1) / 1000 + " ns");

        System.out.println("Tempo di esecuzione: " + (end2 - start2) / 1000 + " ns");

    }

}
