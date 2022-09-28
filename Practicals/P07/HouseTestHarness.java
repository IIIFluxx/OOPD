import java.util.*;

public class HouseTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            //Creating room for our wheels
            House[] houseArr = new House[];

            //Testing Default Constructor
            houseArr[0] = new House();
            //Testing Alternate Constructor
            houseArr[1] = new House("Archer", 2, 2, "");
            //Testing Copy Constructor
            houseArr[2] = new House(houseArr[1]);
            //Testing Clone method
            houseArr[3] = houseArr[1].clone();

            //Display created objects, also tests toString()
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < houseArr.length; i++)
            {
                System.out.println("House[" + i + "]: " + houseArr[i].toString());
            }

            //Testing equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + houseArr[1].equals(houseArr[3]));
            System.out.println("Equals (object) expected FALSE: " + houseArr[0].equals(houseArr[3]));
   
            //Testing getters and setters
            // Alternate constructor tests setters as well.
            // Copy constructor tests getters as well.
            System.out.println("\nGETTERS AND SETTERS:");
            houseArr[0].setName(houseArr[1].getName());
            System.out.println(houseArr[0].getName() + " = " + houseArr[1].getName());

            houseArr[0].setYears(houseArr[2].getYears());
            System.out.println(houseArr[0].getYears() + " = " + houseArr[2].getYears());

            houseArr[0].setBannermen(houseArr[1].getBannermen());
            System.out.println(houseArr[0].getBannermen() + " = " + houseArr[1].getBannermen());

            houseArr[0].setCastle(houseArr[1].getCastle());
            System.out.println(houseArr[0].getCastle() + " = " + houseArr[1].getCastle());
            
        }
        catch(IllegalArgumentException e)
        {
            //Displaying first errors in the tests.
            System.out.println(e.getMessage());
        }
    }
}
