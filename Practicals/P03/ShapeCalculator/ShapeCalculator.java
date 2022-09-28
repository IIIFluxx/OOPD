import java.util.*;
import java.lang.Math.*;

public class ShapeCalculator
{
   public static void main( String [] args)
   {
	   int diameter, truncatedArea, response;
	   double radius, length, width, base, height, centimetres;
	   double millimetres, metres, areaCircle, areaRectangle, areaTriangle;
	   double pi = 3.141592653;
	   int min = 0;
	   length = 0;
	   width = 0;
	   char loopCond = 'y';
	   
	   Scanner sc = new Scanner(System.in);
	   // Obtaining neccessary data in order for the program to run.
	  do 
	  {
		   System.out.println("Please select which shape you would like to enter from the following: ");
		   System.out.println("1 for Circle, 2 for Rectangle, 3 for Triangle");
		   response = sc.nextInt();

		   switch (response) 
		   {
			   case 1:
			   // Process for calculating the area of a circle
					do
				   {
					   System.out.println("Please enter a value for the diameter of the circle(cm)");
					   diameter = sc.nextInt();
				   }
				   while (diameter < min);
			   radius = ((double)diameter)/2.0;
			   areaCircle = radius * radius * Math.PI;
			   // Use DIV & MOD to isolate m, cm and mm
			   truncatedArea = (int)areaCircle;
			   metres = truncatedArea/10000;
			   centimetres = truncatedArea%10000;
			   millimetres = (areaCircle - (double)truncatedArea) * 100;
			   //Output area of circle to user
			   System.out.println("Area of the circle is " + metres + "m^2, " + centimetres + "cm^2 and " + millimetres + "mm^2");
			   break;
			   
			   case 2:
			   do 
			   {
				   System.out.println("Please enter a value for the length of the rectangle (cm)");
				   length = sc.nextDouble(); 
				   System.out.println("Please enter a value for the width of the rectangle (cm)");
				   width = sc.nextDouble(); 
			   } 
			   while ((length < min) && (width < min));
			
			   // Process for calculating the area of a rectangle
			   areaRectangle = length * width;
			   // Use DIV & MOD to isolate m, cm and mm
			   truncatedArea = (int)areaRectangle;
			   metres = truncatedArea/10000;
			   centimetres = truncatedArea%10000;
			   millimetres = (areaRectangle - (double)truncatedArea) * 100;
			   //Output area of circle to user
			   System.out.println("Area of the rectangle is " + metres + "m^2, " + centimetres + "cm^2 and " + millimetres + "mm^2");
			   break;	   

			   case 3:
			   do
				{
					System.out.println("Please enter a value for the base length of the triangle (mm) ");
					base = sc.nextDouble(); 
					System.out.println("Please enter a value for the height of the triangle (mm) ");
					height = sc.nextDouble(); 
				}
				while ((length<min)&&(width<min));
				
				// Convert millimetre input to centimetres
				base = base/10;
				height = height/10;
				// Process for calculating the area of a triangle
				areaTriangle = base * height/2.0;
				// Use DIV & MOD to isolate m, cm and mm
				truncatedArea = (int)areaTriangle;
				metres = truncatedArea/10000;
				centimetres = truncatedArea%10000;
				millimetres = (areaTriangle - (double)(truncatedArea)*100);
				//Output area of circle to user
				System.out.println("Area of the rectangle is " + metres + "m^2, " + centimetres + "cm^2 and " + millimetres + "mm^2");

			   default:
				   System.out.println("That option is an invalid option.");
				   break;
			}
		System.out.println("Would you like to try again? (y for yes, n for no)");
		loopCond = sc.next().charAt(0);
	  }
	  while (loopCond == 'y' || loopCond == 'Y');
	}
}