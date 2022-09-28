import java.util.*;

public class ArmyTestHarness
{
    public static void main(String[] args)
    {
	boolean valid = false;  	
	ArmyClass armyObj1 = new ArmyClass();
	ArmyClass armyObj2 = new ArmyClass();
	if(armyObj1.equals(armyObj2))
	{
		valid = true;
	}
	System.out.println(valid);
    }
}
