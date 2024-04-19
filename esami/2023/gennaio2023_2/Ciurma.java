import java.util.ArrayList;

public class Ciurma {
    private String nome;

    // private Nave[] navi;
    // private Pirata[] pirati;
    private ArrayList<Nave> navi = new ArrayList<>();
    private ArrayList<Pirata> pirati = new ArrayList<>();

    public ArrayList<Nave> getNavi() {
        return navi;
    }

    public void setNavi(ArrayList<Nave> navi) {
        this.navi = navi;
    }

    public ArrayList<Pirata> getPirati() {
        return pirati;
    }

    public void setPirati(ArrayList<Pirata> pirati) {
        this.pirati = pirati;
    }

    public Ciurma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aggiungiPirata(Pirata pirata) {
        pirati.add(pirata);
    }

    public void aggiungiNave(Nave nave) {
        navi.add(nave);
    }

    public ArrayList<Pirata> getPersonaggiMaschili() {
        ArrayList<Pirata> maleOP = new ArrayList<>();
        for (Pirata pirata : pirati) {
            if (pirata.getSesso().equalsIgnoreCase("male"))
                maleOP.add(pirata);
        }
        return maleOP;
    }

    public ArrayList<Pirata> getBigBounty() {
        pirati.sort(null);
        return pirati;
    }

    @Override
    public String toString() {

        String stampa = this.nome;
        for (Nave nave : navi) {
            stampa = stampa + nave.toString();
            stampa = stampa + "\n";
        }
        for (Pirata pirata : pirati) {
            stampa = stampa + pirata.toString();
            stampa = stampa + "\n";
        }
        return stampa;
    }

}
