
/**
 * Class to manage and the player
 */

public class Player {

    private int karma;

    private String name;

    private Inventory inventory;

    /**
     * Constructor
     */
    public Player(String name)
    {
        this.karma = 0;
        this.name = name;
        this.inventory = new Inventory();
    }

    public Player(String name, Inventory inventory) {

        this.karma = 0;
        this.name = name;
        this.inventory = inventory;
        
    }

    /**
     * @return player karma
     */
    public int getKarma()
    {
        return this.karma;
    }

    /**
     * @return player name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return player Inventory
     */
    public Inventory getInventory()
    {
        return this.inventory;
    }

    /**
     * @param null
     */
    public int addKarma(int value)
    {
        this.karma += value;

        return this.karma;
    }

    /**
     * @param null
     */
    public String setName(String name)
    {
        this.name = name;

        return this.name;
    }

    /**
     * @param null
     */
    public Inventory addToInventory(Inventory.Item item)
    {
        this.inventory.addItem(item);

        return this.inventory;
    }

    /**
     * @param null
     */
    public Inventory removeFromInventory(Inventory.Item item)
    {
        this.inventory.removeItem(item);

        return this.inventory;
    }

}