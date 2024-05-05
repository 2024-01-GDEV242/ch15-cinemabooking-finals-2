import java.util.Date;
/**
 * Write a description of class Show here.
 *
 * @author Collie Clarke
 * @version    2024.4.29
 */
public class Show
{
    // instance variables - replace the example below with your own
    private String name; //The name of the show
    private Date date; //The date the show starts

    /**
     * Constructor for objects of class Show
     */
    public Show(String name, Date date)
    {
        // initialise instance variables
        this.name = name;
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
     * Gets the name of the show.
     * @return the name of the show
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the date of the show.
     * @return the date the show starts
     */
    public Date getDate()
    {
        return date;
    }
}
