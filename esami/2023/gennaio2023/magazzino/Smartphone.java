package magazzino;

public class Smartphone extends Device{

    private int camera;

    public Smartphone(String marca, String modello, double display, String connessione, int peso, int codice, int camera) {
        super(marca, modello, display, connessione, peso, codice);
        this.camera = camera;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Smartphone [camera=" + camera + "]";
    }


}
