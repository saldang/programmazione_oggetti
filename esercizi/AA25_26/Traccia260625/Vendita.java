import java.time.LocalDate;

public class Vendita extends Transazione{
    double sconto;
    String metodoPagamento;
    double prezzoFinale;
    
    public Vendita(LocalDate data, String utente, Materiale materiale, double sconto, String metodoPagamento,
            double prezzoFinale) {
        super(data, utente, materiale);
        this.sconto = sconto;
        this.metodoPagamento = metodoPagamento;
        this.prezzoFinale = prezzoFinale;
    }
}
