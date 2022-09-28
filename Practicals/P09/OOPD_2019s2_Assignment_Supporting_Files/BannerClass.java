public class BannerClass
{
    //Class constants.
    public static final String sigil1 = "WOLF";
	public static final String sigil2 = "TOTEM";
	public static final String sigil3 = "LION";
	public static final String sigil4 = "DRAGON";
	
    //private class fields
    private String sigil;
	private int bannerColor, sigilColor;

    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new ArmyClass object
     *ASSERTION:
     ************************************************************/
	public BannerClass()
    {
        sigil = new String("WOLF");
		bannerColor = 0;
		sigilColor = 0;
		BannerClass bannerObj = new BannerClass(sigil, bannerColor, sigilColor);
	}

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inSigil(String), inBannerColor(String), inSigilColor(String)
	 *EXPORT: address of new BannerClass object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public BannerClass(String inSigil, int inBannerColor, int inSigilColor)
    {
        setSigil(inSigil);
        setBannerColor(inBannerColor);
        setSigilColor(inSigilColor);
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inBannerClass (BannerClass)
	 *EXPORT: address of new BannerClass object
	 *ASSERTION: Creates an object with an identical object state as the import.
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
	 *ASSERTION: Sets the name to inSigil if imports are valid, otherwise, fails.
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
	 *ASSERTION: Sets the banner color to inBannerColor if imports are valid, otherwise, fails.
     *********************************************************************/
    public void setBannerColor(int inBannerColor)
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
	 *ASSERTION: Sets the banner color to inSigilColor if imports are valid, otherwise, fails.
     *********************************************************************/
    public void setSigilColor(int inSigilColor)
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

    //ACCESSORS
    public String getSigil()
    {
	    return sigil;
    }

    public int getBannerColor()
    {
	    return bannerColor;
    }

    public int getSigilColor()
    {
	    return sigilColor;
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
            BannerClass inBannerClass = (BannerClass)inObj;
            isEqual = sigil.equals(inBannerClass.getSigil()) &&	
					bannerColor == inBannerClass.getSigilColor() &&
						sigilColor == inBannerClass.getSigilColor();
        }
	    return isEqual;
    }
	
	public BannerClass clone()
    {
        BannerClass cloneBannerClass;

        cloneBannerClass = new BannerClass(this.sigil, this.bannerColor, this.sigilColor);
        return cloneBannerClass;
    }


    public String toString()
    {		
		return ("The " + bannerColor + " banner consists of a " + sigilColor + " sigil in the shape of a " + sigil + ". ");
    }

    //PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateSigil
	 *IMPORT: inSigil (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid banner color.
    ************************************************************************/
    private boolean validateSigil(String inSigil)
    {
		boolean equality = false;
		if(inSigil.equals(sigil1) || inSigil.equals(sigil2) || inSigil.equals(sigil3) || inSigil.equals(sigil4))
		{	
			equality = true;
		}
		return equality;
	}
	

    /*************************************************************************
     *SUBMODULE: validateColor
	 *IMPORT: inBannerColor (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid banner color.
    ************************************************************************/
    private boolean validateColor(int inColor)
    {
        boolean valid = false;
        if (inColor >= 0 && inColor <= 255)
		{
			valid = true;
		}
        return valid;
	}

}


