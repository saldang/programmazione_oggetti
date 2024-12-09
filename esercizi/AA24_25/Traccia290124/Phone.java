public class Phone extends Product{
    double memoria;
    String processore;
    
    public Phone(String modello, String marca, double prezzo, String colore, double peso, double memoria,
            String processore) {
        super(modello, marca, prezzo, colore, peso);
        this.memoria = memoria;
        this.processore = processore;
    }

    
    
}
