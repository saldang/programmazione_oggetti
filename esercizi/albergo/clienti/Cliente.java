package albergo.clienti;

public abstract class Cliente {
    String nome;
    String cognome;

    Cliente(String n, String c) {
        nome = n;
        cognome = c;
    }

    public abstract String toString();
}
