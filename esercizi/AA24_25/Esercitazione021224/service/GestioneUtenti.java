package service;

import java.io.*;
import java.util.ArrayList;

import model.Dipendente;
import model.Docente;
import model.Studente;
import model.Utente;

public class GestioneUtenti {
    private ArrayList<Utente> utenti;

    public GestioneUtenti() {
        utenti = new ArrayList<>();
    }

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }

    public void cercaUtente(String id) throws UtenteNonTrovatoException {
        for (Utente utente : utenti) {
            if (utente.getId().equals(id)) {
                System.out.println(utente);
                return;
            }
        }
        throw new UtenteNonTrovatoException("Utente non trovato!");
    }

    private void creaCartella(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void salvaTuttiGliUtenti(String path) {
        for (Utente utente : utenti) {
            try {
                if (utente instanceof Studente) {
                    creaCartella(path + "/studenti");
                    utente.generaScheda(path + "/studenti");
                } else if (utente instanceof Dipendente) {
                    creaCartella(path + "/dipendenti");
                    utente.generaScheda(path + "/dipendenti");
                } else if (utente instanceof Docente) {
                    creaCartella(path + "/docenti");
                    utente.generaScheda(path + "/docenti");
                } else
                    continue;

            } catch (IOException e) {
                System.out.println("Errore nella scrittura del file: " + utente.getId());
            }
        }
    }

    public void caricaDaCartelle(String pathPrincipale) {
        File directoryPrincipale = new File(pathPrincipale);

        if (!directoryPrincipale.exists() || !directoryPrincipale.isDirectory()) {
            System.out.println("Directory principale non trovata!");
            return;
        }

        for (File sottocartella : directoryPrincipale.listFiles()) {
            if (sottocartella.isDirectory()) {
                String categoria = sottocartella.getName().toLowerCase();

                for (File file : sottocartella.listFiles()) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            Utente utente = leggiScheda(file, categoria);
                            if (utente != null) {
                                utenti.add(utente);
                            }
                        } catch (IOException e) {
                            System.out.println("Errore nella lettura del file: " + file.getName());
                        }
                    }
                }
            }
        }
    }

    private Utente leggiScheda(File file, String categoria) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String id = null, nome = null, email = null, classe = null, ruolo = null, materia = null;
        double mediaVoti = 0.0, stipendio = 0.0;

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length < 2)
                continue;
            String key = parts[0].trim();
            String value = parts[1].trim();

            switch (key) {
                case "ID":
                    id = value;
                    break;
                case "Nome":
                    nome = value;
                    break;
                case "Email":
                    email = value;
                    break;
                case "Classe":
                    classe = value;
                    break;
                case "MediaVoti":
                    mediaVoti = Double.parseDouble(value);
                    break;
                case "Ruolo":
                    ruolo = value;
                    break;
                case "Stipendio":
                    stipendio = Double.parseDouble(value);
                    break;
                case "Materia":
                    materia = value;
                    break;
            }
        }
        reader.close();

        // Creazione dinamica dell'oggetto in base alla categoria
        switch (categoria) {
            case "studenti":
                return new Studente(id, nome, email, classe, mediaVoti);
            case "dipendenti":
                return new Dipendente(id, nome, email, ruolo, stipendio);
            case "docenti":
                return new Docente(id, nome, email, ruolo, stipendio, materia);
            default:
                return null;
        }
    }

    public void stampaUtenti() {
        for (Utente utente : utenti) {
            System.out.println(utente);
        }
    }

    // Genera un file di testo report.txt che riepiloga tutti gli utenti con i
    // dettagli essenziali.
    public void stampaReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            for (Utente utente : utenti) {
                writer.write(utente.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore nella scrittura del file report.txt");
        }
    }
}
