---
layout: post
title: "Traccia 17 Marzo 2025"
date: 2025-03-17
---

## Sistema di Gestione Concessionario Automobilistico

Si richiede di sviluppare un sistema di gestione per un concessionario automobilistico che comprenda la gestione dei veicoli in vendita e a noleggio. Il sistema deve essere implementato in Java utilizzando i concetti di ereditarietà, polimorfismo e interfacce.

### Parte 1: Gestione Veicoli

1. Definire una classe `Veicolo` che rappresenti un'automobile con i seguenti attributi:
   1. targa (string)
   2. marca (string)
   3. modello (string)
   4. anno di immatricolazione (int)
   5. prezzo (double)
2. Creare due classi derivate da `Veicolo`:
   1. `VeicoloVendita`:
      1. garanzia in anni (int)
      2. possibilità di finanziamento (boolean)
      3. nuovo o usato (boolean)
   2. `VeicoloNoleggio`:
      1. tariffa giornaliera (double)
      2. cauzione richiesta (double)
      3. assicurazione inclusa (boolean)
3. Implementare una classe `ParcoAuto` che gestisca l'elenco dei veicoli disponibili nel concessionario. Questa classe deve contenere un elenco di veicoli, consentire l'aggiunta e la rimozione di veicoli, aggiornare le informazioni e fornire metodi per visualizzare i veicoli disponibili per vendita o noleggio.
4. Implementare un'interfaccia `GestioneDati` con metodi per la lettura e la scrittura su file.
5. Modificare la classe `ParcoAuto` in modo che implementi l'interfaccia `GestioneDati` per salvare e caricare l'elenco dei veicoli da un file di testo.

### Parte 2: Gestione Contratti

1. Creare una classe `Contratto` che rappresenti un accordo commerciale. Deve contenere le seguenti informazioni:
   1. data
   2. cliente
   3. veicolo coinvolto.
2. Implementare due classi derivate:
   1. `ContrattoVendita` include:
      1. sconto (double)
      2. modalità di pagamento (string)
      3. prezzo finale (double)
   2. `ContrattoNoleggio` include:
      1. data di inizio
      2. data fine
      3. importo totale (double)
3. Implementare una classe `GestioneContratti` che gestisca i contratti stipulati. Deve consentire l'aggiunta di nuovi contratti, calcolare statistiche sulle vendite e noleggi e permettere la visualizzazione dei contratti attivi e conclusi.
4. Modificare la classe `GestioneContratti` in modo che implementi l'interfaccia `GestioneDati` per salvare e caricare i contratti da un file di log.

### Parte 3: Test

Creare una classe di test `ConcessionarioTest` che esegua i seguenti test:

1. Aggiunta di veicoli al sistema (sia per vendita che noleggio).
2. Salvataggio e caricamento dell'elenco dei veicoli da un file.
3. Creazione di contratti di vendita e noleggio.
4. Calcolo delle statistiche (fatturato totale, numero di veicoli venduti/noleggiati).
5. Salvataggio dei contratti su un file di log.

### File di esempio per i Veicoli (veicoli.txt):

```
tipo,targa,marca,modello,anno,prezzo,garanzia,finanziamento,nuovo,giornaliera,cauzione,assicurazione
VeicoloVendita,AB123CD,Fiat,Panda,2023,15000,3,true,false,,,
VeicoloVendita,EF456GH,Volkswagen,Golf,2024,28000,5,true,true,,,
VeicoloNoleggio,IJ789KL,Ford,Focus,2022,,,,,50,1000,true
VeicoloNoleggio,MN012OP,Audi,A3,2023,,,,,60,1200,false
```

### File di output per i Contratti (contratti.txt):

```
VENDITA,2025-03-10
Cliente: Mario Rossi, CF: RSSMRA80A01H501Z
Veicolo: Fiat Panda (AB123CD)
Prezzo: 14200€ (Sconto: 800€)
Modalità pagamento: Finanziamento

NOLEGGIO,2025-03-12,2025-03-19
Cliente: Laura Bianchi, CF: BNCLRA75B02H501Y
Veicolo: Ford Focus (IJ789KL)
Tariffa: 50€/giorno, Totale: 350€
Assicurazione: Inclusa

VENDITA,2025-03-15
Cliente: Paolo Verdi, CF: VRDPLA82C03H501X
Veicolo: Volkswagen Golf (EF456GH)
Prezzo: 26500€ (Sconto: 1500€)
Modalità pagamento: Contanti

STATISTICHE:
Veicoli venduti: 2, Fatturato vendite: 40700€
Veicoli noleggiati: 1, Fatturato noleggi: 350€
```
