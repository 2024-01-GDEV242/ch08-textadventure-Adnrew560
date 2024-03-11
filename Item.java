
/**
 * This class is part of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 * 
 * This class handles items in the game, They are located in rooms, some are 
 * native to the player's inventory.
 *
 * @author Andrew Steidle
 * @version 2024.3.10
 */
public class Item
{
    // instance variables - replace the example below with your own
    private double weight; //weight in kg
    private String name; //name of the item
    private Room location; //the room the item is in, null value means the player's inventory
    private String locationText; //where in the room the item is blank means the player's inventory
    private String description; //the item's description
    private boolean pickup; //whether or not the item can be picked up
    private boolean owned; //if the item is picked up or not
    
    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
        name = "";
        weight = 0.0;
        description = "";
        location = null;
        locationText = "";
        pickup = false;
        owned = false;
    }
    
    /**
     * Constructor for objects of class Item from Inventory
     * @param   n - the name of the item
     * @param   x - the weight of the item in kg
     * @param   d - the description of the item
     */
    public Item(String n, double x, String d)
    {
        // initialise instance variables
        name = n;
        weight = x;
        description = d;
        location = null;
        locationText = "";
        pickup = true;
        owned = false;
    }
    
    /**
     * Constructor for objects of class Item in a room
     * @param   n - the name of the item
     * @param   x - the weight of the item in kg
     * @param   d - the description of the item
     * @param   r - the room the item is in
     * @param   l - the description of the item's location within the room
     */
    public Item(String n, double x, String d, Room r, String l,boolean p)
    {
        // initialise instance variables
        name = n;
        weight = x;
        description = d;
        location = r;
        locationText = l;
        pickup = p;
        owned = false;
    }

    /**
     * @return    the weight of the item
     */
    public double getWeight()
    {
        return weight;
    }
    
    /**
     * @return    the name of the item
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return    the location of the item
     */
    public Room getLocation()
    {
        return location;
    }
    
    /**
     * @param     full - whether or not to include the room the item is in
     * @return    the description of the item's location
     */
    public String getLocationText(boolean full)
    {
        if(full)
        {
            return locationText + " of " + location.getLocationString();
        }
        return locationText;
    }
    
    /**
     * @return    the description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @param    x - the weight of the item in kg
     */
    public void setWeight(double x)
    {
        weight = x;
    }
    
    /**
     * @param    str - the name of the item
     */
    public void setName(String str)
    {
        name = str;
    }
    
    /**
     * @param    str - the description of the item
     */
    public void setDescription(String str)
    {
        description = str;
    }
    
    /**
     * @param    r - the room the item is in
     * @param    str - the description of the item's location
     */
    public void setLocation(Room r, String str)
    {
        location = r;
        locationText = str;
    }
    
    /**
     * @return   true if the item can be picked up by the player
     */
    public boolean checkPickup()
    {
        return pickup;
    }
    
    /**
     * @return   true if the item is not flagged as owned, and then flags it as owned 
     */
    public boolean pickup()
    {
        if(owned)
        {
            return false;
        }
        owned = true;
        return true;
    }
}
