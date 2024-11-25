import java.time.LocalDate;
import java.util.Scanner;

public class Bicicletta extends Veicolo {
    public Bicicletta(String marca, String modello, int anno, String colore) {
        super(marca, modello, anno, colore);
    }

    @Override
    public void calcolaValoreMercato() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci l'anno di acquisto:");
        int annoAcquisto = tastiera.nextInt();
        System.out.println("Inserisci prezzo di acquisto:");
        double prezzo = tastiera.nextDouble();

        System.out.println(
                "Valore della bici:" + (prezzo - (LocalDate.now().getYear() - annoAcquisto) * (20 / 100) * prezzo));
        tastiera.close();
    }

    @Override
    public String visualizzaInformazioniVeicolo() {
        return "Bicicletta: %s, %s, %d,%s".formatted(marca, modello, anno, colore);
    }

}
