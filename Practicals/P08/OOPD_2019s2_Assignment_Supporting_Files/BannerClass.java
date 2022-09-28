public class BannerClass
{
    //Class constants.
    public static final string sigil1 = "WOLF";
	public static final string sigil2 = "TOTEM";
	public static final string sigil3 = "LION";
	public static final string sigil4 = "DRAGON";
	
    //private class fields
    private String sigil, bannerColor, sigilColor;
    
    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new ArmyClass object
     *ASSERTION:
     ************************************************************/
	public BannerClass()
    {
        sigil = new String("WOLF");
		bannerColor = new String("FFFF");
		sigilColor = new String("FFFF");
		BannerClass bannerObj = new BannerClass(sigil, bannerColor, sigilColor)
	}

    /************************************************************
     *Alternate Constructor:
	 *IMPORT: inSigil(String), inBannerColor(String), inSigilColor(String)
	 *EXPORT: address of new BannerClass object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public BannerClass(String inSigil, String inBannerColor, String inSigilColor)
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
		valid = true;
		try 
		{
			Integer.parseInt(inSigil);
		}
		catch(NumberFormatException ex)
		{
			valid = false;
		}
    }
    /********************************************************************
     *SUBMODULE: setBannerColor
	 *IMPORT: inBannerColor (String)
	 *EXPORT: none
	 *ASSERTION: Sets the banner color to inBannerColor if imports are valid, otherwise, fails.
     *********************************************************************/
    public void setBannerColor(String bannerColor)
    {
	    if(validateBannerColor(inBannerColor))
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
    public void setSigilColor(String sigilColor)
    {
	    if(validateSigilColor(inSigilColor))
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

    public double getSigilColor()
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
            isEqual = name.equals(inBannerClass.getName()) && 
				sigil == inBannerClass.getSigil() &&
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
    private boolean validateSigil(String  inSigil)
    {
	if(inSigil.equals(sigil1) || inSigil.equals(sigil2) || inSigil.equals(sigil3) || inSigil.equals(sigil4))
	{
		return(inSigil)
    }
	

    /*************************************************************************
     *SUBMODULE: validateBannerColor
	 *IMPORT: inBannerColor (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid banner color.
    ************************************************************************/
    private boolean validateBannerColor(String inBannerColor)
    {
        if (inBannerColor.length() == 6)
		{
			Integer.parseInt(inBannerColor,16) // Converts into integer 
    }

    /*************************************************************************
     *SUBMODULE: validateSigilColor
	 *IMPORT: inSigilColor (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid sigil color.
    ************************************************************************/
    private boolean validateSigilColor(String  inSigilColor)
    {
        if (inSigilColor.length() == 6)
		{
			Integer.parseInt(inSigilColor,16) // Converts into integer
    }
}


