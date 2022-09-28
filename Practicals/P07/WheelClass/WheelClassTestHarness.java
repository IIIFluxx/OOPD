import java.util.*;

public class WheelClassTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            //Creating room for our wheels
            WheelClass[] wheel = new WheelClass[4];

            //Testing Default Constructor
            wheel[0] = new WheelClass();
            //Testing Alternate Constructor
            wheel[1] = new WheelClass("190/22 R22", 21.87, WheelClass.MAG, "Bridgestone");
            //Testing Copy Constructor
            wheel[2] = new WheelClass(wheel[1]);
            //Testing Clone method
            wheel[3] = wheel[1].clone();

            //Display created objects, also tests toString()
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < wheel.length; i++)
            {
                System.out.println("Wheel[" + i + "]: " + wheel[i].toString());
            }

            //Testing equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + wheel[1].equals(wheel[3]));
            System.out.println("Equals (object) expected FALSE: " + wheel[0].equals(wheel[3]));
   
            //Testing getters and setters
            // Alternate constructor tests setters as well.
            // Copy constructor tests getters as well.
            System.out.println("\nGETTERS AND SETTERS:");
            wheel[0].setSize(wheel[1].getSize());
            System.out.println(wheel[0].getSize() + " = " + wheel[1].getSize());

            wheel[0].setMake(wheel[2].getMake());
            System.out.println(wheel[0].getMake() + " = " + wheel[2].getMake());

            wheel[0].setRimType(wheel[1].getRimType());
            System.out.println(wheel[0].getRimType() + " = " + wheel[1].getRimType());

            wheel[0].setAirPressure(wheel[1].getAirPressure());
            System.out.println(wheel[0].getAirPressure() + " = " + wheel[1].getAirPressure());
            
        }
        catch(IllegalArgumentException e)
        {
            //Displaying first errors in the tests.
            System.out.println(e.getMessage());
        }
    }
}
