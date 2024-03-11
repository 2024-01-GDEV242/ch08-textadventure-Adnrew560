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
    private String name;    //The NPC's name
    private ArrayList<Option> options;  //Dialogue options
    
    /**
     * Constructor for objects of class NPC
     */
    public NPC(String n)
    {
        // initialise instance variables
        name = n;
        options = new ArrayList<Option>();
    }

    /**
     * Change the dialogue options of an NPC
     *
     * @param  list  The list of options
     * 
     */
    public void setOptions(ArrayList<Option> list)
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
    public ArrayList<Option> getOptions()
    {
        return options;
    }
    
    /**
     * Find a dialogue option from an NPC
     *
     * @return  The option, or null
     * 
     */
    public Option findOption(String str)
    {
        for(Option a : options)
        {
            if(a.getName().toLowerCase().equals(str.toLowerCase()))
            {
                return a;
            }
        }
        return null;
    }
    
    /**
     * Read the name of an NPC
     *
     * @return  The name of the NPC
     * 
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Print the dialogue options of an NPC
     */
    public void printOptions()
    {
        String returnString = ""; 
        for(Option a : options)
        {
            returnString += a.getName() + " ";
        }
        System.out.println(returnString + ".");
    }
}
