public class TexasTI89 extends Calcolatrice implements ScientificCalculus, LogicCalculus {

    double risultato;

    public void stampaRisultato() {
        System.out.println(risultato);
    }

    @Override
    public void andOperation(boolean a, boolean b) {
        System.out.println(a & b);
    }

    @Override
    public void exponetial(double base, int exp) {
        System.out.println(Math.pow(base, exp));
    }
}
