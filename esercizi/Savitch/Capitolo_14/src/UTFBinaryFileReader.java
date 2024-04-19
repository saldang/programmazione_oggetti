import java.util.*;
import java.io.*;

public class UTFBinaryFileReader {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the file to read the values from?");
		String fileName = input.nextLine().trim();

		try {

			// Open the file for reading with binary data

			ObjectInputStream binaryFile = new ObjectInputStream(new FileInputStream(fileName));

			String indicators = binaryFile.readUTF();

			System.out.println("The values are:");

			for (int i = 0; i < indicators.length(); i++) {
				if (indicators.charAt(i) == 'i') {
					System.out.print(" " + binaryFile.readInt());
				} else {
					System.out.print(" " + binaryFile.readDouble());
				}
			}

			binaryFile.close();

			System.out.println("\nFinished processing the file.");
		} catch (Exception e) {
			System.out.println("We had a problem:" + e.getMessage());

		}

	}

}
