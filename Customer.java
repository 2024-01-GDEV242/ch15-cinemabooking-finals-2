
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer {
    private int id;
    private String name;
    private String surname;
    private String street;
    private int streetNumber;
    private int post;
    private String city;

    public Customer(int id) {
        this.id = id;
    }
    
    public Customer(int id, String name, String surname, String street, int streetNumber, int post, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.streetNumber = streetNumber;
        this.post = post;
        this.city = city;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public int getStreetNumber() {
        return streetNumber;
    }
    
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
    
    public int getPost() {
        return post;
    }
    
    public void setPost(int post) {
        this.post = post;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void printCustomer() {
        System.out.println(surname + " " + name);
        System.out.println(street + " " + streetNumber);
        System.out.println(post + " " + city);
    }
}

