public class Pirata implements Comparable<Pirata> {
    String nome;
    String soprannome;
    String ruolo;
    char sesso;
    int eta;
    double altezza;
    double taglia;

    public Pirata(String nome, String soprannome, String ruolo, char sesso, int eta, double altezza, double taglia) {
        this.nome = nome;
        this.soprannome = soprannome;
        this.ruolo = ruolo;
        this.sesso = sesso;
        this.eta = eta;
        this.altezza = altezza;
        this.taglia = taglia;
    }

    @Override
    public String toString() {
        return nome + "," + soprannome + "," + ruolo + "," + sesso + "," + "," + eta + "," + altezza + "," + taglia;
    }

 

    @Override
    public int compareTo(Pirata o) {
        if (this.taglia > o.taglia)
            return 1;
        else if (this.taglia == o.taglia)
            return 0;
        else
            return -1;
    }
}
