import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class SocketServer {
	public static void main(String[] args) {
		String s;
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		ServerSocket serverSocket = null;
		try {
			// Attende una connessione sulla porta 6789
			System.out.println("In attesa di una connessione.");
			serverSocket = new ServerSocket(6789);
			Socket socket = serverSocket.accept();
			// Connessione stabilita, imposta gli stream
			inputStream = new Scanner(new
					InputStreamReader(socket.getInputStream()));
			outputStream = new PrintWriter(new
					DataOutputStream(socket.getOutputStream()));
			// Legge una riga dal client
			s = inputStream.nextLine();
			// Visualizza il testo sul client
			outputStream.println("Bene, ");
			outputStream.println(s +
					" e’ un buon linguaggio di programmazione!");
			outputStream.flush();
			System.out.println("Chiusura della connessione da " + s);
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			// Se si verifica un’eccezione, la visualizza
			System.out.println("Errore " + e);
		}
	}
}