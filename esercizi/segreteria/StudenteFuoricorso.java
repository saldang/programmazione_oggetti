package segreteria;

public class StudenteFuoricorso extends Studente {
    public int annoFuoriCorso;

    public StudenteFuoricorso(String nome, String cognome, int matricola, int i) {
        super(matricola, nome, cognome);
        this.annoFuoriCorso = i;
    }
}
