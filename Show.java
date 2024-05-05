import java.util.Date;
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
     * Date has no mutator because changing it while in use can make things explode.
     * @return Date the date the show starts
     */
    public Date getDate()
    {
        return date;
    }
}
