# 130323

## Traccia 13 Marzo 2023

Implementare una classe Conto che ha le seguenti informazioni:

- Nome Utente
- Saldo conto
- Lista movimenti

e che permette di tenere traccia delle entrate/uscite (movimenti), permetta di categorizzarle e di aggiornare un file che viene usato come memoria/archivio.

Un *movimento* ha i seguenti attributi:

- Data
- Descrizione
- Tipo
- Valore
- Categoria

Il tipo può essere: **entrata** quindi il valore inserito è positivo, **uscita** valore negativo

Il programma dovrà
<u> **controllare la presenza**</u>
del file di archiviazione del conto chiamato **archivio.csv** che contiene una riga con Nome e saldo del conto e le restanti sono la lista dei movimenti archiviati. Se il file esiste, leggere le informazioni del conto e i movimenti, e tenerli in memoria.

Una volta letto il file verrà mostrato il nome utente e il saldo attuale, e chiesto se vuole inserire un movimento, caricare i movimenti da file o uscire.

A questo punto verrà inserito un movimento con le seguenti caratteristiche: 13/03/2023, Stipendio Marzo, entrata, 2000, Stipendio.

Una volta inserito, si procede con il caricamento dei movimenti da un file chiamato **movimenti.csv** che contiene le seguenti informazioni

```csv
14/03/2023,Rata mutuo,uscita,500,Mutuo
16/03/2023,Scarpe,uscita,100,Abbigliamento
16/03/2023,Abbonamento Netflix,uscita,17.99,Abbonamenti
20/03/203,Abbonamento Disney,uscita,89.90, Abbonamenti
23/03/2023,Cena amici,uscita,150,Svago
23/03/2023,Quote cena,entrata,100,Svago
```

Nel file **archivio.csv** sono presenti le seguenti voci:

```csv
Mario Rossi,1450
13/01/2023,Stipendio Gennaio,entrata,2000,Stipendi
14/01/2023,Rata mutuo,uscita,500,Mutuo
16/01/2023,Scarpe,uscita,100,Abbigliamento
16/01/2023,Abbonamento Netflix,uscita,17.99,Abbonamenti
20/01/203,Abbonamento Disney,uscita,89.90, Abbonamenti
23/01/2023,Cena amici,uscita,150,Svago
23/01/2023,Quote cena,entrata,100,Svago
13/02/2023,Stipendio Gennaio,entrata,2000,Stipendi
14/02/2023,Rata mutuo,uscita,500,Mutuo
16/02/2023,Scarpe,uscita,100,Abbigliamento
16/02/2023,Abbonamento Netflix,uscita,17.99,Abbonamenti
20/02/203,Abbonamento Disney,uscita,89.90, Abbonamenti
23/02/2023,Cena amici,uscita,150,Svago
23/02/2023,Quote cena,entrata,100,Svago
```

Quando il programma termina, salva le informazioni inserite manualmente e lette dal file movimenti.csv, nel file archivio.csv.

Strutturare il programma con un main e le classi Conto e Movimento.

N.B. Il programma deve compilare ed eseguire senza errori altrimenti **NON VERRÀ CORRETTO**
