public class CaneDemo {
	public static void main(String[] args) {
		Cane balto = new Cane();
		balto.nome = "Balto";
		balto.anni = 8;
		balto.razza = "Husky Siberiano";
		
		balto.scriviOutput();
		
		Cane scooby = new Cane();
		scooby.nome = "Scooby";
		scooby.anni = 9;
		scooby.razza = "Alano";
		
		System.out.println(scooby.nome + " e' un " + scooby.razza + ".");
		System.out.print("Ha " + scooby.anni + " anni, oppure ");
		int anniUmani = scooby.getEtaInAnniUmani();
		System.out.println(anniUmani + " in anni umani.");
	}
}
