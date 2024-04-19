import java.util.Scanner;

public class CalcolatriceMemoria extends Calcolatrice {
    private double memoria;

    public CalcolatriceMemoria() {
        memoria = 0;
        setRisultato(0);
    }

    public void setMemoria(double valore) {
        memoria = valore;
    }


    @Override
    public void eseguiCalcoli() throws DivisionePerZeroException, OpSconosciutaException {
        Scanner tastiera = new Scanner(System.in);
        boolean fatto = false;
        setRisultato(0);
        System.out.println("risultato = " + getRisultato());

        while (!fatto) {
            char prossimaOp = (tastiera.next()).charAt(0);
            if ((prossimaOp == 'f') || (prossimaOp == 'F')){
                fatto = true;

            }
            else if (prossimaOp == 'c' || prossimaOp == 'C') {
                reset();
                System.out.println("risultato azzerato");
                System.out.println("risultato = " + getRisultato());
            } else if (prossimaOp == 's' || prossimaOp == 'S') {
                setMemoria(getRisultato());
                System.out.println("risultato salvato in memoria");
            } else if (prossimaOp == 'r' || prossimaOp == 'R')
                System.out.println("valore richiamato dalla memoria =" + memoria);
            else {
                double prossimoNumero = tastiera.nextDouble();
                setRisultato(
                    valuta(prossimaOp, getRisultato(), prossimoNumero));
                System.out.println("risultato " + prossimaOp + " " +
                        prossimoNumero + " = " + getRisultato());
                System.out.println("risultato aggiornato = " + getRisultato());
            }
        }

    }

    @Override
    public void gestisciOpSconosciutaException(OpSconosciutaException e) {
        System.out.println(e.getMessage());
        System.out.println("Riprova dall'inizio:");

        try {
            System.out.print("Formato di ogni linea: ");
            System.out.println("operatore spazio numero");
            System.out.println("Per esempio: + 3");
            System.out.println("Per terminare inserire la lettera f.");
            System.out.println("Per salvare il risultato in memoria la lettera s.");
            System.out.println("Per richiamare il risultato in memoria la lettera r.");
            System.out.println("Per resettare il risultato la lettera c");

            eseguiCalcoli();
        } catch (OpSconosciutaException e2) {
            System.out.println(e2.getMessage());
            System.out.println("Riprova in un secondo momento.");
            System.out.println("Fine del programma.");
            System.exit(0);
        } catch (DivisionePerZeroException e3) {
            gestisciDivisionePerZeroException(e3);
        }
    }

    public static void main(String[] args) {
        CalcolatriceMemoria calc = new CalcolatriceMemoria();

        try {
            System.out.println("Calcolatrice attivata.");
            System.out.print("Formato di ogni linea: ");
            System.out.println("operatore spazio numero");
            System.out.println("Per esempio: + 3");
            System.out.println("Per terminare inserire la lettera f.");
            System.out.println("Per salvare il risultato in memoria la lettera s.");
            System.out.println("Per richiamare il risultato in memoria la lettera r.");
            System.out.println("Per resettare il risultato la lettera c");
            calc.eseguiCalcoli();
        } catch (OpSconosciutaException e) {
            calc.gestisciOpSconosciutaException(e);
        } catch (DivisionePerZeroException e) {
            calc.gestisciDivisionePerZeroException(e);
        }
        System.out.println("Il risultato finale e' " + calc.getRisultato());
        System.out.println("Fine del programma.");
    }
}
