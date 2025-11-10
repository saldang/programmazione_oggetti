public class App {
    public static void main(String[] args) {
        Paziente p1 = new Paziente("Antonio", "a001");
        Paziente p2 = new Paziente("Salvatore", "a002");

        Dottore d1 = new Dottore("Salvatore", "pediatria", 50.0);
        Dottore d2 = new Dottore("Antonio", "dentista", 150.0);

        Fattura f1 = new Fattura(p1, d2);
        Fattura f2 = new Fattura(p2, d2);


        double guadagnoTotale = 0;

        guadagnoTotale += f1.getDottore().getParcella();
        if (f2.equals(f1))
            guadagnoTotale += f2.getDottore().getParcella();

        System.out.println(guadagnoTotale);
    }
}
