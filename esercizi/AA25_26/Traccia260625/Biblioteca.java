public class Biblioteca {
    public static void main(String[] args) {
        Catalogo c = new Catalogo();
        c.carica("materiali.csv");
        System.out.println("------------------Carica");
        c.stampaMateriali();
        c.addMateriale(new MaterialeDigitale("D103", "asdasd", 1920, "null", 12.90, "MP3", 220.5, true));
        System.out.println("------------------Aggiunta");
        c.stampaMateriali();
        c.removeMateriale("B002");
        System.out.println("------------------Rimozione");
        c.stampaMateriali();
        Materiale m = c.cerca("d103");
        ((MaterialeDigitale) m).formato = "Mp3";
        // c.updateMateriale(new MaterialeDigitale("D103", "qweqwe", 1920, "null",
        // 12.90, "MP3", 220.5, true));
        c.updateMateriale(m);
        System.out.println("------------------Aggiornamento");
        c.stampaMateriali();
        System.out.println("------------------ Solo Cartaceo");
        for (Materiale materiale : c.soloTipo(MaterialeCartaceo.class)) {
            System.out.println(materiale);
        }
        System.out.println("------------------ Lettura csv aggiornato");
        c.salva("materiali.csv");
        Catalogo c2 = new Catalogo();
        c2.carica("materiali.csv");
        c2.stampaMateriali();
    }
}
