import java.time.LocalDate;
import java.util.Scanner;

public class Motocicletta extends Veicolo implements Guidabile {
    private double distanzaPercorsa;

    public Motocicletta(String marca, String modello, int anno, String colore) {
        super(marca, modello, anno, colore);
        distanzaPercorsa = 0;
    }

    @Override
    public void calcolaValoreMercato() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci l'anno di acquisto:");
        int annoAcquisto = tastiera.nextInt();
        System.out.println("Inserisci prezzo di acquisto:");
        double prezzo = tastiera.nextDouble();

        System.out.println(
                "Valore della moto:" + (prezzo - (LocalDate.now().getYear() - annoAcquisto) * (10 / 100) * prezzo));
        tastiera.close();
    }

    @Override
    public String visualizzaInformazioniVeicolo() {
        return "Motocicletta: %s, %s, %d,%s".formatted(marca, modello, anno, colore);
    }

    @Override
    public void accelera(double quantita) {
        distanzaPercorsa += quantita;
    }

    @Override
    public void frena(double quantita) {
        distanzaPercorsa -= quantita;
    }

    @Override
    public double getDistanza() {
        return distanzaPercorsa;
    }

}