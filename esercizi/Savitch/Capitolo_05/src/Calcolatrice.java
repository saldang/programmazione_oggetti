
public class Calcolatrice {
	public static double somma(int valore1, int valore2) {
		return valore1 + valore2;
	}
	
	public static double moltiplica(int valore1, int valore2) {
		return valore1 * valore2;
	}
	
	public static double dividi(int valore1, int valore2) {
		if(valore2 != 0)
			return valore1 / valore2;
		else
			return Double.NaN;
	}
	
	public static double sottrai(int valore1, int valore2) {
		return valore1 - valore2;
	}
	
}
