---
layout: post
title: "12 Novembre 2025"
date: 2025-11-12
---

## Sistema di Gestione di un Albergo 🏨

Sviluppare un sistema di gestione per un albergo che permetta di gestire camere di diverse tipologie, clienti e le loro prenotazioni. Il programma deve utilizzare i concetti fondamentali di OOP.

### 1. EREDITA' E CLASSI ASTRATTE

Implementare una gerarchia di classi per le camere:

- Classe astratta `Camera` con attributi comuni (numero, prezzo per notte, disponibile)
- Classi concrete: `CameraSingola`, `CameraMatrimoniale`, `CameraDeLuxe` (ereditano da `Camera`)
- Ogni tipo di camera deve avere specifiche proprie (numero posti, servizi extra, ecc.)

### 2. INTERFACCE

Implementare due interfacce:

- `Prenotabile`: metodi `prenota()`, `libera()`, `isPrenotata()`
- `Pagabile`: metodi `calcolaCosto(int giorni)`

Tutte le camere devono implementare `Prenotabile` e `Pagabile`.

### 3. LETTURA E SCRITTURA FILE

- **Scrittura**: Salvare su file `.txt` o `.csv` l'elenco delle prenotazioni effettuate con i dettagli (cliente, camera, date, costo)
- **Lettura**: Caricare da file le prenotazioni pregresse all'avvio (gestire l'assenza del file)

### 4. POLIMORFISMO

- Implementare un metodo `visualizzaDettagli()` polimorfo in ogni classe `Camera` che restituisca informazioni specifiche della tipologia
- Usare una lista generica di `Camera` per memorizzare tutte le camere e invocare il metodo polimorfo su ciascuna

### 5. GESTIONE ECCEZIONI

- Eccezione personalizzata `CameraOccupatException` se si tenta di prenotare una camera non disponibile
- Eccezione personalizzata `ClienteNonValidoException` se i dati del cliente sono incompleti
- Eccezione per errori di lettura/scrittura file
- Gestire opportunamente `try-catch` nel programma principale

---

## STRUTTURA DEL PROGRAMMA

### Classi da implementare

```bash
Camera (classe astratta)
├── CameraSingola
├── CameraMatrimoniale
└── CameraDeLuxe

Prenotabile (interfaccia)
Pagabile (interfaccia)

Cliente
Prenotazione
Albergo (classe principale di gestione)
HotelMain (classe con main per i test)
```

### Classe Camera (astratta)

- **Attributi**: numero, prezzo, disponibile, maxOspiti
- **Metodi**:
  - `prenota(Cliente c)`: implementazione di `Prenotabile`
  - `libera()`: implementazione di `Prenotabile`
  - `isPrenotata()`: implementazione di `Prenotabile`
  - `calcolaCosto(int giorni)`: implementazione di `Pagabile`
  - `visualizzaDettagli()`: astratto
  - Getter e setter

### Classi concrete di Camera

#### CameraSingola

- **Numero massimo ospiti**: 1
- **Prezzo base per notte**: €50
- **Servizi inclusi**: WiFi, TV, Bagno privato
- **Attributi specifici**:
  - `haAria: boolean` (aria condizionata, default true)
  - `numeroFinestre: int` (default 1)
- **Metodo calcolaCosto()**: prezzo base × giorni (senza variazioni)
- **Metodo visualizzaDettagli()**: stampa numero camera, prezzo, ospiti max, servizi inclusi e specifici della singola
- **Metodo toString()**: formato "[Singola - Camera N. X] - €50/notte - Ospiti: 1"

#### CameraMatrimoniale

- **Numero massimo ospiti**: 2
- **Prezzo base per notte**: €80
- **Servizi inclusi**: WiFi, TV, Bagno privato, Minibar
- **Attributi specifici**:
  - `haBalcone: boolean` (balcone, default true)
  - `haVasca: boolean` (vasca da bagno, default true)
  - `tipoLetto: String` ("Matrimoniale" o "Due letti singoli")
- **Metodo calcolaCosto()**:
  - Prezzo base × giorni
  - Se ha balcone e vasca: +5% al costo totale
- **Metodo visualizzaDettagli()**: stampa numero camera, prezzo, ospiti max, tipo letto, servizi
- **Metodo toString()**: formato "[Matrimoniale - Camera N. X] - €80/notte - Ospiti: 2 - Letto: Matrimoniale"

#### CameraDeLuxe

- **Numero massimo ospiti**: 4
- **Prezzo base per notte**: €150
- **Servizi inclusi**: WiFi premium, TV smart, Bagno privato, Minibar, Frigobar, Cassaforte, Accappatoio premium
- **Attributi specifici**:
  - `haTerrazza: boolean` (terrazza con vista, default true)
  - `haJacuzzi: boolean` (vasca con idromassaggio, default true)
  - `haKitchenette: boolean` (mini cucina, default true)
  - `scontoLealtà: double` (sconto fedeltà cliente, range 0.0-0.15, default 0.0)
- **Metodo calcolaCosto()**:
  - Prezzo base × giorni
  - Se ha terrazza e jacuzzi: +15% al prezzo
  - Se ha kitchenette: +10% al prezzo
  - Applica lo sconto fedeltà al costo totale
  - Formula: `((prezzo + supplementi) × giorni) × (1 - scontoLealtà)`
- **Metodo visualizzaDettagli()**: stampa numero camera, prezzo, ospiti max, tutti i servizi esclusivi e sconto se applicabile
- **Metodo toString()**: formato "[DeLuxe - Camera N. X] - €150/notte - Ospiti: 4 - Terrazza: Sì - Jacuzzi: Sì"
- **Metodo setScontoLealtà(double sconto)**: con validazione (0.0 ≤ sconto ≤ 0.15)

### Classe Cliente

- **Attributi**:
  - `nome: String`
  - `cognome: String`
  - `email: String`
  - `telefono: String`
  - `dataRegistrazione: LocalDate`

- **Metodi di validazione** (devono lanciare `ClienteNonValidoException`):
  - **Nome**: non null, non vuoto, almeno 2 caratteri
  - **Cognome**: non null, non vuoto, almeno 2 caratteri
  - **Email**: non null, non vuota, deve contenere "@" e ".", formato valido (es: <nome@dominio.it>)

- **Metodi**:
  - `toString()`: formato "[Cliente] Nome Cognome - Email: email - Tel: telefono"
  - `getInformazioniPerFile()`: ritorna stringa formattata per il salvataggio su file
  - `equals()` e `hashCode()` (confronto basato su email)

### Classe Prenotazione

- **Attributi**: cliente, camera, dataInizio, dataFine, costoTotale
- **Metodi**: toString() per la visualizzazione, metodo per salvare su file

### Classe Albergo

- **Attributi**: nome, lista di camere, lista di prenotazioni
- **Metodi**:
  - `aggiungiCamera(Camera c)`
  - `cercaCameraDisponibile(int ospiti)`: ritorna prima camera disponibile per il numero di ospiti
  - `creaPrenotazione(Cliente c, Camera cam, int giorni)`:
    - Verifica disponibilità camera, lancia `CameraOccupatException` se non disponibile
    - Verifica validità cliente, lancia `ClienteNonValidoException` se non valido
    - Crea prenotazione e aggiorna stato camera
  - `caricaPrenotazioniDaFile(String nomeFile)`: gestione eccezioni file
  - `salvaPrenotazioniSuFile(String nomeFile)`: gestione eccezioni file
  - `visualizzaPrenotazioni()`
  - `visualizzaTutteCamera()`

### Eccezioni personalizzate

#### CameraOccupatException

- **Utilizzata quando**: si tenta di prenotare una camera che non è disponibile (già occupata)
- **Messaggio suggerito**: "La camera numero X è già occupata per le date richieste"

#### ClienteNonValidoException

- **Utilizzata quando**: i dati del cliente non rispettano i criteri di validazione
- **Costruttore**:

  ```java
  public ClienteNonValidoException(String messaggio, String campo)
  ```

- **Campi di validazione falliti**:
  - "NOME" - se nome non valido
  - "COGNOME" - se cognome non valido
  - "EMAIL" - se email non valida
- **Messaggio suggerito**: "Errore nel campo CAMPO: messaggio specifico"
  - Es: "Errore nel campo EMAIL: formato email non valido"
  - Es: "Errore nel campo NOME: deve contenere almeno 2 caratteri"

### Classe HotelMain

Implementare un programma di test che:

1. **Crea un albergo** con 5 camere (almeno una di ogni tipo)

2. **Crea 4 clienti di test**:
   - Cliente 1: valido (es: "Mario Rossi", "<mario@email.com>", "3201234567")
   - Cliente 2: valido (es: "Anna Bianchi", "<anna@email.com>", "3331234567")
   - Cliente 3: valido (es: "Giovanni Ferrari", "<giovanni@email.com>", "3209876543")
   - Cliente 4: NON valido (testare eccezione, es: nome vuoto, email senza @)

3. **Tenta di creare il cliente non valido** e cattura `ClienteNonValidoException`

4. **Effettua 3 prenotazioni valide** (con clienti validi):
   - Prenotazione 1: Cliente 1, CameraSingola, 2 giorni
   - Prenotazione 2: Cliente 2, CameraMatrimoniale, 3 giorni
   - Prenotazione 3: Cliente 3, CameraDeLuxe, 4 giorni (con sconto fedeltà 10%)

5. **Tenta di prenotare la stessa camera** già occupata e cattura `CameraOccupatException`

6. **Salva le prenotazioni su file** (`prenotazioni.txt` o `prenotazioni.csv`):
   - Gestire `IOException` se il salvataggio fallisce
   - Formato suggerito CSV: `Cliente,Camera,DataInizio,DataFine,GiorniPrenotati,CostoTotale`

7. **Carica le prenotazioni da file** (`prenotazioni.txt`):
   - Gestire `FileNotFoundException` se il file non esiste
   - Visualizzare le prenotazioni caricate

8. **Visualizza tutte le camere** con i loro dettagli (polimorfismo):
   - Chiama `visualizzaDettagli()` su ogni camera
   - Mostra le differenze tra CameraSingola, CameraMatrimoniale, CameraDeLuxe

**Output atteso**:

```bash
==== SISTEMA ALBERGO ====
[Creazione albergo e 5 camere]
[Creazione clienti]
ERRORE CATTURATO: Errore nel campo EMAIL: ...
[Creazione 3 prenotazioni valide]
Prenotazione 1: Mario Rossi - Camera Singola N. X - €100 per 2 giorni
Prenotazione 2: Anna Bianchi - Camera Matrimoniale N. Y - €252 per 3 giorni
Prenotazione 3: Giovanni Ferrari - Camera DeLuxe N. Z - €540 per 4 giorni (con sconto 10%)
ERRORE CATTURATO: La camera numero X è già occupata per le date richieste
[Salvataggio prenotazioni su file]
[Caricamento prenotazioni da file]
[Visualizzazione dettagli di tutte le camere]
==== FINE TEST ====
```
