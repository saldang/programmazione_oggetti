---
layout: post
title: "Traccia 14 Luglio 2025"
date: 2025-07-14
---
## Sistema di Gestione Palestra Fitness

Si vuole realizzare un sistema per gestire una palestra fitness che offre diversi tipi di corsi e gestisce gli abbonamenti dei clienti. Il sistema deve tenere traccia dei corsi, dei partecipanti e generare statistiche.

### Requisiti Funzionali

#### 1. Gerarchia di Corsi (Ereditarietà e Polimorfismo)

Creare una gerarchia di classi per i corsi:

- **Classe astratta `Corso`** con:
  - Attributi: `nome`, `istruttore`, `durataMinuti`, `maxPartecipanti`, `costo`
  - Metodi astratti: `calcolaCostoTotale()`, `getDescrizione()`
  - Metodi concreti: `getNome()`, `getIstruttore()`, `getDurata()`, `getCosto()`

- **Classi concrete**:
  - `CorsoCardio`:
    - Attributi aggiuntivi: `livelloIntensita` (1-5), `attrezzaturaRichiesta`
    - Metodo `calcolaCostoTotale()`: costo base + (livelloIntensita * 5)
    - Metodo `getDescrizione()`: restituisce info su intensità e attrezzatura

  - `CorsoForza`:
    - Attributi aggiuntivi: `pesoMassimo`, `numeroEsercizi`
    - Metodo `calcolaCostoTotale()`: costo base + (numeroEsercizi * 2)
    - Metodo `getDescrizione()`: restituisce info su peso e esercizi

  - `CorsoYoga`:
    - Attributi aggiuntivi: `tipoYoga`, `livelloDifficolta`
    - Metodo `calcolaCostoTotale()`: costo base (invariato)
    - Metodo `getDescrizione()`: restituisce tipo e livello difficoltà

#### 2. Interfacce

Implementare le seguenti interfacce:

- **`Prenotabile`**:
  - `prenotaPosto(String nomeCliente)`: prenota un posto nel corso
  - `annullaPrenotazione(String nomeCliente)`: annulla prenotazione
  - `getPostiDisponibili()`: restituisce numero posti liberi

- **`Statistiche`**:
  - `getNumeroPartecipanti()`: restituisce numero iscritti attuali
  - `calcolaIncassoTotale()`: calcola incasso del corso
  - `getPercentualeOccupazione()`: restituisce % di occupazione

#### 3. Gestione File CSV (I/O)

Il sistema deve gestire:

- **Lettura corsi** da file CSV con formato:

  ```txt
  nome,tipo,istruttore,durata,maxPartecipanti,costo,parametro1,parametro2
  Spinning,CARDIO,Mario Rossi,45,20,25.0,4,cyclette
  Sollevamento,FORZA,Luigi Bianchi,60,15,30.0,100,8
  Hatha Yoga,YOGA,Anna Verdi,90,12,20.0,hatha,principiante
  ```

- **Scrittura report** in CSV con statistiche:

  ```txt
  corso,istruttore,partecipanti,incasso,occupazione_percentuale
  Spinning,Mario Rossi,18,450.0,90.0
  Sollevamento,Luigi Bianchi,12,360.0,80.0
  Hatha Yoga,Anna Verdi,10,200.0,83.3
  ```

#### 4. Gestione Eccezioni

Implementare eccezioni personalizzate:

- `CorsoNonTrovatoException`: quando si cerca un corso inesistente
- `PostiEsauritiException`: quando si prova a prenotare un corso pieno
- `ClienteGiaIscrittoException`: quando un cliente è già iscritto al corso
- `FileFormatoException`: per errori nel formato dei file CSV

#### 5. Classe Principale `GestorePalestra`

Deve contenere:

- `List<Corso>` per gestire i corsi
- `Map<String, List<String>>` per associare corsi ai clienti iscritti
- Metodi per aggiungere corsi, gestire prenotazioni, generare report

### Classi di Supporto

#### 6. Classe `Cliente`

- Attributi: `nome`, `cognome`, `email`, `dataIscrizione`
- Metodi: costruttore, getter/setter, `toString()`, `equals()`

#### 7. Implementazione Interfacce

- `CorsoCardio`: implementa `Prenotabile` e `Statistiche`
- `CorsoForza`: implementa `Prenotabile` e `Statistiche`
- `CorsoYoga`: implementa solo `Prenotabile`

### Casi d'Uso da Implementare

1. **Caricamento Corsi**: Leggere il file CSV e creare i corsi appropriati
2. **Gestione Prenotazioni**: Permettere ai clienti di prenotarsi ai corsi
3. **Controllo Disponibilità**: Verificare posti disponibili per ogni corso
4. **Generazione Report**: Creare file CSV con statistiche dei corsi
5. **Gestione Eccezioni**: Gestire tutti i casi di errore

### Esempio di Utilizzo

```java
public class Main {
    public static void main(String[] args) {
        GestorePalestra gestore = new GestorePalestra();

        try {
            // Carica corsi da file
            gestore.caricaCorsi("corsi.csv");

            // Prenota alcuni clienti
            gestore.prenotaCliente("Spinning", "Marco Bianchi");
            gestore.prenotaCliente("Hatha Yoga", "Sara Rossi");

            // Genera report
            gestore.generaReport("statistiche.csv");

            // Mostra info corsi
            gestore.mostraCorsiDisponibili();

        } catch (CorsoNonTrovatoException | PostiEsauritiException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
```

### Metodi Richiesti per GestorePalestra

```java
public class GestorePalestra {
    // Carica corsi da file CSV
    public void caricaCorsi(String nomeFile) throws FileFormatoException

    // Prenota cliente a un corso
    public void prenotaCliente(String nomeCorso, String nomeCliente)
        throws CorsoNonTrovatoException, PostiEsauritiException

    // Trova corso per nome
    public Corso trovaCorso(String nome) throws CorsoNonTrovatoException

    // Genera report statistiche
    public void generaReport(String nomeFile)

    // Mostra corsi con posti disponibili
    public void mostraCorsiDisponibili()

    // Ottieni lista clienti per corso
    public List<String> getClientiCorso(String nomeCorso)
}
```

### Esempio di Output Atteso

```txt
=== CORSI DISPONIBILI ===
Spinning (Cardio) - Istruttore: Mario Rossi
Durata: 45 min, Costo: 25.0€, Posti: 18/20

Sollevamento (Forza) - Istruttore: Luigi Bianchi
Durata: 60 min, Costo: 30.0€, Posti: 12/15

Hatha Yoga (Yoga) - Istruttore: Anna Verdi
Durata: 90 min, Costo: 20.0€, Posti: 10/12
```
