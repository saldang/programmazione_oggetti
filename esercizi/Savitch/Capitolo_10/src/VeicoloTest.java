import java.util.Scanner;

public class VeicoloTest {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		char ripeti;

		do {// ripete se l'utente dice si
			int i = 1;// Contatore dei test

			// Testa i costruttori con scriviOutput()
			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore di default.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Nessuno");
			System.out.println("Marca: Nessuno");
			System.out.println("Numero di cilindri: 0");
			System.out.println();
			Veicolo v1 = new Veicolo();
			v1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con proprietario.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Ann");
			System.out.println("Marca: Nessuno");
			System.out.println("Numero di cilindri: 0");
			System.out.println();
			Persona p1 = new Persona("Ann");
			Veicolo v2 = new Veicolo(p1);
			v2.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con marca.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Nessuno");
			System.out.println("Marca: Honda");
			System.out.println("Numero di cilindri: 0");
			System.out.println();
			Veicolo v3 = new Veicolo("Honda");
			v3.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con proprietario e marca: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: David");
			System.out.println("Marca: Ford");
			System.out.println("Numero di cilindri: 0");
			System.out.println();
			Persona p2 = new Persona("David");
			Veicolo v4 = new Veicolo(p2, "Ford");
			v4.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con proprietario e numero di cilindri: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Jill");
			System.out.println("Marca: Nessuno");
			System.out.println("Numero di cilindri: 4");
			System.out.println();
			Persona p3 = new Persona("Jill");
			Veicolo v5 = new Veicolo(p3, 4);
			v5.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con marca e numero di cilindri:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Nessuno");
			System.out.println("Marca: Chevrolet");
			System.out.println("Numero di cilindri: 8");
			System.out.println();
			Veicolo v6 = new Veicolo("Chevrolet", 8);
			v6.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con proprietario, marca e numero di cilindri: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: John");
			System.out.println("Marca: Volvo");
			System.out.println("Numero di cilindri: 6");
			System.out.println();
			Persona p4 = new Persona("John");
			Veicolo v7 = new Veicolo(p4, "Volvo", 6);
			v7.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi nome proprietario:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: John");
			System.out.println();
			v7.scriviNomeProprietario();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi marca:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Marca: Volvo");
			System.out.println();
			v7.scriviMarca();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi numero di cilindri:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Numero di cilindri: 6");
			System.out.println();
			v7.scriviNumeroCilindri();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("metodo set di tutti gli attributi: ");
			System.out.println();
			System.out.println("Valori prima:");
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Caroline");
			System.out.println("Marca: Audi");
			System.out.println("Numero di cilindri: 5");
			System.out.println();
			Persona p5 = new Persona("Caroline");
			v7.set(p5, "Audi", 5);
			v7.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set proprietario:");
			System.out.println();
			System.out.println("Valori prima:");
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Audi");
			System.out.println("Numero di cilindri: 5");
			System.out.println();
			Persona p6 = new Persona("Jake");
			v7.setProprietario(p6);
			v7.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set marca:");
			System.out.println();
			System.out.println("Valori prima:");
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Jeep");
			System.out.println("Numero di cilindri: 5");
			System.out.println();
			v7.setMarca("Jeep");
			v7.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set numero di cilindri: ");
			System.out.println();
			System.out.println("Valori prima:");
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario : Jake");
			System.out.println("Marca : Jeep");
			System.out.println("Numero di cilindri : 10");
			System.out.println();
			v7.setNumeroCilindri(10);
			v7.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali,");
			System.out.println("i.e., hanno lo stesso proprietario, ");
			System.out.println("la stessa marca e ");
			System.out.println("lo stesso numero di cilindri.).");
			System.out.println("Si noti che questo verifica anche il metodo get per il proprietario di un veicolo.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			// Cambio Proprietario di v6 da "Nessuno" a "Ann"
			v6.setProprietario(p1);
			v6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			// Cambio i valori di v7 in modo che siano uguali a quelli di v6
			v7.set(v6.getPropietario(), v6.getMarca(), v6.getNumeroCilindri());
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere true.");
			System.out.println();
			System.out.println(v6.equals(v7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali:");
			System.out.println("Cambio proprietario del primo veicolo cosii che non siano uguali.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			// Cambio Proprietario di v6 da "Ann" a "David"
			v6.setProprietario(p2);
			v6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(v6.equals(v7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali:");
			System.out.println(
					"Cambio proprietario in modo che sia lo stesso per entrambi i veicoli, ma imposto la marca diversa.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			// Cambio Proprietario di v6 cosi' che sia lo stesso di v7
			v6.setProprietario(p1);
			v6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			v7.setMarca("Ferrari");
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(v6.equals(v7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali:");
			System.out.println(
					"Cambio marca cosi' che siano uguali, ma cambio numero di cilindri cosi' che sono diversi.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			v6.setMarca("Ferrari");
			v6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			// Cambio Numero di cilindri a 12
			v7.setNumeroCilindri(12);
			v7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(v6.equals(v7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println("Ancora? (S per Si, o N for No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 'y') || (ripeti == 'Y'));
	}
}
