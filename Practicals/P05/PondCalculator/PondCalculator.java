import java.util.*;
import java.lang.Math.*;

public class PondCalculator
{
    public static void main (String [] args)
    {
        char username, loopCond;
        String name, animal;
        int speciesChoice;
	    double unit, volume;
        Scanner sc = new Scanner(System.in);
        do 
        {
            System.out.println("Please enter the first letter of your first name - J, C or R");
            username = sc.next().charAt(0);
            if (username == 'J')
            {
                name = "Joey";
                System.out.println("Please enter which your choice between" +
                " the two choices you are given - "
                + "one (1) for Sting Rays or two (2) for Arowana");
                speciesChoice = sc.nextInt();
                
                if(speciesChoice == 1)
                {
                    unit = 0.5;
                    animal = "string ray(s)";
                }
                else if(speciesChoice == 2)
                {
                    unit = 0.4;
                    animal = "arowana(s)";
                }                
                else
                {
                    System.out.println("Invalid input, please enter 1 or 2");
                }           
                calcVolume();
            }
            else if(username == 'C')
            {
                name = "Cory";
                System.out.println("Please enter which your choice between the two choices you are given - one (1) for Koi or two (2) for Puffer Fish");
                speciesChoice = sc.nextInt();
                if(speciesChoice == 1)
                {
                    unit = 0.6;
                    animal = "koi";
                }
                else if(speciesChoice == 2)
                {
                    unit = 0.8;
                    animal = "puffer fish(es)";
                }
                else
                {
                    System.out.println("Invalid input, please enter 1 or 2");
                }
                calcVolume();
            }
            else if(username == 'R')
            {
                name = "Rachel";
                  System.out.println("Please enter which your choice between the two choices you are given - one (1) for Turtles or two (2) for Frogs");
                  speciesChoice = sc.nextInt();
                  if(speciesChoice == 1)
                  {
                      unit = 1.2;
                      animal = "turtle(s)";
                  }
                  else if(speciesChoice == 2)
                  {
                      unit = 4.5;
                      animal = "frog(s)";
                  }
                  else
                  {
                      System.out.println("Invalid input, please enter 1 or 2");
                  }
                  calcVolume();                
            }
            calcNumAnimals(volume,unit,name,animal,speciesChoice);
            System.out.println("Would you like to try again? (y for yes, n for no)");
            loopCond = sc.next().charAt(0);
        } 
        while  (loopCond == 'y' || loopCond == 'Y');
    }
    
    private static double calcVolume()
    {
        Scanner sc = new Scanner(System.in);      
        double volume, length, width, depth;
        System.out.println("Please enter an integer in metres for the length of the pond");
        length = sc.nextDouble;
           
        System.out.println("Please enter an integer in metres for the width of the pond");
        width = sc.nextDouble;

        System.out.println("Please enter an integer in metres for the depth of the pond");
        depth = sc.nextDouble;

        volume = length * width * depth;
        return volume;
    }
    
    private static void calcNumAnimals(double volume, double unit, String name, String animal, int speciesChoice)
    {
        
        int animalCount;
        animalCount = unit * volume;
        if(name = "Joey" && speciesChoice = 1)
        {
            System.out.println(name + " can store " + animalCount + " " + animal + "in his " + volume + " m^3 pond.");
        }
        else if(name == "Joey" && speciesChoice = 2)
        {
            System.out.println(name + " can store " + animalCount + " " + animal + "in his " + volume + " m^3 pond.");
        }
        else if(name == "Cory" && speciesChoice = 1)
        {
            System.out.println(name + " can store " + animalCount + " " + animal + "in his " + volume + " m^3 pond.");
        }
        else if(name == "Cory" && speciesChoice = 2)
        {
            System.out.println(name + " can store " + animalCount + " " + animal + "in his " + volume + " m^3 pond.");
        }
        else if(name == "Rachel" && speciesChoice = 1)
        {   
            System.out.println(name + " can store " + animalCount + " " + animal + "in his " + volume + " m^3 pond.");
        }
        else if(name == "Rachel" && speciesChoice = 2)
        {
            System.out.println(name + " can store " + animalCount + " " + animal + "in his " + volume + " m^3 pond.");
        }
    }
}
