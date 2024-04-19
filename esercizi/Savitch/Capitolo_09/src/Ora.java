public class Ora {
    private int  oraAttuale;
    private int minutiAttuali;


    /**
     * Crea una nuova istanza di Ora
     */
    public Ora() {
        oraAttuale = 0;
        minutiAttuali = 0;
    }

    public Ora(int ora, int minuti){
        setOra(ora, minuti);
    }

    public Ora(int ora, int minuti, boolean isAM){
        setOra(ora, minuti, isAM);
    }

    private boolean valida(int ora, int minuti){
        return (ora>=0 && ora<=23) && (minuti>=0 && minuti<=59);
    }

    public void setOra(int ora, int minuti){
        if(valida(ora, minuti)) {
        	oraAttuale = ora;
            minutiAttuali = minuti;
        }
    }

    public void setOra(int ora, int minuti, boolean isAM){
        if(ora>=1 && ora<=12){
            if(isAM && ora == 12)
                // 12AM  corrisponde a 0.
                ora = 0;
            else if (!isAM && ora < 12)
                // 8PM corrisponde alle 20
                ora = ora + 12;
            // Le ore restanti rimangono invariate
           
            if(valida(ora, minuti)) {
                oraAttuale = ora;
                minutiAttuali = minuti;
            }
        }
    }

    public String getOra12(){
        String risposta = "";

        if(oraAttuale == 0)
            risposta = "12";
        else if(oraAttuale > 12)
            risposta = risposta + (oraAttuale-12);
        else
            risposta = risposta + oraAttuale;

        risposta = risposta + ":";

        if(minutiAttuali < 10)
            risposta = risposta + "0" + minutiAttuali;
        else
            risposta = risposta + minutiAttuali;

        if(oraAttuale>=0 && oraAttuale<11)
            risposta = risposta + "AM";
        else
            risposta = risposta + "PM";

        return risposta;
    }

    public String getOra24(){
        String risposta = "";
        if(oraAttuale < 10)
            risposta = "0" + oraAttuale;
        else
            risposta = "" + oraAttuale;

        if(minutiAttuali < 10)
            risposta = risposta + "0" + minutiAttuali;
        else
            risposta = risposta + minutiAttuali;

        return risposta;
    }

    public String toString(){
        return "ora: " + oraAttuale + " minuti: " + minutiAttuali;
    }

    public static void main(String[] args) {
        Ora ora1 = new Ora();
        System.out.println("Crea un'ora di default");
        System.out.println("\t dovrebbe essere 0, 0:  " + ora1);

        System.out.println("Imposta l'ora a 12, 12");
        ora1.setOra(12, 12);
        System.out.println("\t dovrebbe essere 12, 12:  " + ora1);

        System.out.println("Cerca di impostare l'ora a -1, 12");
        ora1.setOra(-1, 12);
        System.out.println("\t dovrebbe essere 12, 12:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 12, -1");
        ora1.setOra(12, -1);
        System.out.println("\t dovrebbe essere 12, 12:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 24, 12");
        ora1.setOra(24, 12);
        System.out.println("\t dovrebbe essere 12, 12:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 12, 60");
        ora1.setOra(12, 60);
        System.out.println("\t dovrebbe essere 12, 12:  " + ora1);


        System.out.println("Imposta l'ora a 8, 16 am");
        ora1.setOra(8, 16, true);
        System.out.println("\t dovrebbe essere 8, 16:  " + ora1);

        System.out.println("Imposta l'ora a 8, 16 pm");
        ora1.setOra(8, 16, false);
        System.out.println("\t dovrebbe essere 20, 16:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 0, 17 am");
        ora1.setOra(0, 17, true);
        System.out.println("\t dovrebbe essere 20, 16:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 12, 17 am");
        ora1.setOra(13, 17, true);
        System.out.println("\t dovrebbe essere 20, 16:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 0, 17 pm");
        ora1.setOra(0, 17, false);
        System.out.println("\t dovrebbe essere 20, 16:  " + ora1);

        System.out.println("Cerca di impostare l'ora a 12, 17 pm");
        ora1.setOra(13, 17, false);
        System.out.println("\t dovrebbe essere 20, 16:  " + ora1);

        System.out.println("Imposta l'ora a 12, 19 am");
        ora1.setOra(12, 19, true);
        System.out.println("\t dovrebbe essere 0, 19:  " + ora1);

        System.out.println("Imposta l'ora a 12, 19 pm");
        ora1.setOra(12, 19, false);
        System.out.println("\t dovrebbe essere 12, 19:  " + ora1);

        System.out.println("\nCollaudo i costruttori");
        System.out.println("Crea un'ora  12, 19");
        Ora time2 = new Ora(12, 19);
        System.out.println("\t dovrebbe essere 12:19pm:  " + time2.getOra24() + " e " + time2.getOra12());
        System.out.println("Crea un'ora  12, 19 con l'altro costruttore");
        time2 = new Ora(12, 19, false);
        System.out.println("\t dovrebbe essere 12:19pm:  " + time2.getOra24() + " e " + time2.getOra12());

        System.out.println("Crea un'ora  0, 19");
        time2 = new Ora(0, 19);
        System.out.println("\t dovrebbe essere 12:19am:  " + time2.getOra24() + " e " + time2.getOra12());
        System.out.println("Crea un'ora  12, 19 con l'altro costruttore");
        time2 = new Ora(12, 19, true);
        System.out.println("\t dovrebbe essere 12:19pm:  " + time2.getOra24() + " e " + time2.getOra12());

        System.out.println("Crea un'ora  3, 19");
        time2 = new Ora(3, 19);
        System.out.println("\t dovrebbe essere 3:19am:  " + time2.getOra24() + " e " + time2.getOra12());
        System.out.println("Crea un'ora  3, 19 con l'altro costruttore");
        time2 = new Ora(3, 19, true);
        System.out.println("\t dovrebbe essere 3:19am:  " + time2.getOra24() + " e " + time2.getOra12());

        System.out.println("Crea un'ora  15, 19");
        time2 = new Ora(15, 19);
        System.out.println("\t dovrebbe essere 3:19pm:  " + time2.getOra24() + " e " + time2.getOra12());
        System.out.println("Crea un'ora  3, 19 con l'altro costruttore");
        time2 = new Ora(3, 19, false);
        System.out.println("\t dovrebbe essere 3:19pm:  " + time2.getOra24() + " e " + time2.getOra12());

    }

}


