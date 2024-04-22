package Soluzione240424;

import java.time.LocalDate;
import java.util.ArrayList;

public class SicurezzaCasa implements SistemaSicurezza {
    final private Logger logger = new Logger(LocalDate.now().toString());
    private ArrayList<Utente> utenti;
    private ArrayList<Sensore> sensori;
    private Allarme allarme;

    public SicurezzaCasa() {
        this.utenti = new ArrayList<Utente>();
        this.sensori = new ArrayList<Sensore>();
        this.allarme = new Allarme();
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void setSensori(ArrayList<Sensore> sensori) {
        this.sensori = sensori;
    }

    public Allarme getAllarme() {
        return allarme;
    }

    public void setAllarme(Allarme allarme) {
        this.allarme = allarme;
    }

    @Override
    public void attivaSistemaSicurezza(Utente utente) throws AutorizzazioneException {

        if (utente.getLivelloAccesso().equals("admin")) {
            allarme.attiva();
            sensori.forEach(sensore -> sensore.attiva());
            logger.writeToLogFile("Allarme attivato: " + utente.toString());
        } else {
            logger.writeToLogFile("Utente " + utente.toString() + " non autorizzato ad attivare l'allarme");
            throw new AutorizzazioneException("Utente non autorizzato ad attivare l'allarme");
        }

    }

    @Override
    public void disattivaSistemaSicurezza(Utente utente) throws AutorizzazioneException {
        if (utente.getLivelloAccesso().equals("admin")) {
            allarme.disattiva();
            sensori.forEach(sensore -> sensore.disattiva());
            logger.writeToLogFile("Allarme disattivato: " + utente.toString());
        } else {
            logger.writeToLogFile("Utente " + utente.toString() + " non autorizzato ad disattivare l'allarme");
            throw new AutorizzazioneException("Utente non autorizzato ad disattivare l'allarme");
        }
    }

    @Override
    public void aggiungiSensore(Sensore sensore) {
        sensori.add(sensore);
        logger.writeToLogFile("Sensore aggiunto: " + sensore.toString());
    }

    @Override
    public void rimuoviSensore(Sensore sensore) {
        sensori.remove(sensore);
        logger.writeToLogFile("Sensore rimosso: " + sensore.toString());
    }

    @Override
    public void visualizzaSensori() {
        for (Sensore sensore : sensori) {
            System.out.println(sensore.toString());
        }
    }

    @Override
    public void aggiungiUtente(String nome, String livelloAccesso) {
        Utente utente = new Utente(nome, livelloAccesso);
        utenti.add(utente);
        logger.writeToLogFile("Utente aggiunto: " + utente.toString());
    }

    @Override
    public void rimuoviUtente(Utente utente) {
        utenti.remove(utente);
        logger.writeToLogFile("Utente rimosso: " + utente.toString());

    }

    @Override
    public void visualizzaUtenti() {
        for (Utente utente : utenti) {
            System.out.println(utente.toString());
        }
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    public Utente getAdmin() {
        for (Utente utente : utenti) {
            if (utente.getLivelloAccesso().equals("admin")) {
                return utente;
            }
        }
        return null;
    }

    public Utente getOspite() {
        for (Utente utente : utenti) {
            if (utente.getLivelloAccesso().equals("ospite")) {
                return utente;
            }
        }
        return null;
    }
}