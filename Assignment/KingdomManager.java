import java.util.*;

/****************************************************
 * FILE : KingdomManager.java
 * PURPOSE : Contains main method. Calls the menu class.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/

public class KingdomManager
{
	 /********************************************************************
     *SUBMODULE: main
	 *IMPORT: none
	 *EXPORT: name(String)
	 *PURPOSE: creates a new Kingdom class object and calls the Menu class.
     *********************************************************************/
	public static void main(String [] args)
	{
		Kingdom kingdom;
		try
		{
			kingdom = new Kingdom();
			Menu.menu(kingdom);
		}
		catch(Exception e)
		{
			UserInterface.showError("Error! Program will terminate now." 
                                    + e.getMessage());
		}
	}
}
			
