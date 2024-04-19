import java.net.URL;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class Browser {
	public static void main(String[] args) {
		String url;
		Scanner tastiera = new Scanner(System.in);

		try {
			System.out.println("Inserisci l'URL che vuoi raggiungere:");
			url = tastiera.next();
			URL website = new URL(url);
			Scanner inputStream = new Scanner(new InputStreamReader(website.openStream()));
			while (inputStream.hasNextLine()) {
				String s = inputStream.nextLine();
				System.out.println(s);
			}
			inputStream.close();
		} catch (MalformedURLException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}