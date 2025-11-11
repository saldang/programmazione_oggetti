public class CameraNormale extends Camera {
    private boolean tv;

    public boolean hasTv() {
        return tv;
    }

    public CameraNormale(double prezzo, String stato, int occupanti, boolean tv) {
        super(prezzo, stato, occupanti);
        this.tv = tv;
    }

    @Override
    public void pulisci() {
        System.out.println("La camera e' stata pulita!");
    }

    @Override
    public String informazioni() {

        return super.informazioni() + ((hasTv()) ? "TV presente" : "TV assente");
    }

    public void accendiTV() {
        System.out.println("TV Accesa!");
    }

    public void spegniTV() {
        System.out.println("TV Spenta!");
    }
}
