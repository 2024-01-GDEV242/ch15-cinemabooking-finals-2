import java.util.Date;
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
    private Date date;

    /**
     * Constructor for objects of class Show
     */
    public Show(String showName, Date date)
    {
        // initialise instance variables
        this.showName = showName;
    }

    /**
     *
     */
    public void setShow(String showName)
    {
        // put your code here
        this.showName = showName;
    }
    
    public String getShow()
    {
        return showName;
    }
}
