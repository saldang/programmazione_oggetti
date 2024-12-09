# Traccia 30 Gennaio 2023

## Programmazione ad Oggetti

Si scriva un programma Java per la gestione e categorizzazione dei personaggi nel manga "One Piece".

Si deve creare:

- una classe **Ciurma** con attributi: Nome, Navi, Pirati
- una classe **Pirata** con i seguenti attributi:Nome originale,Soprannome,Ruolo,Sesso,Eta,Altezza,Taglia
- una classe **Nave** con i seguenti attributi: Nome, Tipo
- una classe **OnePiece** dove si implementa il main

Contenuto file `onepiece.csv`

```csv
Nome originale,Soprannome,Ruolo,Sesso,Eta,Altezza,Taglia
MMonkey D. Luffy,Straw Hat Luffy,Captain,Male,19,174,3.000.000.000 Berries
Roronoa Zoro,Pirate Hunter,First Mate,Male,21,178,1.111.000.000 Berries
Nami,Cat Burglar,Navigator,Female,20,170,366.000.000 Berries
Usopp,Sogeking,Sniper,Male,19,176,500.000.000 Berries
Sanji,Black Leg,Cook,Male,21,Unknown,1.032.000.000 Berries
Tony Tony Chopper,Cotton Candy Lover,Doctor,Male,17,Unknown,1.000 Berries
Nico Robin,Devil Child,Archaeologist,Female,30,Unknown,930.000.000 Berries
Franky,Cyborg,Shipwright,Male,36,Unknown,394.000.000 Berries
Brook,Soul King,Musician,Male,Unknown,170 cm,383.000.000 Berries
Going Merry,caravella
Thousand Sunny,brigantino
```

Per la creazione dei pirati bisogna leggere un file csv chiamato onepiece.csv (consideratelo come un file di testo txt) che contiene le informazioni dei pirati. Le ultime due righe del file sono le informazioni sulle navi

Il programma deve stampare a video una tabella dei personaggi

Il programma deve stampare su file solo i personaggi maschili con le informazioni separate da virgola(`male_op.csv`)

Il programma deve stampare su file i Nomi dei personaggi e la taglia in ordine decrescente (`big_bounty.txt`)

Strutturare il programma con file separati per classe.

File svolti:

- [Ciurma.java](./Ciurma.java)
- [Pirata.java](./Pirata.java)
- [Nave.java](./Nave.java)
- [OnePiece.java](./OnePiece.java)
