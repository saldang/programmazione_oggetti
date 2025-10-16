public interface Ordinabile {
    // - `aggiungiAllOrdine(int numeroTavolo, int quantita)`: aggiunge piatto
    // all'ordine
    // - `rimuoviDallOrdine(int numeroTavolo)`: rimuove piatto dall'ordine
    // - `getDisponibilita()`: verifica se ingredienti sono disponibili
    // - `getTempoTotale(int quantita)`: calcola tempo preparazione totale

    double aggiungiAllOrdine(int numeroTavolo, int quantita);

    boolean rimuoviDallOrdine(int numeroTavolo);

    boolean getDisponibilita();

    int getTempoTotale(int quantita);
}
