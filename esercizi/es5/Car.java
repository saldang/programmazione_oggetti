package es5;

public class Car {
    // quantità di carburante nel serbatoio
    public double gas;
    // prestazioni della vettura
    public double kmL;

    // si costruisce un'automobile con carburante uguale a zero
    public Car(double resa) {
        kmL = resa;
        gas = 0;
    }

    /*
     * Calcola il livello di carburante rimasto dopo un certo percorso
     *
     * @param km i chilometri percorsi
     */
    public void drive(double km) {
        int l = (int) Math.round(km / kmL);
        for (int i = l - 1; i > 0; i--) {
            gas--;
            if (gas == 0) {
                System.out.println("Hai finito il carburante, mancano " + i * kmL + " km.");
            }
        }
    }

    /*
     * ispeziona il livello di carburante rimasto
     *
     * @return il carburante rimasta
     */
    public double getGas() {
        return gas;
    }

    /*
     * aggiunge carburante nel serbatoio
     *
     * @param rifornimento il carburante da aggiungere
     */
    public void addGas(double rifornimento) {
        gas = gas + rifornimento;
    }
}
