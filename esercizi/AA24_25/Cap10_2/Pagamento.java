public class Pagamento {
    private static double soglia = 200;
    private double importo;

    public Pagamento() {
        this.importo = 0;
    }

    public Pagamento(double importo) {
        this.importo = importo;
    }

    public static double getSoglia() {
        return soglia;
    }

    public static void setSoglia(double soglia) {
        Pagamento.soglia = soglia;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public void dettaglioPagamento() {
        System.out.println("Pagamento di importo pari a " + importo);
    }
}
