# Traccia 19 Novembre 2024

## Esame di Programmazione ad Oggetti

1. **Gerarchia dei Veicoli**

   - Crea una classe astratta `Veicolo` con proprietà per `marca`, `modello`, `anno` e `colore`.
   - Implementa metodi astratti `calcolaValoreMercato()` e `visualizzaInformazioniVeicolo()`.
   - Crea classi concrete di veicoli `Automobile`, `Motocicletta` e `Bicicletta` che estendono la classe `Veicolo`.
   - Implementa i metodi astratti in ciascuna classe concreta di veicoli, tenendo conto dei fattori specifici che influenzano il valore di mercato (ogni anno fa scendere il valore di mercato di una percentuale variabile a seconda del tipo di veicolo) e le informazioni da visualizzare per ogni tipo di veicolo.

2. **Interfaccia Guidabile**

   - Crea un'interfaccia chiamata `Guidabile` con metodi `accelera(double quantita)`, `frena(double quantita)` e `getTotaleDistanza()`.
   - Modifica le classi `Automobile` e `Motocicletta` per implementare l'interfaccia `Guidabile`.
   - Implementa i metodi dell'interfaccia in ciascuna classe, tenendo traccia della distanza totale percorsa da ciascun veicolo.

3. **Repository dei Veicoli**

   - Crea una classe `RepositoryVeicoli` che gestisce una lista di oggetti `Veicolo`.
   - Implementa metodi per aggiungere, rimuovere e recuperare veicoli dal repository.

4. **Input/Output su File e Serializzazione**

   - Crea una classe `EccezioneSerializzazioneVeicoli` che estende `Exception`.
   - Scrivi un metodo per serializzare una lista di oggetti `Veicolo` in un file binario.
   - Scrivi un metodo leggere una lista di oggetti `Veicolo` da un file csv.
   - Gestisci eventuali eccezioni che possono verificarsi durante i processi di serializzazione e deserializzazione.

5. **Interfaccia Utente**
   - Crea una classe `GestoreVeicoli` con un metodo main per dimostrare la funzionalità del tuo sistema di gestione dei veicoli.
   - Implementa un'interfaccia utente guidata da menu che consenta all'utente di:
     - Aggiungere, rimuovere e recuperare veicoli dal `RepositorioVeicoli`
     - Visualizzare il valore di mercato e le informazioni di ciascun veicolo
     - Accelerare e frenare i veicoli, e visualizzare la distanza totale percorsa
     - Salvare la lista di veicoli in un file binario
     - Caricare la lista di veicoli da un file csv

```csv
marca,modello,anno,tipo,dimensioneMotore,prezenzaInterni,cilindrata,prezenzaAntibloccaggio,prezenzaAssistenzaElettrica,colore
Toyota,Corolla,2020,automobile,1800,vero,,,falso,rosso
Honda,Civic,2018,automobile,2000,falso,,,falso,blu
Ducati,Panigale V4,2021,motocicletta,,falso,1103,vero,falso,rosso
Harley-Davidson,Sportster S,2022,motocicletta,,falso,1252,falso,falso,nero
Trek,Domane SL 6,2023,bicicletta,,falso,,falso,vero,grigio
Cannondale,CAAD13,2022,bicicletta,,falso,,falso,falso,bianco
```

File Java (modificateli per completare le classi con le caratteristiche specifiche per classe):

- [Veicolo](./Veicolo.java)
- [Automobile](./Automobile.java)
- [Motocicletta](./Motocicletta.java)
- [Bicicletta](./Bicicletta.java)
- [Guidabile](./Guidabile.java)
- [Repository Veicoli](./RepositoryVeicoli.java)
- [GestoreVeicoli](./GestoreVeicoli.java)
