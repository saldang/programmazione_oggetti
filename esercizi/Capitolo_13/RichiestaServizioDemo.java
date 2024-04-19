import java.util.Scanner;

public class RichiestaServizioDemo {

   public static void main(String[] args) {
       RichiesteServizio list = new RichiesteServizio();

        Scanner tastiera = new Scanner(System.in);

        boolean fatto = false;
        while(!fatto){
            System.out.println("Aggiungi una richiesta (a), Rimuoviuna richiesta (r), Mostra tutte le richieste (m) o esci (e)");
            String response = tastiera.next().toLowerCase();
            try{
                if(response.equals("a")){
                    System.out.println("Quale e' il nome da aggiungere? ");
                    String name = tastiera.next();
                    list.aggiungiNome(name);

                } else if(response.equals("r")){
                    System.out.println("Quale e' il nome da rimuovere? ");
                    String name = tastiera.next();
                    list.rimuoviNome(name);

                } else if(response.equals("m")){
                    System.out.println("Le richieste attuali sono: ");
                    for(int i=0; i<list.getNumber(); i++){
                        System.out.println("Richiesta " + i + " e' " + list.getName(i));
                    }
                    System.out.println();

                } else if(response.equals("e")){
                    fatto = true;
                } else {
                    System.out.println("Comando sconosciuto: " + response);
                }

            } catch (RichiestaServizoException e) {
            	System.out.println(e.getMessage());
            }
        }
        System.out.println("Ok.");
    }
}



