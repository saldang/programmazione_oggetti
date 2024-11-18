public class CameraLusso extends Camera {
    private boolean tv;
    private boolean condizionatore;

    CameraLusso(int numero, double prezzo, String stato, boolean tv, boolean condizionatore) {
        super(numero, prezzo, stato);
        this.tv = tv;
        this.condizionatore = condizionatore;
    }

    public void accendiTV() {
        System.out.println("TV Accesa!");
    }

    public void accendiClima() {
        System.out.println("Clima acceso!");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Tipo: Lusso");
        if (tv && condizionatore)
            System.out.println("Extra: Tv, Clima");
        else if (tv && !condizionatore) {
            System.out.println("Extra: Tv");
        } else {
            System.out.println("Extra: Clima");

        }
    }
}
