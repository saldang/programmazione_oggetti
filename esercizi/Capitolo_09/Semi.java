/**
 Un'enumerazione di Semi di carte
*/
enum Semi {

	FIORI("nero"), QUADRI("rosso"), CUORI("rosso"), PICCHE("nero");

	private final String colore; 

	private Semi(String coloreSeme) { 
		colore = coloreSeme;
	}

	public String getColore() {
		return colore;
	}
}
