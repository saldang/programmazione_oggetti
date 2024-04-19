import java.io.*;

public class Gettysburg {

	public static void main(String[] args) {

		String nomeFile = "gettysburg.txt";
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(nomeFile);
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'aprire il file " + nomeFile);
			System.exit(0);
		}

		outputStream.println(
				"Four score and seven years ago our fathers brought forth on this continent a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.");
		outputStream.println(
				"Now we are engaged in a great civil war, testing whether that nation, or any nation, so conceived and so dedicated, can long endure.");
		outputStream.println("We are met on a great battle-field of that war.");
		outputStream.println(
				"We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live.");
		outputStream.println("It is altogether fitting and proper that we should do this.");
		outputStream.println(
				"But, in a larger sense, we can not dedicate-we can not consecrate-we can not hallow-this ground.");
		outputStream.println(
				"The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract.");
		outputStream.println(
				"The world will little note, nor long remember what we say here, but it can never forget what they did here.");
		outputStream.println(
				"It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. ");
		outputStream.println(
				"It is rather for us to be here dedicated to the great task remaining before us - that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion - that we here highly resolve that these dead shall not have died in vain - that this nation, under God, shall have a new birth of freedom - and that government of the people, by the people, for the people, shall not perish from the earth.");
		outputStream.close();

		System.out.println("Il file gettysburg.txt e' stato scritto.");
	}

}
