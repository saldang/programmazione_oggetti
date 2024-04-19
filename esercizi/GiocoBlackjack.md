# Blackjack semplificato

Scrivere un programma che esegua una versione semplificata del gioco blackjack utilizzando i dadi. Anziché estrarre una carta da un mazzo di carte, viene lanciato un dado a 14 facce per rappresentare una carta. Le regole del gioco per una mano giocata contro il banco sono le seguenti:

1. un lancio di dadi seleziona a caso i valori da 2 a 10 oppure fante, regina, re o asso. Un asso vale sempre 11. Il fante, la regina e il re valgono 10. In altre parole, con la stessa probabilità, ogni lancio seleziona uno di questi valori: 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11;

2. il giocatore fa una puntata. La puntata deve essere positiva e non deve superare la quantità di denaro posseduta dal giocatore;

3. il giocatore dispone di due dadi. Il banco, rappresentato dal computer, dispone di un solo dado. Al giocatore viene mostrato il valore del lancio effettuato dal banco;

4. se il totale del lancio dei dadi è 22 o più, il giocatore “sballa”, perde la puntata e la mano si conclude

5. se il totale del lancio dei dadi è 21 o meno, il giocatore ha la possibilità di passare o di chiedere una carta aggiuntiva. Se il giocatore decide di chiedere una carta aggiuntiva, allora può effettua il lancio di un dado. Si ritorna al punto 4. Se il giocatore sceglie di passare, allora si prosegue al punto 6.

6. adesso è il turno del banco, che effettua un altro lancio, il cui valore viene sommato al precedente. Se il punteggio totale è minore di 17, il banco deve effettuare un altro lancio. Se il punteggio totale è 22 o più, allora il banco sballa, il giocatore vince la puntata e la mano si conclude. Il banco deve continuare a lanciare finché non sballa o non raggiunge un punteggio totale compreso tra 17 e 21;

7. se il banco non sballa, il suo punteggio totale viene confrontato con quello del giocatore. Se i due punteggi sono uguali, allora la mano è “pari”, e il giocatore non vince e non perde. Se il punteggio totale del banco è maggiore di quello del giocatore, il giocatore perde la puntata. Se il punteggio totale del giocatore è maggiore di quello del banco, il giocatore vince la puntata.

Scrivere un programma che ripete una mano finché il giocatore non decide di smettere o perde tutto il denaro. Il giocatore dispone inizialmente di 100 euro.

Progettare il programma utilizzando classi e metodi. L’intero programma non dovrà essere in un singolo metodo main.
