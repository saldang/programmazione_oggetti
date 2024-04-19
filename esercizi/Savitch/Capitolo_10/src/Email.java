
public class Email extends Documento {
	private String mittente;
	private String destinatario;
	private String titolo;

	/**
	 * Costruttori
	 */
	public Email() {
		this("", "", "", "");
	}

	public Email(String testo, String mittente, String destinatario, String titolo) {
		super(testo);
		setMittente(mittente);
		setDestinatario(destinatario);
		setTitolo(titolo);		
	}

	// ======================
	// get e set
	// ======================
	public String getMittente() {
		return mittente;
	}

	public void setMittente(String mittente) {
		this.mittente = mittente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Ritorna una stringa che contiene il tetso, il mittente, il destinatario ed il titolo
	 */
	public String toString() {
		return "Mittente " + mittente + " Destinatario " + destinatario + " Titolo " + titolo + " " + super.toString();
	}
} // Email
