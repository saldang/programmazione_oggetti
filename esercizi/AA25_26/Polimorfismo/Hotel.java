import java.util.ArrayList;

public class Hotel {
    public static void main(String[] args) {
        ArrayList<Camera> camere = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            switch (i) {
                case 0:
                    camere.add(new CameraNormale(100, "Libera", 3, true));
                    break;
                case 1:
                    camere.add(new CameraLusso(200, "Libera", true, 2, true));
                    break;
                case 2:
                    camere.add(new CameraLusso(300, "Occupato", true, 3, true));
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < camere.size(); i++) {
            camere.get(i).pulisci();
        }
        for (Camera camera : camere) {
            if (camera instanceof CameraNormale cn) {
                for (int i = 0; i < camera.getMaxClienti(); i++) {
                    camera.aggiungiCliente(new Ragazzo("Salvatore", "Rossi", "CE12345CE"));
                }

            } else if (camera instanceof CameraLusso cl) {
                if (camera.getMaxClienti() == 3) {

                    Adulto genitore1 = new Adulto("Tizop", "Tizio", "AS1231231");
                    Adulto genitore2 = new Adulto("Caio", "Caio", "CC12312CC");
                    Bambino bambino = new Bambino("Sempronio", "Sempronio", genitore1, genitore2);

                    camera.aggiungiCliente(bambino);
                    camera.aggiungiCliente(genitore1);
                    camera.aggiungiCliente(genitore2);
                } else {
                    for (int i = 0; i < camera.getMaxClienti(); i++) {
                        camera.aggiungiCliente(new Ragazzo("Salvatore", "Rossi", "CE12345CE"));
                    }
                }

            }

        }
        for (Camera camera : camere) {
            System.out.println(camera.informazioni());
        }
    }
}
