package es3;

import java.util.Scanner;

import es5.Car;

public class YearTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci un anno ");
        Year anno = new Year(input.nextInt());
        if (anno.isLeapYear())
            System.out.println("L'anno " + anno.getYear() + " è bisestile.");
        else
            System.out.println("L'anno " + anno.getYear() + " non è  bisestile.");
    }

}
