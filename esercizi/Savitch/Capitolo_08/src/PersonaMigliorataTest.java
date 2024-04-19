
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
		System.out.println("Test case 1: leggiInput() e stampa()");
		PersonaMigliorata agenteSegreto1 = new PersonaMigliorata();
		agenteSegreto1.leggiInput();
		agenteSegreto1.stampa();
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 2:");
		System.out.println("setPersona: nome = Boris & age 40");
		agenteSegreto1.setPersona("Boris", 40);
		System.out.println();
		System.out.println("Verifica con stampa():");
		agenteSegreto1.stampa();
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 3:");
		System.out.println("getNome: dovrebbe essere Boris");
		System.out.println();
		System.out.println("Verifica:" + agenteSegreto1.getNome());
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 4:");
		System.out.println("getEta: dovrebbe essere 40");
		System.out.println();
		System.out.println("Verifica:" + agenteSegreto1.getEta());
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 5:");
		System.out.println("setNome: Natasha");
		agenteSegreto1.setNome("Natasha");
		System.out.println();
		System.out.println("Veifica: " + agenteSegreto1.getNome());
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 6:");
		System.out.println("setEta a 99");
		agenteSegreto1.setEta(99);
		System.out.println();
		System.out.println("Verifica: " + agenteSegreto1.getEta());
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 7:");
		System.out.println("equals (sia nome che eta')");
		System.out.println("Si creano due persone con lo stesso nome e la stessa eta':");
		PersonaMigliorata agenteSegreto2 = new PersonaMigliorata();
		agenteSegreto2.setPersona("Natasha", 99);
		System.out.println("Prima persona: ");
		agenteSegreto1.stampa();
		System.out.println("Seconda persona: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere vero.");
		System.out.println(agenteSegreto1.equals(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 8:");
		System.out.println("equals (sia nome che eta')");
		System.out.println("con nomi diversi e stessa eta'.");
		agenteSegreto2.setNome("Boris");
		System.out.println("Prima persons: ");
		agenteSegreto1.stampa();
		System.out.println("Seconds persons: ");
		agenteSegreto2.stampa();
		System.out.println();
		System.out.println("Verifica: dovrebbe essere falso.");
		System.out.println(agenteSegreto1.equals(agenteSegreto2));
		System.out.println("==================================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 9:");
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
		System.out.println("Test case 10:");
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
		System.out.println("Test case 11:");
		System.out.println("stessoNome");
		System.out.println("con lo stesso nome e la stessa eta'.");
		agenteSegreto2.setPersona("Natasha", 99);
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
		System.out.println("Test case 12:");
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
		System.out.println("Test case 13:");
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
		System.out.println("Test case 14:");
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
		System.out.println("Test case 15:");
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
		System.out.println("Test case 16:");
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
		System.out.println("Test case 17:");
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
		System.out.println("Test case 18:");
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
		System.out.println("Test case 19:");
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
		System.out.println("Test case 20:");
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
