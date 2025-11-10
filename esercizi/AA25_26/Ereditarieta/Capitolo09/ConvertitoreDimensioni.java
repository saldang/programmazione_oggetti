/** 
  Classe con metodi statici per effettuare conversioni di misure
 */
public class ConvertitoreDimensioni {
    public static final int POLLICI_PER_PIEDE = 12; 

    public static double convertiPiediInPollici(double piedi) { 
        return piedi * POLLICI_PER_PIEDE;
    }

    public static double convertiPolliciInPiedi(double pollici) { 
        return pollici / POLLICI_PER_PIEDE;
    }
}
