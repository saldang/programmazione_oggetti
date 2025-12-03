public abstract class Veicolo implements Guidabile {

    private String marca;
    private String modello;
    private int anno;
    private String colore;
    private boolean assistenzaElettrica;
    private double valore;

    protected Veicolo(String marca, String modello, int anno, String colore, double valore) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.colore = colore;
        this.valore = valore;
        this.assistenzaElettrica = false;
    }

    protected Veicolo(String marca, String modello, int anno, String colore, boolean assistenzaElettrica,
            double valore) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.colore = colore;
        this.assistenzaElettrica = assistenzaElettrica;
        this.valore = valore;
    }

    abstract double calcolaValoreMercato();

    abstract String visualizzaInformazioniVeicolo();

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getAnno() {
        return anno;
    }

    public String getColore() {
        return colore;
    }

    public boolean isAssistenzaElettrica() {
        return assistenzaElettrica;
    }

    public double getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return " - Marca:" + marca + "\n - Modello:" + modello + "\n - Anno:" + anno + "\n - Colore:" + colore
                + "\n - Valore:" + valore;
    }

    @Override
    public boolean equals(Object obj) {
        return (((Veicolo) obj).marca.equalsIgnoreCase(marca) && ((Veicolo) obj).modello.equalsIgnoreCase(modello));
    }

}
