# Polimorfismo

## Esercizio Albergo

Creare un programma, utilizzando la tecnica ad oggetti, che consente la gestione delle camere di un albergo.

Presupporre tre diverse tipologie di camere, normale, lusso, extralusso

Tutte le camere devono essere caratterizzate da un prezzo, uno stato (occupata/libera/luce accesa), e funzionalità base tra le quali pulisci, informazioni…

Le camere più grandi supportano le stesse funzioni di quelle più piccole, ma hanno maggior numero di optional e operazioni (es: televisione, condizionatore…).

Presupporre che ogni stanza possa essere occupata da una lista di clienti.

Prevedere tre tipi di clienti: adulto, bambino, ragazzo

Per ogni oggetto di tal tipo deve essere possibile richiedere le informazioni riguardanti il cliente

Per tutti le informazioni base sono nome e cognome

In più per adulto e ragazzo è necessaria la carta d’identità, per il bambino età ed i nomi dei genitori.

## Classi

- [Camera](Camera.java)
- [CameraLusso](CameraLusso.java)
- [CameraNormale](CameraNormale.java)
- [Cliente](Cliente.java)
- [Hotel](Hotel.java)
- [Bambino](Bambino.java)
- [Ragazzo](Ragazzo.java)
- [Adulto](Adulto.java)
- [HasTV](HasTV.java)
