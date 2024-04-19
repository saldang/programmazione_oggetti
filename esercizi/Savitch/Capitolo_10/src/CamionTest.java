import java.util.Scanner;

public class CamionTest {
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
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Camion t1 = new Camion(); // default constructor
			t1.scriviOutput();
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
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Persona p1 = new Persona("Ann");
			Camion t2 = new Camion(p1);
			t2.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con marca.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Nessuno");
			System.out.println("Marca: Dodge");
			System.out.println("Numero di cilindri: 0");
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Camion t3 = new Camion("Dodge");
			t3.scriviOutput();
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
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Persona p2 = new Persona("David");
			Camion t4 = new Camion(p2, "Ford");
			t4.scriviOutput();
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
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Persona p3 = new Persona("Jill");
			Camion t5 = new Camion(p3, 4);
			t5.scriviOutput();
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
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Camion t6 = new Camion("Chevrolet", 8);
			t6.scriviOutput();
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
			System.out.println("Capacita' di carico: 0 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 0 tonnellate.");
			System.out.println();
			Persona p4 = new Persona("John");
			Camion t7 = new Camion(p4, "Volvo", 6);
			t7.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Uso costruttore con tutti i parametri.");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Peggy");
			System.out.println("Marca: Volkswagen");
			System.out.println("Numero di cilindri: 4");
			System.out.println("Capacita' di carico: 1.5 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 2000 tonnellate.");
			System.out.println();
			Persona p5 = new Persona("Peggy");
			Camion t8 = new Camion(p5, "Volkswagen", 4, 1.5, 2000);
			t8.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi nome proprietario:");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Proprietario: Peggy");
			System.out.println();
			t8.scriviNomeProprietario();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi marca: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Marca: Volkswagen");
			System.out.println();
			t8.scriviMarca();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi numero di cilindri: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Numero di cilindri: 4");
			System.out.println();
			t8.scriviNumeroCilindri();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi capacita' di carico: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Capacita' di carico: 1.5 tonnellate");
			System.out.println();
			t8.scriviCapacitaCarico();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo scrivi capacita' di carico rimorchio: ");
			System.out.println();
			System.out.println("Verifica:");
			System.out.println("Capacita' di carico rimorchio: 2000 tonnellate");
			System.out.println();
			t8.scriviCapacitaCaricoRimorchio();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("metodo set di tutti gli attributi: ");
			System.out.println();
			System.out.println("Valori prima:");
			t1.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Caroline");
			System.out.println("Marca: Citroen");
			System.out.println("Numero di cilindri: 3");
			System.out.println("Capacita' di carico: 0.5 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 1000 tonnellate.");
			System.out.println();
			Persona p6 = new Persona("Caroline");
			t1.set(p6, "Citroen", 3, 0.5, 1000);
			t1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set proprietario: ");
			System.out.println();
			System.out.println("Valori prima:");
			t1.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Citroen");
			System.out.println("Numero di cilindri: 3");
			System.out.println("Capacita' di carico: 0.5 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 1000 tonnellate.");
			System.out.println();
			Persona p7 = new Persona("Jake");
			t1.setProprietario(p7);
			t1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set marca: ");
			System.out.println();
			System.out.println("Valori prima:");
			t1.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Jeep");
			System.out.println("Numero di cilindri: 3");
			System.out.println("Capacita' di carico: 0.5 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 1000 tonnellate.");
			System.out.println();
			t1.setMarca("Jeep");
			t1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo setNumero di cilindri: ");
			System.out.println();
			System.out.println("Valori prima:");
			t1.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Jeep");
			System.out.println("Numero di cilindri: 6");
			System.out.println("Capacita' di carico: 0.5 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 1000 tonnellate.");
			System.out.println();
			t1.setNumeroCilindri(6);
			t1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set numero di cilindri: ");
			System.out.println();
			System.out.println("Valori prima:");
			t1.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Jeep");
			System.out.println("Numero di cilindri: 6");
			System.out.println("Capacita' di carico: 1.25 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 1000 tonnellate.");
			System.out.println();
			t1.setCapacitaCarico(1.25);
			t1.scriviOutput();
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Metodo set capacita' di carico rimorchio: ");
			System.out.println();
			System.out.println("Valori prima:");
			t1.scriviOutput();
			System.out.println();
			System.out.println("Verifica valori dopo il cambio:");
			System.out.println("Proprietario: Jake");
			System.out.println("Marca: Jeep");
			System.out.println("Numero di cilindri: 6");
			System.out.println("Capacita' di carico: 1.25 tonnellate.");
			System.out.println("Capacita' di carico rimorchio: 2599 tonnellate.");
			System.out.println();
			t1.setCapacitaCaricoRimorchio(2599);
			t1.scriviOutput();
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
			// Cambio proprietario di v6 da "Nessuno" a "Ann"
			t6.setProprietario(p1);
			t6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			// Cambio i valori di v7 in modo che siano uguali a quelli di v6
			t7.set(t6.getPropietario(), t6.getMarca(), t6.getNumeroCilindri());
			t7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere true.");
			System.out.println();
			System.out.println(t6.equals(t7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali:");
			System.out.println("Cambio Proprietario of 1st vehicle so they are not equal.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			// Cambio proprietario of v6 da "Ann" a "David"
			t6.setProprietario(p2);
			t6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			t7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(t6.equals(t7));
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
			t6.setProprietario(p1);
			t6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			t7.setMarca("Mercedes");
			t7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(t6.equals(t7));
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
			t6.setMarca("Mercedes");
			t6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			// Cambio Numero di cilindri a 10
			t7.setNumeroCilindri(10);
			t7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(t6.equals(t7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali:");
			System.out.println(
					"Cambio numero di cilindri cosi' che siano uguali, ma cambio capacita' di carico cosi' che sono diversi.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			t6.setNumeroCilindri(10);
			t6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			// Cambio capacita' di carico a 0.1
			t7.setCapacitaCarico(0.1);
			t7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(t6.equals(t7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println();
			System.out.println("Test " + i + " :");
			System.out.println("Verifico se due veicoli sono uguali:");
			System.out.println(
					"Cambio capacita' di carico cosi' che siano uguali, ma cambio capacita' di carico rimorchio cosi' che sono diversi.");
			System.out.println();
			System.out.println("Valori per il primo veicolo:");
			// Cambio capacita' di carico rimorchio cosi' che sono diversi
			t6.setCapacitaCarico(0.1);
			t6.setCapacitaCaricoRimorchio(1);
			t6.scriviOutput();
			System.out.println();
			System.out.println("Valori per il secondo veicolo:");
			t7.scriviOutput();
			System.out.println();
			System.out.println("Verifica equals: dovrebbe essere false.");
			System.out.println();
			System.out.println(t6.equals(t7));
			System.out.println();
			System.out.println("===============================");
			++i;

			System.out.println("Ancora? (S per Si, o N for No)");
			ripeti = tastiera.next().charAt(0);

		} while ((ripeti == 's') || (ripeti == 'S'));
	}
}
