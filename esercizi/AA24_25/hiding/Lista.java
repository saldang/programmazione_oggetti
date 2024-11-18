public class Lista {
    // Classe interna Nodo che rappresenta ciascun elemento della lista
    private class Nodo {
        int valore;
        Nodo prossimo;

        Nodo(int valore) {
            this.valore = valore;
            this.prossimo = null;
        }
    }

    // Riferimento al primo elemento della lista
    private Nodo testa;

    // Costruttore che inizializza la lista vuota
    public Lista() {
        testa = null;
    }

    // Metodo pubblico per inserire un elemento all'inizio della lista
    public void inserisciInizio(int valore) {
        Nodo nuovoNodo = new Nodo(valore);
        nuovoNodo.prossimo = testa;
        testa = nuovoNodo;
    }

    // Metodo pubblico per inserire un elemento alla fine della lista
    public void inserisciFine(int valore) {
        Nodo nuovoNodo = new Nodo(valore);
        if (testa == null) {
            testa = nuovoNodo;
        } else {
            Nodo ultimo = trovaUltimoNodo();
            ultimo.prossimo = nuovoNodo;
        }
    }

    // Metodo pubblico per cercare un elemento nella lista
    public boolean cerca(int valore) {
        Nodo corrente = testa;
        while (corrente != null) {
            if (corrente.valore == valore) {
                return true;
            }
            corrente = corrente.prossimo;
        }
        return false;
    }

    // Metodo pubblico per eliminare un elemento dalla lista
    public boolean elimina(int valore) {
        if (testa == null) {
            return false;
        }

        if (testa.valore == valore) {
            testa = testa.prossimo;
            return true;
        }

        Nodo precedente = null;
        Nodo corrente = testa;

        while (corrente != null && corrente.valore != valore) {
            precedente = corrente;
            corrente = corrente.prossimo;
        }

        if (corrente == null) {
            return false;
        }

        precedente.prossimo = corrente.prossimo;
        return true;
    }

    // Metodo privato per trovare l'ultimo nodo della lista
    private Nodo trovaUltimoNodo() {
        Nodo corrente = testa;
        while (corrente.prossimo != null) {
            corrente = corrente.prossimo;
        }
        return corrente;
    }

    // Metodo per stampare la lista (facoltativo, per testare la classe)
    public void stampaLista() {
        Nodo corrente = testa;
        while (corrente != null) {
            System.out.print(corrente.valore + " -> ");
            corrente = corrente.prossimo;
        }
        System.out.println("null");
    }
}