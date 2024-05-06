import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * The Show class represents a movie that is in a Theater's schedule.
 *
 * @author Collie Clarke and Andrew Steidle
 * @version    2024.5.5
 */
public class Show
{
    // instance variables - replace the example below with your own
    private String name; //The name of the show
    private String description; //The description of the show
    private Date date; //The date the show starts

    /**
     * Constructor for objects of class Show
     */
    public Show(String name, String description, Date date)
    {
        // initialise instance variables
        this.name = name;
        this.description = description;
        this.date = date;
    }

    /**
     * Sets the name of the show.
     * @param name the name of the show.
     */
    public void setName(String name)
    {
        // put your code here
        this.name = name;
    }
    
    /**
     * Sets the name of the show.
     * @param description the show's description.
     */
    public void setDescription(String description)
    {
        // put your code here
        this.description = description;
    }
    
    /**
     * Gets the name of the show.
     * @return String the name of the show
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the name of the show.
     * @return String the show's description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Gets the date of the show.
     * 
     * @return Date the date the show starts
     */
    public Date getDate()
    {
        return date;
    }
    
    /**
     * Changes the date of the show.
     * 
     * @param date the date the show starts
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    /**
     * Returns the date of the showing as a string.
     * 
     * @return String The date and time of the showing in MDY 12 Hour format.
     */
    public String timeString()
    {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        String hour = "" + c.get(Calendar.HOUR);
        if(c.get(Calendar.HOUR) == 0)
        {
            hour = "12";
        }
        String period = "PM";
        if(c.get(Calendar.AM_PM) == 0) 
        {
            period = "AM";
        }
        String min = "" + c.get(Calendar.MINUTE); // :0x for minutes less than 10
        if(c.get(Calendar.MINUTE) < 10)
        {
            min = "0" + min;
        }
        String value = c.get(Calendar.DAY_OF_MONTH) + "/" + 
        (c.get(Calendar.MONTH) + 1) + "/" + //+1 beacuse January is 0 for some reason
        c.get(Calendar.YEAR) + " at " + hour + ":" + min + " " + period;
        return value;
    }
}
