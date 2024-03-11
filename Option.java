
/**
 * This class is the main class of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 *
 * @author Andrew Steidle
 * @version 2024.3.10
 */
public class Option
{
    // instance variables - replace the example below with your own
    private String name;
    private String dialogue;

    /**
     * Constructor for objects of class Option
     */
    public Option(String n, String d)
    {
        // initialise instance variables
        name = n;
        dialogue = d;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printDialogue()
    {
        // put your code here
        System.out.println(dialogue);
    }
}
