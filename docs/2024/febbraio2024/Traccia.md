---
layout: post
title: "Traccia 16 Febbraio 2024"
date: 2024-02-16
---

# Esame di Programmazione

## 16 Febbraio 2024

Si consideri il seguente scenario: un'azienda di e-commerce gestisce un sistema per la vendita di prodotti online. I prodotti possono essere di due tipi: **libri** e **prodotti elettronici**.

Si scriva un programma in Java che implementi le seguenti classi:

**Prodotto**: una classe astratta che rappresenta un prodotto generico. La classe deve includere i seguenti attributi:

- _codice_: un codice identificativo univoco
- _descrizione_: una breve descrizione del prodotto
- _prezzo_: il prezzo di vendita del prodotto

**Libro**: una classe concreta che eredita dalla classe Prodotto. La classe deve includere l'attributo _autore_ che rappresenta l'autore del libro.
**ProdottoElettronico**: una classe concreta che eredita dalla classe Prodotto. La classe deve includere l'attributo _garanzia_ che rappresenta la durata della garanzia in anni.

Si consideri la seguente interfaccia:

```Java
public interface ISpedibile {
    double getPeso();
    String getIndirizzoDiSpedizione();
}
```

Si modifichi il codice in modo che le classi **Libro** e **ProdottoElettronico** implementino l'interfaccia **ISpedibile**. La classe Libro deve sovrascrivere il metodo _getPeso_ per restituire il peso del libro (in chilogrammi), mentre la classe ProdottoElettronico deve sovrascrivere il metodo _getPeso_ per restituire il peso del prodotto elettronico (in grammi). Entrambe le classi devono sovrascrivere il metodo _getIndirizzoDiSpedizione_ per restituire l'indirizzo di spedizione del cliente.

Si implementi una classe Carrello che gestisce la lista dei prodotti da acquistare. La classe Carrello deve includere i seguenti metodi:

- _aggiungiProdotto(Prodotto prodotto)_: aggiunge un prodotto al carrello
- _rimuoviProdotto(Prodotto prodotto)_: rimuove un prodotto dal carrello
- _calcolaTotale()_: calcola il totale dell'ordine, sommando i prezzi dei prodotti nel carrello
- _stampaRiepilogo()_: stampa un riepilogo dell'ordine, che include l'elenco dei prodotti, il totale dell'ordine e l'indirizzo di spedizione

Il programma deve includere un metodo main che crea un'istanza di ciascuna classe e ne stampa i dettagli.

Il programma deve includere un metodo main che crea un'istanza di Carrello, aggiunge alcuni prodotti al carrello, calcola il totale dell'ordine e stampa un riepilogo dell'ordine.

### Bonus

Si implementi un sistema di sconti per il carrello. I prodotti di tipo Libro hanno uno sconto del 10%, mentre i prodotti di tipo ProdottoElettronico hanno uno sconto del 5%. Il metodo calcolaTotale() deve applicare lo sconto al totale dell'ordine.
