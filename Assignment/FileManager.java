import java.io.*;

/****************************************************
 * FILE : FileManager.java
 * PURPOSE : Contains all methods concerning File I/O
 * in 2019s2 OOPD assignment.
 * UNIT : OOPD (COMP1001)
 * AUTHOR : Curtin University
 * MODIFIED BY : Bharath Sukesh - 19982634
 * DATE CREATED : 27/08/2019
 * LAST MOD : 27/10/2019
 ****************************************************/

public class FileManager
{	

	// No class constants or private class fields in FileManager.
	
    /********************************************************************
     *SUBMODULE: readFile
	 *IMPORT: fileName(String), kingdom(Kingdom)
	 *EXPORT: none
	 *PURPOSE: Reads a file line-by-line and calls processing methods.
     *********************************************************************/
	
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
	
    /********************************************************************
     *SUBMODULE: processLine
	 *IMPORT: fileName(String), kingdom(Kingdom)
	 *EXPORT: none
	 *PURPOSE: Conducts all line processing - splits a CSV file into 
				 a line array and constructs an appropriate object to pass
				 back to the kingdom object's methods.
     *********************************************************************/ 
	
	// processLine based on algorithm from OOPD_Worksheet_8.pdf
	// URL: https://lms.curtin.edu.au/bbcswebdav/pid-7108131-dt-content-rid-36935645_1/xid-36935645_1
	
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
            
            isValid = validateLine(lineArray); 
			/* validates elements common to both House and Army objects  
			/ i.e. name, years, banner */
            if(isValid)
            {
				// sets specific lineArray elements to specific variables 
                name = lineArray[1];
                years = Integer.parseInt(lineArray[2]);
                type = lineArray[0].charAt(0);
                sigil = lineArray[3];
                sigilColor = lineArray[5]; 
                bannerColor = lineArray[4];
                BannerClass bannerObj = new BannerClass(sigil, bannerColor, 
														sigilColor);
                switch(type)
			    {
                    case 'H': /* If the first character is a 'H' 
							     indicating House class */
                    valid = validateHouse(lineArray);
                    if(valid)
                    {
                        bannermen = Integer.parseInt(lineArray[6]);
                        castle = lineArray[7];
                        newAllianceObj = new House(name, years, bannerObj, 
												   bannermen, castle);
                        kingdom.addNewAlliance(newAllianceObj);
                    }
                        break;
                    
                    case 'A': /* If the first character is an 'A' 
							     indicating ArmyClass */
                        valid = validateArmy(lineArray);
                        if(valid)
                        {
                            footmen = Double.parseDouble(lineArray[6]);
                            archers = Double.parseDouble(lineArray[7]);
                            history = lineArray[8];
                            newAllianceObj = new ArmyClass(name, years, 
													bannerObj, footmen, 
													archers, history);
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
	
	
	 /********************************************************************
     *SUBMODULE: writeFile
	 *IMPORT: fileOutputName(String), kingdom(Kingdom)
	 *EXPORT: none
	 *PURPOSE: Writes the lineArray's contents to a file containing a
				 user specified fileOutputName in CSV format; as described
				in the assignment specification.
     *********************************************************************/
			
	
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
		System.out.println("Error occured whilst writing to file: " 
							+ e.getMessage());	
		}   
	}
	
	/* Validation methods to ensure all data within the file is valid. Makes 
	   calls to UserInterface validation methods, which return a
	   boolean - true or false */
	 /********************************************************************
     *SUBMODULE: validateLine
	 *IMPORT: lineArray(String [])
	 *EXPORT: isValid(boolean)
	 *ASSERTION: Checks whether certain fields in the inputted line are valid 
	 *********************************************************************/
	 
    public static boolean validateLine(String[] lineArray)
        {
            boolean isValid = false;
            String name = lineArray[1];                                            
            int years = Integer.parseInt(lineArray[2]);                         
            char type = lineArray[0].charAt(0);                                  
            String sigil = lineArray[3];                                           
            String sigilColor = lineArray[5];                                      
            String bannerColor = lineArray[4]; 
            isValid = UserInterface.validateString(name) && 
					  UserInterface.validateYears(years) &&
					  UserInterface.validateSigil(sigil) &&
					  UserInterface.validateColor(sigilColor) && 
					  UserInterface.validateColor(bannerColor);
            return isValid; 
        }

	 /********************************************************************
     *SUBMODULE: validateArmy
	 *IMPORT: lineArray(String [])
	 *EXPORT: valid(boolean)
	 *ASSERTION: Checks whether ArmyClass' classfields 
				 in the inputted file are valid
	 *********************************************************************/

    public static boolean validateArmy(String [] lineArray)
        {
	         
            boolean valid = false;
            double footmen = Double.parseDouble(lineArray[6]);
            double archers = Double.parseDouble(lineArray[7]);
            String history = lineArray[8];
            valid = UserInterface.validateFootmen(footmen) && 
			UserInterface.validateArchers(archers) && 
			UserInterface.validateString(history);
            return valid;
        }
		
	/********************************************************************
     *SUBMODULE: validateHouse
	 *IMPORT: lineArray(String [])
	 *EXPORT: valid(boolean)
	 *ASSERTION: Checks whether House' classfields in 
				 the inputted file are valid
	*********************************************************************/

    public static boolean validateHouse(String [] lineArray)
    {
        boolean valid = false;
        int bannermen = Integer.parseInt(lineArray[6]);
        String castle = lineArray[7];
        valid = UserInterface.validateBannermen(bannermen) 
				&& UserInterface.validateString(castle); 
        return valid;    
    }
}
