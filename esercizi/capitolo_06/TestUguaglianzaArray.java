/**
 * Esempio di programma che verifica se due array sono uguali.
 */
public class TestUguaglianzaArray {

    public static void main(String[] args) {
        int[] a = new int[3];
        int[] b = new int[3];
        setArray(a);
        setArray(b);
        
        if (b == a)
            System.out.println("Uguali secondo l'operatore ==.");
        else
            System.out.println("Diversi secondo l'operatore ==.");

        if (equals(b, a))
            System.out.println("Uguali secondo il metodo equals.");
        else
            System.out.println("Diversi secondo il metodo equals.");
    }

    public static boolean equals(int[] a, int[] b) {
        //boolean elementiUguali = true;// si ipotizza che gli array siano uguali
        if (a.length != b.length)
            return false;
        else {
            int i = 0;
            while (i < a.length) {
                if (a[i] != b[i])
                    return false;
                i++;
            }
        }
        return true;
    }

    public static void setArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i;
    }
}