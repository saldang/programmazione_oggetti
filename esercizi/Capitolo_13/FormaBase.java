public abstract class FormaBase implements ShapeInterface {
    private int scostamento;
    
    public FormaBase() {
        scostamento = 0;
    }
    
    public FormaBase(int scostamentoIniziale) {
        scostamento = scostamentoIniziale;
    }
    
    public int getScostamento() {
        return scostamento;
    }
    
    public void setScostamento(int nuovoScostamento) {
        scostamento = nuovoScostamento;
    }
    
    public void disegnaDa(int lineNumber) {
        for (int count = 0; count < lineNumber; count++)
            System.out.println();
        disegnaQui();
    }
    
    public abstract void disegnaQui();
}
