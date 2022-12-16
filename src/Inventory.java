import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class Inventory {

    // We could use a linked list instead here if we were to be more readily
    // removing items but at the moment we are using an ArrayList. We currently
    // do not plan to remove items in our implementation
    public static ArrayList<Item> fullItemList;
    public static ArrayList<Integer> playerItemList;

    /**
     * Default constructor to create an empty player Inventory
     * and an empty Item master list. Helpful for handcrafting them
     * or something but mostly useful if you want to run a game
     * that doesn't use any items.
     */
    public Inventory() {

        fullItemList = new ArrayList<Item>();
        playerItemList = new ArrayList<Integer>();
    }

    /**
     * Constructor that populates the fullItemList with a given
     * ArrayList of Item objects, typically constructed by
     * the readSlimeFile( ) method. Sets an empty player
     * fullItemList with no starting Items.
     * 
     * @param allItems pre-populated ArrayList of every single Item within the game.
     */
    public Inventory(ArrayList<Item> allItems) {

        fullItemList = allItems;
        playerItemList = new ArrayList<Integer>();

    }

    /**
     * Constructor that populates the fullItemList with a given
     * ArrayList of Item objects, typically constructed by
     * the readSlimeFile( ) method. Sets the playerItemList
     * to have starting Items as well.
     * 
     * @param allItems pre-populated ArrayList of every single Item within the game
     * @param startingItems pre-populated ArrayList of starting Items for the player
     */
    public Inventory(ArrayList<Item> allItems, ArrayList<Integer> startingItems) {

        fullItemList = allItems;
        playerItemList = startingItems;
    }

    /**
     * Static factory method that reads a file in the .slime format
     * (a proprietary file format for Jal) to construct and populate
     * an ArrayList of every Item within the game.
     * 
     * @param filePath to the .slime file
     * @throws Exception from BufferedReader
     */
    public static void readSlimeFile(String filePath) throws Exception {

        filePath = "slimeballs/" + filePath;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int numItems;

        // sitting on first line with number of items, situations, and choices
        String[] line = reader.readLine().trim().split("~");

        if (line.length == 2) { // if there's only 2 params, then there are no items in the game
            new Inventory();
            reader.close();
            return;
        }

        numItems = Integer.parseInt(line[0], 10); // line[0] must be the number of items if we reached this point
        ArrayList<Item> masterList = new ArrayList<Item>(numItems);

        for (int i = 0; i < numItems; i++) {

            // this line contains the item name in line[0] and the item
            // description in line[1]
            line = reader.readLine().trim().split("~");
            masterList.add(new Item(line[0], line[1]));
        }

        new Inventory(masterList);
        reader.close();
    }

    /**
     * @param itemKey integer key within the master list fullItemList
     * @return Item object with integer key itemKey
     */
    public static Item getItemFromFullList(int itemKey) {

        return fullItemList.get(itemKey);
    }

    /**
     * @return The current playerItemList that contains the integer keys of the Items they currently possess
     */
    public static ArrayList<Integer> getPlayerItems() {

        return playerItemList;
    }

    /**
     * @param newItem Item to append to the master list of Item objects fullItemList
     */
    public static void addItem(Item newItem) {

        fullItemList.add(newItem);
    }

    /**
     * @param itemKey integer key of the Item in fullItemList to append to the player's current inventory playerItemList
     */
    public static void addPlayerItem(int itemKey) {

        playerItemList.add(itemKey);
    }

    /**
     * The Item object is referenced by
     * the Inventory fullItemList using an assigned integer
     * key so that the Choice can be accessed directly using
     * that integer key.
     * Stores data members for the Item's name and
     * description
     */
    public static class Item {

        private String name;
        private String description;

        /**
         * Constructor that is the only one available since you are
         * not allowed to make an Item without a name and description,
         * and has no optional data members.
         *
         * @param name of the Item
         * @param description of the Item
         */
        public Item(String name, String description) {

            this.name = name;
            this.description = description;
        }

        /**
         * @return Item name
         */
        public String getName() {

            return this.name;
        }

        /**
         * @return Item description
         */
        public String getDescription() {

            return this.description;
        }

        /**
         * @param newName to replace the original name with
         * @return the original name
         */
        public String setName(String newName) {

            String oldName = this.name;
            this.name = newName;

            return oldName;
        }

        /**
         * @param newDescription to replace the original description with
         * @return the original description
         */
        public String setDescription(String newDescription) {

            String oldDescription = this.description;
            this.description = newDescription;

            return oldDescription;
        }
    }
}