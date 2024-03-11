import java.util.ArrayList;
/**
 * This class is part of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 *
 * @author Andrew Steidle
 * @version 2024.03.10
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int health;
    private ArrayList<Item> inventory;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        health = 10;
        inventory = new ArrayList<Item>();
    }

    /**
     * @return    the health of the player
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * @return    the item at index i in inventory
     */
    public Item readItem(int i)
    {
        return inventory.get(i);
    }
    
    /**
     * @param    x - the new health of the player
     */
    public void setHealth(int x)
    {
        health = x;
    }
    
    /**
     * @param   i - the item to add to the inventory
     */
    public void addItem(Item i)
    {
        inventory.add(i);
    }
    
    /**
     * Prints the inventory
     */
    public void printInventory()
    {
        for(Item i : inventory)
        {
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }
    
    /**
     * Returns the index of the item with the provided name
     */
    public int findItem(String n)
    {
        for(int i = 0; i < inventory.size(); i++)
        {
            if(inventory.get(i).getName().toLowerCase().equals(n.toLowerCase()))
            {
                return i;
            }
        }
        return -1;
    }
    
    public double getWeight()
    {
        double result = 0;
        for(int i = 0; i < inventory.size(); i++)
        {
            result += inventory.get(i).getWeight();
        }
        return result;
    }
}
