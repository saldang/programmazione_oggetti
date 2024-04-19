Scrivere un programma che usi la classe Calcolatrice del Listato 13.12 per creare una calcolatrice più potente. Questa nuova calcolatrice deve fornire all’utente la possibilità di salvare un risultato in memoria e di poterlo riutilizzare in seguito. I comandi che la calcolatrice deve accettare sono i seguenti:

* f (fine) per terminare;
* c (cancella) per cancellare il risultato. Reimposta risultato a 0;
* s (salva) per salvare in memoria l’attuale valore di risultato;
* r (richiama) per richiamare il valore dalla memoria; visualizza il valore in memoria, ma non modifica il valore della variabile risultato.

Deve essere definita una classe derivata da Calcolatrice che abbia un’altra variabile di istanza per rappresentare la memoria, un nuovo metodo main che esegua la versione migliorata della calcolatrice, una ridefinizione del metodo gestisciOpSconosciutaException e tutto ciò che sarà necessario ridefinire o scrivere da zero. Di seguito è riportato un esempio di una possibile esecuzione della nuova calcolatrice. Il programma non deve produrre un output identico a quello riportato, ma deve essere simile e sufficientemente chiaro.

Output di esempio:
```bash
Calcolatrice attivata. 
risultato = 0.0 
+ 4 
risultato + 4.0 = 4.0 
risultato aggiornato = 4.0
/ 2 
risultato / 2.0 = 2.0
risultato aggiornato = 2.0
s risultato salvato in memoria
c
risultato = 0.0
+ 99
risultato + 99.0 = 99.0 
risultato aggiornato = 99.0 
/ 3 
risultato / 3.0 = 33.0 
risultato aggiornato = 33.0 
r 
valore richiamato dalla memoria = 2.0 
risultato = 33.0 + 2 
risultato + 2.0 = 35.0 
risultato aggiornato = 35.0 
f 
Fine del programma. 
```