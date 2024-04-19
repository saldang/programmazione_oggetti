
public class ElementoBiblioteca {
	private String titolo;
	private String autore;
	private String ISBN;
	private String dataAcquisizione;
	
	public ElementoBiblioteca(String titolo, String autore, String iSBN, String dataAcquisizione) {
		this.titolo = titolo;
		this.autore = autore;
		ISBN = iSBN;
		this.dataAcquisizione = dataAcquisizione;
	}
	public String getTitolo() {
		return titolo;
	}
	public String getAutore() {
		return autore;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getDataAcquisizione() {
		return dataAcquisizione;
	}
}
