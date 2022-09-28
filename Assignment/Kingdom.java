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
 * LAST MOD : 27/10/2019
 ****************************************************/
public class Kingdom
{
	//Class constants.
	public static final int ARRAYLENGTH = 30;
	
	//Private class fields
	private AllianceClass allianceArray[];
    private int allianceCount;
    /***************************************************
     * DEFAULT CONSTRUCTOR: Kingdom
     * PURPOSE: Initialises the length of the alliance array 
				at use in this class.
     * IMPORTS: none (void)
     ***************************************************/
    public Kingdom()
    {
        allianceArray = new AllianceClass[ARRAYLENGTH];
		allianceCount = 0;
    }
	
	 /********************************************************************
     *SUBMODULE: addAlliance
	 *IMPORT: none
	 *EXPORT: statement(String)
	 *PURPOSE: Creates a new Alliance object based off user input,
				and calls the addNewAlliance method to add the returned
				object to the Alliance array (classfield)
     *********************************************************************/
	
	public String addAlliance()
	{       
        AllianceClass newAllianceObj;
		String statement = "";
        int type = UserInterface.getObject();
        try
        {
            if (type == 1)
            {

                newAllianceObj = UserInterface.getHouseObject();
                addNewAlliance(newAllianceObj);
                statement = ("A new alliance has been added! ");
            }
            if (type == 2)
            {
                newAllianceObj = UserInterface.getArmyObject();
                addNewAlliance(newAllianceObj);
                statement = ("A new alliance has been added! ");
            }
        }
        catch (IllegalArgumentException e)
		{
		    System.out.println("Invalid object");    
		}
       
        return statement;
    }
				
	
    /***************************************************
     * SUBMODULE: addNewAlliance
     * IMPORTS: newAllianceObj of object type AllianceClass
     * EXPORTS: none
	 * PURPOSE: Adds imported object to allianceArray
	 * ASSERTION: Adds the imported object to the allianceArray (classfield) 
				 if and only if the object valid is valid and there is space
				 left in the allianceArray.
     ***************************************************/
	
	public void addNewAlliance(AllianceClass newAllianceObj)
	{
		if(newAllianceObj != null && allianceCount < ARRAYLENGTH)
		{
			allianceArray[allianceCount] = newAllianceObj;
			allianceCount++;
		}

		// If null, throw exception
		if (newAllianceObj == null)
		{
			throw new IllegalArgumentException("Object is null. ");
		}
		
		if (allianceCount > ARRAYLENGTH)
		{
			//reached end of array without finding an empty spot
		    throw new IllegalArgumentException("End of array reached and is "
                        + "now full");
		}
	}

    /***************************************************
     * SUBMODULE: allianceBattleStrength
     * PURPOSE: Find the strongest alliance and alert the user.
     * IMPORTS: none
     * EXPORTS: statement(String)
     ***************************************************/
    public String allianceBattleStrength()
    {
		String statement = "";        
        int battleStrength = 0;
		int tempStrength = 0;
		String bestAlliance = "";
        for(int i=0;i<allianceCount;i++)
        {
            tempStrength = allianceArray[i].battleStrength(); 
			if(tempStrength > battleStrength)
			{
				battleStrength = tempStrength;
				bestAlliance = allianceArray[i].getName();
			}
		}
		
        statement = "The strongest alliance " + bestAlliance 
					+ " has a strength of " + battleStrength + "\n";
        return statement;
     }

    /***************************************************
     * SUBMODULE: kingdomBattleStrength
     * PURPOSE: Find the strongest alliance and alert the user.
     * IMPORTS: none
     * EXPORTS: statement(String)
     ***************************************************/
    public String kingdomBattleStrength()
    {   
        String statement = "";
		int tempStrength = 0;
        for(int i=0;i<allianceCount;i++)
        {
			tempStrength += allianceArray[i].battleStrength(); 
        }
       statement = "The kingdom has a total battle strength of " + tempStrength;
        return statement;
        
    }
			
    /***************************************************
     * SUBMODULE: findDuplicates
     * PURPOSE: checks if there are any duplicates within the allianceArray, 
				and alerts the user whether there are any or not.
     * IMPORTS: none
     * EXPORTS: similarity(String)
     ***************************************************/
    public String findDuplicates()
    {
		String similarity = " ";
		// Check duplicates for Alliance array
		
		for (int i=0;i<allianceCount;i++)
		{
			for(int j=i+1;j<allianceCount;j++)
			{
				if ((allianceArray[i]).equals(allianceArray[j]))
				{
					similarity += ("Alliance " + (i+1) + " and " 
									+(j+1) + "are the same \n");
	            }
			}
		}
		return similarity; 
    }

    /***************************************************
     * SUBMODULE: compareKingdoms
     * PURPOSE: Checks whether two kingdoms contain exactly same classfields
				and alerts the user if so.
     * IMPORTS: none
     * EXPORTS: foundInfo(String)
     ***************************************************/
    public String compareKingdoms()
    {	
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
     * PURPOSE: Outputs any currently loaded Alliance's for the user to see.
     * IMPORTS: none
     * EXPORTS: allianceInfo(String)
     ***************************************************/
	
	public String viewAlliance()
    {
		String allianceInfo = " ";
		for (int i=0;i<allianceCount;i++)
		{
			allianceInfo += allianceArray[i].toString() + " \n";  
		}
			
		return allianceInfo;
    }

    /***************************************************
     * SUBMODULE: viewAlliancePopulation
     * PURPOSE: Outputs any currently loaded Alliance's populations
     * IMPORTS: none
     * EXPORTS: alliancePopulation(String)
     ***************************************************/
    public String viewAlliancePopulation()
    {
		String alliancePopulation = " ";
		
        for (int i=0;i<allianceCount;i++)
		{
			alliancePopulation += allianceArray[i].population();
		}
		return alliancePopulation;
    }

    /***************************************************
     * SUBMODULE: updateAlliance
     * PURPOSE: Takes user input for the name of the alliance
				they wish to update. If that Alliance's name is among the 
				currently loaded Alliance's, they can that Alliance's Banner 
     * IMPORTS: none
     * EXPORTS: foundInfo(String)
     ***************************************************/

	public String updateAlliance()
    {
		String foundInfo = "";
        String allianceName = UserInterface.getAllianceName();
        boolean found = false;
        int i=0;
        int index = 0;
        while(!found && i<allianceCount)
        {
            found = allianceArray[i].getName().equals(allianceName);
            index = i;
            i++;
        }
        if(found)
        {
            foundInfo = "Found";
            allianceArray[index].setBanner(UserInterface.getBannerObject());
            
     /* UserInterface.getBannerObj() returns a new Banner obj, then we use
			Alliance's setter allianceArray[index].setBanner to set the user 
			inputted banner values. */
        }
        else
        {
            foundInfo = "Not found";
        }
        return foundInfo;
    }


    /***************************************************
     * SUBMODULE: loadAlliance
     * PURPOSE: Loads an Alliance from a file (if valid).
     * IMPORTS: none
     * EXPORTS: return string indicating file being loaded
     ***************************************************/
    public String loadAlliance()
    {
		String fileName = UserInterface.getFileName();
		
		FileManager.readFile(fileName, this);		
    return "File has been loaded";
    }

    /***************************************************
     * SUBMODULE: saveAlliance
     * PURPOSE: Save a created alliance to a file (in CSV format).
     * IMPORTS: none
     * EXPORTS: return string indicating alliance being saved to a file.
     ***************************************************/
    public String saveAlliance()
    {
		String fileOutputName = UserInterface.getAllianceName();
        
        FileManager.writeFile(fileOutputName, this); 
		
		return "Alliance has been saved!";
    }
	
	 /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inObj(Object)
	 *EXPORT: same(boolean)
	 *PURPOSE: Checks if each classfield is equal to a identical 
				constructed object's classfields.
     *********************************************************************/
	public boolean equals(Object inObject)
	{
		boolean same = false;
        Kingdom inKingdom = null;
        int inAllianceCount;
        AllianceClass[] inAllianceArray;
        if (inObject instanceof Kingdom)
        {   
            inKingdom = (Kingdom)inObject;

            inAllianceCount = inKingdom.getAllianceCount();  
            inAllianceArray = inKingdom.getAllianceArray(); 

           

            if(inAllianceCount == allianceCount)
            {
                
                for (int i=0;i<allianceCount;i++)
			    {
				    if (inAllianceArray[i].equals(allianceArray[i]))
				    {
				    	same = true;
                    }
                }
            }
	    }
	    return same;
    }
		
	// ACCESSORS/GETTERS
	
	 /********************************************************************
     *SUBMODULE: getAllianceArray
	 *IMPORT: none
	 *EXPORT: (newAllianceArray[ARRAYLENGTH])(AllianceClass)
	 *PURPOSE: returns the classfield - allianceArray[]
     *********************************************************************/
	
    public AllianceClass[] getAllianceArray()
    {
	    AllianceClass[] newAllianceArray;
		newAllianceArray = new AllianceClass[ARRAYLENGTH];
        for (int i=0;i<allianceCount;i++)
		{
		    newAllianceArray[i] = allianceArray[i].clone();
		// Uses alliance's clone method (abstract method) ^
        }
		return newAllianceArray;
    }
	
	/********************************************************************
     *SUBMODULE: getAllianceCount
	 *IMPORT: none
	 *EXPORT: allianceCount(Integer)
	 *PURPOSE: returns the classfield - allianceCount
     *********************************************************************/

	public int getAllianceCount()
    {
	    return allianceCount;
    }
}
