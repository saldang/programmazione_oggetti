# 040923

## Traccia 04 Settembre 2023

### Sistema di gestione veicoli con polimorfismo, ereditarietà e interfaccia Cloneable

**Descrizione**:

Definisci una classe astratta chiamata Veicolo che implementi l'interfaccia Cloneable. Questa classe dovrebbe avere i seguenti attributi:

* targa (una stringa per identificare il veicolo)
* marca (una stringa che indica la marca del veicolo)
  
Aggiungi un costruttore alla classe Veicolo per inizializzare i suoi attributi.

Definisci due sottoclassi di Veicolo: Automobile e Moto. Entrambe queste classi dovrebbero estendere Veicolo e aggiungere attributi specifici:

Per Automobile: numeroPorte (un intero che rappresenta il numero di porte)
Per Moto: cilindrata (un intero che rappresenta la cilindrata)

Implementa il metodo clone() nell'interfaccia Cloneable in modo che possa essere utilizzato per clonare oggetti di tipo Veicolo.

Nel metodo main, leggi i dati da un file di testo chiamato veicoli.txt. Il file contiene una serie di righe, ognuna delle quali rappresenta un veicolo. Ogni riga contiene il tipo di veicolo (automobile o moto), la targa, la marca e altri attributi specifici del veicolo. Ad esempio:

```
automobile,AB123CD,Fiat,5
moto,XY456ZT,Honda,500
automobile,EF789GH,Alfa Romeo,3
moto,LM012NP,Kawasaki,1000
```

Dopo aver letto i dati dal file, crea un elenco di oggetti Veicolo e aggiungi ogni veicolo letto dal file all'elenco. Infine, utilizza il metodo clone() per creare una copia di ogni veicolo nell'elenco e aggiungi la copia all'elenco.

Stampa l'elenco originale e l'elenco clonato per verificare che i veicoli siano stati clonati correttamente.

Nota:

Assicurati di gestire le eccezioni che possono verificarsi durante la clonazione.
Questo esercizio richiede di utilizzare polimorfismo per lavorare con oggetti di tipo Veicolo, ereditarietà per definire sottoclassi specifiche e l'interfaccia Cloneable per consentire la clonazione degli oggetti.


