public class BibliotecaTest {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca("Vanvitelli");
        bib.caricaLibriDaFile("libri.csv");
        bib.visualizzaTuttiLibri();
        Utente utente1, utente2, utente3;
        try {
            utente1 = new Utente("Luca", "Verdi", "luca@email.com", "BIB001234");

            utente2 = new Utente("Sara", "Neri", "sara@email.com", "BIB005678");

            utente3 = new Utente("Paolo", "Bianchi", "paolo@email.com", "BIB009012");

            // Utente utenteErrato = new Utente("salvatore", "dangelo", "test.com", "BIB123456");

            // Utente utenteErrato2 = new Utente("salvatore", "dangelo", "test@test.com", "BIB13456");

            bib.creaPrestito(utente1, bib.getLibri().get(2), 21);
            bib.creaPrestito(utente2, bib.getLibri().get(4), 21);
            bib.creaPrestito(utente3, bib.getLibri().get(6), 21);

            bib.restituisciLibro(bib.getLibri().get(2), 5);
            bib.restituisciLibro(bib.getLibri().get(4), 3);
            bib.restituisciLibro(bib.getLibri().get(6), 2);

            bib.salvaPrestitiSuFile("prestiti.txt");

            bib.visualizzaPrestiti();
        } catch (UtenteNonValidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
