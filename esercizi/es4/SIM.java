package es4;

public class SIM {
    private String numero;
    private int eff;
    private float credito;
    private TEL T[];// dichiarazione del vettore delle chiamate

    SIM(String n, int c, int dim) {
        numero = n;
        credito = c;
        eff = 0;// eff:chiamate effettuate
        T = new TEL[dim];// allocazione del vettore delle chiamate
    }

    public void ins(String num, int tempo) {
        if (eff < T.length) {
            TEL t = new TEL(num, tempo);
            T[eff] = t;
            credito -= (float) tempo / 4;// 25cent/min
            eff++;
        } else
            System.out.println("max chiamate effettuate");
    }// fine ins

    public int cal() {
        int tot = 0;
        for (int i = 0; i < eff; i++)
            tot += T[i].getd();
        return tot;
    }// fine cal

    public int conta(String n) {
        int tot = 0;
        for (int i = 0; i < eff; i++)
            if (T[i].getn().equals(n))
                tot++;
        return tot;
    }// fine conta

    public String getn() {
        return numero;
    }

    public float getc() {
        return credito;
    }

    public String toString() {
        String st = "numero:" + getn() + " credito:" + getc() + "\n";
        for (int i = 0; i < eff; i++)
            st += T[i].getn() + " " + T[i].getd() + "\n";
        return st;
    }// fine toString()
}// fine classe SIM
