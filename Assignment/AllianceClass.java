/****************************************************
 * FILE : AllianceClass.java
 * PURPOSE : Superclass used in 2019s2 OOPD assignment.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/
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
    *EXPORT: address of new Alliance object                                       
    *PURPOSE: initializes the object containing AllianceClass' classfields                                                                
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
    *EXPORT: address of new Alliance object
    *PURPOSE: Creates the AllianceClass object 
	* ASSERTION: Only creates an object if imports are valid, FAILS 
				otherwise                                                                
    ************************************************************/    

    public AllianceClass(String inName, int inYears, BannerClass inBanner)
    {
        setName(inName);
        setYears(inYears);
        setBanner(inBanner.clone());
    }
    
   /************************************************************
     *Copy Constructor:
	 *IMPORT: inAlliance(AllianceClass)
	 *EXPORT: address of new Alliance class object
	 *PURPOSE: Creates an object with an identical object state as the import.
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
	 *PURPOSE: Sets the name to inName 
	 *ASSERTION: Only sets the name to inName IF 
				 import is valid, otherwise, fails.
     ************************************************************/
    public void setName(String inName)
    {
		if(validateName(inName))
		{
			name = inName;
		}
		else
		{
			throw new IllegalArgumentException("Invalid name - must "
												+ "not be null");
		}
    }
    /********************************************************************
     *SUBMODULE: setYears
	 *IMPORT: inYears (Integer)
	 *EXPORT: none
	 *PURPOSE: Sets the year to inYears
	 *ASSERTION: Only sets year to inYears if imports are valid,
				 otherwise, fails.
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
	 *PURPOSE: Sets the banner name
	 *ASSERTION: sets the banner name only if imports are valid, else fails.
     *********************************************************************/
	public void setBanner(BannerClass inBanner)
    {   
        if(inBanner == null)
        {
            throw new IllegalArgumentException("Invalid banner");
        }
        
        banner = new BannerClass(inBanner);
        /* When passing arrays/objects, you pass the reference 
            of it (using a copy constructor or clone)*/

     }
    // ACCESSORS
    /********************************************************************
     *SUBMODULE: getName
	 *IMPORT: none
	 *EXPORT: name(String)
	 *PURPOSE: returns the classfield - name
     *********************************************************************/
    public String getName()
    {
	    return name;
    }
    /********************************************************************
     *SUBMODULE: getYears
	 *IMPORT: none
	 *EXPORT: years(Integer)
	 *PURPOSE: returns the classfield - years
     *********************************************************************/
      public int getYears()
    {
	    return years;
    }
	
	/********************************************************************
     *SUBMODULE: getBanner
	 *IMPORT: none
	 *EXPORT: banner(BannerClass)
	 *PURPOSE: returns the classfield - banner
     *********************************************************************/
    
    public BannerClass getBanner()
	{
		return new BannerClass(banner); 
	}
    
	 /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inObj(Object)
	 *EXPORT: isEqual(boolean)
	 *PURPOSE: Checks if each classfield is equal to a identical 
				constructed object's classfields
     *********************************************************************/
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
    
    // toString/toFileString overrides methods from House/Army classes    
        
    // The toString and toFileString calls the respective method (i.e. toString)
    // in the Banner class. */    
    
	 /********************************************************************
     *SUBMODULE: toString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a statement string containing specific classfields
     *********************************************************************/
	
    public String toString()
    {
        return("The Alliance of " + name + " has existed for " 
                + years + " years. " + banner.toString());
        

    }


	 /********************************************************************
     *SUBMODULE: toFileString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a specific statement string in CSV 
			  (comma-separated) format
     *********************************************************************/


    public String toFileString()
    {
        return(name + "," + years + "," + banner.toFileString()); 
    }  
    
       
    // abstract methods 
	/********************************************************************
     *SUBMODULES: ABSTRACT METHOD battleStrength
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: Abstract methods call the respective 
			   subclass method in House/Army's
     *********************************************************************/
    
    public abstract int battleStrength();

	/********************************************************************
     *SUBMODULES: ABSTRACT METHOD population
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: Abstract methods call the respective
			   subclass method in House/Army's
     *********************************************************************/

    public abstract String population();
	
	/********************************************************************
     *SUBMODULES: ABSTRACT METHOD clone
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: Abstract methods call the respective 
			   subclass method in House/Army's
     *********************************************************************/
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
	*EXPORT: A boolean - true or false
	*ASSERTION: Number of years must be between 1 and 10,000 (inclusive)
    ************************************************************************/
    private boolean validateYears(int inYears)
    {
        return ((inYears >= MINYEARS) && (inYears <= MAXYEARS));
    }

}
    
