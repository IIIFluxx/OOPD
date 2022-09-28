import java.util.*;
import java.lang.Math.*;

public class Fibonacci
{
   public static void main( String [] args)
   { 
	  int response = 0; 
	  int input = 0;
	  int max = 20;
	  int[] fib = new int[max];
	    
	  Scanner sc = new Scanner(System.in);
	  fib[0] = 0;
	  fib[1] = 1;
	  
	  do 
	  {
		  System.out.println("Select an option - one (1) for inputting a number to calculate the Fibonacci sequence leading up to it - two (2) to exit");
		  response = sc.nextInt();
	  }
	  while ((response < 1) || (response > 2));
	  
	  if (response == 1)
	  {
		  do
		  {
			  System.out.println("Enter an integer value");
			  input = sc.nextInt();
		  }
		  while((input < 1) && (response > 20));
	  
		  for(int i=2; i <input; i++)
		  {
			  fib[i] =fib[i-1]+fib[i-2];
		  }
		  //print the Fibonacci series numbers
		  System.out.println("Fibonacci Series up to " + max);
		  
		  for(int i=0; i< max; i++)
		  {
			  System.out.println(fib[i] + " ");
		  }
	  }
	  else
	  {
		  System.out.println("Exiting program..");
	  }
	}
}
