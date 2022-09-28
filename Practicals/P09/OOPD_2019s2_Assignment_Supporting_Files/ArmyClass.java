public class ArmyClass
{
    //Class constants.
    public static final int minyears = 1;
	public static final int maxyears = 10000;
	public static final double minfootmen = 3.5;
	public static final double maxfootmen = 160.5;
	public static final double minarchers = 1.5;
	public static final double maxarchers = 112.5;
	
    //private class fields
    private String name, history;
    private int years;
	private double footmen, archers;
    private BannerClass banner;
    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new ArmyClass object
     *ASSERTION:
     ************************************************************/
	public ArmyClass()
    {
        name = new String("Archer");
        years = 2;
        footmen = 4.5;
		archers = 2.5;
		history = "";
        banner = new BannerClass();
	}

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inFootmen(Double), inArchers(Double), inHistory(String)
	 *EXPORT: address of new ArmyClass object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public ArmyClass(String inName, int inYears, double inFootmen, double inArchers, String inHistory, BannerClass inBanner)
    {
        setName(inName);
        setYears(inYears);
        setFootmen(inFootmen);
		setArchers(inArchers);
        setHistory(inHistory);
        setBanner(new BannerClass(inBanner));
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inArmyClass (ArmyClass)
	 *EXPORT: address of new ArmyClass class object
	 *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
    public ArmyClass (ArmyClass inArmyClass)
    {
	    name = inArmyClass.getName();
        years = inArmyClass.getYears();
		footmen = inArmyClass.getFootmen();
		archers = inArmyClass.getArchers();
		history = inArmyClass.getHistory();
        banner = new BannerClass(inArmyClass.getBanner());
        /* [inArmyClass.getBanner()] = BannerClass inBannerClas from
            BannerClass' copy constructor. */
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
        if (validateName(inName))
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
     *SUBMODULE: setFootmen
	 *IMPORT: inFootmen(Double)
	 *EXPORT: none
	 *ASSERTION: Sets the number of groups of bannermen if imports are valid, otherwise, fails.
     *********************************************************************/
    public void setFootmen(double inFootmen)
    {
	    if(validateFootmen(inFootmen))
        {
		    footmen = inFootmen;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid number of groups of footmen");
        }
    }

   /********************************************************************
     *SUBMODULE: setArchers
	 *IMPORT: inArchers(Double)
	 *EXPORT: none
	 *ASSERTION: Sets the number of squads of archers if imports are valid, otherwise, fails.
     *********************************************************************/
    public void setArchers(double inArchers)
    {
	    if(validateArchers(inArchers))
        {
		    archers = inArchers;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid number of squads of archers");
        }
    }

    /********************************************************************
     *SUBMODULE: setHistory
	 *IMPORT: inHistory (String)
	 *EXPORT: none
	 *ASSERTION: sets the history name.
     *********************************************************************/
    public void setHistory(String inHistory)
    {
        history = inHistory;
    }

    public void setBanner(BannerClass inBanner)
    {
        banner = inBanner;
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

    public double getFootmen()
    {
	    return footmen;
    }

    public double getArchers()
    {
	    return archers;
    }
    public String getHistory()
    {
	    return history;
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
        if(inObj instanceof ArmyClass)
        {
            ArmyClass inArmyClass = (ArmyClass)inObj;
            isEqual = name.equals(inArmyClass.getName()) && 
				years == inArmyClass.getYears() &&
					footmen == inArmyClass.getFootmen() &&
						archers == inArmyClass.getArchers() &&
							history.equals(inArmyClass.getHistory())&&
                                banner.equals(inArmyClass.getBanner());			
                            
        }
	    return isEqual;
    }
	
	public ArmyClass clone()
    {
        ArmyClass cloneArmyClass;

        cloneArmyClass = new ArmyClass(this.name, this.years, this.footmen, 
                                this.archers, this.history, this.banner);

        return cloneArmyClass;
    }


    public String toString()
    {		
		return ("The Army of " + name + " has existed for " + years 
				+ " year(s). Its " + banner.getBannerColor() + " Banner consists of a "
				+ banner.getSigilColor() + " Sigil in the shape of a " + banner.getSigil()
				+ ". " + "This Army has " + footmen + " groups of footmen and " + archers +
				" squads of archers at its ready." 	+ " The history of this Army is that "
				+ history + ". ");
    }
	
	
		
	public String toFileString()
	{
		return("A," + name + "," + years + "," + banner.getSigil() + "," 
				+ banner.getBannerColor() + "," + banner.getSigilColor() 
				+ "," + footmen + "," + archers + "," + history);
	}
	
	/*public String population()
    {
        String message1;
		message1 = "Not yet implemented";
		return message1;	
    }*/
		
	public String population()
    {
		int population = 0;
		double sum = (archers + 450.0 + footmen * 120.0);
		return ("The Army of " + name + " consists of " + population + " people.  \n ");
    }
    
    public int battleStrength()
    {
        int strength = 0;
        strength =(int)((footmen * 50.0) + (archers *14.0));
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
		return(inName != null);
	}
	
	/*************************************************************************
     *SUBMODULE: validateHistory
	 *IMPORT: inName (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Name must be non-empty (not null)
    ************************************************************************/
	private boolean validateHistory(String inHistory)
	{
		return(inHistory != null);
	}
	
	
    /*************************************************************************
     *SUBMODULE: validateYears
	 *IMPORT: inYears (Integer)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of years must be between 1 and 10,000 (inclusive)
    ************************************************************************/
    private boolean validateYears(int inYears)
    {
        return ((inYears >= 1) && (inYears <= 10000));
    }

    /*************************************************************************
     *SUBMODULE: validateFootmen 
	 *IMPORT: inFootmen (Double)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of groups of footmen must be between 3.5 and 160.5 (inclusive). 
    ************************************************************************/
    private boolean validateFootmen(double inFootmen)
    {
        return ((inFootmen>= minfootmen) && (inFootmen <= maxfootmen));
    }
    /*************************************************************************
     *SUBMODULE: validateArchers 
	 *IMPORT: inArchers (Double)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of squads of archers must be between 1.5 and 112.5 (inclusive). 
    ************************************************************************/
    private boolean validateArchers(double inArchers)
    {
        return ((inArchers>= minarchers) && (inArchers <= maxarchers));
    }
    
}
