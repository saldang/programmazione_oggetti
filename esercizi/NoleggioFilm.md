# Noleggio Film

Si definisca una classe astratta Film che rappresenta un film preso a noleggio da una videoteca. Nella classe Film si deve definire un codice identificativo e un titolo. Si definiscano per questi attributi i metodi get e set. Si definisca anche un metodo equals che sovrascrive quello ereditato da Object e che restituisce true se due film hanno il loro codice identificativo uguale.

Si creino, inoltre, tre classi derivate dalla classe Film chiamate Azione, Commedia e Dramma. In ultimo, si crei un metodo ridefinito chiamato calcolaPenaleRitardo che prende in ingresso il numero di giorni di ritardo per un film e restituisce la penale per quel film. La penale predefinita è di Euro 2 al giorno. I film di azione hanno una penale pari a Euro 3 al giorno, le commedie Euro 2.50 al giorno e i film drammatici Euro 2 al giorno.

Si verifichino le classi in un metodo main.

Si estenda il progetto precedente realizzando una classe Noleggio. Questa classe dovrebbe memorizzare il Film che è stato noleggiato, un numero intero che rappresenta il documento d'identificazione del cliente che ha affittato il film e un numero intero che rappresenta il numero di giorni di ritardo del film. Si aggiunga un metodo che calcola le penali per il noleggio.

Si crei un’altra classe in cui si definisce il metodo main. Nel metodo main si crei un array di tipo base Noleggio e lo si riempia con i dati per tutti i tipi di film.

Si crei, quindi, un metodo calcolaPenaliRitardo che itera attraverso l’array e restituisce l'ammontare totale di penali che devono essere incassate.
