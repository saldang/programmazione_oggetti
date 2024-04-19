public class App {
    public static void main(String[] args) {
        System.out.println("Benvenuto nella biblioteca");

        GestoreBiblioteca gb = new GestoreBiblioteca();

        gb.caricaCSV("biblio.csv");

        gb.printItems();

        gb.presta(1, "Mario Rossi");
        gb.presta(2, "Mario Rossi");

        gb.printItems();

        gb.restituisci(1);

        gb.printItems();
        gb.salvaPrestati();
    }
}
