# Traccia 25 Settembre 2024

## Sistema di Gestione Corsi ed Esami

Si richiede di sviluppare un sistema di gestione per uno studente universitario che comprenda la gestione dei corsi seguiti e degli esami sostenuti. Il sistema deve essere implementato in Java utilizzando i concetti di ereditarietà, polimorfismo e interfacce.

### Parte 1: Gestione Corsi

Definire una classe **Corso** che rappresenti un corso universitario con attributi come codice del corso, nome, numero di crediti e docente.

Creare due classi derivate da Corso: **CorsoTeorico** e **CorsoPratico**. I corsi teorici devono avere un attributo aggiuntivo, come la modalità di esame (orale, scritto), mentre i corsi pratici possono avere attributi specifici come il numero di laboratori.

Implementare una classe **GestioneCorsi** che gestisca l’elenco dei corsi seguiti dallo studente. Questa classe deve contenere un elenco di corsi, consentire l’aggiunta e la rimozione di corsi, aggiornare le informazioni sui corsi e fornire un metodo per visualizzare i corsi iscritti.

Implementare un’interfaccia **GestioneFile** con metodi per la lettura e la scrittura su file.

Modificare la classe **GestioneCorsi** in modo che implementi l’interfaccia GestioneFile per salvare e caricare l’elenco dei corsi seguiti da un file di testo.

### Parte 2: Gestione Esami

Creare una classe **Esame** che rappresenti un esame sostenuto. Deve contenere informazioni sulla data, sul voto ottenuto, e sul corso a cui l’esame si riferisce.

Implementare una classe **GestioneEsami** che gestisca gli esami sostenuti dallo studente. Deve consentire l’aggiunta di esami, calcolare la media dei voti e permettere la visualizzazione degli esami sostenuti.

Modificare la classe **GestioneEsami** in modo che implementi l’interfaccia GestioneFile per salvare e caricare gli esami da un file di log.

### Parte 3: Test

Creare una classe di test StudenteTest che esegua i seguenti test:

- Aggiunta di corsi al sistema.
- Salvataggio e caricamento dell’elenco dei corsi da un file.
- Aggiunta di esami sostenuti.
- Calcolo della media dei voti.
- Salvataggio degli esami su un file di log.

**Buon lavoro!
**
File di output per i Corsi (corsi.txt):

```plaintext
CorsoTeorico,001,Programmazione,9,Prof. Rossi,Scritto
CorsoTeorico,002,Matematica,6,Prof. Bianchi,Orale
CorsoPratico,101,InformaticaLaboratorio,6,Prof. Verdi,5
CorsoPratico,102,FisicaLaboratorio,3,Prof. Neri,3
```

File di output per gli Esami (esami.txt):

```plaintext
2024-09-15
Corso,Programmazione,9,Voto: 28
Corso,Matematica,6,Voto: 30
Media Voti: 29

2024-09-25
Corso,InformaticaLaboratorio,6,Voto: 25
Corso,FisicaLaboratorio,3,Voto: 27
Media Voti: 26
```

### Parte Teorica

**Domande:**

1. **Ereditarietà:**

   - Che cos'è l'ereditarietà in Java? Fornisci un esempio pratico.
   - Qual è la differenza tra una classe astratta e un'interfaccia?

2. **Polimorfismo:**

   - Cos'è il polimorfismo in Java? Spiega con un esempio.
   - Come viene implementato il polimorfismo durante l'esecuzione?

3. **Interfacce:**

   - Quali sono le principali caratteristiche delle interfacce in Java?
   - Può una classe implementare più interfacce? Se sì, fornisci un esempio.

4. **Eccezioni e Gestione degli Errori:**

   - Cos'è un'eccezione in Java? Come si gestiscono le eccezioni?
   - Qual è la differenza tra `throw` e `throws`?

5. **Lettura e Scrittura su File:**
   - Come si legge da un file in Java? Fornisci un esempio di codice.
   - Come si scrive su un file in Java? Fornisci un esempio di codice.
