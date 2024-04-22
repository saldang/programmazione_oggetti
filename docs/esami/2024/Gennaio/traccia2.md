---
layout: post
title: "Traccia 29 Gennaio 2024"
date: 2024-01-29
---

# Esame 29/01/2021

**Obiettivo:**
L'obiettivo di questo esame è sviluppare un programma in Java per la gestione di uno stock di prodotti di tre tipi diversi. Il programma dovrà leggere i dati da un file CSV, utilizzando concetti di ereditarietà, interfacce e polimorfismo. Successivamente, i prodotti dovranno essere raggruppati sulla base di un attributo comune, scelto dall'utente, e il contenuto dovrà essere salvato su un file con il nome dell'attributo scelto. In alternativa, l'utente potrà scegliere un intervallo di valori per un attributo numerico e il contenuto degli oggetti che rientrano nell'intervallo dovrà essere salvato su un file con il nome dell'attributo e l'intervallo scelto.

**Descrizione:**
Il file CSV (`stock.csv`) contiene dati relativi a tre tipi di prodotti, ad esempio telefoni, computer e accessori. Ogni riga rappresenta un prodotto e include informazioni come tipo, modello, marca, prezzo, ecc.

**Requisiti:**

1. Creare una classe base `Product` e tre classi derivate (`Phone`, `Computer`, `Accessory`) che estendano la classe base.
2. Implementare un'interfaccia `CSV` che definisca i metodi `readCSV` e `writeCSV` per la lettura e la scrittura di oggetti da e su file CSV.
3. Implementare nel main la lettura dei dati dal file `stock.csv`.
4. Chiedere all'utente di scegliere un attributo comune per raggruppare i prodotti (ad esempio, marca, colore) oppure un intervallo di valori per un attributo numerico (ad esempio, prezzo, peso).
   1. Nel caso di un attributo comune raggruppare gli oggetti sulla base dell'attributo scelto e stampare a video il contenuto di ciascun gruppo e salvare il contenuto di ciascun gruppo su un file CSV con il nome dell'attributo scelto.
   2. Nel caso di un intervallo di valori per un attributo numerico, stampare a video il contenuto degli oggetti che rientrano nell'intervallo e salvare il contenuto degli oggetti che rientrano nell'intervallo su un file CSV con il nome dell'attributo e l'intervallo scelto.

**Esempio di input `stock.csv`:**

```csv
tipo,modello,marca,prezzo,colore,peso,memoria,processore,gpu,cancellazioneRumore
Phone,iPhone 13,Apple,999,nero,200,128,Apple A15 Bionic,,
Phone,Galaxy S21,Samsung,899,nero,200,128,Exynos 2100,,
Computer,MacBook Pro,Apple,1999,grigio,1500,256,Intel Core i5,Intel Iris Xe,,
Computer,ThinkPad X1 Carbon,Lenovo,1499,nero,1000,512,Intel Core i7,Intel Iris Xe,,
Accessory,Auricolari,Sony,99,nero,50,,,,true
Accessory,Mouse,Logitech,49,nero,100,,,,

```

**Esempio di output (file `Apple.csv`):**

```csv
tipo,modello,marca,prezzo,colore,peso,memoria,processore,gpu,cancellazioneRumore
Phone,iPhone 13,Apple,999,nero,200,128,Apple A15 Bionic,,
Computer,MacBook Pro,Apple,1999,grigio,1500,256,Intel Core i5,Intel Iris Xe,,

```

**Esempio di output (file `peso0-200.csv`):**

```csv
tipo,modello,marca,prezzo,colore,peso,memoria,processore,gpu,cancellazioneRumore
Phone,iPhone 13,Apple,999,nero,200,128,Apple A15 Bionic,,
Phone,Galaxy S21,Samsung,899,nero,200,128,Exynos 2100,,
Accessory,Auricolari,Sony,99,nero,50,,,,true
Accessory,Mouse,Logitech,49,nero,100,,,,
```

**Note:**

- Assicurarsi che il codice sia ben strutturato, con l'uso appropriato di classi, interfacce e metodi.
- Utilizzare le librerie Java standard per la lettura e la scrittura dei file.
- Gestire eventuali eccezioni durante la lettura/scrittura dei file e durante la creazione degli oggetti.
- Utilizzare un approccio modulare per facilitare la manutenzione e l'estensione del codice.

rentry edit code: pao2901
