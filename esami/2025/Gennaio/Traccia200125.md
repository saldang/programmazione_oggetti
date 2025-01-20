---
layout: post
title: "Traccia 20 Gennaio 2025"
date: 2025-01-20
---

## Quiz Game

### Descrizione del Progetto

Il gioco consiste in una serie di domande a scelta multipla, dove il giocatore deve selezionare una risposta tra le opzioni proposte. Ogni domanda ha un punteggio associato, che viene assegnato in base alla risposta data. Alla fine del quiz, il giocatore riceve il punteggio totale ottenuto.

#### Componenti del Programma

1. **Classe `Question`**:

   - Campi:
     - String `questionText`
     - Map<String, Integer> `answers`, dove la chiave è l'opzione di risposta e il valore è il punteggio.
   - Metodi:
     - Costruttore per inizializzare le domande.
     - Metodo `displayQuestion()` per mostrare la domanda e le opzioni al giocatore.
     - Metodo `evaluateAnswer(String answer)` per valutare una risposta data.

2. **Classe `MultipleChoiceQuestion`** (eredita da `Question`):

   - Implementazione specifica per domande a scelta multipla.
   - Sovrascrittura del metodo `displayQuestion()` se necessario.

3. **Interfaccia `Scorable`**:

   - Metodo `getScore()`: restituisce il punteggio ottenuto per una domanda.

4. **Classe `QuizGame`**:

   - Gestisce la logica del gioco, inclusi i punteggi e le interazioni con l'utente.
   - Campi:
     - List<Question> `questions`
     - int `score`
   - Metodi:
     - `loadQuestions(String filePath)`: Legge le domande da un file e le inizializza.
     - `start()`: Inizia il quiz, gestendo l'interazione con l'utente.
     - `displayScore()`: Mostra il punteggio totale ottenuto.

5. **Classe principale (`Main`)**:
   - Crea un'istanza di `QuizGame`, carica le domande e avvia il gioco.

#### Istruzioni

1. **Struttura del File**: Il file delle domande e' un file CSV con i campi separati da virgola e i valori racchiusi tra virgolette.

2. **Interazione con l'Utente**: Il programma deve chiedere all'utente di selezionare un'opzione per ogni domanda e mostrare il punteggio totale al termine del quiz.

#### Compiti Specifici

- Implementare la classe `Question` con tutte le funzionalità richieste.
- Creare la classe derivata `MultipleChoiceQuestion`.
- Definire l'interfaccia `Scorable` e garantire che la classe `Question` la implementi correttamente.
- Implementare il meccanismo di lettura delle domande dal file usando un metodo in `QuizGame`.
- Gestire l'esecuzione del quiz tramite interazioni con l'utente.

#### File quiz.csv di esempio

```csv
Numero Domanda,Tipo Domanda,Quesito,A,B,C,D,Risposta Corretta,Punteggio
"1","MC","Cosa è un 'classe' in OOP?","Una singola istanza di un oggetto","Un gruppo di metodi senza attributi","Una definizione di tipo che può essere utilizzata per creare oggetti","Uno stato fisso dell'applicazione","c","3"
"2","MC","Che cos'è un 'oggetto' in OOP?","Un gruppo di variabili statiche","Una collezione di metodi pubblici","Una singola istanza di una classe","Il file sorgente di un programma",c,3
"3","MC","Che cos'è l''incapsulamento'?","La capacità di un oggetto di assumere diversi comportamenti","Il modo in cui gli oggetti sono organizzati in gerarchie","L'abbinamento dei dati e del codice che li manipola all'interno dello stesso oggetto","Nascondere dettagli interni di implementazione","c","3"
"4","MC","Cos'è l'ereditarietà in OOP?","Il processo di creazione di una nuova classe utilizzando esistenti classi come base","La capacità di un metodo di essere utilizzato con vari tipi di dati","L'organizzazione degli oggetti in gerarchie","Nascondere dettagli interni di implementazione","a","3"
"5","MC","Qual è il termine usato per una classe che estende un'altra classe?","Superclasse","Sottoclasse","Interfaccia","Metaclass","b","3"
"6","MC","Che differenza c'è tra 'override' e 'overloading'?","Override modifica il comportamento di un metodo, mentre overloading aggiunge nuovi metodi con lo stesso nome ma parametri diversi","Overload cambia l'implementazione di una classe intera, override cambia solo alcune parti","Override e overloading sono sinonimi","Overload è usato per le variabili, mentre override è per i metodi","a","3"
"7","MC","Che cos'è il polimorfismo in OOP?","La capacità di una funzione o metodo di avere più forme","L'incapsulamento dei dati e del codice all'interno di un oggetto","La struttura gerarchica tra classi","Il modo in cui i dettagli interni sono nascosti dall'utente","a","3"
"8","MC","Nel quale scenario viene utilizzato il polimorfismo?","Quando si definisce una nuova classe senza usare altre classi","Quando un metodo in una sottoclasse ha lo stesso nome di un metodo nella superclasse e ne modifica l'implementazione","Quando si incapsulano dati all'interno di una classe","Quando si scrivono metodi con lo stesso nome ma parametri diversi","b","3"
"9","MC","Qual è il ruolo principale delle interfacce in Java?","Per definire comportamenti che possono essere implementate da classi","Per creare istanze di oggetti","Per organizzare le classi in una gerarchia","Per incapsulare i dati all'interno di una classe","a","3"
"10","MC","Una classe può implementare più interfacce?","No, una classe può implementare solo un'interfaccia per volta.","Sì, ma non più di due interfacce","Sì, una classe può implementare qualsiasi numero di interfacce","Solo le classi astratte possono implementare interfacce","c","3"
```
