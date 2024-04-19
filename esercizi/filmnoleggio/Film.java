package filmnoleggio;

abstract class Film {
    private int id;
    private String titolo;

    protected Film(int id, String titolo){
        this.id = id;
        this.titolo = titolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public boolean equals(Object o) {
        Film altroFilm = (Film) o;
        if (o != null && o instanceof Film) {
            if (this.id == altroFilm.id) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public abstract double calcolaPenaleRitardo(int giorniDiRitardo);

}
