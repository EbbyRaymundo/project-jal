import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Events class will hold the master list of all the Situation objects.
 * Read the nested Situation class below to understand how Situation
 * interacts with other classes in the program.
 */
public class Events {

    private static ArrayList<Situation> situationList; // situation master list

    /**
     * Constructor that creates an empty Events master list
     * that contains no Situation objects.
     * This constructor would only ever be useful if you want to
     * craft your list of Situation objects by hand and add them
     * into the empty situationList.
     */
    public Events() {

        situationList = new ArrayList<Situation>();
    }

    /**
     * Constructor that populates the situationList with a given
     * ArrayList of Situation objects, typically constructed by
     * the readSlimeFile( ) method.
     * 
     * @param newSituationList pre-populated ArrayList of every single Situation within the game.
     */
    public Events(ArrayList<Situation> newSituationList) {

        situationList = newSituationList;
    }

    /**
     * Static factory method that reads a file in the .slime format
     * (a proprietary file format for Jal) to construct and populate
     * an ArrayList of every Situation within the game.
     * 
     * @param filePath to the .slime file
     * @throws Exception from BufferedReader
     */
    public static void readSlimeFile(String filePath) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int numSituations;

        // sitting on first line with number of items, situations, and choices
        String[] line = reader.readLine().trim().split("~");

        if (line.length == 2) { // if there's only 2 params, then there are no items in the game

            numSituations = Integer.parseInt(line[0], 10);
        }

        else {

            int numItems = Integer.parseInt(line[0]); // if 3 params, then numItems is line[0]. Not a necessary var but
                                                      // more clear
            numSituations = Integer.parseInt(line[1], 10); // if there's 3 params, then numSituations is the line[1]

            // we want to advance the reader ahead an amount of lines equal
            // to the Items so that it's sitting on the line just before the
            // first Situation
            for (int i = 0; i < numItems; i++) {

                reader.readLine();
            }
        }

        ArrayList<Situation> masterList = new ArrayList<Situation>(numSituations); // we know what the max capacity MUST be


        // we can now loop through all the situations in the file and construct
        // our Situation objects
        for (int i = 0; i < numSituations; i++) {

            // this line contains the prompt in line[0]
            line = reader.readLine().trim().split("~");

            if (line.length == 1) {
                // if line was of only length 1, then we know it was only the prompt
                // on that line. You can't have a situation without a prompt EVER.
                masterList.add(new Situation(line[0]));
            }

            else if (line.length == 2) { // line[1] could either be the item key or image name

                try { // this attempts to parseInt in case this is an item key

                    masterList.add(new Situation(line[0], Integer.parseInt(line[1])));
                }

                catch (Exception e) { // if it failed, then we know it was actually an image name now

                    masterList.add(new Situation(line[0], line[1]));
                }
            }

            else { // it had 3 entries, a prompt, an item key, and an image name

                masterList.add(new Situation(line[0], Integer.parseInt(line[1], 10), line[2])); // if it wasn't
            }
        }

        new Events(masterList);
        reader.close();
    }

    public static ArrayList<Situation> getSituations( ) {

        return situationList;
    }

    /**
     * To access an item from the fullItemList by its integer key
     * 
     * @param situationKey
     * @return Item at integer key 
     */
    public static Situation getSituation(int situationKey) {

        return situationList.get(situationKey);
    }

    /**
     * Developers don't really have a reason to update the Situation
     * master list using this method, but if for whatever reason
     * you wanted to, here it is.
     *
     * @param newSituation to append to the situationList
     */
    public static void addSituation(Situation newSituation) {
        situationList.add(newSituation);
    }

    /**
     * The Situation object is referenced by the Events
     * situationList using an assigned integer key so that the
     * Situation can be accessed directly using that integer key.
     * Stores data members for the Situation's prompt, the integer
     * keys of the possible Choices within the choiceList of
     * Decisions, and the integer key of the Item within the
     * fullItemList of Inventory that landing on this Situation 
     * grants the player to their playerItemList in Inventory.
     * A Situation will always have at minimum a prompt, and will
     * always create an empty Choice ArrayList of size 4. The
     * choices ArrayList should never exceed 4. You can exceed 4
     * if you do not plan on using the given GUI and instead want
     * to print everything out to the terminal, or extend to GUI
     * to be able to have more Choices.
     */
    public static class Situation {

        private String prompt;
        private ArrayList<Integer> choices;
        private int itemKey; // if you land on the item, you get this in your playerItemList IFF hasItem is true
        private String imageName;

        /**
         * Constructor for when all 3 data fields are provided, meaning
         * that this Situation gives the player an Item and has an
         * associated image.
         *
         * @param prompt text
         * @param itemKey that refers to an Item in the fullItemList in Inventory
         * @param imageName name of image file within the photos/ folder
         */
        public Situation(String prompt, int itemKey, String imageName) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = itemKey;
            this.imageName = imageName;
        }

        /**
         * Constructor for when an itemKey is given
         * meaning that this Situation gives the player an
         * Item, but no associated image. Sets the imageName
         * to a default of "" empty String.
         *
         * @param prompt text
         * @param itemKey that refers to an Item in the fullItemList in Inventory
         */
        public Situation(String prompt, int itemKey) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = itemKey;
            this.imageName = "";
        }

        /**
         * Constructor for when an image is given
         * meaning that this Situation has an associated image
         * but no associated Item. Sets the itemKey to the
         * default of -1.
         *
         * @param prompt text
         * @param imageName name of image file within the photos/ folder
         */
        public Situation(String prompt, String imageName) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = -1;
            this.imageName = imageName;
        }

        /**
         * Constructor for when only a prompt is given,
         * having no associated image or Item. Sets the
         * itemKey to a default of -1 and imageName to
         * a default of "" empty String.
         * 
         * @param prompt
         */
        public Situation(String prompt) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = -1;
            this.imageName = "";
        }

        /**
         * @param newChoices should be of size 4 preferably
         * @return the old ArrayList of choices
         */
        public ArrayList<Integer> setChoices(ArrayList<Integer> newChoices) {

            ArrayList<Integer> oldChoices = this.choices;
            this.choices = newChoices;

            return oldChoices;
        }

        /**
         * ArrayList of integer keys that references the next
         * Choices within the choiceList of Decisions.
         * 
         * @return next Choices integer keys
         */
        public ArrayList<Integer> getChoices( ) {

            return this.choices;
        }

        /**
         * @param n the n'th choice in this Situation's choices
         * @return n'th Choice object
         */
        public Decisions.Choice getNthChoice(int n) {

            return Decisions.getChoice(this.choices.get(n));
        }

        /**
         * Appends the integer choiceKey to the
         * choices.
         *
         * @param choiceKey
         */
        public void addChoice(int choiceKey) {

            this.choices.add(choiceKey);
        }

        /**
         * @return the String prompt
         */
        public String getPrompt() {
            return this.prompt;
        }

        /**
         * @param newPrompt
         * @return the original String prompt
         */
        public String setPrompt(String newPrompt) {
            String oldPrompt = this.prompt;
            this.prompt = newPrompt;

            return oldPrompt;
        }

        /**
         * @param newItemKey integer key of the new Item that this Situation grants the Player in the Inventory playerItemList
         */
        public int setItem(int newItemKey) {

            int oldItemKey = this.itemKey;
            this.itemKey = newItemKey;

            return oldItemKey;
        }

        /**
         * @return true if this item has an item (itemKey != -1), false if this Situation grants nothing
         */
        public boolean hasItem() {

            return !(this.itemKey == -1);
        }

        /**
         * @return the Item of this Situation, using its itemKey on fullItemList
         */
        public Inventory.Item getItem() {

            return Inventory.getItem(this.itemKey);
        }

        /**
         * @return the integer key of the Item that this Situation grants the player
         */
        public int getItemKey() {

            return this.itemKey;
        }

        /**
         * @return true if this Situation has an associated image (imageName != ""), false otherwise
         */
        public boolean hasImage() {

            return !(this.imageName.equals(""));
        }

        /**
         * @return the String imageName associated with this Situation
         */
        public String getImage() {

            return this.imageName;
        }
    }
}