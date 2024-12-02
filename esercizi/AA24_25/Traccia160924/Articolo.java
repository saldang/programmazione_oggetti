public abstract class Articolo {

    public String codice;
    public String nome;
    public double prezzo;
    public int quantita;

    public Articolo(String codice, String nome, double prezzo, int quantita) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    @Override
    public String toString(){
        return codice+","+nome+","+prezzo+","+quantita;
    }

}