public class ListaConcatenataDoppiaDemo {
	public static void main(String[] args) {
		boolean risultato = false;

		ListaConcatenataDoppia<String> lista = new ListaConcatenataDoppia<String>();

		lista.mostraStatoLista();
		System.out.println();

		System.out.println("============================");

		// aggiunge un nodo alla lista vuota
		System.out.println("Aggiungi un nodo alla lista vuota.");
		lista.aggiungiNodoInTesta("Alligatore");
		lista.mostraStatoLista();
		System.out.println();
		System.out.println("============================");

		// Aggiunge nodi alla line della lista
		System.out.println("AAggiunge nodi alla fine della listat.");
		lista.reimpostaIterazione();
		lista.inserisciNodoDopoCorrente("Carlino");
		lista.mostraStatoLista();
		lista.vaiAlProssimo();
		lista.inserisciNodoDopoCorrente("Gatto");
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		// Aggiunge nodi nel mezzo della lista
		System.out.println("Aggiunge nodi nel mezzo della lista.");
		lista.reimpostaIterazione();
		lista.vaiAlProssimo();
		lista.mostraStatoLista();
		lista.inserisciNodoDopoCorrente("Leone");
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		lista.vaiAlProssimo();
		System.out.println("Cancella il primo nodo.");
		lista.cancellaNodoTesta();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println("Aggiunge ulteriori nodi alla fine della lista.");
		lista.vaiAlProssimo();
		lista.inserisciNodoDopoCorrente("Delfino");
		lista.vaiAlProssimo();
		lista.inserisciNodoDopoCorrente("Elefante");
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println("Indietro di un nodo");
		lista.vaiAlPrecedente();
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println("Cancella nel mezzo della lista.");
		lista.vaiAlPrecedente();
		System.out.println("Cancella il nodo corrente: " + lista.getDatiDaNodoCorrente());
		lista.cancellaNodoCorrente();
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println();
		System.out.println("Aggiunge all'inizio della lista.");
		lista.aggiungiNodoInTesta("Gallinella di mare");
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println();
		System.out.println("Itera alla fine della listat.");
		lista.mostraStatoLista();
		System.out.println("Inizia iterazione.");
		while (lista.ancoraDaIterare()) {
			lista.mostraStatoLista();
			lista.vaiAlProssimo();
		}
		System.out.println("Finisce iterazione.");
		lista.mostraStatoLista();
		System.out.println();
		System.out.println("============================");

		System.out.println();
		System.out.println("Itera la lista in senso inverso.");
		lista.reimpostaIteratoreAlContrario();
		lista.mostraStatoLista();
		System.out.println("Inizia iterazione.");
		while (lista.ancoraDaIterare()) {
			lista.mostraStatoLista();
			lista.vaiAlPrecedente();
		}
		System.out.println("Finisce iterazione.");
		lista.mostraStatoLista();
		System.out.println();
		System.out.println("============================");

		System.out.println("Cancella dalla fine della lista.");
		lista.reimpostaIteratoreAlContrario();
		lista.mostraStatoLista();
		lista.cancellaNodoCorrente();
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println("Cerca Delfino nella lista: dovrebbe essere trovato.");
		risultato = lista.cercaNellaLista("Delfino");
		if (risultato) {
			System.out.println("Trovato.");
		} else {
			System.out.println("Non trovato.");
		}
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");

		System.out.println("Cerca Delfino nella lista: dovrebbe essere trovato.");
		risultato = lista.cercaNellaLista("Delfino");
		if (risultato) {
			System.out.println("Trovato.");
		} else {
			System.out.println("Non trovato.");
		}
		lista.mostraStatoLista();
		lista.mostraLista();
		System.out.println();
		System.out.println("============================");
	}
}
