//implements DecodificatoreMessaggio per risolvere il Programma 4.
public class CifrarioACombinazione implements CodificatoreMessaggio, DecodificatoreMessaggio {
	private int numeroCombinazioni;

	public CifrarioACombinazione(int n) {
		numeroCombinazioni = n;
	}

	public String codifica(String testoInChiaro) {
		String testoCifrato = testoInChiaro;
		for (int i = 0; i < numeroCombinazioni; i++) {
			testoCifrato = shuffle(testoCifrato);
		}
		return testoCifrato;
	}

	private String shuffle(String s) {
		String shuffled = "";

		int mid = s.length() / 2;
		String primo = s.substring(0, mid);
		String secondo = s.substring(mid, s.length());

		for (int i = 0; i < primo.length(); i++) {
			shuffled = shuffled + primo.charAt(i) + secondo.charAt(i);
		}

		// Se la lunghezza del messaggio è dispari aggiunge l'ultimo carattere
		if (secondo.length() > primo.length())
			shuffled = shuffled + secondo.charAt(secondo.length() - 1);

		return shuffled;
	}

	// metodo dell'interfaccia DecodificatoreMessaggio per risolvere il Programma 4.
	public String decodifica(String testoCodificato) {
		String testoInChiaro = testoCodificato;
		for (int i = 0; i < numeroCombinazioni; i++) {
			testoInChiaro = unshuffle(testoInChiaro);
		}
		return testoInChiaro;
	}

	private String unshuffle(String s) {
		String unshuffled = "";

		for (int i = 0; i < s.length(); i += 2)
			unshuffled = unshuffled + s.charAt(i);
		for (int i = 1; i < s.length(); i += 2)
			unshuffled = unshuffled + s.charAt(i);
		return unshuffled;
	}

	public static void main(String[] args) {
		CifrarioACombinazione shuffle3Times = new CifrarioACombinazione(3);
		String inChiaro = "Un messaggio da cifrare";
		System.out.println("Testo in chiaro: " + inChiaro);

		String cifrato = shuffle3Times.codifica(inChiaro);
		System.out.println("Testo cifrato: " + cifrato);

		CifrarioACombinazione shuffle1 = new CifrarioACombinazione(1);
		CifrarioACombinazione shuffle2 = new CifrarioACombinazione(2);
		CifrarioACombinazione shuffle3 = new CifrarioACombinazione(3);
		CifrarioACombinazione shuffle4 = new CifrarioACombinazione(4);
		CifrarioACombinazione shuffle5 = new CifrarioACombinazione(5);
		CifrarioACombinazione shuffle6 = new CifrarioACombinazione(6);

		String test = "abcd1234";
		System.out.println("Shuffling " + test);
		System.out.println("1 shuffle: " + shuffle1.codifica(test));
		System.out.println("2 shuffle: " + shuffle2.codifica(test));
		System.out.println("3 shuffle: " + shuffle3.codifica(test));
		System.out.println("4 shuffle: " + shuffle4.codifica(test));

		test = "abcd12345";
		System.out.println("Shuffling " + test);
		System.out.println("1 shuffle: " + shuffle1.codifica(test));
		System.out.println("2 shuffle: " + shuffle2.codifica(test));
		System.out.println("3 shuffle: " + shuffle3.codifica(test));
		System.out.println("4 shuffle: " + shuffle4.codifica(test));

		test = "abcde12345";
		System.out.println("Shuffling " + test);
		System.out.println("1 shuffle: " + shuffle1.codifica(test));
		System.out.println("2 shuffle: " + shuffle2.codifica(test));
		System.out.println("3 shuffle: " + shuffle3.codifica(test));
		System.out.println("4 shuffle: " + shuffle4.codifica(test));
		System.out.println("5 shuffle: " + shuffle5.codifica(test));
		System.out.println("6 shuffle: " + shuffle6.codifica(test));

		// Per progetto 4
		System.out.println("\nVerifica decodifica " + test);
		String shuffled = shuffle1.codifica(test);
		System.out.println("messaggio cifrato: " + shuffled);
		System.out.println("messaggio in chiaro: " + shuffle1.decodifica(shuffled));

		shuffled = shuffle2.codifica(test);
		System.out.println("\nmessaggio cifrato: " + shuffled);
		System.out.println("messaggio in chiaro: " + shuffle2.decodifica(shuffled));

		shuffled = shuffle3.codifica(test);
		System.out.println("\nmessaggio cifrato: " + shuffled);
		System.out.println("messaggio in chiaro: " + shuffle3.decodifica(shuffled));

		shuffled = shuffle4.codifica(test);
		System.out.println("\nmessaggio cifrato: " + shuffled);
		System.out.println("messaggio in chiaro: " + shuffle4.decodifica(shuffled));
	}
}
