import java.util.*;

public class ContenitoreGruppi {
	private ArrayList<NodoGruppo> elementi;

	public ContenitoreGruppi() {
		elementi = new ArrayList<NodoGruppo>();
	}

	// Metodo privato di supporto per cercare una stringa
	private NodoGruppo trova(String s) {
		Iterator<NodoGruppo> accessor = elementi.iterator();
		NodoGruppo node = null;

		boolean trovato = false;
		while (accessor.hasNext() && !trovato) {
			node = accessor.next();
			if ((node.dati).equals(s))
				trovato = true;
		}

		if (trovato)
			return node;
		else
			return null;
	}

	public void aggiungiElemento(String s) {
		NodoGruppo nodo = trova(s);
		if (nodo == null) {
			// Non ancora presente, lo aggiunge
			NodoGruppo nuovoElemento = new NodoGruppo(s, null);
			elementi.add(nuovoElemento);
		}
	}

	public String getRappresentativa(String s) {
		NodoGruppo nodo = trova(s);

		while (nodo.collegamento != null) {
			nodo = nodo.collegamento;
		}

		return nodo.dati;
	}

	public ArrayList<String> getTutteRappresentative() {
		ArrayList<String> risultato = new ArrayList<String>();

		for (int i = 0; i < elementi.size(); i++) {
			if (elementi.get(i).collegamento == null)
				risultato.add(elementi.get(i).dati);
		}

		return risultato;
	}

	public boolean nelloStessoGruppo(String s1, String s2) {
		String rep1 = getRappresentativa(s1);
		String rep2 = getRappresentativa(s2);

		return (rep1 != null && rep1.equals(rep2));
	}

	public void unione(String s1, String s2) {
		String rep1 = getRappresentativa(s1);
		String rep2 = getRappresentativa(s2);

		if (rep1 != null && rep2 != null && !rep1.equals(rep2)) {
			NodoGruppo node1 = trova(rep1);
			NodoGruppo node2 = trova(rep2);
			node1.collegamento = node2;
		}
	}

	private class NodoGruppo {
		private String dati;
		private NodoGruppo collegamento;

		public NodoGruppo() {
			collegamento = null;
			dati = null;
		}

		public NodoGruppo(String dati, NodoGruppo collegamento) {
			this.dati = dati;
			this.collegamento = collegamento;
		}
	}

	public static void main(String[] args) {
		System.out.println("Costruzione gruppi per a b c d e f g h");

		ContenitoreGruppi iGruppi = new ContenitoreGruppi();

		iGruppi.aggiungiElemento("a");
		iGruppi.aggiungiElemento("b");
		iGruppi.aggiungiElemento("c");
		iGruppi.aggiungiElemento("d");
		iGruppi.aggiungiElemento("e");
		iGruppi.aggiungiElemento("f");
		iGruppi.aggiungiElemento("g");
		iGruppi.aggiungiElemento("h");

		System.out.println("I gruppi sono: " + iGruppi.getTutteRappresentative());

		iGruppi.unione("a", "d");
		iGruppi.unione("b", "d");
		iGruppi.unione("e", "b");
		iGruppi.unione("h", "f");
		System.out.println("Fatte alcune unioni, i gruppi sono adesso: " + iGruppi.getTutteRappresentative());

		System.out.println("a e e sono nello stesso gruppo (deve essere vero): " + iGruppi.nelloStessoGruppo("a", "e"));
		System.out.println(
				"a e f non sono nello stesso gruppo (deve essere falso) : " + iGruppi.nelloStessoGruppo("a", "f"));
	}
}
