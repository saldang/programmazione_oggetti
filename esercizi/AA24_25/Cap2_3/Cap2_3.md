---
layout: page
title: Capitolo 2 Esercizio 3
permalink: /esercizi/AA24_25/Cap2_3/
---

## {{page.title}}

Scrivere un programma che legga l’ammontare di un pagamento mensile per un’ipoteca e l’ammontare ancora dovuto (il debito rimanente). Il programma deve quindi visualizzare la parte di pagamento che serve per coprire gli interessi a debito e l’ammontare che serve per ridurre il debito. Si supponga che il tasso di interesse annuo sia del 7.49 %. Si utilizzi una costante per memorizzare il tasso di interesse. Si noti che i pagamenti vengono fatti mensilmente: l’interesse è quindi un dodicesimo del tasso di interesse annuale del 7.49 %.

```java
import java.util.Scanner;

public class Cap2_3 {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        final double interesse;
        // final double ipoteca = 150000;
        System.out.println("Inserisci l'ammontare dell'ipoteca:");
        double ipoteca = tastiera.nextDouble();
        System.out.println("Inserisci il tasso di interesse:");
        interesse = tastiera.nextDouble();
        double debito = ipoteca;
        // boolean esci = false;
        int count = 0;

        // while (!esci) {
        // System.out.println("Vuoi inserire un pagamento?(Y/N):");
        // String scelta = tastiera.next();
        // if (scelta.equalsIgnoreCase("n")) {
        // break;
        // } else if (scelta.equalsIgnoreCase("y")) {
        // esci = false;
        // } else {
        // System.out.println("Scelta errata");
        // }

        System.out.println("Inserisci l'ammontare da versare (eg. 1250.50):");
        double pagamentoMensile = tastiera.nextDouble();

        while (debito > 0) {
            System.out.println(debito);

            debito -= pagamentoMensile;
            double interesseMensile = debito * ((interesse / 100) / 12);
            debito += debito * ((interesse / 100) / 12);
            System.out.println(interesseMensile);
            System.out.println(debito);
            count++;
        }
        System.out.println("Hai impiegato " + count / 12 + " anni per estinguere l'ipoteca!");
        System.out.println("Ciao!");
        tastiera.close();
    }

}
```
