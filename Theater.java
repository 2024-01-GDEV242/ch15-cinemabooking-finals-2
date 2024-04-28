
/**
 * Write a description of class Theater here.
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
    //Private Show[] schedule; (will add once others are done)
    /**
     * Constructor for objects of class Theater
     */
    public Theater(String name, int[][] layout, int maxShowings)
    {
        // initialise instance variables
        this.name = name;
        seats = new String[maxShowings][layout.length][layout[0].length];
        for(int a = 0; a < layout.length; a++)
        {
            for(int b = 0; b < layout[0].length; b++)
            {
                if(layout[a][b] == 0) //null seat
                {
                    seats[0][a][b] = "null";
                } else
                {
                    seats[0][a][b] = "";
                }
            }
        }
        this.layout = seats[0];
        for(int i = 0; i < maxShowings; i++)
        {
            seats[i] = this.layout;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return 0;
    }
}
