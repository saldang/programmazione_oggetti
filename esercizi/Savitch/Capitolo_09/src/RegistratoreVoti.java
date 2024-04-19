import java.util.Scanner;

public class RegistratoreVoti {
    private static String nomeCandidatoPresidente1;
    private static String nomeCandidatoPresidente2;
    private static int votiPerCandidatoPresidente1;
    private static int votiPerCandidatoPresidente2;

    private static String nomeCandidatoVicePresidente1;
    private static String nomeCandidatoVicePresidente2;
    private static int votiPerCandidatoVicePresidente1;
    private static int votiPerCandidatoVicePresidente2;

    public static void setCandidatiPresidente(String nome1, String nome2){
        nomeCandidatoPresidente1 = nome1;
        nomeCandidatoPresidente2 = nome2;
    }

    public static String getVotiPresidenti(){
        return nomeCandidatoPresidente1 + " ha " + votiPerCandidatoPresidente1 + " voti; "
                + nomeCandidatoPresidente2 + " ha " + votiPerCandidatoPresidente2 + " voti; ";
    }

    public static void setCandidatiVicePresidente(String nome1, String nome2){
        nomeCandidatoVicePresidente1 = nome1;
        nomeCandidatoVicePresidente2 = nome2;
    }

    public static String getVotiVicePresidenti(){
        return nomeCandidatoVicePresidente1 + " ha " + votiPerCandidatoVicePresidente1 + " voti; "
                + nomeCandidatoVicePresidente2 + " ha " + votiPerCandidatoVicePresidente2 + " voti; ";
    }

    public static void resettaVoti(){
        votiPerCandidatoVicePresidente1 = 0;
        votiPerCandidatoVicePresidente2 = 0;
        votiPerCandidatoPresidente1 = 0;
        votiPerCandidatoPresidente2 = 0;
    }
    
    private int mioVotoPerPresidente;
    private int mioVotoPerVicePresidente;

    /** crea una nuova istanza di RegistratoreVoti */
    public RegistratoreVoti() {
    	mioVotoPerPresidente = 0;
    	mioVotoPerVicePresidente = 0;
        
    }

    private void registraVoti(){
        switch(mioVotoPerPresidente) {
            case 0:
                // non fare nulla
                break;
            case 1:
                votiPerCandidatoPresidente1++;
                break;
            case 2:
                votiPerCandidatoPresidente2++;
                break;
        }

        switch(mioVotoPerVicePresidente) {
            case 0:
                // non fare nulla
                break;
            case 1:
                votiPerCandidatoVicePresidente1++;
                break;
            case 2:
                votiPerCandidatoVicePresidente2++;
                break;
        }
    }

    private int getVoto(String nome1, String nome2){
        Scanner tastiera = new Scanner(System.in);
        int risposta = 0;
        boolean rispostaValida = false;
        while(!rispostaValida){
            System.out.println("Scegli un candidato: ");
            System.out.println("      0 - nessuno ");
            System.out.println("      1 - " + nome1);
            System.out.println("      2 - " + nome2);
            risposta = tastiera.nextInt();
            rispostaValida = risposta>=0 && risposta <=2;
        }
        return risposta;
    }

    private void getVoti(){
        System.out.println("STAI VOTANDO PER IL PRESIDENTE ");
        mioVotoPerPresidente = getVoto(nomeCandidatoPresidente1, nomeCandidatoPresidente2);

        System.out.println("STAI VOTANDO PER IL VICE PRESIDENTE ");
        mioVotoPerVicePresidente = getVoto(nomeCandidatoVicePresidente1, nomeCandidatoVicePresidente2);
    }

    private boolean confermaVoti(){
        System.out.print("Il tuo voto per il presidente e' ");
        switch(mioVotoPerPresidente) {
            case 0:
                System.out.println("nessuno");
                break;
            case 1:
                System.out.println(nomeCandidatoPresidente1);
                break;
            case 2:
                System.out.println(nomeCandidatoPresidente2);
                break;
        }

        System.out.print("YIl tuo voto per il vice presidente e'  ");
        switch(mioVotoPerVicePresidente) {
            case 0:
                System.out.println("nessuno");
                break;
            case 1:
                System.out.println(nomeCandidatoVicePresidente1);
                break;
            case 2:
                System.out.println(nomeCandidatoVicePresidente2);
                break;
        }
        System.out.println("Digita si se confermi i tuoi voti");
        Scanner tastiera = new Scanner(System.in);
        return tastiera.next().equals("si");
    }

    public void restituisciEConfermaVoti(){
        boolean votazioneTerminata = false;
        while(!votazioneTerminata){
            getVoti();
            votazioneTerminata = confermaVoti();
        }
        registraVoti();
    }


    public static void main(String[] args) {
        setCandidatiPresidente("Annie", "Bob");
        setCandidatiVicePresidente("John", "Susan");
        resettaVoti();

        boolean ancoraVoti = true;

        while(ancoraVoti){
            RegistratoreVoti aVoter = new RegistratoreVoti();
            aVoter.restituisciEConfermaVoti();
            System.out.println("Digita si se c'e' ancora un votante");
            Scanner tastiera = new Scanner(System.in);
            ancoraVoti = tastiera.next().equals("si");

        }

        System.out.println(getVotiPresidenti());
        System.out.println(getVotiVicePresidenti());
    }
}
