/****************************************************
 * PLEASE NOTE: Students are required to populate this
 *       class with:
 *       - Any ClassFields required.
 *       - Any Constants required
 *       - Accessors (Getters) and Mutators (Setters) to support the
 *         Class Fields
 *       - equals(), clone(), toString()
 *       - Any additional submodule needed for
 *         correct implementation of the program.
 *
 *       The following submodule signatures MUST not
 *        be changed:
 *           - public String addAlliance()
 *           - public String allianceBattleStrength()
 *           - public String kingdomBattleStrength()
 *           - public String findDuplicates()
 *           - public String compareKingdoms()
 *           - public String viewAlliance()
 *           - public String viewAlliancePopulation()
 *           - public String updateAlliance()
 *           - public String loadAlliance()
 *           - public String saveAlliance()
 *
 * HINT: Each of the fixed methods can return a
 *       String to the UserInterface, use that
 *       String to print out the result from
 *       your submodule.
 ****************************************************/

/****************************************************
 * FILE : Kingdom.java
 * PURPOSE : Provides the basic container class for
 *           2019s2 OOPD assignment implementation.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 
 ****************************************************/
public class Kingdom
{
	//Class constants.
	public static final int ARRAYLENGTH = 15;
	
	//Private class fields
	private House houseArray[];
	private ArmyClass armyArray[];
	private int houseCount;
    private int armyCount;
    /***************************************************
     * DEFAULT CONSTRUCTOR: Kingdom
     * PURPOSE: Initialises the length of the two arrays at use in this class.
     * IMPORTS: none (void)
     ***************************************************/
    public Kingdom()
    {
        houseArray = new House[ARRAYLENGTH];
		armyArray = new ArmyClass[ARRAYLENGTH];
		houseCount = 0;
		armyCount = 0;
	
    }
	
	
	public String addAlliance()
	{
			//Calls should consist of:
			//Alliance newAlliance;
            //newAlliance = UserInterface.addAlliance();
            //addNewAlliance(newAlliance);
			//This is what it will look like after completion of Inheritance.
		
		// Create new Kingdom object based off user input, calls in the respective method -- addHouseObjects and addArmyObjects based off input.

		String statement = "";
		int type = UserInterface.getObject();
		try
		{
		    if (type == 1) // i.e. if they want to create a House object
		    {
			    House newHouseObj = UserInterface.getHouseObject();
			    addHouseObjects(newHouseObj);
			    statement = ("A new house has been added to the Kingdom");
		    }
		    if (type == 2) // i.e. if they want to create an Army object
		    {
			    ArmyClass newArmyObj = UserInterface.getArmyObject();
			    addArmyObjects(newArmyObj);
			    statement = ("A new army has been added to Kingdom");
			}
		}
		
        catch (IllegalArgumentException e)
		{
		    System.out.println("Invalid object");    
		}
        
        return statement;
    }
				
	
    /* **************************************************
     * SUBMODULE: addHouseObjects
     * PURPOSE: 
     * IMPORTS: inHouse of object type House
     * EXPORTS:
     ***************************************************/
	
	public void addHouseObjects(House newHouseObj)
	{
		if(newHouseObj != null && houseCount < ARRAYLENGTH)
		{
			houseArray[houseCount] = newHouseObj;
			houseCount++;
		}

		// If null, throw exception
		if (newHouseObj == null)
		{
			throw new IllegalArgumentException();
		}
		
		if (houseCount > ARRAYLENGTH)
		{
			//reached end of array without finding an empty spot
		    throw new IllegalArgumentException();
		}
	}
				
    /***************************************************
     * SUBMODULE: addArmyObjects
     * PURPOSE: 
     * IMPORTS: inArmy of object type ArmyClass
     * EXPORTS:
     ***************************************************/
	
	public void addArmyObjects(ArmyClass newArmyObj)
	{
		if(newArmyObj != null && armyCount < ARRAYLENGTH)
		{
            armyArray[armyCount] = newArmyObj;
			armyCount++;
		}
		
		// If null, throw exception
		if (newArmyObj == null)
		{
			throw new IllegalArgumentException();
		}
		
		if (armyCount > ARRAYLENGTH)
		{
			//reached end of array without finding an empty spot
			throw new IllegalArgumentException();
		}
	}

    /***************************************************
     * SUBMODULE: allianceBattleStrength
     * PURPOSE: Find the strongest alliance and alert the user.
     * IMPORTS: none
     * EXPORTS: allianceStrength(Integer)
     ***************************************************/
    public String allianceBattleStrength()
    {
		String statement = "";        
        int battleStrength = 0;
		int tempStrength = 0;
		String bestAlliance = "";
        for(int i=0;i<houseCount;i++)
        {
            tempStrength = houseArray[i].battleStrength(); 
			if(tempStrength > battleStrength)
			{
				battleStrength = tempStrength;
				bestAlliance = houseArray[i].getName();
			}
		}
		
		for(int i=0;i<armyCount;i++)
        {
            tempStrength = armyArray[i].battleStrength(); 
			if(tempStrength > battleStrength)
			{
				battleStrength = tempStrength;
				bestAlliance = houseArray[i].getName();
			}
		}
			
        statement = "The strongest alliance " + bestAlliance + " has a strength of " 
                    + battleStrength; 
        return statement;
     }

    /***************************************************
     * SUBMODULE: kingdomBattleStrength
     * PURPOSE:
     * IMPORTS: 
     * EXPORTS:
     ***************************************************/
    public String kingdomBattleStrength()
    {   
        String statement = "";
		int kingdomStrength = 0;
		int tempStrength = 0;
        for(int i=0;i<houseCount;i++)
        {
			tempStrength += houseArray[i].battleStrength(); 
        }
        for (int i=0;i<armyCount;i++)
        {
			tempStrength += armyArray[i].battleStrength(); 
        }
        kingdomStrength = tempStrength; // FIX 
        statement = "The kingdom has a battle strength of " + kingdomStrength;
        return statement;
        
    }
			
    /***************************************************
     * SUBMODULE: findDuplicates
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String findDuplicates()
    {
		String similarity = " ";
		// Check duplicates for Army array
		
		for (int i=0;i<houseCount;i++)
		{
			for(int j=i+1;j<houseCount;j++)
			{
				if ((houseArray[i]).equals(houseArray[j]))
				{
					similarity += ("House " + i + "and" + j + "are the same \n");
	            }
			}
		}
		// Check duplicates for Army array
		for (int i=0;i<armyCount;i++)
		{
			for(int j=i+1;j<armyCount;j++)
			{
				if (armyArray[i].equals(armyArray[j]))
				{
					similarity += ("Army " + i + "and" + j + "are the same \n");		
                }
		    }
		}
		return similarity; 
    }

    /***************************************************
     * SUBMODULE: compareKingdoms
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String compareKingdoms()
    {	
		String fileName;
		String foundInfo = "";
        Kingdom newKingdomObj = new Kingdom();
    	newKingdomObj.loadAlliance();	
        if(this.equals(newKingdomObj))
			{
				foundInfo = "The kingdoms are the same";
			}
			else
			{
				foundInfo = "The kingdoms are NOT the same";
			}		
		return foundInfo;
    }

    /***************************************************
     * SUBMODULE: viewAlliance
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
	
	public String viewAlliance()
    {
		String houseInfo = " ";
		String armyInfo = " ";
		String combinedInfo = " ";
		for (int i=0;i<houseCount;i++)
		{
			houseInfo = houseArray[i].toString();  
		}
		
		for (int i=0;i<armyCount;i++)
		{
			armyInfo = armyArray[i].toString(); 
		}
		
		combinedInfo = houseInfo + "  \n " + armyInfo;
		return combinedInfo;
    }

    /***************************************************
     * SUBMODULE: viewAlliancePopulation
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String viewAlliancePopulation()
    {
        String housePopulation = " ";
		String armyPopulation = " ";
		String combinedPopulation = " ";
		for (int i=0;i<houseCount;i++)
		{
			housePopulation += houseArray[i].population();
		}
		for (int i=0;i<armyCount;i++)
		{
			armyPopulation += armyArray[i].population();
		}
		combinedPopulation = housePopulation + " " + armyPopulation;

		return combinedPopulation;
    }

    /***************************************************
     * SUBMODULE: updateAlliance
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/

	public String updateAlliance()
    {
		String foundInfo = " ";
        String allianceName = UserInterface.getAllianceName();
        for (int i=0;i<houseCount;i++)
		{
			if(houseArray[i].getName().equals(allianceName))
			{
				foundInfo = "Found";
			}
			else
			{
				foundInfo = "Not found";
			}
		}
		
		for (int i=0;i<armyCount;i++)
		{
			if(armyArray[i].equals(allianceName))
			{
				foundInfo = "Found";
			}
			else
			{
				foundInfo = "Not found";
			}
		}
		return foundInfo;
	}


    /***************************************************
     * SUBMODULE: loadAlliance
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String loadAlliance()
    {
		String fileName = UserInterface.getFileName();
		
		FileManager.readFile(fileName, this);		
    return "File has been loaded";
    }

    /***************************************************
     * SUBMODULE: saveAlliance
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String saveAlliance()
    {
		String fileOutputName = UserInterface.getAllianceName();
        
        FileManager.writeFile(fileOutputName, this); 
		
		return "Alliance has been saved!";
    }
	
	/***************************************************
     * SUBMODULE: 	
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
	public boolean equals(Object inObject)
	{
		boolean same = true;
        Kingdom inKingdom = null;
    	int inHouseCount; 
	    int inArmyCount;  
        if (inObject instanceof Kingdom)
        {   
            inKingdom = (Kingdom)inObject;
			House[] inHouseArray;
            inHouseCount = inKingdom.getHouseCount();  
            inHouseArray = inKingdom.getHouseArray(); 
            
			ArmyClass[] inArmyArray;
            inArmyCount = inKingdom.getArmyCount();
			inArmyArray = inKingdom.getArmyArray(); 
			
            if(inHouseCount != houseCount)
            {
                same = false;
            }
			else
            {
                for (int i=0;i<ARRAYLENGTH;i++)
			    {
				    if (!(inHouseArray[i].equals(houseArray[i])))
				    {
				    	same = false;
                    }
                }
            }
            if(inArmyCount != armyCount)
            {
                same = false;
            }
            else 
            {
                for(int i=0;i<ARRAYLENGTH;i++)
                {   
                    if (!(inArmyArray[i].equals(houseArray[i])))
                    {
                        same = false;
                    }
                }
            }
        }
        else
        {
            same = false;
        }
	    return same;
	}
    
		
	
	/************************************************************
     *SUBMODULE: population
	 *IMPORT: 
	 *EXPORT: Returns "not yet implemented".
	 *ASSERTION: 
     ************************************************************/
	
	// ACCESSORS/GETTERS
    public House[] getHouseArray()
    {
	    House[] newHouseArray;
		newHouseArray = new House[ARRAYLENGTH];

        for (int i=0;i<houseCount;i++)
		{
            
			newHouseArray[i] = new House(houseArray[i]);
		}
		return newHouseArray;
    }
	
	public ArmyClass[] getArmyArray()
    {
	    ArmyClass[] newArmyArray;
        newArmyArray = new ArmyClass[ARRAYLENGTH];

		for (int i=0;i<armyCount;i++)
		{
			newArmyArray[i] = new ArmyClass(armyArray[i]);
		}
		return newArmyArray;
    }
	
	public int getHouseCount()
    {
	    return houseCount;
    }
	
	public int getArmyCount()
    {
	    return armyCount;
    }
	
}
