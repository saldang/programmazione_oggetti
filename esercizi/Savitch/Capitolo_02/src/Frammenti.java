import java.util.Scanner;
public class Frammenti {
    
    public static void main(String[] args) {
        
        // Esercizio 4
        int  u = 2, v = 3, w = 5, x = 7, y = 11;
        
        System.out.println("u + v * w + x e' " + (u + v * w + x));
        System.out.println("u + y % v * w + x e' " + (u + y % v * w + x));
        System.out.println("u++ / v + u++ * w e' " + (u++ / v + u++ * w));
        
        // Esercizio 6
        x = 10;
        System.out.println("Test 1" + x * 3 * 2.0);
        System.out.println("Test 2" + x * 3 + 2.0);
        
        // Esercizio 7
        String frase = "  Ciao, mio caro!";
        
        frase = frase.trim();
        int spazio = frase.indexOf(" ");
        String parola = frase.substring(0, spazio);
        
        System.out.println("La prima parola e': " + parola);
        
        // Esercizio 8
        String resto = frase.substring(spazio).trim();
        spazio = resto.indexOf(" ");
        String secondaParola = resto.substring(0, spazio);
        
        System.out.println("La seconda parola e': " + secondaParola);
        
        // Esercizio 9
        System.out.println("\"\tTest\\\\\rIt\'");
        System.out.println("\"\tTest\\\\\nIt\'");
        
        
        // Esercizio 10
        System.out.println("uno\ndue\ntre");
        
        // Esercizio 11
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci una stringa.");
        int n = tastiera.nextInt();
        String s = tastiera.next();
        System.out.println("n e' " + n);
        System.out.println("s e' " + s);
        
        // Esercizio 12
        tastiera = new Scanner(System.in);
        tastiera.useDelimiter("i");
        System.out.println("Scrivi una stringa.");
        String a = tastiera.next();
        String b = tastiera.next();
        System.out.println("a e' " + a);
        System.out.println("b e' " + b);
        
        // Esercizio 13
        tastiera = new Scanner(System.in);
        tastiera.useDelimiter("i");
        System.out.println("Scrivi una stringa.");
        a = tastiera.next();
        b = tastiera.nextLine();
        System.out.println("a e' " + a);
        System.out.println("b e' " + b);
    }
    
    
    // Esercizio 14
    
    // Basket
    public static final int QUARTERS = 4;
    public static final int POINTS_PER_REGULAR_SHOT = 2;
    public static final int FOULS_PER_GAME = 5;
    
    // Calcio
    public static final int PLAYERS_PER_SIDE = 11;
    public static final int MINUTES_PER_HALF = 45;
    public static final int BREAK_TIME = 15;
    
    // Tennis
    public static final int SET = 3;
    public static final int GAMES = 6;

    	// Pallavolo
    public static final int PLAYERS = 21;
    public static final int NET_HEIGHT_MEN = 243;
    public static final int NET_HEIGHT_WOMEN = 224;    
       
    // Bowling
    public static final int NUMBER_OF_PINS = 10;
    public static final int FRAMES = 10;
    public static final int PERFECT_GAME = 300;
}

