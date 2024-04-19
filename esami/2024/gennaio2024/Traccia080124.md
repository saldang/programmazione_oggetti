# Traccia d'esame

## 08 Gennaio 2024

**Obiettivo**: Implementare un sistema per la gestione di una libreria digitale. La libreria deve essere in grado di gestire diverse tipologie di risorse digitali, tra cui libri e audiolibri. Ogni risorsa ha informazioni specifiche come titolo, autore, anno di pubblicazione, ecc.

1. Creare una classe astratta RisorsaDigitale che contenga i seguenti attributi:
   * **titolo** (String)
   * **annoPubblicazione** (int)
   * **autore** (String)
   * Almeno un metodo astratto **mostraDettagli()** che verrà implementato nelle classi figlie.
2. Creare due classi concrete che estendano RisorsaDigitale:
   * **Libro**: Deve avere un attributo aggiuntivo **numeroPagine** (int) e implementare il metodo **mostraDettagli()** per visualizzare tutte le informazioni del libro.
   * **Audiolibro**: Deve avere un attributo aggiuntivo durata (int in minuti) e implementare il metodo **mostraDettagli()** per visualizzare tutte le informazioni dell'audiolibro.
3. Definire un'interfaccia GestioneFile con i seguenti metodi:
   * **scriviSuFile(String nomeFile)**: Scrive il contenuto su un file con il nome specificato.
   * **leggiDaFile(String nomeFile)**: String: Legge il contenuto da un file con il nome specificato e restituisce il testo letto.
4. Creare una classe **GestoreLibreria** che implementi l'interfaccia **GestioneFile** e gestisca un elenco di risorse digitali (libri e audiolibri). La classe deve fornire i seguenti metodi:
   * aggiungiRisorsa(RisorsaDigitale risorsa): Aggiunge una risorsa all'elenco.
   * mostraElencoRisorse(): Mostra l'elenco completo di risorse digitali con tutti i dettagli.
   * scriviSuFile(String nomeFile): Salva l'elenco di risorse su un file.
   * leggiDaFile(String nomeFile): Carica l'elenco di risorse da un file.
   * modificaRisorsa(String titolo, RisorsaDigitale nuovaRisorsa): Modifica una risorsa esistente.
  
Nel metodo main della classe principale:

* Creare un oggetto GestoreLibreria.
* Leggere il contenuto del file "libreria.csv" e aggiungere le risorse all'elenco.
* Aggiungere almeno due libri e due audiolibri.
* Visualizzare l'elenco completo di risorse.
* Salvare l'elenco su un file.
* Caricare l'elenco da un file.
* Modificare almeno una risorsa esistente.
* Visualizzare l'elenco aggiornato.
* Salvare nuovamente l'elenco su un file.

File di archivio "libreria.csv" (separatore virgola):

```csv
tipo,titolo,autore,annoPubblicazione,numeroPagine,durata
Libro,Il Signore degli Anelli,J.R.R. Tolkien,1954,1178,
Audiolibro,Harry Potter e la Pietra Filosofale,J.K. Rowling,1997,,450
Libro,1984,George Orwell,1949,328,
Audiolibro,Il Codice da Vinci,Dan Brown,2003,,560
Libro,La Ragazza di Fuoco,Suzanne Collins,2009,391,
```

Risorse da aggiungere:
```text
Libro,Il Trono di Spade,George R.R. Martin,1996,694,
Audiolibro,Il Trono di Spade,George R.R. Martin,1996,,600
Libro,Il Conte di Montecristo,Alexandre Dumas,1844,1276,
Audiolibro,Il Conte di Montecristo,Alexandre Dumas,1844,,1200
```

Risorsa da modificare:
```text
Libro,1984,George Orwell,1949,338,
```
File di archivio "libreria.csv" aggiornato:
```csv
tipo,titolo,autore,annoPubblicazione,numeroPagine,durata
Libro,Il Signore degli Anelli,J.R.R. Tolkien,1954,1178,
Audiolibro,Harry Potter e la Pietra Filosofale,J.K. Rowling,1997,,450
Libro,1984,George Orwell,1949,338,
Audiolibro,Il Codice da Vinci,Dan Brown,2003,,560
Libro,La Ragazza di Fuoco,Suzanne Collins,2009,391,
Libro,Il Trono di Spade,George R.R. Martin,1996,694,
Audiolibro,Il Trono di Spade,George R.R. Martin,1996,,600
Libro,Il Conte di Montecristo,Alexandre Dumas,1844,1276,
Audiolibro,Il Conte di Montecristo,Alexandre Dumas,1844,,1200
```
