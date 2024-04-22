# Traccia

## 17 Aprile 2023

### Programmazione ad Oggetti

Implementare la logia di un distributore automatico in Java con le seguenti funzionalità:

1. Il distributore puo essere caricato con un file csv (Comma Separated Value) denominato stock.csv che contiene i prodotti da vendere. Il file stock.csv ha un prodotto per riga e i campi sono separati da virgole. Il primo campo è il codice identificativo del prodotto, il secondo è il nome del prodotto, il terzo è il prezzo del prodotto e il quarto è il numero di pezzi disponibili. Il file stock.csv ha il seguente formato:

    ```csv
    A1,Acqua,1.5,10
    A2,Latte,1.0,10
    A3,The,1.0,10
    A4,Caffè,1.5,10
    A6,CocaCola,2.0,10
    A7,Sprite,2.0,10
    A8,Aranciata,2.0,10
    A9,AcquaMinerale,1.5,10
    ```

2. Il distributore accetta monete da 1, 2, 5, 10, 20, 50 centesimi e da 1 e 2 euro. Il distributore deve inoltre stampare a video il valore totale delle monete inserite.

3. Il distributore permette di scegliere il prodotto da acquistare inserendo il codice identificativo del prodotto. Il distributore deve inoltre stampare a video il prezzo del prodotto e il resto da restituire.

4. Il distributore deve inoltre stampare a video il numero di pezzi rimanenti di ogni prodotto.

5. Il distributore deve permettere al venditore di inserire nuovi prodotti e di aggiornare il numero di pezzi disponibili.

Struttura del progetto:

1. Creare un'interfaccia denominata `Distributore` con le funzionalità descritte sopra.
2. Creare una classe denominata `DistributoreImpl` che implementa la classe `Distributore` e che implementa le funzionalità descritte sopra.
3. Creare una classe denominata `Prodotto` che rappresenta un prodotto del distributore.
4. Creare una classe enumerata denominata `Moneta` che rappresenta le monete accettate dal distributore.
5. Creare una classe denominata `Main` che contiene il metodo `main` e che permette di testare il distributore leggendo le righe del file input.csv che contiene le scelte dell'utente. Il file input.csv ha un comando per riga e i campi sono separati da virgole.

```csv
3,stock.csv,""
1,"CINQUANTACENT CINQUANTACENT CINQUANTACENT 0","A6"
1,"CINQUANTACENT CINQUANTACENT CINQUANTACENT CINQUANTACENT 0","A6"
1,"DUEEURO 0","A1"
2,"A1 Acqua 1.5",""
2,"A2 Latte 1.0",""
2,"A6 CocaCola 1.0 5",""
0,"",""
```

Il progetto deve essere realizzato utilizzando il paradigma di programmazione ad oggetti.

Main:

```pseudo
crea un distributore
leggi input.csv
do
    stampa "Benvenuto nel distributore automatico"
    stampa "1. Acquista un prodotto"
    stampa "2. Aggiungi un prodotto"
    stampa "3. Carica il distributore"
    stampa "0. Esci"
    for input in input.csv
        leggi scelta
        se (scelta è 1)
            do
                stampa "Inserisci le moneta o 0 per terminare"
                leggi moneta
                aggiungiMoneta(moneta)
            while (monete non è 0)
            stampaCredito()
            leggi codice
            acquista(codice)
            restituisciResto()
            stampaStock()
        altrimenti se (scelta è 2)
            leggi codice
            leggi nome
            leggi prezzo
            if quantita non è specificata
                aggiungiProdotto(Prodotto(codice, nome, prezzo))
            else
                aggiungiProdotto(Prodotto(codice, nome, prezzo, quantita))
        altrimenti se (scelta è 3)
            stampa "Inserisci il nome del file"
            leggi nomeFile
            carica(nomeFile)
            stampaStock()
        altrimenti se (scelta è 0)
            esci
while (scelta non è 0)
```
