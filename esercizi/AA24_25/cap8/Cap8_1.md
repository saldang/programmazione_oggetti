---
layout: page
title: Capitolo 8 Esercizio 1
permalink: /esercizi/AA24_25/Cap8/
---

## {{page.title}}

Si scriva un programma di valutazione per un insegnante il cui corso ha le seguenti caratteristiche.

Vengono dati due esercizi ciascuno con un punteggio di 10.

Ci sono due esami intermedi e uno finale ciascuno con un punteggio massimo di 100.

L’esame finale vale il 50% del punteggio totale, mentre gli esami intermedi il 25%. I due esercizi, assieme, valgono il 25%. È bene non dimenticarsi di normalizzare i punteggi: questi dovrebbero essere convertiti in percentuali prima di essere usati per calcolare la media finale.

Ciascun punteggio che supera il 90% del punteggio totale si trasforma in un voto A, un punteggio tra 80 e 89% in B, tra 70 e 79 in C, tra 60 e 69 in C, ogni punteggio sotto 60 è una F.

Il programma dovrebbe leggere i punteggi di ogni studente e mostrarli facendo vedere i punteggi dei due esercizi, dei due esami intermedi, dell’esame finale, la media dell’intero corso e il voto espresso in lettera. Il voto finale è compreso tra 0 e 100 e rappresenta la media pesata del lavoro dello studente.

Si definisca e si usi una classe per registrare queste informazioni. La classe dovrebbe avere variabili di istanza per i voti degli esercizi, degli esami intermedi, dell’esame finale, per il punteggio totale del corso e per il voto espresso in lettera. La classe dovrebbe avere metodi di input e output. Il metodo di input non dovrebbe chiedere il voto finale, né in percentuale né in lettera. La classe dovrebbe avere i metodi per calcolare la media totale e il voto finale in lettera. Questi due metodi saranno metodi void che assegnano i valori calcolati alle variabili di istanza appropriate. Si ricordi che un metodo può invocare un altro metodo. Se si preferisce, si può definire un singolo metodo che assegna sia il punteggio totale, sia il punteggio in lettere, ma se questa è la scelta, è bene usare un metodo ausiliario. Il programma dovrebbe usare tutti i metodi descritti. La classe dovrebbe avere un insieme ragionevole di metodi set e get, anche se il programma non li usa tutti. Si possono aggiungere altri metodi se si desidera.

[AppEsame.java](./AppEsame.java)

[Studente.java](./Studente.java)
