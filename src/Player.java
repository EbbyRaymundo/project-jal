
/**
 * Class to manage and the player
 */

public class Player {

    private static String name;

    /**
     * Constructor
     */
    public Player(String playerName)
    {
        name = playerName;
    }

    /**
     * @return player name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param newName
     * @return the old player name
     */
    public String setName(String newName)
    {
        String oldName = name;
        name = newName;

        return oldName;
    }
}