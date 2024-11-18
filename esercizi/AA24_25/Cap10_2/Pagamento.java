public class Pagamento {

    private double importo;

    public Pagamento() {
        this.importo = 0;
    }

    public Pagamento(double importo) {
        this.importo = importo;
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