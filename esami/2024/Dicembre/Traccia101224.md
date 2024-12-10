# Traccia 10 Dicembre 2024

## Sistema per la gestione di assets finanziari

Si realizzi un sistema per la gestione di assets finanziari. Gli assets sono di due tipi: azioni e obbligazioni. Per le azioni si memorizzano il nome della società, il prezzo attuale e il prezzo di acquisto. Per le obbligazioni si memorizzano il nome dell'emittente, il tasso di interesse e il prezzo di acquisto. Si realizzi una classe astratta `Asset` con i metodi astratti `valore_attuale` e `guadagno`. Si realizzi poi una classe `Azione` e una classe `Obbligazione` che estendono `Asset`. Si realizzi infine una classe `Portafoglio` che contiene una lista di assets e che ha un metodo `valore_totale` che restituisce il valore totale del portafoglio e un metodo `guadagno_totale` che restituisce il guadagno totale del portafoglio.

1. Utilizzare il polimorfismo per gestire i diversi tipi di assets nel portafoglio.
2. Implementare un'interfaccia `Salvabile` con i metodi `salvaSuFile` e `caricaDaFile` per la lettura e scrittura di file.
3. Le classi `Azione` e `Obbligazione` devono implementare l'interfaccia `Salvabile`.
4. La classe `Portafoglio` deve avere metodi per salvare e caricare la lista di assets da un file.

Si realizzi infine una classe `Main` che crea un portafoglio con alcuni assets letti da file csv, aggiunge un'azione e un'obbligazione, stampa il valore totale e il guadagno totale del portafoglio e salva il portafoglio aggiornato su file.

```csv
Azione,Apple,1500,1000
Obbligazione,IBM,0.05,2000
Azione,Microsoft,2000,1500
Azione,Amazon,3000,2500
Obbligazione,Google,0.03,3000
```

### Domande teoriche

_Non e' necessario rispondere a tutte le domande_

1. **Modificatori**: Quali sono i principali modificatori di accesso in Java e come influenzano la visibilità dei membri di una classe?
2. **Incapsulamento**: Cos'è l'incapsulamento e perché è importante nella programmazione orientata agli oggetti?
3. **Ereditarietà e Polimorfismo**: Spiega la differenza tra ereditarietà e polimorfismo. Come si applicano nel contesto delle classi `Asset`, `Azione` e `Obbligazione`?
4. **Upcasting e Downcasting**: Cosa sono upcasting e downcasting? Fornisci un esempio di ciascuno nel contesto del sistema di gestione degli assets.
5. **Keyword `this` e `super`**: Qual è la differenza tra `this` e `super` in Java? Fornisci un esempio di utilizzo di ciascuno.
6. **Interfacce e Classi Astratte**: Quali sono le principali differenze tra interfacce e classi astratte? Quando è opportuno utilizzare una rispetto all'altra?
7. **Modificatore `static`**: Qual è il ruolo del modificatore `static` in Java? Fornisci un esempio di utilizzo.
8. **Gestione File**: Come si gestisce la lettura e scrittura di file in Java? Fornisci un esempio di codice che legge e scrive un file di testo.
