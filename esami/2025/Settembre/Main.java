public class Main {
    public static void main(String[] args) {
        GestoreRistorante gestore = new GestoreRistorante();

        try {
            // Carica menu da file
            gestore.caricaMenu("menu.csv");

            // Crea nuovo ordine per tavolo 5
            gestore.nuovoOrdine(5, "TAVOLO");
            gestore.aggiungiPiattoOrdine(5, "Carbonara", 2);
            gestore.aggiungiPiattoOrdine(5, "Tiramisu", 2);

            // Personalizza piatto
            gestore.personalizzaPiatto(5, "Carbonara", "senza pecorino", -1.00);

            // Calcola e stampa conto
            double totale = gestore.calcolaConto(5);
            System.out.println("Totale tavolo 5: €" + totale);

            // Genera report vendite
            gestore.generaReportVendite("vendite_giornaliere.csv");

        } catch (PiattoNonDisponibileException | TavoloNonValidoException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
