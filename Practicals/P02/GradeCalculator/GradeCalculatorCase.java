import java.util.*;
import java.lang.Math.*;

public class GradeCalculatorCase
{
   public static void main( String [] args)
   {
	double unitTotal;
	String grade;
	int mark, newMark;
	Scanner sc = new Scanner(System.in);
	// Obtaining neccessary data in order for the program to run.
	System.out.println("Please enter the total mark you recieved");
	unitTotal = sc.nextDouble();
	
	mark = (int)(Math.round(unitTotal));
	newMark = mark / 10;
	
	switch(newMark)
	{
		case 0:
		System.out.println("Invalid");
		break;
		
		case 1:
		System.out.println("F - " + mark);
		break;
		
		case 2:
		System.out.println("F - " + mark);
		break;
		
		case 3:
		System.out.println("F - " + mark);
		break;
		
		case 4:
		System.out.println("F - " + mark);
		break;
			
		case 5:
		System.out.println("P-5");
		break;
		
		case 6:
		System.out.println("C-6");
		break;
		
		case 7:
		System.out.println("D-7");
		break;
		
		case 8:
		System.out.println("HD-8");
		break;
		
		case 9:
		System.out.println("HD-9");
		break;
		
		case 10:
		System.out.println("HD-10");
		break;
		
		default:
		System.out.println("Invalid");
		break;
	}
   }
}

   
	
	


