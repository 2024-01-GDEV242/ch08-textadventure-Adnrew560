import java.util.ArrayList;
/** 
 * This class is the main class of the "Very Original Murder Mystery" application.
 * "Very Original Murder Mystery" is a simple, and very definitely original game
 * not at all derivative of Capcom's "Ace Attorney" series, which is completely
 * coincedentially the closest thing to a text adventure game I've ever played.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Andrew Steidle
 * @version 2024.03.10
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Room> path; //the path the player took to get to the room
    private Player p1; //the player
    private boolean talking;
    public static final int LINE_LENGTH = 50; //Will be implemented later, fixes text format
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        path = new ArrayList<Room>();
        p1 = new Player();
        talking = false;
    }
    
    public static void main(String[] args)
    {
        Game a = new Game();
        a.play();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside","outside the main entrance of the university");
        theater = new Room("theater","in a lecture theater");
        pub = new Room("pub","in the campus pub");
        lab = new Room("lab","in a computing lab");
        office = new Room("office","in the computing admin office");
        
        
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.addItem(new Item("Shovel",10.0,
        "An iron shovel with a wooden handle, covered in rust",
        outside,"shovel laying on the shed", true));
        outside.addItem(new Item("Apple",1.0,
        "It's a fuji apple, it has rotted, inedible.",
        outside,"apple that fell from a nearby tree", false));

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
    }

    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Very Original Murder Mystery!");
        System.out.println("Very Original Murder Mystery is a new, incredibly original adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            //Movement
            case HELP:
                printHelp();
                break;

            case GO:
                if(talking)
                {
                    System.out.println("It's rude to leave mid conversation!");
                } 
                else 
                {
                    goRoom(command);
                }
                break;
                
            case LOOK:
                look();
                break;
                
            case BACK:
                if(talking)
                {
                    System.out.println("It's rude to leave mid conversation!");
                } 
                else 
                {
                    if(path.size() == 0)
                    {
                        System.out.println("You cannot go back.");
                    } 
                    else 
                    {
                        goRoom(path.get(path.size() -1));
                        //teleport method does not print for the sake of other use cases
                        System.out.println(currentRoom.getLongDescription());
                    }
                }
                break;
                
            //Item related
            case INVENTORY:
                p1.printInventory();
                break;
            
            case EXAMINE:
                examine(command);
                break;
                
            //NPC related
            case TALK:
                talk(command);
                break;
                
            case PRESENT:
                break;
                
            //Misc.
            case EAT:
                System.out.println("I do indeed like food, you eat a bowl of noodles");
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            path.add(currentRoom);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    /** 
     * Examine an item and print its description.
     */
    private void examine(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Examine which item?");
            return;
        }

        String selection = command.getSecondWord();
        //I will make both getItem / findItem methods work the same way later
        Item a = currentRoom.getItem(selection);
        
        if (a == null) //The item is not in the room
        {
            int b = p1.findItem(selection);
            if(b == -1) //The item is in another room, or does not exist
            {
                System.out.println("There is no " + selection + "!");
            } 
            else //The item is in the player's inventory
            {
                a = p1.readItem(b);
                System.out.println(a.getDescription());
            }
        }
        else //The item is in the room
        {
            System.out.println(a.getDescription());
            if(a.checkPickup()) //Check if the item can be picked up
            {
                if(a.pickup()) //Pick up the item if it hasn't been already
                {
                    p1.addItem(a);
                    System.out.println(a.getName() + " has been added to your inventory");
                }
            }
        }
    }
    
    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void talk(Command command) 
    {
        
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            path.add(currentRoom);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    /**
     * Teleports the player to a room, instead of using a direction, does not print anything
     * so it can be used in scripted events
     * @param r - the room to go to
     */
    private void goRoom(Room r)
    {
        path.remove(path.size() - 1);
        currentRoom = r;
    }

    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
