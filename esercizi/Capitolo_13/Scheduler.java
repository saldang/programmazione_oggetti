import java.util.*;

public class Scheduler {
    public static void main(String[] args) {
        System.out.println("Puoi schedulare un appuntamento alle 13, 14, 15, 16, 17, o 18.");
        
        Scanner tastiera = new Scanner(System.in);
        
        String appuntamenti[] = new String[19];
        int appuntamentiFissati = 0;
        
        while(appuntamentiFissati < 6){
            
            System.out.println("Qual e' il tuo nome? ");
            String nome = tastiera.next();
            
            boolean fissato = false;
            while(!fissato){
                try {
                    System.out.println("A che ora vorresti l'appuntamento?");
                    int ora = tastiera.nextInt();
                    
                    if(ora < 13 || ora > 18)
                        throw new OraNonContemplataException("ora specificata non nell'intervallo");
                    
                    if(appuntamenti[ora] != null)
                        throw new OraOccupataException("ora non disponibile poiche' gia' occupata");
                    
                    appuntamenti[ora] = nome;
                    fissato = true;
                    appuntamentiFissati++;
                    
                } catch (OraNonContemplataException e){
                    System.out.println("Non e' un'ora corretta");
                } catch (OraOccupataException e){
                    System.out.println("L'orario specificato e' gia' allocato per un altro appuntamento");
                } catch (Exception e){
                    System.out.println("Fortato otrario non corretto, devi usante un intero");
                    // Use up the rest of the line
                    tastiera.nextLine();
                }
            }
        }
        System.out.println("Fissati tutti gli appuntamenti");
        for(int i=13; i<=18; i++){
            System.out.println("Alle " + i +" e' fissato l'appuntamento di " + appuntamenti[i]);
        }
    }
}

