/**
 
  File name: DoubleOutDriver.java
 
  Until the user says not to repeat:
     Read in a floating point number (type double).
     Call all three writeln methods to display the number
 		(using 5 for the number of digits to the right of the
 		decimal point when you need to specify such a number).
 
  Author: Lew Rakocy
  email address: LRakocy@devrycols.edu
  Date: 8/27/00
  Last changed:
  Updated for fourth edition by Brian Durney, November 2004
*/
import java.util.*;

public class ConvertiScientificoDriver
{
    public static void main(String[] args)
    {
        Scanner tastiera = new Scanner(System.in);

        double valore;
        char risposta;

        System.out.println("Si collaudano tutti e 3 i metodi scrivi di ConvertiScientifico");
        do {
            System.out.println("Inserisci un valore di tipo double:");
            valore = tastiera.nextDouble();
            System.out.println();

            // Usa scriviRiga di Euro.
            ConvertiScientifico.scriviRiga(valore);
            System.out.println();

            // Usa scriviRiga per stampare un numero con un 
            // certo numero di cifre decimali (5 in questo caso)
            ConvertiScientifico.scriviRiga(valore, 5);
            System.out.println();

            // Usa concertiScientificoRiga per stampare
            // in notazione scientifica.
            ConvertiScientifico.scriviScientificoRiga(valore, 5);
            System.out.println();

            System.out.println("Vuoi collaudare ancora? (s/n)");
            risposta = tastiera.next().charAt(0);
            System.out.println();

        } while ((risposta == 's') || (risposta == 'S'));

        System.out.println("Fine del collaudo.");
    }
}
