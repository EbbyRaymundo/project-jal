import java.util.Arrays;
import java.util.ArrayList;

/**
 * Events class will hold the master list of all the Event objects.
 * A Situation object in the eventList will point to its corresponding
 * Choice objects in the Decisions class master list. Situations have
 * a unique integer key (these are assigned by the developer when
 * mapping our their game paths), hence the use of an ArrayList in the 
 * master list for Events.
 */
public class Events {

    private static ArrayList<Situation> situationList; // the String key will represent the name of the eventInMap

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

    public static void readSlimeFile(String filePath) {


    }
    /**
     * @param newSituation
     */
    public static void addSituation(Situation newSituation)
    {
        situationList.add(newSituation);
    }

    /**
     * The developer should maintain the integer key
     * that corresponds to each Situation.
     * @param situationInList
     * @return The 
     */
    public static Situation removeSituation(int situationKey)
    {
        return situationList.remove(situationKey);
    }

    /**
     * Situation subclass stores the prompt and Choice List of the
     * Situation object. The Situation object is referenced by the
     * Events class LinkedHashMap.
     */
    public static class Situation {

        private String prompt;
        private int[] choices;
        private int itemKey; // if you land on the item, you get this IFF hasItem is true

        /**
         * Event constructor that creates an Event with a prompt but
         * doesn't point to any Decisions. The LinkedHashMap situations is
         * hard coded to have a max of 4 Choice objects since the GUI will
         * only have 4 buttons. It uses the default load factor of 0.75.
         * @param prompt
         */
        public Situation(String prompt)
        {
            this.choices = new int[4];
            Arrays.fill(this.choices, -1);
            this.prompt = prompt;
            this.itemKey = -1;
        }

        /**
         * @param decisions Needs to be of size 4
         * @return The newly added Choice integer keys
         */
        public int[] setChoices(int[] newChoices){

            int[] oldChoices = this.choices;
            this.choices = newChoices;

            return oldChoices;
        }

        // may not actually be relevant
        // /**
        //  * 
        //  * @param choice
        //  */
        // public void addChoice(int choice){

        //     this.decisions.add(choice);
        // }

        // may not actually be relevant
        // /**
        //  * 
        //  * @param choice
        //  */
        // public void removeChoice(Decisions.Choice choice){

        //     this.decisions.remove(choice);

        // }
        

        /**
        * 
        * @return prompt string of the Situation object
        */
        public String getPrompt()
        {
            return this.prompt;
        }

        /**
         * 
         * @param newPrompt
         * @return the original prompt
         */
        public String setPrompt(String newPrompt)
        {
            String oldPrompt = this.prompt;
            this.prompt = newPrompt;

            return oldPrompt;
        }

        public int setItem(int newItemKey) {

            int oldItemKey = this.itemKey;
            this.itemKey = newItemKey;

            return oldItemKey;
        }
    }
}