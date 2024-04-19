package downcasting;
public class App {

    public static void main(String[] args) {
        Persona[] persone = { new Persona("Salvatore", "DAngelo"), new Studente("Mario", "Rossi", 111),
                new Bambino("Alberto", "DAngelo", "macchinine") };
        for (Persona persona : persone) {
            
            if (Persona.class.isInstance(persona))
                persona.miPresento();
            else if (Studente.class.isInstance(persona)) {
                persona.miPresento();
                ((Studente) persona).studio();
            } else if (Bambino.class.isInstance(persona)) {
                persona.miPresento();
                ((Bambino) persona).gioca();
            }

        }
    }
}