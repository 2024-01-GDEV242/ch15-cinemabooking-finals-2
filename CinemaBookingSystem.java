
/**
 * Write a description of class CinemaBookingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CinemaBookingSystem
{
    // instance variables - replace the example below with your own
    int cost;
    Customer costumer;
    Show show;
    int rowNumber;
    int seatNumber;

    /**
     * Constructor for objects of class CinemaBookingSystem
     */
    public CinemaBookingSystem(Customer costumer, Show show)
    {
        // initialise instance variables
        this.costumer = costumer;
        this.show = show;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getCost()
    {
        if (show.getTheatre().getRows().get(rowNumber).getRowClass() == 1)
        {
            return cost += 8;
        }
        else
        {
            return cost += 5;
        }
    }
    
    public void setRowNumber(int rowNumber)
    {
        this.rowNumber = rowNumber;
    }
    
    public void setSeatNumber(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }
    
    public boolean reserveSeat(int selectedRow, int selectedSeat)
    {
        if (show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).getReservationStatus())
        {
            return false;
        }
        else
        {
            show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).reserve();
            setRowNumber(selectedRow);
            setSeatNumber(selectedSeat);
            return true;
        }
    }
    
    public boolean unreserveSeat()
    {
        show.getTheatre().getRows().get(rowNumber).getSeats().get(seatNumber).unreserve();
        return true;
    }
    
    public Customer getCostumer()
    {
        return costumer;
    }
}
