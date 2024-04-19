/**
  Un'altra classe che rappresenta un rettangolo generico
 */
public class Rettangolo2 {
	private int larghezza;
	private int altezza;

	public void setDimensioni(int nuovaLarghezza, int nuovaAltezza) {
		larghezza = nuovaLarghezza;
		altezza = nuovaAltezza;
	}

	public int getArea() {
		return altezza*larghezza;
	}
}
