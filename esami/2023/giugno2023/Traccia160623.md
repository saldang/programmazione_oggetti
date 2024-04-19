
# 160623

## Traccia 16 Giugno 2023

### Sistema di gestione di un negozio di abbigliamento con polimorfismo, ereditarietà e lettura da file

**Descrizione**
In questo esame di programmazione in Java, verrà richiesto di sviluppare un sistema di gestione di un negozio di abbigliamento che faccia uso del concetto di polimorfismo, ereditarietà e lettura da file. Il sistema dovrà consentire l'inserimento, la visualizzazione e la ricerca di prodotti, salvando i dati su un file di testo.

Requisiti:
1. Creare una classe astratta chiamata "Prodotto" con i seguenti attributi:
   - Codice (stringa): il codice univoco del prodotto.
   - Descrizione (stringa): una breve descrizione del prodotto.
   - Prezzo (double): il prezzo del prodotto.

2. Creare le seguenti classi derivate da "Prodotto":
   - Abbigliamento: rappresenta un capo di abbigliamento, con l'aggiunta degli attributi "taglia" e "materiale".
   - Accessorio: rappresenta un accessorio, con l'aggiunta dell'attributo "colore".

3. Creare una classe "Negozio" che contenga un elenco di oggetti "Prodotto". La classe dovrà avere i seguenti metodi:
   - Metodo "caricaDaFile" che legge i dati da un file di testo e popola l'elenco di prodotti.
   - Metodo "aggiungiProdotto" che consente di inserire un nuovo prodotto nell'elenco.
   - Metodo "visualizzaProdotti" che visualizza le informazioni di tutti i prodotti presenti.
   - Metodo "cercaProdottoPerCodice" che cerca un prodotto per codice e restituisce l'oggetto corrispondente.

4. Implementare i seguenti metodi nelle classi "Abbigliamento" e "Accessorio":
   - Costruttore che inizializza gli attributi.
   - Metodo "toString" che restituisce una stringa rappresentante le informazioni del prodotto.

5. Creare un file di testo chiamato "prodotti.txt" contenente i dati dei prodotti da caricare nel negozio, uno per riga nel seguente formato:
   - Per un capo di abbigliamento: "abbigliamento,codice,descrizione,prezzo,taglia,materiale".
   - Per un accessorio: "accessorio,codice,descrizione,prezzo,colore".

6. Nella classe principale chiamata "Main" (che contiene il metodo "main"), creare un oggetto di tipo "Negozio" e utilizzare i metodi implementati per gestire il sistema. In particolare, il programma dovrà:
   - Caricare i dati dal file "prodotti.txt" utilizzando il metodo "caricaDaFile".
   - Visualizzare i prodotti presenti utilizzando il metodo "visualizzaProdotti".
   - Aggiungere nuovi prodotti utilizzando il metodo "aggiungiProdotto".
   - Cercare un prodotto per codice utilizzando il metodo "cercaProdottoPerCodice" e visualizzarne le informazioni.

Note aggiuntive:

- È possibile utilizzare le classi del package `java.io` per leggere i dati da file.
- Si richiede di gestire eventuali eccezioni durante la lettura da file.
- È consentito l'utilizzo di liste o array per la gestione dell'elenco dei prodotti.
- Si suggerisce di utilizzare il costrutto "try-catch" per catturare le eccezioni e gestirle in modo appropriato.
- file `prodotti.txt`:
  ```txt
  abbigliamento,P001,Maglia a maniche lunghe,29.99,L,Cotone
  accessorio,A001,Occhiali da sole,59.99,Nero
  abbigliamento,P002,Pantaloni jeans,49.99,42,Denim
  abbigliamento,P003,T-shirt stampata,19.99,M,Cotone
  accessorio,A002,Cappello invernale,39.99,Rosso
  ```
- `main.java` da completare con le relative funzionalita':

```java
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Negozio negozio = new Negozio();

        negozio.caricaDaFile("prodotti.txt");
        
        Scanner scanner = new Scanner(System.in);
        
        int scelta = 0;
        do {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Visualizza prodotti");
            System.out.println("2. Aggiungi prodotto");
            System.out.println("3. Cerca prodotto per codice");
            System.out.println("4. Esci");
            
            scelta = scanner.nextInt();
            
            switch (scelta) {
                case 1:
                  ...
                case 2:
                  ...
                case 3:
                  ...
                case 4:
                  ...
                default:
                  ...
            }
            ...
            
        } while (scelta != 4);
        
        scanner.close();
    }
}

```

Buon lavoro!