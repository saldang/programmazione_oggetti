class Struccante {
    private String s = new String("Detersivo");

    @Override
    public String toString() {
        return s;
    }

    public void append(String a) {
        s += a;
    }

    void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void pulisci() {
        append(" pulisci()");
    }

    public static void main(String[] args) {
        Struccante x = new Struccante();
        x.dilute();
        x.apply();
        x.pulisci();
        System.out.println(x.toString());
    }
}
