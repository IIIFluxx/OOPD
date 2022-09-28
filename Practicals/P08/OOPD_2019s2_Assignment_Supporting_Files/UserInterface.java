public class UserInterface(kingdomObj)
{
	// No class constants or classfields
	
	//Each method MUST be static
	
	public static callMethods()
	{
		Menu.menu();
		
		switch(response)
		{
			case 1:
			{
				Kingdom.addAlliance();
			}
			case 2:
			{
				Kingdom.allianceBattleStrength();
			}
			case 3:
			{
				Kingdom.findDuplicates();
			}
			case 4:
			{
				Kingdom.compareKingdoms();
			}
			case 5:
			{
				Kingdom.viewAlliance();
			}
			case 6:
			{
				Kingdom.viewAlliancePopulation();
			}
			case 7:
			{
				Kingdom.updateAlliance();
			}
			case 8:
			{
				Kingdom.loadAlliance();
			}
			case 9:
			{
				Kingdom.saveAlliance()
			}
			case 0:
			{
				// How do you exit?
			}
		}
	}
				
	/* 
	
	