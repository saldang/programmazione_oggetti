import java.util.ArrayList;

public class Albergo {

    public static void main(String[] args) {
        ArrayList<Camera> camere = new ArrayList<Camera>();
        camere.add(new CameraNormale(1, 100, "Libera"));
        camere.add(new CameraLusso(2, 200, "Libera", true, false));
        camere.add(new CameraLusso(3, 250, "Libera", true, true));

        ArrayList<Cliente> clienti = new ArrayList<>(1);
        Adulto salvatore = new Adulto("Salvatore", "DAngelo", "CA12345SD");
        Adulto anna = new Adulto("Anna", "Rossi", "U1234567Z");
        clienti.add(salvatore);
        clienti.add(anna);
        clienti.add(new Bambino("Alberto", "DAngelo", salvatore, anna));

        for (Cliente cliente : clienti) {
            cliente.info();
        }

        for (Camera camera : camere) {
            camera.info();

        }
    }
}