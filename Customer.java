
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    int id;
    String name;
    String surname;
    String street;
    int streetNumber;
    int plz;
    String city;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(int id)
    {
        // initialise instance variables
        this.id = id;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public void setStreet(String street)
    {
        this.street = street;
    }
    
    public void setStreetNumber(int streetNumber)
    {
        this.streetNumber = streetNumber;
    }
    
    public void setPLZ(int plz)
    {
        this.plz = plz;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void printCostumer()
    {
        System.out.print(surname + " " + name);
	System.out.println(street + " " + streetNumber);
	System.out.println(plz + " " + city);
    }
}
