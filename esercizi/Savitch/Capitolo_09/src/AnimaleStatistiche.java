
import java.util.*;

public class AnimaleStatistiche {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		String nomeAanimale;
		int etaAnimale;
		double pesoAnimale;

		System.out.println("Nome primo animale: ");
		nomeAanimale = tastiera.nextLine();
		System.out.println();
		System.out.println("Eta primo animale: ");
		etaAnimale = tastiera.nextInt();
		System.out.println();
		System.out.println("Peso primo animale: ");
		pesoAnimale = tastiera.nextDouble();
		Animale animale1 = new Animale(nomeAanimale, etaAnimale, pesoAnimale);
		System.out.println();
		System.out.println("Verifica:");
		animale1.scriviOutput();
		System.out.println();

		// nuovo oggetto per evitare problemi con nextLine()
		tastiera = new Scanner(System.in);

		System.out.println("Nome secondo animale: ");
		nomeAanimale = tastiera.nextLine();
		System.out.println();
		System.out.println("Eta secondo animale: ");
		etaAnimale = tastiera.nextInt();
		System.out.println();
		System.out.println("Peso secondo animale: ");
		pesoAnimale = tastiera.nextDouble();
		Animale animale2 = new Animale(nomeAanimale, etaAnimale, pesoAnimale);
		System.out.println();
		System.out.println("Verifica:");
		animale2.scriviOutput();
		System.out.println();

		// nuovo oggetto per evitare problemi con nextLine()
		tastiera = new Scanner(System.in);

		System.out.println("Nome terzo animale: ");
		nomeAanimale = tastiera.nextLine();
		System.out.println();
		System.out.println("Eta terzo animale: ");
		etaAnimale = tastiera.nextInt();
		System.out.println();
		System.out.println("Peso terzo animale: ");
		pesoAnimale = tastiera.nextDouble();
		Animale animale3 = new Animale(nomeAanimale, etaAnimale, pesoAnimale);
		System.out.println();
		System.out.println("Verifica:");
		animale3.scriviOutput();
		System.out.println();

		// nuovo oggetto per evitare problemi con nextLine()
		tastiera = new Scanner(System.in);

		System.out.println("Nome quarto animale: ");
		nomeAanimale = tastiera.nextLine();
		System.out.println();
		System.out.println("Eta quarto animale: ");
		etaAnimale = tastiera.nextInt();
		System.out.println();
		System.out.println("Peso quarto animale: ");
		pesoAnimale = tastiera.nextDouble();
		Animale animale4 = new Animale(nomeAanimale, etaAnimale, pesoAnimale);
		System.out.println();
		System.out.println("Verifica:");
		animale4.scriviOutput();
		System.out.println();

		// nuovo oggetto per evitare problemi con nextLine()
		tastiera = new Scanner(System.in);

		System.out.println("Nome quinto animale: ");
		nomeAanimale = tastiera.nextLine();
		System.out.println();
		System.out.println("Eta quinto animale: ");
		etaAnimale = tastiera.nextInt();
		System.out.println();
		System.out.println("Peso quinto animale: ");
		pesoAnimale = tastiera.nextDouble();
		Animale animale5 = new Animale(nomeAanimale, etaAnimale, pesoAnimale);
		System.out.println();
		System.out.println("Verifica:");
		animale5.scriviOutput();
		System.out.println();

		System.out.println();
		System.out.println("====================================");
		System.out.println();

		// Cerca e stampa il piu' pesante
		double piuPesante = animale1.getPeso();

		if (animale2.getPeso() > piuPesante)
			piuPesante = animale2.getPeso();
		if (animale3.getPeso() > piuPesante)
			piuPesante = animale3.getPeso();
		if (animale4.getPeso() > piuPesante)
			piuPesante = animale4.getPeso();
		if (animale5.getPeso() > piuPesante)
			piuPesante = animale5.getPeso();

		// Se più di un animale ha lo stesso peso, e che il peso è il peso
		// massimo, stampa i nomi di tutti gli animali con quel peso.
		// Un approccio simile è utilizzato per il peso minimo e l'età minima
		// e massima.

		System.out.println("Il/gli animale/i piu' pesante/i (" + piuPesante + " Kg):");
		if (animale1.getPeso() == piuPesante)
			System.out.println(animale1.getNome());
		if (animale2.getPeso() == piuPesante)
			System.out.println(animale2.getNome());
		if (animale3.getPeso() == piuPesante)
			System.out.println(animale3.getNome());
		if (animale4.getPeso() == piuPesante)
			System.out.println(animale4.getNome());
		if (animale5.getPeso() == piuPesante)
			System.out.println(animale5.getNome());
		System.out.println();

		// Cerca e stampa il piu' leggero
		double piuLeggero = animale1.getPeso();
		if (animale2.getPeso() < piuLeggero)
			piuLeggero = animale2.getPeso();
		if (animale3.getPeso() < piuLeggero)
			piuLeggero = animale3.getPeso();
		if (animale4.getPeso() < piuLeggero)
			piuLeggero = animale4.getPeso();
		if (animale5.getPeso() < piuLeggero)
			piuLeggero = animale5.getPeso();

		System.out.println("Il/gli animale/i piu' leggero/i (" + piuLeggero + " Kg):");
		if (animale1.getPeso() == piuLeggero)
			System.out.println(animale1.getNome());
		if (animale2.getPeso() == piuLeggero)
			System.out.println(animale2.getNome());
		if (animale3.getPeso() == piuLeggero)
			System.out.println(animale3.getNome());
		if (animale4.getPeso() == piuLeggero)
			System.out.println(animale4.getNome());
		if (animale5.getPeso() == piuLeggero)
			System.out.println(animale5.getNome());
		System.out.println();

		// Cerca e stampa il piu' anziano
		int piuAnziano = animale1.getEta();
		if (animale2.getEta() > piuAnziano)
			piuAnziano = animale2.getEta();
		if (animale3.getEta() > piuAnziano)
			piuAnziano = animale3.getEta();
		if (animale4.getEta() > piuAnziano)
			piuAnziano = animale4.getEta();
		if (animale5.getEta() > piuAnziano)
			piuAnziano = animale5.getEta();

		System.out.println("Il/gli animale/i piu' anziano/i (" + piuAnziano + " anni):");
		if (animale1.getEta() == piuAnziano)
			System.out.println(animale1.getNome());
		if (animale2.getEta() == piuAnziano)
			System.out.println(animale2.getNome());
		if (animale3.getEta() == piuAnziano)
			System.out.println(animale3.getNome());
		if (animale4.getEta() == piuAnziano)
			System.out.println(animale4.getNome());
		if (animale5.getEta() == piuAnziano)
			System.out.println(animale5.getNome());
		System.out.println();

		// Cerca e stampa il piu' giovane
		int piuGiovane = animale1.getEta();
		if (animale2.getEta() < piuGiovane)
			piuGiovane = animale2.getEta();
		if (animale3.getEta() < piuGiovane)
			piuGiovane = animale3.getEta();
		if (animale4.getEta() < piuGiovane)
			piuGiovane = animale4.getEta();
		if (animale5.getEta() < piuGiovane)
			piuGiovane = animale5.getEta();

		System.out.println("Il/gli animale/i piu' giovane/i (" + piuAnziano + " anni):");
		if (animale1.getEta() == piuGiovane)
			System.out.println(animale1.getNome());
		if (animale2.getEta() == piuGiovane)
			System.out.println(animale2.getNome());
		if (animale3.getEta() == piuGiovane)
			System.out.println(animale3.getNome());
		if (animale4.getEta() == piuGiovane)
			System.out.println(animale4.getNome());
		if (animale5.getEta() == piuGiovane)
			System.out.println(animale5.getNome());
		System.out.println();

		// Peso medio
		double pesoMedio = (animale1.getPeso() + animale2.getPeso() + animale3.getPeso() + animale4.getPeso()
				+ animale5.getPeso()) / 5;
		System.out.print("Peso medio (Kg) = " + pesoMedio);
		//FormattaOutput.scriviACapo(pesoMedio, 1);
		System.out.println();

		// Eta' media
		double etaMedia = (animale1.getEta() + animale2.getEta() + animale3.getEta() + animale4.getEta()
				+ animale5.getEta()) / (double) 5;
		System.out.print("Eta' media  (anni) = " + etaMedia);
		//FormattaOutput.scriviACapo(pesoMedio, 1);
		System.out.println();
	}
}
