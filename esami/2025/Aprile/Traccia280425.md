---
layout: post
title: "Traccia 28 Aprile 2025"
date: 2025-04-28
---

## La Gara degli Animali Magici

### Obiettivo

Sviluppare un’applicazione Java che modelli una gara tra animali magici, utilizzando concetti di ereditarietà, polimorfismo, interfacce, gestione delle eccezioni e lettura/scrittura di file.

### Parte 1: Modellazione delle Classi

#### Classe Astratta AnimaleMagico

1. Attributi:
   1. String nome
   2. int eta
   3. double velocitaBase (in km/h)
2. Metodi:
   1. abstract double calcolaTempoPercorrenza(double distanzaK) (Calcola il tempo necessario a percorrere una distanza data)
   2. String descrizione() (Restituisce una breve descrizione dell’animale)

#### Classi Derivate

Creare tre classi concrete che estendono AnimaleMagico:

1. Drago
   1. Attributo aggiuntivo: boolean soffiaFuoco
   2. Se soffiaFuoco == true e distanza > 100 km, la velocità aumenta del 20%.
2. Unicorno
   1. Attributo aggiuntivo: boolean siStanca
   2. Se siStanca == true e distanza > 200 km, la velocità diminuisce del 10%.
3. Fenice
   1. Nessun attributo aggiuntivo.
   2. Quando percorre una distanza, rinasce a metà strada, dimezzando il tempo totale.

#### Interfaccia PotereMagico

1. Metodo:
   1. String usaPotere() (Restituisce una stringa che descrive l’uso di un potere speciale)
2. Implementazione dell’Interfaccia
   1. Ogni classe (Drago, Unicorno, Fenice) deve implementare l’interfaccia PotereMagico con una propria descrizione dell’incantesimo.

### Parte 2: Gestione della Gara

1. Classe GaraMagica
   1. Attributi:
      1. ArrayList \<AnimaleMagico\> partecipanti
   2. Metodi:
      1. void aggiungiAnimale(AnimaleMagico a)
      2. void simulaGara(double distanzaKm)
      3. Ogni animale calcola il proprio tempo di percorrenza.
      4. Ogni animale usa il suo potere magico (stampa a video).
      5. Viene determinato il vincitore (minore tempo).
      6. void salvaPartecipantiSuFile(String nomeFile)
      7. void caricaPartecipantiDaFile(String nomeFile)

### Parte 3: Gestione degli Errori

Eccezione Personalizzata AnimaleNonValidoException

* Deve essere lanciata:
  * Se si crea un animale con velocitaBase <= 0 o eta < 0.
  * Deve essere gestita all’interno di GaraMagica e della classe di test.

### Parte 4: Gestione File

* Tutte le operazioni di lettura e scrittura devono essere gestite usando try-catch appropriati.
* Se il file non esiste o il formato è errato, gestire l’errore stampando un messaggio significativo.

#### File di Input

```txt
Drago;Smaug;300;120;true
Unicorno;Stella;150;80;false
Fenice;Fiamma;500;150
Drago;Draconis;-20;110;true
Unicorno;Arcobaleno;100;70;true
```

Legenda:

* Tipo di animale (Drago, Unicorno, Fenice);
* Nome;
* Età (anni);
* Velocità base (km/h);
* Attributo specifico (solo per Drago e Unicorno).

Nota:

* I dati degli animali devono essere letti da questo file e caricati nella lista dei partecipanti.
* Se i dati sono errati (es. età negativa), deve essere sollevata un’eccezione.

### Parte 5: Classe di Test

Classe MainGara

* Legge gli animali da animali.txt caricandoli nella gara.
* Simula una gara su una distanza di 300 km.
* Stampa:
  * La descrizione di ogni animale.
  * Il potere usato da ogni animale.
  * Il tempo impiegato da ogni animale.
* Stampa il nome del vincitore.
* Salva i dati aggiornati dei partecipanti in animali_output.txt.
