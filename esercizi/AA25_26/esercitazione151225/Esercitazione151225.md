# Sistema di Gestione di una Biblioteca 📚

Sviluppare un sistema di gestione per una biblioteca che permetta di gestire libri di diverse categorie, utenti e i loro prestiti. Il programma deve utilizzare i concetti fondamentali di OOP.

## 1. EREDITA' E CLASSI ASTRATTE

Implementare una gerarchia di classi per i libri:

* Classe astratta `Libro` con attributi comuni (codice ISBN, titolo, autore, disponibile)
* Classi concrete: `Romanzo`, `Manuale`, `Rivista` (ereditano da `Libro`)
* Ogni tipo di libro deve avere specifiche proprie (genere letterario, argomento, periodicità, ecc.)

## 2. INTERFACCE

Implementare due interfacce:

* `Prestabile`: metodi `presta()`, `restituisci()`, `isPrestato()`
* `Valutabile`: metodi `calcolaPenale(int giorniRitardo)`

Tutti i libri devono implementare `Prestabile` e `Valutabile`.

## 3. LETTURA E SCRITTURA FILE

* **Scrittura**: Salvare su file `.txt` o `.csv` l'elenco dei prestiti effettuati con i dettagli (utente, libro, date, penale se applicata)
* **Lettura**: Caricare da file i prestiti pregressi all'avvio (gestire l'assenza del file)

## 4. POLIMORFISMO

* Implementare un metodo `visualizzaDettagli()` polimorfo in ogni classe `Libro` che restituisca informazioni specifiche della tipologia
* Usare una lista generica di `Libro` per memorizzare tutti i libri e invocare il metodo polimorfo su ciascuno

## 5. GESTIONE ECCEZIONI

* Eccezione personalizzata `LibroNonDisponibileException` se si tenta di prestare un libro non disponibile
* Eccezione personalizzata `UtenteNonValidoException` se i dati dell'utente sono incompleti
* Eccezione per errori di lettura/scrittura file
* Gestire opportunamente `try-catch` nel programma principale

---

## STRUTTURA DEL PROGRAMMA

### Classi da implementare

```txt
Libro (classe astratta)
├── Romanzo
├── Manuale
└── Rivista

Prestabile (interfaccia)
Valutabile (interfaccia)

Utente
Prestito
Biblioteca (classe principale di gestione)
BibliotecaMain (classe con main per i test)
```

### Classe Libro (astratta)

* **Attributi**: isbn, titolo, autore, disponibile, annoPubblicazione
* **Metodi**:
  * `presta(Utente u)`: implementazione di `Prestabile`
  * `restituisci()`: implementazione di `Prestabile`
  * `isPrestato()`: implementazione di `Prestabile`
  * `calcolaPenale(int giorniRitardo)`: implementazione di `Valutabile`
  * `visualizzaDettagli()`: astratto
  * Getter e setter

### Classi concrete di Libro

#### Romanzo

* **Durata prestito standard**: 21 giorni
* **Penale base per ritardo**: €0.50/giorno
* **Attributi specifici**:
  * `genere: String` (es: "Giallo", "Fantasy", "Storico")
  * `numeroPagine: int`
  * `saga: boolean` (fa parte di una saga, default false)
* **Metodo calcolaPenale()**: penale base × giorni ritardo (senza variazioni)
* **Metodo visualizzaDettagli()**: stampa ISBN, titolo, autore, genere, numero pagine, se fa parte di saga
* **Metodo toString()**: formato "[Romanzo] Titolo - Autore - Genere: X - Pagine: Y"

#### Manuale

* **Durata prestito standard**: 30 giorni
* **Penale base per ritardo**: €1.00/giorno
* **Attributi specifici**:
  * `argomento: String` (es: "Informatica", "Medicina", "Ingegneria")
  * `edizione: int` (numero edizione)
  * `universitario: boolean` (testo universitario, default true)
* **Metodo calcolaPenale()**:
  * Penale base × giorni ritardo
  * Se universitario: +50% alla penale totale
* **Metodo visualizzaDettagli()**: stampa ISBN, titolo, autore, argomento, edizione, se è universitario
* **Metodo toString()**: formato "[Manuale] Titolo - Autore - Argomento: X - Ed. Y"

#### Rivista

* **Durata prestito standard**: 7 giorni
* **Penale base per ritardo**: €0.30/giorno
* **Attributi specifici**:
  * `periodicita: String` ("Settimanale", "Mensile", "Trimestrale")
  * `numeroEdizione: int` (numero dell'edizione)
  * `mese: String` (mese di pubblicazione)
  * `conAllegato: boolean` (con allegato, default false)
* **Metodo calcolaPenale()**:
  * Penale base × giorni ritardo
  * Se con allegato: +20% alla penale totale
  * Se periodicità settimanale: nessuna penale (materiale che perde rapidamente valore)
* **Metodo visualizzaDettagli()**: stampa ISBN, titolo, periodicità, numero edizione, mese, se ha allegato
* **Metodo toString()**: formato "[Rivista] Titolo - Periodicità: X - Edizione N. Y - Mese: Z"

### Classe Utente

* **Attributi**:
  * `nome: String`
  * `cognome: String`
  * `email: String`
  * `tessera: String` (numero tessera biblioteca)
  * `dataIscrizione: LocalDate`
* **Metodi di validazione** (devono lanciare `UtenteNonValidoException`):
  * **Nome**: non null, non vuoto, almeno 2 caratteri
  * **Cognome**: non null, non vuoto, almeno 2 caratteri
  * **Email**: non null, non vuota, deve contenere "@" e ".", formato valido
  * **Tessera**: non null, non vuota, formato "BIB" seguito da 6 cifre (es: BIB123456)
* **Metodi**:
  * `toString()`: formato "[Utente] Nome Cognome - Tessera: BIB123456 - Email: email"
  * `getInformazioniPerFile()`: ritorna stringa formattata per il salvataggio su file
  * `equals()` e `hashCode()` (confronto basato su numero tessera)

### Classe Prestito

* **Attributi**: utente, libro, dataPrestito, dataScadenza, dataRestituzione, penaleTotale
* **Metodi**: toString() per la visualizzazione, metodo per calcolare giorni ritardo, metodo per salvare su file

### Classe Biblioteca

* **Attributi**: nome, lista di libri, lista di prestiti
* **Metodi**:
  * `aggiungiLibro(Libro l)`
  * `cercaLibroDisponibile(String titolo)`: ritorna primo libro disponibile con quel titolo
  * `creaPrestito(Utente u, Libro l, int giorniPrestito)`:
    * Verifica disponibilità libro, lancia `LibroNonDisponibileException` se non disponibile
    * Verifica validità utente, lancia `UtenteNonValidoException` se non valido
    * Crea prestito e aggiorna stato libro
  * `restituisciLibro(Libro l, int giorniRitardo)`: gestisce restituzione e calcola penale
  * `caricaPrestitiDaFile(String nomeFile)`: gestione eccezioni file
  * `salvaPrestitiSuFile(String nomeFile)`: gestione eccezioni file
  * `visualizzaPrestiti()`
  * `visualizzaTuttiLibri()`

### Eccezioni personalizzate

#### LibroNonDisponibileException

* **Utilizzata quando**: si tenta di prestare un libro che non è disponibile (già in prestito)
* **Messaggio suggerito**: "Il libro 'Titolo' (ISBN: X) non è attualmente disponibile per il prestito"

#### UtenteNonValidoException

* **Utilizzata quando**: i dati dell'utente non rispettano i criteri di validazione
* **Costruttore**:

  ```java
  public UtenteNonValidoException(String messaggio, String campo)
  ```

* **Campi di validazione falliti**:
  * "NOME" - se nome non valido
  * "COGNOME" - se cognome non valido
  * "EMAIL" - se email non valida
  * "TESSERA" - se numero tessera non valido
* **Messaggio suggerito**: "Errore nel campo CAMPO: messaggio specifico"
  * Es: "Errore nel campo TESSERA: formato non valido (deve essere BIBXXXXXX)"
  * Es: "Errore nel campo EMAIL: formato email non valido"

### Classe BibliotecaMain

Implementare un programma di test che:

1. **Crea una biblioteca** con 6 libri (almeno due di ogni tipo)
2. **Crea 4 utenti di test**:
   * Utente 1: valido (es: "Luca Verdi", "<luca@email.com>", "BIB001234")
   * Utente 2: valido (es: "Sara Neri", "<sara@email.com>", "BIB005678")
   * Utente 3: valido (es: "Paolo Bianchi", "<paolo@email.com>", "BIB009012")
   * Utente 4: NON valido (testare eccezione, es: tessera con formato errato "123456")
3. **Tenta di creare l'utente non valido** e cattura `UtenteNonValidoException`
4. **Effettua 3 prestiti validi** (con utenti validi):
   * Prestito 1: Utente 1, Romanzo, 21 giorni
   * Prestito 2: Utente 2, Manuale universitario, 30 giorni
   * Prestito 3: Utente 3, Rivista mensile con allegato, 7 giorni
5. **Tenta di prestare lo stesso libro** già in prestito e cattura `LibroNonDisponibileException`
6. **Simula restituzioni in ritardo**:
   * Restituzione romanzo: 5 giorni ritardo → penale €2.50
   * Restituzione manuale: 3 giorni ritardo → penale €4.50 (con maggiorazione universitario)
   * Restituzione rivista: 2 giorni ritardo → penale €0.72 (con maggiorazione allegato)
7. **Salva i prestiti su file** (`prestiti.txt` o `prestiti.csv`):
   * Gestire `IOException` se il salvataggio fallisce
   * Formato suggerito CSV: `Utente,Libro,DataPrestito,DataScadenza,DataRestituzione,GiorniRitardo,PenaleTotale`
8. **Carica i prestiti da file** (`prestiti.txt`):
   * Gestire `FileNotFoundException` se il file non esiste
   * Visualizzare i prestiti caricati
9. **Visualizza tutti i libri** con i loro dettagli (polimorfismo):
   * Chiama `visualizzaDettagli()` su ogni libro
   * Mostra le differenze tra Romanzo, Manuale, Rivista

**Output atteso**:

```txt
==== SISTEMA BIBLIOTECA ====
[Creazione biblioteca e 6 libri]
[Creazione utenti]
ERRORE CATTURATO: Errore nel campo TESSERA: formato non valido (deve essere BIBXXXXXX)
[Creazione 3 prestiti validi]
Prestito 1: Luca Verdi - Romanzo "Titolo" - Scadenza: 21 giorni
Prestito 2: Sara Neri - Manuale "Titolo" - Scadenza: 30 giorni
Prestito 3: Paolo Bianchi - Rivista "Titolo" - Scadenza: 7 giorni
ERRORE CATTURATO: Il libro 'Titolo' (ISBN: X) non è attualmente disponibile per il prestito
[Restituzioni con ritardo]
Restituzione romanzo: 5 giorni ritardo → Penale: €2.50
Restituzione manuale: 3 giorni ritardo → Penale: €4.50 (con maggiorazione)
Restituzione rivista: 2 giorni ritardo → Penale: €0.72 (con maggiorazione allegato)
[Salvataggio prestiti su file]
[Caricamento prestiti da file]
[Visualizzazione dettagli di tutti i libri]
==== FINE TEST ====
```

File:

* [Biblioteca.java](./Biblioteca.java)
* [BibliotecaTest.java](./BibliotecaTest.java)
* [Libro.java](./Libro.java)
* [Prestabile.java](./Prestabile.java)
* [Valutabile.java](./Valutabile.java)
* [Romanzo.java](./Romanzo.java)
* [Manuale.java](./Manuale.java)
* [Rivista.java](./Rivista.java)
* [Utente.java](./Utente.java)
* [UtenteNonValidoException.java](./UtenteNonValidoException.java)
* [Prestito.java](./Prestito.java)
* [Libri.csv](./libri.csv)
