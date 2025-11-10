import Capitolo10.Persona;

public class Dipendente extends Persona {
    private double retribuzioneAnnuale;
    private int annoAssunzione;
    private String id;

    public Dipendente() {
    }

    public Dipendente(String nome) {
        super(nome);
    }

    public Dipendente(String nome, double retribuzioneAnnuale, int annoAssunzione, String id) {
        super(nome);
        this.id = id;
        this.retribuzioneAnnuale = retribuzioneAnnuale;
        this.annoAssunzione = annoAssunzione;
    }

    public double getRetribuzioneAnnuale() {
        return retribuzioneAnnuale;
    }

    public int getAnnoAssunzione() {
        return annoAssunzione;
    }

    public String getId() {
        return id;
    }

    public void setRetribuzioneAnnuale(double retribuzioneAnnuale) {
        this.retribuzioneAnnuale = retribuzioneAnnuale;
    }

    public void setAnnoAssunzione(int annoAssunzione) {
        this.annoAssunzione = annoAssunzione;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dipendente dipendente)
            return id.equals(dipendente.getId());
        else
            System.out.println("Non e' un oggetto Dipendente!");
        return false;
    }

    @Override
    public String toString() {
        return getNome() + " " + annoAssunzione + " " + retribuzioneAnnuale + " " + id;
    }
}
