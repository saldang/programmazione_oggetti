import java.util.Scanner;

import Capitolo10.Persona;

public class Test {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.print("Inserisci il numero di veicoli da inserire:");
        int dimensione = tastiera.nextInt();
        Veicolo[] veicoli = new Veicolo[dimensione];

        for (int i = 0; i < veicoli.length; i++) {
            String inputCasaAuto = "Fiat";
            int inputCilindri = 5;
            String nomepersona = "Salvatore";
            int carico = 199;
            int rimorchio = 122;
            if (i % 2 == 0) {

                veicoli[i] = new Veicolo(inputCasaAuto, inputCilindri, new Persona(nomepersona));
            } else {
                veicoli[i] = new Camion(inputCasaAuto, inputCilindri, new Persona(nomepersona), carico, rimorchio);
            }
        }

        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i] instanceof Camion) {
                System.out.println(((Camion) veicoli[i]).getCapacitaCarico());
            }
            System.out.println(veicoli[i]);
        }
        tastiera.close();

    }

}
