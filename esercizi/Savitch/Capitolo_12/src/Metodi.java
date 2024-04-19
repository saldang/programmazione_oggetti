import java.util.ArrayList;
import java.util.Scanner;

public class Metodi {

	// Esercizio 5
	public static void rimuoviDuplicati(ArrayList<Character> dati) {
		for (int i = 0; i < dati.size(); i++) {
			int j = i + 1;
			while (j < dati.size()) {
				if (dati.get(i) == dati.get(j))
					dati.remove(j);
				else
					j++;
			}
		}
	}

	// Esercizio 6
	public static ArrayList<String> getStringheComuni(ArrayList<String> lista1, ArrayList<String> lista2) {
		ArrayList<String> risultato = new ArrayList<String>();
		for (int i = 0; i < lista1.size(); i++) {
			for (int j = 0; j < lista2.size(); j++) {
				if (lista1.get(i).equals(lista2.get(j)))
					risultato.add(lista1.get(i));
			}
		}
		// Rimuove i duplicati
		for (int i = 0; i < risultato.size(); i++) {
			int j = i + 1;
			while (j < risultato.size()) {
				if (risultato.get(i) == risultato.get(j))
					risultato.remove(j);
				else
					j++;
			}
		}
		return risultato;
	}

	// Esercizio 6: soluzione alternativa
	public static ArrayList<String> getStringheComuni2(ArrayList<String> lista1, ArrayList<String> lista2) {
		ArrayList<String> risultato = (ArrayList<String>) lista1.clone();
		risultato.retainAll(lista2);
		// Rimuove i duplicati
		for (int i = 0; i < risultato.size(); i++) {
			int j = i + 1;
			while (j < risultato.size()) {
				if (risultato.get(i) == risultato.get(j))
					risultato.remove(j);
				else
					j++;
			}
		}
		return risultato;
	}

	
	
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		ArrayList<Character> dati = new ArrayList<Character>();
		dati.add('a');
		dati.add('b');
		dati.add('c');
		dati.add('a');
		dati.add('b');
		dati.add('a');
		dati.add('a');
		dati.add('a');
		dati.add('b');
		dati.add('b');
		dati.add('b');
		dati.add('c');
		dati.add('d');
		dati.add('a');
		dati.add('b');
		dati.add('e');
		dati.add('f');
		dati.add('a');
		dati.add('b');
		dati.add('g');
		dati.add('f');
		dati.add('a');
		dati.add('b');
		dati.add('g');

		rimuoviDuplicati(dati);

		System.out.println("Rimuovendo i duplicati dovremmo avere a,b,c,d,e,f,g " + dati);

		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();

		list1.add("ab");
		list1.add("cd");
		list1.add("ef");
		list1.add("gh");
		list1.add("gh");
		list1.add("ij");
		list1.add("kl");
		list1.add("mn");
		list1.add("op");
		list1.add("qr");

		list2.add("ef");
		list2.add("wx");
		list2.add("ef");
		list2.add("wx");
		list2.add("gh");
		list2.add("ij");
		list2.add("kl");
		list2.add("mn");
		list2.add("st");
		list2.add("uv");
		list2.add("ef");
		list2.add("gh");
		list2.add("ij");
		list2.add("kl");
		list2.add("yz");

		System.out.println("Le stringhe comuni dovrebbero essere ef, gh, ij, kl, mn " + getStringheComuni2(list1, list2));

	}
}
