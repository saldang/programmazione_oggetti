package esame.albergo2025;

import java.io.FileNotFoundException;
import java.util.Locale;

public class HotelMain {
    public static void main(String[] args) {
        System.out.println("==== SISTEMA ALBERGO ====");

        Albergo albergo = new Albergo("Hotel Copilot");
        System.out.println("[Creazione albergo e 5 camere]");

        CameraSingola singola101 = new CameraSingola(101);
        CameraSingola singola102 = new CameraSingola(102, true, 2);
        CameraMatrimoniale matrimoniale201 = new CameraMatrimoniale(201);
        CameraMatrimoniale matrimoniale202 = new CameraMatrimoniale(202, true, false, "Due letti singoli");
        CameraDeLuxe deluxe301 = new CameraDeLuxe(301, false, false, false);

        albergo.aggiungiCamera(singola101);
        albergo.aggiungiCamera(singola102);
        albergo.aggiungiCamera(matrimoniale201);
        albergo.aggiungiCamera(matrimoniale202);
        albergo.aggiungiCamera(deluxe301);

        System.out.println("[Creazione clienti]");
        try {
            Cliente cliente1 = new Cliente("Mario", "Rossi", "mario@email.com", "3201234567");
            Cliente cliente2 = new Cliente("Anna", "Bianchi", "anna@email.com", "+39 320 123 4567");
            Cliente cliente3 = new Cliente("Giovanni", "Ferrari", "giovanni@email.com", "3209876543");

            try {
                new Cliente("", "Verdi", "verdi.email.com", "1234");
            } catch (ClienteNonValidoException e) {
                System.out.println("ERRORE CATTURATO: " + e.getMessage());
            }

            System.out.println("[Creazione 3 prenotazioni valide]");
            Prenotazione pren1 = albergo.creaPrenotazione(cliente1, singola101, 2);
            System.out.println("Prenotazione 1: " + pren1.getCliente().getNome() + " " + pren1.getCliente().getCognome()
                    + " - Camera Singola N. " + pren1.getCamera().getNumero()
                + " - €" + String.format(Locale.ROOT, "%.2f", pren1.getCostoTotale())
                    + " per " + pren1.getGiorniPrenotati() + " giorni");

            Prenotazione pren2 = albergo.creaPrenotazione(cliente2, matrimoniale201, 3);
            System.out.println("Prenotazione 2: " + pren2.getCliente().getNome() + " " + pren2.getCliente().getCognome()
                    + " - Camera Matrimoniale N. " + pren2.getCamera().getNumero()
                + " - €" + String.format(Locale.ROOT, "%.2f", pren2.getCostoTotale())
                    + " per " + pren2.getGiorniPrenotati() + " giorni");

            deluxe301.setScontoLealta(0.10);
            Prenotazione pren3 = albergo.creaPrenotazione(cliente3, deluxe301, 4);
            System.out.println("Prenotazione 3: " + pren3.getCliente().getNome() + " " + pren3.getCliente().getCognome()
                    + " - Camera DeLuxe N. " + pren3.getCamera().getNumero()
                + " - €" + String.format(Locale.ROOT, "%.2f", pren3.getCostoTotale())
                    + " per " + pren3.getGiorniPrenotati() + " giorni (con sconto 10%)");

            try {
                albergo.creaPrenotazione(cliente1, singola101, 1);
            } catch (CameraOccupatException e) {
                System.out.println("ERRORE CATTURATO: " + e.getMessage());
            }

            String filePrenotazioni = "esami/2025/Novembre/prenotazioni.csv";
            System.out.println("[Salvataggio prenotazioni su file]");
            albergo.salvaPrenotazioniSuFile(filePrenotazioni);

            System.out.println("[Caricamento prenotazioni da file]");
            albergo.caricaPrenotazioniDaFile(filePrenotazioni);
            albergo.visualizzaPrenotazioni();
        } catch (ClienteNonValidoException e) {
            System.out.println("ERRORE CATTURATO: " + e.getMessage());
        } catch (CameraOccupatException e) {
            System.out.println("ERRORE CATTURATO: " + e.getMessage());
        } catch (FileAccessException e) {
            System.out.println("ERRORE CATTURATO: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("ERRORE CATTURATO: " + e.getMessage());
        }

        System.out.println("[Visualizzazione dettagli di tutte le camere]");
        albergo.visualizzaTutteCamere();

        System.out.println("==== FINE TEST ====");
    }
}
