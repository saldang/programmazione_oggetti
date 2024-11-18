public class Paziente extends Persona {
    private String id;

    Paziente(String nome, String id) {
        super(nome);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean equals(Paziente paziente) {
        if (this.id.equals(paziente.getId()))
            return true;
        else
            return false;

    }

}
