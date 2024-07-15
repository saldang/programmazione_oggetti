# Traccia 20 Giugno 2024

## **Simulatore di Parco Divertimenti**

https://saldang.github.io/programmazione_oggetti/esami/2024/

### Descrizione del Progetto:

Crea un'applicazione Java che simuli la gestione di un parco divertimenti. L'applicazione deve consentire di gestire attrazioni, visitatori e dipendenti, oltre a salvare e caricare lo stato del parco su file. Il progetto deve mettere in pratica i concetti di ereditarietà, polimorfismo, interfacce e lettura/scrittura su file.

### Specifiche del Progetto:

#### 1. Classi e Ereditarietà

- **Attrazione (classe base)**: Definisci una classe `Attraction` con attributi comuni come `name`, `capacity`, e `minHeight`. Implementa un metodo `displayInfo()` che mostri le informazioni dell'attrazione.
  - **RollerCoaster (sottoclasse di Attraction)**: Aggiungi attributi specifici come `speed` e `numLoops`. Sovrascrivi il metodo `displayInfo()` per includere queste informazioni.
  - **FerrisWheel (sottoclasse di Attraction)**: Aggiungi attributi specifici come `diameter` e `numCabins`. Sovrascrivi il metodo `displayInfo()` per includere queste informazioni.
  - **HauntedHouse (sottoclasse di Attraction)**: Aggiungi attributi specifici come `numRooms` e `scarinessLevel`. Sovrascrivi il metodo `displayInfo()` per includere queste informazioni.

#### 2. Polimorfismo e Interfacce

- **Visitatore**: Crea una classe `Visitor` con attributi come `name`, `age`, e `height`. Implementa un metodo `ride(Attraction attraction)` che verifichi se il visitatore può salire sull'attrazione (in base a `minHeight` e `capacity`).
- **Dipendente (interfaccia)**: Definisci un'interfaccia `Employee` con metodi `work()` e `takeBreak()`.
  - **OperatoreAttrazione (classe che implementa Employee)**: Implementa i metodi `work()` e `takeBreak()`. Aggiungi un attributo `assignedAttraction` per l'attrazione gestita.
  - **AddettoPulizie (classe che implementa Employee)**: Implementa i metodi `work()` e `takeBreak()`. Aggiungi un attributo `area` per l'area del parco assegnata.

#### 3. Lettura/Scrittura su File

- **Salvataggio e Caricamento**: Implementa i metodi `saveToFile(String filename)` e `loadFromFile(String filename)` per salvare e caricare lo stato del parco divertimenti (inclusi attrazioni, visitatori e dipendenti) da un file di testo. Gestisci adeguatamente le eccezioni.

### Funzionalità dell'Applicazione (main):

- **Aggiungere Attrazioni**: Permetti all'utente di aggiungere nuove attrazioni al parco, specificando i dettagli rilevanti.
- **Registrare Visitatori**: Consenti la registrazione di nuovi visitatori e il controllo delle attrazioni a cui possono accedere.
- **Gestione Dipendenti**: Gestisci i dipendenti del parco, assegnandoli alle attrazioni o alle aree di pulizia.
- **Simulazione**: Permetti di simulare una giornata nel parco, dove i visitatori provano le attrazioni e i dipendenti svolgono le loro mansioni (sequenza di azioni su attrazioni, visitatori e dipendenti stampando messaggi a video).
- **Salvataggio e Caricamento**: Consenti di salvare lo stato attuale del parco su file e di caricarlo all'avvio dell'applicazione.

### File esempio stato del parco (attrazioni, visitatori, dipendenti):

```csv
Attraction,RollerCoaster,Blue Tornado,10,120,140,5
Attraction,FerrisWheel,Orlando Eye,100,80,35,5
Attraction,HauntedHouse,Halloween Horror Nights,50,100,25,9
Visitor,Alice,6,100
Visitor,Charlie,15,130
Visitor,Bob,18,180
Employee,Operator,Bob,RollerCoaster,
Employee,Cleaner,Emily,Entrance
```

### Requisiti Tecnici:

- Utilizza classi e metodi ben organizzati.
- Impiega l'ereditarietà e il polimorfismo in modo appropriato.
- Implementa le interfacce necessarie per la gestione dei dipendenti.
- Gestisci la lettura e scrittura su file in modo robusto, gestendo le eccezioni.
- Assicurati che ogni classe abbia un metodo `toString()` ben definito per la rappresentazione delle informazioni.

### Bonus (opzionale):

- Aggiungi funzionalità innovative alla tua applicazione. Alcuni esempi potrebbero includere:
  - Implementare una funzione di raccomandazione per le attrazioni basata sui dati dei visitatori.
  - Creare un sistema di gestione delle code per le attrazioni.
  - Creare eccezioni per casi specifici (es. visitatore troppo giovane per un'attrazione).

### Consegna

- Assicurati che ogni file Java sia ben commentato, l'applicazione sia priva di errori e compili correttamente.
