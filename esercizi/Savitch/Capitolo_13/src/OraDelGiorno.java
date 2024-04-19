import java.util.*;

public class OraDelGiorno {

	private int ora;
	private int minuti;
	private boolean isAM;

	public OraDelGiorno() {
		ora = 0;
		minuti = 0;
		isAM = false;
	}

	public void setOra(String stringaOra)
			throws FormatoInvalidoException, OraNonValidaException, MinutiNonValidiException {
		int oraRilevata;
		int minutiRilevati;
		String indicatorFound;

		Scanner tastiera = new Scanner(stringaOra);
		tastiera.useDelimiter(":");
		try {
			oraRilevata = tastiera.nextInt();
		} catch (Exception e) {
			throw new FormatoInvalidoException("Ora non e' un intero");
		}

		if (oraRilevata < 1 || oraRilevata > 24)
			throw new OraNonValidaException("Ora non nell'intervallo 1 - 12");

		// Recupero il resto della stringa
		String restoDellaStringa = tastiera.next();
		tastiera = new Scanner(restoDellaStringa);

		// Tronco gli ultimi 2 caratteri
		if (restoDellaStringa.length() < 3)
			throw new FormatoInvalidoException("Formato non valido");

		String minutiStringa = restoDellaStringa.substring(0, restoDellaStringa.length() - 2);
		String amStringa = restoDellaStringa.substring(restoDellaStringa.length() - 2);

		try {
			minutiRilevati = Integer.parseInt(minutiStringa);

		} catch (Exception e) {
			throw new FormatoInvalidoException("Minuti non sono un intero");
		}

		if (minutiRilevati < 0 || minutiRilevati > 59)
			throw new MinutiNonValidiException("Minuti non nell'intervallo 0 - 59");

		if (!amStringa.equals("am") && !amStringa.equals("pm"))
			throw new FormatoInvalidoException("Non inserito ne' AM e ne' PM");

		ora = oraRilevata;
		minuti = minutiRilevati;

		if (amStringa.equals("am"))
			isAM = true;
		else
			isAM = false;
	}

	public String toString() {
		String risultato = "Ora:  " + ora + ":" + minuti;
		if (isAM)
			risultato = risultato + "am";
		else
			risultato = risultato + "pm";
		return risultato;
	}

	public static void main(String[] args) {
		OraDelGiorno t = new OraDelGiorno();
		System.out.println(t);
		System.out.println("\nCambia l'ora in 1:11am");
		try {
			t.setOra("1:11am");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

		System.out.println("\nCambia l'ora in 17:11am");
		try {
			t.setOra("17:11am");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

		System.out.println("\nCambia l'ora in 1:89am");
		try {
			t.setOra("1:89am");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

		System.out.println("\nCambia l'ora in 1:11 am");
		try {
			t.setOra("1:11 am");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

		System.out.println("\nCambia l'ora in 1/11am");
		try {
			t.setOra("1/11am");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

		System.out.println("\nCambia l'ora in 1:11AM");
		try {
			t.setOra("1:11AM");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

		System.out.println("\nCambia l'ora in 1:11");
		try {
			t.setOra("1:11");
		} catch (FormatoInvalidoException e) {
			System.out.println("Rilevato un formato non valido: " + e.getMessage());
		} catch (OraNonValidaException e) {
			System.out.println("Rilevato un formato non valido dell'ora: " + e.getMessage());
		} catch (MinutiNonValidiException e) {
			System.out.println("Rilevato un formato non valido dei minuti: " + e.getMessage());
		}
		System.out.println(t);

	}
}
