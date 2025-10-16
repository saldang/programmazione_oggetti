---
layout: post
title: "16 Ottobre 2025"
date: 2025-10-16
---

## Sistema di Gestione di un Parco Veicoli 🚗

Sviluppare un'applicazione in Java per la gestione del parco veicoli di una società di noleggio. Il sistema deve essere in grado di gestire diverse tipologie di veicoli, calcolare i costi di noleggio, gestire la manutenzione e salvare lo stato del parco veicoli su file di testo.

### Sezione 1: Struttura delle Classi (Ereditarietà e Classi Astratte)

1. **Classe Astratta `Veicolo`:**
    Creare una classe astratta `Veicolo` che rappresenti le proprietà e i comportamenti comuni a tutti i veicoli. La classe deve avere i seguenti attributi `protected`:

      * `targa` (String)
      * `marca` (String)
      * `modello` (String)
      * `annoImmatricolazione` (int)
      * `costoNoleggioGiornaliero` (double)

    La classe deve includere:

      * Un costruttore per inizializzare tutti gli attributi.
      * Metodi `get` per tutti gli attributi.
      * Un metodo astratto `public double calcolaCostoNoleggio(int giorni)`.
      * Un `override` del metodo `toString()` che restituisca una stringa formattata con le informazioni comuni del veicolo.

2. **Sottoclassi `Automobile` e `Furgone`:**
    Creare due classi concrete che estendono `Veicolo`:

      * **`Automobile`**:

          * Attributi aggiuntivi `private`: `numeroPosti` (int), `tipologia` (String, es. "Utilitaria", "SUV", "Berlina").
          * Costruttore che chiami il costruttore della superclasse e inizializzi i nuovi attributi.
          * Implementazione del metodo `calcolaCostoNoleggio(int giorni)`: Se il numero di giorni di noleggio è superiore a 7, viene applicato uno sconto del 10% sul costo totale.
          * Override del metodo `toString()` che aggiunga le informazioni specifiche dell'automobile a quelle del veicolo.

      * **`Furgone`**:

          * Attributi aggiuntivi `private`: `capacitaCaricoKg` (double).
          * Costruttore che chiami il costruttore della superclasse e inizializzi il nuovo attributo.
          * Implementazione del metodo `calcolaCostoNoleggio(int giorni)`: Al costo totale viene aggiunto un supplemento fisso di 20.50 € per ogni giorno di noleggio, indipendentemente dalla durata.
          * Override del metodo `toString()` che aggiunga le informazioni specifiche del furgone.

### Sezione 2: Interfacce e Polimorfismo

1. **Interfaccia `Manutenibile`:**
    Creare un'interfaccia `Manutenibile` che definisca i comportamenti legati alla manutenzione dei veicoli. L'interfaccia deve dichiarare i seguenti metodi:

      * `void eseguiManutenzione()`
      * `boolean necessitaManutenzione()`

2. **Implementazione dell'Interfaccia:**
    Modificare la classe astratta `Veicolo` affinché implementi l'interfaccia `Manutenibile`.

      * Aggiungere un attributo `protected boolean inManutenzione`.
      * Implementare `eseguiManutenzione()` in modo che imposti `inManutenzione` a `true`.
      * Il metodo `necessitaManutenzione()` deve rimanere **astratto**, lasciando alle sottoclassi il compito di definire i criteri specifici.

3. **Implementazione nelle Sottoclassi:**
    Implementare il metodo `necessitaManutenzione()` in `Automobile` e `Furgone`:

      * Per `Automobile`: necessita di manutenzione se l'anno di immatricolazione è antecedente al 2020.
      * Per `Furgone`: necessita di manutenzione se la sua capacità di carico supera i 1000 kg.

### Sezione 3: Gestione delle Eccezioni

1. **Eccezione Personalizzata `TargaInvalidaException`:**
    Creare una *checked exception* personalizzata chiamata `TargaInvalidaException` che estende `Exception`. Questa eccezione verrà lanciata quando si tenta di creare un veicolo con una targa non valida.

2. **Validazione nel Costruttore:**
    Modificare il costruttore della classe `Veicolo` in modo che validi il formato della targa. Una targa è considerata valida se è composta da 7 caratteri alfanumerici (es. "AB123CD").
    Se la targa non è valida, il costruttore deve lanciare una `TargaInvalidaException`.

### Sezione 4: Lettura e Scrittura su File

1. **Classe `GestioneParcoVeicoli`:**
    Creare una classe `GestioneParcoVeicoli` che gestisca una collezione di veicoli.
      * Attributi: `private List<Veicolo> parcoVeicoli`.
      * Metodi:
          * `aggiungiVeicolo(Veicolo v)`: aggiunge un veicolo alla lista.
          * `stampaVeicoli()`: stampa i dettagli di tutti i veicoli nel parco utilizzando il polimorfismo (richiamando il metodo `toString()` di ogni oggetto).
          * `caricaVeicoliDaFile(String nomeFile)`:
              * Legge i dati dei veicoli da un file di testo. Ogni riga rappresenta un veicolo e i dati sono separati da virgole.
              * Il formato della riga è: `TIPO,targa,marca,modello,anno,costoGiornaliero,attributoSpecifico1,attributoSpecifico2`
              * Esempi di righe nel file `veicoli.txt`:

                ```csv
                AUTO,AB123CD,Fiat,Panda,2021,35.0,5,Utilitaria
                FURGONE,XY987ZW,Ford,Transit,2019,80.0,1200.0
                AUTO,GH456JK,BMW,X3,2018,95.5,5,SUV
                ```

              * Il metodo deve creare l'oggetto corretto (`Automobile` o `Furgone`) in base al primo campo (`TIPO`).
              * Deve gestire eventuali `IOException` durante la lettura del file e `TargaInvalidaException` durante la creazione degli oggetti. Le eccezioni devono essere gestite con messaggi di errore appropriati, senza interrompere il caricamento degli altri veicoli validi.
          * `salvaManutenzioniSuFile(String nomeFile)`:
              * Scrive su un file di testo l'elenco delle targhe di tutti i veicoli che necessitano di manutenzione (`necessitaManutenzione()` restituisce `true`).
              * Ogni targa deve essere scritta su una nuova riga.
              * Deve gestire eventuali `IOException` durante la scrittura.

### Sezione 5: Classe Main di Test

Creare una classe `Main` con un metodo `main` che dimostri il funzionamento di tutte le funzionalità implementate.

1. Creare un'istanza di `GestioneParcoVeicoli`.
2. Invocare il metodo `caricaVeicoliDaFile("veicoli.csv")` per popolare il parco veicoli. Assicurarsi di aver creato un file `veicoli.csv` con dati di test validi e non validi (es. una targa errata) per testare la gestione delle eccezioni.
3. Stampare a console l'elenco completo dei veicoli caricati correttamente.
4. Per ogni veicolo nel parco, calcolare e stampare il costo di un noleggio di 10 giorni.
5. Invocare il metodo `salvaManutenzioniSuFile("manutenzioni.txt")` per generare il report dei veicoli da manutenere.
6. Verificare che il file `manutenzioni.txt` sia stato creato correttamente.

### Dettagli Aggiuntivi

* Per la verifica della validità della targa, si può utilizzare una regex: `^[A-Z]{2}[0-9]{3}[A-Z]{2}$` con `.matches()`.

```java
String regexTarga = "^[a-zA-Z0-9]{7}$";

if (!targa.matches(regexTarga)){
    ...
    }
```
