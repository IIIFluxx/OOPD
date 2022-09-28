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
	private House houseArray() = new House(ARRAYLENGTH);
	private ArmyClass armyArray() = new ArmyClass(ARRAYLENGTH);
	
    /***************************************************
     * DEFAULT CONSTRUCTOR: Kingdom
     * PURPOSE: Initialises the length of the two arrays at use in this class.
     * IMPORTS: none (void)
     ***************************************************/
    public Kingdom()
    {
        House [] houseArray[ARRAYLENGTH];
		ArmyClass [] armyArray[ARRAYLENGTH];
		houseCount = 0;
		armyCount = 0;
		
		// Construct kingdom object. This can be passed wherever necessary outside the class i.e. FileManager
		Kingdom kingdomObj = new Kingdom(houseArray[], armyArray[], houseCount, armyCount);		
    }

    /***************************************************
     * SUBMODULE: addAlliance
     * PURPOSE: Add an 'Alliance' to one of the arrays.
     * IMPORTS: inHouse(House), inArmy (ArmyClass)
     * EXPORTS: statement (String)
     ***************************************************/
    public String addAlliance(House inHouse, ArmyClass inArmy)
    {
		String objAdd = " ";
        //Implement this method
        //Calls should consist of:

            //Alliance newAlliance;
            //newAlliance = UserInterface.addAlliance();
            //addNewAlliance(newAlliance);

        //This is what it will look like after completion of Inheritance.
		
		/* Create new Kingdom object, pass it to menu, call in addHouseObjects and addArmyObjects based off input. */		
		addHouseObjects(inHouse);
		addArmyObjects(inArmy);
		objAdd = ("The objects have been added to their respective array");
		return objAdd;
    }
	
    /***************************************************
     * SUBMODULE: addHouseObjects
     * PURPOSE: 
     * IMPORTS: inHouse of object type House
     * EXPORTS:
     ***************************************************/
	
	public int addHouseObjects(House inHouse)
	{
		int i = 0;
		if(inHouse != null && houseCount < ARRAYLENGTH)
		{
			houseCount++;
			i++;
		}
		if (i == ARRAYLENGTH)
		{
			//reached end of array without finding an empty spot
			throw new InvalidArgumentException("Array is full!");
		}
		else
		{
			houseArray[i] = inHouse;
		}
	}
				
    /***************************************************
     * SUBMODULE: addArmyObjects
     * PURPOSE: 
     * IMPORTS: inArmy of object type ArmyClass
     * EXPORTS:
     ***************************************************/
	
	public int addArmyObjects(ArmyClass inArmy)
	{
		if(inArmy != null && armyCount < ARRAYLENGTH)
		{
			armyCount++;
			i++;
		}
		if (i == ARRAYLENGTH)
		{
		//reached end of array without finding an empty spot
			throw new InvalidArgumentException("Array is full!");
		}
		else
		{
			armyArray[i] = inArmy;
		}
	}
	
    /***************************************************
     * SUBMODULE: allianceBattleStrength
     * PURPOSE: Find the strongest alliance and alert the user.
     * IMPORTS: none
     * EXPORTS: strength(Integer)
     ***************************************************/
    public String allianceBattleStrength()
    {	
		String allianceStrength = " ";;
		while(inHouse != null && houseCount < ARRAYLENGTH)
		{
			battleStrength();
			houseCount++;
		}
		
		while(inArmy != null && armyCount < ARRAYLENGTH)
		{
			battleStrength();
			armyCount++;
		}
		return allianceStrength;
		
		/* Uses the  interface  method  battleStrength  that imports nothing and exports an integer.  The interface method should return an int that contains the strength of theAlliance. Your task is to find the strongest Allianceand notify the user.*/
		
    }

    /***************************************************
     * SUBMODULE: kingdomBattleStrength
     * PURPOSE:
     * IMPORTS: 
     * EXPORTS:
     ***************************************************/
    public String kingdomBattleStrength()
    {
		String kingdomStrength = " ";;
        while(inHouse != null && houseCount < ARRAYLENGTH)
		{
			kingdomBattleStrength();
			houseCount++;
		}
		
		while(inArmy != null && armyCount < ARRAYLENGTH)
		{
			kingdomBattleStrength();
			armyCount++;
		}
		return kingdomStrength;
		// return kingdomStrength integer
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
		
		for (i=0;i<ARRAYLENGTH;i++)
		{
			for(j=i+1;j<ARRAYLENGTH;j++)
			{
				if (houseArray[i].equals(houseArray[j]) 
				{
					similarity = ("They are duplicates of each other");
				}
				else
				{
					similarity = ("They are NOT duplicates of each other")'
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
		FileManager.readFile(this,fileName);
		FileManager.lineArrayValidation(this,line);
		FileManager.splitLineArray(this);
		
		if(kingdomObj.equals(newkingdomObj))
			{
				foundInfo = "found";
			}
			else
			{
				foundInfo = "Not found";
			}		
		return foundInfo;
		
		
		
		/* 1. Construct new kingdomObj from FileManager.
		   2. Fill it with Alliance's from the input file
		   3. Use Kingdom's **equals() method** to determine if it matches the existing Kingdom. */   
		
		// get new Kingdom from File Manager
		
		// For loop to check elements between two arrays 
		
		// calls loadAlliance, creates an object, pass in object, equate using equals.
		
		equals(___,___)
		////* HOW TO PASS BACK TO USERINTERFACE?? */////
    }

    /***************************************************
     * SUBMODULE: viewAlliance
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String viewAlliance()
    {
		String houseInfo = " ";;
		String armyInfo = " ";;
		String combinedInfo = " ";;
		for (i=0;i<ARRAYLENGTH;i++)
		{
			houseInfo = houseArray[i].toString();
			armyInfo = armyArray[i].toString();
			combinedInfo = houseInfo + " " + armyInfo;
		}
		
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
		for (i=0;i<ARRAYLENGTH;i++)
		{
			housePopulation = houseArray[i].population();
			armyPopulation = armyArray[i].population();
			combinedPopulation = housePopulation + " " + armyPopulation;
		}
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
        for (int i=0;i<ARRAYLENGTH;i++)
		{
			if(houseArray[i].equals(inName))
			{
				foundInfo = "Found";
			}
			else
			{
				foundInfo = "Not found";
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
		fileName = UserInterface.getFileName();
		
		FileManager.readFile(this,fileName);
		FileManager.lineArrayValidation(this,line);
		FileManager.splitLineArray(this);
		
		// if array is full -- print warning message
		
    }

    /***************************************************
     * SUBMODULE: saveAlliance
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
    public String saveAlliance()
    {
		FileManager.writeFile(this, fileOutputName, houseArray[],armyArray[], type); 
    }
	
	/***************************************************
     * SUBMODULE: equals
     * PURPOSE: 
     * IMPORTS: 
     * EXPORTS: 
     ***************************************************/
	public static boolean equals()
	{
		boolean same = true;
		if (houseArray.length = armyArray.length)
		{
			for (i=0;i<ARRAYLENGTH;i++)
			{
				if (houseArray[i] != armyArray[i])
				{
					same = false;
				}
			}
		}
	return same;
	}
		
	
	/************************************************************
     *SUBMODULE: population
	 *IMPORT: 
	 *EXPORT: Returns "not yet implemented".
	 *ASSERTION: 
     ************************************************************/
	public void population()
    {
        String message1;
		message = "Not yet implemented";
		return(message1);	
    }
	
	public void battleStrength()
    {
        String message2;
		message = "Not yet implemented";
		return(message2);	
    }
	
	// ACCESSORS/GETTERS
    public House getHouseArray()
    {
	    House [] newHouseArray;
		for (int i=0;i<ARRAYLENGTH;i++)
		{
			newHouseArray[i] = houseArray[i];
			return newHouseArray[];
		}
    }
	
	public ArmyClass getArmyArray()
    {
	    ArmyClass [] newArmyArray;

		for (int i=0;i<ARRAYLENGTH;i++)
		{
			newArmyArray[i] = armyArray[i];
			return newArmyArray[];
		}
    }
	
	public ArmyClass getHouseCount()
    {
	    return houseCount;
    }
	
	public ArmyClass getArmyCount()
    {
	    return armyCount;
    }
	
}
