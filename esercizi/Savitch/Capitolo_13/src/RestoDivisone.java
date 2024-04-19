import java.util.*;

public class RestoDivisone {
    
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        
        boolean fatto = false;
        while(!fatto){
            System.out.println("Inserisci 2 valori interi");
            try{
                int primo = tastiera.nextInt();
                int secondo = tastiera.nextInt();
                
                System.out.println("Il resto della divisione di " + primo + " per " + secondo + " e' " + (primo % secondo));
                
            } catch (ArithmeticException e){
                System.out.println("Non e' possibile calcolare la divisione per 0");
            } catch (Exception e) {
                System.out.println("Occorre inserire 2 valori interi");
                tastiera.nextLine();
            }
            
            System.out.println("Vuoi continuare? (s)");
            String response = tastiera.next().toLowerCase();
            if(!response.equals("s"))
                fatto = true;            
        }
    }
}


