
public class SpecieEqualsDemo {

	public static void main(String[] args) {
		Specie s1 = new Specie(), s2 = new Specie(); 
		
		s1.setSpecie("Bufalo Klingon", 10, 15);
		s2.setSpecie("Bufalo Klingon", 10, 15);
		
		if (s1 == s2) 
			System.out.println("Corrispondono secondo ==.");
		else
			System.out.println("Non corrispondono secondo ==.");
		
		if (s1.equals(s2)) 
			System.out.println("Corrispondono secondo il metodo equals.");
		else
			System.out.println("Non corrispondono secondo il metodo equals.");
		
		System.out.println("Ora cambiamo un Klingon in lettere minuscole."); 
		s2.setSpecie("klingon", 10, 15); //Usa minuscole

		if (s1.equals(s2)) 
			System.out.println("Corrispondono secondo il metodo equals.");
		else
			System.out.println("Non corrispondono secondo il metodo equals.");		
	}
}
