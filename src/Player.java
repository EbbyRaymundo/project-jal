public class Player {

    private int karma;

    private String name;

    private Inventory inventory;

    public Player()
    {
        this.karma = -1;
        this.name = "";
        this.inventory = new Inventory();
    }

    public static int getKarma()
    {
        return -1;
    }

    public static String getName()
    {
        return null;
    }

    public static Inventory getInventory()
    {
        return null;
    } 
}