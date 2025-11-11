public class CameraLusso extends Camera implements HasTV {
    private boolean condizionatore;
    private boolean tvGrande;

    public CameraLusso(double prezzo, String stato, boolean tvGrande, int occupanti, boolean condizionatore) {
        super(prezzo, stato, occupanti);
        this.condizionatore = condizionatore;
        this.tvGrande = tvGrande;
    }

    public boolean hasCondizionatore() {
        return condizionatore;
    }

    @Override
    public void pulisci() {

        System.out.println("Pulita camera di lusso!");
    }

    @Override
    public String informazioni() {
        return super.informazioni()
                + ((hasCondizionatore()) ? "Condizionatore Presente" : "Condizionatore Non Presente")
                + "\n"
                + ((hasTV()) ? "TV Grande Presente" : "TV Grande Non Presente");
    }

    private boolean hasTV() {
        return this instanceof HasTV;
    }

    public void accendiCondizionatore() {
        System.out.println("Condizionatore Acceso");
    }

    public void spegniCondizionatore() {
        System.out.println("Condizionatore spento");
    }

    @Override
    public void accendiTV() {
        System.out.println("Accendi tv");
    }

    @Override
    public void spegniTV() {
        System.out.println("Spegni tv");
    }

}
