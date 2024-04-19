package aprile2023;

public enum Moneta {
    UNCENT(0.01),
    DUECENT(0.02),
    CINQUECENT(0.05),
    DIECICENT(0.1),
    VENTICENT(0.2),
    CINQUANTACENT(0.5),
    UNEURO(1),
    DUEEURO(2);


    private final double valore;

    Moneta(double valore) {
        this.valore = valore;
    }

    public double getValore() {
        return valore;
    }
}

