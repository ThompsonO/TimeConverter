/*
 * Author: Oliver Thompson
 * Date: Feb. 29, 2016
 * Created and run on NetBeans IDE 8.1
 */

package timeconverter;

public class TimeZones {
    
    //Global Constants with the UTC offsets for time zones
    public static final int UTC = 0;
    public static final int WET = 0;
    public static final int CET = 1;
    public static final int CAT = 2;
    public static final int MSK = 3;
    public static final int GST = 4;
    public static final int PKT = 5;
    public static final int BST = 6;
    public static final int ICT = 7;
    public static final int CT = 8;
    public static final int JST = 9;
    public static final int PGT = 10;
    public static final int SBT = 11;
    public static final int FJT = 12;
    public static final int TOT = 13;
    public static final int LINT = 14;
    public static final int EGT = -1;
    public static final int FNT = -2;
    public static final int ART = -3;
    public static final int ECT = -4;
    public static final int EST = -5;
    public static final int CST = -6;
    public static final int MST = -7;
    public static final int PST = -8;
    public static final int GIT = -9;
    public static final int HST = -10;
    public static final int SST = -11;
    public static final int BIT = -12;
    
    //Converts the time from one time zone to another
    public String convert_time(String myZone, String myTime, String newZone)
    {
        String newTime;
        int myZ, newZ;
        int hour, min;
        String meridi;
        
        //Converts time zones to UTC offsets
        myZ = zone_to_int(myZone);
        newZ = zone_to_int(newZone);
        
        //Parses the entered time
        hour = hour_parser(myTime);
        min = min_parser(myTime);
        meridi = meridian_parser(myTime);
        
        //Converts hours to UTC
        hour -= myZ;
        
        //Convert AM to PM if necessary
        if(hour < 0)
        {
            hour += 12;
            
            if(meridi.equals("AM"))
            {
                meridi = "PM";
            }
            else
            {
                meridi = "AM";
            }
        }
        else if(hour == 0)
        {
            hour += 12;
        }
        else if(hour > 12)
        {
            hour -= 12;
            
            if(meridi.equals("AM"))
            {
                meridi = "PM";
            }
            else
            {
                meridi = "AM";
            }
        }
        
        
        //Converts hours to new time zone
        hour += newZ;
        
        //Convert AM to PM if necessary
        if(hour < 0)
        {
            hour += 12;
            
            if(meridi.equals("AM"))
            {
                meridi = "PM";
            }
            else
            {
                meridi = "AM";
            }
        }
        else if(hour == 0)
        {
            hour += 12;
        }
        else if(hour > 12)
        {
            hour -= 12;
            
            if(meridi.equals("AM"))
            {
                meridi = "PM";
            }
            else
            {
                meridi = "AM";
            }
        }
        
        //Concatenates the changes into a string
        if(hour < 10)
        {
            newTime = "0" + hour;
        }
        else
        {
            newTime = "" + hour;
        }
        
        newTime += ":";
        
        if(min < 10)
        {
            newTime += "0" + min;
        }
        else
        {
            newTime += min;
        }
        
        newTime += meridi;
        
        return newTime;
    }
    
    //Returns an integer with the appropriate hour offset from UTC
    public int zone_to_int(String zone)
    {
        int intZ;
        
        //Sets intZ to the hour offset of the appropriate time zone
        switch (zone) {
            case "UTC":
            case "WET":
                intZ = 0;
                break;
            case "CET":
                intZ = 1;
                break;
            case "CAT":
                intZ = 2;
                break;
            case "MSK":
                intZ = 3;
                break;
            case "GST":
                intZ = 4;
                break;
            case "PKT":
                intZ = 5;
                break;
            case "BST":
                intZ = 6;
                break;
            case "ICT":
                intZ = 7;
                break;
            case "CT":
                intZ = 8;
                break;
            case "JST":
                intZ = 9;
                break;
            case "PGT":
                intZ = 10;
                break;
            case "SBT":
                intZ = 11;
                break;
            case "FJT":
                intZ = 12;
                break;
            case "TOT":
                intZ = 13;
                break;
            case "LINT":
                intZ = 14;
                break;
            case "EGT":
                intZ = -1;
                break;
            case "FNT":
                intZ = -2;
                break;
            case "ART":
                intZ = -3;
                break;
            case "ECT":
                intZ = -4;
                break;
            case "EST":
                intZ = -5;
                break;
            case "CST":
                intZ = -6;
                break;
            case "MST":
                intZ = -7;
                break;
            case "PST":
                intZ = -8;
                break;
            case "GIT":
                intZ = -9;
                break;
            case "HST":
                intZ = -10;
                break;
            case "SST":
                intZ = -11;
                break;
            case "BIT":
                intZ = -12;
                break;
            default:
                intZ = 0;
                break;
        }

        return intZ;
    }
    
    //Parses the time and returns just the hours
    public int hour_parser(String myTime)
    {
        String convert;
        int hour;
        
        //Grabs the first to digits of the time
        convert = myTime.substring(0, 2);
        
        //Converts the string to an integer
        hour = Integer.parseInt(convert);
        
        return hour;
    }
    
    //Parses the time and returns just the minutes
    public int min_parser(String myTime)
    {
        String convert;
        int min;
        
        //Grabs the first to digits of the time
        convert = myTime.substring(3, 5);
        
        //Converts the string to an integer
        min = Integer.parseInt(convert);
        
        return min;
    }
    
    //Parses the time and returns just the AM or PM
    public String meridian_parser(String myTime)
    {
        String meridi;
        
        //Sets it to am or pm to match myTime
        if(myTime.charAt(6) == 'a' || myTime.charAt(6) == 'A')
        {
            meridi = "AM";
        }
        else
        {
            meridi = "PM";
        }
        
        return meridi;
    }
    
}
