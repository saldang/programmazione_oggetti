
public class CoppiaAnimali {
	private Animale primo, secondo;
	
	public CoppiaAnimali(Animale primoAnimale, Animale secondoAnimale) {
		primo = primoAnimale;
		secondo = secondoAnimale;
	}
	
	public Animale getPrimo() {
		return primo; 
	}

	public Animale getSecondo() {
		return secondo;
	}

	public void scriviOutput() {
		System.out.println("Primo animale nella coppia:");
		primo.scriviOutput(); 
		System.out.println("\nSecondo animale nella coppia:"); 
		secondo.scriviOutput();
	}
}
