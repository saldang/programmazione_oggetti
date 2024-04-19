import java.io.*;
import java.util.*;

public class NumeroDiTelefono {
	private boolean haPrefissoInternazionale;
	private int prefissoInternazionale;
	private int prefissoNazionale;
	private int numero;

	public NumeroDiTelefono(String input) throws NumeroTelefonicoNonValidoException {
		StringTokenizer scanner = new StringTokenizer(input, "-");
		// splitta la stringa garzie ai trattini
		if ((scanner.countTokens() != 2) && (scanner.countTokens() != 3))
			throw new NumeroTelefonicoNonValidoException("Non ho trovato il giusto numero di elementi nel numero.");
		if (scanner.countTokens() == 3) {
			String prefissoInternazioneString = scanner.nextToken().trim();
			if (prefissoInternazioneString.length() != 2)
				throw new NumeroTelefonicoNonValidoException("Il prefisso internazionale non e' di 2 cifre");
			try {
				prefissoInternazionale = Integer.parseInt(prefissoInternazioneString);
			} catch (NumberFormatException ex) {
				throw new NumeroTelefonicoNonValidoException("Il prefisso internazionale non era un intero.");
			}
			haPrefissoInternazionale = true;
		} else
			haPrefissoInternazionale = false;

		String prefissoNazionaleString = scanner.nextToken().trim();
		if (prefissoNazionaleString.length() != 2)
			throw new NumeroTelefonicoNonValidoException("Il prefisso nazionale non e' di 2 cifre");
		try {
			prefissoNazionale = Integer.parseInt(prefissoNazionaleString);
		} catch (NumberFormatException ex) {
			throw new NumeroTelefonicoNonValidoException("Il prefisso azionale non era un intero.");
		}

		String numeroString = scanner.nextToken().trim();
		if (numeroString.length() != 6)
			throw new NumeroTelefonicoNonValidoException("Il numero non e' di 6 cifre");
		try {
			numero = Integer.parseInt(numeroString);
		} catch (NumberFormatException ex) {
			throw new NumeroTelefonicoNonValidoException("Il numero non era un intero.");
		}
	}

	public String toString() {

		String prefissoInternazioneString = Integer.toString(prefissoInternazionale);
		
		String prefissoNazionaleString = Integer.toString(prefissoNazionale);

		String numeroString = Integer.toString(numero);
		
		String risultato;

		if (haPrefissoInternazionale)
			risultato = prefissoInternazioneString + "-" + prefissoNazionaleString + "-" + numeroString;
		else
			risultato = prefissoNazionaleString + "-" + numeroString;

		return risultato;
	}
}
