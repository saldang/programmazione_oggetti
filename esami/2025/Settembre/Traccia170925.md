---
layout: post
title: "Traccia 17 Settembre 2025"
date: 2025-09-16
---

## Sistema di Gestione Ristorante e Delivery

Si vuole realizzare un sistema per gestire un ristorante che offre servizio al tavolo e delivery. Il sistema deve tenere traccia del menu, gestire gli ordini e calcolare statistiche di vendita.

### Requisiti Funzionali

#### 1. Gerarchia di Piatti (Ereditarietà e Polimorfismo)

Creare una gerarchia di classi per i piatti del menu:

- **Classe astratta `Piatto`** con:
  - Attributi: `nome`, `descrizione`, `prezzoBase`, `tempoPreparazione`, `codice`
  - Metodi astratti: `calcolaPrezzoFinale()`, `getInfoNutrizionali()`
  - Metodi concreti: `getNome()`, `getDescrizione()`, `getTempo()`, `getCodice()`

- **Classi concrete**:
  - `Antipasto`:
    - Attributi aggiuntivi: `porzione` (PICCOLA/MEDIA/GRANDE), `vegetariano`
    - Metodo `calcolaPrezzoFinale()`: prezzoBase * moltiplicatorePorzione (0.8/1.0/1.3)
    - Metodo `getInfoNutrizionali()`: restituisce calorie base su porzione

  - `PiattoPrincipale`:
    - Attributi aggiuntivi: `tipoCottura`, `contorno`, `calorie`
    - Metodo `calcolaPrezzoFinale()`: prezzoBase + (contorno ? 3.50 : 0)
    - Metodo `getInfoNutrizionali()`: restituisce calorie totali con contorno

  - `Dessert`:
    - Attributi aggiuntivi: `contenutoZucchero`, `senzaGlutine`, `temperaturaServizio`
    - Metodo `calcolaPrezzoFinale()`: prezzoBase + (senzaGlutine ? 2.00 : 0)
    - Metodo `getInfoNutrizionali()`: restituisce zuccheri e calorie

#### 2. Interfacce

Implementare le seguenti interfacce:

- **`Ordinabile`**:
  - `aggiungiAllOrdine(int numeroTavolo, int quantita)`: aggiunge piatto all'ordine
  - `rimuoviDallOrdine(int numeroTavolo)`: rimuove piatto dall'ordine
  - `getDisponibilita()`: verifica se ingredienti sono disponibili
  - `getTempoTotale(int quantita)`: calcola tempo preparazione totale

- **`Personalizzabile`**:
  - `aggiungiIngrediente(String ingrediente, double costo)`: aggiunge extra
  - `rimuoviIngrediente(String ingrediente)`: toglie ingrediente
  - `getListaModifiche()`: restituisce modifiche applicate
  - `resettaPersonalizzazioni()`: rimuove tutte le modifiche

#### 3. Gestione File CSV (I/O)

Il sistema deve gestire:

- **Lettura menu** da file CSV con formato:

  ```txt
  nome,tipo,descrizione,prezzo,tempo,codice,parametro1,parametro2,parametro3
  Bruschette,ANTIPASTO,Pomodoro e basilico,6.50,10,ANT001,MEDIA,true,
  Carbonara,PRINCIPALE,Guanciale uova pecorino,12.00,15,PRI001,tradizionale,false,380
  Tiramisu,DESSERT,Mascarpone e caffe,7.00,5,DES001,25,false,freddo
  ```

- **Scrittura report vendite** in CSV con statistiche:

  ```txt
  piatto,tipo,venduti_oggi,incasso,tempo_medio_attesa,valutazione_media
  Bruschette,ANTIPASTO,35,227.50,12,4.5
  Carbonara,PRINCIPALE,48,576.00,18,4.8
  Tiramisu,DESSERT,22,154.00,6,4.7
  ```

#### 4. Gestione Eccezioni

Implementare eccezioni personalizzate:

- `PiattoNonDisponibileException`: quando ingredienti non sono disponibili
- `TavoloNonValidoException`: quando numero tavolo non esiste
- `OrdineVuotoException`: quando si tenta di processare ordine vuoto
- `FormatoMenuException`: per errori nel formato del file menu

#### 5. Classe Principale `GestoreRistorante`

Deve contenere:

- `List<Piatto>` per gestire il menu
- `Map<Integer, Ordine>` per associare tavoli agli ordini
- `Map<String, Integer>` per inventario ingredienti
- Metodi per gestire ordini, calcolare conti, generare report

### Classi di Supporto

#### 6. Classe `Ordine`

- Attributi: `numeroOrdine`, `numeroTavolo`, `orarioApertura`, `stato`, `tipologia` (TAVOLO/ASPORTO/DELIVERY)
- Metodi: costruttore, `aggiungiPiatto()`, `calcolaTotale()`, `getTempoStimato()`, `toString()`

#### 7. Classe `Cliente`

- Attributi: `nome`, `telefono`, `indirizzo`, `noteAllergie`, `clienteAbituale`
- Metodi: costruttore, getter/setter, `applicaSconto()`, `equals()`

#### 8. Implementazione Interfacce

- `Antipasto`: implementa `Ordinabile` e `Personalizzabile`
- `PiattoPrincipale`: implementa `Ordinabile` e `Personalizzabile`
- `Dessert`: implementa solo `Ordinabile`

### Casi d'Uso da Implementare

1. **Caricamento Menu**: Leggere il file CSV e creare i piatti del menu
2. **Gestione Ordini**: Creare e modificare ordini per tavoli
3. **Calcolo Conto**: Calcolare totale con eventuali sconti
4. **Gestione Inventario**: Verificare disponibilità ingredienti
5. **Generazione Report**: Creare file CSV con vendite giornaliere
6. **Gestione Eccezioni**: Gestire tutti i casi di errore

### Esempio di Utilizzo

```java
public class Main {
    public static void main(String[] args) {
        GestoreRistorante gestore = new GestoreRistorante();

        try {
            // Carica menu da file
            gestore.caricaMenu("menu.csv");

            // Crea nuovo ordine per tavolo 5
            gestore.nuovoOrdine(5, "TAVOLO");
            gestore.aggiungiPiattoOrdine(5, "Carbonara", 2);
            gestore.aggiungiPiattoOrdine(5, "Tiramisu", 2);

            // Personalizza piatto
            gestore.personalizzaPiatto(5, "Carbonara", "senza pecorino", -1.00);

            // Calcola e stampa conto
            double totale = gestore.calcolaConto(5);
            System.out.println("Totale tavolo 5: €" + totale);

            // Genera report vendite
            gestore.generaReportVendite("vendite_giornaliere.csv");

        } catch (PiattoNonDisponibileException | TavoloNonValidoException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
```

### Metodi Richiesti per GestoreRistorante

```java
public class GestoreRistorante {
    // Carica menu da file CSV
    public void caricaMenu(String nomeFile) throws FormatoMenuException

    // Crea nuovo ordine per tavolo
    public void nuovoOrdine(int numeroTavolo, String tipo)
        throws TavoloNonValidoException

    // Aggiunge piatto all'ordine
    public void aggiungiPiattoOrdine(int tavolo, String nomePiatto, int quantita)
        throws PiattoNonDisponibileException

    // Personalizza piatto nell'ordine
    public void personalizzaPiatto(int tavolo, String piatto, String modifica, double costoExtra)

    // Calcola conto del tavolo
    public double calcolaConto(int numeroTavolo) throws OrdineVuotoException

    // Genera report vendite
    public void generaReportVendite(String nomeFile)

    // Mostra piatti disponibili
    public void mostraMenuDisponibile()

    // Ottieni tempo stimato ordine
    public int getTempoStimato(int numeroTavolo)
}
```

### Esempio di Output Atteso

```txt
=== MENU DEL GIORNO ===
[ANTIPASTO] Bruschette - €6.50
Pomodoro e basilico - Tempo: 10 min - Vegetariano: SI

[PRINCIPALE] Carbonara - €12.00
Guanciale uova pecorino - Tempo: 15 min - Calorie: 380

[DESSERT] Tiramisu - €7.00
Mascarpone e caffe - Tempo: 5 min - Servizio: freddo

=== ORDINE TAVOLO 5 ===
2x Carbonara (personalizzato: senza pecorino) - €22.00
2x Tiramisu - €14.00
TOTALE: €36.00
Tempo stimato: 20 minuti
```

Per la consegna dell'esame caricare la cartella al seguente link: [Settembre 2025](https://uninadue.sharepoint.com/:f:/r/sites/v.msteams_20240910113621/Documenti%20condivisi/Esami/Settembre%202025?csf=1&web=1&e=HxYb8N)
