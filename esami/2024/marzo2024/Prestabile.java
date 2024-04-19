
import java.time.LocalDate;

public interface Prestabile {
    public void presta(String utente, LocalDate data);

    public void restituisci();

    public boolean isDisponibile();
}
