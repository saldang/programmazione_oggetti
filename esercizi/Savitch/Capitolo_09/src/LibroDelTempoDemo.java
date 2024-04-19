public class LibroDelTempoDemo {
    public static void main(String[] args) {
        //1 Test i costruttore di default
        LibroDelTempo book1 = new LibroDelTempo();
        book1.getOre();
        book1.aggiorna();
        book1.visualizzaTabella();
        System.out.println("");

        //2 Test dei metodi di set
        LibroDelTempo book2 = new LibroDelTempo(3);
        book2.setOre();
        book2.aggiorna();
        System.out.println("");
        book2.visualizzaTabella();
        System.out.println("");

        System.out.println("Assegna 20 ore il venerdi' al dipendente #3");
        //Venerdi = 4
        book2.setOre(4, 3, 20);
        book2.aggiorna();
        System.out.println("");
        book2.visualizzaTabella();
        System.out.println("");

        System.out.println("Assegna ore per lunedi':");
        book2.setOreDipendentePerGiorno(0);
        System.out.println("Assegna ore per venerdi':");
        book2.setOreDipendentePerGiorno(4);
        book2.aggiorna();
        System.out.println("");
        book2.visualizzaTabella();
        System.out.println("");

        System.out.println("Assegna le ore al dipendente #1:");
        book2.setOrePerDipendente(1);
        System.out.println("Assegna le ore al dipendente #3:");
        book2.setOrePerDipendente(3);
        book2.aggiorna();
        System.out.println("");
        book2.visualizzaTabella();
        System.out.println("");

        //3 Test metodi di get

        System.out.println("Testing getNumeroDiDipendenti()");
        System.out.println("Numero di dipendenti = "
                           + book2.getNumeroDiDipendenti());
        System.out.println("");
        System.out.println("====================================");

        System.out.println("Ecco i dati in modo da sapere quali dovrebbero essere i valori nei test seguenti.");
        book2.visualizzaTabella();
        System.out.println("");
        System.out.println("Testing getOreGiornoPerImpiegato(giorno#, dipendente#)");
        for(int i = 0; i < 5; i++)//per ogni giorno
            for(int j = 0; j < book2.getNumeroDiDipendenti(); j++)
                System.out.println("Ore per il giorno#" + i
                                   + " e dipendente #" + (j+1) + " = "
                                   + book2.getOreGiornoPerDipendente(i, (j+1)));
        System.out.println("====================================");
        System.out.println("");

        System.out.println("Testing getOreSettimana(dipendente#)");
        for(int i = 0; i < book2.getNumeroDiDipendenti(); i++)
            System.out.println("Totale ore della settimana del dipendente #"
                               + (i+1) + " " + book2.getOreSettimana(i+1));
        System.out.println("====================================");
        System.out.println("");

        System.out.println("Testing getDayHours(giorno#)");
        for(int i = 0; i < 5; i++)//For each day
            System.out.println("Totale ore per il giorno# " + i + " = "
                               + book2.getOreGiorno(i));
    }
}