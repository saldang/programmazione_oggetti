public class CaneDemo {
	public static void main(String[] args) {
		Cane balto = new Cane();
		balto.setNome("Balto");
		balto.setRazza("Siberian Husky");
		balto.setAnni(8);
		balto.scriviOutput();

		Cane scooby = new Cane();
		scooby.setNome("Scooby");
		scooby.setRazza("Great Dane");
		scooby.setAnni(42);
		scooby.scriviOutput();

		System.out.println("Scooby e Balto sono uguali? " + scooby.equals(balto));

		Cane baltoJunior = new Cane();
		baltoJunior.setNome("Balto");
		baltoJunior.setRazza("Siberian Husky");
		baltoJunior.setAnni(balto.getAnni() - 4);
		System.out.println("BaltoJunior e Balto sono uguali? " + baltoJunior.equals(balto));

		Cane baltoClone = new Cane();
		baltoClone.setNome("Balto");
		baltoClone.setRazza("Siberian Husky");
		baltoClone.setAnni(8);
		System.out.println("BaltoClone e balto sono uguali? " + baltoClone.equals(balto));
	}
}
