import java.util.Scanner;

/**
 * 
 */

/**
 * @author Caitlin Stewart
 * Chapter 7 Project 2
 * Count Spaces 2
 *
 */
public class CountSpaces2 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		// calculate number of spaces in user entered string
		
		
		int spaceCount=0;
		Scanner input=new Scanner(System.in);
	
		System.out.println("Please enter a string");
		StringBuilder userIn =new StringBuilder(input.nextLine());
		
		for (int i=0; i<userIn.length();i++)
		{
			if(Character.isWhitespace(userIn.charAt(i))) spaceCount++;
		}
		System.out.println("The number of the spaces in the string is " + spaceCount);
	}

}
