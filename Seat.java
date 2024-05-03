
/**
 * Write a description of class Seat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Seat
{
    // instance variables - replace the example below with your own
    int seatNumber;
    boolean isReserved;

    /**
     * Constructor for objects of class Seat
     */
    public Seat(boolean isReserved, int seatNumber)
    {
        // initialise instance variables
        this.isReserved = isReserved;
        this.seatNumber = seatNumber;
    }
    
    public void setSeatNumber(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getSeatNumber()
    {
        // put your code here
        return this.seatNumber;
    }
    
    public boolean getReservationStatus()
    {
        return isReserved;
    }
    
    public void reserve()
    {
        isReserved = true;
    }
    
    public void unreserve()
    {
        isReserved = false;
    }
}
