import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<Persona>();
        Scanner tastiera = new Scanner(System.in);
        boolean letto = false;
        boolean create = false;
        String nomeFile = null;
        File newFile = null;
        while (!letto && !create) {
            System.out.println("\nInserisci il nome del file da leggere:");
            nomeFile = tastiera.nextLine();

            try {
                Scanner inputStream = new Scanner(new File(nomeFile));

                while (inputStream.hasNextLine()) {
                    String line = inputStream.nextLine();
                    String[] fields = line.split(",");
                    persone.add(new Persona(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]),
                            Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
                }
                letto = true;
            } catch (FileNotFoundException e) {
                System.out.println("File non trovato! Inserisci il nome corretto.");
                System.out.println("Vuoi creare il file?(s/n)");
                String scelta = tastiera.nextLine();
                if (scelta.equalsIgnoreCase("s")) {
                    newFile = new File(nomeFile);
                    try {
                        newFile.createNewFile();
                        create = true;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        if (create && persone.isEmpty()) {
            System.out.println("Inserisci almeno i dati di due persone separate da virgola(es. 34,40,3,1)");
            int count = 0;
            // PrintWriter outWriter = null;
            do {
                String line = tastiera.nextLine();
                // try {
                // outWriter = new PrintWriter(new FileOutputStream(nomeFile, true));
                // outWriter.println(line);
                // } catch (FileNotFoundException e) {
                // e.printStackTrace();
                // } finally {
                // outWriter.close();
                // }
                String[] fields = line.split(",");
                persone.add(new Persona(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]),
                        Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));

                count++;
            } while (count < 2);
            System.out.print("Continua ad inserire (s/n):");
            String scelta = tastiera.nextLine();
            while (scelta.equalsIgnoreCase("s")) {
                String line = tastiera.nextLine();
                String[] fields = line.split(",");
                persone.add(new Persona(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]),
                        Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
                System.out.print("Continua ad inserire (s/n):");
                scelta = tastiera.nextLine();
            }
            letto = true;
        }

        if (letto) {
            int count1 = 0;
            int count2 = 0;
            int sumNumNoduli1 = 0;
            int sumNumNoduli2 = 0;
            PrintWriter outputStream = null;
            try {
                outputStream = new PrintWriter(newFile.getAbsoluteFile());

                for (Persona persona : persone) {
                    System.out.println(persona);
                    outputStream.write(persona.toString());

                    if (persona.stato == 1) {
                        count1++;
                        sumNumNoduli1 += persona.nNoduli;
                    } else {
                        count2++;
                        sumNumNoduli2 += persona.nNoduli;
                    }
                }
            } catch (IOException e) {
                System.out.println("Errore Apertura file");
                e.printStackTrace();
            }

            System.out.println("Media noduli delle persone sopravvissute piu di 5 anni: " + sumNumNoduli1 / count1);
            System.out.println("Media noduli delle persone decedute prima dei 5 anni: " + sumNumNoduli2 / count2);

        }
        tastiera.close();
    }
}
