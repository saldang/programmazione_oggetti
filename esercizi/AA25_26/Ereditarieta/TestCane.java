public class TestCane {
    public static void main(String[] args) {
        Cane[] cani = new Cane[5];
        cani[0] = new Cane("Pippo", 3, 13, "Pitbull", true);
        cani[1] = new Cane("Pluto", 3, 13, "Pitbull", false);
        cani[2] = new Cane("Paperino", 1, 13, "Pitbull", true);
        cani[3] = new Cane("Pippo2", 3, 13, "Pitbull", false);
        cani[4] = new Cane("Pippo3", 2, 13, "Pitbull", true);

        for (Cane cane : cani) {
            if (cane.getEta() > 2 && !cane.getComandoDiRichiamo()) {
                System.out.println(cane.getNome());
                System.out.println(cane.getRazza());
            }
        }
    }
}
