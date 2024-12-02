# Traccia 16 Settembre 2024

## Caffetteria e Gestione dell'Inventario

Si richiede di sviluppare un sistema di gestione per una caffetteria che comprenda la gestione dell'inventario degli articoli e delle vendite al banco. Il sistema deve essere implementato in Java utilizzando i concetti di ereditarietà, polimorfismo e interfacce.

### Parte 1: Inventario

Definire una classe astratta **Articolo** che rappresenti un prodotto venduto in caffetteria con attributi come codice, nome, prezzo e quantità in inventario.

Creare almeno due classi derivate da **Articolo**: **Bevanda** e **Snack**. Le bevande devono avere un attributo aggiuntivo come la **dimensione** (es. piccola, media, grande), mentre gli snack possono avere attributi specifici come la **data di scadenza**.

Implementare una classe **Inventario** che gestisca l'elenco degli articoli. Questa classe deve contenere un elenco di articoli, consentire l'aggiunta e la rimozione di articoli, aggiornare le quantità e fornire un metodo per visualizzare l'inventario corrente.

Implementare un'interfaccia **GestioneFile** con metodi per la lettura e la scrittura su file.

Modificare la classe **Inventario** in modo che implementi l'interfaccia **GestioneFile** per salvare e caricare l'inventario da un file di testo.

### Parte 2: Vendita al Banco

Creare una classe **Ordine** che rappresenti una vendita al banco. Deve contenere informazioni sulla data, gli articoli venduti e il totale della vendita.

Implementare una classe **Cassa** che gestisca gli ordini al banco. Deve consentire l'aggiunta di articoli all'ordine corrente, calcolare il totale della vendita e registrare l'ordine completato.

Modificare la classe **Cassa** in modo che implementi l'interfaccia **GestioneFile** per salvare e caricare gli ordini da un file di log.

### Parte 3: Test

Creare una classe di test **CaffetteriaTest** che esegua i seguenti test:

- Aggiunta di articoli all'inventario.
- Salvataggio e caricamento dell'inventario da un file.
- Aggiunta di articoli all'ordine di vendita.
- Calcolo del totale dell'ordine.
- Salvataggio degli ordini su un file.
- Salvataggio inventario aggiornato (quantita' diminuita) su un file.

Commentare il codice e fornire spiegazioni per ogni classe e metodo.

Nota: Assicurarsi di utilizzare i principi della programmazione ad oggetti in modo appropriato, come l'ereditarietà e il polimorfismo, e gestire le eccezioni in modo adeguato durante la lettura/scrittura su file.

Buon lavoro!

---

### File di output per l'Inventario (inventario.txt):

```txt
Bevanda,001,Caffe,1.50,100,Piccola
Bevanda,002,Cappuccino,2.50,80,Media
Snack,101,Croissant,1.80,50,2024-12-31
Snack,102,TortaCioccolato,3.50,20,2024-10-15
```

### File di output per le Vendite (vendite.txt):

```txt
2024-09-25 09:30:00
Articolo,Codice,Quantità,PrezzoUnitario,Totale
Caffe,001,2,1.50,3.00
Croissant,101,1,1.80,1.80
Totale Vendita: 4.80

2024-09-25 14:15:30
Articolo,Codice,Quantità,PrezzoUnitario,Totale
Cappuccino,002,1,2.50,2.50
TortaCioccolato,102,2,3.50,7.00
Totale Vendita: 9.50
```

### Domande di Teoria

- Spiega il concetto di ereditarietà in Java e descrivi in che modo essa consente di riutilizzare il codice. Fornisci un esempio pratico in cui l'ereditarietà può migliorare l'organizzazione del codice.
- Che cos'è il polimorfismo in Java? Spiega la differenza tra polimorfismo statico (overloading) e polimorfismo dinamico (overriding), fornendo un esempio per ciascun tipo.
- Come viene gestita la gestione delle eccezioni in Java? Descrivi la differenza tra eccezioni controllate (checked) e non controllate (unchecked). Quando è appropriato usare `try-catch` e quando è preferibile propagare l'eccezione?
- Quali sono i principali modificatori di accesso in Java (es. `public`, `private`, `protected`, e il modificatore di default)? Spiega come ciascuno di essi controlla la visibilità dei membri di una classe all'interno dello stesso package e tra package diversi.
- Spiega il concetto di interfaccia in Java. Quali sono le principali differenze tra un'interfaccia e una classe astratta? In quali situazioni utilizzeresti un'interfaccia invece di una classe astratta?

File Java:

- [Articolo.java](./Articolo.java)
- [ArticoloNonPresenteException.java](./ArticoloNonPresenteException.java)
- [Bevanda.java](./Bevanda.java)
- [Cassa.java](./Cassa.java)
- [GestioneFile.java](./GestioneFile.java)
- [Inventario.java](./Inventario.java)
- [Ordine.java](./Ordine.java)
- [Snack.java](./Snack.java)
- [TestCaffetteria.java](./TestCaffetteria.java)
