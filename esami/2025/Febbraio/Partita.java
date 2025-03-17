
import java.util.Scanner;

public class Partita {
    private Allenatore allenatore1;
    private Allenatore allenatore2;
    private Allenatore giocatoreAttivo;
    private Allenatore giocatoreInattivo;

    public Partita(Allenatore allenatore1, Allenatore allenatore2) {
        this.allenatore1 = allenatore1;
        this.allenatore2 = allenatore2;
        this.giocatoreAttivo = allenatore1; // Allenatore1 inizia
        this.giocatoreInattivo = allenatore2;
    }

    public void iniziaPartita() {
        System.out.println("Caricamento mazzi...");
        allenatore1.getMazzo().caricaDaFile("mazzo1.csv");
        allenatore2.getMazzo().caricaDaFile("mazzo2.csv");

        System.out.println("Inizia la partita!");
        allenatore1.pescaCarte(7);
        allenatore2.pescaCarte(7);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Allenatore 1, seleziona il Pokémon attivo:");
        allenatore1.stampaMano();
        int scelta1 = scanner.nextInt() - 1; // -1 per l'indice dell'array
        allenatore1.setPokemonAttivo((CartaPokemon) allenatore1.getMano().get(scelta1));
        System.out.println("Allenatore 2, seleziona il Pokémon attivo:");
        allenatore2.stampaMano();
        int scelta2 = scanner.nextInt() - 1;
        allenatore2.setPokemonAttivo((CartaPokemon) allenatore2.getMano().get(scelta2));

        giocaTurni();
    }

    private void giocaTurni() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTurno di " + giocatoreAttivo.getNome() + ":");
            giocatoreAttivo.stampaMano();
            if (giocatoreAttivo.getPokemonAttivo() == null) {
                System.out.println("Non hai un Pokémon attivo. Scegline uno.");
                int scelta = scanner.nextInt() - 1;
                giocatoreAttivo.setPokemonAttivo((CartaPokemon) giocatoreAttivo.getMano().get(scelta));
            }
            System.out.println("Mano di " + giocatoreAttivo.getNome() + ":");
            System.out.println("Pokémon attivo: " + giocatoreAttivo.getPokemonAttivo().getNome());
            System.out.println("Pokémon avversario: " + giocatoreInattivo.getPokemonAttivo().getNome());
            // Opzioni di gioco (semplificato)
            System.out.println("1. Gioca carta");
            System.out.println("2. Attacca");
            System.out.println("3. Passa turno");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Quale carta vuoi giocare?");
                    int cartaScelta = scanner.nextInt() - 1;
                    giocatoreAttivo.giocaCarta(giocatoreAttivo.getMano().get(cartaScelta));
                    break;
                case 2:
                    if (giocatoreAttivo.getPokemonAttivo() != null && giocatoreInattivo.getPokemonAttivo() != null) {
                        attacca(giocatoreAttivo.getPokemonAttivo(), giocatoreInattivo.getPokemonAttivo());
                    } else {
                        System.out.println("Non ci sono Pokémon attivi per attaccare.");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

            if (verificaCondizioniVittoria()) {
                break;
            }

            passaTurno();
        }
    }

    private void attacca(CartaPokemon attaccante, CartaPokemon difensore) {
        difensore.subisciDanni(attaccante.getAttacco());
        System.out.println(attaccante.getNome() + " attacca " + difensore.getNome() + "!");
        System.out.println(difensore.getNome() + " ha " + difensore.getPuntiVita() + " PV.");
        if (difensore.getPuntiVita() <= 0) {
            System.out.println(difensore.getNome() + " è stato sconfitto!");
            giocatoreAttivo.prelevaCartaPremio(difensore);
            giocatoreInattivo.getMano().remove(difensore);
            giocatoreInattivo.pescaCarte(1);
            giocatoreInattivo.setPokemonAttivo(null); // Il pokemon attivo viene messo a null
        }
    }

    private boolean verificaCondizioniVittoria() {

        if (giocatoreInattivo.getMazzo().getCarte().isEmpty()) {
            System.out.println(giocatoreInattivo.getMazzo().getCarte().size());
            System.out.println(giocatoreAttivo.getNome() + " vince per esaurimento mazzo avversario!");
            return true;
        }
        if (giocatoreInattivo.getPokemonAttivo() == null
                && giocatoreInattivo.getMano().stream().noneMatch(CartaPokemon.class::isInstance)) {
            System.out.println(giocatoreAttivo.getNome() + " vince per mancanza di pokemon giocabili dell'avversario!");
            return true;
        }
        if( !giocatoreInattivo.haCartePremio()){
            //NON ci sono carte pokemon nella mano del giocatore inattivo
            System.out.println(giocatoreAttivo.getNome() + " vince per mancanza di carte premio dell'avversario!");
            return true;
        }

        return false;
    }

    private void passaTurno() {
        Allenatore temp = giocatoreAttivo;
        giocatoreAttivo = giocatoreInattivo;
        giocatoreInattivo = temp;
    }
}