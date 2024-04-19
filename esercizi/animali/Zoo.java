package animali;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Zoo
 */
public class Zoo {

    public static void main(String[] args) {
        String inpuString = "";
        InputStreamReader is = null;
        BufferedReader br = null;
        BufferedReader brf = null;
        FileReader fr = null;
        ArrayList<Animale> zoo = new ArrayList<>();
        try {
            fr = new FileReader(
                    "/home/salvatoredangelo/Insync/totore86@gmail.com/Google Drive/RTDa2021/Didattica/PAO-ASD/PAO/dangelo/Esercizi/animali/animali.txt");
        } catch (FileNotFoundException e1) {
            System.out.println("File non trovato");
            System.exit(2);
        }

        try {
            is = new InputStreamReader(System.in);
        } catch (Exception e) {
            System.out.println("Errore apertura InputStream");
            System.exit(1);
        }

        try {
            br = new BufferedReader(is);
        } catch (Exception e) {
            System.out.println("Errore BufferedReader InputStream");
            System.exit(2);
        }
        try {
            brf = new BufferedReader(fr);
        } catch (Exception e) {
            System.out.println("Errore BufferedReader FileReader");
            System.exit(2);
        }
        boolean esci = false;
        while (!esci) {
            int scelta = 0;
            System.out.println("1 - Inserisci Animale");
            System.out.println("2 - Ordina Animali");
            System.out.println("3 - Ordina Animali (per peso) ");
            System.out.println("5 - Leggi da file");
            System.out.println("4 - Esci");

            try {
                scelta = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("Errore buffer lettura");
                System.exit(3);
            } catch (NumberFormatException e) {
                System.out.println("Errore parse scelta");
                System.exit(3);
            }
            switch (scelta) {
                case 0:
                    System.out.println("Non hai effettuato una scelta");
                    break;
                case 1: {
                    try {
                        System.out.println("Inserisci nome, eta e peso dell'animale:");
                        inpuString = br.readLine();
                        String[] input = inpuString.split(" ");
                        zoo.add(new Animale(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                    } catch (NumberFormatException e) {
                        System.out.println("Errore parse Eta o Peso");
                        System.exit(scelta);
                    } catch (IOException e) {
                        System.out.println("Errore lettura buffer");
                        System.exit(scelta);
                    }
                }
                    break;
                case 2: {
                    zoo.sort(null);
                    for (Animale animale : zoo) {
                        System.out.println(animale.toString());
                    }
                }
                    break;
                case 3: {
                    Comparator<Animale> comparePeso = new Comparator<Animale>() {
                        @Override
                        public int compare(Animale arg0, Animale arg1) {
                            if (arg0.peso > arg1.peso)
                                return 1;
                            else if (arg0.peso < arg1.peso)
                                return -1;
                            else
                                return 0;
                        }
                    };
                    zoo.sort(comparePeso);
                    for (Animale animale : zoo) {
                        System.out.println(animale.toString());

                    }
                }
                    break;
                case 5: {
                    try {
                        inpuString = brf.readLine();
                        while (inpuString != null) {
                            String[] input = inpuString.split(" ");
                            zoo.add(new Animale(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                            inpuString = brf.readLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Errore lettura file");
                        System.exit(scelta);
                    }
                }
                    break;
                case 4:
                    esci = true;
                    break;
                default:
                    System.out.println("1 errata");
                    break;
            }

        }

    }
}
