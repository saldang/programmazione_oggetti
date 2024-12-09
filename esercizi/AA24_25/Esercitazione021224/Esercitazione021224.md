# Esercitazione: Gestione Gerarchica di Utenti con Archiviazione in File e Cartelle

## Obiettivo

Realizzare un sistema che gestisca una gerarchia di utenti, utilizzando i concetti di ereditarietà, interfacce e polimorfismo. Gli utenti devono essere salvati in una struttura di cartelle che rispecchi la gerarchia creata nel codice. Ogni utente deve avere una scheda salvata in un file di testo all'interno della relativa cartella.

### Requisiti

#### 1. Gerarchia di Utenti

Devi creare una gerarchia di classi che rappresenti diverse categorie di utenti:

- **Classe astratta `Utente`**:
  - Attributi: `ID` (String), `nome` (String), `email` (String).
  - Metodo astratto `generaScheda()`, che crea e salva la scheda dell’utente in un file di testo.
- **Sottoclassi di `Utente`**:
  - **`Studente`**:
    - Attributi: `classe` (String), `mediaVoti` (double).
    - Implementa il metodo `generaScheda()` salvando i dettagli dello studente in un file.
  - **`Dipendente`**:
    - Attributi: `ruolo` (String), `stipendio` (double).
    - Implementa il metodo `generaScheda()` salvando i dettagli del dipendente in un file.
  - **`Docente`** (sottoclasse di `Dipendente`):
    - Attributi: `materia` (String).
    - Sovrascrive `generaScheda()` per aggiungere il dettaglio della materia.

---

#### 2. Struttura di Cartelle

Il sistema deve rispecchiare la gerarchia degli utenti nella struttura di cartelle:

- Una cartella principale `utenti/` con sottocartelle per ogni tipo di utente (`studenti/`, `dipendenti/`, `docenti/`).
- Ogni cartella contiene i file di testo delle schede dei rispettivi utenti.

---

#### 3. Funzionalità del Programma

Implementa una classe `GestioneUtenti` con le seguenti funzionalità:

1. **Aggiunta di utenti**:
   - Gli utenti devono essere memorizzati in un `ArrayList<Utente>`.
   - Devono essere salvati nelle cartelle corrette.
2. **Generazione automatica della gerarchia di cartelle**:
   - Usa il metodo `creaCartella()` per creare automaticamente la cartella appropriata per ogni utente.
3. **Letture delle schede utenti**:
   - Implementa il metodo `caricaDaCartelle(String path)` che legge tutte le schede da una struttura di cartelle e crea gli oggetti utente corrispondenti.
4. **Esportazione schede utenti**:
   - Implementa il metodo `salvaTuttiGliUtenti()` che salva tutte le schede utenti nei file di testo.
5. **Ricerca utenti**:
   - Implementa il metodo `cercaUtente(String id)` che restituisce un utente cercando nel `ArrayList` e legge la sua scheda dal file associato.
6. **Stampa di un report completo**:
   - Genera un file di testo `report.txt` che riepiloga tutti gli utenti con i dettagli essenziali.

---

#### 4. Interfacce

1. **Interfaccia `SchedaGenerabile`**:
   - Metodo `generaScheda()` da implementare in tutte le sottoclassi di `Utente`.
2. **Interfaccia `Archiviabile`**:
   - Metodo `creaCartella(String path)` per creare la cartella di archiviazione.

---

### Vincoli e Linee Guida

1. **Lettura e scrittura dei file**:
   - Usa `FileWriter` e/o `BufferedWriter` per scrivere le schede degli utenti.
   - Usa `BufferedReader` per leggere i file e visualizzare le schede.
2. **Gestione delle eccezioni**:
   - Solleva un'eccezione personalizzata `UtenteNonTrovatoException` se un utente cercato non esiste.
   - Gestisci eccezioni comuni come `IOException` durante la lettura/scrittura dei file.
3. **Organizzazione del codice**:
   - Dividi il progetto in packages (`model` per le classi degli utenti, `service` per la gestione degli utenti, ecc.).

---

### Output Atteso

Esempio di struttura delle cartelle e dei file generati:

```txt
utenti/
│
├── studenti/
│   ├── studente1.txt
│   ├── studente2.txt
│
├── dipendenti/
│   ├── dipendente1.txt
│
└── docenti/
    ├── docente1.txt
```

Contenuto di un file `studente1.txt`:

```txt
ID: S123
Nome: Mario Rossi
Email: mario.rossi@example.com
Classe: 2A
Media Voti: 8.5
```

---

### Estensioni Opzionali

1. **Caricamento iniziale**: Implementa un metodo per caricare utenti da file esistenti.
2. **Interfaccia grafica**: Estendi il programma con una semplice GUI per la gestione degli utenti.

---

Questo progetto permette di mettere in pratica i principali concetti di programmazione a oggetti, gestione file e organizzazione del codice in Java.

