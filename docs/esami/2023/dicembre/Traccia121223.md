# Traccia 12 Dicembre 2023

Implementa le seguenti classi in Java per gestire un concessionario che vende e noleggia auto e moto:

### Classe Veicolo

Definisci una classe Veicolo con attributi marca e modello. Include un metodo descrizione che restituisce la concatenazione di marca e modello.

### Classe Auto

Estendi la classe Veicolo creando una classe Auto. Aggiungi i seguenti attributi: porte, prezzoVendita, prezzoNoleggio. Implementa metodi per ottenere e impostare il prezzo di vendita, prezzo noleggio. Sovrascrivi il metodo descrizione per includere anche il numero di porte,prezzoNoleggio e il prezzo di vendita.

### Classe Moto

Estendi la classe Veicolo creando una classe Moto. Aggiungi i seguenti attributi: cilindrata, prezzoVendita, prezzoNoleggio. Implementa metodi per ottenere e impostare il prezzo di noleggio e prezzo di vendita. Sovrascrivi il metodo descrizione per includere anche la cilindrata, il prezzoNoleggio e il prezzo di vendita.

### Classe Concessionario

Crea una classe Concessionario che gestisce un elenco di veicoli disponibili per la vendita e il noleggio. Implementa i seguenti metodi:
aggiungiVeicolo(Veicolo veicolo): Aggiunge un veicolo all'inventario del concessionario.
visualizzaInventario(): Stampa l'inventario completo del concessionario con tutte le informazioni sui veicoli.
acquistaVeicolo(Veicolo veicolo): Rimuove un veicolo dall'inventario del concessionario.
noleggiaVeicolo(Veicolo veicolo): Rimuove un veicolo dall'inventario del concessionario.
calcolaGuadagnoVendita(): Calcola e restituisce il guadagno dalla vendita dei veicoli.
calcolaGuadagnoNoleggio(): Calcola e restituisce il guadagno dal noleggio dei veicoli.
calcolaGuadagnoTotale(): Calcola e restituisce il guadagno totale del concessionario, sommando i guadagni dalla vendita e dal noleggio dei veicoli.

### Lettura da CSV

Implementa un metodo statico nella classe CsvReader che legge un file CSV contenente informazioni su veicoli e restituisce una lista di oggetti Veicolo. Usa questa lista per popolare l'inventario del concessionario.

## Istruzioni

Assicurati che il codice sia correttamente indentato e commentato.
Usa i principi di polimorfismo ed ereditarietà dove appropriato.
Gestisci eccezioni laddove necessario.
Testa il funzionamento del programma creando almeno un oggetto di ogni classe e eseguendo le operazioni richieste.
Completa l'implementazione del metodo di lettura da CSV per popolare l'inventario del concessionario.

```csv
marca,modello,tipo,porte,cilindrata,prezzo_vendita,prezzo_noleggio
Toyota,Corolla,Auto,4,,20000,200
Honda,CRV,Auto,5,,25000,250
BMW,R1200GS,Moto,,1200,15000,150
Ducati,Panigale,Moto,,1299,18000,180
```

https://rentry.co/traccia121223
