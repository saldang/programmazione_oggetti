import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestoreRistorante {

        // - `List<Piatto>` per gestire il menu
        // - `Map<Integer, Ordine>` per associare tavoli agli ordini
        // - `Map<String, Integer>` per inventario ingredienti
        // - Metodi per gestire ordini, calcolare conti, generare report

        List<Piatto> menu;
        Map<Integer, Ordine> ordini;
        Map<String, Integer> inventarioIngredienti;

        // Costruttore

        public GestoreRistorante() {
                this.menu = new ArrayList<>();
                this.ordini = new HashMap<>();
                this.inventarioIngredienti = new HashMap<>();
        }

        // Carica menu da file CSV
        public void caricaMenu(String nomeFile) throws FormatoMenuException {
        }

        // Crea nuovo ordine per tavolo
        public void nuovoOrdine(int numeroTavolo, String tipo)

                        throws TavoloNonValidoException {
                if (!ordini.containsKey(numeroTavolo)) {
                        Ordine nuovoOrdine = new Ordine(ordini.size() + 1, numeroTavolo,
                                        java.time.LocalDateTime.now().toString(), "APERTO", tipo);
                        ordini.put(numeroTavolo, nuovoOrdine);
                } else {
                        throw new TavoloNonValidoException("Il tavolo " + numeroTavolo +
                                        " ha già un ordine aperto.");
                }
        }

        // Aggiunge piatto all'ordine
        public void aggiungiPiattoOrdine(int tavolo, String nomePiatto, int quantita)
                        throws PiattoNonDisponibileException {
        if (ordini.containsKey(tavolo)) {
            Ordine ordine = ordini.get(tavolo);
            Piatto piattoDaAggiungere = null;
            for (Piatto piatto : menu) {
                if (piatto.getNome().equalsIgnoreCase(nomePiatto)) {
                        piattoDaAggiungere = piatto;
                }
            }
                if (piattoDaAggiungere != null) {
                        ordine.aggiungiPiatto(piattoDaAggiungere, quantita);
                } else {
                        throw new PiattoNonDisponibileException("Il piatto " + nomePiatto + " non è disponibile nel menu.");
                }} else {
            throw new PiattoNonDisponibileException("Il tavolo " + tavolo + " non ha un ordine aperto.");


        }

        // Personalizza piatto nell'ordine
        public void personalizzaPiatto(int tavolo, String piatto, String modifica, double costoExtra)
                        throws PiattoNonDisponibileException {
        }

        // Rimuove piatto dall'ordine
        public void rimuoviPiattoOrdine(int tavolo, String nomePiatto)
                        throws PiattoNonDisponibileException {
        }

        // Calcola conto del tavolo
        public double calcolaConto(int numeroTavolo) throws OrdineVuotoException {
        }

        // Genera report vendite
        public void generaReportVendite(String nomeFile) {
        }

        // Mostra piatti disponibili
    public void mostraMenuDisponibile()

    // Ottieni tempo stimato ordine
        public int getTempoStimato(int numeroTavolo) {
        }
}
