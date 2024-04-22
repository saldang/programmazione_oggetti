# Esame di Programmazione ad Oggetti in Java

## Istruzioni:

* Leggi attentamente ogni domanda prima di rispondere.
* Assicurati di fornire una soluzione completa per ciascun problema.
* Scrivi codice pulito e ben documentato.

### Domanda 1: Ereditarietà (4 punti)

Scrivi una classe **Veicolo** con i seguenti attributi e metodi:

**Attributi**:
* targa (una stringa che rappresenta la targa del veicolo)
* marca (una stringa che rappresenta la marca del veicolo)

**Metodi**:
* Un costruttore che accetta la targa e la marca come argomenti.
* getTarga(): restituisce la targa del veicolo.
* getMarca(): restituisce la marca del veicolo.
  
Successivamente, crea una classe **Auto** che estende **Veicolo** e ha un attributo aggiuntivo *modello*. Implementa i metodi necessari per ottenere e impostare il modello dell'auto.

### Domanda 2: Polimorfismo (6 punti)

Scrivi una classe **Garage** che può contenere una serie di veicoli. Implementa un metodo *stampaVeicoli()* che accetta una lista di veicoli e stampa le informazioni di ciascun veicolo, inclusa la targa, la marca e il modello (se è un'auto).

Utilizza il polimorfismo per consentire al metodo *stampaVeicoli()* di funzionare correttamente sia per oggetti di tipo Veicolo che per oggetti di tipo Auto.

### Domanda 3: I/O da file CSV (8 punti)

Supponi di avere un file CSV chiamato **veicoli.csv** con il seguente formato:

```csv 
Targa,Marca,Modello
ABC123,Toyota,Corolla
XYZ789,Honda,Civic
LMN456,Ford,Focus
```

Scrivi un programma Java che legge questo file CSV e crea una lista di oggetti Auto (utilizzando la classe Auto definita nella Domanda 1) dai dati del file. Successivamente, stampa le informazioni di ciascuna auto nella lista.

### Domanda 4: Interfaccia Comparable (9 punti)

Aggiungi un'implementazione dell'interfaccia *Comparable* alla classe Auto. Gli oggetti Auto dovrebbero essere confrontati in base al modello in ordine crescente. Quindi, implementa un metodo che accetti una lista di auto e le ordini in base al modello utilizzando il metodo **Arrays.sort()**.

Fornisci un esempio di utilizzo del metodo di ordinamento con un elenco di auto e stampa la lista ordinata.

## Valutazione:

4 punti per la corretta implementazione dell'ereditarietà e dei metodi richiesti per la classe Veicolo e Auto.
6 punti per la corretta implementazione del polimorfismo nella classe Garage.
8 punti per la lettura del file CSV e la creazione della lista di oggetti Auto.
9 punti per l'implementazione dell'interfaccia Comparable e il corretto ordinamento delle auto.
3 punti per la chiarezza del codice, la documentazione e la formattazione.

Buona fortuna nell'esame!