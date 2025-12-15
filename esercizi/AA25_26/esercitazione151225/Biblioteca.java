import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private ArrayList<Libro> libri;
    private ArrayList<Prestito> prestiti;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.libri = new ArrayList<>();
        this.prestiti = new ArrayList<>();
    }

    public void aggiungiLibro(Libro l) {
        libri.add(l);
    }

    public Libro cercaLibroDisponibile(String titolo) {
        for (Libro libro : libri) {
            if (libro.titolo.equalsIgnoreCase(titolo))
                return libro;
        }
        return null;
    }

    public void creaPrestito(Utente u, Libro l, int giorniPrestito) {
        if (l.isDisponibile()) {
            Prestito p = new Prestito(u, l, LocalDate.now());
            for (Libro libro : libri) {
                if (l.equals(libro))
                    libro.presta();
            }
            prestiti.add(p);
        }
    }

    public void restituisciLibro(Libro l, int giorniRitardo) {
        for (Prestito prestito : prestiti) {
            if (l.equals(prestito.getLibro())) {

                for (Libro libro : libri) {
                    if (libro.equals(prestito.getLibro()))
                        libro.restituisci();
                }
                prestito.setPenaleTotale(prestito.getLibro().calcolaPenale(giorniRitardo));
            }

        }
    }

    public void caricaLibriDaFile(String nomeFile) {
        try (BufferedReader bf = new BufferedReader(new FileReader(nomeFile))) {
            String line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] info = line.split(",");
                if (info[0].equalsIgnoreCase("romanzo")) {
                    if (info.length > 7)
                        libri.add(new Romanzo(info[1], info[2], info[3], Integer.parseInt(info[4]),
                                Boolean.parseBoolean(info[5]), info[6], Integer.parseInt(info[7])));
                    else
                        libri.add(new Romanzo(info[1], info[2], info[3], Integer.parseInt(info[4]),
                                Boolean.parseBoolean(info[5]), info[6], Integer.parseInt(info[7]),
                                Boolean.parseBoolean(info[8])));
                } else if (info[0].equalsIgnoreCase("manuale")) {
                    libri.add(new Manuale(info[1], info[2], info[3], Integer.parseInt(info[4]),
                            Boolean.parseBoolean(info[5]), info[9], Integer.parseInt(info[10]),
                            Boolean.parseBoolean(info[11])));
                } else {
                    libri.add(new Rivista(info[1], info[2], info[3], Integer.parseInt(info[4]),
                            Boolean.parseBoolean(info[5]), info[12], Integer.parseInt(info[13]), info[14],
                            Boolean.parseBoolean(info[15])));
                }
            }
        } catch (IOException e) {
            System.out.println("Errore IO");
            e.printStackTrace();
        }
    }

    public void salvaPrestitiSuFile(String nomeFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile))) {
            for (Prestito prestito : prestiti) {
                pw.println(prestito);
            }

        } catch (IOException e) {
            System.out.println("Errore IO");
            e.printStackTrace();
        }
    }

    public void visualizzaPrestiti() {
        for (Prestito prestito : prestiti) {
            System.out.println(prestito);
        }
    }

    public void visualizzaTuttiLibri() {
        for (Libro libro : libri) {
            System.out.println(libro.visualizzaDettagli());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Libro> getLibri() {
        return libri;
    }

    public void setLibri(ArrayList<Libro> libri) {
        this.libri = libri;
    }

    public ArrayList<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(ArrayList<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

}
