public class DocumentoTest {
	/**
	 * ====================== 
	 * Restituisce true se oggettoDoc contiene parolaChiave all'interno di testo
	 * ======================
	 */
	public static boolean contieneParolaChiave(Documento oggettoDoc, String parolaChiave) {
		if (oggettoDoc.toString().indexOf(parolaChiave, 0) >= 0)
			return true;
		return false;
	}

	/**
	 * ====================== metodo main ======================
	 */
	public static void main(String[] args) {
		Email email1 = new Email("Body about programming in Java", "Larry", "Curly", "Programming");
		Email email2 = new Email("Body about running marathons", "Speedy", "Gonzales", "races");

		File file1 = new File("Contents about some Java file", "file.txt");
		File file2 = new File("Contents about marathon races", "run.txt");

		System.out.println("Quale contiene Java?");
		if (contieneParolaChiave(email1, "Java"))
			System.out.println(" Email1");
		if (contieneParolaChiave(email2, "Java"))
			System.out.println(" Email2");
		if (contieneParolaChiave(file1, "Java"))
			System.out.println(" File1");
		if (contieneParolaChiave(file2, "Java"))
			System.out.println(" File2");
	}
} 