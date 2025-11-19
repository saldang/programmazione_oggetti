package esame.albergo2025;

public abstract class Camera implements Prenotabile, Pagabile {
    private final int numero;
    private final double prezzoPerNotte;
    private final int maxOspiti;
    private boolean disponibile;
    private Cliente clienteAttuale;

    protected Camera(int numero, double prezzoPerNotte, int maxOspiti) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Il numero della camera deve essere positivo");
        }
        if (prezzoPerNotte <= 0) {
            throw new IllegalArgumentException("Il prezzo per notte deve essere positivo");
        }
        if (maxOspiti <= 0) {
            throw new IllegalArgumentException("Il numero massimo di ospiti deve essere positivo");
        }
        this.numero = numero;
        this.prezzoPerNotte = prezzoPerNotte;
        this.maxOspiti = maxOspiti;
        this.disponibile = true;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrezzoPerNotte() {
        return prezzoPerNotte;
    }

    public int getMaxOspiti() {
        return maxOspiti;
    }

    public Cliente getClienteAttuale() {
        return clienteAttuale;
    }

    @Override
    public void prenota(Cliente cliente) throws CameraOccupatException {
        if (cliente == null) {
            throw new IllegalArgumentException("Il cliente non può essere null");
        }
        if (!disponibile) {
            throw new CameraOccupatException("La camera numero " + numero + " è già occupata per le date richieste");
        }
        this.disponibile = false;
        this.clienteAttuale = cliente;
    }

    @Override
    public void libera() {
        this.disponibile = true;
        this.clienteAttuale = null;
    }

    @Override
    public boolean isPrenotata() {
        return !disponibile;
    }

    protected String statoDisponibilita() {
        return disponibile ? "Disponibile" : "Occupata";
    }

    public abstract String visualizzaDettagli();
}
