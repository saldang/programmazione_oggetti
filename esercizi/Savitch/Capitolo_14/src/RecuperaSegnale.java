import java.io.*;
import java.util.*;

public class RecuperaSegnale {
    
    public static void main(String[] args) {
        ObjectInputStream inFile = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Qual e' il nome del file da leggere?");
        String fileName = input.next();
        
        try {
            inFile = new ObjectInputStream(new FileInputStream(fileName));
            System.out.println("I valori sono: ");
            Integer primoDato = inFile.readInt();
            System.out.println(primoDato);
            while(true){
                Byte difference = inFile.readByte();
                primoDato = primoDato + difference;
                System.out.println(primoDato);
            }
            
        } catch(EOFException e){
            System.out.println("E' cosi'.");
        } catch(IOException e){
            System.out.println("Abbaimo un problema: " + e.getMessage());
            
        }
    }
    
}
