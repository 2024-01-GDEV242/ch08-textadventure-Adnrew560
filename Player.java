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

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        health = 10;
    }

    /**
     * @return    the health of the player
     */
    public int getHealth()
    {
        // put your code here
        return health;
    }
    
    /**
     * @param    x - the new health of the player
     */
    public void setHealth(int x)
    {
        // put your code here
        health = x;
    }
}
