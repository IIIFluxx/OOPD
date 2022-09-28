Bharath Sukesh - Assignment  - Readme

Date created: 27/10/19

Date last modified: 27/10/19

Purpose: The purpose of the program is to evaluate the battle strength of different Alliances

Files in project: AllianceClass.java, AllianceClass.txt
				 ArmyClass.java, ArmyClass.txt
				 BannerClass.java, BannerClass.txt
				 Combatable.java, Combatable.txt
				 FileManager.java, FileManager.txt
				 House.java, House.txt
				 Kingdom.java, Kingdom.txt
				 Menu.class
				 UserInterface.java, UserInterface.txt

Test Files: duplicate.csv, sample.csv, test2.csv

Functionality: Manages two types of alliances; Houses and Armies. It can store, add, update, save details regarding Alliances, both within the program and to a file (so it can be reloaded within the program). It can perform	calculations based off of the alliance's properties i.e. its Battle Strength and its population. 	

TODO: N/A

Known bugs
	Bug #1: Prints out the prompt for castle and history twice. It can be replicated by trying to add a new Alliance (either House or Army).
			I suspect it has something to do with the relationship between the string input and validateString method after it is used once (i.e. after it is used for the name).     It *could* be fixed by having separate string validation methods for Name, Castle and History however this seemed inefficient. 
	Bug #2: Can't deal with a House without a Castle from user/file input. 

