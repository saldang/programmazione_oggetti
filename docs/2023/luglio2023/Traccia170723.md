# 170723

## Traccia 17 Luglio 2023

### Sistema per la gestione di una dispensa condivisa con ereditarieta', polimorfismo e lettura/scrittura da file

**Descrizione**: Si vuole realizzare un sistema per la gestione di una dispensa condivisa. La dispensa contiene prodotti alimentari e non alimentari. Ogni prodotto ha un codice, un nome, una quantita' e una descrizione. I prodotti alimentari hanno anche una data di scadenza. I prodotti non alimentari hanno anche un materiale di costruzione. Il sistema deve permettere di visualizzare tutti i prodotti presenti nella dispensa, aggiungere un prodotto, cercare un prodotto per codice e rimuovere un prodotto. Il sistema deve anche permettere di salvare e caricare i prodotti da file.

Requisiti:
1. Creare una classe astratta chiamata "Prodotto" con i seguenti attributi:
   - Codice (stringa): il codice univoco del prodotto.
   - Nome (stringa): il nome del prodotto.
   - Quantita' (int): la quantita' del prodotto.
   - Descrizione (stringa): una breve descrizione del prodotto.
  
2. Creare una classe "ProdottoAlimentare" che eredita da "Prodotto" e ha un attributo in piu':
   - Data di scadenza (stringa): la data di scadenza del prodotto.

3. Creare una classe "ProdottoNonAlimentare" che eredita da "Prodotto" e ha un attributo in piu':
   - Materiale (stringa): il materiale di costruzione del prodotto.

4. Creare una classe "Dispensa" che ha i seguenti attributi:
   - Prodotti (lista di "Prodotto"): la lista dei prodotti presenti nella dispensa.
   - Utenti (lista di "Utente"): la lista degli utenti che possono accedere alla dispensa.
  
5. Creare una classe "Utente" con i seguenti attributi:
    - Nome (stringa): il nome dell'utente.
    - Cognome (stringa): il cognome dell'utente.
    - Username (stringa): l'username dell'utente.

6. Creare una classe "GestoreDispensa" con i seguenti attributi:
    - Dispensa (Dispensa): la dispensa che deve gestire.
    - Utente (Utente): l'utente che sta usando il gestore della dispensa.
    - Metodo "aggiungiProdotto" che prende in input un prodotto e lo aggiunge alla dispensa.
    - Metodo "rimuoviProdotto" che prende in input un codice e rimuove il prodotto con quel codice dalla dispensa.
    - Metodo "cercaProdotto" che prende in input un codice e restituisce il prodotto con quel codice.
    - Metodo "visualizzaProdotti" che stampa a video tutti i prodotti presenti nella dispensa.
    - Metodo "salvaProdotti" che che prende in input il nome del file e salva tutti i prodotti presenti nella dispensa su file.
    - Metodo "caricaProdotti" che prende in input il nome del file e carica tutti i prodotti presenti nella dispensa da file.
    - Metodo "aggiungiUtente" che prende in input un utente e lo aggiunge alla dispensa.
    - Metodo "rimuoviUtente" che prende in input un username e rimuove l'utente con quell'username dalla dispensa.
    - Metodo "verificaUtente" che prende in input un username e restituisce True se l'utente con quell'username e' presente nella dispensa, False altrimenti.

7. Completare il `Main.java` con le funzionalita richieste.

#### IMPLEMENTARE ALMENO 6 FUNZIONALITA' PER SUPERARE L'ESAME

Note aggiuntive:

- È possibile utilizzare le classi del package `java.io` per leggere i dati da file.
- Si richiede di gestire eventuali eccezioni durante la lettura da file.
- È consentito l'utilizzo di liste o array per la gestione dell'elenco dei prodotti.
- Si suggerisce di utilizzare il costrutto "try-catch" per catturare le eccezioni e gestirle in modo appropriato.
- file di input: 
  ```
    codice,nome,quantita,descrizione, datascadenza, materiale
    001,patate,10,patate rosse, 2023-12-31, 
    002,carote,10,carote arancioni, 2023-12-31, 
    003,mele,10,mele verdi, 2023-12-31,
    004,banane,10,banane gialle, 2023-12-31,
    005,scopa,1,scopa per pulire,,legno
    006,spazzolino,1,spazzolino per denti,,plastica
    007,pennello,1,pennello per dipingere,,legno
  ```
- file di output: 
    ```
    codice,nome,quantita,descrizione, datascadenza, materiale
    001,patate,8,patate rosse, 2023-12-31, 
    002,carote,10,carote arancioni, 2023-12-31, 
    003,mele,5,mele verdi, 2023-12-31,
    004,banane,10,banane gialle, 2023-12-31,
    005,scopa,1,scopa per pulire,,legno
    006,spazzolino,1,spazzolino per denti,,plastica
    008,risma carta,1,risma carta A4,,carta
  ```

`main.java` da completare:

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestoreDispensa gestoreDispensa = new GestoreDispensa(new Dispensa(), new Utente("Mario", "Rossi", "mario.rossi"));
        gestoreDispensa.aggiungiUtente(new Utente("Luigi", "Verdi", "luigi.verdi"));
        gestoreDispensa.aggiungiUtente(new Utente("Giuseppe", "Bianchi", "giuseppe.bianchi")); 
       
        while(leggiTest()!=null){
            testline = leggiTest();
            String[] test = testline.split(",");
            
            int scelta = test[0];
            
            System.out.println("1. Aggiungi prodotto");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Cerca prodotto");
            System.out.println("4. Visualizza prodotti");
            System.out.println("5. Salva prodotti");
            System.out.println("6. Carica prodotti");
            System.out.println("7. Aggiungi utente");
            System.out.println("8. Rimuovi utente");
            System.out.println("9. Verifica utente");
            System.out.println("10. Esci");
            System.out.print("Scelta: ");

            switch (scelta) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    public static String leggiTest() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line = reader.readLine();
            reader.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
```

Buon lavoro!
