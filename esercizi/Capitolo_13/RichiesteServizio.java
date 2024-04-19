

import java.util.*;

public class RichiesteServizio {

	private String[] nomi;
	private int numero;

	public RichiesteServizio() {
		nomi = new String[10];
		numero = 0;
	}

	public void aggiungiNome(String nome) throws RichiestaServizoException {
		if (numero == 10)
			throw new RichiestaServizoException("Spazio insufficiente per aggiungere il nome");
		nomi[numero] = nome;
		numero++;
	}

	public void rimuoviNome(String nome) throws RichiestaServizoException {
		int trovatoPosizione = -1;

		for (int i = 0; i < numero; i++) {
			if (nomi[i].equals(nome))
				trovatoPosizione = i;
		}

		if (trovatoPosizione == -1)
			throw new RichiestaServizoException("Nome non trovato");
		
		for (int i = trovatoPosizione; i < numero - 1; i++)
			nomi[i] = nomi[i + 1];

		nomi[numero - 1] = null;

		numero--;
	}

	public String getName(int i) {
		return nomi[i];
	}

	public int getNumber() {
		return numero;
	}

}
