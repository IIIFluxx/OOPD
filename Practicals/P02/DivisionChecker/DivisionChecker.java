import java.util.*;

public class DivisionChecker
{   
    public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		int numOne, numTwo;
		String solution;
		
		
		// Get input from user for program to work
		System.out.println("Please enter an integer - the dividend (number to be divided)");
		numOne = sc.nextInt();
		
		System.out.println("Please enter another integer - the divisor (number that divides into the dividend)");
		numTwo = sc.nextInt();
		if (numOne%numTwo == 0)
		{
			solution = "Divisible";
		}
		else
		{
			solution = "Not divisible";
		}
		System.out.println("These two numbers are: " + solution);
	}
}
