---
layout: page
title: Traccia 13 Febbraio 2023 Svolta v1
permalink: /esercizi/AA24_25/Traccia130223v1
---

## {{page.title}}

Scrivere un programma java per la gestione dei salari dei dipendenti di un'azienda.

1. Creare una classe chiamata **Dipendente** che rappresenti un dipendente aziendale. Questa classe deve avere una matricola, un nome e un salario come proprietà. Inoltre, deve avere un metodo per calcolare il bonus annuale che è il 10% del salario.
2. Creare una classe chiamata **Developer** che erediti da Dipendente. Questa classe deve avere una proprietà che indica il livello di esperienza (Junior, Mid). Inoltre, deve avere un metodo per calcolare il bonus annuale che è il 20% del salario per il livello Junior e 30% per il livello Mid.
3. Creare una classe chiamata **Senior Developer** che erediti da Developer. Questa classe deve avere un metodo per calcolare il bonus annuale che è il 40% del salario.
4. Creare una classe chiamata **Project Manager** che erediti da Dipendente. Questa classe deve avere una proprietà che indica il numero di progetti che ha gestito. Inoltre, deve avere un metodo per calcolare il bonus annuale che è il 5% del salario per ogni progetto gestito.

```csv
Matricola,Nome,Salario,Ruolo,Livello,Progetti Gestiti
1,Marco Rossi,1500,Developer,Junior,0
2,Paolo Bonolis,3000,Developer,Senior,0
3,Francesco Renga,2000,Developer,Senior,0
4,Chiara Ferragni ,2500,Developer,Mid,0
5,Stefano De Martino,2000,Developer,Senior,0
6,Marco Mengoni,2500,Developer,Mid,0
7,Anna Oxa,2500,Developer,Mid,0
8,Francesca Michelin,4000,Project Manager,,8
9,Mattia Pasini,1500,Developer,Junior,0
10,Stefano Cinque,1500,Developer,Junior,0
11,Marco Pantani,4000,Project Manager,,10
12,Lorenzo Miniero,4000,Project Manager,,12
```

Creare un programma che crei istanze di Dipendente, Developer, Senior Developer e Project Manager leggendo da file csv, imposti le proprietà appropriate e stampi su file la matricola e il bonus annuale per ogni istanza. Utilizzare il polimorfismo per chiamare il metodo per calcolare il bonus annuale per ogni istanza, indipendentemente dal tipo di oggetto.

File java:

- [Dipendente.java](./Dipendente.java)
- [Developer.java](./Developer.java)
- [SeniorDeveloper.java](./SeniorDeveloper.java)
- [ProjectManager.java](./ProjectManager.java)
- [App.java](./App.java)
- [Esperienza.java](./Esperienza.java)
