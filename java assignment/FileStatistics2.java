/*
 * Compares the file statistics of a text file and word document containing the same content, 
 * and figures out how much larger the word document is
*/

import java.io.File;

public class FileStatistics2 {

	public static void main(String[] args) {
		// specifies text file and word document
		File text = new File("Quote.txt");
		File doc = new File("Quote.docx");
		
		// makes sure both files exist
		if (text.exists() && doc.exists()) {
			// calculates word document length to text document length ratio
			long ratio = doc.length() / text.length();
			// outputs text file size
			System.out.println("Quote.txt size: " + text.length() + " bytes.");
			// outputs word document size
			System.out.println("Quote.docx size: " + doc.length() + " bytes.");
			// outputs word-to-text ratio
			System.out.println("Ratio: The word document is " + ratio + " times the size of the text file.");
		} 
		
		// displays error if either file cannot be found
		else {
			System.out.println("Text file and/or word document not found.");
		}

	}

}
