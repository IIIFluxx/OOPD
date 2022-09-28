import java.util.*;
import java.lang.Math.*;

public class ShapeCalculator
{
   public static void main( String [] args)
   {
	   int diameter, truncatedArea, response;
	   double radius, length, width, base, height, centimetres, millimetres, metres, areaCircle, areaRectangle, areaTriangle;
	   double pi = 3.141592653;
	   Scanner sc = new Scanner(System.in);
	   // Obtaining neccessary data in order for the program to run.
	   System.out.println("Please select which shape you would like to enter from the following: ");
	   System.out.println("1 for Circle, 2 for Rectangle, 3 for Triangle, 4 for quit");
	   response = sc.nextInt();

	   switch (response) 
	   {
		   case 1:
		   // Process for calculating the area of a circle
		   System.out.println("Please enter a value for the diameter of the circle(cm)");
		   diameter = sc.nextInt();
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
		   System.out.println("Please enter a value for the length of the rectangle (cm)");
		   length = sc.nextDouble(); 
		   System.out.println("Please enter a value for the width of the rectangle (cm) ");
		   width = sc.nextDouble(); 
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
			System.out.println("Please enter a value for the base length of the triangle (mm) ");
			base = sc.nextDouble(); 

			System.out.println("Please enter a value for the height of the triangle (mm) ");
			height = sc.nextDouble(); 
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
			break;
		 default:
		   System.out.println("Exiting program..");	
		   break;
	   }
	}
}
