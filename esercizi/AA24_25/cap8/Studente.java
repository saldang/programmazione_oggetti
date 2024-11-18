public class Studente {
    private char lettera;
    private float votoFinale;
    private float esameFinale;
    private float[] esamiIntermedi = new float[2];
    private float[] esercizi = new float[2];

    public char getLettera() {
        return lettera;
    }

    public float getVotoFinale() {
        return votoFinale;
    }

    public float getEsameFinale() {
        return esameFinale;
    }

    public void setEsameFinale(float esameFinale) {
        this.esameFinale = esameFinale;
    }

    public float[] getEsamiIntermedi() {
        return esamiIntermedi;
    }

    public void setEsamiIntermedi(float voto, int index) {
        if (voto >= 0 && voto <= 100)
            esamiIntermedi[index] = voto;
        else {
            System.out.println("Valore non corretto, impostato il valore 10");
            esamiIntermedi[index] = 10;
        }
    }

    public float[] getEsercizi() {
        return esercizi;
    }

    public void setEsercizi(float voto, int index) {
        if (voto >= 0 && voto <= 10)
            esercizi[index] = voto;
        else {
            System.out.println("Valore non corretto, impostato il valore 1");
            esercizi[index] = 1;
        }

    }

    public void calcolaVotoFinale() {
        votoFinale = esameFinale * 0.5F;
        float sumIntermedi = 0;
        for (float f : esamiIntermedi) {
            sumIntermedi += f;
        }
        votoFinale += (sumIntermedi / esamiIntermedi.length) * 0.25F;
        float sumEsercizi = 0;
        for (float f : esercizi) {
            sumEsercizi += (f * 10);
        }
        votoFinale += (sumEsercizi / esercizi.length) * 0.25;

    }

    public void calcolaVotoLettera() {
        if (votoFinale >= 90)
            lettera = 'A';
        else if (votoFinale < 90 && votoFinale >= 80)
            lettera = 'B';
        else if (votoFinale < 80 && votoFinale >= 70)
            lettera = 'C';
        else if (votoFinale < 70 && votoFinale >= 60)
            lettera = 'D';
        else
            lettera = 'F';
    }
}
