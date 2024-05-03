import java.util.*;
/**
 * Write a description of class Show here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Show
{
    // instance variables - replace the example below with your own
    private String showName;
    private String showDate;
    private Theatre theatre;
    private ArrayList<Seat> seats;
    private int freeSeats;

    /**
     * Constructor for objects of class Show
     */
    public Show(String showName, String showDate, Theatre theatre)
    {
        // initialise instance variables
        this.showName = showName;
        this.showDate = showDate;
        this.theatre = theatre;
    }
    
    public void loadSeats()
    {
        for (Row row : theatre.getRows())
        {
            for (Seat seat : row.getSeats())
            {
                seats.add(seat);
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getFreeSeatsCount()
    {
        // put your code here
        for (Seat seat : seats)
        {
            if (!seat.getReservationStatus())
            {
                freeSeats++;
            }
        }
        return freeSeats;
    }
    
    public void setShowName(String showName)
    {
        this.showName = showName;
    }
    
    public void setShowDate(String showDate)
    {
        this.showDate = showDate;
    }
    
    public void setTheatre(Theatre theatre)
    {
        this.theatre = theatre;
    }
    
    public String getShowName()
    {
        return showName;
    }
    
    public String getShowDate()
    {
        return showDate;
    }
    
    public Theatre getTheatre()
    {
        return theatre;
    }
    
    public ArrayList<Seat> getSeats()
    {
        return seats;
    }
}
