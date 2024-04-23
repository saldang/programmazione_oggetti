# Traccia 19 Maggio 2023

### Programmazione ad Oggetti

Sviluppo di un sistema di gestione di una biblioteca

In questo esame di programmazione ad oggetti, verrà richiesto di sviluppare un sistema di gestione di una biblioteca utilizzando il linguaggio Java. Il sistema dovrà fare uso del concetto di polimorfismo e ereditarietà per ottenere una struttura modulare e flessibile.

Requisiti:

1. Creare una classe astratta chiamata "MaterialeBibliotecario" con i seguenti attributi:

   - Titolo (stringa): il titolo del materiale bibliotecario.
   - AnnoPubblicazione (intero): l'anno di pubblicazione del materiale.
   - NumeroCopie (intero): il numero di copie disponibili in biblioteca.
   - NumeroCopieInPrestito (intero): il numero di copie attualmente in prestito.

2. Creare le seguenti classi derivate da "MaterialeBibliotecario":

   - Libro: rappresenta un libro, con l'aggiunta degli attributi "autore" e "genere".
   - Rivista: rappresenta una rivista, con l'aggiunta dell'attributo "numero".

3. Creare una classe "Prestito" che rappresenti un prestito di un materiale bibliotecario. La classe dovrà avere i seguenti attributi:

   - Materiale (istanza di "MaterialeBibliotecario"): il materiale bibliotecario oggetto del prestito.
   - DataInizio (oggetto di tipo "Date"): la data di inizio del prestito.
   - DataFine (oggetto di tipo "Date"): la data di fine del prestito.

4. Implementare i seguenti metodi nelle classi:

   - Nella classe "MaterialeBibliotecario":
     - Costruttore che inizializza gli attributi.
     - Metodi getter e setter per gli attributi.
     - Metodo "calcolaDisponibilità" che restituisce il numero di copie disponibili.
   - Nella classe "Prestito":
     - Costruttore che inizializza gli attributi.
     - Metodo "calcolaDurata" che restituisce la durata del prestito in giorni.

5. Creare una classe principale chiamata "Biblioteca" che utilizzi le classi precedenti per gestire il sistema di prestito e restituzione dei materiali bibliotecari. La classe dovrà avere un metodo "main" che permetta di interagire con il sistema attraverso un menu di scelte, ad esempio:
   - Aggiunta di un nuovo libro o rivista alla biblioteca.
   - Prestito di un materiale bibliotecario.
   - Restituzione di un materiale bibliotecario.
   - Visualizzazione delle informazioni sui materiali disponibili.
   - Visualizzazione delle informazioni sui materiali in prestito.

Esempio di interazione con il sistema:

```
Benvenuto nel sistema di gestione della biblioteca!

Cosa vuoi fare?
1. Aggiungere un nuovo libro o rivista alla biblioteca
2. Effettuare un prestito
3. Effettuare una restituzione
4. Visualizzare le informazioni sui materiali disponibili
5. Visualizzare le informazioni sui materiali in prestito
6. Uscire dal programma

Inserisci il numero corrispondente all'azione che vuoi eseguire: 1

Vuoi aggiungere un libro o una rivista?
1. Libro
2. Rivista

Inserisci il numero corrispondente al tipo di materiale che vuoi aggiungere: 1

Inserisci il titolo del libro: Il nome della rosa

Inserisci l'autore del libro: Umberto Eco

Inserisci il genere del libro: Giallo

Inserisci l'anno di pubblicazione del libro: 1980

Inserisci il numero di copie disponibili in biblioteca: 3

Inserisci il numero di copie attualmente in prestito: 0

Vuoi aggiungere un altro libro o rivista?

1. Si
2. No

Inserisci il numero corrispondente alla tua scelta: 2

Cosa vuoi fare?
...

```

Note aggiuntive:

- Si richiede di utilizzare il concetto di polimorfismo quando possibile, ad esempio nel caso di una lista di oggetti "MaterialeBibliotecario" che può contenere sia libri che riviste.
- Assumere che l'input degli utenti avvenga tramite la console e che i dati siano salvati in memoria, senza persistenza su file o database.

Suggerimenti:

- Utilizzare le classi del package `java.util.ArrayList` per gestire le liste di oggetti.
- Utilizzare le classi del package `java.util` per lavorare con le date.
- Utilizzare le classi del package `java.util.Scanner` per leggere l'input degli utenti dalla console.
- Sviluppare il programma in modo incrementale, implementando una funzionalità alla volta e verificandone il corretto funzionamento prima di passare alla successiva.

Buon lavoro!

[def]: https://rentry.co/8p5sp
