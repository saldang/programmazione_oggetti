/**
 * This class tracks who rented what Film and how many days late it is.
 */
class Noleggio {
	private Film film;
	private int idCliente;
	private int giorniDiRitardo;

	public Noleggio() {
		this(null, 0);
	}

	public Noleggio(Film film, int idCliente) {
		setFilm(film);
		setIdCliente(idCliente);
		setGiorniDiRitardo(0);
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getGiorniDiRitardo() {
		return giorniDiRitardo;
	}

	public void setGiorniDiRitardo(int giorniDiRitardo) {
		this.giorniDiRitardo = giorniDiRitardo;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public double calcolaPenaliRitardo() {
		return film.calcolaPenaleRitardo(giorniDiRitardo);
	}
}