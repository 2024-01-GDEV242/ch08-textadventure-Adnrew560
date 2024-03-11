import java.util.ArrayList;
/**
 * This class is the main class of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 *
 * @author Andrew Steidle
 * @version 2024.3.10
 */
public class NPC
{
    // instance variables - replace the example below with your own
    private ArrayList<String> options;  //Dialogue options

    /**
     * Constructor for objects of class NPC
     */
    public NPC()
    {
        // initialise instance variables
        options = new ArrayList<String>();
    }

    /**
     * Change the dialogue options of an NPC
     *
     * @param  list  The list of options
     * 
     */
    public void setOptions(ArrayList<String> list)
    {
        // put your code here
        options = list;
    }
    
    /**
     * Read the dialogue options of an NPC
     *
     * @return  The list of options
     * 
     */
    public ArrayList<String> getOptions()
    {
        return options;
    }
    
    /**
     * Print the dialogue options of an NPC
     */
    public void printOptions()
    {
        String returnString = ""; 
        for(String a : options)
        {
            returnString += a + " ";
        }
        System.out.println(returnString + ".");
    }
}
