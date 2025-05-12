public class MainGara {
    public static void main(String[] args) {
        GaraMagica gara = new GaraMagica();
        try {
            gara.caricaPartecipantiDaFile("animali.txt");
        } catch (AnimaleNonValidoException e) {
            System.out.println("Errore durante il caricamento dei partecipanti: " + e.getMessage());
        }

        gara.simulaGara(300);

        gara.salvaPartecipantiSuFile("risultati.txt");
        System.out.println("Gara completata. Risultati salvati in risultati.txt");
    }
}
