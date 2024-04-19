// Classe che converte i voti in lettere in voti in numeri
public class Grade {
    private String votoL;
    private double votoN;
    private String segno;
    // per il segno + si aggiunge,per il segno - si sottrae
    final static double SEGNO = 0.3;

    public void setVoto(String input){
        votoL = input;
    }

    public double getNumericGrade() {
        //String  si separa il voto(lettera) dal segno
        String lettera = votoL.substring(0, 1);
        segno = votoL.substring(1);
        if (lettera.equalsIgnoreCase("A")) {
            votoN = 4;
            if (segno.equals("-"))
                votoN = votoN - SEGNO;
        } else if (lettera.equalsIgnoreCase("B"))
            votoN = 3;
        else if (lettera.equalsIgnoreCase("C"))
            votoN = 2;
        else if (lettera.equalsIgnoreCase("D"))
            votoN = 1;
        else if (lettera.equalsIgnoreCase("F"))
            votoN = 0;
        if (lettera.equalsIgnoreCase("B") || lettera.equalsIgnoreCase("C") ||
                lettera.equalsIgnoreCase("D")) {
            if (segno.equals("+"))
                votoN = votoN + SEGNO;
            else if (segno.equals("-"))
                votoN = votoN - SEGNO;
        }
        return votoN;
    }
}
