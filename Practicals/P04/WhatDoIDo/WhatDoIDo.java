import java.util.*;
class WhatDoIDo 
{
    public static void randomnumberProgram (String[] args) 
    {
        // Pre-initialized variable used in the case statement 
        int numOne = 5;
        // Variable that is assigned to a random value 
        Random rand = new Random();
        int numTwo = rand.nextInt(5);
        switch(numTwo) 
        {
            case 1: 
                System.out.println("Which case is this?");
                break;
            case 2: 
                System.out.println(numOne);
                break;
            case 3:
                System.out.println("Who knows");
                break;
            case 4:
            // If the random number is 'four (4), then the following msg
            // is printed out.  
                if(numOne == 5) 
                { 
                    System.out.println("Wow, formatting is fun!");
                }
                break;
            case 5: 
                for(int numTwo = 0; counter <= numTwo; counter++)
                {
                    System.out.println(counter); 
                }
                break;
            default: 
                System.out.println("None of the above"); 
        } 
    }
}
