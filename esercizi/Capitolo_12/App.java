import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Animale> animali = new ArrayList<>();
        Scanner tastiera = new Scanner(System.in);
        String risposta = "";
        while (!risposta.equalsIgnoreCase("n")) {
            System.out.println("Vuoi inserire un animale? (s/n)");
            risposta = tastiera.nextLine();
            if (risposta.equalsIgnoreCase("s")) {
                System.out.println("Inserisci il nome dell'animale");
                String nome = tastiera.nextLine();
                System.out.println("Inserisci l'età dell'animale");
                int eta = Integer.parseInt(tastiera.nextLine());
                System.out.println("Inserisci il peso dell'animale");
                double peso = Double.parseDouble(tastiera.nextLine());
                animali.add(new Animale(nome, eta, peso));

            } else if (risposta.equalsIgnoreCase("n")) {
                System.out.println("Ok, non inserisco nessun animale");
            } else {
                System.out.println("Risposta non valida");
            }
        }

        // animali.sort(null);
        animali.sort(new Comparator<Animale>() {
        //     @Override
        //     public int compare(Animale o1, Animale o2) {
        //         if (o1.getEta() > o2.getEta()) {
        //             return 1;
        //         } else if (o1.getEta() < o2.getEta()) {
        //             return -1;
        //         } else {
        //             return 0;
        //         }
        //     }
                @Override
                public int compare(Animale o1, Animale o2) {
                    return o1.getNome().compareTo(o2.getNome());
                }
        });

        for (int i = 0; i < animali.size(); i++) {
            System.out.println(animali.get(i));
        }

        tastiera.close();
    }
}
