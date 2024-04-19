package es1;

import java.util.Scanner;

public class BankAccountTester {
    public static void main(String[] args) {
        // si inizializza la variabile che mi servirà per inserire I dati
        // dalla tastiera
        Scanner in = new Scanner(System.in);

        in.useDelimiter(System.getProperty("line.separator"));

        // si costruisce un primo conto con saldo iniziale pari a zero e
        // password definita dall’utente
        System.out.println("Inserire un numero che sarà password del conto 1");
        String pass1 = in.next();

        BankAccount conto1 = new BankAccount(in.next());
        // stampa di verifica dei dati inseriti
        System.out.println("Il saldo del conto 1 è: " + conto1.getBalance()
                + "\nla password del conto 1 è: " + conto1.getPassword());
        // si costruisce un secondo conto con saldo iniziale e
        // password definiti dall’utente
        System.out.println("Inserire un numero che sarà password del conto 2");
        String pass2 = in.next();
        System.out.println("Inserire il saldo iniziale del conto 2");
        BankAccount conto2 = new BankAccount(in.nextDouble(),
                pass2);
        // stampa di verifica dei dati inseriti
        System.out.println("Il saldo del conto 2 è: " + conto2.getBalance()
                + "\nla password del conto 2 è: " + conto2.getPassword());
        // si preleva una somma dal conto 2
        System.out.println("Prelievo dal conto 2:\nInserire la password del conto 2");
        pass2 = in.next();
        System.out.println("Inserire la somma da prelevare:");
        double amount = in.nextDouble();
        conto2.withdraw(amount, pass2);

        // si versa una somma sul conto 1
        System.out.println("Versamento sul conto 1:\nInserire la password del conto 1");
        pass1 = in.next();
        System.out.println("Inserire la somma da versare:");
        conto1.deposit(in.nextDouble(), pass1);
        // stampa un resoconto dei saldi
        System.out.println("Nuovi saldi:\nconto 1: " + conto1.getBalance() +
                "\nconto 2: " + conto2.getBalance());
        // applica l’interesse sui due conti e stampa i saldi aggiornati
        conto1.addInterest(3);
        conto2.addInterest(3);
        System.out.println("Nuovi saldi con interesse applicato del 3%:");
        System.out.println("conto 1: " + conto1.getBalance() + "\nconto 2: " + conto2.getBalance());
    }
}
