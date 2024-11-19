---
layout: page
title: Capitolo 2 Esercizio 1
permalink: /esercizi/AA24_25/Cap2_2/
---

## {{page.title}}

[Visualizza Cap2_2.java](./Cap2_2.java)

```java
import java.util.Scanner;

public class Cap2_2 {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String s1, s2;
        System.out.println("Inserisci la prima stringa:");
        s1 = tastiera.next();
        System.out.println("Inserisci la seconda stringa:");
        s2 = tastiera.next();

        System.out.println(s1 + " e' lunga " + s1.length());
        System.out.println(s2 + " e' lunga " + s2.length());

        String s3 = s1.concat(" ").concat(s2);
        //String s3 = s1 + " " + s2;
        System.out.println(s3 + " e' lunga " + s3.length());

    }
}
```
