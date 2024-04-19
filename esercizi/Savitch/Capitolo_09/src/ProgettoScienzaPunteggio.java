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

	public ProgettoScienzaPunteggio(String nome, String id, String persona) {
		nomeProgetto = nome;
		identificativo = id;
		proprietario = persona;
		punteggioCreativita = new Punteggio("Creativita' del progetto", 30);
		punteggioValoreScientifico = new Punteggio("Valore scientifico del progetto", 30);
		punteggioCompletezza = new Punteggio("Completezza del progetto", 15);
		punteggioAbilitaTecnica = new Punteggio("Abilita' tecniche dimostrate dal progetto", 15);
		punteggioChiarezza = new Punteggio("Chiarezza nella presentazione del progetto", 10);
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
		ProgettoScienzaPunteggio progettoDiLeonardo = new ProgettoScienzaPunteggio("CoderBot", "A1234", "Leonardo");
		ProgettoScienzaPunteggio progettoDiDaniela = new ProgettoScienzaPunteggio("App Life", "B1234", "Daniela");

		progettoDiLeonardo.giudicaProgetto();
		progettoDiDaniela.giudicaProgetto();
		System.out.println("La valutazione dei progetti e' terminata: ");
		System.out.println(progettoDiLeonardo.getPunteggioTotaleInFormatoStringa());
		System.out.println(progettoDiDaniela.getPunteggioTotaleInFormatoStringa());

	}

}
