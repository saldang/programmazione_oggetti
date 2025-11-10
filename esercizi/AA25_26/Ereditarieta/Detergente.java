public class Detergente extends Struccante {
    // aggiunta di un nuovo metodo
    public void spuma() {
        append(" spuma()");
    }

    // Occultare all’esterno
    
    void dilute() {
    }

    // Specializzazione: overriding
    public void pulisci() {
        append(" Detergente.pulisci()");
    }

    public void pulisci_old() {
        // Chiamata del metodo della classe base
        super.pulisci(); // non si tratta di una ricorsione!!
        System.out.println("Pulito");
    }

    public static void main(String[] args) {
        Detergente x = new Detergente();
        x.apply();
        x.spuma();
        x.dilute(); // Solo allinterno della classe detergente
        x.pulisci();
        x.pulisci_old(); // Metodo che stampa "Pulito"
        System.out.println("---");
        System.out.println(x.toString());
    }
}
