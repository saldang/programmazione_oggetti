package Soluzione240424;
public class Allarme {
    private Boolean stato = false;
    private int volume = 10;

    public Boolean getStato() {
        return stato;
    }

    public void setStato(Boolean stato) {
        this.stato = stato;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void attiva() {
        this.stato = true;
    }

    public void disattiva() {
        this.stato = false;
    }

    public void suona() {
        for (int i = 0; i < volume; i++) {
            System.out.println("BIIIIP!!!!");
        }   
    }

    public void silenzia() {
        System.out.println("Allarme silenziato!");
    }
}
