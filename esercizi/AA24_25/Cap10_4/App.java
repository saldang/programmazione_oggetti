public class App {
    public static void main(String[] args) {
        GruppoAlieni alieni = new GruppoAlieni(5);
        alieni.aggiungiAlieno(new Orco("asdasd", 100), 0);
        alieni.aggiungiAlieno(new Serpente("asdasd", 100), 1);
        alieni.aggiungiAlieno(new UomoMarshmellow("asdasd", 100), 2);
        alieni.aggiungiAlieno(new Orco("asdasd", 100), 3);
        alieni.aggiungiAlieno(new Serpente("asdasd", 100), 4);

        for (int i = 0; i < alieni.getAlieni().length; i++) {
            System.out.println(alieni.getAlieni()[i]);
        }
        System.out.println("Danno totale degli alieni:" + alieni.calcolaDanno());
    }
}
