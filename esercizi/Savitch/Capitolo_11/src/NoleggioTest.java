
public class NoleggioTest {
	private Noleggio[] noleggi;

	public NoleggioTest(int numeroNoleggi) {
		noleggi = new Noleggio[numeroNoleggi];
	}

	public void setNoleggio(Noleggio noleggio, int indice) {
		this.noleggi[indice] = noleggio;
	}

	public Noleggio[] getNoleggi() {
		return this.noleggi;
	}

	public double calcolaPenaliRitardo() {
		double ammontare = 0;
		for (int i = 0; i < noleggi.length; i++) {
			ammontare += noleggi[i].calcolaPenaliRitardo();
		}
		return ammontare;
	}

	public static void main(String[] args) {
		Azione killbill2 = new Azione(0, "Kill Bill: Volume 2");
		Commedia meangirls = new Commedia(1, "Mean Girls");
		Dramma mystic = new Dramma(2, "Mystic River");

		NoleggioTest noleggiDiJoe = new NoleggioTest(3); // Joe e' ID #1
		Noleggio noleggio1 = new Noleggio(killbill2, 1);
		Noleggio noleggio2 = new Noleggio(meangirls, 1);
		Noleggio noleggio3 = new Noleggio(mystic, 1);
		noleggiDiJoe.setNoleggio(noleggio1, 0); 
		noleggiDiJoe.setNoleggio(noleggio2, 1);
		noleggiDiJoe.setNoleggio(noleggio3, 2);
		
		noleggio1.setGiorniDiRitardo(2);
		noleggio2.setGiorniDiRitardo(2);
		noleggio3.setGiorniDiRitardo(2);
		
		System.out.println("Con un ritrado di 2 giorni per ogni film, Joe deve pagare una penale pari a: " + noleggiDiJoe.calcolaPenaliRitardo());
	}
}
