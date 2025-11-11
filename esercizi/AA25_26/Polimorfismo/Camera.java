abstract class Camera {
    private double prezzo;
    private String stato;
    private Cliente[] clienti;

    public Cliente[] getClienti() {
        return clienti;
    }

    private int occupanti = 0;

    protected Camera(double prezzo, String stato, int maxPersone) {
        this.prezzo = prezzo;
        this.stato = stato;
        clienti = new Cliente[maxPersone];
    }

    abstract void pulisci();

    public String informazioni() {
        String occupanti = "";
        for (Cliente cliente : getClienti()) {
            occupanti += cliente.toString() + "\n \t";

        }
        return "Camera: prezzo " + prezzo + "\n \tstato " + stato + "\n \tOccupanti: " + "\n \t" + occupanti;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public void aggiungiCliente(Cliente c) {
        if (this.occupanti < clienti.length) {
            clienti[occupanti] = c;
            occupanti++;
        } else {
            System.out.println("Stanza piena");
        }

    }

    public int getMaxClienti() {
        return clienti.length;
    }
}
