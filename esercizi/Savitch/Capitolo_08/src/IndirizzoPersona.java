import java.util.Scanner;

public class IndirizzoPersona {
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    
    public void inizializza(String nomeDAssegnare, String cognomeDaAssegnare, String emailDaAssegnare, String telefonoDaAssegnare) {
        nome = nomeDAssegnare;
        cognome = cognomeDaAssegnare;
        email = emailDaAssegnare;
        telefono = telefonoDaAssegnare;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCognome(){
        return cognome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setEmail(String nuovaEmail){
        email = nuovaEmail;
    }
    
    public void setTelefono(String nuovoTelefono){
        telefono = nuovoTelefono;
    }
    
    public boolean equal(IndirizzoPersona altraPersona){
        return cognome.equals(altraPersona.cognome) &&
                nome.equals(altraPersona.nome);
    }
    
    
  public static void main(String[] args) {        
        IndirizzoPersona persona1 = new IndirizzoPersona();
        IndirizzoPersona persona2 = new IndirizzoPersona();
        IndirizzoPersona persona3 = new IndirizzoPersona();
        persona1.inizializza("Joe", "Henry", "jhenry@bix.net", "555-3456");
        persona2.inizializza("Joe", "Henry", "jh@bbb.com", "555-4356");
        persona3.inizializza("Sue", "Henry", "sh@bbb.com", "555-4356");
        
        System.out.println("Attributi della perona 1");
        System.out.println(" Nome: " + persona1.getNome()
        + " " + persona1.getCognome()
        + " e-mail: " + persona1.getEmail()
        + " telefono: " + persona1.getTelefono()
        );
        System.out.println();
        
        System.out.println("persona 1 dovrebbe essere uguale a persona 2");
        System.out.println(persona1.equal(persona2));
        System.out.println();
        
        System.out.println("persona 2 non dovrebbe essere uguale a persona 3");
        System.out.println(persona2.equal(persona3));
        System.out.println();
        
        System.out.println("Cambio l'e-mail di persona 1 con \"email@bob\"");
        System.out.println("Cambio il telefono di persona 1 in \"555-1111\"");
        persona1.setEmail("email@bob");
        persona1.setTelefono("555-1111");
        System.out.println(" Nome: " + persona1.getNome()
        + " " + persona1.getCognome()
        + " e-mail: " + persona1.getEmail()
        + " telefono: " + persona1.getTelefono()
        );
        System.out.println();
    }
}




