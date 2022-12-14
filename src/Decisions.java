import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Decisions {

    public static ArrayList<Choice> choiceList; // master list of Choice objects

    /**
     * Event constructor that creates an empty Decisons master list
     * that contains no Choice objects.
     */
    public Decisions() {

        choiceList = new ArrayList<Choice>();
    }

    public Decisions(ArrayList<Choice> newChoiceList) {

        choiceList = newChoiceList;
    }

    public static void readSlimeFile(String filePath) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Choice> masterList = new ArrayList<Choice>();
        int numSituations;
        int numChoices;

        // sitting on first line with number of items, situations, and choices
        String[] line = reader.readLine().trim().split("~");

        if (line.length == 2) { // if there's only 2 params, then there are no items in the game

            numSituations = Integer.parseInt(line[0], 10);
            numChoices = Integer.parseInt(line[1], 10);

        }

        else {

            numSituations = Integer.parseInt(line[1], 10);
            numChoices = Integer.parseInt(line[2], 10);

            // we want to advance the reader ahead an amount of lines equal
            // to the Items so that it's sitting on the line just before the
            // first Situation
            for (int i = 0; i < Integer.parseInt(line[0], 10); i++) {

                reader.readLine();
            }
        }

        // both cases (line.length == 2 and line.length == 3) need 
        // to do this step so we'll just do it outside the if statement
        for (int i = 0; i < numSituations; i++) {
            
            reader.readLine();
        }

        // we can now loop through all the choices in the file and construct
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
            //Reaches 
                Events.situationList.get(precedingKey).addChoice(i);
                masterList.add(new Choice(text, followingKey));
            }

            else { // line.length must be 4 in this case, line[3] must be the required item
                int itemKey = Integer.parseInt(line[3]);
                Events.situationList.get(precedingKey).addChoice(i);
                masterList.add(new Choice(text, followingKey, itemKey));

                
            }
        }

        new Decisions(masterList);
        reader.close();
    }
    
    /**
     * Puts a new decision object into the decisions LinkedHashMap using
     * its key 
     * @param choice Choice to append to the LinkedHashMap of Choice objects
     * @return The previous Choice value if key existed, null if a new key
     */
    public static void addChoice(Choice newChoice)
    {
        choiceList.add(newChoice);
    }


    /**
     * Choice subclass stores all the data members of the
     * Choice object. The Choice object is referenced by
     * the Decisions class LinkedHashMap.
     */
    public static class Choice {

        private String text;
        private int nextSituationKey;
        // this will serve as the Item condition for being able to select this Choice
        private int itemKey;

        /**
         * Constructor
         */
        public Choice (String text, int nextSituationKey, int itemKey)
        {
            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.itemKey = itemKey;
        }

        /**
         * Constructor
         */
        public Choice (String text, int nextSituationKey)
        {
            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.itemKey = -1;
        }

        /**
         * @return Choice text
         */
        public String getText( )
        {
            return this.text;
        }

        /**
         * @return next Situation
         */
        public int getNextSituation( )
        {
            return this.nextSituationKey;
        }

        /**
         * @param newText
         * @return the original text
         */
        public String setText(String newText)
        {
            String oldText = this.text;
            this.text = newText;

            return oldText;
        }

        /**
         * @param null
         */
        public int setNextSituation(int newSituationKey)
        {
            int oldSituation = this.nextSituationKey;
            this.nextSituationKey = newSituationKey;

            return oldSituation;
        }

        /**
         * @param null
         */
        public int setItemCondition(int newItemKey)
        {
            int oldItemKey = this.itemKey;
            this.itemKey = newItemKey;

            return oldItemKey;
        }

        /**
         * This method checks if the Choice has a conditonal Item to
         * be able to select it (-1) or if the itemKey is within the
         * player's items.
         */
        public boolean isAvailable() {

            return this.itemKey == -1 || Inventory.getPlayerItems().contains(this.itemKey);
        }
    }
}