public class Computer extends Product{
    int memoria;
    String processore;
    String gpu;

    public Computer(String modello, String marca, String colore, int prezzo, int peso, int memoria, String processore,
            String gpu) {
        super(modello, marca, colore, prezzo, peso);
        this.memoria = memoria;
        this.processore = processore;
        this.gpu = gpu;
    }

    public String scriviDettagli(){
        return "Computer,"+super.scriviDettagli()+","+memoria+","+processore+","+gpu+",";
    }
    
}
