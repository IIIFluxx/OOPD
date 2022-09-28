public abstract class AllianceClass implements Combatable 
{
    // Class constants
    public static final int MINYEARS = 1;
    public static final int MAXYEARS = 10000;
       
    // private class fields
    private String name;
    private int years;
    private BannerClass banner;

/************************************************************               
    *Default Constructor:                                                          
    *IMPORT: none                                                              
    *EXPORT: address of new House object                                       
    *ASSERTION:                                                                
 ************************************************************/    

    public AllianceClass()
    {
        name = new String("Archer");
        years = 2;
        banner = new BannerClass();
    }

    /************************************************************               
    * Alternate Constructor:                                                       
    *IMPORT: inName(String), inYears(Integer), inBanner(BannerClass)
    *EXPORT: address of new House object
    *ASSERTION:                                                                
    ************************************************************/    

    public AllianceClass(String inName, int inYears, BannerClass inBanner)
    {
        setName(inName);
        setYears(inYears);
        setBanner(inBanner);
    }
    
   /************************************************************
     *Copy Constructor:
	 *IMPORT: inAlliance(AllianceClass)
	 *EXPORT: address of new Alliance class object
	 *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
    public AllianceClass(AllianceClass inAlliance)
    {
        name = inAlliance.getName();
        years = inAlliance.getYears();
        banner = inAlliance.getBanner();
    }
    
    // MUTATORS
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
     *SUBMODULE: setBanner
	 *IMPORT: inCastle (String)
	 *EXPORT: none
	 *ASSERTION: sets the castle name.
     *********************************************************************/
	public void setBanner(BannerClass inBanner)
    {   
        if(inBanner == null)
        {
            throw new IllegalArgumentException("Invalid banner");
        }
        
        banner = new BannerClass(inBanner);
        /* When passing arrays/objects, you pass the reference 
            of it (use copy constructor or clone)*/

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
    
    public BannerClass getBanner()
	{
		return new BannerClass(banner); 
	}
    
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if(inObj instanceof AllianceClass)
        {
            AllianceClass inAlliance = (AllianceClass)inObj;
            if(name.equals(inAlliance.getName()))
            {
                if(years == inAlliance.getYears())
                {
                    if(banner.equals(inAlliance.getBanner()))
                    {
                        isEqual = true;
                    }
                }
            }  
        }
        return isEqual;
    }
    
    // Override methods from House/Army classes    
        
    /* The toString and toFileString calls the respective method (i.e. toString)
        in the Banner class. */    
    
    public String toString()
    {
        return("The Alliance of " + name + " has existed for " + years + "years. "
                + banner.toString());
        

    }

    public String toFileString()
    {
        return(name + "," + years + "," + banner.toFileString()); 
    }  
    
       
    // abstract methods 
    
    public abstract int battleStrength();

    public abstract String population();

    public abstract AllianceClass clone();

    // PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateName
	 *IMPORT: inName (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Name must be non-empty (not null)
    ************************************************************************/
	private boolean validateName(String inString)
	{
		boolean test = false;
		if (inString != null)
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
        return ((inYears >= MINYEARS) && (inYears <= MAXYEARS));
    }

}
    
