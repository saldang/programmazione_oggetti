import java.util.Scanner;
public class ControlloData {

 public static void main(String[] args) {
        System.out.println("Inserisci la data da controllare");

        Scanner tastiera = new Scanner(System.in);
        String data = tastiera.next();

        int carattereSeparatore = data.indexOf("/");
        String meseStringa =  data.substring(0, carattereSeparatore);

        int mese = Integer.parseInt(meseStringa);

        String dataRimanente = data.substring(carattereSeparatore+1);
        carattereSeparatore = dataRimanente.indexOf("/");

        String giornoStringa = dataRimanente.substring(0, carattereSeparatore);
        String annoStringa = dataRimanente.substring(carattereSeparatore+1);

        int giorno = Integer.parseInt(giornoStringa);
        int anno = Integer.parseInt(annoStringa);

        System.out.println("La data e' " + mese + ":" + giorno + ":"+ anno );

        boolean dataValida = true;
        String messaggio = "";

        if(giorno<1) {
            dataValida = false;
            messaggio = "Il numero del giorno ha un valore minore di 1.  ";
        }

        switch(mese){
            case 2:  // Fabbraio
                boolean annoBisestile  = (anno%400 == 0) || ((anno%4 == 0) && (anno%100 != 0));
                if(annoBisestile && giorno>29){
                    dataValida = false;
                    messaggio = "Il numero del giorno ha un valore maggiore di 29 Febbraio in un anno bisestile in a leap year.  ";
                } else if(!annoBisestile && giorno>28){
                    dataValida = false;
                    messaggio = "Il numero del giorno ha un valore maggiore di 28 Febbraio in un anno non bisestile.  ";
                }
                break;
            case 4:  // Aprile
            case 6:  // Giugno
            case 9:  // Settembre
            case 11:  // Novembre
                if(giorno>30) {
                    dataValida = false;
                    messaggio = "Il numero del giorno ha un valore maggiore di 30 in un mese di 30 giorni.  ";
                }
                break;
            case 1:  // Gennaio
            case 3:  // Marzo
            case 5:  // Maggio
            case 7:  // Luglio
            case 8:  // Augosto
            case 10:  // Ottobre
            case 12:  // Dicembre
                if(giorno>31) {
                    dataValida = false;
                    messaggio = "Il numero del giorno ha un valore maggiore di 31 in un mese di 31 giorni.  ";
                }
                break;
            default:
                dataValida = false;
                messaggio = messaggio + "Il numero del mese non e' compreso tra 1 e 12.  ";

        }

        System.out.println("La tua data era " + data);
        if(dataValida){
            System.out.println("E' una data valida.");
        } else {
            System.out.println("Non e' una data valida.");
            System.out.println("Ecco il motivo per cui non e' valida: " + messaggio);
        }
    }
}



