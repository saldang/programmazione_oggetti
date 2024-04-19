import java.util.ArrayList;

public class Concessionario {
    ArrayList<Veicolo> inventario = new ArrayList<>();
    double guadagnoNoleggio;
    double guadagnoVendita;

    public Concessionario(ArrayList<Veicolo> inventario) {
        this.inventario = inventario;
        guadagnoNoleggio = 0;
        guadagnoVendita = 0;
    }

    public void aggiungiVeicolo(Veicolo veicolo) {
        inventario.add(veicolo);
    }

    public void visualizzaInventario() {
        for (Veicolo veicolo : inventario) {
            System.out.println(veicolo.descrizione());
        }
    }

    public void acquistaVeicolo(Veicolo veicolo) {
        if (veicolo instanceof Auto) {
            guadagnoVendita += ((Auto) veicolo).prezzoVendita;
            System.out.println("Hai acquistato " + veicolo.marca + " " + veicolo.modello + ((Auto) veicolo).numeroPorte
                    + " al prezzo di: "
                    + ((Auto) veicolo).prezzoVendita);
        } else {
            guadagnoVendita += ((Moto) veicolo).prezzoVendita;
            System.out.println("Hai acquistato " + veicolo.marca + " " + veicolo.modello + ((Moto) veicolo).cilindrata
                    + " al prezzo di: "
                    + ((Moto) veicolo).prezzoVendita);
        }
        inventario.remove(veicolo);

    }

    public void noleggiaVeicolo(Veicolo veicolo) {
        if (veicolo instanceof Auto) {
            guadagnoNoleggio += ((Auto) veicolo).prezzoNoleggio;
            System.out.println("Hai noleggiato " + veicolo.marca + " " + veicolo.modello + ((Auto)veicolo).numeroPorte
                    + " al prezzo di: "
                    + ((Auto) veicolo).prezzoNoleggio);
        } else {
            guadagnoNoleggio += ((Moto) veicolo).prezzoNoleggio;
            System.out.println("Hai noleggiato " + veicolo.marca + " " + veicolo.modello + ((Moto) veicolo).cilindrata
                    + " al prezzo di: "
                    + ((Moto) veicolo).prezzoNoleggio);
        }
        inventario.remove(veicolo);
    }

    public double calcolaGuadagnoVendita() {
        return guadagnoVendita;
    }

    public double calcolaGuadagnoNoleggio() {
        return guadagnoNoleggio;
    }

    public double calcolaGuadagnoTotale() {
        return guadagnoNoleggio + guadagnoVendita;
    }

}
