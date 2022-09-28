public class ArmyClass extends AllianceClass
{
    //Class constants.
	public static final double MINFOOTMEN = 3.5;
	public static final double MAXFOOTMEN = 160.5;
	public static final double MINARCHERS = 1.5;
	public static final double MAXARCHERS = 112.5;
    public static final double TOL = 0.0001;
	
    //private class fields
    private String history;
	private double footmen, archers;
    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new ArmyClass object
     *ASSERTION:
     ************************************************************/
	public ArmyClass()
    {
        footmen = 4.5;
		archers = 2.5;
		history = "";
	}

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inFootmen(Double), inArchers(Double), inHistory(String)
	 *EXPORT: address of new ArmyClass object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public ArmyClass(String inName, int inYears, BannerClass inBanner, double inFootmen, double inArchers, String inHistory)
    {
        super(inName, inYears, inBanner);
        setFootmen(inFootmen);
		setArchers(inArchers);
        setHistory(inHistory);
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inArmyClass (ArmyClass)
	 *EXPORT: address of new ArmyClass class object
	 *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
    public ArmyClass (ArmyClass inArmyClass)
    {   
        super(inArmyClass);
		footmen = inArmyClass.getFootmen();
		archers = inArmyClass.getArchers();
		history = inArmyClass.getHistory();
        /* comment for exam <delete>: 
            [inArmyClass.getBanner()] = BannerClass inBannerClas from
            BannerClass' copy constructor. */
    }

    //MUTATORS
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
		    footmen = inFootmen; // 2 decimal point HERE ------------
	    }
        else
        {
            throw new IllegalArgumentException("Invalid number of footmen");
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
        if(validateHistory(inHistory))
        {
            history = inHistory;
        }
        else
        {
            throw new IllegalArgumentException("Invalid history description - must not be null");
        }
    }

       //ACCESSORS
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
        if(inObj instanceof ArmyClass)
        {
            ArmyClass inArmyClass = (ArmyClass)inObj;

			if(super.equals(inArmyClass))
			{   
				if(Math.abs(footmen - inArmyClass.getFootmen()) < TOL)
				{
					if(Math.abs(archers - inArmyClass.getArchers()) < TOL)
					{
                        if(history.equals(inArmyClass.getHistory()))
                        {
                            isEqual = true;
                        }
                    }
                }
			}
        }
	    return isEqual;
    }
	
	public AllianceClass clone()
    {

        /* Old line 1:
        ArmyClass cloneArmyClass;
        cloneArmyClass = new ArmyClass(this.name, this.years, this.footmen, 
                                this.archers, this.history, this.banner); */

        return new ArmyClass(this);
    }

    @Override
    public String toString()
    {		
		return (super.toString() + "This Army has " + footmen + " groups of footmen and " + archers + " squads of archers at its ready." 
		+ " The history of this Army is that " + history + ". ");
    }
	
	
	@Override	
	public String toFileString()
	{
		return("A," + super.toFileString() + "," + footmen + "," + archers + "," + history                + ". \n");
	}
	@Override
	public String population()
    {
		int population = 0;
		double sum = (archers + 450.0 + footmen * 120.0);
        population = (int)sum;
		return ("The Army of " + super.getName() + " consists of " + population + " people.  \n ");
    }
    
    // Do we need an override?
    public int battleStrength()
    {
        int strength = 0;
        strength =(int)((footmen * 50.0) + (archers *14.0));
        return strength;
    }
	
    //PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateHistory
	 *IMPORT: inName (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: History description must be non-empty (not null)
    ************************************************************************/
	private boolean validateHistory(String inHistory)
	{
        boolean test = false;
        if(inHistory != null)
        {
            test = true;
        }
        return test;
	}
	
	
    /*************************************************************************
     *SUBMODULE: validateFootmen 
	 *IMPORT: inFootmen (Double)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of groups of footmen must be between 3.5 and 160.5 (inclusive). 
    ************************************************************************/
    private boolean validateFootmen(double inFootmen)
    {
        return ((inFootmen>= MINFOOTMEN) && (inFootmen <= MAXFOOTMEN));
    }
    /*************************************************************************
     *SUBMODULE: validateArchers 
	 *IMPORT: inArchers (Double)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Number of squads of archers must be between 1.5 and 112.5 (inclusive). 
    ************************************************************************/
    private boolean validateArchers(double inArchers)
    {
        return ((inArchers>= MINARCHERS) && (inArchers <= MAXARCHERS));
    }
    
}
