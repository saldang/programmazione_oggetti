public class App {
    public static void main(String[] args) {
        Gestore gestore = new Gestore("stock.csv");
        String[] tests={"1,Apple","7,0,200","9,false"};
        for (String test : tests) {

            gestore.raggruppaProdotti(test);
            gestore.raggruppamento.clear();
        }

    }
}
