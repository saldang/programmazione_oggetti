public class Persona {
	private String nome;
	private int eta;

	/** Crea una nuova istanza di Personaa */
    public Persona() {
        setNome("Senza nome");
        setEta(0);
    }

    public Persona(String unNome, int unaEta) {
        setNome(unNome);
        setEta(unaEta);
    }

	
	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}
	
	public void setNome(String primo, String ultimo){
        setNome(primo+ultimo); 
    }

	public void setEta(int nuovaEta) {
		if (nuovaEta >= 0) {
			eta = nuovaEta;
		} else {
			System.out.println("ERRORE: Eta' negativa.");
			System.exit(0);
		}
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}
	
	
	public static Persona creaBambino(){
        Persona p = new Persona();
        p.setNome("Un bambino");
        p.setEta(2);
        return p;
    }

    public static Persona creaBambinoPrescolare(){
        Persona p = new Persona();
        p.setNome("Un bambino prescolare");
        p.setEta(5);
        return p;
    }

    public static Persona creaAdulto(){
        Persona p = new Persona("un adulto", 21);
        return p;
    }

    public static Persona creaTeenager(){
        Persona p = new Persona();
        p.setNome("Un teenager");
        p.setEta(15);
        return p;
    }

    public static Persona creaAdolescente(){
        Persona p = new Persona();
        p.setNome("Un adolescente");
        p.setEta(9);
        return p;
    }

    public static void main(String[] args) {
        Persona y = new Persona();
        System.out.println("Collauda il costruttore");
        System.out.println("Creata una persona di nome " + y.getNome() + " ed eta " + y.getEta());


        System.out.println("\nCrea istanze specifiche");

        Persona x;

        x = Persona.creaBambino();
        System.out.println("Creata una persona di nome " + x.getNome() + " ed eta' " + x.getEta());

        x = Persona.creaBambinoPrescolare();
        System.out.println("Creata una persona di nome " + x.getNome() + " ed eta' " + x.getEta());

        x = Persona.creaAdolescente();
        System.out.println("Creata una persona di nome " + x.getNome() + " ed eta' " + x.getEta());

        x = Persona.creaTeenager();
        System.out.println("Creata una persona di nome " + x.getNome() + " ed eta' " + x.getEta());

        x = Persona.creaAdulto();
        System.out.println("Creata una persona di nome " + x.getNome() + " ed eta' " + x.getEta());

        System.out.println("\nCollauda i set - Il nome deve essere Bobby con eta' 10");
        x.setNome("Bobby");
        x.setEta(10);
        System.out.println("La persona ha nome " + x.getNome() + " ed eta' " + x.getEta());


        System.out.println("\nCollaudo il metodo set overlodatod - Nome e' cambiato in Jane Doe");
        x.setNome("Jane", "Doe");
        x.setEta(10);
        System.out.println("La persona ha nome " + x.getNome() + " ed eta' " + x.getEta());
    }	
}
