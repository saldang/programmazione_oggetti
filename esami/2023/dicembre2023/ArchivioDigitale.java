import java.util.ArrayList;

public class ArchivioDigitale {

    ArrayList<ElementoArchivio> elementiArchivio;

    public ArchivioDigitale(ArrayList<ElementoArchivio> elementiArchivio) {
        this.elementiArchivio = elementiArchivio;
    }

    public void aggiungiElemento(ElementoArchivio elemento) {
        elementiArchivio.add(elemento);
    }

    public void visualizzaElementi() {
        for (ElementoArchivio elemento : elementiArchivio) {
            System.out.println(elemento.visualizzaDettagli());
        }
    }

    public void eliminaElemento(ElementoArchivio elementoArchivio) {
        elementiArchivio.remove(elementoArchivio);
    }

}
