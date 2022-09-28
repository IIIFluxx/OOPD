import java.io.*;
public class FileManager
{	
	public static void readFile(String fileName, Kingdom kingdom)
	{
		FileInputStream fileStrm = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
	    String[] lineArray;
        int lineNum;
		String line;
		try 
		{
			fileStrm = new FileInputStream(fileName);	 
			rdr = new InputStreamReader(fileStrm);
			bufRdr = new BufferedReader(rdr);
			lineNum = 0;
			line = bufRdr.readLine();
			while (line != null) 
			{
				lineNum++;
				processLine(line,kingdom);
				line = bufRdr.readLine();
			}
			fileStrm.close();
		}
		catch (IOException e) 
		{
			if (fileStrm != null) 
			{
				try 
				{
					fileStrm.close(); 
				} catch (IOException ex2) { } 
			}
		}
	}
	
	//Create objects as appropriate and add them to Kingdom. 
	
	public static void processLine(String line, Kingdom kingdom)
	{ 
		String [] lineArray;
		String name, history, castle, sigil, sigilColor, bannerColor;
		int years, bannermen;
		double footmen, archers;
		char type;
        boolean isValid = false;
        boolean valid = false;
        AllianceClass newAllianceObj;
 
		try
		{
			
			/* 
			
			public boolean validateLine(String line)
			{
                boolean isValid = false;    
				lineArray = line.split(",");
				isValid = validateColor(sigilcolour) && validateColor(bannerColor) && validateHouse(house) && validateSigil(sigil) && validate;
				return isValid;
			}
			
						
			*/
			lineArray = line.split(",");
            if(lineArray.length != 8 && lineArray.length != 9)
			{
				throw new IllegalArgumentException("Invalid length");
			}
			if(lineArray[0].length() != 1)
			{
				throw new IllegalArgumentException("Invalid input");
			}
			
			if (lineArray[0].charAt(0) != 'H' && lineArray[0].charAt(0) != 'A')
			{
				throw new IllegalArgumentException("Invalid type");
			}
            
            isValid = validateLine(lineArray); // validates elements common to both House and Army objects i.e. name, years, banner
            
            /* Reads in sigilColor as string, validate it (check if length is
               6), if so, convert to int using parseInt, then we check if between              
                 0 and 255 (doublecheck), store in classfield(its valid) 
            */ 
            if(isValid)
            {
            
                name = lineArray[1];
                years = Integer.parseInt(lineArray[2]);
                type = lineArray[0].charAt(0);
                sigil = lineArray[3];
                sigilColor = lineArray[5]; 
                bannerColor = lineArray[4];
                BannerClass bannerObj = new BannerClass(sigil, bannerColor, sigilColor);
                switch(type)
			    {
                    case 'H':
                    
                    valid = validateHouse(lineArray);
                    if(valid)
                    {
                        bannermen = Integer.parseInt(lineArray[6]);
                        castle = lineArray[7];
                        newAllianceObj = new House(name, years, bannerObj, bannermen, castle);
                            kingdom.addNewAlliance(newAllianceObj);
                    }
                        break;
                    
                    case 'A':
                    
                        valid = validateArmy(lineArray);
                        if(valid)
                        {
                            footmen = Double.parseDouble(lineArray[6]);
                            archers = Double.parseDouble(lineArray[7]);
                            history = lineArray[8];
                            newAllianceObj = new ArmyClass(name, years, bannerObj, footmen, archers, history);
                            kingdom.addNewAlliance(newAllianceObj);
                        }
                        break;
                    
                    default:
                    
                        throw new IllegalArgumentException();
			    }
            }
		}
		catch (NumberFormatException error)
		{
			UserInterface.showError("Invalid number type. ");
		}
		
        catch (IllegalArgumentException error)
		{
			UserInterface.showError(error.getMessage());
		}
        
	
	}
	
	/*
	Output Method:
	INPUT: House  and  Army  arrays, file  name
	PROCESS: write  arrays  content  to  the  specified  file,  as  described  in  the  assignment specification.
	OUTPUT: Generate string.*/
		
	public static void writeFile(String fileOutputName, Kingdom kingdom)
	{
		FileOutputStream fileStrm = null;
		PrintWriter pw;
        /* House houseArray[];
        ArmyClass armyArray[];
        int houseCount, armyCount;
		*/
        AllianceClass[] allianceArray;
        int allianceCount;
        try 
		{
			fileStrm = new FileOutputStream(fileOutputName);
			pw = new PrintWriter(fileStrm);

            allianceArray = kingdom.getAllianceArray();
            allianceCount = kingdom.getAllianceCount();
            
            for(int i=0;i<allianceCount;i++)
            {
                pw.print(allianceArray[i].toFileString()); 
			}
            
            pw.close();
		}
		catch (IOException e) 
		{
			if (fileStrm != null)
			{
				try { fileStrm.close(); } catch (IOException ex2) { }
			}
		System.out.println("Error occured whilst writing to file: " + e.getMessage());	
		}   
	}
	

    public static boolean validateLine(String[] lineArray)
        {
            boolean isValid = false;
            String name = lineArray[1];                                            
            int years = Integer.parseInt(lineArray[2]);                         
            char type = lineArray[0].charAt(0);                                  
            String sigil = lineArray[3];                                           
            String sigilColor = lineArray[5];                                      
            String bannerColor = lineArray[4]; 
            isValid = UserInterface.validateString(name) && UserInterface.validateYears(years) && UserInterface.validateSigil(sigil) && UserInterface.validateColor(sigilColor) && UserInterface.validateColor(bannerColor);
            return isValid; 
        }
    public static boolean validateArmy(String [] lineArray)
        {
	         
            boolean valid = false;
            double footmen = Double.parseDouble(lineArray[6]);
            double archers = Double.parseDouble(lineArray[7]);
            String history = lineArray[8];
            valid = UserInterface.validateFootmen(footmen) && UserInterface.validateArchers(archers) && UserInterface.validateString(history);
            return valid;

        }

    public static boolean validateHouse(String [] lineArray)
    {
        boolean valid = false;
        int bannermen = Integer.parseInt(lineArray[6]);
        String castle = lineArray[7];
        valid = UserInterface.validateBannermen(bannermen) && UserInterface.validateString(castle); 
        return valid;    
    }
}
