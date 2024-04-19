public class EsempioInsieme {
	public static void main(String args[]) {
		// Oggetti rotondi
		InsiemeHash<String> rotondi = new InsiemeHash<String>();
		// Oggetti verdi
		InsiemeHash<String> verdi = new InsiemeHash<String>();

		// Aggiunta di elementi agli insiemi
		rotondi.aggiungi("piselli");
		rotondi.aggiungi("palla");
		rotondi.aggiungi("torta");
		rotondi.aggiungi("acini");

		verdi.aggiungi("piselli");
		verdi.aggiungi("tubo");
		verdi.aggiungi("erba");
		
		System.out.println("Contenuto dell'insieme rotondi:");
		rotondi.mostraInsieme();
		System.out.println();
		System.out.println("Contenuto dell'insieme verdi:");
		verdi.mostraInsieme();
		System.out.println();

		System.out.println("palla appartiene all'insieme rotondi? " + 
								rotondi.nellInsieme("palla"));
		System.out.println("palla appartiene all'insieme verdi? " + 
								verdi.nellInsieme("palla"));
		System.out.println("palla e piselli appartengono allo stesso insieme? " + 
	 	 	 ((rotondi.nellInsieme("palla") && rotondi.nellInsieme("piselli")) || 
	 	 	 (verdi.nellInsieme("palla") && verdi.nellInsieme("piselli"))));

		System.out.println("torta e erba appartengono allo stesso insieme? " + 
	 	 	 ((rotondi.nellInsieme("torta") && rotondi.nellInsieme("erba")) || 
	 	 	 (verdi.nellInsieme("torta") && verdi.nellInsieme("erba"))));

		System.out.print("Unione di verdi e rotondi: ");
		rotondi.unione(verdi).mostraInsieme();

		System.out.print("Intersezione di verdi e rotondi: ");
		rotondi.intersezione(verdi).mostraInsieme();
	}
}
