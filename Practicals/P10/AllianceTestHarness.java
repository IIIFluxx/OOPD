import java.util.*;

public class AllianceTestHarness
{
    public static void main(String[] args)
    {
	boolean valid = false;  	
	AllianceClass allObj1 = new AllianceClass();
	AllianceClass allObj2 = new AllianceClass();
	if(allObj1.equals(allObj2))
	{
		valid = true;
	}
	System.out.println(valid);
    }
}
