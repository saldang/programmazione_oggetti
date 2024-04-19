public class OccupazioneStanza {

	private int numeroNellaStanza;
	private static int numeroTotale = 0;

	/**
	 * Crea una nuova istanza di OccupazioneStanza
	 */
	public OccupazioneStanza() {
		numeroNellaStanza = 0;
	}

	public void aggiungiUnoAllaStanza() {
		numeroNellaStanza++;
		numeroTotale++;
	}

	public void rimuoviUnoDallaStanza() {
		if (numeroNellaStanza > 0) {
			numeroNellaStanza--;
			numeroTotale--;
		}
	}

	public int getNumero() {
		return numeroNellaStanza;
	}

	public static int getTotale() {
		return numeroTotale;
	}

	public static void main(String[] args) {
		OccupazioneStanza stanzaA = new OccupazioneStanza();
		OccupazioneStanza stanzaB = new OccupazioneStanza();

		System.out.println("Aggiunge 1 persona alla stanza a e 3 alla stanza b.");
		stanzaB.aggiungiUnoAllaStanza();
		stanzaA.aggiungiUnoAllaStanza();
		stanzaB.aggiungiUnoAllaStanza();
		stanzaB.aggiungiUnoAllaStanza();

		System.out.println("La stanza a ha " + stanzaA.getNumero() + " persone");
		System.out.println("La stanza b ha " + stanzaB.getNumero() + " persone");
		System.out.println("Totale persone in tutte le stanze " + OccupazioneStanza.getTotale());

		System.out.println("Rimuove una persona da entrambe le stanze.");
		stanzaA.rimuoviUnoDallaStanza();
		stanzaB.rimuoviUnoDallaStanza();

		System.out.println("La stanza a ha " + stanzaA.getNumero() + " persone");
		System.out.println("La stanza b ha " + stanzaB.getNumero() + " persone");
		System.out.println("Totale persone in tutte le stanze " + OccupazioneStanza.getTotale());

		System.out.println("Rimuove 2 persone dalla stanza a");
		stanzaA.rimuoviUnoDallaStanza();
		stanzaA.rimuoviUnoDallaStanza();
		System.out.println("La stanza a ha " + stanzaA.getNumero() + " persone");
		System.out.println("La stanza b ha " + stanzaB.getNumero() + " persone");
		System.out.println("Totale persone in tutte le stanze " + OccupazioneStanza.getTotale());

		System.out.println("Crea la stanza c ed aggiunge 3 persone alla stanza.");

		OccupazioneStanza stanzaC = new OccupazioneStanza();
		stanzaC.aggiungiUnoAllaStanza();
		stanzaC.aggiungiUnoAllaStanza();
		stanzaC.aggiungiUnoAllaStanza();
		System.out.println("La stanza a ha " + stanzaA.getNumero() + " persone");
		System.out.println("La stanza b ha " + stanzaB.getNumero() + " persone");
		System.out.println("La stanza c ha " + stanzaC.getNumero() + " persone");
		System.out.println("Totale persone in tutte le stanze " + OccupazioneStanza.getTotale());
	}

}
