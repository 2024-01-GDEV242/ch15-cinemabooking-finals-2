import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
/**
 * The class that holds the theaters of the cinema and manages them. 
 * Serves as an interface for using the system
 *
 * @author Andrew Steidle
 * @version 2024.5.5
 */
public class CinemaBookingSystem
{
    // instance variables - replace the example below with your own
    private ArrayList<Theater> theaters;
    private int maxShowings;
    
    
    /**
     * Constructor for objects of class CinemaBookingSystem
     */
    public CinemaBookingSystem(int maxShowings)
    {
        // initialise instance variables
        this.maxShowings = maxShowings;
        theaters = new ArrayList<Theater>();
    }
    
    /**
     * Accessor Method for maxShowings
     * @return  int  the maximum number of showings each theater in the system can hold
     */
    public int getMaxShowings()
    {
        return maxShowings;
    }
    
    /**
     * Adds a Theater to the cinema
     * @param name The name of the theater
     * @param layout The layout of seats in the theater, true marks a place where a seat exists.
     */
    public void addTheater(String name, boolean[][] layout)
    {
        theaters.add(new Theater(name,layout,maxShowings));
    }
    
    /**
     * Adds a show to the schedule of the Theater at a given index, at another given index.
     * @param tIndex The index of the Theater to add the Show to.
     * @param sIndex The index of the Theater's schedule to add the show to.
     * @param show The Show to add to the Theater's schedule
     */
    public void addShowing(int tIndex, int sIndex, Show show)
    {
        theaters.get(tIndex).setShowing(sIndex, show);
    }
    
    /**
     * Reads the schedule of Theater at a given index, at another given index.
     * @param tIndex The index of the Theater to read the schedule of.
     * @param sIndex The index of the Theater's schedule to read.
     * @return Show The Show at the index in the schedule.
     */
    public Show getShowing(int tIndex, int sIndex)
    {
        return theaters.get(tIndex).getShowing(sIndex);
    }
    
    /**
     * Reserves a seat in a Theater if it is empty (and it exists)
     * 
     * @param  tIndex The index of the theater that is being reserved
     * @param  sIndex  The index of the show that is being reserved
     * @param  row  The row of the seat being reserved
     * @param  col  The column of the seat being reserved
     * @return boolean  Whether or not the seat was available.
     */
    public boolean reserveSeat(int tIndex, int sIndex, int row, int col, String phone)
    {
        return theaters.get(tIndex).reserveSeat(sIndex,row,col,phone);
    }
    
    /**
     * Reserves a range of seats if all are empty (and they exist).
     * Will not reserve any seats in the row if any are taken.
     *
     * @param  tIndex The index of the theater that is being reserved
     * @param  sIndex  The index of the show that is being reserved
     * @param  row  The row of the seat being reserved
     * @param  sCol  The starting column of the seats being reserved, inclusive
     * @param  eCol  The ending column of the seats being reserved, exclusive
     * @return boolean  Whether or not the seats were available. 
     */
    public boolean reserveRange(int tIndex, int sIndex, int row, int sCol, int eCol, String phone)
    {
        return theaters.get(tIndex).reserveRange(sIndex,row,sCol,eCol,phone);
    }
    
    /**
     * Updates all Theaters to the provided time, removing any showings that have passed from shedules.
     * Clears layouts of showings and shifts the arrays, leaving the last entry blank.
     * @param date The Date/Time to update to.
     */
    public void updateSchedule(Date date)
    {
        for(int i = 0; i < theaters.size(); i++)
        {
            theaters.get(i).updateSchedule(date);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // public int sampleMethod(int y)
    // {

    // }
}
