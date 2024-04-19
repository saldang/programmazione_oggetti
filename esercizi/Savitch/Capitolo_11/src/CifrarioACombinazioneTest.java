import java.util.Scanner;

public class CifrarioACombinazioneTest {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Qual e' la chiave (lo shift da adottare) per la codifica?");
        int shift = tastiera.nextInt();
        CifrarioACombinazione coder = new CifrarioACombinazione(shift);

        boolean fatto = false;

        while(!fatto){
            String rest = tastiera.nextLine();

            System.out.println("Inserisci un messaggio da cifrare o da decifrare.");
            String messaggio = tastiera.nextLine();

            System.out.println("Cifrare (C) o Decifrare (D)");
            String risposta = tastiera.next();
            risposta = risposta.toLowerCase();
            if(risposta.equals("c")){
                System.out.println("Cifrato in: " + coder.codifica(messaggio));
            } else if(risposta.equals("d")){
                System.out.println("Decifrato in: " + coder.decodifica(messaggio));
            }

            System.out.println("Vuoi continuare? (S)");
            risposta = tastiera.next();
            risposta = risposta.toLowerCase();
            if(!risposta.equals("s"))
                fatto = true;
        }
    }
}
