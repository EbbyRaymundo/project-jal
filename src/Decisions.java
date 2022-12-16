import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The Decisions class contains the master list of Choice objects
 * and the nested Choice class.
 * Each Choice object within the choiceList master list of Decisions
 * has an associated integer key which is used to directly access
 * that Choice within choiceList.
 * See the nested Choice class below to see how it interacts with
 * the program.
 */
public class Decisions {

    public static ArrayList<Choice> choiceList; // master list of Choice objects

    /**
     * Constructor that creates an empty Decisions master list
     * that contains no Choice objects.
     * This constructor would only ever be useful if you want to
     * craft your list of Choice objects by hand and add them
     * into the empty choiceList.
     */
    public Decisions() {

        choiceList = new ArrayList<Choice>();
    }

    /**
     * Constructor that populates the choiceList with a given
     * ArrayList of Choice objects, typically constructed by
     * the readSlimeFile( ) method.
     * 
     * @param newChoiceList pre-populated ArrayList of every single Choice within the game.
     */
    public Decisions(ArrayList<Choice> newChoiceList) {

        choiceList = newChoiceList;
    }

    /**
     * Static factory method that reads a file in the .slime format
     * (a proprietary file format for Jal) to construct and populate
     * an ArrayList of every Choice within the game.
     * 
     * @param filePath to the .slime file
     * @throws Exception from BufferedReader
     */
    public static void readSlimeFile(String filePath) throws Exception {

        filePath = "slimeballs/" + filePath;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int numSituations;
        int numChoices;

        // sitting on first line with number of items, situations, and choices
        String[] line = reader.readLine().trim().split("~");

        if (line.length == 2) { // if there's only 2 params, then there are no items in the game

            numSituations = Integer.parseInt(line[0], 10);
            numChoices = Integer.parseInt(line[1], 10);

        }

        else {
            // we must have 3 params if we reach this point, and the game has item
            // lines we need to skip over
            int numItems = Integer.parseInt(line[0], 10);
            numSituations = Integer.parseInt(line[1], 10);
            numChoices = Integer.parseInt(line[2], 10);

            // we want to advance the reader ahead an amount of lines equal
            // to the Items so that it's sitting on the line just before the
            // first Situation
            for (int i = 0; i < numItems; i++) {

                reader.readLine();
            }
        }

        // both cases (line.length == 2 and line.length == 3) need
        // to do this step where we skip the Situation lines
        // so we'll just do it outside the previous if statement
        for (int i = 0; i < numSituations; i++) {

            reader.readLine();
        }

        ArrayList<Choice> masterList = new ArrayList<Choice>(numChoices); // we know what the max capacity MUST be


        // we can now loop through all the Choice lines in the file and construct
        // our Choice objects
        for (int i = 0; i < numChoices; i++) {

            // this line contains the prompt in line[0]
            line = reader.readLine().trim().split("~");

            // regardless of line length, line[0] will be the preceding
            // Situation key, line[1] will be the following Situation key,
            // and line[2] will be the Choice text.
            int precedingKey = Integer.parseInt(line[0]);
            int followingKey = Integer.parseInt(line[1]);
            String text = line[2];

            // in this case, we know line[0] is the preceding Situation key,
            // line[1] is the following Situation key, and line[2] is the
            // choice text
            if (line.length == 3) {
                // Reaches
                Events.situationList.get(precedingKey).addChoice(i);
                masterList.add(new Choice(text, followingKey));
            }

            else { // line.length must be 4 in this case, line[3] must be the required item
                int itemKey = Integer.parseInt(line[3]);
                Events.situationList.get(precedingKey).addChoice(i);
                masterList.add(new Choice(text, followingKey, itemKey));

            }
        }

        new Decisions(masterList); // throw that bad boy into the constructor
        reader.close(); // coding kosher
    }

    /**
     * @param choiceKey integer key within the master list choiceList
     * @return Choice object with integer key choiceKey
     */
    public static Choice getChoice(int choiceKey) {

        return choiceList.get(choiceKey);
    }

    /**
     * @param newChoice Choice to append to the master list of Choice objects
     */
    public static void addChoice(Choice newChoice) {

        choiceList.add(newChoice);
    }

    /**
     * The Choice object is referenced by
     * the Decisions choiceList using an assigned integer
     * key so that the Choice can be accessed directly using
     * that integer key.
     * Stores data members for the Choice's text, the integer
     * key of the next Situation within the situationList of
     * Events, and the integer key of the
     * Item the player must possess to be able to choose
     * this Choice within the fullItemList of Inventory.
     */
    public static class Choice {

        private String text;
        private int nextSituationKey;
        // this will serve as the Item condition for being able to select this Choice
        private int itemKey;

        /**
         * Constructor for when all 3 data fields are provided,
         * meaning that this Choice has an Item condition.
         */
        public Choice(String text, int nextSituationKey, int itemKey) {
            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.itemKey = itemKey;
        }

        /**
         * Constructor for when there's no Item condition
         * for this Choice.
         */
        public Choice(String text, int nextSituationKey) {
            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.itemKey = -1;
        }

        /**
         * @return Choice object's String text
         */
        public String getText() {

            return this.text;
        }

        /**
         * integer key that references the next
         * Situation within the situationList of Events
         * 
         * @return next Situation integer key
         */
        public int getNextSituation() {

            return this.nextSituationKey;
        }

        /**
         * @param newText
         * @return the original Choice String text
         */
        public String setText(String newText) {
            String oldText = this.text;
            this.text = newText;

            return oldText;
        }

        /**
         * Manually sets the next Situation integer
         * key that references the Situation in the
         * situationList of Events
         * 
         * @param newSituationKey
         */
        public int setNextSituation(int newSituationKey) {
            int oldSituation = this.nextSituationKey;
            this.nextSituationKey = newSituationKey;

            return oldSituation;
        }

        /**
         * Manually sets the Item condition integer key
         * that references the corresponding Item object
         * within the fullItemList of Inventory
         * that this Choice requires for the player to
         * be able to select this Choice.
         * 
         * @param newItemKey integer key of the new Item condition
         * @return the old integer key of the Item condition
         */
        public int setItemCondition(int newItemKey) {
            int oldItemKey = this.itemKey;
            this.itemKey = newItemKey;

            return oldItemKey;
        }

        /**
         * This method checks if the Choice has a conditonal Item to
         * be able to select it (itemKey == -1 if no condition) or
         * if the itemKey is within the playerItemList in Inventory.
         * 
         * @return true if the player is allowed to select this Choice, false otherwise
         */
        public boolean isAvailable() {

            return this.itemKey == -1 || Inventory.getPlayerItems().contains(this.itemKey);
        }
    }
}