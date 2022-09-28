public class House extends AllianceClass
{
    //Class constants.
	public static final int minbannermen = 25;
	public static final int maxbannermen = 80000;  

    //private class fields
    private String castle;
    private int bannermen;

    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new House object
     *ASSERTION:
     ************************************************************/
	public House()
    {
        super();
        bannermen = 2;
        castle = "";
    }

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inBannermen(Integer), inCastle(String)
	 *EXPORT: address of new House class object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public House(String inName, int inYears, BannerClass inBanner, int inBannermen, String inCastle)
    {
        super(inName, inYears, inBanner);
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
        super(inHouse);
		bannermen = inHouse.getBannermen();
		castle = inHouse.getCastle();
        
        //comment for exam <delete>: banner = inHouse.getBanner(); 
        //  new BannerClass(inHouse.getBanner());
		/* [inHouse.getBanner()] = BannerClass inBannerClass from 
            Banner class' copy constructor. */ 
    }
    //MUTATORS
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


    //ACCESSORS
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
	
	public AllianceClass clone() 
    {

        /* Old line 1
        
        House cloneHouse;
        cloneHouse = new House(this.name, this.years, this.bannermen, this.castle, this.banner);
        ///
        Old line 2: cloneHouse = new House(super.getName(), super.getYears(), super.getBanner(), this.bannermen, this.castle);
        return cloneHouse;
        //*/
        return new House(this);
    }

    @Override
    public String toString()
    {
        return (super.toString() + ". This house has " + bannermen 
                + " Bannerman and " + "a castle named: " + castle + ". ");
    }
    
	@Override
	public String toFileString()
	{
		return("H," + super.toFileString() + "," + bannermen + "," + castle 
                + ". \n");		
	}

    @Override
	public String population()
    {
		int population = 0;
		population = bannermen + 450;
		return ("The House of " + super.getName() + " has a population of " + population + ". \n");
    }
    
    // Automatically overrides battleStrength()
    
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
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of bannermen must be between 25 and 80,000 (inclusive). 
    ************************************************************************/
    private boolean validateBannermen(int inBannermen)
    {
        return ((inBannermen >= minbannermen) && (inBannermen <= maxbannermen));
    }
}

