---
layout: post
title: "Traccia 24 Febbraio 2025"
date: 2025-02-24
---

## Implementazione Gioco di Carte Collezionabili Pokémon (GCC Pokémon)

### Obiettivo

Implementare un sistema per un Gioco di Carte Collezionabili Pokémon, che consenta di gestire Allenatori, creare mazzi di carte, organizzare partite e simulare battaglie tra due giocatori. Il sistema deve utilizzare i concetti di ereditarietà, polimorfismo, interfacce e gestione dei file.

---

### **Requisiti**

1. **Ereditarietà e Polimorfismo**

   - Creare una classe astratta `Carta` con i seguenti attributi:
     - `nome` (String)
     - `descrizione` (String, effetto della carta)
   - Creare le seguenti sottoclassi di `Carta`:
     - `CartaPokemon`: rappresenta un Pokémon con le seguenti proprietà:
       - `puntiVita` (int)
       - `puntiVitaIniziali` (int)
       - `attacco` (int)
       - `energiaNecessaria` (int, energia richiesta per attaccare)
       - `energiaAssegnata` (int, inizialmente 0)
       - Metodi:
         - getter e setter`
         - `assegnaEnergia(CartaEnergia energia)`: aggiunge energia al Pokémon se compatibile.
     - `CartaEnergia`: rappresenta una carta energia con il seguente attributo:
       - `tipoEnergia` (String, es. Fuoco, Acqua, Elettro)

2. **Gestione degli Allenatori e dei Mazzi**

   - Creare una classe `Allenatore` con i seguenti attributi:

     - `nome` (String)
     - `mazzo` (Mazzo)
     - `mano` (ArrayList<Carta>)
     - `pokemonAttivo` (CartaPokemon)

   - Metodi:

     - `pescaCarte(int numero)`: permette di pescare un numero specifico di carte dal mazzo, se disponibili.
     - `giocaCarta(Carta carta)`: gioca una carta dalla mano.
     - `scartaCarta(Carta carta)`: scarta una carta.
     - `prelevaCartaPremio()`: pesca una carta premio dopo aver sconfitto un Pokémon avversario.
     - `haCartePremio()`: verifica se l'allenatore ha ancora carte premio.

- Creare una classe `Mazzo` con i seguenti attributi:
  - `carte` (ArrayList<Carta>)
- Metodi:
  - `caricaDaFile(String percorsoFile)`: legge le carte da un file CSV e le aggiunge al mazzo.
  - `mescola()`: mescola il mazzo utilizzando `Collections.shuffle()`.
  - `pesca()`: pesca e rimuove la prima carta del mazzo.

1. **Lettura del Mazzo da File CSV**

   - Implementare un metodo per leggere il mazzo da un file CSV e caricare le carte.
   - Il file CSV contiene i dati delle carte e viene caricato all’inizio del gioco.

   - **Formato del file CSV:**

     ```csv
     tipo,nome,descrizione,puntiVita,attacco,energiaNecessaria,tipoEnergia
     Pokemon,Pikachu,Tuonoshock,60,20,1,
     Pokemon,Charizard,Lanciafiamme,120,50,3,
     Energia,EnergiaFuoco,Fuoco,,,,Fuoco
     Energia,EnergiaAcqua,Acqua,,,,Acqua
     ```

2. **Gestione delle Partite**

   - Creare una classe `Partita` con i seguenti attributi:
     - `allenatore1` (Allenatore)
     - `allenatore2` (Allenatore)
     - `giocatoreAttivo` (Allenatore)
     - `giocatoreInattivo` (Allenatore)
   - Metodi:
     - `iniziaPartita()`: inizia la partita, caricando i mazzi e selezionando i Pokémon attivi.
     - `giocaTurni()`: gestisce i turni alternati dei giocatori.
     - `attacca(CartaPokemon attaccante, CartaPokemon difensore)`: simula un attacco tra due Pokémon.
     - `verificaCondizioniVittoria()`: verifica le condizioni di vittoria.
     - `passaTurno()`: passa il turno al giocatore successivo.

   1. **Inizio Partita:**

      - Carica i mazzi dei due Allenatori da file CSV.
      - Ogni Allenatore pesca 7 carte iniziali.
      - Ogni Allenatore seleziona un Pokémon attivo.

   2. **Turni Alternati:**

      - I giocatori si alternano nei turni.
      - Ogni turno consiste nelle seguenti azioni:
        - Pescare una carta.
        - Giocare carte (Pokémon o Energia) dalla mano.
        - Attaccare con il Pokémon attivo (se possibile).

   3. **Attacco:**

      - Il Pokémon attaccante infligge danni al Pokémon difensore.
      - Se il Pokémon difensore viene sconfitto, il giocatore attaccante prende una carta premio.

   4. **Condizioni di Vittoria:**

   - Vince chi prende tutte le carte premio dell'avversario.
   - Vince chi mette K.O. tutti i pokemon attivi dell'avversario.
   - Vince chi fa terminare il mazzo all'avversario.

---

### Implementazione Partita

```java

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

        return false;
    }

    private void passaTurno() {
        Allenatore temp = giocatoreAttivo;
        giocatoreAttivo = giocatoreInattivo;
        giocatoreInattivo = temp;
    }
}
```

### **Esempio di Output Atteso**

```plaintext
Inizia la partita!
Allenatore 1, seleziona il Pokémon attivo:
Mano di Ash:
1. Pikachu
2. Charmander
3. EnergiaFuoco
4. EnergiaElettro
5. Bulbasaur
6. Squirtle
7. EnergiaAcqua
1
Allenatore 2, seleziona il Pokémon attivo:
Mano di Gary:
1. Vaporeon
2. Ivysaur
3. EnergiaAcqua
4. EnergiaErba
5. Raichu
6. Charizard
7. EnergiaFuoco
1

Turno di Ash:
Mano di Ash:
1. Pikachu
2. Charmander
3. EnergiaFuoco
4. EnergiaElettro
5. Bulbasaur
6. Squirtle
7. EnergiaAcqua
Mano di Ash:
Pokémon attivo: Pikachu
Pokémon avversario: Vaporeon
1. Gioca carta
2. Attacca
3. Passa turno
2
Pikachu attacca Vaporeon!
Vaporeon ha 50 PV.
....
...
Mano di Gary:
Pokémon attivo: Vaporeon
Pokémon avversario: Pikachu
1. Gioca carta
2. Attacca
3. Passa turno
2
Vaporeon attacca Pikachu!
Pikachu ha 0 PV.
Pikachu è stato sconfitto!

...

Turno di Ash:
Mano di Ash:
1. EnergiaFuoco
2. EnergiaElettro
3. Bulbasaur
4. Squirtle
5. EnergiaAcqua
6. EnergiaErba
7. Vaporeon
8. Jolteon
Non hai un Pokémon attivo. Scegline uno.
3
Mano di Ash:
Pokémon attivo: Bulbasaur
Pokémon avversario: Ivysaur
1. Gioca carta
2. Attacca
3. Passa turno
2
Bulbasaur attacca Ivysaur!
Ivysaur ha 30 PV.
...
..
..

Mano di Gary:
Pokémon attivo: Ivysaur
Pokémon avversario: Bulbasaur
1. Gioca carta
2. Attacca
3. Passa turno
2
Ivysaur attacca Bulbasaur!
Bulbasaur ha 0 PV.
Bulbasaur è stato sconfitto!
0
Gary vince per esaurimento mazzo avversario!
```

**mazzo1.csv**

```csv
tipo,nome,descrizione,puntiVita,attacco,energiaNecessaria,tipoEnergia
Pokemon,Pikachu,Tuonoshock,60,20,1,
Pokemon,Charmander,Braciere,50,15,1,
Energia,EnergiaFuoco,Fuoco,,,,Fuoco
Energia,EnergiaElettro,Elettro,,,,Elettro
Pokemon,Bulbasaur,Frustata,60,10,1,
Pokemon,Squirtle,Bolla,50,10,1,
Energia,EnergiaAcqua,Acqua,,,,Acqua
Energia,EnergiaErba,Erba,,,,Erba
Pokemon,Jolteon,Tuono,70,25,2,
Pokemon,Flareon,Lanciafiamme,70,30,2,
```

**mazzo2.csv**

```csv
tipo,nome,descrizione,puntiVita,attacco,energiaNecessaria,tipoEnergia
Pokemon,Vaporeon,Idropompa,70,25,2,
Pokemon,Ivysaur,Foglielama,70,20,2,
Energia,EnergiaAcqua,Acqua,,,,Acqua
Energia,EnergiaErba,Erba,,,,Erba
Pokemon,Raichu,Tuonobomba,90,30,3,
Pokemon,Charizard,Vampata,120,50,3,
Energia,EnergiaFuoco,Fuoco,,,,Fuoco
Energia,EnergiaElettro,Elettro,,,,Elettro
Pokemon,Blastoise,Idrocannone,100,40,3,
Pokemon,Venusaur,Solarraggio,100,45,3,
```
