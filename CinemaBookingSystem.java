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
     * @return the maximum number of showings each theater in the system can hold
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // public int sampleMethod(int y)
    // {

    // }
}
