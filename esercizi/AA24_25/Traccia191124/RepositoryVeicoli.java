import java.util.ArrayList;

public class RepositoryVeicoli {
    ArrayList<Veicolo> veicoli = new ArrayList<>();

    public void aggiungi(Veicolo veicolo) {
        veicoli.add(veicolo);
    }

    public void rimuovi(String marca, String modello) {
        int daRimuovere = -1;
        for (Veicolo veicolo : veicoli) {
            if (veicolo.marca.equalsIgnoreCase(marca) && veicolo.modello.equalsIgnoreCase(modello)) {

                daRimuovere = veicoli.indexOf(veicolo);
                break;
            }
        }
        veicoli.remove(daRimuovere);
    }

    public void leggiVeicoli() {
        veicoli.forEach((v) -> System.out.println(v.visualizzaInformazioniVeicolo()));
    }
}
