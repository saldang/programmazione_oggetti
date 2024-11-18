# Sudoku

Il Sudoku è un gioco ampiamente diffuso basato sulla logica che utilizza un array di 9x9 caselle suddivise in 3x3 sotto-array. Il solutore deve riempire le caselle bianche inserendo numeri che vanno da 1 a 9, in modo che la cifra inserita non si ripeta né nella riga, né nella colonna e neanche nel sottogruppo cui appartiene la cifra. All’ini­zio alcune celle hanno già un valore e non possono essere modificate. Per esempio, la figura seguente rappresenta lo schema iniziale di un Sudoku:

```text
5 3 0 | 0 7 0 | 0 0 0
6 0 0 | 1 9 5 | 0 0 0
0 9 8 | 0 0 0 | 0 6 0
---------------------
8 0 0 | 0 6 0 | 0 0 3
4 0 0 | 8 0 3 | 0 0 1
7 0 0 | 0 2 0 | 0 0 6
---------------------
0 6 0 | 0 0 0 | 2 8 0
0 0 0 | 4 1 9 | 0 0 5
0 0 0 | 0 8 0 | 0 7 9

```

Si crei una classe Sudoku che possiede i seguenti attributi:

- scacchiera – un array 9x9 di interi che rappresenta lo stato attuale del gioco e in cui gli zeri rappresentano le celle ancora non riempite;
- inizio – un array 9x9 di valori booleani che specifica quali elementi dell’array scacchiera possiedono un valore che non può essere cambiato;

e i seguenti metodi:

- Sudoku – un costruttore che crea un nuovo gioco in cui tutte le caselle sono vuote;
- toString – restituisce una stringa stampabile che rappresenta il gioco;
- aggiungiaIniziali(riga, colonna, valore) – aggiunge nella posizione specificata da riga e colonna il valore iniziale dato da valore che non può essere modificato;
- aggiungiMossa(riga, colonna, valore) – aggiunge nella posizione specificata da riga e colonna il valore specificato da valore. Tale valore può essere modificato;
- verificaGioco() – restituisce vero se i valori inseriti non violano le regole del gioco;
- getValoreIn(riga, colonna) – restituisce il valore contenuto nella posizione specificata da riga e colonna;
- getValoriValidi(riga, colonna) – restituisce un array monodimensionale di nove valori booleani, ognuno dei quali corrisponde a una cifra e risulta vero se la cifra può essere posta alla posizione specificata da riga e colonna senza violare le regole del gioco;
- pieno – restituisce vero se ogni cella possiede un valore;
- reset – imposta a zero tutte le celle che non contengono valori immutabili.

Scrivere un metodo main nella classe Sudoku che crea un’istanza di Sudoku e imposta la configurazione iniziale. Quindi utilizzare un ciclo per permettere all’utente di giocare. Visualizzare la configurazione corrente e chiedere all’utente una riga, una colonna e un valore. Aggiornare la scacchiera di gioco e visualizzarla. Si avvisi l’utente qualora la nuova configurazione non rispetti le regole del gioco. Visualizzare un messaggio quando il gioco è stato completato correttamente. In questo caso, sia verificaGioco sia pieno devono restituire true. Si deve dare all’utente la possibilità di riavviare il gioco e di visualizzare i valori che possono essere inseriti nelle celle.
