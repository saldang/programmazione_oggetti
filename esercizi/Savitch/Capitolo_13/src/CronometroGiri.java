
import java.util.Calendar;

public class CronometroGiri {
	private boolean inEsecuzione;
	private int numeroGiri;
	private int giriCompletati;
	private long tempoDiPartenza;
	private long tempoDiPartenzaGiroCorrente;
	private long durataUltimoGiro;
	private long tempoTotale;

	public CronometroGiri(int n) {
		inEsecuzione = false;
		numeroGiri = n;
		giriCompletati = 0;
		tempoDiPartenza = 0;
		tempoDiPartenzaGiroCorrente = 0;
		durataUltimoGiro = 0;
		tempoTotale = 0;
	}

	public void parti() throws CronometroException {
		if (inEsecuzione == true || giriCompletati > 0)
			throw new CronometroException("Il timer e' gia' partito");
		inEsecuzione = true;
		tempoDiPartenza = Calendar.getInstance().getTimeInMillis();
		tempoDiPartenzaGiroCorrente = tempoDiPartenza;
	}

	public void marcaGiro() throws CronometroException {
		if (!inEsecuzione)
			if (giriCompletati == 0)
				throw new CronometroException("Il timer non e' partito");
			else
				throw new CronometroException("Tutti i giri sono stati completati");

		giriCompletati++;
		long currentTime = Calendar.getInstance().getTimeInMillis();
		durataUltimoGiro = currentTime - tempoDiPartenzaGiroCorrente;
		tempoTotale = currentTime - tempoDiPartenza;
		tempoDiPartenzaGiroCorrente = currentTime;

		if (giriCompletati == numeroGiri)
			inEsecuzione = false;
	}

	public long getDurataUltimoGiro() throws CronometroException {
		if (giriCompletati == 0)
			throw new CronometroException("Nessun giro e' stato completato");

		return durataUltimoGiro;
	}

	public long getTempoTotale() throws CronometroException {
		if (giriCompletati == 0)
			throw new CronometroException("Nessun giro e' stato completato");

		return tempoTotale;
	}

	public int getGiriRimanenti() {
		return numeroGiri - giriCompletati;
	}

}
