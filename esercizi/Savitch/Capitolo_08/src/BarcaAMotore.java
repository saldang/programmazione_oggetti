import java.util.Scanner;

public class BarcaAMotore {
    private double capacitaSerbatoio;
    private double carburanteDisponibile;
    private double velocitaMax;
    private double velocitaCorrente;
    private double efficienzaMotore;
    private double distanzaPercorsa;
    
    public void inizializza(double capacita, double velocitaMassima, double efficienza) {
        capacitaSerbatoio = capacita;
        carburanteDisponibile = 0.0;
        velocitaMax = velocitaMassima;
        velocitaCorrente = 0.0;
        efficienzaMotore = efficienza;
        distanzaPercorsa = 0.0;
    }
    
    public void cambiaVelocita(double nuovaVelocita){
        if(nuovaVelocita < 0.0)
            velocitaCorrente = 0.0;
        else if (nuovaVelocita > velocitaMax)
            velocitaCorrente = velocitaMax;
        else
            velocitaCorrente = nuovaVelocita;
    }
    
    public void navigaATempo(double tempo){
        if(tempo > 0.0 ){
            double carburanteNecessario = efficienzaMotore * velocitaCorrente * velocitaCorrente * tempo;
            
            double tempoEffettivo;
            
            // Determina se terminiamo prima il carburante
            if(carburanteNecessario > carburanteDisponibile){
                tempoEffettivo = tempo * (carburanteDisponibile/carburanteNecessario);
                carburanteDisponibile = 0.0;
            }else{
                carburanteDisponibile -= carburanteNecessario;
                tempoEffettivo = tempo;
            }
            distanzaPercorsa += velocitaCorrente * tempoEffettivo;
        }
    }
    
    public void rifornisci(double quantita){
        if(quantita > 0.0){
            if (quantita + carburanteDisponibile > capacitaSerbatoio)
                carburanteDisponibile = capacitaSerbatoio;
            else
                carburanteDisponibile += quantita;
        }
    }
    
    public double carburanteRimanente(){
        return carburanteDisponibile;
    }
    
    public double distanza(){
        return distanzaPercorsa;
    }
    
    
    public static void main(String[] args) {
        
        BarcaAMotore miaBarca = new BarcaAMotore();
        miaBarca.inizializza(5.0, 55.0, 0.001);
        
        System.out.println("Stiamo cercando di navigare per 1.0 ora senza carburante.");
        miaBarca.navigaATempo(1.0);
        System.out.println("Il carburante rimasto e' " + miaBarca.carburanteRimanente()
        + " e abbiamo percorso " + miaBarca.distanza());
        System.out.println();
        
        System.out.println("Cerchiamo di aggiungere 10 litri di carburante, ma la barca ne puo' contenere solo al massimo 5.");
        miaBarca.rifornisci(10.0);
        System.out.println("Il carburante rimasto e' " + miaBarca.carburanteRimanente()
        + " e abbiamo percorso " + miaBarca.distanza());
        System.out.println();
        
        System.out.println("Stiamo navigando per 1.0 ora a velocita' 0.");
        miaBarca.navigaATempo(1.0);
        System.out.println("Il carburante rimasto e' " + miaBarca.carburanteRimanente()
        + " e abbiamo percorso " + miaBarca.distanza());
        System.out.println();
        
        System.out.println("Cerchiamo di modificare la velocita' a 85, ma la barca puo' andare solo fino a 55.");
        miaBarca.cambiaVelocita(85.0);
        System.out.println("Il carburante rimasto e' " + miaBarca.carburanteRimanente()
        + " e abbiamo percorso " + miaBarca.distanza());
        System.out.println();
        
        System.out.println("Stiamo navigando per 1.0 ora a velocita' 55.");
        System.out.println("Dovremmo usare 3.025 litri di carburante e percorrere 55 miglia.");
        miaBarca.navigaATempo(1.0);
        System.out.println("Il carburante rimasto e' " + miaBarca.carburanteRimanente()
        + " e abbiamo percorso " + miaBarca.distanza());
        System.out.println();
        
        System.out.println("Stiamo navigando per 1.0 ora a velocita' 45.");
        System.out.println("Dovremmo usare tutti i 1.975 litri rimasti.  " +
                "Il tempo di navigazione sara' quindi 0.9753 e la distanza percorsa approssimatamente 43.888 miglia");
        miaBarca.cambiaVelocita(45.0);
        miaBarca.navigaATempo(1.0);
        System.out.println("Il carburante rimasto e' " + miaBarca.carburanteRimanente()
        + " e abbiamo percorso " + miaBarca.distanza());
        System.out.println();
    }    
}



