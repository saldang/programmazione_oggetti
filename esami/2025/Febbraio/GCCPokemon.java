public class GCCPokemon {
    public static void main(String[] args) {
        Allenatore ash = new Allenatore("Ash");
        Allenatore gary = new Allenatore("Gary");
        Partita partita = new Partita(ash, gary);
        partita.iniziaPartita();
    }
}
