public class StatisticheVoto {
	private int numeroGiudizi, sommaGiudizi;

	public StatisticheVoto() {
		numeroGiudizi = 0;
		sommaGiudizi = 0;
	}

	public int getNumeroGiudizi() {
		return numeroGiudizi;
	}

	public int getSommaGiudizi() {
		return sommaGiudizi;
	}

	public void aggiungiGiudizio(int giudizio) {
		numeroGiudizi++;
		sommaGiudizi += giudizio;
	}
}