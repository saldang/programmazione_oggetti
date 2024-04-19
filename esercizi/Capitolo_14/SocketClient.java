


import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class SocketClient {
	public static void main(String[] args) {
		String s;
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		try {
			// Connessione al server sulla stessa macchina, porta 6789
			Socket clientSocket = new Socket("localhost", 6789);
			// Imposta gli stream per inviare/ricevere i dati
			inputStream = new Scanner(new
					InputStreamReader(clientSocket.getInputStream()));
			outputStream = new PrintWriter(new
					DataOutputStream(clientSocket.getOutputStream()));
			// Invia “Java” al server
			outputStream.println("Java");
			outputStream.flush(); // Invia i dati allo stream
			// Legge tutte le righe provenienti dal server
			// e le visualizza sullo schermo
			while (inputStream.hasNextLine()) {
				s = inputStream.nextLine();
				System.out.println(s);
			}
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			// Se si verifica un’eccezione, la visualizza
			System.out.println("Errore " + e);
		}
	}
}