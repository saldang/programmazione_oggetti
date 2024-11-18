public abstract class Camera {
    private int numero;
    private double prezzo;
    private String stato;
    

    public Camera(int numero, double prezzo, String stato) {
        this.numero = numero;
        this.prezzo = prezzo;
        this.stato = stato;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public void pulisci() {
        System.out.println("Camera pulita!");
    }

    public void info() {
        System.out.println("Camera:"+numero+" ;prezzo:"+prezzo+" stato:"+stato);
    }

}
