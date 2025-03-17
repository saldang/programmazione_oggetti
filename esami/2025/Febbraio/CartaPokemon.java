public class CartaPokemon extends Carta {
    private int puntiVitaIniziali;
    private int puntiVita;
    private int attacco;
    private int energiaNecessaria;
    private int energiaAssegnata = 0;

    public CartaPokemon(String nome, String descrizione, int puntiVita, int attacco,
            int energiaNecessaria) {
        super(nome, descrizione);
        this.puntiVitaIniziali = puntiVita;
        this.puntiVita = puntiVita;
        this.attacco = attacco;
        this.energiaNecessaria = energiaNecessaria;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getEnergiaNecessaria() {
        return energiaNecessaria;
    }

    public void setEnergiaNecessaria(int energiaNecessaria) {
        this.energiaNecessaria = energiaNecessaria;
    }

    public int getEnergiaAssegnata() {
        return energiaAssegnata;
    }

    public void setEnergiaAssegnata(int energiaAssegnata) {
        this.energiaAssegnata = energiaAssegnata;
    }

    public void subisciDanni(int attacco2) {
        puntiVita -= attacco2;
        if (puntiVita < 0) {
            puntiVita = 0;
        }
    }

    public int getPuntiVitaIniziali() {
        return puntiVitaIniziali;
    }

}
