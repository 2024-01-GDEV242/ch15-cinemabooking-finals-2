import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    
    public static void main(String args[])
    {
        CinemaBookingSystem cbs = new CinemaBookingSystem(3);
        boolean[][] layout = {
            {false,true,true,true,false},
            {true,true,true,true,true},
            {true,true,true,true,true},
            {true,false,false,false,true},
        };
        cbs.addTheater("A1",layout);
        //Note: The months are indexed at 0, the days wihtin the month are not
        GregorianCalendar c = new GregorianCalendar(2024,9,5,12,0);//May 10 2024 12:00 PM
        cbs.getTheater(0).setShowing(0, new Show("Action movie","Thrilling movie with cool vfx",c.getTime()));
        c = new GregorianCalendar(2024,9,5,13,30);//May 10 2024 1:30 PM
        cbs.getTheater(0).setShowing(1, new Show("Mystery movie","Suspensful movie that scares you",c.getTime()));
        c = new GregorianCalendar(2024,9,5,15,50);//May 10 2024 3:50 PM
        cbs.getTheater(0).setShowing(2, new Show("Romance movie","Titanic 2 in real",c.getTime()));
        boolean[][] layout2 = {
            {false,true,true,true,false},
            {true,true,true,true,false},
            {true,false,true,true,true},
            {true,true,true,true,true},
        };
        cbs.addTheater("A2",layout2);
        c = new GregorianCalendar(2024,9,5,12,0);//May 10 2024 12:00 PM
        cbs.getTheater(1).setShowing(0, new Show("Mystery movie","Suspensful movie that scares you",c.getTime()));
        c = new GregorianCalendar(2024,9,5,16,0);//May 10 2024 4:00 PM
        cbs.getTheater(1).setShowing(1, new Show("Action movie","Thrilling movie with cool vfx",c.getTime()));
        c = new GregorianCalendar(2024,9,5,17,0);//May 10 2024 5:00 PM
        cbs.getTheater(1).setShowing(2, new Show("Romance movie","Titanic 2 in real",c.getTime()));
        cbs.printSchedule();
        System.out.println();
        cbs.printSeating(0,0);
        cbs.printSeating(1,0);
        System.out.println();
        if(cbs.reserveSeat(0,0,1,1,"1-908-444-5825")) //valid seat
        {
            System.out.println("return test success");
        }
        cbs.reserveSeat(0,0,0,0,"1-908-425-5723"); //null seat
        if(cbs.reserveSeat(0,0,1,1,"1-908-321-1865")) //taken seat
        {
            System.out.println("return test fail");
        } 
        cbs.reserveRange(0,1,1,0,3,"1-483-358-2922");
        cbs.reserveRange(0,1,0,0,4,"1-411-325-2942"); //Some seats are invalid, all fail
        cbs.printSeating(0,0); //only 5825 is displayed
        cbs.printSeating(0,1); //only 
        cbs.printSeating(0,2);
        c = new GregorianCalendar(2024,9,5,12,30);
        //demonstrate the schedules shifting
        System.out.println();
        System.out.println("Updated schedule to May 10th 2024 at 12:30 PM");
        cbs.updateSchedule(c.getTime());
        cbs.printSeating(0,0);
        cbs.printSeating(0,1);
        cbs.printSeating(0,2);
        cbs.cancelReservation(0,0,1,1);
        System.out.println();
        System.out.println("A1 1:30 PM reservation 1 1 cancelled");
        cbs.printSeating(0,0);
        System.out.println();
        System.out.println("2 days skipped");
        c = new GregorianCalendar(2024,12,5,12,40);
        cbs.updateSchedule(c.getTime());
        cbs.printSeating(0,0);
        cbs.printSeating(0,1);
        cbs.printSeating(0,2);

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
     * Reads a theater at a given index
     * 
     * @return Theater The theater at the index
     */
    public Theater getTheater(int index)
    {
        return theaters.get(index);
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
     * Cancels a reservation of a seat
     * 
     * @param  tIndex  The index of the target theater
     * @param  sIndex  The index of the target show
     * @param  row  The row of the reservation to cancel
     * @param  col  The column of the reservation to cancel
     * @return boolean  Whether or not the seat was valid.
     */
    public boolean cancelReservation(int tIndex, int sIndex, int row, int col)
    {
        boolean value = theaters.get(tIndex).cancelReservation(sIndex,row,col);
        return value;
    }
    
    /**
     * Cancels a row of reservations
     * 
     * @param  tIndex  The index of the target theater
     * @param  sIndex  The index of the target show
     * @param  row  The row of the reservations being cancelled
     * @param  sCol  The starting column of the reservations being cancelled, inclusive
     * @param  eCol  The ending column of the reservations being cancelled, exclusive
     */
    public void cancelRange(int tIndex, int sIndex, int row, int sCol, int eCol)
    {
        theaters.get(tIndex).cancelRange(sIndex,row,sCol,eCol);
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
     * If updated to exactly the time of a showing then causes unexpected behavior.
     * I have no idea why that happens because it shouldn't do anything if the date is the same
     * 
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
     * Prints the entire CBS schedule in chronological order
     */
    public void printSchedule()
    {
        printSchedule(0,-1);
    }
    
    /**
     * printSchedule() only gets called with the params other than 0 and -1 internally during recursion. 
     * 
     * @param start The start date of the search
     * @param lIndex The index of the last theater printed. 
     */
    private void printSchedule(long start, int lIndex)
    {
        Date earliest = new Date(0);
        Date last = new Date(start);
        int tIndex = -1;
        int sIndex = -1;
        //Find the earliest showing
        for(int i = 0; i < theaters.size(); i++)
        {
            for(int a = 0; a < maxShowings; a++)
            {
                Date b = theaters.get(i).getShowing(a).getDate();
                if((b.before(earliest) || earliest.equals(new Date(0))) && (b.after(last) || (b.equals(last) && i > lIndex)))
                {
                    tIndex = i;
                    sIndex = a;
                    earliest = b;
                }
            }
        }
        
        if(tIndex > -1) //if tIndex never changes, then all entries have been printed
        {   //getTime converts the date to a long
            Theater t = theaters.get(tIndex);
            System.out.println(t.getShowing(sIndex).getName() +
            " Airing in theater "+ t.getName() + " on: " + t.getShowing(sIndex).timeString());
            System.out.println("Description: " + t.getShowing(sIndex).getDescription());
            printSchedule(earliest.getTime(),tIndex);//Recursive call to function searching for only after this entry
        }
    }
    
    /**
     * Prints the seating chart to the console for the given showing
     * 
     * @param tIndex The index of the theater to print.
     * @param sIndex The index of the showing to print.
     */
    public void printSeating(int tIndex, int sIndex)
    {
        theaters.get(tIndex).printSeating(sIndex);
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
