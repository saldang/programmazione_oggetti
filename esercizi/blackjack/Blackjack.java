package blackjack;

import java.util.Scanner;

public class Blackjack {

    public int lanciaDado(int punteggio) {
        int dado = (int) (Math.random() * 13) + 1;
        System.out.println(dado);
        return calcolaPunteggio(punteggio, dado);
    }

    public int calcolaPunteggio(int punteggio, int dado) {
        switch (dado) {
            case 2, 3, 4, 5, 6, 7, 8, 9, 10:
                punteggio += dado;
                break;
            case 1:
                punteggio += 11;
                break;
            case 11, 12, 13:
                punteggio += 10;
                break;
            default:
                System.out.println("default");
                break;
        }
        return punteggio;
    }

    public int haiVinto(int conto, int puntata) {
        return conto += puntata;
    }

    public int haiPerso(int conto, int puntata) {
        return conto -= puntata;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Blackjack bj = new Blackjack();
        Banco b = new Banco();
        boolean termina = false;
        while (!termina) {
            System.out.println("(q) per uscire (n) nuova partita");
            String response = input.next();
            if (response.equalsIgnoreCase("q")) {
                termina = true;
            } else if (response.equalsIgnoreCase("n")) {
                System.out.println("Inserisci il tuo nome:");
                String nome = input.next();
                System.out.println("Inserisci il tuo conto:");
                int conto = input.nextInt();
                Giocatore g1 = new Giocatore(nome, conto);
                boolean puntataok = false;
                while (!puntataok) {
                    System.out.println("Quanto vuoi puntare?");
                    int puntata = input.nextInt();
                    puntataok = g1.punta(puntata);
                }
                boolean passa = false;
                boolean perde = false;
                while (!passa || !perde) {
                    for (int i = 0; i < 2; i++) {
                        g1.setPunteggio(bj.lanciaDado(g1.getPunteggio()));
                    }

                    if (g1.getPunteggio() > 21) {
                        System.out.println("Hai sballato!");
                        g1.perdita();
                        perde = true;
                        if (g1.getConto() <= 0) {
                            termina = true;
                        }
                    }
                    // else {
                    // System.out.println("Il tuo punteggio e':"+g1.getPunteggio());
                    // System.out.println("Voui passare?(s/n)");
                    // if (input.nextInt().equalsIgnoreCase("s")){
                    // passa = true;
                    // }
                    // }

                }
            }

        }
    }
}
