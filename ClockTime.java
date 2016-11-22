
/**
 * Name: Bryce Sulin (sulin) 
 * Course: CSCI-241 - Computer Science I
 * Section: 001
 * Assignment: 9
 * 
 * Program Description:
 * Complete and test an instantiable Java class that
 * keeps track of the hours, minutes, and seconds for different clocks' time.
 * It also compares two clock times, and displays them in 12 hour and 24 hour format.
 * 
 * Known Bugs: none.
 */
public class ClockTime
{
    // These instance variables hold the associated ClockTime setting in 24 hours
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructor for objects of class ClockTime.
     * Sets all instance variables equal to zero.
     */
    public ClockTime()
    {
        // Initialise instance variables
        hour = 0;
        minute = 0;
        second = 0;
    }

    /**
     * Constructor for objects of class ClockTime.
     * Takes 3 integer parameters, holding the hour, minute,
     * and second values (in that order).
     */
    public ClockTime(int h, int m, int s)
    {
        // Set instance variables equal to parameter values
        hour = h;
        minute = m;
        second = s;

        // Use if-statements to ensure all time variables stay within their parameters
        if (second > 59)
        {
            minute = minute + second / 60;
            second = second % 60;
        }
        if (second < 0)
        {
            second = 0;
        }
        if (minute > 59)
        {
            hour = hour + minute / 60;
            minute = minute % 60;
        }
        if (minute < 0)
        {
            minute = 0;
        }
        if (hour > 24)
        {
            hour = hour % 24;
        }
        if (hour < 0)
        {
            hour = 0;
        }
    }

    /**
     * The getHour() accessor method takes no parameters and returns an integer.
     * This accesses the hour variable.
     */
    public int getHour()
    {
        return hour;
    }

    /**
     * The getMinute() accessor method takes no parameters and returns an integer.
     * This accesses the minute variable.
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * The getSecond() accessor method takes no parameters and returns an integer.
     * This accesses the second variable.
     */
    public int getSecond()
    {
        return second;
    }

    /**
     * The setHour(int) mutator method takes an integer parameter
     * and returns nothing. This sets the hour variable.
     */
    public void setHour(int h)
    {
        hour = h;
    }

    /**
     * The setMinute(int) mutator method takes an integer parameter
     * and returns nothing. This sets the minute variable.
     */
    public void setMinute(int m)
    {
        minute = m;
    }

    /**
     * The setSecond(int) mutator method takes an integer parameter
     * and returns nothing.This sets the second variable.
     */
    public void setSecond(int s)
    {
        second = s;
    }

    /**
     * The toString() method has no parameters and returns a string.
     * This holds the clock's time in 24-hour format. (No AM/PM)
     */
    public String toString()
    {
        String time24 = "";
        time24 = String.format("%02d:%02d:%02d", hour, minute, second);
        return time24;
    }

    /**
     * The toSTring12() method has no parameters and returns a string.
     * This holds the clock's time in 12hr format (AM/PM). 
     * A new int variable is initialized to convert the hours 
     * to 12hr without affecting the hour variable.
     */
    public String toString12()
    {
        String time = "";
        String time12 = "";
        int hour24 = 0;

        // if-statement to decide to use AM or PM
        if (hour >= 12)
        {
            time = "P.M.";
        }
        else
        {
            time = "A.M.";
        }

        // if-else statement to convert the hours to 12-hour format using hour24
        if (hour > 12)
        {
            hour24 = hour - 12;
        }
        else
        {
            hour24 = hour;
        }
        time12 = String.format("%02d:%02d:%02d %4s", hour24, minute, second, time);
        return time12;
    }

    /**
     * The advance(int) method has one integer parameter and returns nothing.
     * This takes a positive integer, 
     * and moves the ClockTime object by that many seconds.
     */
    public void advance(int addTime)
    {
        second = second + addTime;
        if (second > 59)
        {
            minute = minute + second / 60;
            second = second % 60;
        }
        if (minute > 59)
        {
            hour = hour + minute / 60;
            minute = minute % 60;
        }
        if (hour > 24)
        {
            hour = hour % 24;
        }
    }

    /**
     * The equals(ClockTime) method returns a boolean value.
     * This checks to see if the current ClockTime contains the same values
     * as the one sent in the parameter.
     */
    public boolean equals(ClockTime clock1)
    { 
        boolean check = false;
        if (hour == clock1.hour && minute == clock1.minute && second == clock1.second)    
        {
            check = true;
        }
        return check;
    }
}