import java.util.Scanner;

/**
Classe che rappresenta un venditore.
*/
public class Venditore {
    private String nome;
    private double vendite;

    public Venditore() {
        nome = "Nessun nome";
        vendite = 0;
    }

    public Venditore (String nomeIniziale, double venditeIniziali) {
        setValori(nomeIniziale, venditeIniziali);
    }

    public void setValori(String nuovoNome, double nuoveVendite) {
        nome = nuovoNome;
        vendite = nuoveVendite;
    }

    public void leggiValoriDaTastiera() {
        System.out.print("Inserire il nome: ");
        Scanner tastiera = new Scanner(System.in);
        nome = tastiera.nextLine();
        System.out.print("Inserire le vendite: € ");
        vendite = tastiera.nextDouble();
    }

    public void scriviOutput() {
        System.out.println("Nome: " + nome);
        System.out.println("Vendite: € " + vendite);
    }

    public String getNome() {
        return nome;
    }

    public double getVendite() {
        return vendite;
    }
}
