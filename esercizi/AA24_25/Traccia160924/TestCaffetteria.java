public class TestCaffetteria {
    public static void main(String[] args) {
        Cassa cassa = new Cassa();
        // Lettura da file
        cassa.inventario.leggiFile("inventario.csv");
        cassa.inventario.stampaInventario();
        // Aggiunta prodotti all'inventario
        cassa.inventario.aggiungiArticolo(new Bevanda("003", "Ginseng", 2.5, 5, "media"));
        cassa.inventario.aggiungiArticolo(new Snack("103", "Pizza", 3.5, 5, "31-12-2024"));
        // Salvataggio inventario aggiornato
        cassa.inventario.scriviFile("inventario2.csv");

        // Creazione ordine
        Ordine newOrder = cassa.creaOrdine();
        // Aggiunta articolo
        try {
            newOrder.aggiungiArticolo(cassa.inventario.getArticoloByCode("001"), 2);
        } catch (ArticoloNonPresenteException e) {
            e.printStackTrace();
        }
        try {
            newOrder.aggiungiArticolo(cassa.inventario.getArticoloByCode("101"), 2);
        } catch (ArticoloNonPresenteException e) {
            e.printStackTrace();
        }
        cassa.calcolaTotale(newOrder);

        newOrder = cassa.creaOrdine();
        try {
            newOrder.aggiungiArticolo(cassa.inventario.getArticoloByCode("002"), 2);
        } catch (ArticoloNonPresenteException e) {
            e.printStackTrace();
        }
        try {
            newOrder.aggiungiArticolo(cassa.inventario.getArticoloByCode("103"), 1);
        } catch (ArticoloNonPresenteException e) {
            e.printStackTrace();
        }
        cassa.calcolaTotale(newOrder);
        for (Ordine ordine : cassa.ordini) {
            for (Articolo articolo : ordine.articoli.keySet()) {
                System.out.println(articolo);
                System.out.println(ordine.articoli.get(articolo));
            }
        }
        cassa.scriviFile("vendite.txt");
        cassa.inventario.scriviFile("inventario3.csv");
    }
}
