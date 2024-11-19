---
layout: page
title: Esercitazione 18 Novembre 2024
permalink: /esercizi/AA24_25/Esercitazione181124/
---

## **Esercizio 1: Rubrica Contatti (File di Testo e Eccezioni)**

Creare un’applicazione che gestisce una rubrica, leggendo e scrivendo contatti in un file di testo.

1. **Crea una classe `Contatto`** con attributi `nome`, `cognome` e `numeroTelefono`.
2. **Crea una classe `Rubrica`** che gestisca un `ArrayList<Contatto>` e i seguenti metodi:
   - `aggiungiContatto(Contatto c)` per aggiungere un contatto alla rubrica.
   - `salvaSuFile(String percorsoFile)` per salvare i contatti in un file di testo (uno per riga, con i dati separati da `;`).
   - `leggiDaFile(String percorsoFile)` per caricare i contatti dal file di testo.
3. **Gestione delle eccezioni**:
   - Solleva un’eccezione personalizzata `ContattoDuplicatoException` se il contatto esiste già nella rubrica.
   - Gestisci eccezioni comuni come `IOException` durante la lettura/scrittura del file.
4. **Interazione con l’utente**:
   - Permetti all’utente di aggiungere contatti tramite input e di salvare o caricare i dati dal file.

File java:

- [Contatto.java](./Contatto.java)
- [Rubrica.java](./Rubrica.java)
- [Esercizio1.java](./Esercizio1.java)
- [ContattoDuplicatoException.java](./ContattoDuplicatoException.java)

---

## **Esercizio 2: Registro Studenti (File Binari)**

Creare un sistema che memorizza i dati degli studenti in un file binario.

1. **Crea una classe `Studente`** con attributi `id`, `nome`, `cognome`, e `mediaVoti`.
2. **Crea una classe `Registro`** che:
   - Contiene un `ArrayList<Studente>`.
   - Implementa metodi per aggiungere, cercare e visualizzare studenti.
   - Ha un metodo `salvaSuFileBinario(String percorsoFile)` per salvare l’elenco degli studenti in un file binario.
   - Ha un metodo `caricaDaFileBinario(String percorsoFile)` per caricare gli studenti da un file binario.
3. **Gestione delle eccezioni**:
   - Solleva un’eccezione personalizzata `StudenteNonTrovatoException` se si tenta di cercare uno studente che non esiste.
   - Gestisci eccezioni come `FileNotFoundException` o `ClassNotFoundException` durante la lettura/scrittura.
4. **Interazione con l’utente**:
   - Permetti di gestire l’elenco studenti e memorizzare i dati in un file binario.

File java:

- [Studente.java](./Studente.java)
- [Registro.java](./Registro.java)
- [StudenteNonTrovatoException.java](./StudenteNonTrovatoException.java)
- [StudenteDuplicatoException.java](./StudenteDuplicatoException.java)
- [Esercizio2.java](./Esercizio2.java)

---

### **Esercizio 3: Calcolatore Finanziario (File di Testo e Binari)**

Gestire operazioni finanziarie, memorizzandole in un file di testo per la leggibilità e in un file binario per l’efficienza.

1. **Crea una classe `Transazione`** con attributi `id`, `data`, `importo`, e `tipo` (es. `Entrata` o `Uscita`).
2. **Crea una classe `GestioneFinanziaria`** con:
   - Un `ArrayList<Transazione>` per memorizzare le transazioni.
   - Metodi per aggiungere transazioni, calcolare il saldo totale e visualizzare il report.
   - Un metodo `salvaTransazioniTesto(String percorsoFile)` per salvare le transazioni in formato testo.
   - Un metodo `salvaTransazioniBinario(String percorsoFile)` per salvare le transazioni in formato binario.
   - Metodi corrispondenti per leggere i dati dai file.
3. **Gestione delle eccezioni**:
   - Solleva un’eccezione personalizzata `SaldoNegativoException` se il saldo totale diventa negativo.
   - Gestisci eccezioni di lettura/scrittura (`IOException`, `EOFException`).
4. **Interazione con l’utente**:
   - Permetti di registrare transazioni, visualizzare il saldo corrente e generare un report (sia da file di testo che da file binari).

---

### **Esercizio 4: Analisi di File (Testo e Binario)**

Analizzare un file di testo e salvarne i risultati in un file binario.

1. **Crea una classe `AnalizzatoreFile`** con:
   - Un metodo `analizzaFile(String percorsoFileInput, String percorsoFileOutput)` che:
     - Legge un file di testo riga per riga.
     - Conta il numero di righe, parole e caratteri.
     - Scrive i risultati in un file binario sotto forma di un oggetto della classe `RisultatiAnalisi`.
2. **Gestione delle eccezioni**:
   - Gestisci eccezioni come `FileNotFoundException` e `EOFException`.
   - Solleva un’eccezione personalizzata `FileVuotoException` se il file di input è vuoto.
3. **Output**:
   - Leggi e stampa i risultati dal file binario per verificare che siano corretti.
