import java.util.*;

public class AllianceClassTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            //Creating room for our wheels
            AllianceClass[] allianceArray = new AllianceClass[30];

            //Testing Default Constructor
            allianceArray[0] = new House();
            //Testing Alternate Constructor
            allianceArray[1] = new House("Archer", 2, 2, "");
            //Testing Copy Constructor
            allianceArray[2] = new House(allianceArray[1]);
            //Testing Clone method
            allianceArray[3] = allianceArray[1].clone();

            //Display created objects, also tests toString()
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < allianceArray.length; i++)
            {
                System.out.println("AllianceClass [" + i + "]: " + allianceArray[i].toString());
            }

            //Testing equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + allianceArray[1].equals(allianceArray[3]));
            System.out.println("Equals (object) expected FALSE: " + allianceArray[0].equals(allianceArray[3]));
   
            //Testing getters and setters
            // Alternate constructor tests setters as well.
            // Copy constructor tests getters as well.
            System.out.println("\nGETTERS AND SETTERS:");
            allianceArray[0].setName(allianceArray[1].getName());
            System.out.println(allianceArray[0].getName() + " = " + allianceArray[1].getName());

            allianceArray[0].setYears(allianceArray[2].getYears());
            System.out.println(allianceArray[0].getYears() + " = " + allianceArray[2].getYears());

            allianceArray[0].setFootmen(allianceArray[1].getFootmen());
            System.out.println(allianceArray[0].getFootmen() + " = " + allianceArray[1].getFootmen());

            allianceArray[0].setArchers(allianceArray[1].getArchers());
            System.out.println(allianceArray[0].getArchers() + " = " + allianceArray[1].getArchers());
			
            allianceArray[0].setHistory(allianceArray[1].getHistory());
            System.out.println(allianceArray[0].getHistory() + " = " + allianceArray[1].getHistory());
            
        }
        catch(IllegalArgumentException e)
        {
            //Displaying first errors in the tests.
            System.out.println(e.getMessage());
        }
    }
}
