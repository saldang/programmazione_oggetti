public class GestoreVeicoli {
    public static void main(String[] args) {
        // TODO Aggiungere, rimuovere e recuperare veicoli dal RepositorioVeicoli
        RepositoryVeicoli rv = new RepositoryVeicoli();

        rv.readCSV("veicoli.csv");

        rv.rimuoviVeicolo(new Motocicletta("Ducati", "Panigale V4", 2021, "rosso", 22000, 1103, true));

        for (Veicolo veicolo : rv.veicoli) {
            System.out.println(veicolo.visualizzaInformazioniVeicolo());
        }
        // TODO Visualizzare il valore di mercato e le informazioni di ciascun veicolo
        // TODO Accelerare e frenare i veicoli, e visualizzare la distanza totale
        // percorsa
        // TODO Salvare la lista di veicoli in un file binario
        // TODO Caricare la lista di veicoli da un file csv
    }

}
