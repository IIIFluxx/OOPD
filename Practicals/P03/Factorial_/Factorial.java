import java.util.*;
import java.lang.Math.*;

public class Factorial
{
   public static void main( String [] args)
   {
	   
	   int i, factorial, num;
	   factorial = 1;
	   Scanner sc = new Scanner(System.in);
	   
		System.out.println("Please enter an integer in order to calculate its factorial: ");
		num = sc.nextInt();   
		
		if (num<0)
		{
			System.out.println("Input integer should not be negative. Factorials do not exist for negative numbers");
		}
		else if (num == 0)
		{
			System.out.println("The value of 0! is 1"); 
		}
		else
		{
			for(i=1;i<=num;i++)
			{
				factorial=factorial*i;  
			}
			System.out.println("Factorial of " + num + " is: " + factorial);
		}
		   
   }
}
   
	   
	   
	   