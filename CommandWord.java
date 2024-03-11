/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Andrew Steidle
 * @version 2024.03.10
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"), BACK("back"), TALK("talk"), 
    INVENTORY("inventory"), EXAMINE("examine"), PRESENT("present"), STATS("stats"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
