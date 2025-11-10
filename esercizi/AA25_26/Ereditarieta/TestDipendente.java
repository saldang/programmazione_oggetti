public class TestDipendente {
    public static void main(String[] args) {
        Dipendente d1 = new Dipendente();
        Dipendente d2 = new Dipendente("Salvatore");
        Dipendente d3 = new Dipendente("Giuseppe", 40000, 2002, "UNI003");

        d1.setNome("Francesco");
        d1.setAnnoAssunzione(2000);
        d1.setRetribuzioneAnnuale(20000);
        d1.setId("UNI002");

        d2.setAnnoAssunzione(2020);
        d2.setRetribuzioneAnnuale(40000);
        d2.setId("UNI003");

        System.out.println(d2.equals(d3));
        System.out.println(d1.getId());
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
