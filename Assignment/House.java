/****************************************************
 * FILE : House.java
 * PURPOSE : Subclass used in 2019s2 OOPD assignment.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/
public class House extends AllianceClass
{
    //Class constants.
	public static final int MINBANNERMEN = 25;
	public static final int MAXBANNERMEN = 80000;  
	public static final int BANNERMEN_POP_MULTIPLIER = 450;
	public static final int BANNERMEN_BS_MULTIPLIER = 2;
	public static final int CASTLE_BS_MULTIPLIER = 20000;

    //private class fields
    private String castle;
    private int bannermen;

    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new House object
     *PURPOSE: initializes the object containing House's classfields     
     ************************************************************/
	public House()
    {
        super();
        bannermen = 2;
        castle = "";
    }

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inBanner(BannerClass),
	 inBannermen(Integer), inCastle(String)
	 *EXPORT: address of new House class object
	 *PURPOSE: Creates the House object
	 *ASSERTION: Creates the House object only if imports are valid,
				 FAILS otherwise.
     ************************************************************/
    public House(String inName, int inYears, BannerClass inBanner, 
				 int inBannermen, String inCastle)
    {
        super(inName, inYears, inBanner);
        setBannermen(inBannermen);
        setCastle(inCastle);
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inHouse (House)
	 *EXPORT: address of new House class object
	 *PURPOSE: Creates an object with an identical object state as the import
     ************************************************************/
    public House(House inHouse)
    {
        super(inHouse);
		bannermen = inHouse.getBannermen();
		castle = inHouse.getCastle();
    }
	
    //MUTATORS
    /********************************************************************
     *SUBMODULE: setBannermen
	 *IMPORT: inBannermen(Integer)
	 *EXPORT: none
	 *ASSERTION: Sets the number of bannermen if import is 
				 valid, otherwise fails.
     *********************************************************************/
    public void setBannermen(int inBannermen)
    {
	    if(validateBannermen(inBannermen))
        {
		    bannermen = inBannermen;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid number of bannermen");
        }
    }

    /********************************************************************
     *SUBMODULE: setCastle
	 *IMPORT: inCastle (String)
	 *EXPORT: none
	 *ASSERTION: sets the castle name if import is valid, otherwise fails.
     *********************************************************************/
    public void setCastle(String inCastle)
    {
        if (validateCastle(inCastle))
		{
			castle = inCastle;
		}
		else
		{
			throw new IllegalArgumentException("Invalid castle description "
												+"- must not be null");
		}
    }

    //ACCESSORS
	
	 /********************************************************************
     *SUBMODULE: getBannermen
	 *IMPORT: none
	 *EXPORT: bannermen(Integer)
	 *PURPOSE: returns the classfield - bannermen
     *********************************************************************/
	
   public int getBannermen()
    {
	    return bannermen;
    }

	 /********************************************************************
     *SUBMODULE: getCastle
	 *IMPORT: none
	 *EXPORT: castle(String)
	 *PURPOSE: returns the classfield - castle
     *********************************************************************/

    public String getCastle()
    {
	    return castle;
    }
	
	 /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inObj(Object)
	 *EXPORT: isEqual(boolean)
	 *PURPOSE: Checks if each classfield is equal to a identical 
				constructed object's classfields
     *********************************************************************/
    @Override 
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if(inObj instanceof House)
        {
            House inHouse = (House)inObj;
            if(super.equals(inHouse))
                {
                    if(bannermen == inHouse.getBannermen())
                    {
                        if(castle.equals(inHouse.getCastle()))
                        {
                            isEqual =  true;
                        }
                    }
                }
	    }
        return isEqual;
    }
	 /********************************************************************
     *SUBMODULE: clone
	 *IMPORT: none
	 *EXPORT: new ArmyClass object 
	 *PURPOSE: Creates a House object of data-type AllianceClass
				that is a copy of the current House object
     *********************************************************************/
	
	public AllianceClass clone() 
    {
        return new House(this);
    }

	/********************************************************************
     *SUBMODULE: toString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a statement string containing specific classfields
     *********************************************************************/
    @Override
    public String toString()
    {
        return (super.toString() + ". \n This House has " + bannermen 
                + " Bannerman and " + "a castle named: " + castle + ". ");
    }
    
	 /********************************************************************
     *SUBMODULE: toFileString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a specific statement string 
				 in CSV (comma-separated) format
     *********************************************************************/
	 
	@Override
	public String toFileString()
	{
		return("H," + super.toFileString() + "," + bannermen + "," + castle 
                + ". \n");		
	}
	
	/********************************************************************
     *SUBMODULE: population
	 *IMPORT: none
	 *EXPORT: return string
	 *PURPOSE: returns a specific statement string 
				 containing a House's population
     *********************************************************************/

    @Override
	public String population()
    {
		int population = 0;
		population = bannermen + BANNERMEN_POP_MULTIPLIER;
		return ("The House of " + super.getName() + " has a population of " 
				+ population + ". \n");
    }
    
    // Automatically overrides battleStrength()
	
	/********************************************************************
     *SUBMODULE: battleStrength
	 *IMPORT: none
	 *EXPORT: strength(Integer)
	 *ASSERTION: returns an integer containing a House's Battle Strength
     *********************************************************************/ 
    
    public int battleStrength()
    {
        int strength = 0;
		if(castle.equals(""))
        {
            strength = bannermen * BANNERMEN_BS_MULTIPLIER;
        }
        if(!(castle.equals("")))
        {
            strength = (int)(bannermen * 2 + CASTLE_BS_MULTIPLIER);
        }
        return strength;
    }

    //PRIVATE SUBMODULES:
	/*************************************************************************
     *SUBMODULE: validateCastle
	 *IMPORT: inCastle (String)
	 *EXPORT: test (boolean)
	 *ASSERTION: Castle description must be non-empty (not null)
    ************************************************************************/
	private boolean validateCastle(String inCastle)
	{
		boolean test = false;
		if (inCastle != null)
		{
			test = true;
		}
		return test;
	}

      /*************************************************************************
     *SUBMODULE: validateBannermen 
	 *IMPORT: inBannermen (Integer)
	 *EXPORT: A boolean - true or false
	 *ASSERTION: Number of bannermen must be between 25 and 80,000 (inclusive). 
    ************************************************************************/
    private boolean validateBannermen(int inBannermen)
    {
        return ((inBannermen >= MINBANNERMEN) && 
				(inBannermen <= MAXBANNERMEN));
    }
}

