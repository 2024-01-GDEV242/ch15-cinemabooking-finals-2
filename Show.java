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
    private String name;
    private Date date;

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
     * @Param name
     */
    public void setName(String name)
    {
        // put your code here
        this.name = name;
    }
    
    /**
     * Gets the name of the show.
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the date of the show.
     * @return date
     */
    public Date getDate()
    {
        return date;
    }
}
