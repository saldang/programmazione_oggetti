public class SpecieEqualsDemo2 {

	public static void main(String[] args) {
		Specie s1 = new Specie(), s2 = new Specie(); 
		
		s1.setSpecie("Bufalo Klingon", 10, 15);
		s2.setSpecie("Bufalo Klingon", 10, 15);
		
		testConOperatoreUguale(s1, s2);
		testConMetodoEquals(s1, s2);
		
		System.out.println("Cambio un Felino in minuscole."); 
		s2.setSpecie("felino", 10, 15); //Usa minuscole

		testConOperatoreUguale(s1, s2);		
	}
	
	private static void testConOperatoreUguale(Specie s1, Specie s2) {
		if (s1 == s2) 
			System.out.println("Uguale con ==.");
		else
			System.out.println("Non uguale con ==.");
	}	
	
	private static void testConMetodoEquals(Specie s1, Specie s2) {
		if (s1.equals(s2)) 
			System.out.println("Uguale con il metodo equals.");
		else
			System.out.println("Non uguale con il metodo equals.");
	}
}
