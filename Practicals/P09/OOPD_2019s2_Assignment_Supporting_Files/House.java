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
    private BannerClass banner;

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
        banner = new BannerClass();
		// super() ...
    }

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inBannermen(Integer), inCastle(String)
	 *EXPORT: address of new House class object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public House(String inName, int inYears, int inBannermen, String inCastle, BannerClass inBanner)
    {
        
        setName(inName);
        setYears(inYears);
        setBannermen(inBannermen);
        setCastle(inCastle);
        setBanner(inBanner);
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
        banner = inHouse.getBanner(); 
        // new BannerClass(inHouse.getBanner());
		/* [inHouse.getBanner()] = BannerClass inBannerClass from 
            Banner class' copy constructor. */ 
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
		if(validateName(inName))
		{
			name = inName;
		}
		else
		{
			throw new IllegalArgumentException("Invalid name - must not be null");
		}
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
        if (validateCastle(inCastle))
		{
			castle = inCastle;
		}
		else
		{
			throw new IllegalArgumentException("Invalid castle description - must not be null");
		}
    }

	 /********************************************************************
     *SUBMODULE: setBanner
	 *IMPORT: inCastle (String)
	 *EXPORT: none
	 *ASSERTION: sets the castle name.
     *********************************************************************/
	public void setBanner(BannerClass inBanner)
    {
		banner = inBanner; // check if null
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
	
	public BannerClass getBanner()
	{
		return banner; 
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
						castle.equals(inHouse.getCastle()) &&
							banner.equals(inHouse.getBanner()); 
							
        }
	    return isEqual;
    }
	
	public House clone()
    {
        House cloneHouse;

        cloneHouse = new House(this.name, this.years, this.bannermen, 
                                         this.castle, this.banner);
        return cloneHouse;
		// Will need one in Alliance
    }


    public String toString()
    {
        return ("The House of " + name + " has existed for " + years 
				+ " years. its " + banner.getBannerColor() + " Banner consists of a " 
				+ banner.getSigilColor() + " Sigil in the shape of a " + banner.getSigil()
				+ ". "  + " This house has " + bannermen + " Bannerman and "
                + "a castle named: " + castle + ". ");
    }
	
	public String toFileString()
	{
		return("H," + name + "," + years + "," + banner.getSigil() + ","
				+ banner.getBannerColor() + "," + banner.getSigilColor()
				+ "," + bannermen + "," + castle);		
	}

	public String population()
    {
		int population = 0;
		population = bannermen + 450;
		return ("The House of " + name + " has a population of " + population + ". \n");
    }
    
    public int battleStrength()
    {
        int strength = 0;
		if(castle.equals(""))
        {
            strength = bannermen * 2;
        }
        if(!(castle.equals("")))
        {
            strength = (int)(bannermen * 2 + 2000);
        }
        return strength;
    }

    //PRIVATE SUBMODULES:
	/*************************************************************************
     *SUBMODULE: validateName
	 *IMPORT: inName (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Name must be non-empty (not null)
    ************************************************************************/
	private boolean validateName(String inName)
	{
		boolean test = false;
		if (inName != null)
		{
			test = true;
		}
		return test;
	}
	
	/*************************************************************************
     *SUBMODULE: validateCastle
	 *IMPORT: inName (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Name must be non-empty (not null)
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

