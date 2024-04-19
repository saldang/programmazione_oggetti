
public class ParametriDemo {

	public static void main(String[] args) {
		SpecieDemo s1 = new SpecieDemo(), s2 = new SpecieDemo();
		s1.setSpecie("Bufalo Klingon", 10, 15);
		int unaPopolazione = 42;
		System.out.println("unaPopolazione PRIMA di invocare provaACambiare: " + unaPopolazione);
		s1.provaACambiare(unaPopolazione);
		System.out.println("unaPopolazione DOPO aver invocato provaACambiare: " + unaPopolazione);
		s2.setSpecie("Furetto", 90, 56);
		System.out.println("s2 PRIMA di invocare provaASostituire:");
		s2.scriviOutput();
		s1.provaASostituire(s2);
		System.out.println("s2 DOPO aver invocato provaASostituire:");
		s2.scriviOutput();
		s1.cambia(s2);
		System.out.println("s2 DOPO ave invocato cambia:");
		s2.scriviOutput();
	}
}
