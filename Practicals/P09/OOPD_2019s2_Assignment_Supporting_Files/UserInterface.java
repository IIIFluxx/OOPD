import java.util.*;

public class UserInterface
{
	// No class constants or classfields
	
	//ALL methods MUST be static
	
	public static int getObject()
	{
		int userAlliance = 0;
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter 1 (one) for House, 2 (two) for Army");
		userAlliance = sc.nextInt();
		return userAlliance;
	}
	
	public static House getHouseObject()
	{
		Scanner sc = new Scanner(System.in);
		String name, castle;
		int years, bannermen;
		boolean test;
		BannerClass banner;
		do
		{
			System.out.println("Please input the name of your House: ");
			name = sc.nextLine();
			test = validateString(name);
		} while(!test);
		
		do
		{
			System.out.println("Please input the number of years: ");
			years = sc.nextInt();
			test = validateYears(years);
		} while(!test);
		
		do
		{
			System.out.println("Please input the number of bannermen: ");
			bannermen = sc.nextInt();
			test = validateBannermen(bannermen);
		} while(!test);
		
		do
		{
			System.out.println("Please input the name of your Castle: ");
			castle = sc.nextLine(); 
			test = validateString(castle);
		} while (!test);
        
        // PASS IN BANNER OBJECT FROM CREATE BANNER SUBMODULE
        banner = getBannerObject();
		House newObj = new House(name, years, bannermen, castle, banner);
		return newObj;
	}

	public static ArmyClass getArmyObject()
	{
		Scanner sc = new Scanner(System.in);
		String name, history;
		int years, footmen;
		double archers;
		boolean test = false;
        BannerClass banner;
		do
		{
			System.out.println("Please input the name of your Army: ");
			name = sc.nextLine();
			test = validateString(name);
		} while(!test);
		
		do
		{
			System.out.println("Please input the number of years: ");
			years = sc.nextInt();
			test = validateYears(years);
		} while(!test);
		
		do
		{
			System.out.println("Please input the number of footmen: ");
			footmen = sc.nextInt();
			test = validateFootmen(footmen);
		} while(!test);
		
		do
		{
			System.out.println("Please input the number of squads of archers: ");
			archers = sc.nextDouble();
			test = validateArchers(archers);
		} while(!test);
		
		do
		{
			System.out.println("Please input the details of your history: ");
			history = sc.nextLine();
			test = validateString(history);
		} while(!test);
        
        
        // PASS IN BANNER OBJECT FROM CREATE BANNER SUBMODULE  
        banner = getBannerObject();
		
        ArmyClass newObj = new ArmyClass(name, years, footmen, archers, history, banner);
		return newObj;
	}

    public static BannerClass getBannerObject()
    {
        int bannerColor,sigilColor;
        String sigil, sigilColorString, bannerColorString;
        Scanner sc = new Scanner(System.in);
        boolean test = false;
        do
        {
            System.out.println("Please input the name of the sigil: ");
            sigil = sc.nextLine();
            test = validateSigil(sigil);
        } while(!test);
    
        do
        {
            System.out.println("Please enter the colour of the banner as a hex string: ");
            bannerColorString = sc.nextLine();
            test = validateColor(bannerColorString);
        } while(!test);
        
        bannerColor = Integer.parseInt(bannerColorString);
        
         do
        {
            System.out.println("Please enter the colour of the sigil as a hex string: ");
            sigilColorString = sc.nextLine();
            test = validateColor(sigilColorString);
        } while(!test);
        
        sigilColor = Integer.parseInt(sigilColorString);
        
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
			throw new IllegalArgumentException("Invalid number of bannermen");
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
				if (colorNum >= 0 && colorNum <= 16777215)
				{
					valid = true;
				}
			}
			catch(NumberFormatException e)
			{
				showError("Not a number");
			}
		}
		else
		{
			showError("String too long");
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
