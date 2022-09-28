import java.util.*;
public class KingdomManager
{
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
			UserInterface.showError("Error! Program will terminate now." + e.getMessage());
		}
	}
}
			