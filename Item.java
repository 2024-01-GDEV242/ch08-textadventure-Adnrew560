
/**
 * This class is part of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 * 
 * This class handles items in the game, They are located in rooms, some are 
 * native to the player's inventory.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private double weight; //weight in kg
    private String name;
    private String description;
    
    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
        name = "";
        weight = 0.0;
        description = "";
    }

    /**
     * @return    the weight of the item
     */
    public double getWeight()
    {
        // put your code here
        return weight;
    }
    
    /**
     * @return    the name of the item
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * @return    the description of the item
     */
    public String getDescription()
    {
        // put your code here
        return description;
    }
    
    /**
     * @return    the weight of the item
     */
    public void setWeight(double x)
    {
        // put your code here
        weight = x;
    }
    
    /**
     * @return    the name of the item
     */
    public void setName(String str)
    {
        // put your code here
        name = str;
    }
    
    /**
     * @return    the description of the item
     */
    public void setDescription(String str)
    {
        // put your code here
        description = str;
    }
}
