import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneLibreria implements GestioneFile {

    private ArrayList<RisorsaDigitale> libreria;

    public GestioneLibreria() {
        libreria = new ArrayList<>();
    }

    public void aggiungiRisorsa(RisorsaDigitale risorsa) {
        libreria.add(risorsa);
    }

    public void rimuoviRisorsa(RisorsaDigitale risorsa) {
        libreria.remove(risorsa);
    }

    public void modificaRisorsa(String titolo, RisorsaDigitale risorsa) {
        for (RisorsaDigitale risorsaDigitale : libreria) {
            if (risorsaDigitale.getTitolo().equals(titolo)) {
                libreria.set(libreria.indexOf(risorsaDigitale), risorsa);
            }
        }
    }

    public void mostraLibreria() {
        for (RisorsaDigitale risorsa : libreria) {
            System.out.println(risorsa.mostraDettagli());
        }
    }

    @Override
    public void scriviSuFile(String nomeFile) {
        try {
            PrintWriter file = new PrintWriter(nomeFile);
            file.println("tipo,titolo,autore,annoPubblicazione,numeroPagine,durata");
            for (RisorsaDigitale risorsa : libreria) {
                file.println(risorsa.mostraDettagli());
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: file non trovato");
        }
    }

    @Override
    public void leggiDaFile(String nomeFile) {
        try {
            File file = new File(nomeFile);
            Scanner input = new Scanner(file);
            String riga = input.nextLine();
            while (input.hasNext()) {
                riga = input.nextLine();
                String[] info = riga.split(",");
                if (info[0].equalsIgnoreCase("Libro")) {
                    Libro libro = new Libro(info[1], info[2], info[3], Integer.parseInt(info[4]));
                    libreria.add(libro);
                } else if (info[0].equalsIgnoreCase("Audiolibro")) {
                    Audiolibro audiolibro = new Audiolibro(info[1], info[2], info[3], Integer.parseInt(info[5]));
                    libreria.add(audiolibro);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: file non trovato");
        }
    }

}
