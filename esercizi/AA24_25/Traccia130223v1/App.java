public class App {
    public static void main(String[] args) {
        Dipendente[] dipendenti = new Dipendente[4];
        dipendenti[0] = new Developer("d001", "davide", 1500, Esperienza.JUNIOR);
        dipendenti[1] = new Developer("d002", "ciro", 2500, Esperienza.MID);
        dipendenti[2] = new SeniorDeveloper("d001", "davide", 3500);
        dipendenti[3] = new ProjectManager("d001", "davide", 2500, 5);

        for (Dipendente dipendente : dipendenti) {
            System.out.println(dipendente.bonusAnnuale());
        }
    }
}
