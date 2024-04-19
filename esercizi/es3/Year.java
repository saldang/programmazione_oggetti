package es3;

public class Year {
    private int anno;

    public Year(int unAnno) {
        anno = unAnno;
    }

    /*
     * Un anno è bisestile se è divisibile per 400 oppure per 4 ma non per 100.
     * Questo metodo controlla tale proprietà.
     *
     * @return true se è bisestile, false se non lo è
     */
    public boolean isLeapYear() {
        int resto1 = anno % 400;
        int resto2 = anno % 4;
        int resto3 = anno % 100;
        if (resto1 == 0 || (resto2 == 0 && resto3 != 0))
            return true;
        else
            return false;
    }

    /*
     * restituisce il valore della variabile anno
     * 23
     *
     * @return l’anno
     */
    public int getYear() {
        return anno;
    }
}
