package Soluzione240424;

public interface SistemaSicurezza {

    public void attivaSistemaSicurezza(Utente utente) throws AutorizzazioneException;

    public void disattivaSistemaSicurezza(Utente utente) throws AutorizzazioneException;

    public void aggiungiSensore(Sensore sensore);

    public void rimuoviSensore(Sensore sensore);

    public void visualizzaSensori();

    public void aggiungiUtente(String nome, String livelloAccesso);

    public void rimuoviUtente(Utente utente);

    public void visualizzaUtenti();

}
