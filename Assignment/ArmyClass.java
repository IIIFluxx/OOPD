import java.util.*;

/****************************************************
 * FILE : ArmyClass.java
 * PURPOSE : Subclass used in 2019s2 OOPD assignment.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/
public class ArmyClass extends AllianceClass
{
    //Class constants.
	public static final double MINFOOTMEN = 3.5;
	public static final double MAXFOOTMEN = 160.5;
	public static final double MINARCHERS = 1.5;
	public static final double MAXARCHERS = 112.5;
    public static final double TOL = 0.0001;
	public static final double ARCHERS_POP_MULTIPLIER = 450.0;
	public static final double FOOTMEN_POP_MULTIPLIER = 120.0;
	public static final double ARCHERS_BS_MULTIPLIER = 50.0;
	public static final double FOOTMEN_BS_MULTIPLIER = 14.0;
	
	
    //private class fields
    private String history;
	private double footmen, archers;
    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new ArmyClass object
     *PURPOSE: initializes the object containing ArmyClass' classfields  
     ************************************************************/
	public ArmyClass()
    {
        footmen = 4.5;
		archers = 2.5;
		history = "";
	}

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inName(String), inYears(Integer), inBanner(BannerClass), 
			  inFootmen(Double), inArchers(Double), inHistory(String)
	 *EXPORT: address of new ArmyClass object
	 *PURPOSE: Creates the object
	 *ASSERTION: Creates an object only if 
				 the imports are valid and FAILS otherwise
     ************************************************************/
    public ArmyClass(String inName, int inYears, BannerClass inBanner,
					double inFootmen, double inArchers, String inHistory)
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
	 *ASSERTION: Creates an object with an identical object state as the import
     ************************************************************/
    public ArmyClass (ArmyClass inArmyClass)
    {   
        super(inArmyClass);
		footmen = inArmyClass.getFootmen();
		archers = inArmyClass.getArchers();
		history = inArmyClass.getHistory();
    }

    //MUTATORS
      /********************************************************************
     *SUBMODULE: setFootmen
	 *IMPORT: inFootmen(Double)
	 *EXPORT: none
	 *ASSERTION: Sets the number of groups of bannermen if 
				 imports are valid, otherwise fails.
     *********************************************************************/
    public void setFootmen(double inFootmen)
    {
	    if(validateFootmen(inFootmen))
        {
		    
			footmen = inFootmen; // *100, truncate int,truncate double, /100
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
	 *ASSERTION: Sets the number of squads of archers if 
				imports are valid, otherwise fails.
     *********************************************************************/
    public void setArchers(double inArchers)
    {
	    if(validateArchers(inArchers))
        {
		    archers = inArchers;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid number of squads "
												+ "of archers");
        }
    }

    /********************************************************************
     *SUBMODULE: setHistory
	 *IMPORT: inHistory (String)
	 *EXPORT: none
	 *ASSERTION: sets the history description if imports are valid, else fails.
     *********************************************************************/
    public void setHistory(String inHistory)
    {
        if(validateHistory(inHistory))
        {
            history = inHistory;
        }
        else
        {
            throw new IllegalArgumentException("Invalid history description "
												+"- must not be null");
        }
    }

       //ACCESSORS
    /********************************************************************
     *SUBMODULE: getFootmen
	 *IMPORT: none
	 *EXPORT: footmen(double)
	 *ASSERTION: returns the classfield - footmen
     *********************************************************************/	   
	 
    public double getFootmen()
    {
	    return footmen;
    }

    /********************************************************************
     *SUBMODULE: getArchers
	 *IMPORT: none
	 *EXPORT: archers(double)
	 *ASSERTION: returns the classfield - archers
     *********************************************************************/


    public double getArchers()
    {
	    return archers;
    }

    /********************************************************************
     *SUBMODULE: getHistory
	 *IMPORT: none
	 *EXPORT: history(String)
	 *ASSERTION: returns the classfield - history
     *********************************************************************/
	
    public String getHistory()
    {
	    return history;
    }
    
    
    
	 /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inObj(Object)
	 *EXPORT: isEqual(boolean)
	 *ASSERTION: Checks if each classfield is equal to a identical 
				constructed object's classfields
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

	 /********************************************************************
     *SUBMODULE: clone
	 *IMPORT: none
	 *EXPORT: new ArmyClass object 
	 *ASSERTION: Creates an ArmyClass object of data-type AllianceClass,
				 that is a copy of the current ArmyClass object
     *********************************************************************/
	
	public AllianceClass clone()
    {
        return new ArmyClass(this);
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
		footmen = (Math.round(footmen*100.0)/100.0);
		archers = (Math.round(archers*100.0)/100.0);
		
		return (super.toString() + "\n This Army has " + footmen 
				+ " groups of footmen and " + archers 
				+ " squads of archers at its ready." 
				+ "\n The history of this Army is that " + history + ". ");
    }
	
	 /********************************************************************
     *SUBMODULE: toFileString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a specific statement string in CSV (comma-separated)
				 format
     *********************************************************************/
	
	@Override	
	public String toFileString()
	{
		return("A," + super.toFileString() + "," + footmen + "," + archers 
				+ "," + history + ". \n");
	}
	
	
	/********************************************************************
     *SUBMODULE: population
	 *IMPORT: none
	 *EXPORT: return string
	 *PURPOSE: returns a specific statement string containing 
				 an Army's population
     *********************************************************************/
	
	@Override
	public String population()
    {
		int population = 0;
		double sum = (archers * ARCHERS_POP_MULTIPLIER
					  + footmen * FOOTMEN_POP_MULTIPLIER);
        population = (int)sum;
		return ("The Army of " + super.getName() + " consists of " 
				+ population + " people.  \n ");
    }

	/********************************************************************
     *SUBMODULE: battleStrength
	 *IMPORT: none
	 *EXPORT: strength(Integer)
	 *PURPOSE: returns an integer containing an Army's Battle Strength
     *********************************************************************/    

    public int battleStrength()
    {
        int strength = 0;
        strength =(int)((footmen * FOOTMEN_BS_MULTIPLIER) 
						+ (archers *ARCHERS_BS_MULTIPLIER));
        return strength;
    }
	
    //PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateHistory
	 *IMPORT: inHistory (String)
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
	 *EXPORT: A boolean - true or false
	 *ASSERTION: Number of groups of footmen must be between 
				 3.5 and 160.5 (inclusive).
    ************************************************************************/
    private boolean validateFootmen(double inFootmen)
    {
        return ((inFootmen>= MINFOOTMEN) && (inFootmen <= MAXFOOTMEN));
    }
    /*************************************************************************
     *SUBMODULE: validateArchers 
	 *IMPORT: inArchers (Double)
	 *EXPORT: A boolean - true or false
	 *ASSERTION: Number of squads of archers must be between 1.5 
				 and 112.5 (inclusive). 
    ************************************************************************/
    private boolean validateArchers(double inArchers)
    {
        return ((inArchers>= MINARCHERS) && (inArchers <= MAXARCHERS));
    }
    
}
