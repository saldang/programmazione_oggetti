# Traccia 20 Maggio 2024

Sviluppare un programma Java che gestisce un magazzino di prodotti alimentari e di elettrodomestici. Il programma deve:

- Definire un'interfaccia **Prodotto** con metodi per accedere e modificare le informazioni di base di un prodotto (codice, nome, prezzo, quantità).
- Creare due classi che implementano l'interfaccia **Prodotto**: **Alimentare** e **Elettrodomestico**.
- Ogni classe derivata deve avere attributi specifici:
  - scadenza per Alimentare
  - potenza per Elettrodomestico
- implementare metodi specifici:
  - *calcolaScadenzaRimanente* per Alimentare, 
  - *calcolaConsumoEnergetico* per Elettrodomestico.
- Definire una classe **Magazzino** con metodi per la gestione dei prodotti:
  - aggiunta
  - rimozione, 
  - ricerca
  - stampa delle informazioni
  - stampa di un scontrino con il totale da pagare.
- Implementare il polimorfismo utilizzando metodi sovrascritti.
- Salvare l'elenco dei prodotti su un file e leggerlo da un file esistente.
- ==Implementare la serializzazione degli oggetti per salvare i prodotti su file.==
- ==Implementare la gestione delle eccezioni per casi come "prodotto non trovato".==
- ==Implementare l'ordinamento dei prodotti in base al prezzo.==
- Implementare un metodo main che testi il funzionamento del programma.


```csv
codice,nome,prezzo,quantità,scadenza,potenza
A001,Latte,1.50,10,30/06/2024,
A002,Pane,1.00,20,30/04/2024,
E001,Frigorifero,500.00,5,,100
E002,Lavatrice,400.00,3,,200
```

Testare il programma inserendo 2 prodotti alimentari e 2 elettrodomestici, rimuovendo un prodotto per tipo, calcolando il totale da pagare e stampando l'elenco dei prodotti rimanenti.