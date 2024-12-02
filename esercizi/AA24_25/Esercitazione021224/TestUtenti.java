import model.Dipendente;
import model.Docente;
import model.Studente;
import service.GestioneUtenti;

public class TestUtenti {
    public static void main(String[] args) {
        GestioneUtenti gu = new GestioneUtenti();
        gu.aggiungiUtente(new Dipendente("DIP001", "Mario Rossi", "mario.rossi@unicampania.it", "Segretario", 2000.0));
        gu.aggiungiUtente(new Docente("DOC001", "Mario Verdi", "mario.verdi@unicampania.it", "Associato", 2000.0,
                "Programmazione Oggetti"));
        gu.aggiungiUtente(new Studente("S001", "Giuseppe Rossi", "giuseppe.rossi@studente.unicampania.it", "2A", 26.9));

        gu.stampaUtenti();

        gu.stampaReport();

        gu.salvaTuttiGliUtenti();

        GestioneUtenti gu2 = new GestioneUtenti();

        gu2.caricaDaCartelle("utenti");

        gu2.stampaUtenti();

    }
}
