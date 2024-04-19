import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Dany {
public static void main(String aé[]) {
	// Riscrive il file
    ObjectOutputStream outFile = null;
    try {
        outFile = new ObjectOutputStream(new FileOutputStream("numeri.data"));
    } catch(FileNotFoundException e) {
    	System.out.println("Errore nell'aprire il file number.txt in scrittura " + e.getMessage());
        System.exit(0);
    } catch (IOException ex) {
    	System.out.println("Abbiamo un problema: " + ex.getMessage());
        System.exit(0);
    }

   
    // Riscrive l'array
        try {
            outFile.writeObject(new NumeroDiTelefonoSerializzato("12-654321"));
            outFile.writeObject(new NumeroDiTelefonoSerializzato("45-12-235512"));
            outFile.writeObject(new NumeroDiTelefonoSerializzato("34-42-113356"));
            outFile.writeObject(new NumeroDiTelefonoSerializzato("33-22-123145"));
            outFile.close();
        } catch (Exception ex) {
            System.out.println("Abbiamo un problema: " + ex.getMessage());
            System.exit(0);
        }
    
}
}
