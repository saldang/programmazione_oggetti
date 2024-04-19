import java.io.*;
import java.util.*;

public class InformazioniContatto {
	private String nome;
	private String telefonoUfficio;
	private String telefonoCasa;
	private String cellulare;
	private String email;
	private String indirizzoCasa;

	// Il formato dell'input deve essere nome 
	// # telefono ufficio # telefono casa # cellulare # email # indirizzo casa 
	// Se un campo non e' noto, lasciare uno spazio bianco
	public InformazioniContatto(String input) throws ContattoNonValidoException {
		StringTokenizer scanner = new StringTokenizer(input, "#");
		// splitta in tocken
		if (scanner.countTokens() != 6)
			throw new ContattoNonValidoException("Non ho trovato il numero di campi necessari.");
		nome = scanner.nextToken().trim();
		telefonoUfficio = scanner.nextToken().trim();
		telefonoCasa = scanner.nextToken().trim();
		cellulare = scanner.nextToken().trim();
		email = scanner.nextToken().trim();
		indirizzoCasa = scanner.nextToken().trim();
	}

	public String toString() {
		return nome + "# " + telefonoUfficio + "# " + telefonoCasa + "# " + cellulare + "# " + email + "# "
				+ indirizzoCasa;
	}

	public String stringFormattata() {
		return "NOME:" + nome + " TELEFONO(UFFICIO): " + telefonoUfficio + " TELEFONO(CASA): " + telefonoCasa
				+ " TELEFONO(CELLULARE): " + cellulare + " EMAIL: " + email + " INDIRIZZO: " + indirizzoCasa;
	}

	public void aggiornaNome(String nuovoNome) {
		if (nuovoNome != null)
			nome = nuovoNome;
	}

	public void aggiornaTelefonoUfficio(String nuovoNumero) {
		if (nuovoNumero != null)
			telefonoUfficio = nuovoNumero;
	}

	public void aggiornaTelefonoCasa(String nuovoNumero) {
		if (nuovoNumero != null)
			telefonoCasa = nuovoNumero;
	}

	public void aggiornaTelefonoCellulare(String nuovoNumero) {
		if (nuovoNumero != null)
			cellulare = nuovoNumero;
	}

	public void aggiornaEmail(String nuovaEmail) {
		if (nuovaEmail != null)
			email = nuovaEmail;
	}

	public void aggiornaIndirizzoCasa(String nuovoIndirizzo) {
		if (nuovoIndirizzo != null)
			indirizzoCasa = nuovoIndirizzo;
	}
}
