
public class GruppoAlieni {
    private Alieno[] alieno;

    public GruppoAlieni(int alieniNum) {
        alieno = new Alieno[alieniNum];
    }

    public void aggiungiAlieno(Alieno nuovoAlieno, int indice) {
        alieno[indice] = nuovoAlieno;
    }

    public Alieno[] getAlieni() {
        return alieno;
    }

    public int calcolaDanno() {
        int danno = 0;
        for (int i = 0; i < alieno.length; i++) {
            if (alieno[i] instanceof Serpente)
                danno += ((Serpente) alieno[i]).bite();
            else
                danno += alieno[i].getDanno();

        }
        return danno;
    }
}
