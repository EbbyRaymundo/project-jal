
/**
 * Class to manage the Player. At the moment, this
 * class is not necessary to the model's logic but
 * if anyone ever wanted to expand upon Jal's engine,
 * this could be easily done by adding data members
 * to the player class.
 */

public class Player {

    private static String name;

    /**
     * Constructor for when you create a Player object.
     *
     * @param playerName
     */
    public Player(String playerName)
    {
        name = playerName;
    }

    /**
     * @return the player name
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