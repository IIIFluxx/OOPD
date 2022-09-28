import java.util.*;

public class UserInterface
{
	// No class constants or classfields
	
	//ALL methods MUST be static
	
	public static int getObject()
	{
		int userAlliance = 0;
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter 1 (one) for House, 2 (two) for Army "
                            + "for the type of Alliance you wish to make. ");
		userAlliance = sc.nextInt();
		return userAlliance;
	}
	
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
        AllianceClass newObj = new House(name, years, banner, bannermen, castle);
		return newObj;
	}

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
                System.out.println("Please input the number of squads of archers: ");
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
            	System.out.println("Please input the details of your history: ");
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
		
        AllianceClass newObj = new ArmyClass(name, years,banner, footmen, archers, history);
		return newObj;
	}

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
                System.out.println("Please input the name of the sigil: ");
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
		
        do // missing trycatch here
        {
            System.out.println("Please enter the colour of the banner as a hex string: ");
            bannerColor = sc.nextLine();
            test = validateColor(bannerColor);
        } while(!test);
        
        test = false;
		
        do
        {
            System.out.println("Please enter the colour of the sigil as a hex string: ");
            sigilColor = sc.nextLine();
            test = validateColor(sigilColor);
        } while(!test);
        
        
        BannerClass bannerObj = new BannerClass(sigil, bannerColor, sigilColor);
        return bannerObj;    
    
    }
	public static String getFileName()
	{
		Scanner sc = new Scanner(System.in);
		String fileName = "";
		System.out.println("Please input the name of the file you wish to load: ");
		fileName = sc.nextLine();
		return fileName;
	}
	
    public static String getAllianceName()
    {
        Scanner sc = new Scanner(System.in);
        String allianceName = "";
        System.out.println("Please input the name of the alliance: ");
        allianceName = sc.nextLine();
        return allianceName;
    }

	public static void showError(String error)
	{
		System.out.println(error);
	}
	
	
	public static boolean validateString(String inString)
	{
		boolean test = false;
		if (inString != null && !inString.equals(""))
		{
			test = true;
		}
		return test;
	}
	
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
            throw new IllegalArgumentException("Invalid number of years");
        }
       		return test;
	}
	
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
			throw new IllegalArgumentException("Invalid number of bannermen"
                                    + " must be between " + minbannermen 
                                    + " and " + maxbannermen + " . ");
		}
		return test;
	}
	
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
			throw new IllegalArgumentException("Invalid number of footmen");
		}
		return test;
	}
	
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
			throw new IllegalArgumentException("Invalid number of archers");
		}
		return test;
	}

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

    public static boolean validateSigil(String inSigil)
    {
        boolean equality = false;
        if(inSigil.equals(BannerClass.sigil1) || inSigil.equals(BannerClass.sigil2)     || inSigil.equals(BannerClass.sigil3) || inSigil.equals(BannerClass.sigil4))
        {                                                                       
            equality = true;                                                    
        }                                                                       
        return equality;                                                        
    }                      
}
