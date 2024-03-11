import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Andrew Steidle
 * @version 2024.03.10
 */

public class Room 
{
    private String description;
    private String name;
    private String locationString;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private NPC activeNPC;                      //the current NPC that is active in the room
    private ArrayList<Item> items;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name, String description) 
    {
        this.description = description;
        items = new ArrayList<Item>();
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Define an name for this room.
     * @param name The name of the room.
     * @param locationDescription the way the room is described as a location.
     * Same set method since a change to one necessitates a change to the other
     */
    public void setName(String str, String locationStr) 
    {
        name = str;
        locationString = locationStr;
    }
    
    public void setActiveNPC(NPC n)
    {
        activeNPC = n;
    }
    
    public void addItem(Item i)
    {
        items.add(i);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + "." + getItemString() + getNPCString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * Return a string describing the room's items, for example
     * "There is a shovel, an apple.".
     * @return Details of the room's items.
     */
    private String getItemString()
    {
        String returnString = "";
        if(items.size() > 0)
        {
            returnString = "\nThere is ";
            for(Item a : items) 
            {
                char b = a.getLocationText(false).charAt(0); //the first letter of the item's name
                if(b == 'a' || b == 'e' || b == 'i'  || b == 'o'|| b == 'u') //choose a or an
                {
                    returnString += "an " + a.getLocationText(false) + ", ";
                } else
                {
                    returnString += "a " + a.getLocationText(false) + ", ";
                }
            }
            return returnString.substring(0,returnString.length() - 2) + ".";
        }
        return "";
    }
    
    /**
     * Return a string describing the room's NPC, for example
     * "Timothy is here".
     * @return Details of the room's NPC.
     */
    private String getNPCString()
    {
        if(activeNPC == null)
        {
            return "";
        }
        return "\n" + activeNPC.getName() + " is here";
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Return the item that is examined if we search thir room for selection
     * "selection". If there is no item of that name, return null.
     * @param selection The selected item.
     * @return The item selected.
     */
    public Item getItem(String selection) 
    {
        for(Item i : items)
        {
            if(i.getName().toLowerCase().equals(selection.toLowerCase()))
            {
                return i;
            }
        }
        return null;
    }
    
    /**
     * Return the name of the room
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the string to append a sentence with the room as a location
     * Ex: The broom is located on the right side * of the kitchen *
     */
    public String getLocationString()
    {
        return locationString;
    }
    
    public NPC getActiveNPC()
    {
        return activeNPC;
    }
}

