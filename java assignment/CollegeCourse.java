import java.util.Scanner;

/**
 * 
 */

/**
 * @author Caitlin Stewart
 *Chapter 10
 *Program 9
 */
public class CollegeCourse {

	/**
	 * @param args
	 */
	
	public static String dept;
	static int courseNum;
	static int credits;
	static double fee;
	static final double cost=120.00;
	
	static Scanner input=new Scanner(System.in);
	
	public static void main (String[] args)
	{
		new UseCourse();
	}
	
	public CollegeCourse (String dept, int courseNum, int credits ) 
	{
	
		this.dept = dept;
		this.courseNum= courseNum;
		this.credits= credits;
		
		fee= cost * credits;
		
		
	}

	

	public void display() 
	{
		System.out.println(dept+ courseNum+ " "+ "is "+ credits+" credits, with a cost of $"+ fee + "." );
		
	}



}
