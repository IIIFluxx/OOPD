public class House
{
    //Class constants.
    public static final int minyears = 1;
	public static final int maxyears = 10000;
	public static final int minbannermen = 25;
	public static final int maxbannermen = 80000;

    //private class fields
    private String name, castle;
    private int years, bannermen;

    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new House object
     *ASSERTION:
     ************************************************************/
	public House()
    {
        name = new String("Archer");
        years = 2;
        bannermen = 2;
        castle = "";
    }

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inBannermen(Integer), inCastle(String)
	 *EXPORT: address of new House class object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public House(String inName, int inYears, int inBannermen, String inCastle)
    {
        setName(inName);
        setYears(inYears);
        setBannermen(inBannermen);
        setCastle(inCastle);
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inHouse (House)
	 *EXPORT: address of new House class object
	 *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
    public House(House inHouse)
    {
	    name = inHouse.getName();
        years = inHouse.getYears();
		bannermen = inHouse.getBannermen();
		castle = inHouse.getCastle();
    }

    //MUTATORS
    /************************************************************
     *SUBMODULE: setName
	 *IMPORT: inName (String)
	 *EXPORT: none
	 *ASSERTION: Sets the name to inName.
     ************************************************************/
    public void setName(String inName)
    {
        name = inName;
    }
    /********************************************************************
     *SUBMODULE: setYears
	 *IMPORT: inYears (Integer)
	 *EXPORT: none
	 *ASSERTION: Sets the year if imports are valid, otherwise, fails.
     *********************************************************************/
    public void setYears(int inYears)
    {
	    if(validateYears(inYears))
        {
		    years = inYears;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid number of years");
        }
    }

   /********************************************************************
     *SUBMODULE: setBannermen
	 *IMPORT: inBannermen(Integer)
	 *EXPORT: none
	 *ASSERTION: Sets the number of bannermen if imports are valid, otherwise, fails.
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
	 *ASSERTION: sets the castle name.
     *********************************************************************/
    public void setCastle(String inCastle)
    {
        castle = inCastle;
    }


    //ACCESSORS
    public String getName()
    {
	    return name;
    }

    public int getYears()
    {
	    return years;
    }

    public int getBannermen()
    {
	    return bannermen;
    }

    public String getCastle()
    {
	    return castle;
    }

    /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inObj (Object)
	 *EXPORT: isEqual (Boolean)
	 *ASSERTION:
     *********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if(inObj instanceof House)
        {
            House inHouse = (House)inObj;
            isEqual = name.equals(inHouse.getName()) && 
				years == inHouse.getYears() &&
					bannermen == inHouse.getBannermen() &&
						castle.equals(inHouse.getCastle());			
        }
	    return isEqual;
    }
	
	public House clone()
    {
        House cloneHouse;

        cloneHouse = new House(this.name, this.years, this.bannermen, 
                                         this.castle);

        return cloneHouse;
    }


    public String toString()
    {
        return ("The House of " + name + "has existed for " + years 
				+ " years. This house has " + bannermen + " Bannerman and "
                + "a castle named: " + castle + ". ");
    }

    //PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateYears
	 *IMPORT: inYears (Integer)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of years must be between 1 and 10,000 (inclusive)
    ************************************************************************/
    private boolean validateYears(int inYears)
    {
        return ((inYears >= minyears) && (inYears <= maxyears));
    }

    /*************************************************************************
     *SUBMODULE: validateBannermen 
	 *IMPORT: inBannermen (Integer)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of bannermen must be between 25 and 80,000 (inclusive). 
    ************************************************************************/
    private boolean validateBannermen(int inBannermen)
    {
        return ((inBannermen >= minbannermen) && (inBannermen <= maxbannermen));
    }


}
