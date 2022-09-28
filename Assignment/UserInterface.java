import java.util.*;

/****************************************************
 * FILE : UserInterface.java
 * PURPOSE : Handles all interactions with User.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/

public class UserInterface
{
	// No class constants or classfields & ALL methods MUST be static
	
	 /********************************************************************
     *SUBMODULE: getObject
	 *IMPORT: none
	 *EXPORT: userAlliance(Integer)
	 *PURPOSE: Obtains what type of Alliance the user wishes to make.
     *********************************************************************/
	
	public static int getObject()
	{
		int userAlliance = 0;
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter 1 (one) for House, 2 (two) for Army "
                            + "for the type of Alliance you wish to make. ");
		userAlliance = sc.nextInt();
		return userAlliance;
	}
	
	/********************************************************************
     *SUBMODULE: getHouseObject
	 *IMPORT: none
	 *EXPORT: New object containing House classfields, 
			  of data-type AllianceClass 
	 *ASSERTION: Makes a new object only IF inputs are valid
     *********************************************************************/

	 
	public static AllianceClass getHouseObject()
	{
		Scanner sc = new Scanner(System.in);
		String name = "";
        String castle = "";
		int years = 0;
        int bannermen = 0;
		boolean test = false;
		BannerClass banner;
		do
		{
            try
            {   
                System.out.println("Please input the name of your House: ");
                name = sc.nextLine();
                test = validateString(name);
            }
            catch(IllegalArgumentException e) 
            {
                
                sc.nextLine();
                showError(e.getMessage());
		    }
        } while(!test);
		
	    test = false;
		
        do
		{
			try
            {
                System.out.println("Please input the number of years: ");
			    years = sc.nextInt();
			    test = validateYears(years);
                
		    }
        
            catch(InputMismatchException e)
            {
                sc.nextLine();
                showError("Invalid type. Input must be of an integer type.");
            }
        
            catch(IllegalArgumentException e)
            {
                sc.nextLine();
                showError(e.getMessage());
            }
        
        } while(!test);
		
	    test = false;
		
		do
		{
			try
            {
                System.out.println("Please input the number of bannermen: ");
                bannermen = sc.nextInt();
                test = validateBannermen(bannermen);
		    }
            catch(InputMismatchException e)
            {   
                
                sc.nextLine();
                showError("Invalid type. Input must be of an integer type.");
            }

            catch(IllegalArgumentException e)
            {
                
                sc.nextLine();
                showError(e.getMessage());
            }

        } while(!test);
		
	    test = false;
		
		do
		{
			try
            {
                System.out.println("Please input the name of your Castle: ");
                castle = sc.nextLine(); 
                test = validateString(castle);
		    }
            catch(IllegalArgumentException e) 
            {   
                sc.nextLine();
                showError(e.getMessage());
            }
        } while (!test);
        
	    test = false;
		
        // PASS IN BANNER OBJECT FROM CREATE BANNER SUBMODULE
        banner = getBannerObject();
        AllianceClass newObj = new House(name, years, banner,
										 bannermen, castle);
		return newObj;
	}

	/********************************************************************
     *SUBMODULE: getArmyObject
	 *IMPORT: none
	 *EXPORT: New object containing ArmyClass classfields,
			  of data-type AllianceClass
	 *ASSERTION: Makes a new object only IF inputs are valid
     *********************************************************************/
	
	public static AllianceClass getArmyObject()
	{
		Scanner sc = new Scanner(System.in);
		String name = "";
        String history = "";
		int years = 0;
		double archers = 0;
        double footmen = 0;
		boolean test = false;
        BannerClass banner;
		do
		{
			try
            {
                System.out.println("Please input the name of your Army: ");
			    name = sc.nextLine();
			    test = validateString(name);
            }
            catch(IllegalArgumentException e)
            {
                sc.nextLine();
                showError(e.getMessage());
            }
		} while(!test);
		
	    test = false;
		
		do
		{
			try
            {
                System.out.println("Please input the number of years: ");
                years = sc.nextInt();
                test = validateYears(years);
            }
            catch(InputMismatchException e)
            {
                sc.nextLine();
                showError("Invalid type. Input must be of an integer type.");
            }
            catch(IllegalArgumentException e)
            {
                sc.nextLine();
                showError(e.getMessage());
            }
		} while(!test);
		
	    test = false;
		
		do
		{
			try
            {
                System.out.println("Please input the number of footmen: ");
                footmen = sc.nextDouble();
                test = validateFootmen(footmen);
            }
            catch(InputMismatchException e)
            {
                showError("Invalid type. Input must be of a double type.");
            }
            catch(IllegalArgumentException e)
            {
                showError(e.getMessage());
            }
		} while(!test);
		
	    test = false;
		
		do
		{
            try
            {
                System.out.println("Please input the number of " 
									+ "squads of archers: ");
                archers = sc.nextDouble();
                test = validateArchers(archers);
		    }
            catch(InputMismatchException e)
            {
                sc.nextLine();
                showError("Invalid type. Input must be of a double type");
            }
            catch(IllegalArgumentException e)
            {
                sc.nextLine();
                showError(e.getMessage());
            }
        } while(!test);
		
	    test = false;
		
		do
		{
            try
            {
            	System.out.println("Please input the details of " 
									+ "your history: ");
			    history = sc.nextLine();
			    test = validateString(history);
            }
           catch(IllegalArgumentException e)
            {
                sc.nextLine();
                showError(e.getMessage());
            }

		} while(!test);
        
        
	    test = false;
		
        // PASS IN BANNER OBJECT FROM CREATE BANNER SUBMODULE  
        banner = getBannerObject();
		
        AllianceClass newObj = new ArmyClass(name, years,banner,
									footmen, archers, history);
		return newObj;
	}
	
	/********************************************************************
     *SUBMODULE: getBannerObject
	 *IMPORT: none
	 *EXPORT: New BannerClass object
	 *ASSERTION: Makes a new BannerClass object only IF inputs are valid
     *********************************************************************/

    public static BannerClass getBannerObject()
    {
        String sigil = "";
        String sigilColor = "";
        String bannerColor = "";
        Scanner sc = new Scanner(System.in);
        boolean test = false;
        do
        {
            try
            {
                System.out.println("Please input the name of the sigil: "
								   + "\nWOLF, TOTEM, LION or DRAGON ");
                sigil = sc.nextLine();
                test = validateSigil(sigil);
            }
            catch(IllegalArgumentException e)
            {
                sc.nextLine();
                showError(e.getMessage());
            }
        } while(!test);
    
	    test = false;
		
        do 
        {
			try
			{
				System.out.println("Please enter the colour of the banner as "
									+ "a hex string: ");
				bannerColor = sc.nextLine();
				test = validateColor(bannerColor);
			}
			catch(IllegalArgumentException e)
			{
				sc.nextLine();
				showError(e.getMessage());
			}
        } while(!test);
        
        test = false;
		
        do
        {
			try
			{
				System.out.println("Please enter the colour of the sigil "
									+ "as a hex string: ");
				sigilColor = sc.nextLine();
				test = validateColor(sigilColor);
			}
			catch(IllegalArgumentException e)
			{
				sc.nextLine();
				showError(e.getMessage());
			}
        } while(!test);
        
        
        BannerClass bannerObj = new BannerClass(sigil, bannerColor, sigilColor);
        return bannerObj;    
    
    }
	
	/********************************************************************
     *SUBMODULE: getFileName
	 *IMPORT: none
	 *EXPORT: fileName(String)
	 *PURPOSE: Retrieves the name of the file from user.
     *********************************************************************/

	public static String getFileName()
	{
		Scanner sc = new Scanner(System.in);
		String fileName = "";
		System.out.println("Please input the name of the file " 
							+ "you wish to load: ");
		fileName = sc.nextLine();
		return fileName;
	}
	
	/********************************************************************
     *SUBMODULE: getAllianceName
	 *IMPORT: none
	 *EXPORT: allianceName(String)
	 *PURPOSE: Retrieves the name of the alliance from user.
     *********************************************************************/

    public static String getAllianceName()
    {
        Scanner sc = new Scanner(System.in);
        String allianceName = "";
        System.out.println("Please input the name of the alliance: ");
        allianceName = sc.nextLine();
        return allianceName;
    }

	/********************************************************************
     *SUBMODULE: showError
	 *IMPORT: error(String)
	 *EXPORT: error(String)
	 *PURPOSE: Prints out a specific error message to user.
     *********************************************************************/

	
	public static void showError(String error)
	{
		System.out.println(error);
	}
	


	// Validation submodules
	
	/********************************************************************
     *SUBMODULE: validateString
	 *IMPORT: inString(String)
	 *EXPORT: test(boolean)
	 *ASSERTION: inString must be non-empty (not null)
     *********************************************************************/

	
	public static boolean validateString(String inString)
	{
		boolean test = false;
		if (inString != null && !inString.equals(""))
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
	
	public static boolean validateYears(int inYears)
	{
		int minyears = 1;
		int maxyears = 10000;
		boolean test = false;
		
        if ((inYears >= minyears) && (inYears <= maxyears))
        {
            test = true;
        }
        else
        {
            throw new IllegalArgumentException("Invalid number of years. "
            + "Must be between" + minyears + " and " + maxyears + " . " );
        }
       		return test;
	}


     /*************************************************************************
     *SUBMODULE: validateBannermen 
	 *IMPORT: inBannermen (Integer)
	 *EXPORT: A boolean - true or false
	 *ASSERTION: Number of bannermen must be between 25 and 80,000 (inclusive). 
    ************************************************************************/

	
	public static boolean validateBannermen(int inBannermen)
	{
		int minbannermen = 25;
		int maxbannermen = 80000;
		boolean test = false;
		
		if ((inBannermen >= minbannermen) && (inBannermen <= maxbannermen))
		{
			test = true;
		}
		else
		{
			throw new IllegalArgumentException("Invalid number of bannermen. "
                                    + "Must be between " + minbannermen 
                                    + " and " + maxbannermen + " . ");
		}
		return test;
	}

    /*************************************************************************
     *SUBMODULE: validateFootmen 
	 *IMPORT: inFootmen (Double)
	 *EXPORT: A boolean - true or false
	 *ASSERTION: Number of groups of footmen must be 
				 between 3.5 and 160.5 (inclusive). 
    ************************************************************************/
	
	public static boolean validateFootmen(double inFootmen)
	{
		double minfootmen = 3.5;
		double maxfootmen = 160.5;
		boolean test = false;
		
		if ((inFootmen >= minfootmen) && (inFootmen <= maxfootmen))
		{
			test = true;
		}
		else
		{
			throw new IllegalArgumentException("Invalid number of footmen. "
            + "Must be between " + minfootmen + " and " + maxfootmen 
            + " (inclusive). ");
		}
		return test;
	}

    /*************************************************************************
     *SUBMODULE: validateArchers 
	 *IMPORT: inArchers (Double)
	 *EXPORT: A boolean - true or false
	 *ASSERTION: Number of squads of archers 
				 must be between 1.5 and 112.5 (inclusive). 
    ************************************************************************/
	
	public static boolean validateArchers(double inArchers)
	{
		double minarchers = 1.5;
		double maxarchers = 112.5;
		boolean test = false;
		
		if ((inArchers >= minarchers) && (inArchers <= maxarchers))
		{
			test = true;
		}
		else
		{
			throw new IllegalArgumentException("Invalid number of archers. "
                        + "Must be between " + minarchers + " and " + 
                        + maxarchers + " (inclusive). ");
		}
		return test;
	}

    /*************************************************************************
     *SUBMODULE: validateColor
	 *IMPORT: inColor (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid color -- i.e. string length of 6 & hexadecimal.
    ************************************************************************/

	public static boolean validateColor(String inColor)
	{
		int colorNum;
		boolean valid = false;
		
		if (inColor.length() == 6)
		{
			try
			{
				colorNum = Integer.parseInt(inColor,16);
				valid = true;
			}
			catch(NumberFormatException e)
			{
				showError("Not a hexvalue");
			}
		}
		else
		{
			showError("String inputted must be of length 6 characters long");
		}
		return valid;
	}

    /*************************************************************************
     *SUBMODULE: validateSigil
	 *IMPORT: inSigil (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: Must be valid sigil name (i.e. TOTEM, LION, DRAGON or WOLF).
    ************************************************************************/

    public static boolean validateSigil(String inSigil)
    {
        boolean equality = false;
        if(inSigil.equals(BannerClass.SIGIL1) ||
		inSigil.equals(BannerClass.SIGIL2) ||
		inSigil.equals(BannerClass.SIGIL3) ||
		inSigil.equals(BannerClass.SIGIL4))
        {                                                                       
            equality = true;                                                    
        }      
        return equality;                                                        
    }                      
}
