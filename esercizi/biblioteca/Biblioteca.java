package biblioteca;

import java.util.Date;

public class Biblioteca {
    Archivio archivio = new Archivio();

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        Abbonato a = new Abbonato("Mario", "Rossi");
        Abbonato a2 = new Abbonato("Giovanni", "Verdi");

        b.archivio.newAbbonato(a.getNome(), a.getCognome());
        b.archivio.newAbbonato(a2.getNome(), a2.getCognome());

        Libro l = new Libro("Il Signore degli Anelli");
        Libro l2 = new Libro("Il Signore degli Anelli 2");
        Libro l3 = new Libro("Il Signore degli Anelli 3");

        b.archivio.newLibro(l.getTitolo());
        b.archivio.newLibro(l2.getTitolo());
        b.archivio.newLibro(l3.getTitolo());
        System.out.println(b.archivio.getLibri().size());
        Date dataPrestito = Date.from(new Date().toInstant());
        System.out.println(dataPrestito);

        System.out.println(new Date(dataPrestito.getTime() + 1000 * 60 * 60 * 24 * 30));
        prestato(b.archivio.presta(l, a, dataPrestito));
        prestato(b.archivio.presta(l2, a, dataPrestito));
        prestato(b.archivio.presta(l2, a2, dataPrestito));

        System.out.println("Libri di " + a.getNome() + " " + a.getCognome() + ":" + b.archivio.numLibri(a));
        for (Libro libro : b.archivio.getLibri()) {
            System.out.println(libro.getTitolo());
            System.out.println(libro.getAbbonato());
            System.out.println(libro.getDataScadenza());
        }

    }

    private static void prestato(int x) {
        if (x != -1) {
            System.out.println("Prestato");
        } else {
            System.out.println("Non disponibile");
        }
    }
}
