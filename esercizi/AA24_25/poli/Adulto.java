public class Adulto extends Cliente {

    private String documentoRiconoscimento;

    public Adulto(String nome, String cognome, String documentoRiconoscimento) {
        super(nome, cognome);
        this.documentoRiconoscimento = documentoRiconoscimento;
    }

    public String getDocumentoRiconoscimento() {
        return documentoRiconoscimento;
    }

    public void setDocumentoRiconoscimento(String documentoRiconoscimento) {
        this.documentoRiconoscimento = documentoRiconoscimento;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Documento: " + documentoRiconoscimento);
    }
}
