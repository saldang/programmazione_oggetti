package filmnoleggio;

/**
 * Noleggio
 */
public class Noleggio {

    Film film;
    int idUtente;
    int giorniDiRitardo;

    public Noleggio(Film film, int idUtente, int giorniDiRitardo) {
        this.film = film;
        this.idUtente = idUtente;
        this.giorniDiRitardo = giorniDiRitardo;
    }

    public double calcolaPenaleRitardo(){
        return film.calcolaPenaleRitardo(giorniDiRitardo);
    }


}
