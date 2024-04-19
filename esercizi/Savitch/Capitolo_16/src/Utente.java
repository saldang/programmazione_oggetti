import java.util.HashSet;

public class Utente {
	private String nome; 
	private HashSet<Utente> amici;

	public Utente() {
		this(null);		
	}

	public Utente(String newName) {
		nome = newName;
		amici = new HashSet<Utente>();
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashSet<Utente> getAmici() {
		return amici;
	}

	
	public Object[] getAmiciArray() {
		return amici.toArray();
	}

	/**
	 * Aggiunge un nuovo amico ll'insieme degli amici
	 */
	public void aggiungiAmico(Utente amico) {
		amici.add(amico);
	}

	/**
	 * Rimuove un amico dall'insieme degli amici
	 */
	public void eliminaAmico(Object amico) {
		amici.remove((Utente) amico);
	}

	/**
	 * un metodo wrapper che sfrutta la routine ricorsiva allo scopo di 
	 * mostrare tutti gli amici fino a numeraMaxCollegamenti. 
	 * Aggiunge una nuova variabile per indicare il numero attuale di link lontani dalla fonte, e si inizializza a 1.
	 *
	 * @param numeraMaxCollegamenti
	 *            Numero massimo di collegamenti per mostrare agli amici
	 */
	public void mostraAmici(int numeraMaxCollegamenti) {
		mostraAmiciRicorsivo(1, numeraMaxCollegamenti);
	}

	/**
	 * Il metodo opera in modo ricorsivo mostrando tutti gli amici fino 
	 * a numeraMaxCollegamenti. Incrementa numeroCorrenteCollegamenti per ogni 
	 * collegamento.
	 *
	 * @param numeroCorrenteCollegamenti
	 *            Numero corrente di collegamenti 
	 * @param numeraMaxCollegamenti
	 *             Numero massimo di collegamenti per mostrare agli amici
	 */
	private void mostraAmiciRicorsivo(int numeroCorrenteCollegamenti, int numeraMaxCollegamenti) {
		// Mostra tutti gli amici diretti
		for (Utente amico : amici) {
			System.out.println(nome + " e' amico di " + amico.getNome() + " (" + numeroCorrenteCollegamenti + " collegamenti)");
			// Effettuta la ricorsione su ogni amico se non 
			// e' stato raggiunto il numero massimo di collegamenti su ogni amico
			if (numeroCorrenteCollegamenti < numeraMaxCollegamenti) {
				amico.mostraAmiciRicorsivo(numeroCorrenteCollegamenti + 1, numeraMaxCollegamenti);
			}
		}
		System.out.println();
	
	}
}
