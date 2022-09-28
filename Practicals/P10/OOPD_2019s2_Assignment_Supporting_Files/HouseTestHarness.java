import java.util.*;

public class HouseTestHarness
{
    public static void main(String[] args)
    {
	boolean valid = false;  	
	House houseObj1 = new House();
	House houseObj2 = new House();
	if(houseObj1.equals(houseObj2))
	{
		valid = true;
	}
	System.out.println(valid);
    }
}
