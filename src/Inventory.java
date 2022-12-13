import java.util.ArrayList;

public class Inventory {

    // We could use a linked list instead here if we were to be more readily
    // removing items but at the moment we are using an array list. We currently
    // do not plan to remove items in our implementation
    private static ArrayList<Item> fullItemList;
    private static ArrayList<Integer> playerItemList;

    /**
     * Default constructor to create an empty player Inventory
     * and an empty Item master list.
     */
    public Inventory() {

        fullItemList = new ArrayList<Item>();
        playerItemList = new ArrayList<Integer>();
    }

    public Inventory(ArrayList<Item> allItems) {

        fullItemList = allItems;
    }

    /**
     * Constructor that uses the provided ArrayList of items
     * to start the player with. Must provide the corresponding
     * fullItemList to know what they correspond to
     * @param items List of Item objects
     */
    public Inventory(ArrayList<Item> allItems, ArrayList<Integer> startingItems) {

        fullItemList = allItems;
        playerItemList = startingItems;
    }

    /**
     * To retrieve an item from the fullItemList by its integer key
     * @return Item at index i
     */
    public Item getItemFromFullList(int i) {

        return fullItemList.get(i);
    }

    /**
     * Read the method
     * @return The current Inventory
     */
    public static ArrayList<Integer> getPlayerItems() {

        return playerItemList;
    }
    
    /**
     * @param item Item object
     */
    public void addItem(Item newItem) {

        fullItemList.add(newItem);
    }

    public Item removeItem(int itemKey) {

        return fullItemList.remove(itemKey);

    }

    public void addPlayerItem(int itemKey) {

        playerItemList.add(itemKey);
    }

    /**
     * Create a nested Item class here. Going to rework so that
     * you should only be managing and adding items through
     * calls to the inventory class. This makes sense in my head
     * so this is what we're going with.
     */
    public class Item {

        private String name;
        private String description;
    
        /**
         * Constructor
         */
        public Item (String name, String description)
        {
            this.name = name;
            this.description = description;
        }
        
        /**
         * @return Item name
         */
        public String getName()
        {
            return this.name;
        }
        
        /**
         * @return Item description
         */
        public String getDescription() 
        {
            return this.description;
        }
    
        /**
         * @param newName
         */
        public String setName(String newName)
        {
            String oldName = this.name;
            this.name = newName;
    
            return oldName;
        }

        /**
         * @param null
         */
        public String setDescription(String newDescription)
        {
            String oldDescription = this.description;
            this.description = newDescription;
    
            return oldDescription;
        }
    }
}