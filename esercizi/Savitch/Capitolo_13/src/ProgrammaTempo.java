import java.util.*;

public class ProgrammaTempo {
    
    public static void main(String[] args) {
       Scanner tatsiera = new Scanner(System.in);
        OraDelGiorno miaOra = new OraDelGiorno();
        
        boolean done = false;
        while(!done){
            System.out.println("Inserisci un orario nel formato hh:mm seguito da am/pm senza spazi");
            String potentialTime = tatsiera.next();
            try{
                miaOra.setOra(potentialTime);
                done = true;
            } catch (FormatoInvalidoException e){
                System.out.println("Rilevato un formato non valido: " +e.getMessage() );
            } catch (OraNonValidaException e){
                System.out.println("Rilevato un formato non valido dell'ora: " +e.getMessage() );
            } catch (MinutiNonValidiException e){
                System.out.println("Rilevato un formato non valido dei minut: " +e.getMessage() );
            }
            
        }
        System.out.println("Ora " + miaOra);
        
    }
}



