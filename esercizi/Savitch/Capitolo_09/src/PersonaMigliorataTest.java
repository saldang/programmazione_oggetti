
/**
 File name: PersonaMigliorataTest.java

 Class PersonaMigliorataTest: collauda la classe PersonaMigliorata.

 Questo programma crea oggetti di classe PersonaMigliorata e
 esercita i suoi metodi.  Gli oggetti di PersonaMigliorata hanno due 
 attributi: nome ed età.

 I metodi pubblici della classe PersonaMigliorata originariamente in Classe Persona:
   leggiInput assegna in modo interattivo il nome e i valori di età.
   stampa il nome e l'età.
   setPersona assegna nome ed età.
   getNome restituisce il nome.
   getEta restituisce l'età.

 Ulteriori metodi pubblici di PersonaMigliorata
	 verificare se due persone sono uguali (stesso nome ed età)l
	 verificare se due persone hanno lo stesso nome.
	 verificare se due persone hanno la stessa età.
	 verificare se una persona è più anziana di un'altra.
	 verificare se una persona è più giovane di un'altra.
 */
import java.util.*;

public class PersonaMigliorataTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println();
		System.out.println("Test case 1: costruttore di default e stampa()");
		PersonaMigliorata agenteSegreto1 = new PersonaMigliorata();
		System.out.println("Dovrebbe essere nome = \"Nessun nome\" ed eta' 0");
		System.out.println();
		agenteSegreto1.stampa();
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 2: verifica di leggiInput");
		agenteSegreto1.leggiInput();
		System.out.println("Dovrebbe essere cio' che e' stato inserito dall'utente");
		System.out.println();
		agenteSegreto1.stampa();
		System.out.println("==================================");
		System.out.println();

		System.out.println("Test case 3: costruttore con solo il nome.");
		PersonaMigliorata agenteSegreto2 = new PersonaMigliorata("Boris");
		System.out.println();
		System.out.println("Verifica nome = Boris and age = 0.");
		System.out.println();
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("====================================");

		System.out.println("Test case 4: costruttore con solo l'eta.");
		System.out.println();
		System.out.println("Verifica nome e' \"Nessun nome\" ed eta' = 40.");
		System.out.println();
		PersonaMigliorata agenteSegreto3 = new PersonaMigliorata(40);
		agenteSegreto3.stampa();
		System.out.println();
		System.out.println("====================================");

		System.out.println("Test case 5: ccostruttore con sia il nome che l'eta'.");
		System.out.println();
		System.out.println("Verifica nome = Natasha ed eta' 39.");
		System.out.println();
		PersonaMigliorata agenteSegreto4 = new PersonaMigliorata("Natasha", 39);
		agenteSegreto4.stampa();
		System.out.println();
		System.out.println("====================================");

		System.out.println();
		System.out.println("Test case 6:");
		System.out.println("getName: dovrebbe essere Natasha.");
		System.out.println();
		System.out.println("Verifica resultato: " + agenteSegreto4.getNome());
		System.out.println("====================================");

		System.out.println();
		System.out.println("Test case 7:");
		System.out.println("getEta: dovrebbe essere 39");
		System.out.println();
		System.out.println("Verifica resultato: " + agenteSegreto4.getEta());
		System.out.println("====================================");

		System.out.println();
		System.out.println("Test case 8:");
		System.out.println("setNome a Rocky");
		agenteSegreto4.setNome("Rocky");
		System.out.println();
		System.out.println("Verifica resultato con getNome(): " + agenteSegreto4.getNome());
		System.out.println("====================================");

		System.out.println();
		System.out.println("Test case 9:");
		System.out.println("setEta a 99");
		agenteSegreto4.setEta(99);
		System.out.println();
		System.out.println("Verifica resultato con getEta(): " + agenteSegreto4.getEta());
		System.out.println("====================================");

		System.out.println();
		System.out.println("Test case 10: metodo set (sia nome che eta') e equals (sia nome che eta')");
		System.out.println("Si creano due persone con lo stesso nome e la stessa eta':");
		agenteSegreto1.set("Bullwinkle", 10);
		agenteSegreto2.set("Bullwinkle", 10);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere vero.");
		System.out.println(agenteSegreto1.equals(agenteSegreto2));
		System.out.println("====================================");

		///////

		System.out.println();
		System.out.println("Test case 11:");
		System.out.println("equals (sia nome che eta')");
		System.out.println("con nomi diversi e stessa eta'.");
		agenteSegreto2.setNome("Boris");
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconds persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.equals(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 12:");
		System.out.println("equals (sia name che eta')");
		System.out.println("con eta' differenti e stesso nome.");
		agenteSegreto2.setNome("Natasha");
		agenteSegreto2.setEta(98);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.equals(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 13:");
		System.out.println("equals (sia name che eta')");
		System.out.println("con nome ed eta' differenti.");
		agenteSegreto2.setNome("Boris");
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.equals(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 14:");
		System.out.println("stessoNome");
		System.out.println("con lo stesso nome e la stessa eta'.");
		agenteSegreto2.set("Natasha", 99);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere vero.");
		System.out.println(agenteSegreto1.stessoNome(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 15:");
		System.out.println("stessoNome");
		System.out.println("con setsso nome ed eta' diverse.");
		agenteSegreto2.setEta(98);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("VVerifica: dovrebbe essere vero.");
		System.out.println(agenteSegreto1.stessoNome(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 16:");
		System.out.println("stessoNome");
		System.out.println("con nomi diversi e stessa eta'.");
		agenteSegreto2.setNome("Boris");
		agenteSegreto2.setEta(99);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.stessoNome(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 17:");
		System.out.println("stessoNome");
		System.out.println("con nomi diversi ed eta' diverse.");
		agenteSegreto2.setEta(98);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.stessoNome(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 18:");
		System.out.println("piuVecchiaDi");
		System.out.println("con al prma persona piu' anziana dell'altra.");
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere vero.");
		System.out.println(agenteSegreto1.piuVecchiaDi(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 19:");
		System.out.println("piuVecchiaDi");
		System.out.println("con la setssa eta'..");
		agenteSegreto2.setEta(99);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.piuVecchiaDi(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 20:");
		System.out.println("piuVecchiaDi");
		System.out.println("con al prima persona piu' giovane dell'altra.");
		agenteSegreto2.setEta(100);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.piuVecchiaDi(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 21:");
		System.out.println("piuGiovaneDi");
		System.out.println("con la prima pesrona piu' giovane dell'altra.");
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere vero.");
		System.out.println(agenteSegreto1.piuGiovaneDi(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 22:");
		System.out.println("piuGiovaneDi");
		System.out.println("con la stessa eta'.");
		agenteSegreto2.setEta(99);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.piuGiovaneDi(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 23:");
		System.out.println("piuGiovaneDi");
		System.out.println("con la prima persona piu' anziana dell'altra.");
		agenteSegreto2.setEta(98);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.piuGiovaneDi(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

	}
}
