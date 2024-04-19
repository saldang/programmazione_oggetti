public class BambinoPrecoce extends BambinoScuola {
    
    /**Crea una istanza di BambinoPrecoce
     */
    public BambinoPrecoce(String nome, int eta, String insegnante, String saluto) {
        super(nome, eta, insegnante, saluto);
    }
    
    
    
    // Override
    public String getSaluto(){
        return super.getSaluto() + "  Io sono il migliore.";
    }
    
    public int getEta(){
        return super.getEta() + 2;
    }

    public static void main(String[] args) {
    	BambinoScuola ken = new BambinoPrecoce("Ken", 5, "Mrs. Jones", "Hiyas.");
        System.out.println("Stato di ken");        
        System.out.println(ken);
        
        System.out.println("Ma Ken dobrebbe aggiungere 2 all'eta': " + ken.getEta());
        System.out.println("e dovrebbe aggiungere ai saluti: " + ken.getSaluto());
        
        System.out.println("\nAumento l'eta' di 1, assegno l'insegnante Mr. Roberson, e i saluti in Aloha");
        ken.compleanno();
        ken.cambiaInsegnante("Mr. Roberson");
        ken.cambiaSaluto("Aloha");
        System.out.println("Stato di Ken ora...");
        System.out.println(ken);
        System.out.println("Ma Ken dobrebbe aggiungere 2 all'eta': " + ken.getEta());
        System.out.println("e dovrebbe aggiungere ai saluti: " + ken.getSaluto());        
    }
}


