# Sistema di Gestione Biblioteca

## Obiettivi:

Dimostrare la comprensione dell'ereditarietà e del polimorfismo.
Utilizzare le interfacce per definire comportamenti comuni.
Implementare la lettura e la scrittura su file per la persistenza dei dati.

### Descrizione:
Si vuole progettare un sistema per gestire una biblioteca. Il sistema dovrà permettere la gestione di libri e riviste, la registrazione di prestiti a utenti e la gestione di resi.

## Parte 1: Struttura delle Classi

**Item**: Classe astratta che rappresenta un generico item della biblioteca. Dovrà contenere almeno le seguenti proprietà:
* ID (unico per ogni item)  
* Titolo
* Anno di pubblicazione

**Libro**: Classe che eredita da Item e aggiunge le seguenti proprietà:
* Autore
* Numero di pagine

**Rivista**: Classe che eredita da Item e aggiunge le seguenti proprietà:
* Periodicità (es. mensile, settimanale)
* Numero di uscita

Utilizzare il polimorfismo per definire metodi comuni in Item che verranno implementati diversamente in Libro e Rivista.

## Parte 2: Gestione dei Prestiti

Definire un'interfaccia Prestabile con metodi per effettuare un prestito e per restituire un item.
Far implementare questa interfaccia alle classi Libro e Rivista in modo appropriato.

### Interfaccia Prestabile
L'interfaccia Prestabile è pensata per definire le operazioni legate al prestito degli item (libri e riviste) nella biblioteca. Attraverso questa interfaccia, si assicura che solo gli item che possono essere effettivamente prestati implementino le necessarie operazioni di prestito e restituzione.

Metodi dell'interfaccia Prestabile:
* **presta**: Questo metodo modifica lo stato dell'item per indicare che è stato prestato. Potrebbe accettare parametri quali la data di prestito e l'identificativo dell'utente a cui l'item è prestato. Dovrebbe inoltre gestire la logica per evitare il prestito se l'item è già prestato.
  * **void presta(String utenteId, LocalDate dataPrestito);**

* **restituisci**: Questo metodo cambia lo stato dell'item per segnalare che è stato restituito e quindi è di nuovo disponibile per il prestito. Potrebbe, opzionalmente, gestire operazioni aggiuntive come l'aggiornamento della storia dei prestiti.
  * v**oid restituisci();**

* **isDisponibile**: Un metodo di utilità che restituisce un booleano per indicare se l'item è attualmente disponibile per il prestito o meno.
  * **boolean isDisponibile();**

## Parte 3: Persistenza dei Dati

Creare una classe GestoreBiblioteca che utilizzi le collezioni per memorizzare gli item disponibili e i prestiti effettuati.
Implementare metodi in GestoreBiblioteca per la lettura e la scrittura degli item e dei prestiti da e verso file. Utilizzare serializzazione o scrittura in formato leggibile (ad esempio, CSV o JSON).

## Requisiti:

Implementare correttamente l'ereditarietà tra le classi Item, Libro e Rivista.
Dimostrare il polimorfismo con metodi sovrascritti o implementati tramite interfaccia.
Gestire correttamente la lettura e scrittura da file, gestendo eventuali eccezioni.
Fornire un main di esempio che dimostri la creazione e il caricamento degli Item, la gestione di prestiti e la persistenza dei dati.

## Bonus:

Implementare funzionalità aggiuntive come la ricerca di item per titolo o autore.
Implementare un sistema di log per tracciare le operazioni effettuate sul sistema, che salvi i log su file.

## Csv file

```csv
Tipo,ID,Titolo,Anno,Autore,Pagine,Periodicita,Uscita
Libro,1,Il signore degli anelli,1954,J.R.R. Tolkien,1178,,
Rivista,2,The New Yorker,1925,,,Mensile,1
Libro,3,Il nome della rosa,1980,Umberto Eco,503,,
Rivista,4,The Economist,1843,,,Settimanale,1
Libro,5,Il vecchio e il mare,1952,Ernest Hemingway,127,,
Rivista,6,Time,1923,,,Settimanale,1
Libro,7,Il processo,1925,Franz Kafka,255,,
Rivista,8,The Atlantic,1857,,,Mensile,1
Libro,9,Il ritratto di Dorian Gray,1890,Oscar Wilde,254,,
Rivista,10,The New York Times Magazine,1896,,,Settimanale,1
```