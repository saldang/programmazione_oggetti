/**
 Classe che rappresenta un generico rettangolo
 */
public class Rettangolo {
	private int larghezza;
	private int altezza;
	private int area;

	public void setDimensioni(int nuovaLarghezza, int nuovaAltezza) {
		larghezza = nuovaLarghezza;
		altezza = nuovaAltezza;
		area = larghezza * altezza;
	}

	public int getArea() {
		return area;
	}
}
