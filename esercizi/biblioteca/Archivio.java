package biblioteca;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Archivio
 */
public class Archivio {

    private ArrayList<Libro> libri;

    public ArrayList<Libro> getLibri() {
        return libri;
    }

    public void setLibri(ArrayList<Libro> libri) {
        this.libri = libri;
    }

    private ArrayList<Abbonato> abbonati;

    public Archivio() {
        libri = new ArrayList<>();
        abbonati = new ArrayList<>();
    }

    public void newLibro(String titolo) {
        // if (nLibri < MAX_LIBRI) {
        // libri[nLibri] = new Libro();
        // libri[nLibri].setTitolo(titolo);
        // nLibri++;
        // }

        libri.add(new Libro(titolo));
    }

    public void newAbbonato(String nome, String cognome) {
        // if (nAbbonati < MAX_ABBONATI) {
        // abbonati[nAbbonati] = new Abbonato(nome, cognome);
        // nAbbonati++;
        // }

        abbonati.add(new Abbonato(nome, cognome));
    }

    public int trovaAbbonato(Abbonato abbonato) {
        // for (int i = 0; i < nAbbonati; i++) {
        // if (abbonati[i].equals(abbonato)) {
        // return i;
        // }
        // }
        for (Abbonato abb : abbonati) {
            if (abb.equals(abbonato)) {
                return abbonati.indexOf(abbonato);
            }
        }

        return -1;
    }

    public Date dataScadenza(Date dataPrestito) {
        // Date dataScadenza = new Date(dataPrestito.getDay(), dataPrestito.getMonth(),
        // dataPrestito.getYear());
        Date dataScadenza = new Date(dataPrestito.getTime() + 1000 * 60 * 60 * 24 * 30);
        System.out.println("Data scadenza: " + DateFormat.getDateInstance().format(dataScadenza));
        return dataScadenza;
    }

    public int trovaLibro(Libro l) {
        for (Libro libro : libri) {
            if (libro.getTitolo().equals(l.getTitolo())) {
                return libri.indexOf(libro);
            }
        }
        return -1;
    }

    public int presta(Libro libro, Abbonato abbonato, Date dataPrestito) {
        int librodaprestare = trovaLibro(libro);
        if (libri.get(librodaprestare).getAbbonato() != null) {
            return -1;
        }
        libro.setAbbonato(abbonato);
        libro.setDataScadenza(dataScadenza(dataPrestito));
        libri.set(librodaprestare, libro);
        return 0;
    }

    public void aggiorna() {
        Date today = new Date();
        // for (int i = 0; i < nLibri; i++) {
        // if (libri[i].getDataPrestito().equals(new Date())) {
        // libri[i].setAbbonato(null);
        // libri[i].setDataPrestito(null);
        // }
        // }
        for (Libro libro : libri) {
            String dataScadenza = DateFormat.getDateInstance(DateFormat.SHORT).format(libro.getDataScadenza());

            if (dataScadenza.equals(DateFormat.getDateInstance(DateFormat.SHORT).format(today))) {
                libro.setAbbonato(null);
                libro.setDataScadenza(null);
            }

        }
    }

    public int numLibri(Abbonato abbonato) {
        int num = 0;
        // for (int i = 0; i < nLibri; i++) {
        // if (libri[i].getAbbonato() != null &&
        // libri[i].getAbbonato().equals(abbonato)) {
        // num++;
        // }
        // }
        for (Libro libro : libri) {
            System.out.println(libro.getAbbonato());
            if (libro.getAbbonato() != null && libro.getAbbonato().equals(abbonato)) {
                num++;
            }
        }
        return num;
    }
}
