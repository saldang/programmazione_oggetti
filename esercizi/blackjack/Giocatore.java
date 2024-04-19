package blackjack;

public class Giocatore {

    private String nome;
    private int conto;
    private int punteggio = 0;
    private int puntata = 0;

    public Giocatore(String nome, int conto) {
        this.nome = nome;
        this.conto = conto;
    }

    public String getNome() {
        return nome;
    }

    public int getConto() {
        return conto;
    }

    public boolean punta(int puntata) {
        if (puntata > conto) {
            System.out.println("Non puoi puntare piu' di quanto hai!");
            return false;
        } else if (puntata < 0) {
            System.out.println("Non puoi puntare un valore negativo!");
            return false;
        } else {
            this.puntata = puntata;
            return true;
        }
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio += punteggio;
    }

    public void vincita(){
        conto += puntata;
        this.punteggio = 0;
    }

    public void perdita(){
        conto -= puntata;
        this.punteggio = 0;
    }



}
