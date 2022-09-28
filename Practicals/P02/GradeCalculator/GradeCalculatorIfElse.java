import java.util.*;
import java.lang.Math.*;

public class GradeCalculatorIfElse
{
   public static void main( String [] args)
   {
	double unitTotal;
	String grade;
	int mark;
	Scanner sc = new Scanner(System.in);
	// Obtaining neccessary data in order for the program to run.
	System.out.println("Please enter the total mark you recieved");
	unitTotal = sc.nextDouble();
	
	mark = (int)(Math.round(unitTotal));
	
	if (mark < 0)
	{
		System.out.println("Invalid");
	}
	else if (mark>= 0 && mark<50)
	{
		System.out.println("F - " + mark);
	}
	else if (mark>= 50 && mark<60)
	{
		System.out.println("P-5");
	}
	else if (mark>= 60 && mark<70)
	{
		System.out.println("C-6");
	}
	else if (mark>= 70 && mark<80)
	{
		System.out.println("D-7");
	}
	else if (mark>=80 && mark<90 )
	{
		System.out.println("HD-8");
	}
	else if (mark>=90 && mark<100 )
	{
		System.out.println("HD-9");
	}
	else if (mark==100)
	{
		System.out.println("HD-10");
	}
	else
	{
		System.out.println("Invalid");
	}
   }
}
