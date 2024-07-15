# Traccia 15 Luglio 2024

https://saldang.github.io/programmazione_oggetti/esami/2024/

## Parte Pratica

**Traccia:**

Scrivere un programma in Java che gestisca una libreria. Il programma deve permettere di:

1. Aggiungere nuovi libri.
2. Visualizzare i libri presenti.
3. Salvare i dati dei libri su un file txt.
4. Caricare i dati dei libri da un file txt.

Il programma deve utilizzare i concetti di polimorfismo, ereditarietà e interfacce. Di seguito sono fornite alcune specifiche:

1. **Classe Astratta Libro**:

   - Attributi: titolo, autore, ISBN.
   - Metodo astratto `getTipo()`: restituisce una stringa che rappresenta il tipo di libro (es. "Romanzo", "Manuale", etc.).
   - Metodo `toString()`: restituisce una stringa con le informazioni del libro.

2. **Classi Concrete**:

   - **Romanzo**: estende `Libro` e aggiunge un attributo `genere`.
   - **Manuale**: estende `Libro` e aggiunge un attributo `argomento`.

3. **Interfaccia Archivio**:

   - Metodi: `salvaSuFile(String filename)`, `caricaDaFile(String filename)`.

4. **Classe Libreria**:
   - Implementa l'interfaccia `Archivio`.
   - Contiene una lista di oggetti di tipo `Libro`.
   - Metodi per aggiungere libri, visualizzare i libri presenti, salvare e caricare i dati da/verso un file txt.

**Esempio di Output Atteso:**

```
1. Aggiungi nuovo libro
2. Visualizza libri
3. Salva libri su file
4. Carica libri da file
5. Esci
Scegli un'opzione: 1

Inserisci il tipo di libro (Romanzo/Manuale): Romanzo
Titolo: Il Signore degli Anelli
Autore: J.R.R. Tolkien
ISBN: 978-0261102385
Genere: Fantasy

Libro aggiunto con successo!

Scegli un'opzione: 2

Libri nella libreria:
Romanzo: Il Signore degli Anelli, Autore: J.R.R. Tolkien, ISBN: 978-0261102385, Genere: Fantasy
```

**Suggerimenti:**

- Assicurarsi di gestire le eccezioni durante le operazioni di I/O.

#### Parte Teorica

**Domande:**

1. **Ereditarietà:**

   - Che cos'è l'ereditarietà in Java? Fornisci un esempio pratico.
   - Qual è la differenza tra una classe astratta e un'interfaccia?

2. **Polimorfismo:**

   - Cos'è il polimorfismo in Java? Spiega con un esempio.
   - Come viene implementato il polimorfismo durante l'esecuzione?

3. **Interfacce:**

   - Quali sono le principali caratteristiche delle interfacce in Java?
   - Può una classe implementare più interfacce? Se sì, fornisci un esempio.

4. **Eccezioni e Gestione degli Errori:**

   - Cos'è un'eccezione in Java? Come si gestiscono le eccezioni?
   - Qual è la differenza tra `throw` e `throws`?

5. **Lettura e Scrittura su File:**
   - Come si legge da un file in Java? Fornisci un esempio di codice.
   - Come si scrive su un file in Java? Fornisci un esempio di codice.
