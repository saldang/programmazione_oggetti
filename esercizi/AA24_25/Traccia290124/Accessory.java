public class Accessory extends Product {
    boolean cancellazioneRumore;

    public Accessory(String modello, String marca, double prezzo, String colore, double peso,
            boolean cancellazioneRumore) {
        super(modello, marca, prezzo, colore, peso);
        this.cancellazioneRumore = cancellazioneRumore;
    }
}
