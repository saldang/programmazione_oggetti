package es4;

public class TEL {
    private String numero;
    private int durata;

    TEL(String n, int d) {
        numero = n;
        durata = d;
    }

    public String getn() {
        return numero;
    }

    public int getd() {
        return durata;
    }
}// fine classe TEL
