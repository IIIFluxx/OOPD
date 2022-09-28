import java.util.*;

public class ArmyTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            //Creating room for our wheels
            ArmyClass[] armyArr = new ArmyClass[];

            //Testing Default Constructor
            armyArr[0] = new ArmyClass();
            //Testing Alternate Constructor
            armyArr[1] = new ArmyClass("Archer", 2, 2, "");
            //Testing Copy Constructor
            armyArr[2] = new ArmyClass(armyArr[1]);
            //Testing Clone method
            armyArr[3] = armyArr[1].clone();

            //Display created objects, also tests toString()
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < armyArr.length; i++)
            {
                System.out.println("ArmyClass [" + i + "]: " + armyArr[i].toString());
            }

            //Testing equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + armyArr[1].equals(armyArr[3]));
            System.out.println("Equals (object) expected FALSE: " + armyArr[0].equals(armyArr[3]));
   
            //Testing getters and setters
            // Alternate constructor tests setters as well.
            // Copy constructor tests getters as well.
            System.out.println("\nGETTERS AND SETTERS:");
            armyArr[0].setName(armyArr[1].getName());
            System.out.println(armyArr[0].getName() + " = " + armyArr[1].getName());

            armyArr[0].setYears(armyArr[2].getYears());
            System.out.println(armyArr[0].getYears() + " = " + armyArr[2].getYears());

            armyArr[0].setFootmen(armyArr[1].getFootmen());
            System.out.println(armyArr[0].getFootmen() + " = " + armyArr[1].getFootmen());

            armyArr[0].setArchers(armyArr[1].getArchers());
            System.out.println(armyArr[0].getArchers() + " = " + armyArr[1].getArchers());
			
            armyArr[0].setHistory(armyArr[1].getHistory());
            System.out.println(armyArr[0].getHistory() + " = " + armyArr[1].getHistory());
            
        }
        catch(IllegalArgumentException e)
        {
            //Displaying first errors in the tests.
            System.out.println(e.getMessage());
        }
    }
}
