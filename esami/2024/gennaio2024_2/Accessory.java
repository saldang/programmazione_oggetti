public class Accessory extends Product{

    boolean cancellazioneRumore;

    public Accessory(String modello, String marca, String colore, int prezzo, int peso, boolean cancellazioneRumore) {
        super(modello, marca, colore, prezzo, peso);
        this.cancellazioneRumore = cancellazioneRumore;
    }

    public String scriviDettagli(){
        return "Accessory,"+super.scriviDettagli()+",,,,"+cancellazioneRumore;
    }
    
}
