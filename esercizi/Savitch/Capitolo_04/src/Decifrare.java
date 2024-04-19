// Questo progarmma usa una tecnica brute force per decriptare il messaggio
// cercando tutte le possibili chiavi e visualizzando il risultato per ciascun tentativo.
// Un apersona osserva il risultato e decide se e' corretto.
//
// La chiave e' 88 e il messaggio e' "Attack at Dawn!"
public class Decifrare {
	public static void main(String[] args) {
		String criptata = ":mmZ\\dxZmx]Zpgy";

		// Prova tutte le chiavi da 1 a 100
		for (int chiave = 1; chiave <= 100; chiave++) {
			System.out.print("Prova chiave " + chiave + " :");
			for (int i = 0; i < criptata.length(); i++) {
				// Decifra ogni carattere
				char e = criptata.charAt(i);
				int d;
				if ((e - chiave) < 32)
					d = e - 32 + 127 - chiave;
				else
					d = e - chiave;
				System.out.print((char) d);
			}
			System.out.println();
		}
	}
}
