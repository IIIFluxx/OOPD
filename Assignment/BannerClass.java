/****************************************************
 * FILE : BannerClass.java
 * PURPOSE : Subclass used in 2019s2 OOPD assignment.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/
 
public class BannerClass
{
    //Class constants.
    public static final String SIGIL1 = "WOLF";
	public static final String SIGIL2 = "TOTEM";
	public static final String SIGIL3 = "LION";
	public static final String SIGIL4 = "DRAGON";
	
    //private class fields
    private String sigil;
    private String bannerColor;
    private String sigilColor;

    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new BannerClass object
     *PURPOSE: initializes the object containing BannerClass' classfields  
     ************************************************************/
	public BannerClass()
    {
        sigil = new String("WOLF");
		bannerColor = "000000";
		sigilColor = "000000";
		BannerClass bannerObj = new BannerClass(sigil, bannerColor, sigilColor);
	}

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inSigil(String), inBannerColor(String), inSigilColor(String)
	 *EXPORT: address of new BannerClass object
	 *PURPOSE: Creates the Banner object 
	 *ASSERTION: Creates the object only if the imports are valid,
				 FAILS otherwise.
     ************************************************************/
    public BannerClass(String inSigil, String inBannerColor, 
                        String inSigilColor)
    {
        setSigil(inSigil);
        setBannerColor(inBannerColor);
        setSigilColor(inSigilColor);
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inBannerClass (BannerClass)
	 *EXPORT: address of new BannerClass object
	 *PURPOSE: Creates an object with an identical object state as the import.
     ************************************************************/
    public BannerClass (BannerClass inBannerClass)
    {
	    sigil = inBannerClass.getSigil();
        bannerColor = inBannerClass.getBannerColor();
		sigilColor = inBannerClass.getSigilColor();
		
    }

    //MUTATORS
    /************************************************************
     *SUBMODULE: setSigil
	 *IMPORT: inSigil(String)
	 *EXPORT: none
	 *ASSERTION: Sets sigil to inSigil if imports are valid, otherwise, fails.
     ************************************************************/
    public void setSigil(String inSigil)
    {
		boolean valid = true;
		if(validateSigil(inSigil))
		{
			sigil = inSigil;
		}
		else
		{
			throw new IllegalArgumentException("Invalid sigil name.");
		}
    }
    /********************************************************************
     *SUBMODULE: setBannerColor
	 *IMPORT: inBannerColor (String)
	 *EXPORT: none
	 *ASSERTION: Sets the banner color to inBannerColor if imports are valid,
				 otherwise, fails.
     *********************************************************************/
    public void setBannerColor(String inBannerColor)
    {
	    if(validateColor(inBannerColor))
        {
		    bannerColor = inBannerColor;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid banner color.");
        }
    }

    /********************************************************************
     *SUBMODULE: setSigilColor
	 *IMPORT: inSigilColor (String)
	 *EXPORT: none
	 *ASSERTION: Sets the banner color to inSigilColor if imports are valid,
				 otherwise, fails.
     *********************************************************************/
    public void setSigilColor(String inSigilColor)
    {
	    if(validateColor(inSigilColor))
        {
		    sigilColor = inSigilColor;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid sigil color.");
        }
    }

    //ACCESSORS - RETURN A COPY

    /********************************************************************
     *SUBMODULE: getSigil
	 *IMPORT: none
	 *EXPORT: sigil(String)
	 *ASSERTION: returns the classfield - sigil
     *********************************************************************/

    public String getSigil()
    {
	    return sigil;
    }

    /********************************************************************
     *SUBMODULE: getBannerColor
	 *IMPORT: none
	 *EXPORT: bannerColor(String)
	 *ASSERTION: returns the classfield - bannerColor
     *********************************************************************/

    public String getBannerColor()
    {
	    return bannerColor;
    }

    /********************************************************************
     *SUBMODULE: getSigilColor
	 *IMPORT: none
	 *EXPORT: sigilColor(String)
	 *ASSERTION: returns the classfield - sigilColor
     *********************************************************************/

    public String getSigilColor()
    {
	    return sigilColor;
    }

	 /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inObj(Object)
	 *EXPORT: isEqual(boolean)
	 *ASSERTION: Checks if each classfield is equal to a identical 
				constructed object's classfields
     *********************************************************************/
	 
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if(inObj instanceof BannerClass)
        {
            BannerClass inBannerClass = (BannerClass)inObj;
            if(sigil.equals(inBannerClass.getSigil()))
            {
                if(bannerColor.equals(inBannerClass.getBannerColor()))
                {
                    if(sigilColor.equals(inBannerClass.getSigilColor()))
                    {
                        isEqual = true;
                    }
	            }
            }
        }
        return isEqual;
    }
	
	/********************************************************************
     *SUBMODULE: clone
	 *IMPORT: none
	 *EXPORT: new BannerClass object 
	 *ASSERTION: Creates an BannerClass object that is a copy of the current
				 BannerClass object
     *********************************************************************/
	
	public BannerClass clone()
    {
        BannerClass cloneBannerClass;

        cloneBannerClass = new BannerClass(this.sigil, 
                                            this.bannerColor, this.sigilColor);
        return cloneBannerClass;
    }

	 /********************************************************************
     *SUBMODULE: toString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a statement string containing specific classfields
     *********************************************************************/

    public String toString()
    {		
		return ("\n The " + bannerColor + " banner consists of a " + sigilColor 
				+ " sigil in the shape of a " + sigil + ". ");
    }

	 /********************************************************************
     *SUBMODULE: toFileString
	 *IMPORT: none
	 *EXPORT: none
	 *PURPOSE: returns a specific statement string 
                in CSV (comma-separated) format
     *********************************************************************/ 
	 
    public String toFileString()
    {
        return(sigil + "," + bannerColor + "," + sigilColor);
    }
	
	
    //PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateSigil
	 *IMPORT: inSigil (String)
	 *EXPORT: equality (boolean)
	 *ASSERTION: Must be valid sigil name (i.e. TOTEM, LION, DRAGON or WOLF).
    ************************************************************************/
    private boolean validateSigil(String inSigil)
    {
		boolean equality = false;
		if(inSigil.equals(SIGIL1) || inSigil.equals(SIGIL2) 
            || inSigil.equals(SIGIL3) || inSigil.equals(SIGIL4))
		{	
			equality = true;
		}
		return equality;
	}
	

    /*************************************************************************
     *SUBMODULE: validateColor
	 *IMPORT: inColor (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid color -- i.e. string length of 6 and hexadecimal.
    ************************************************************************/
    private boolean validateColor(String inColor)
    {
        boolean valid = false;
		int num;
        if (inColor.length() == 6)
        {
            try
            {
                num = Integer.parseInt(inColor,16);
                valid = true;
            }
            catch(NumberFormatException e)
            {}
        }
        return valid;
	}

}


