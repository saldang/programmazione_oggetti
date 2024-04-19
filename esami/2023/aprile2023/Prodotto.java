package aprile2023;

public class Prodotto {
    private String codice;
    private String nome;
    private double prezzo;
    private int quantita;


    public Prodotto(String codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = 1;
    }

    public Prodotto(String codice, String nome, double prezzo, int quantita) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

}
