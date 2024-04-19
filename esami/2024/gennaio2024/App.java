/**
 * App
 */
public class App {

    public static void main(String[] args) {
        GestioneLibreria gestioneLibreria = new GestioneLibreria();

        gestioneLibreria.leggiDaFile("libreria.csv");
        gestioneLibreria.mostraLibreria();
        String[] libriDaAggiungere = {
                "Libro,Il Trono di Spade,George R.R. Martin,1996,694,",
                "Audiolibro,Il Trono di Spade,George R.R. Martin,1996,,600",
                "Libro,Il Conte di Montecristo,Alexandre Dumas,1844,1276,",
                "Audiolibro,Il Conte di Montecristo,Alexandre Dumas,1844,,1200"
        };
        for (String inputUtente : libriDaAggiungere) {
            String[] info = inputUtente.split(",");
            if (info[0].equals("Libro")) {
                Libro libro = new Libro(info[1], info[2], info[3], Integer.parseInt(info[4]));
                gestioneLibreria.aggiungiRisorsa(libro);
            } else if (info[0].equals("Audiolibro")) {
                Audiolibro audiolibro = new Audiolibro(info[1], info[2], info[3], Integer.parseInt(info[5]));
                gestioneLibreria.aggiungiRisorsa(audiolibro);
            }
        }

        gestioneLibreria.scriviSuFile("libreria1.csv");

        GestioneLibreria gestioneLibreria2 = new GestioneLibreria();
        System.out.println("Libreria aggiornata:");
        gestioneLibreria2.leggiDaFile("libreria1.csv");
        gestioneLibreria2.mostraLibreria();
        System.out.println("Libreria modificata:");
        gestioneLibreria2.modificaRisorsa("1984", new Libro("1984", "George Orwell", "1949", 338));
        gestioneLibreria2.mostraLibreria();
        gestioneLibreria2.scriviSuFile("libreria2.csv");

    }
}