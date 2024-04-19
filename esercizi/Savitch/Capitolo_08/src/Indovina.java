import java.util.Scanner;

public class Indovina {
    private String parolaSegreta;
    private String parolaLettereScoperte;
    private String lettereRimanenti;
    private int numeroTentativiFatti;
    private int numeroTentativiNonCorretti;

    public void inizializza(String parola) {
        parolaSegreta = parola.toLowerCase().trim();
        lettereRimanenti = parolaSegreta;
        parolaLettereScoperte = creaParolaLettereScoperte(parolaSegreta);
        numeroTentativiFatti = 0;
        numeroTentativiNonCorretti = 0;
    }

    public String creaParolaLettereScoperte(String parola) {
        parola = parola.toLowerCase();
        parola = parola.replace('a', '?');
        parola = parola.replace('b', '?');
        parola = parola.replace('c', '?');
        parola = parola.replace('d', '?');
        parola = parola.replace('e', '?');
        parola = parola.replace('f', '?');
        parola = parola.replace('g', '?');
        parola = parola.replace('h', '?');
        parola = parola.replace('i', '?');
        parola = parola.replace('j', '?');
        parola = parola.replace('k', '?');
        parola = parola.replace('l', '?');
        parola = parola.replace('m', '?');
        parola = parola.replace('n', '?');
        parola = parola.replace('o', '?');
        parola = parola.replace('p', '?');
        parola = parola.replace('q', '?');
        parola = parola.replace('r', '?');
        parola = parola.replace('s', '?');
        parola = parola.replace('t', '?');
        parola = parola.replace('u', '?');
        parola = parola.replace('v', '?');
        parola = parola.replace('w', '?');
        parola = parola.replace('x', '?');
        parola = parola.replace('y', '?');
        parola = parola.replace('z', '?');

        return parola;
    }

    public void indovina(char c) {
        if(Character.isLetter(c)){
            String guess = "" + c;
            guess = guess.toLowerCase();
            int letterPosition = lettereRimanenti.indexOf(guess);
            boolean goodGuess = letterPosition > -1;
            while(letterPosition > -1){
                String before = lettereRimanenti.substring(0, letterPosition);
                String after = lettereRimanenti.substring(letterPosition+1);
                lettereRimanenti = before + "#" + after;

                before = parolaLettereScoperte.substring(0, letterPosition);
                after = parolaLettereScoperte.substring(letterPosition+1);
                parolaLettereScoperte = before + guess + after;

                letterPosition = lettereRimanenti.indexOf(guess);
            }

            numeroTentativiFatti++;
            if(!goodGuess)
                numeroTentativiNonCorretti++;
        } else
            System.out.println("Sorry, your guess must be an alphabet character from a to z");
    }

    public String getParolaScoperta(){
        return parolaLettereScoperte;
    }

    public String getParolaDaIndovinare(){
        return parolaSegreta;
    }


    public int getNumeroTentativi(){
        return numeroTentativiFatti;
    }

    public boolean isIndovinata(){
        return parolaSegreta.equals(parolaLettereScoperte);
    }


    public void gioca(){
        if(!isIndovinata()){
            while(!isIndovinata()){
                System.out.println("\nLa parola scoperta e' <" + parolaLettereScoperte +">");
                System.out.println("Indovina una lettera");
                Scanner tastiera = new Scanner(System.in);
                String guess = tastiera.next();
                if(guess.length()!= 1)
                    System.out.println("Mi spiace, devi inserire una sola lettera.");
                else {
                    indovina(new Character(guess.charAt(0)));
                }
                System.out.println("Tentativi totali " + numeroTentativiFatti + " di cui " + numeroTentativiNonCorretti + " errati");
            }
            System.out.println("Congratulazioni, hai trovato la parola segreta: " + parolaSegreta);
        }

    }

    public static void main(String[] args) {
        Indovina game = new Indovina();
        game.inizializza("Gioia");
        System.out.println("Giochiamo!");
        game.gioca();

        game.inizializza("Sono di ritorno.");
        System.out.println("\nGiochiamo una seconda partita!");
        game.gioca();
    }
}






