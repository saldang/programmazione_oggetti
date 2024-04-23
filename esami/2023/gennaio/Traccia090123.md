# Traccia 9 Gennaio 2023

### Programmazione ad Oggetti

Si scriva un programma in Java per la gestione di un magazzino. Il programma deve leggere da un file csv (Comma Separated Value) stock.csv i prodotti da immagazzinare. I prodotti possono essere di due tipi: tablet e smartphone. Il file stock.txt ha un prodotto per riga: il primo carattere è t per indicare un tablet e s per smartphone. Dopo il primo carattere ci sono le informazioni sui prodotti: modello, produttore, la dimensione dello schermo in pollici (double), il peso in grammi (intero), la connessione e un codice identificativo (intero).
Creare una classe base "Device" e le classi derivate "Smartphone" e "Tablet".

```csv
tipo,modello,marca,display,connessione,peso,camera,penna,codice
t,Galaxy Tab S8,Samsung,11.0,Wifi,200,,Y,1231311
s,Galaxy S22,Samsung,6.1,5G,167,108,,5326354
s,Galaxy S22,Samsung,6.1,5G,167,108,,5326354
t,IPad Air,Apple,10.9,Wifi,458,,N,6365464
s,IPhone 13,Apple,6.1,5G,172,12,,3242342
s,IPhone 12,Apple,6.1,5G,174,12,,6456546
s,IPhone 14,Apple,6.1,5G,164,12,,9845344
s,11,Oneplus,6.7,5G,180,50,,1232342
s,11 Pro,Oneplus,6.7,5G,180,108,,1232343
t,Galaxy Tab S7,Samsung,11.0,Wifi,200,,Y,1231312
s,Pixel 5,Google,6.0,5G,163,12,,1231314
s,Pixel 5,Google,6.0,5G,163,12,,1231314
s,Pixel 4,Google,6.0,5G,163,8,,1231315
s,Pixel 4,Google,6.0,5G,163,8,,1231315
t,IPad Pro,Apple,12.9,Wifi,650,,N,1231316
t,IPad Mini,Apple,7.9,Wifi,300,,N,1231317
t,IPad Mini,Apple,7.9,Wifi,300,,N,1231317

```

Il programma deve inoltre stampare a video il contenuto del magazzino in una tabella.

Il programma deve inoltre stampare a video l’elenco dei modelli presenti in magazzino e, per ogni modello, il numero di pezzi presenti.
