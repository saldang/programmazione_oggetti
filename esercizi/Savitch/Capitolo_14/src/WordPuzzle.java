import java.io.FileInputStream;
import java.util.Scanner;

public class WordPuzzle {
	public static void main(String[] args) {
		String s;
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("words.txt"));
			while (inputStream.hasNextLine()) {
				s = inputStream.nextLine();
				s = s.toLowerCase();
				if (s.indexOf("dous") > 0) {
					// Parola candidata: la stampa
					System.out.println(s);
				}
			}
			inputStream.close();
		} catch (Exception e) {
			// Se viene sollevata un'eccezione, il programma termina
			System.out.println("Error " + e);
			System.exit(0);
		}
	}
}
