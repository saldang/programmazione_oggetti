package segreteria;

import java.util.Scanner;

public class TestSegreteria {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Persona p = new Studente(123,"asdas", "asdasd");
        System.out.println("Inserisci il numero di studenti che puo registrare la segreteria:");
        int max = in.nextInt();
        Segreteria seg = new Segreteria(max);
        for (int i = 0; i < max; i++) {
            // byte[] array = new byte[7]; // length is bounded by 7
            // new Random().nextBytes(array);
            // String nome = new String(array, Charset.forName("ascii"));
            // String cognome = new String(array, Charset.forName("ascii"));
            // int matricola = new Random().nextInt();
            seg.registraStudente(new Studente(123410, "asas", "asas"));
        }
        Studente[] listaStudenti = seg.getStudenti();
        System.out.println(listaStudenti[0].equals(listaStudenti[1]));
        System.out.println(listaStudenti[0].hashCode() == listaStudenti[1].hashCode());
        System.out.println(listaStudenti[0].hashCode());

        StudenteFuoricorso s = new StudenteFuoricorso("sda", "qwe", 11111, 2);


        seg.stampaListaStudenti();
    }
}
