import java.util.Scanner;

public class ProgettoScienzaPunteggio {
	private String nomeProgetto;
	private String identificativo;
	private String proprietario;
	private Punteggio punteggioCreativita;
	private Punteggio punteggioValoreScientifico;
	private Punteggio punteggioCompletezza;
	private Punteggio punteggioAbilitaTecnica;
	private Punteggio punteggioChiarezza;

	public void inizializza(String nome, String id, String persona) {
		nomeProgetto = nome;
		identificativo = id;
		proprietario = persona;
		punteggioCreativita = new Punteggio();
		punteggioValoreScientifico = new Punteggio();
		punteggioCompletezza = new Punteggio();
		punteggioAbilitaTecnica = new Punteggio();
		punteggioChiarezza = new Punteggio();
		punteggioCreativita.inizializza("Creativita' del progetto", 30);
		punteggioValoreScientifico.inizializza("Valore scientifico del progetto", 30);
		punteggioCompletezza.inizializza("Completezza del progetto", 15);
		punteggioAbilitaTecnica.inizializza("Abilita' tecniche dimostrate dal progetto", 15);
		punteggioChiarezza.inizializza("Chiarezza nella presentazione del progetto", 10);
	}

	public void giudicaProgetto() {
		System.out.println("Inserisci i punteggi per il progetto " + nomeProgetto + " (" + identificativo + ")");

		punteggioCreativita.ottieniPunteggio();
		punteggioValoreScientifico.ottieniPunteggio();
		punteggioCompletezza.ottieniPunteggio();
		punteggioAbilitaTecnica.ottieniPunteggio();
		punteggioChiarezza.ottieniPunteggio();
	}

	public int getPunteggioTotale() {
		return punteggioCreativita.getPunteggio() + punteggioValoreScientifico.getPunteggio() + punteggioCompletezza.getPunteggio()
				+ punteggioAbilitaTecnica.getPunteggio() + punteggioChiarezza.getPunteggio();
	}

	public int getPunteggioMassimo() {
		return punteggioCreativita.getPunteggioMassimo() + punteggioValoreScientifico.getPunteggioMassimo()
				+ punteggioCompletezza.getPunteggioMassimo() + punteggioAbilitaTecnica.getPunteggioMassimo()
				+ punteggioChiarezza.getPunteggioMassimo();
	}

	public String getPunteggioTotaleInFormatoStringa() {
		return "Il progetto " + nomeProgetto + " (" + identificativo + ") di " + proprietario + " ha ottenuto il punteggio di "
				+ getPunteggioTotale() + "/" + getPunteggioMassimo();
	}

	public static void main(String[] args) {
		ProgettoScienzaPunteggio progettoDiLeonardo = new ProgettoScienzaPunteggio();
		ProgettoScienzaPunteggio progettoDiDaniela = new ProgettoScienzaPunteggio();
		progettoDiLeonardo.inizializza("CoderBot", "A1234", "Leonardo");
		progettoDiDaniela.inizializza("App Life", "B1234", "Daniela");

		progettoDiLeonardo.giudicaProgetto();
		progettoDiDaniela.giudicaProgetto();
		System.out.println("La valutazione dei progetti e' terminata: ");
		System.out.println(progettoDiLeonardo.getPunteggioTotaleInFormatoStringa());
		System.out.println(progettoDiDaniela.getPunteggioTotaleInFormatoStringa());

	}

}
