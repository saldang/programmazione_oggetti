public class Computer extends Product{
    double memoria;
    String processore;
    String gpu;
    public Computer(String modello, String marca, double prezzo, String colore, double peso, double memoria,
            String processore, String gpu) {
        super(modello, marca, prezzo, colore, peso);
        this.memoria = memoria;
        this.processore = processore;
        this.gpu = gpu;
    }

    
}
