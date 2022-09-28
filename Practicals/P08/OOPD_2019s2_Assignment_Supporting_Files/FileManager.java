public class FileManager(kingdomObj)
{
	
	private String[] lineArray;
	
	public static readFile(String fileName)
	{
		FileInputStream fileStrm = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		int lineNum;
		String line;
		try 
		{
			fileStrm = new FileInputStream();	 
			rdr = new InputStreamReader(fileStrm);
			bufRdr = new BufferedReader(rdr);
			lineNum = 0;
			line = bufRdr.readLine();
			while (line != null) 
			{
				processLine(line,lineArray[]);
				line = bufRdr.readLine();
				
				lineNum++;
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
	
	public static lineArrayValidation(String line)
	{
		IllegalArgumentException e = new IllegalArgumentException("Invalid length");
		try
		{
			lineArray[] = line.split(",");
			if(lineArray.length != 8 || lineArray.length != 9)
			{
				throw e;
			}
			if(lineArray[0].length() != 1)
			{
				throw e;
			}
			
			if (lineArray[].charAt(0) != "H" || lineArray[].charAt(0) != "A")
			{
				throw e;
			}
		}
		catch (IllegalArgumentException e) { }
		return;
	}
	
	public static splitLineArray()
	{
		char type = lineArray[0].charAt(0);
		String sigil = bannerClass.validateSigil(lineArray[3]);
		String sigilColour = bannerClass.validateSigilColor(Integer.parseInt.lineArray[4],16);
		String bannerColor = bannerClass.validateBannerColor(lineArray[5]);
		BannerClass bannerObj = new BannerClass(sigil, bannerColour, sigilColour);
		
		switch(type)
		{
			case H:
			{
				name = House.validateName(lineArray[1]);
				years = House.validateYears((int)(lineArray[2]));
				bannermen = House.validateBannermen(lineArray[6]);
				castle = House.validateCastle(lineArray[7]);
				House houseObj = new House(name, years, bannermen, castle);
				Kingdom.addHouseObjects(houseObj);
			}
			case A:
			{
				name = ArmyClass.validateName(lineArray[1]);
				years = ArmyClass.validateYears((int)(lineArray[2]));
				footmen = ArmyClass.validateFootmen(lineArray[6]);
				archers = ArmyClass.validateArchers(lineArray[7]);
				history = ArmyClass.validateHistory(lineArray[8]);
				ArmyClass armyObj = new ArmyClass(name, years, footmen, archers, history);
				Kingdom.addArmyObjects(armyObj);
			}
			default:
			{
				throw new IllegalArgumentException("Invalid type");
			}
		}
		catch (IllegalArgumentException e) 
		{
			UserInterface.showError(e.getMessage())
		}
	}
	/*
	Output Method:
	INPUT: House  and  Army  arrays, file  name
	PROCESS: write  arrays  content  to  the  specified  file,  as  described  in  the  assignment specification.
	OUTPUT: Generate string.*/
		
	public static void writeFile(String fileOutputName, House houseArray[], ArmyClass armyArray[], char type)
	{
		FileOutputStream fileStrm = null;
		PrintWriter pw;
		try 
		{
			fileStrm = new FileOutputStream(fileOutputName);
			pw = new PrintWriter(fileStrm);

			if (type == 'H')
			{
				pw.println(House[i].name, House[i].years, House[i].bannermen, House[i].castle);
			}
			if (type == 'A')
			{
				pw.println(ArmyClass[i].name, ArmyClass[i].years, ArmyClass[i].footmen, ArmyClass[i].archers, ArmyClass[i].history);
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
}