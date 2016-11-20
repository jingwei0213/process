import java.util.Scanner;

/**
 * 
 */

/**
 * @author Caitlin Stewart
 * Chapter 6 
 * College Cost
 * 
 * calculates amount needed to save per year based
 * on user input of age and cost
 *
 */
public class CollegeCost {

	
	public static void main(String[] args) {
		// gets age and cost, validates age, calculates amount to save, prints
		int age;
		int cost;
		final int LIMIT=18;
		int savePerYear;
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Please enter the child's age");
		age= input.nextInt();
		
		System.out.println("Please enter the estimated cost for college");
		cost= input.nextInt();

		while (age>LIMIT)
		{System.out.println("The age you have entered is too high");
		System.out.print("Please re-enter the child's age as less than " + LIMIT);
		age=input.nextInt();
		}

		savePerYear= age++;
		
		System.out.println("You should save $" + savePerYear + " per year.");

	}

}
