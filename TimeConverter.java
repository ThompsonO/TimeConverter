/*
 * Author: Oliver Thompson
 * Date: Feb. 29, 2016
 * Created and run on NetBeans IDE 8.1
 */

package timeconverter;

/*
 * Time must be entered in the formate of hh:mmMM
 * Ex.) 05:03AM
 */

import java.util.Scanner;

public class TimeConverter {
   
    public static void main(String[] args) {
        
        TimeZones zone = new TimeZones();
        Scanner scan = new Scanner(System.in);
        String again;
        String myZone, myTime, newZone, newTime;
        
        do
        {
            //Gets the user's time zone
            System.out.println("What time zone are you currently in?");
            myZone = scan.next();
            
            //Gets the current time
            System.out.println("What time is it?");
            myTime = scan.next();
            
            //Gets the time zone to convert to
            System.out.println("What time zone are you looking for?");
            newZone = scan.next();
            
            //Converts the time
            newTime = zone.convert_time(myZone, myTime, newZone);
            
            //Prints the new time
            System.out.println("The time in " + newZone + " is currently " + newTime);
            
            //Allows you to repeat
            System.out.println("Do you want to convert another time?");
            again = scan.next();
            
        }while(again.equals("y") || again.equals("Y"));
        
        //A non-user input example
        /*
        myZone = "CST";
        myTime = "11:52PM";
        newZone = "CET";
        
        newTime = zone.convert_time(myZone, myTime, newZone);
        System.out.println("newTime: " + newTime);
        */
    }
    
    
    
}
