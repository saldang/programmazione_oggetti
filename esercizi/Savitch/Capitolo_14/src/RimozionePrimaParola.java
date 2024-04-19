import java.io.*;
import java.util.*;

public class RimozionePrimaParola {
       
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        
        System.out.println("Qual e' il file da cui leggere?");
        String infileName = tastiera.nextLine().trim();
        
        System.out.println("Qual e' il file su cui scrivere una volta rimossa la prima parola da ogni linea");
        String outfileName = tastiera.nextLine().trim();
        
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new File(infileName));
        } catch (FileNotFoundException ex) {
            System.out.println("Errore nell'aprire il file " + infileName + " in lettura");
            System.exit(0);
        }
        
        PrintWriter outputFile = null;
        try {
            outputFile = new PrintWriter(new File(outfileName));
        } catch (FileNotFoundException ex) {
            System.out.println("Errore nell'aprire il file " + outfileName + " in scrittura");
            System.exit(0);
        }

        // Processa il file linea per linea
        while(inputFile.hasNextLine()){
            String line = inputFile.nextLine();
            
            Scanner lineScanner = new Scanner(line);
            if(lineScanner.hasNext()){
                String parola = lineScanner.next();
                int posizioneParola = line.indexOf(parola);
                String rest = line.substring(posizioneParola + parola.length());
                outputFile.println(rest);
            } else {
                outputFile.println(line);
            }
        }
        
        inputFile.close();
        outputFile.close();
        
        System.out.println("Elaborazione file completata.");
    }
}





