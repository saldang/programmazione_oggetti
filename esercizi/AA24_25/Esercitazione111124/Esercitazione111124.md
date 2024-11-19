---
layout: page
title: Esercitazione 11 Novembre 2024
permalink: /esercizi/AA24_25/Esercitazione111124/
---

## Sistema di Gestione di una Scuola

Creare un sistema che gestisca studenti, insegnanti e corsi all’interno di una scuola, tenendo traccia di iscrizioni, valutazioni e materiali di studio.

### Definizione delle Classi Principali

1. Definisci una classe astratta Persona con attributi comuni come nome, cognome e ID. Definisci un metodo astratto visualizzaDettagli().
2. Crea le sottoclassi Studente e Insegnante che estendono Persona.
   1. Studente avrà attributi come classe, mediaVoti e un ArrayList<Double> per i voti.
   2. Insegnante avrà attributi come materia e stipendioBase.
3. Implementa un’interfaccia Valutabile che contiene metodi come aggiungiVoto(double voto), implementata solo da Studente.

### Definizione della Classe Corso

1. Crea una classe Corso con attributi nomeCorso, Insegnante insegnante e un ArrayList<Studente> per tenere traccia degli studenti iscritti.
2. Aggiungi metodi come aggiungiStudente(Studente studente) e assegnaVoto(Studente studente, double voto).

### Definizione della Classe Scuola

1. Crea una classe Scuola che utilizza:
   - Un ArrayList<Corso> per memorizzare i corsi disponibili.
   - Un HashMap<String, ArrayList<Studente>> per organizzare gli studenti in base alla loro classe (ad esempio, “1A”, “2B”).
2. Aggiungi metodi come:
   - aggiungiCorso(Corso corso) per inserire un nuovo corso.
   - iscriviStudenteACorso(String corso, Studente studente) per aggiungere uno studente a un corso specifico.
   - visualizzaDettagliCorso(String nomeCorso) per stampare tutti i dettagli del corso, inclusi insegnante e lista studenti.
   - calcolaMediaStudente(Studente studente) per calcolare la media dei voti di uno studente.

### Interazione Polimorfica e Downcasting

1. Polimorfismo: utilizza ArrayList<Persona> per contenere sia Studente che Insegnante, e implementa un metodo per stampare i dettagli di ciascuno tramite visualizzaDettagli().

### Requisiti Aggiuntivi

1. Ricerca e Filtraggio: implementa un metodo nella classe Scuola che restituisce la lista degli studenti con una media voti sopra una certa soglia.
2. Report: implementa un metodo generaReport che crea un riepilogo per ogni corso, includendo l’insegnante, il numero di studenti iscritti e la media generale dei voti.
3. Gestione delle Risorse: aggiungi un attributo HashMap<String, ArrayList<String>> in Corso per rappresentare le risorse (ad es., “Slides”, “Compiti”) con la lista di materiali associati, e un metodo per aggiungere nuove risorse.

Al termine, il sistema potrebbe stampare dettagli come:
• Elenco completo degli insegnanti e degli studenti.
• Dettagli di un corso specifico con l’insegnante assegnato e gli studenti iscritti.
• Report di fine anno con le medie voti per corso e per studente.
• Elenco degli studenti con media voti sopra una certa soglia.

File java:

- [Scuola.java](./Scuola.java)
- [Corso.java](./Corso.java)
- [Valutabile.java](./Valutabile.java)
- [Persona.java](./Persona.java)
- [Studente.java](./Studente.java)
- [Insegnante.java](./Insegnante.java)
- [GestioneScuola.java](./GestioneScuola.java)
