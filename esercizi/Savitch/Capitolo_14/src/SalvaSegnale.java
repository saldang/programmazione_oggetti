import java.io.*;
import java.util.*;

public class SalvaSegnale {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual e' il nome del file da craere?");
        String fileName = input.next();
        
        try {
            ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(fileName));
            System.out.println("Inserire i dati interi uno alla volta.");
            System.out.println("Il primo dato deve essere positivo.");
            System.out.println("Un valore negativo indica che tutti i valori sono stati inseriti..");
            System.out.println("Ogni valore deve essere compreso entro 127 del valore precedente");
            Integer primoDato = input.nextInt();
            while(primoDato < 0){
                System.out.println("Inserire un valore positivo.");
                primoDato = input.nextInt();
            }
            outFile.writeInt(primoDato);
            
            int goodMin = Math.max(primoDato - 127, 0);
            int goodMax = Math.min(primoDato + 127, Integer.MAX_VALUE);
            Integer nextData = input.nextInt();
            
            while(nextData >= 0){
                if(nextData >= goodMin && nextData <= goodMax){
                    byte difference = (byte) (nextData - primoDato);
                    outFile.writeByte(difference);
                    System.out.println("La differenza e' " + difference);
                    
                    primoDato = nextData;
                    goodMin = Math.max(primoDato - 127, 0);
                    goodMax = Math.min(primoDato + 127, Integer.MAX_VALUE);
                    nextData = input.nextInt();
                } else {
                    System.out.println("Il valore deve essere compreso nel range " + goodMin + " - " + goodMax);
                    nextData = input.nextInt();
                }
            }            
            outFile.close();
        } catch(Exception e){
            System.out.println("Abbiamo un problema:" + e.getMessage());
            
        }
    }
}
