/*
 * StringLinkedIteratorFragments.java
 *
 * Created on June 5, 2007, 3:05 PM
 *
 * Solution to Exercises 13, 14, 15
 */

/**
 *
 * @author charleshoot
 */

import java.io.*;
import java.util.*;

public class ListaConcatenataDiStringheConIteratoreFrammento {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
    	ListaConcatenataDiStringheConIteratore list = new ListaConcatenataDiStringheConIteratore();
        System.out.println("Aggiunge a, b, c, c ad una lista vuota");        
        list.aggiungiNodoInTesta("c");
        list.aggiungiNodoInTesta("c");
        list.aggiungiNodoInTesta("b");
        list.aggiungiNodoInTesta("a");
        
        System.out.println("La lista e' ");
        list.mostraLista();
        
// Soluzione dell'Esercizio 4        
        // Posizona l'iteratore all'inizio della lista
        list.reimpostaIterazione();
        while(list.altriElementi()){
            String data = list.getDatiDaNodoCorrente();
            list.inserisciDopoNodoCorrente(data);
            // Salta il dato appena inserito e il successivo
            list.vaiAlSuccessivo();
            list.vaiAlSuccessivo();
        }        
        System.out.println("Ogni elemento della lista dovrebbe essere ripetuto");
        list.mostraLista();
        
        
// Soluzione dell'Esercizio 5
        list.reimpostaIterazione();
        String data = list.getDatiDaNodoCorrente();
        list.eliminaNodoCorrente();
        // Itera finoalla fine della lista
        for(int i=0; i<list.lunghezza()-1; i++){
            list.vaiAlSuccessivo();
        }
        list.inserisciDopoNodoCorrente(data);
        
        System.out.println("Il primo valore dovrebbe essere spostato alla fine della lista");
        list.mostraLista();
        
        
// Soluzione dell'Esercizio 6
        list.reimpostaIterazione();
        while(list.altriElementi()) {
            String daScambiare = list.getDatiDaNodoCorrente();
            list.eliminaNodoCorrente();
            list.inserisciDopoNodoCorrente(daScambiare);
            list.vaiAlSuccessivo();
            list.vaiAlSuccessivo();
        }
        System.out.println("Ogni coppia di sringhe dovrebbero essere state scambiate.");
        list.mostraLista();
    }
}


