import java.util.Date;
/**
 * The Theater class holds seating charts and a schedule of Shows to screen.
 *
 * @author Andrew Steidle
 * @version 2024.4.28
 */
public class Theater
{
    // instance variables - replace the example below with your own
    private String name;
    private String[][] layout;
    private String[][][] seats; //[showing][row][column]
    private Show[] schedule; //The schedule of the theater
    /**
     * Constructor for objects of class Theater
     */
    public Theater(String name, boolean[][] layout, int maxShowings)
    {
        // initialise instance variables
        this.name = name;
        seats = new String[maxShowings][layout.length][layout[0].length];
        for(int a = 0; a < layout.length; a++)
        {
            for(int b = 0; b < layout[0].length; b++)
            {
                if(layout[a][b]) //true means seat exists
                {
                    seats[0][a][b] = "seat available";
                } else //false means it does not
                {
                    seats[0][a][b] = "              ";
                }
            }
        }
        this.layout = seats[0].clone();
        for(int i = 0; i < maxShowings; i++)
        {
            for(int c = 0; c < layout.length; c++) //deep copy
            {
                seats[i][c] = this.layout[c].clone();
            } 
        }
        schedule = new Show[maxShowings];
    }
    
    /**
     * Reserves a seat if it is empty (and it exists)
     * 
     * @param  show  The index of the show that is being reserved
     * @param  row  The row of the seat being reserved
     * @param  col  The column of the seat being reserved
     * @return boolean  Whether or not the seat was available.
     */
    public boolean reserveSeat(int show, int row, int col, String phone)
    {
        if(seats[show][row][col].equals("seat available"))
        {
            seats[show][row][col] = phone; //add the user's phone number
            return true; //the seat is empty
        }
        return false; //the seat is taken
    }
    
    /**
     * Cancels a reservation of a seat
     * 
     * @param  show  The index of the target show
     * @param  row  The row of the reservation to cancel
     * @param  col  The column of the reservation to cancel
     * @return boolean  Whether or not the seat was valid.
     */
    public boolean cancelReservation(int show, int row, int col)
    {
        if(seats[show][row][col].equals("              "))
        {
            return false; //the seat is null and can't be overwritten
        }
        seats[show][row][col] = "seat available"; //make the seat available to reserve
        return true; //the seat is taken
    }
    
    /**
     * Cancels a row of reservations
     * 
     * @param  show  The index of the target show
     * @param  row  The row of the reservations being cancelled
     * @param  sCol  The starting column of the reservations being cancelled, inclusive
     * @param  eCol  The ending column of the reservations being cancelled, exclusive
     */
    public void cancelRange(int show, int row, int sCol, int eCol)
    {
        for(int i = sCol; i < eCol; i++)
        {
            cancelReservation(show,row,i);
        }
    }
    
    /**
     * Internal method of reserveRow that checks the availibility of seats
     * 
     * @param  show  The index of the show that is being reserved
     * @param  row  The row of the seat being reserved
     * @param  col  The column of the seat being reserved
     * @return boolean  Whether or not the seats were available.
     */
    private boolean checkRow(int show, int row, int sCol, int eCol)
    {
        for(int i = sCol; i < eCol; i++)
        {
            if(seats[show][row][i].equals("seat available"))
            {
                continue;
            } else
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Reserves a seat if it is empty (and it exists)
     * 
     * @param  show  The index of the show that is being reserved
     * @param  row  The row of the seat being reserved
     * @param  sCol  The starting column of the seats being reserved, inclusive
     * @param  eCol  The ending column of the seats being reserved, exclusive
     * @return boolean  Whether or not the seats were available.
     */
    public boolean reserveRange(int show, int row, int sCol, int eCol, String phone)
    {
        if(checkRow(show,row,sCol,eCol))
        {
            for(int i = sCol; i < eCol; i++)
            {
                seats[show][row][i] = phone; //add the user's phone number
            }
            return true; //the seats were empty
        }
        return false; //the seats were taken
    }
    
    /**
     * Modifies the Theater's schedule
     *
     * @param  index  The entry to modify
     * @param  show   The show to add to the schedule
     */
    public void setShowing(int index, Show show)
    {
        schedule[index] = show;
    }
    
   
    /**
     * Modifies the Theater's schedule
     *
     * @param  index  The entry to modify
     * @return Show The show at the provided index
     */
    public Show getShowing(int index)
    {
        return schedule[index];
    }
    
   
    /**
     * Updates the schedule to match the provided time
     *
     * @param  date  The time to update to
     */
    public void updateSchedule(Date date)
    {
        if((schedule[0].getDate().equals(new Date (0)) == false) && schedule[0].getDate().before(date)) //has the showing passed?
        {
            for(int i = 0; i < schedule.length - 1; i++)
            {
                schedule[i] = new Show(schedule[i+1].getName(),schedule[i+1].getDescription(),schedule[i+1].getDate()); //shift schedules over
                seats[i] = seats[i+1].clone(); //shift seatings over to match
            }
            schedule[schedule.length - 1] = new Show("Blank","Blank",new Date(0));
            for(int c = 0; c < layout.length; c++)
            {
                seats[schedule.length - 1][c] = this.layout[c].clone();
            }
            updateSchedule(date); //Recursive check in case multiple shows pass
        }
    }
    
    /**
     * Prints the seating chart to the console for the given showing
     * 
     * @param index The index of the showing to print.
     */
    public void printSeating(int index)
    {
        System.out.println("Theater " + name + "'s showing of: " + schedule[index].getName() +
                            " on: " + schedule[index].timeString());
        System.out.print("Row   Col:   "); //formatting
        for(int b = 0; b < seats[index][0].length; b++)
        {
            System.out.print(b + "               ");
        }
        System.out.println(); //New line
        for(int i = 0; i < seats[index].length; i++)
        {
            System.out.print(i + ":    "); //Prints the column index
            for(int a = 0; a < seats[index][i].length; a++)
            {
                System.out.print("[" + seats[index][i][a] + "]"); //Prints the seat in an array
            }
            System.out.println();//New line
        }
        //examples of uniformly sized seats
        //[0-000-000-0000] seat reserved
        //[seat available] empty seat
        //[              ] null seat
    }
    
    /**
     * Returns the name of the theater
     * 
     * @return String The name of the theater
     */
    public String getName()
    {
        return name;
    }
}
