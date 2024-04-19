/*
 * SerializedTelephoneProgram.java
 *
 * Created on June 5, 2007, 3:05 PM
 *
 * Solution to Project 6
 */

/**
 *
 * @author charleshoot
 */

import java.io.*;
import java.util.*;

public class NumeroDiTelefonoSerializzatoDemo {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);
        NumeroDiTelefonoSerializzato numeri[] = null;

        ObjectInputStream fileInput = null;
        try{
            try {
                fileInput = new ObjectInputStream(new FileInputStream("numeri.data"));

            } catch (FileNotFoundException ex) {
                throw new FileNumeriTelefonoMancanteException("File non trovato");
            } catch (IOException ex) {
                System.out.println("Errore nell'aprire il file numeri.data in lettura " + ex.getMessage());
                System.exit(0);
            }
            
            // Controlla quanti numeri ci sono
            int count = 0;
            try{
                while(true){
                    fileInput.readObject();
                    count++;
                }
            } catch(EOFException e){
                //fine file e conteggio corretto
            } catch(IOException e){
                System.out.println("Abbiamo un problema: " + e.getMessage());
                System.exit(0);
            } catch(ClassNotFoundException e) {
            	System.out.println("Abbiamo un problema: " + e.getMessage());
                System.exit(0);
            }
            try {
                fileInput.close();
            } catch (IOException ex) {
            	System.out.println("Abbiamo un problema: " + ex.getMessage());
                System.exit(0);
            }

            // Crea un array e quindi rilegge il file per inserire i numeri nell'array
            numeri = new NumeroDiTelefonoSerializzato[count];
            try {
                fileInput = new ObjectInputStream(new FileInputStream("numeri.data"));

            } catch (FileNotFoundException ex) {
            	System.out.println("Errore nell'aprire il file number.data in lettura " + ex.getMessage());
                System.exit(0);
            } catch (IOException ex) {
            	System.out.println("Errore nell'aprire il file number.data in lettura " + ex.getMessage());
                System.exit(0);
            }

            for(int i=0; i<count; i++){
                NumeroDiTelefonoSerializzato numero = null;
                try {
                    numero = (NumeroDiTelefonoSerializzato) fileInput.readObject();
                    numeri[i] = numero;
                    System.out.println("Il numero " + i + " e' " + numero);
                } catch(Exception e){
                	System.out.println("Abbiamo un problema: " + e.getMessage());
                    System.exit(0);
                }
            }

            try {
                fileInput.close();
            } catch (IOException ex) {
            	System.out.println("Abbiamo un problema: " + ex.getMessage());
                System.exit(0);
            }

        } catch (FileNumeriTelefonoMancanteException ex){
            // continuiamo con un array vuoto
            numeri = new NumeroDiTelefonoSerializzato[0];
        }

        NumeroDiTelefonoSerializzato nuovoNumero = null;

        System.out.println("Cambia un numero (c) o aggiungi un numero (a)");
        String risposta = tastiera.next().toLowerCase();
        if(risposta.equals("c")){
            System.out.println("Quale numero vuoi cambiare (immetti l'indice)");
            int index = tastiera.nextInt();
            System.out.println("Inserisci il numero di telefono");
            String phone = tastiera.next();

            try {
                nuovoNumero = new NumeroDiTelefonoSerializzato(phone);
            } catch (NumeroTelefonicoNonValidoException ex) {
                System.out.println("Formato non valido per il numero immesso " + ex.getMessage());
            }

            if(nuovoNumero != null)
                numeri[index] = nuovoNumero;
        } else if(risposta.equals("a")){
            System.out.println("Enter the phone number to add");
            String phone = tastiera.next();

            try {

                nuovoNumero = new NumeroDiTelefonoSerializzato(phone);
            } catch (NumeroTelefonicoNonValidoException ex) {
            	System.out.println("Formato non valido per il numero immesso " + ex.getMessage());
            }
        }

        // Riscrive il file
        ObjectOutputStream outFile = null;
        try {
            outFile = new ObjectOutputStream(new FileOutputStream("numeri.data"));
        } catch(FileNotFoundException e) {
        	System.out.println("Errore nell'aprire il file numeri.data in scrittura " + e.getMessage());
            System.exit(0);
        } catch (IOException ex) {
        	System.out.println("Abbiamo un problema: " + ex.getMessage());
            System.exit(0);
        }

        // Riscrive l'array
        for(int i=0; i<numeri.length; i++){
            try {
                outFile.writeObject(numeri[i]);
            } catch (IOException ex) {
                System.out.println("Abbiamo un problema: " + ex.getMessage());
                System.exit(0);
            }
        }

        if(risposta.equals("a"))

            try {
                outFile.writeObject(nuovoNumero);
            } catch (IOException ex) {
            	System.out.println("Abbiamo un problema: " + ex.getMessage());
                System.exit(0);
            }
        try {
            outFile.close();
        } catch (IOException ex) {
        	System.out.println("Abbiamo un problema: " + ex.getMessage());
            System.exit(0);
        }

        System.out.println("Il file e' stato riscritto.");
    }
}




