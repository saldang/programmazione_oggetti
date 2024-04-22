# Traccia 24 Aprile 2024

## Simulazione di un Sistema di Sicurezza Domestica

### Descrizione

Si richiede di progettare e implementare un sistema di sicurezza domestica simulato che gestisca sensori, allarmi e utenti autorizzati.

### Requisiti

1. **Classi Principali:**
   - Sensore:
     1. Attributi: stato (attivo/inattivo), posizione.
     2. Metodi: costruttore, attiva(), disattiva(), statoSensore(), rilevaEvento(), toString().
   - Allarme
     1. Attributi: stato (acceso/spento), volume.
     2. Metodi: costruttore, attivaAllarme(), disattivaAllarme(), suona(), silenzia().
   - Evento
     1. Attributi: tipo (es. movimento, fumo), data, ora.
     2. Metodi: costruttore, toString().
   - Utente
     1. Attributi: nome, livello di accesso (es. proprietario, ospite, servizio).
     2. Metodi: costruttore, verificaAccesso(), toString().
2. **Gestione Eventi e Polimorfismo**
   Implementare un sistema di gestione eventi che attiva l'allarme in base al tipo di evento rilevato dai sensori.
   Utilizzare il polimorfismo per gestire diversi tipi di sensori con una interfaccia comune.
3. **Interfaccia e Classi Astratte**
   Creare un'interfaccia SistemaSicurezza con metodi per aggiungere/rimuovere sensori e utenti, attivare/disattivare sistema.
   Implementare questa interfaccia in una classe concreta SicurezzaCasa.
4. **Eccezioni**  
   Gestire eccezioni per casi come "accesso non autorizzato", "sensore guasto".
5. **Input/Output**
   Implementare un sistema di logging che registra ogni evento di sicurezza, inclusi gli accessi, attivazioni/disattivazioni di allarmi, e rilevazioni di sensori.
   Salvare il log degli eventi in un file di testo con il nome del sistema e la data corrente.

### Compiti

- Implementare le classi sopra descritte.
- Scrivere un metodo main che simula un'interazione tipica in un sistema di sicurezza domestica, come l'aggiunta di sensori, la gestione degli utenti e la risposta agli eventi di sicurezza.
- Gestire le eccezioni in modo appropriato per mantenere il sistema operativo e sicuro.
- Implementare un meccanismo di logging per tenere traccia delle operazioni effettuate sul sistema.

### Scenario di Esempio

Un sistema di sicurezza domestica è composto da due sensori, un sensore di movimento e un sensore di fumo, e un allarme. Il sistema è installato in una casa con due utenti, il proprietario e un ospite. Il sistema è attivo e monitora costantemente la casa. Quando il sensore di movimento rileva un'intrusione, l'allarme si attiva e il proprietario viene avvisato. Se l'ospite tenta di disattivare l'allarme, il sistema genera un'eccezione. Il proprietario può disattivare l'allarme con successo.
Ogni evento viene registrato in un file di log.

### Input

Eventi

```csv
tipo evento, data, ora
null, 24/04/2024, 10:00
accesso, 24/04/2024, 10:15
movimento, 24/04/2024, 10:30
fumo, 24/04/2024, 11:15
```

Sensori

```csv
tipo sensore, posizione
movimento, ingresso
fumo, cucina
```

Utenti

```csv
nome, livello accesso
Sam, admin
Alice, ospite
```
