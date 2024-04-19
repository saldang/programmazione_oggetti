
public class Confronta {

	public static int confronta(int primo, int secondo) {
		if(primo > secondo)
			return primo - secondo;
		else 
			return secondo - primo;
	}
	
	
	public static void main(String arg[]) {
		int valore1 = 10;
		int valore2 = 9;
		int esito = confronta(valore1, valore2);
		System.out.println(esito);
		valore1 = 8;
		valore2 = 10;
		esito = confronta(valore1, valore2);
		System.out.println(esito);
	}
}
