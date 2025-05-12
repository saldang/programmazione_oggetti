---
layout: post
title: "Traccia 12 Maggio 2025"
date: 2025-05-12
---

## Sistema Gestione Esami Universitari

Progettare un sistema Java per la gestione degli esami universitari, in grado di rappresentare esami di diverso tipo, registrarli, calcolarne la media, salvarli su file e leggere da file le specifiche. Il sistema dovrà gestire anche errori comuni tramite eccezioni personalizzate.

### Requisiti

- Classe astratta Esame: contiene informazioni comuni a tutti gli esami

  - Attributi:
    - String nomeCorso
    - String docente
    - int voto (compreso tra 18 e 30)
  - Metodi:
    - abstract double calcolaPeso() – restituisce il peso in media ponderata
    - abstract String descrizione()

- Sottoclassi concrete: implementano tipi diversi di esame

  - EsameOrale
    - Aggiunge l’attributo durataMinuti
    - Il peso è calcolato come: `voto * (durataMinuti/60.0)`

  - EsameScritto
    - Aggiunge l’attributo numeroDomande
    - Il peso è calcolato come: `voto * log(numeroDomande)`

  - EsameLaboratorio
    - Aggiunge boolean progettoConsegnato
    - Il peso è calcolato come `voto * 1.5` se progetto consegnato, altrimenti `voto * 0.8`

  Tutte le sottoclassi devono sovrascrivere descrizione().

- Interfaccia Valutabile
  - double calcolaMediaPonderata(List\<Esame\> esami);

- Classe LibrettoUniversitario

  - Attributi:
    - List\<Esame\> esami
  - Metodi:
    - void aggiungiEsame(Esame e)
    - void caricaEsamiDaFile(String nomeFile) – crea istanze dinamicamente da file
    - void salvaEsami(String nomeFile)
    - void stampaReport() – mostra nome corso, voto, tipo esame, descrizione

- Eccezione Personalizzata EsameNonValidoException:
  Lanciata se:
  - Il voto è < 18 o > 30
  - Parametri incoerenti (es. domande < 1, durata < 0)

- Classe MainEsami

  - Legge il file di input
  - Costruisce dinamicamente gli oggetti
  - Calcola e stampa la media ponderata
  - Stampa la descrizione per ogni esame
  - Salva i dati su file report_esami.txt

File di input per test:

- [input1](./input_esami_1.txt)
- [input2](./input_esami_2.txt)
- [input3](./input_esami_3.txt)

Output atteso:

- [output1](./output_esami_1.txt)
- [output2](./output_esami_2.txt)
- [output3](./output_esami_3.txt)
