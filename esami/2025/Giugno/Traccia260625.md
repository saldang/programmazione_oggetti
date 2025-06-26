---
layout: post
title: "Traccia 26 Giugno 2025"
date: 2025-06-26
---

## Sistema di Gestione Biblioteca Multimediale

Si richiede di sviluppare un sistema per la gestione di una biblioteca che offra **prestiti** e **vendite** di materiale cartageo e digitale.
Il sistema dovrà essere implementato sfruttando ereditarietà, polimorfismo, interfacce e gestione delle eccezioni; dovrà inoltre salvare/caricare dati da file di testo.

### Parte 1: Gestione dei Materiali

1. **Classe `Materiale`**
   Attributi comuni a qualunque risorsa:
   - `codice` (Stringa – identificativo univoco)
   - `titolo` (Stringa)
   - `annoPubblicazione` (int)
   - `genere` (Stringa)
   - `prezzo` (double)

2. **Classi derivate**
   - `MaterialeCartaceo`
     - `autore` (Stringa)
     - `numeroPagine` (int)
     - `ISBN` (Stringa)
   - `MaterialeDigitale`
     - `formato` (Stringa – es. PDF, EPUB, MP3, MP4…)
     - `dimensioneMB` (double)
     - `drm` (boolean – indica se il file è protetto da DRM)

3. **Classe `Catalogo`**
   - Mantiene un elenco di oggetti `Materiale`
   - Metodi per aggiungere, rimuovere, aggiornare e cercare risorse
   - Metodi di utilità per filtrare:
     - solo materiali cartacei
     - solo materiali digitali
     - disponibili per **vendita** o **prestito** (vedi oltre)

4. **Interfaccia `GestioneDati`**

   ```java
   public interface GestioneDati {
       void salva(String percorso) throws IOException;
       void carica(String percorso) throws IOException;
   }
    ```

5. **`Catalogo` implementa `GestioneDati`**
    - Salva/carica il catalogo da file CSV
    - Gestisce l’eccezione personalizzata FormatoFileException se il file è corrotto o malformato

### Parte 2: Gestione delle Transazioni

 1. Classe astratta Transazione
    - data (LocalDate)
    - utente (Stringa – nome e cognome)
    - materiale (Materiale)
 2. Classi derivate
    - Prestito
        - dataInizio (LocalDate)
        - dataFine (LocalDate)
        - penalitaGiornaliera (double)
    - Vendita
        - sconto (double)
        - metodoPagamento (Stringa – contanti, carta, bonifico…)
        - prezzoFinale (double)
 3. Classe GestioneTransazioni
    - Elenco di Transazione
    - Aggiunta di nuove vendite / prestiti
    - Statistiche:
    - totale incassato dalle vendite
    - numero di prestiti attivi e conclusi
    - materiale più richiesto
    - Visualizzazione delle transazioni in corso e archiviate
 4. GestioneTransazioni implementa GestioneDati
    - Log delle transazioni su file di testo in formato leggibile
 5. Eccezione personalizzata
    - MaterialeNonDisponibileException lanciata quando si tenta di vendere o prestare un materiale non presente o già in prestito

### Parte 3: Test (classe BibliotecaTest)

 1. Aggiunta di materiali (cartacei e digitali) al Catalogo
 2. Salvataggio e caricamento del catalogo da materiali.txt
 3. Creazione di prestiti e vendite
 4. Calcolo delle statistiche (incassi, numero prestiti, ecc.)
 5. Salvataggio dei log delle transazioni in transazioni.txt
 6. Verifica delle eccezioni (FormatoFileException, MaterialeNonDisponibileException)

File di esempio per i Materiali (materiali.txt)

```text
tipo,codice,titolo,anno,genere,prezzo,autore,pagine,ISBN,formato,dimensione,drm
MaterialeCartaceo,B001,Il Nome della Rosa,1980,Storico,12.90,Umberto Eco,512,9788845240798,,,
MaterialeCartaceo,B002,Neuromante,1984,Fantascienza,10.50,William Gibson,320,9788804668359,,,
MaterialeDigitale,D101,Lo Hobbit,1937,Fantasy,7.99,,,,"EPUB",2.3,false
MaterialeDigitale,D102,Dark Side of the Moon,1973,Musica,9.99,,,,"MP3",120.0,true
```

File di output per le Transazioni (transazioni.txt)

```text
PRESTITO,2025-07-01 → 2025-07-15
Utente: Anna Verdi
Materiale: Il Nome della Rosa (B001)
Penalità giornaliera: 0.50€

VENDITA,2025-07-03
Utente: Luca Bianchi
Materiale: Dark Side of the Moon (D102)
Prezzo: 8.49€ (Sconto: 1.50€)
Metodo pagamento: Carta di credito

STATISTICHE:
Prestiti attivi: 1
Prestiti conclusi: 0
Materiali venduti: 1
Incasso vendite: 8.49€
```

### Extra

- Utilizzo LocalDate per gestire le date:

```java
// Data corrente e piu 7 giorni (per il prestito)
import java.time.LocalDate;
public class EsempioData {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        System.out.println("Data corrente: " + data);
        LocalDate dataFutura = data.plusDays(7);
        System.out.println("Data tra 7 giorni: " + dataFutura);
    }
}
```

