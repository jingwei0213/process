/*
 * Reads the contents of a file if it exists
 * If the file does not exist, the program prompts the user for input, and writes the input into a newly created file
 */

import java.io.*;
import java.util.Scanner;

public class DisplayBook {

	public static void main(String[] args) {
		int i;

		try {
			// specify which file
			File book = new File("Book.txt");

			// checks if file exists
			if (book.exists()) {
				// creates input stream
				FileInputStream inputStream = new FileInputStream(book);

				// "reads" contents of file
				while ((i = inputStream.read()) != -1) {
					// prints out file letter by letter
					System.out.print((char) i);
				}
				inputStream.close(); // closes input stream
			} 
			
			// if file does not exist
			else {
				// creates scanner object to allow user input
				Scanner input = new Scanner(System.in);
				// creates output stream
				FileOutputStream outputStream = new FileOutputStream(book);

				// prompts user for favorite book
				System.out.print("What is your favorite book? ");
				String bookName = input.nextLine();

				// writes user's favorite book into file
				for (i = 0; i < bookName.length(); i++) {
					outputStream.write(bookName.charAt(i));
				}
				outputStream.close(); // closes output stream
				
				// gives feedback to user that new file has been created and book has been recorded
				System.out.println("Thank you. You have created a new Book.txt file and recorded " + bookName + " as your favorite book.");
			}
		} 
		
		// if file does not exist 
		// will never be called b/c user is prompted to give the name of their favorite book and a new file is created to store it 
		catch (IOException exception) {
			System.out.println("Cannot find file.");
		}

	}

}
