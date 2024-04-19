public class Phone extends Product{
    int memoria;
    String processore;

    public Phone(String modello, String marca, String colore, int prezzo, int peso, int memoria, String processore) {
        super(modello, marca, colore, prezzo, peso);
        this.memoria = memoria;
        this.processore = processore;
    }

    public String scriviDettagli(){
        return "Phone,"+super.scriviDettagli()+","+memoria+","+processore+",,";
    }

    
}
