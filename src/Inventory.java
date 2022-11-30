import java.util.ArrayList; // There may be items that have different names but the same descriptions
import java.util.List;

//import javax.print.Doc; // Why is this line even here???

public class Inventory {

    // We could use a linked list instead here if we were to be more readily
    // removing items but at the moment we are using an array list 
    private ArrayList<Item> items;

    public Inventory() {

        this.items = new ArrayList<Item>();
    }

    // @TODO: add a constructor that lets the user construct Inventory
    // using List<Item> as input. Would be goofy to give them a method
    // that does is since they could just overwrite the entire
    // Inventory by doing so. Should make a more deliberate method
    // such as clearInventory().

    /**
     * Constructor that uses the List<Item> input as the Player Inventory.
     * @param items List of Item objects
     */
    public Inventory(List<Item> items) {

        this.items = (ArrayList<Inventory.Item>) items;
    }

    /**
     * Read the method
     * @return The current Inventory
     */
    public List<Item> getItems() {

        return this.items;
    }
    
    /**
     * 
     * @param item Item object
     */
    public void addItem(Item item) {

        this.items.add(item);
    }

    public void removeItem(Item item) {

        this.items.remove(item);

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
        public Item ()
        {
            this.name = "";
            this.description = "";
        }
    
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
         * @param null
         */
        public String setName(String newName)
        {
            this.name = newName;
    
            return this.name;
        }
        /**
         * @param null
         */
        public String setDescription(String newDescription)
        {
            this.description = newDescription;
    
            return this.description;
        }
    }
}