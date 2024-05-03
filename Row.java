import java.util.*;
/**
 * Write a description of class Row here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Row
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Seat> seats;
    private int rowNumber;
    private int rowClass;
    private int seatCount;

    /**
     * Constructor for objects of class Row
     */
    public Row(int rowNumber, int rowClass, int seatCount)
    {
        // initialise instance variables
        x = 0;
        this.rowNumber = rowNumber;
        this.rowClass = rowClass;
        this.seatCount = seatCount;
        seats = new ArrayList<Seat>();
        createSeats(this.seatCount);
        
    }
    
    public void setRowClass(int rowClass)
    {
        this.rowClass = rowClass;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getRowClass()
    {
        // put your code here
        return this.rowClass;
    }
    
    public int getRowNumber()
    {
        return this.rowClass;
    }
    
    public void createSeats(int seatCount)
    {
        for (int i = 1; i <= seatCount; i++)
        {
            seats.add(new Seat(false, i));
        }
    }
    
    public ArrayList<Seat> getSeats()
    {
        return seats;
    }
}
