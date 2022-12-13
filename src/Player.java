
/**
 * Class to manage and the player
 */

public class Player {

    private static int karma;
    private static String name;

    /**
     * Constructor
     */
    public Player(String playerName)
    {
        karma = 0;
        name = playerName;
    }


    /**
     * @return player karma
     */
    public static int getKarma()
    {
        return karma;
    }

    /**
     * @return player name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param value Can be a positive or negative value.
     */
    public static int addKarma(int value)
    {
        karma += value;

        return karma;
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