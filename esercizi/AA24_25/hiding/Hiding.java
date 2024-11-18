public class Hiding {
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.inserisciInizio(5);
        lista.inserisciFine(10);
        lista.inserisciFine(15);
        lista.inserisciInizio(1);

        System.out.println("Lista dopo inserimenti:");
        lista.stampaLista();

        System.out.println("Ricerca del valore 10: " + lista.cerca(10));
        System.out.println("Eliminazione del valore 5: " + lista.elimina(5));

        System.out.println("Lista dopo eliminazione:");
        lista.stampaLista();
    }
}

