import java.util.Date;

public class TabellaHashDemo
{
	public static void main(String[] args)
	{
		TabellaHash<Dipendente> h = new TabellaHash<Dipendente>();

		System.out.println("Aggiungo Pippo, Pluto, e Paperino");
		h.aggiungi("Pippo", new Dipendente("Pippo", 10000, 10, "10"));
		h.aggiungi("Pluto", new Dipendente("Pluto", 12000, 11, "27"));
		h.aggiungi("Paperino", new Dipendente("Paperino", 9000, 8, "3"));
		

		// Il metodo get puo' apparire strano. Il primo parametro è la chiave hash 
		// mentre il secondo e' un oggetto che puo' essere usato per il confronto 
		// con gli oggetti memorizzati nella tabella hash.  In questo caso, 
		// il metodo egual() controlla per vedere se i nomi corrispondono, 
		// quindi il secondo parametro serve come oggetto query per far corrispondere i dipendenti
		// Occorre solo bisogno di inserire il nome, dato che questa e' l'unica variabile utilizzata.
		System.out.println("Pippo è nella tabella? ");
		Dipendente e1 = (Dipendente) h.get("Pippo", new Dipendente("Pippo"));
	 	if (e1 != null)
	 		System.out.println("Vero");
	 	else
	 		System.out.println("Falso");

		System.out.println("Paperone? ");
		Dipendente e2 = (Dipendente) h.get("Paperone", new Dipendente("Paperone"));
	 	if (e2 != null)
	 		System.out.println("Vero");
	 	else
	 		System.out.println("Falso");

	 	Dipendente e3 = (Dipendente) h.get("Pippo",  new Dipendente("Pippo"));
	 	System.out.println("Dettagli su Pippo: " + e3.toString());

		System.out.println();
	}
}