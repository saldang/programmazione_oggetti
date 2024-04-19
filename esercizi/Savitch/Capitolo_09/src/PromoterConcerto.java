import java.util.Scanner;

public class PromoterConcerto {
    private String nomeBand;
    private int capacita;
    private int bigliettiVenduti;
    private double costoVenditaTelefonica;
    private double costoVenditaSulLuogo;
    private double totaleVendite;
    private boolean venditeAlTelefono;


    /**
     * Inizializza l'istanza
     */
    public PromoterConcerto(String band, int max, double costoTelefono, double costoSulLuogo) {
        nomeBand = band;
        capacita = max;
        bigliettiVenduti = 0;
        costoVenditaTelefonica = costoTelefono;
        costoVenditaSulLuogo = costoSulLuogo;
        totaleVendite = 0.0;
        venditeAlTelefono = true;
    }


    public void effettuaVendita(){
        System.out.println("Quanti biglietti? (Massimo " + getNumeroBigliettiRimanenti() + ")");

        Scanner tastiera = new Scanner(System.in);
        int daVendere = tastiera.nextInt();

        boolean venditaCompletata = vendiBiglietti(daVendere);

        if(venditaCompletata)
            System.out.println("Il costo dei biglietti e' " + getCostoVendita(daVendere));
        else
            System.out.println("Siamo spiacenti ma non siamo in grado di compeltare la vendita");
    }

    public boolean vendiBiglietti(int numero) {
        if(numero > 0 && numero <= getNumeroBigliettiRimanenti()){
            bigliettiVenduti += numero;
            totaleVendite += getCostoVendita(numero);
            return true;
        } else {
            return false;
        }
    }

    public double getCostoVendita(int numbero){
        double costoVendita = numbero;
        if(venditeAlTelefono)
            costoVendita *= costoVenditaTelefonica;
        else
            costoVendita *= costoVenditaSulLuogo;
        return costoVendita;
    }

    public void venditaTelefonicaTerminata(){
        venditeAlTelefono = false;
    }

    public int getBigliettiVenduti(){
        return bigliettiVenduti;
    }

    public int getNumeroBigliettiRimanenti(){
        return capacita - bigliettiVenduti;
    }

    public double getNumeroBigliettiVenduti(){
        return totaleVendite;
    }

    public boolean venditeAlTelefono(){
        return venditeAlTelefono;
    }

    public String getReportVendite(){
        return "Vendite per " + nomeBand + ":  Biglietti venduti: " + bigliettiVenduti + " per " + totaleVendite;
    }

 public static void main(String[] args) {
        PromoterConcerto concerto = new PromoterConcerto("Maneskin", 100, 10.00 , 12.00);
        
        Scanner tastiera = new Scanner(System.in);

        boolean fatto = false;

        while(!fatto){
            if(concerto.venditeAlTelefono())
                System.out.println("Vendi biglietti (V), Passa a vendita sul luogo (L), Termina vendita (T)");
            else
                System.out.println("Vendi biglietti (L), Termina vendita (T)");

            String risposta = tastiera.next();
            if(risposta.equals("T"))
                fatto = true;
            else if(risposta.equals("V"))
                concerto.effettuaVendita();
            else if(risposta.equals("L"))
                concerto.venditaTelefonicaTerminata();
            else {
                System.out.println("La risposta " + risposta + " non e' valida.");
            }

            System.out.println("Biglietti rimanenti: " + concerto.getNumeroBigliettiRimanenti());
        }
        System.out.println("Report finale: " + concerto.getReportVendite());
    }


}





