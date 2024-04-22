# Esame 19 Dicembre 2023

## Traccia:

Si richiede di implementare un sistema di gestione di un archivio digitale in Java utilizzando concetti di ereditarietà e polimorfismo. L'archivio deve essere salvato e caricato da un file CSV. Segui le istruzioni fornite per ciascuna parte del problema.

### Definizione delle Classi: 

a. Crea una classe astratta chiamata ElementoArchivio con attributi comuni (ad esempio: nome, data di creazione) e un metodo astratto visualizzaDettagli().

b. Implementa almeno due classi derivate da ElementoArchivio che rappresentino tipi diversi di elementi archivistici (es. Documento, Immagine). Ogni classe deve avere attributi specifici e implementare il metodo visualizzaDettagli().

### Gestione dell'Archivio:

a. Crea una classe chiamata ArchivioDigitale che gestisca una lista dinamica di oggetti ElementoArchivio.

b. Implementa i metodi aggiungiElemento() per aggiungere un nuovo elemento all'archivio e visualizzaArchivio() per visualizzare i dettagli di tutti gli elementi presenti.

### Input/Output da File CSV: 

a. Implementa la capacità di salvare l'archivio su un file CSV e caricare l'archivio da un file CSV. Utilizza classi come BufferedReader e BufferedWriter.

b. Fornisci un esempio pratico di utilizzo del sistema, includendo l'aggiunta di elementi, la visualizzazione dell'archivio e il salvataggio/caricamento da file CSV.


Ecco un esempio di file CSV di input con tre tipologie di elementi: Documento, Immagine e Audio.

```csv
Tipo, Nome, DataCreazione, AltroAttributo1, AltroAttributo2
Documento, Contratto1, 2023-01-15, FormatoPDF, 5 pagine
Immagine, Vacanza2022, 2023-02-20, RisoluzioneAlta, FormatoJPEG
Audio, PodcastTech, 2023-03-10, Durata30min, FormatoMP3
```
