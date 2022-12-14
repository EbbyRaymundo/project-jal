import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Events class will hold the master list of all the Situation objects.
 * A Situation object in the eventList will point to its corresponding
 * Choice objects in the Decisions class master list. Situations have
 * a unique integer key (these are assigned by the developer when
 * mapping our their game paths), hence the use of an ArrayList in the
 * master list for Events.
 */
public class Events {

    public static ArrayList<Situation> situationList; // the String key will represent the name of the eventInMap

    /**
     * Event constructor that creates an empty Events master list
     * that contains no Event objects.
     */
    public Events() {

        situationList = new ArrayList<Situation>();
    }

    public Events(ArrayList<Situation> newSituationList) {

        situationList = newSituationList;
    }

    public static void readSlimeFile(String filePath) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Situation> masterList = new ArrayList<Situation>();
        int numSituations;

        // sitting on first line with number of items, situations, and choices
        String[] line = reader.readLine().trim().split("~");

        if (line.length == 2) { // if there's only 2 params, then there are no items in the game

            numSituations = Integer.parseInt(line[0], 10);
        }

        else {

            int numItems = Integer.parseInt(line[0]); // if 3 params, then numItems is line[0]. Not a necessary var but more clear
            numSituations = Integer.parseInt(line[1], 10); // if there's 3 params, then numSituations is the line[1]

            // we want to advance the reader ahead an amount of lines equal
            // to the Items so that it's sitting on the line just before the
            // first Situation
            for (int i = 0; i < numItems; i++) {

                reader.readLine();
            }
        }

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

    /**
     * To retrieve an item from the fullItemList by its integer key
     * 
     * @return Item at index i
     */
    public static Situation getSituationFromFullList(int i) {

        return situationList.get(i);
    }

    /**
     * @param newSituation
     */
    public static void addSituation(Situation newSituation) {
        situationList.add(newSituation);
    }

    /**
     * Situation subclass stores the prompt and Choice List of the
     * Situation object. The Situation object is referenced by the
     * Events class LinkedHashMap.
     */
    public static class Situation {

        private String prompt;
        private ArrayList<Integer> choices;
        private int itemKey; // if you land on the item, you get this IFF hasItem is true
        private String imageName;

        public Situation(String prompt, int itemKey, String imageName) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = itemKey;
            this.imageName = imageName;

        }

        public Situation(String prompt, int itemKey) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = itemKey;
            this.imageName = "";
        }

        public Situation(String prompt, String imageName) {

            this.prompt = prompt;
            this.choices = new ArrayList<Integer>(4);
            this.itemKey = -1;
            this.imageName = imageName;
        }

        /**
         * Event constructor that creates an Event with a prompt but
         * doesn't point to any Decisions. The LinkedHashMap situations is
         * hard coded to have a max of 4 Choice objects since the GUI will
         * only have 4 buttons. It uses the default load factor of 0.75.
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
         * @param decisions Needs to be of size 4
         * @return The newly added Choice integer keys
         */
        public ArrayList<Integer> setChoices(ArrayList<Integer> newChoices) {

            ArrayList<Integer> oldChoices = this.choices;
            this.choices = newChoices;

            return oldChoices;
        }

        public ArrayList<Integer> getChoices() {

            return this.choices;
        }

        /**
         *
         * @param choice
         */
        public void addChoice(int choiceKey) {

            this.choices.add(choiceKey);
        }

        // may not actually be relevant
        // /**
        // *
        // * @param choice
        // */
        // public void removeChoice(Decisions.Choice choice){

        // this.decisions.remove(choice);

        // }

        /**
         * 
         * @return prompt string of the Situation object
         */
        public String getPrompt() {
            return this.prompt;
        }

        /**
         * 
         * @param newPrompt
         * @return the original prompt
         */
        public String setPrompt(String newPrompt) {
            String oldPrompt = this.prompt;
            this.prompt = newPrompt;

            return oldPrompt;
        }

        public int setItem(int newItemKey) {

            int oldItemKey = this.itemKey;
            this.itemKey = newItemKey;

            return oldItemKey;
        }

        public boolean hasItem() {

            return !(this.itemKey == -1);
        }

        public int getItem() {

            return this.itemKey;
        }

        public boolean hasImage() {

            return !(this.imageName.equals(""));
        }

        public String getImage() {

            return this.imageName;
        }
    }
}