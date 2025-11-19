package esame.albergo2025;

public interface Prenotabile {
    void prenota(Cliente cliente) throws CameraOccupatException;

    void libera();

    boolean isPrenotata();
}
